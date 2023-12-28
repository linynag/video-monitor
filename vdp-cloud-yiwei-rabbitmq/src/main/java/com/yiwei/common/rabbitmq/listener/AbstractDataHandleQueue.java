package com.yiwei.common.rabbitmq.listener;

import com.yiwei.common.component.queue.SequenceQueue;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


@Slf4j
public abstract class AbstractDataHandleQueue<T> extends SequenceQueue<T> {

    protected List<MqDataHandler<T>> handlerList;

    public AbstractDataHandleQueue(List<MqDataHandler<T>> handlerList) {
        this.handlerList = handlerList;
    }

    @Override
    public void svc() {
        while (true) {
            T data = this.getq();
            handleData(data);
        }
    }

    protected void handleData(T data){
        if(handlerList != null) {
            handlerList.forEach(handler -> {
                try {
                    handler.handleData(data);
                } catch (Exception e) {
                    log.error("处理器【{}】处理数据:[{}]时发生异常！{}", handler.getClass().getName(), data.toString(), e);
                }
            });
        }
    }

    protected abstract int getTaskSeq(T data);

    public void putData(T data) throws Exception{
        while (!this.isCanPut()){
            log.info("需要分发的队列容量已超过阀值，等待一秒后再检查是否能分发！");
            Thread.sleep(1000);
        }
        this.putq(getTaskSeq(data), data);
    }

}
