package com.yiwei.common.component.bytebuffPool;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description 不限定容量的ByteBufFac的工厂类, 实现对象pool中的对象创建和销毁
 * @Author longxn
 * @Date 11:45 2018/7/3
 **/
@Slf4j
public class ByteBufFactory implements PooledObjectFactory<ByteBuf> {

    AtomicLong createCnt = new AtomicLong(0);

    /**
     * 功能描述：激活资源对象.
     * 激活一个对象或者说启动对象的某些操作。比如，如果对象是socket，如果socket没有连接，或意外断开了，可以在这里启动socket的连接。
     * 它会在检测空闲对象的时候，如果设置了测试空闲对象是否可以用，就会调用这个方法，在borrowObject的时候也会调用。
     * 另外，如果对象是一个包含参数的对象，可以在这里进行初始化。让使用者感觉这是一个新创建的对象一样。
     * <p>
     * 什么时候会调用此方法
     * 1：从资源池中获取资源的时候
     * 2：资源回收线程，回收资源的时候，如果回收策略返回true，参数 testWhileIdle配置为 true 时，调用此方法
     *
     * @param buf
     */
    @Override
    public void activateObject(PooledObject<ByteBuf> buf) {
        // TODO Auto-generated method stub
        buf.getObject().clear();
    }

    /**
     * 功能描述：判断资源对象是否有效，有效返回 true，无效返回 false.
     * 在对象池中的对象必须是有效的，这个有效的概念是，从对象池中拿出的对象是可用的。
     * 比如，如果是socket,那么必须保证socket是连接可用的。在从对象池获取对象或归还对象到对象池时，会调用这个方法，判断对象是否有效，如果无效就会销毁。
     * <p>
     * 什么时候会调用此方法
     * 1：从资源池中获取资源的时候，参数 testOnBorrow 或者 testOnCreate 中有一个 配置 为 true 时，则调用  factory.validateObject() 方法
     * 2：将资源返还给资源池的时候，参数 testOnReturn，配置为 true 时，调用此方法
     * 3：资源回收线程，回收资源的时候, 如果回收策略返回false，参数 testWhileIdle配置为 true 时，调用此方法
     */
    @Override
    public boolean validateObject(PooledObject<ByteBuf> buf) {
        return true;
    }

    /**
     * 功能描述：钝化资源对象
     * 钝化一个对象。在向对象池归还一个对象是会调用这个方法。这里可以对对象做一些清理操作。比如清理掉过期的数据，下次获得对象时，不受旧数据的影响。
     * 一般来说activateObject和passivateObject是成对出现的。前者是在对象从对象池取出时做一些操作，后者是在对象归还到对象池做一些操作，可以根据自己的业务需要进行取舍。
     * 什么时候会调用此方法
     * 1：资源回收线程，回收资源的时候, 如果回收策略返回false, 参数 testWhileIdle配置为 true 时，调用此方法
     */
    @Override
    public void passivateObject(PooledObject<ByteBuf> buf) {
        //设置读写索引为0
        buf.getObject().clear();
    }

    /**
     * 销毁对象，当对象池检测到某个对象的空闲时间(idle)超时，或使用完对象归还到对象池之前被检测到对象已经无效时，就会调用这个方法销毁对象。
     * 对象的销毁一般和业务相关，但必须明确的是，当调用这个方法之后，对象的生命周期必须结果。
     * 如果是对象是线程，线程必须已结束，如果是socket，socket必须已close，如果是文件操作，文件数据必须已flush，且文件正常关闭。
     * 什么时候会调用此方法:
     * 1: 根据回收策略判断，资源是否需要回收。如果回收策略返回true, 则将资源从池中删除，并调用factory.destroyObject()方法。
     **/
    @Override
    public void destroyObject(PooledObject<ByteBuf> buf) {
        // TODO Auto-generated method stub
        buf.getObject().clear();
    }

    /**
     * 创建一个对象，当在GenericObjectPool类中调用borrowObject方法时，如果当前对象池中没有空闲的对象，
     * GenericObjectPool会调用这个方法，创建一个对象，并把这个对象封装到PooledObject类中，并交给对象池管理。
     **/
    @Override
    public PooledObject<ByteBuf> makeObject() {
        log.debug("创建byteBuf: {}", 1024 * 10);
        createCnt.addAndGet(1);
        return new DefaultPooledObject<>(Unpooled.buffer(1024 * 10));
    }

}
