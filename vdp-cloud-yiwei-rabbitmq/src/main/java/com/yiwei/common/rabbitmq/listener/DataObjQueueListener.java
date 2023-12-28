package com.yiwei.common.rabbitmq.listener;

import com.rabbitmq.client.Channel;
import com.yiwei.common.component.data.DataObj;
import com.yiwei.common.component.msgPack.MsgPackage;
import com.yiwei.common.component.msgPack.MsgPacker;
import com.yiwei.common.rabbitmq.service.RabbitmqService;
import org.springframework.amqp.core.Message;

/**
 * @program: vdp-cloud
 * @description:
 * @author: xiazj
 * @create: 2019-06-06 17:41
 **/
public class DataObjQueueListener extends AbstractQueueListener<DataObj>  {

    protected String mqQueueId;
    protected int threadNum;
    protected int queueMaxLength;

    public DataObjQueueListener(String mqQueueId, int threadNum, int queueMaxLength, RabbitmqService rabbitmqService) {
        super(rabbitmqService);
        this.mqQueueId = mqQueueId;
        this.threadNum = threadNum;
        this.queueMaxLength = queueMaxLength;
    }

    public void putdata2(DataObj obj){
        super.putData(obj);
    }

    @Override
    protected String getMqQueueId() {
        return mqQueueId;
    }

    @Override
    protected DataObj parseData(Message message, Channel channel) {
        byte[] data = message.getBody();
        MsgPackage mp = MsgPacker.unpackone(data);
        DataObj dataObj = DataObj.formJSONString(new String(mp.getMsgData()));
        return dataObj;
    }

    @Override
    protected AbstractDataHandleQueue<DataObj> createAndStartDataHandleQueue() {
        DataObjHandleQueue handleQueue = new DataObjHandleQueue(this.getHandlerList());
        handleQueue.start("DataObjHandleQueue", threadNum, queueMaxLength);
        return handleQueue;
    }
}
