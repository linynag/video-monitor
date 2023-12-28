package com.yiwei.common.rabbitmq.service;

import com.yiwei.common.component.data.DataObj;
import com.yiwei.common.component.msgPack.MsgPackage;
import com.yiwei.common.rabbitmq.client.ExchangeSenders;
import com.yiwei.common.rabbitmq.client.QueueChannel;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;

import java.util.Map;


public interface RabbitmqService {


    /**
     * 往某个exchange发送数据
     *
     * @param exchangeId exchange标识（根据不同的实现来通过exchangeId来找到对应的exchange）
     * @param msg        需要发送的数据
     */
    void send(final String exchangeId, byte[] msg);

    /**
     * 往某个exchange发送数据
     *
     * @param exchangeId exchange标识（根据不同的实现来通过exchangeId来找到对应的exchange）
     * @param msg        需要发送的数据
     */
    void send(final String exchangeId, String routingKey, byte[] msg);

    /**
     * 往某个exchange发送数据
     *
     * @param exchangeId exchange标识（根据不同的实现来通过exchangeId来找到对应的exchange）
     * @param msg        需要发送的数据
     */
    void send(final String exchangeId, MsgPackage msg);

    /**
     * 往某个exchange发送数据
     *
     * @param exchangeId exchange标识（根据不同的实现来通过exchangeId来找到对应的exchange）
     * @param dataObj    需要发送的数据
     */
    void send(final String exchangeId, DataObj dataObj);

    /**
     * 监听消费队列的数据
     *
     * @param queueId  queue标识（根据不同的实现来通过exchangeId来找到对应的queue）
     * @param listener 消费队列数据的处理器
     */
    void receive(final String queueId, ChannelAwareMessageListener listener);

    void receive(final String queueId, final String routingKey, ChannelAwareMessageListener listener);

    /**
     * 获取目前全部已创建的exchange
     *
     * @return
     */
    Map<String, ExchangeSenders> getAllExchange();

    /**
     * 根据exchange的名字获取对应的exchange对象
     *
     * @param exchangeId
     * @return
     */
    ExchangeSenders getExchangeById(String exchangeId);

    /**
     * 获取目前全部已创建的队列
     *
     * @return
     */
    Map<String, QueueChannel> getAllQueues();

    /**
     * 根据queue的名字获取对应的queue对象
     *
     * @param queueId
     * @return
     */
    QueueChannel getQueueById(String queueId);

    void initExchange(final String exchangeId);

    void unBindQueue(final String queueId, final String routingKey);

    Integer getQueueMsgCount(final String queueId);
}
