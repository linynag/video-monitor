package com.yiwei.common.rabbitmq.service;

import com.yiwei.common.component.data.DataObj;
import com.yiwei.common.component.msgPack.MsgPackage;
import com.yiwei.common.component.utils.SnMaker;
import com.yiwei.common.rabbitmq.client.ExchangeSenders;
import com.yiwei.common.rabbitmq.client.QueueChannel;
import com.yiwei.common.rabbitmq.client.RabbitmqClient;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 提供了一个通用的抽象层，封装了 RabbitMQ 的常用操作，
 * 根据初始化的MQ路由/队列的代号映射关系进行收发数据
 **/
public abstract class AbstractRabbitmqService implements RabbitmqService {

    protected RabbitmqClient rabbitmqClient;

    protected Map<String, ExchangeSenders> exchangeMap = new HashMap<>();

    protected Map<String, QueueChannel> queueMap = new HashMap<>();

    public AbstractRabbitmqService(RabbitmqClient rabbitmqClient) {
        this.rabbitmqClient = rabbitmqClient;
    }

    /**
     * 根据exchange标识创建对应的exchange，exchange标识规则由实现类定义
     * 实现类可以根据exchange标识规则来进行exchange的创建与创建需要默认绑定队列
     *
     * @param exchangeId
     * @return
     */
    protected abstract ExchangeSenders createExchange(final String exchangeId);

    protected abstract ExchangeSenders onlyExchange(final String exchangeId);

    /**
     * 根据queue标识创建对应的queue对象，queue标识规则由实现类定义
     * 实现类可以根据queue标识规则来进行queue的创建、维护queue与exchange的绑定关系
     *
     * @param queueId
     * @return
     */
    protected abstract QueueChannel createQueue(final String queueId);

    protected abstract QueueChannel createQueue(final String queueId, final String routingKey);

    public abstract void unBindQueue(final String queueId, final String routingKey);

    @Override
    public void send(final String exchagneId, byte[] msg) {
        Assert.notNull(exchagneId, "exchagneId must be not null!");
        Assert.notNull(msg, "msg must be not null!");

        ExchangeSenders exchange = exchangeMap.get(exchagneId);
        if (exchange == null) {
            synchronized (exchangeMap) {
                exchange = exchangeMap.get(exchagneId);
                if (exchange == null) {
                    exchange = createExchange(exchagneId);
                    Assert.notNull(exchange, "exchagneId:[" + exchagneId + "] create exchange faild! please check this exchagneId accuracy!");
                    exchangeMap.put(exchagneId, exchange);
                }
            }
        }
        exchange.sendMsg(msg);
    }

    @Override
    public void send(final String exchagneId, String routingKey, byte[] msg) {
        Assert.notNull(exchagneId, "exchagneId must be not null!");
        Assert.notNull(msg, "msg must be not null!");

        ExchangeSenders exchange = exchangeMap.get(exchagneId);
        if (exchange == null) {
            synchronized (exchangeMap) {
                exchange = exchangeMap.get(exchagneId);
                if (exchange == null) {
                    exchange = createExchange(exchagneId);
                    Assert.notNull(exchange, "exchagneId:[" + exchagneId + "] create exchange faild! please check this exchagneId accuracy!");
                    exchangeMap.put(exchagneId, exchange);
                }
            }
        }
        exchange.sendMsg(routingKey, msg);
    }

    @Override
    public void initExchange(final String exchagneId) {
        ExchangeSenders exchange = exchangeMap.get(exchagneId);
        if (exchange == null) {
            synchronized (exchangeMap) {
                exchange = exchangeMap.get(exchagneId);
                if (exchange == null) {
                    exchange = onlyExchange(exchagneId);
                    Assert.notNull(exchange, "exchagneId:[" + exchagneId + "] create exchange faild! please check this exchagneId accuracy!");
                    exchangeMap.put(exchagneId, exchange);
                }
            }
        }
    }

    @Override
    public void send(String exchagneId, MsgPackage msg) {
        Assert.notNull(exchagneId, "exchagneId must be not null!");
        Assert.notNull(msg, "msg must be not null!");
        this.send(exchagneId, msg.getPackData());
    }

    @Override
    public void send(String exchagneId, DataObj dataObj) {
        Assert.notNull(exchagneId, "exchagneId must be not null!");
        Assert.notNull(dataObj, "dataObj must be not null!");

        MsgPackage msg = new MsgPackage();
        msg.setMsgType(dataObj.getObjtype());
        msg.setMsgData(dataObj.toJSONString());
        msg.setMsgSN(SnMaker.getSN());
        this.send(exchagneId, msg);
    }

    @Override
    public void receive(final String queueId, ChannelAwareMessageListener listener) {
        Assert.notNull(queueId, "queueId must be not null!");
        Assert.notNull(listener, "listener must be not null!");

        QueueChannel queue = queueMap.get(queueId);
        if (queue == null) {
            synchronized (queueMap) {
                queue = queueMap.get(queueId);
                if (queue == null) {
                    queue = createQueue(queueId);
                    Assert.notNull(queue, "queueId:[" + queueId + "] create listener faild! please check this queueId accuracy!");
                    queueMap.put(queueId, queue);
                }
            }
        }
        if (queue.isListening()) {
            throw new RuntimeException("queueId:[" + queueId + "] is start listen!please don't repeated startup!");
        }
        queue.startListening(listener);
    }

    @Override
    public void receive(final String queueId, final String routingKey, ChannelAwareMessageListener listener) {
        Assert.notNull(queueId, "queueId must be not null!");
        Assert.notNull(listener, "listener must be not null!");

        QueueChannel queue = queueMap.get(queueId);
        if (queue == null) {
            synchronized (queueMap) {
                queue = queueMap.get(queueId);
                if (queue == null) {
                    queue = createQueue(queueId, routingKey);
                    Assert.notNull(queue, "queueId:[" + queueId + "] create listener faild! please check this queueId accuracy!");
                    queueMap.put(queueId, queue);
                }
            }
        }
        if (queue.isListening()) {
            throw new RuntimeException("queueId:[" + queueId + "] is start listen!please don't repeated startup!");
        }
        queue.startListening(listener);
    }

    @Override
    public Map<String, ExchangeSenders> getAllExchange() {
        return exchangeMap;
    }

    @Override
    public ExchangeSenders getExchangeById(String exchagneId) {
        return exchangeMap.get(exchagneId);
    }

    @Override
    public Map<String, QueueChannel> getAllQueues() {
        return queueMap;
    }

    @Override
    public QueueChannel getQueueById(String queueId) {
        return queueMap.get(queueId);
    }

}
