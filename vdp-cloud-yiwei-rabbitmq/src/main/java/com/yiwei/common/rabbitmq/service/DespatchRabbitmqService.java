package com.yiwei.common.rabbitmq.service;

import com.yiwei.common.component.msgPack.MsgPackage;
import com.yiwei.common.rabbitmq.client.ExchangeSenders;
import com.yiwei.common.rabbitmq.client.QueueChannel;
import com.yiwei.common.rabbitmq.client.RabbitmqClient;

import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据初始化的MQ路由/队列的代号映射关系进行收发数据
 **/
public class DespatchRabbitmqService extends PeriodSeparatedIdRabbitmqService{

    /**
     *路由/队列的代号映射关系
     * 例如：key: dataUpdateQ, value: scdata.topic.realTimeDataUpdate
     */
    private Map<String, String> codeNameMap;

    public DespatchRabbitmqService(Map<String, String> codeNameMap, RabbitmqClient rabbitmqClient) {
        super(rabbitmqClient);
        this.codeNameMap = codeNameMap;
    }

    /**
     * 根据初始化时传入的代号map来找到对应的exchange并发送数据
     * @param codeName exchange代号（exchangeId对应的映射名称）
     * @param msg 要发送的数据
     */
    @Override
    public void send(String codeName, byte[] msg) {
        String exchagneId = codeNameMap.get(codeName);
        Assert.notNull(exchagneId, String.format("codeName:[%s]无法找到对应映射的exchangeId！", codeName));
        super.send(exchagneId, msg);
    }
    @Override
    public void send(String codeName,String routingkey, byte[] msg) {
        String exchagneId = codeNameMap.get(codeName);
        Assert.notNull(exchagneId, String.format("codeName:[%s]无法找到对应映射的exchangeId！", codeName));
        super.send(exchagneId,routingkey, msg);
    }

    /**
     * 根据初始化时传入的代号map来找到对应的exchange并发送数据
     * @param msg 要发送的数据
     */
    @Override
    public void send(String codeName, MsgPackage msg) {
        String exchagneId = codeNameMap.get(codeName);
        Assert.notNull(exchagneId, String.format("codeName:[%s]无法找到对应映射的exchangeId！", codeName));
        super.send(exchagneId, msg);
    }

    /**
     *根据初始化时传入的代号map来找到对应的queue并进行监听
     * @param codeName queue代号（queueId对应的映射名称）
     * @param listener
     */
    @Override
    public void receive(String codeName, ChannelAwareMessageListener listener) {
        String queueId = codeNameMap.get(codeName);
        Assert.notNull(queueId, String.format("codeName:[%s]无法找到对应映射的queueId！", codeName));
        super.receive(queueId, listener);
    }

    @Override
    public void receive(String codeName,String routingkey, ChannelAwareMessageListener listener) {
        String queueId = codeNameMap.get(codeName);
        Assert.notNull(queueId, String.format("codeName:[%s]无法找到对应映射的queueId！", codeName));
        super.receive(queueId,routingkey, listener);
    }

    @Override
    public Map<String, ExchangeSenders> getAllExchange() {
        Map<String, ExchangeSenders> exchangeSendersMap = new HashMap<>();
        for (String key : codeNameMap.keySet()) {
            ExchangeSenders exchange = getExchangeById(key);
            if(exchange != null)exchangeSendersMap.put(key, exchange);
        }
        return exchangeSendersMap;
    }

    @Override
    public ExchangeSenders getExchangeById(String codeName) {
        String exchagneId = codeNameMap.get(codeName);
        Assert.notNull(exchagneId, String.format("codeName:[%s]无法找到对应映射的exchangeId！", codeName));
        return super.getExchangeById(exchagneId);
    }

    @Override
    public Map<String, QueueChannel> getAllQueues() {
        Map<String, QueueChannel> queueChannelMap = new HashMap<>();
        for (String key : codeNameMap.keySet()) {
            QueueChannel queue = getQueueById(key);
            if(queue != null)queueChannelMap.put(key, queue);
        }
        return super.getAllQueues();
    }

    @Override
    public QueueChannel getQueueById(String codeName) {
        String queueId = codeNameMap.get(codeName);
        Assert.notNull(queueId, String.format("codeName:[%s]无法找到对应映射的queueId！", codeName));
        return super.getQueueById(queueId);
    }
}
