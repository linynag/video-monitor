package com.yiwei.common.component.bytebuffPool;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.KeyedPooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description 限定容量的ByteBuf的工厂类, 实现对象pool中的对象创建和销毁
 * 方法的注释请参考{@link ByteBufFactory}
 * @Author longxn
 * @Date 12:01 2018/7/3
 **/


@Slf4j
public class FixedByteBufFactory implements
		KeyedPooledObjectFactory<Integer, ByteBuf> {

	AtomicLong createCnt = new AtomicLong(0);

	@Override
	public void activateObject(Integer cap, PooledObject<ByteBuf> buf) {
		buf.getObject().clear();
	}

	@Override
	public void destroyObject(Integer cap, PooledObject<ByteBuf> buf) {
		buf.getObject().clear();
	}

	@Override
	public PooledObject<ByteBuf> makeObject(Integer cap) {
		 log.debug("创建 wrapped byteBuf: {}", cap);
		createCnt.addAndGet(1);
		return new DefaultPooledObject<>(Unpooled.wrappedBuffer(new byte[cap]));
	}

	@Override
	public void passivateObject(Integer cap, PooledObject<ByteBuf> buf) {
		buf.getObject().clear();
	}

	@Override
	public boolean validateObject(Integer cap, PooledObject<ByteBuf> buf) {
		return true;
	}

}
