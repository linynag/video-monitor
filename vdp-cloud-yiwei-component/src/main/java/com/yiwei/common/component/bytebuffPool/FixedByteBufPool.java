package com.yiwei.common.component.bytebuffPool;

import com.yiwei.common.component.timer.TimeScheduler;
import io.netty.buffer.ByteBuf;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.impl.AbandonedConfig;
import org.apache.commons.pool2.impl.GenericKeyedObjectPool;
import org.apache.commons.pool2.impl.GenericKeyedObjectPoolConfig;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description 每个方法带一个key参数。你可以把这个GenericKeyedObjectPool的对象池看作是一个map的GenericObjectPool，
 *              每个key对应一个GenericObjectPool。它用于区别不同类型的对象。比如数据库连接，有可能会连接到不同地址的数据库上面。就可以用这个区分。
 *              本类是将gdcp项目中的common.pool替换成了common.pool2对应的方式
 * @Author longxn
 * @Date 11:50 2018/7/3
 **/
@Slf4j
public class FixedByteBufPool {

    private GenericKeyedObjectPool<Integer, ByteBuf> pool = null;

    private static FixedByteBufPool instance = new FixedByteBufPool();

    AtomicLong releaseCnt = new AtomicLong(0);
    AtomicLong requestCnt = new AtomicLong(0);
    FixedByteBufFactory factory = new FixedByteBufFactory();


    private FixedByteBufPool() {
    /*  1.      参数maxActive指明能从池中借出的对象的最大数目。如果这个值不是正数，表示没有限制。
        2.      参数whenExhaustedA ction指定在池中借出对象的数目已达极限的情况下，调用它的borrowObject方法时的行为。可以选用的值有：
                    GenericObjectPool.WHEN_EXHAUSTED_BLOCK，表示等待；
                    GenericObjectPool.WHEN_EXHAUSTED_GROW，表示创建新的实例（不过这就使maxActive参数失去了意义）；
                    GenericObjectPool.WHEN_EXHAUSTED_FAIL，表示抛出一个java.util.NoSuchElementException异常。
        3.      参数maxWait指明若在对象池空时调用borrowObject方法的行为被设定成等待，最多等待多少毫秒。如果等待时间超过了这个数值，则会抛出一个java.util.NoSuchElementException异常。如果这个值不是正数，表示无限期等待。
        4.      参数testOnBorrow设定在借出对象时是否进行有效性检查。
        5.      参数testOnBorrow设定在还回对象时是否进行有效性检查。
        6.      参数timeBetweenEvictionRunsMillis，设定间隔每过多少毫秒进行一次后台对象清理的行动。如果这个值不是正数，则实际上不会进行后台对象清理。
        7.      参数minEvictableIdleTimeMillis，设定在进行后台对象清理时，视休眠时间超过了多少毫秒的对象为过期。过期的对象将被回收。如果这个值不是正数，那么对休眠时间没有特别的约束。
        8.      参数testWhileIdle，则设定在进行后台对象清理时，是否还对没有过期的池内对象进行有效性检查。不能通过有效性检查的对象也将被回收。
        9.      参数lifo，池对象的放入和取出默认是后进先出的原则，默认是true，代表后进先出，设置为false代表先进先出。
    */
        GenericKeyedObjectPoolConfig cfg = new GenericKeyedObjectPoolConfig();
        // TODO 将具体配置设置到配置文件
        cfg.setMaxTotal(10000);
      //  cfg.setMaxIdle(100000);
    //    cfg.setMaxTotal(100);//maxTotal 允许创建资源的最大数量，默认值 8，-1 代表无数量限制（int类型）
        cfg.setMaxWaitMillis(30000);//maxWaitMillis 获取资源时的等待时间，单位毫秒。当 blockWhenExhausted 配置为 true 时，此值有效。 -1 代表无时间限制，一直阻塞直到有可用的资源。（long类型）
        cfg.setBlockWhenExhausted(true);
        //testOnBorrow 默认值 false ，当设置为true时，每次从池中获取资源时都会调用 factory.validateObject() 方法
        //testOnCreate 默认值 false，当设置为true时，只有当创建资源时才会调用 factory.validateObject() 方法
        cfg.setTestOnBorrow(true);
        cfg.setTimeBetweenEvictionRunsMillis(60000);
      //  cfg.setMinEvictableIdleTimeMillis();
        //资源最小空闲时间， 默认值 1800000，单位 毫秒，（long类型 ）,超过改时间会触发回收
        cfg.setMinEvictableIdleTimeMillis(3000);
        //软资源最小空闲时间， 默认值 1800000，单位 毫秒，（long类型 ）,超过改时间会触发回收
        cfg.setSoftMinEvictableIdleTimeMillis(3000);

        //minIdle 最小空闲资源数，默认值 0 （int类型 ，当使用pool2编写自己的资源池时，结合spring的IOC，当项目启动时，会自动创建minIdle个资源。
        //当前的Idle数小于最小的Idle数也会触发回收
        cfg.setMinIdlePerKey(20);
        cfg.setMaxIdlePerKey(100);//最大空闲资源数，默认值 8 （int类型）

        pool = new GenericKeyedObjectPool<Integer, ByteBuf>(factory, cfg);

        //监控pool的状态
        commitScheduleTask();
    }

    public static FixedByteBufPool getInstance() {
        return instance;
    }

    /**
     * 从对象池中获取byte对象,没有的自动增加
     *
     * @param key
     * @return
     * @throws Exception
     */
    public ByteBuf borrowObject(int key) {
        try {

            ByteBuf o = pool.borrowObject(fixCap(key));
            requestCnt.addAndGet(1);
            if (o != null) {
                return o;
            }
        } catch (Exception e) {
            log.error("获取对象失败 {}", e);
        }
        return null;
    }

    /**
     * 对象使用完之后，释放buff对象, 归还到对象池
     *
     * @param key
     * @param obj
     * @return
     */
    public void returnObject(int key, ByteBuf obj) {

        // log.logDebug("归还byteBuf: {}", key);
        try {
            pool.returnObject(fixCap(key), obj);
            releaseCnt.addAndGet(1);
        } catch (Exception e) {
            log.error("释放对象失败", e);
        }
    }

    public int fixCap(int cap) {
        if (cap <= 64) {
            return 64;
        }
        if (cap <= 128) {
            return 128;
        }
        if (cap <= 256) {
            return 256;
        }
        if (cap <= 512) {
            return 512;
        }
        if (cap <= 1024) {
            return 1024;
        }
        if (cap <= 2 * 1024) {
            return 2 * 1024;
        }
        if (cap <= 4 * 1024) {
            return 4 * 1024;
        }

        if (cap <= 8 * 1024) {
            return 8 * 1024;
        }
        if (cap <= 16 * 1024) {
            return 16 * 1024;
        }
        if (cap <= 32 * 1024) {
            return 32 * 1024;
        }
        if (cap <= 64 * 1024) {
            return 64 * 1024;
        }
        if (cap <= 128 * 1024) {
            return 128 * 1024;
        }
        if (cap <= 256 * 1024) {
            return 256 * 1024;
        }

        return 512 * 1024;

    }

    public void commitScheduleTask() {
        TimeScheduler.instance().registerScheduledTask(new Runnable() {

            @Override
            public void run() {
                log.info("###############BYTEBUF POOL STAT INFO#################");
                log.info(
                        "FIX BYTEBUF POOL > TOTAL BUF CREATE:  {} , TOTAL BUF REQUEST: {}, TOTAL BUF RETURN: {}",
                        factory.createCnt, requestCnt, releaseCnt);
                log.info(
                        "FIXED BYTEBUF POOL > POOL ACTIVE: {},POOL IDEL: {}, NumActivePerKey {} ,MaxIdlePerKey {} , MIN EVICTABLEIIDLE {}",
                        pool.getNumActive(), pool.getNumIdle(),
                        pool.getNumActivePerKey(), pool.getMaxIdlePerKey(),
                        pool.getMinEvictableIdleTimeMillis());
                // log.logDebug("POOL ACTIVE BUF 128: {},POOL IDEL BUF 128: {}",
                // pool.getNumActive(128), pool.getNumIdle(128));
            }

        }, 60, 30, TimeUnit.SECONDS);
    }
}
