package com.yiwei.common.component.bytebuffPool;

import com.yiwei.common.component.timer.TimeScheduler;
import io.netty.buffer.ByteBuf;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.impl.AbandonedConfig;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description 对象池实现的核心类，它实现了对ByteBuf类型的对象池的管理
 * 本类是将gdcp项目中的common.pool替换成了common.pool2对应的方式
 * @Author longxn
 * @Date 11:49 2018/7/3
 **/
@Slf4j
public class ByteBufPool {

    private GenericObjectPool<ByteBuf> pool = null;

    AtomicLong releaseCnt = new AtomicLong(0);
    AtomicLong requestCnt = new AtomicLong(0);
    ByteBufFactory factory = new ByteBufFactory();
    private static ByteBufPool instance = new ByteBufPool();

    private ByteBufPool() {
        GenericObjectPoolConfig cfg = new GenericObjectPoolConfig();

        //	cfg.maxActive = 100000;
        cfg.setMaxTotal(100000);
        cfg.setMaxIdle(100000);
        //	cfg.setBlockWhenExhausted(true);
        // 周期性扫描pool中的对象列表,已检测"对象池中的对象"空闲(idle)的时间是否达到了阀值,如果是,则移除此对象
        cfg.setMinEvictableIdleTimeMillis(30000);

        pool = new GenericObjectPool<ByteBuf>(factory, cfg);

        /**
         * 释放对象时HASHCODE不明原因发生变更，导致无法正确释放对象池的对象，累积造成溢出
         * GenericObjectPool判断一个对象是否泄漏是根据对象最后一次使用或者最后一次borrow的时间进行判断的
         * 如果超出了预设的值就会被认为是一个泄漏的对象被清理掉（PooledObjectFactory.destroyObject在这一过程中会被调用）
         * 抛弃时间可以通过 AbandonedConfig.setRemoveAbandonedTimeout 进行设置，时间单位是秒。
         * */
        AbandonedConfig abandonedConfig = new AbandonedConfig();
        abandonedConfig.setRemoveAbandonedOnBorrow(true);
        abandonedConfig.setRemoveAbandonedOnMaintenance(true);
        //如果一个对象borrow之后65秒还没有返还给pool，认为是泄漏的对象
        abandonedConfig.setRemoveAbandonedTimeout(60*60*8);
        pool.setAbandonedConfig(abandonedConfig);
        //10秒运行一次维护任务
        pool.setTimeBetweenEvictionRunsMillis(10000);

        // 监控程序
        commitScheduleTask();


    }

    public static ByteBufPool getInstance() {
        return instance;
    }

    /**
     * 获取byte对象,没有的自动增加
     *
     * @return
     * @throws Exception
     */
    public ByteBuf borrowObject() {
        requestCnt.addAndGet(1);
        try {

            Object o = pool.borrowObject();
            log.debug("对象池已获取ByteBuf对象id:{}", System.identityHashCode(o));
            if (o != null) {
                ByteBuf buf = (ByteBuf) o;
                return buf;
            }
        } catch (Exception e) {
            log.error("获取对象失败", e);
        }
        return null;
    }

    /**
     * 释放buff对象,返回到对象池中
     *
     * @param byteBuf
     * @return
     */
    public void returnObject(ByteBuf byteBuf) {
        releaseCnt.addAndGet(1);
        // log.logDebug("归还byteBuf");
        try {
            pool.returnObject(byteBuf);
            log.debug("对象池已释放ByteBuf对象id:{}", System.identityHashCode(byteBuf));
        } catch (Exception e) {
            log.error("对象池释放ByteBuf对象id失败:{}", System.identityHashCode(byteBuf));
            log.error("释放对象失败", e);
        }
    }

    public void commitScheduleTask() {
        TimeScheduler.instance().registerScheduledTask(() -> {
            log.info("###############BYTEBUF POOL STAT INFO#################");
            log.info("BYTE BUF POOL > TOTAL BUF CREATE:  {} , TOTAL BUF REQUEST: {}, TOTAL BUF RETURN: {}",
                    factory.createCnt, requestCnt, releaseCnt);
            log.info(
                    "BYTE BUF POOL > POOL ACTIVE: {},POOL IDEL: {}, MAX IDEL {} , MIN EVICTABLEIIDLE {}",
                    pool.getNumActive(), pool.getNumIdle(), pool.getMaxIdle(),
                    pool.getMinEvictableIdleTimeMillis());
        }, 6, 10, TimeUnit.SECONDS);
    }
}
