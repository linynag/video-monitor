package com.yiwei.common.rabbitmq.client;


import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.util.Assert;

/**
 * exchange对象管理，对象初始化后会向MQ创建对应的exchange
 * 可以在MQ上对exchange进行创建、删除、发送数据、绑定队列操作
 *
 * @program: rabbitmq
 * @description:
 * @author: xiazj
 **/
public class ExchangeSenders extends RabbitmqHandler {

    private Exchange exchangeInfo;

    protected ExchangeSenders(String exchangeName, ExchangeEnum exchangeType, RabbitmqConnector connector) {
        super(connector);
        this.exchangeInfo = newExchangeObj(exchangeType, exchangeName);
        createExchange();
    }

    /**
     * 往exchange发送数据
     *
     * @param message
     */
    public void sendMsg(Object message) {
        this.sendMsg(DEFAULT_ROUTE_KEY, message);
    }

    /**
     * 往exchange发送数据
     *
     * @param routingKey
     * @param message
     */
    public void sendMsg(String routingKey, Object message) {
        Assert.notNull(routingKey, "routingKey must be not null!");
        Assert.notNull(message, "message must be not null!");

        connector.getRabbitTemplate().convertAndSend(this.getExchagneName(), routingKey, message);
    }

    /**
     * 获取exchange名字
     *
     * @return
     */
    public String getExchagneName() {
        return exchangeInfo.getName();
    }

    /**
     * 获取exchange类型
     *
     * @return
     */
    public String getExchagneType() {
        return exchangeInfo.getType();
    }

    /**
     * 获取Spring-rabbitMQ API的exchange对象
     *
     * @return
     */
    public Exchange getExchagne() {
        return exchangeInfo;
    }

    /**
     * 向MQ服务器声明创建exchange
     */
    public void createExchange() {
        connector.getRabbitAdmin().declareExchange(this.exchangeInfo);
    }

    /**
     * 向MQ服务器声明删除exchange
     *
     * @return
     */
    public boolean removeExchange() {
        return connector.getRabbitAdmin().deleteExchange(getExchagneName());
    }

    /**
     * 为当前exchange绑定queue
     *
     * @param queueName
     */
    public void bindingQueue(String queueName) {
        bindingQueue(queueName, DEFAULT_ROUTE_KEY);
    }

    /**
     * 为当前exchange绑定queue
     *
     * @param queueName
     * @param routeKey
     */
    public void bindingQueue(String queueName, String routeKey) {
        Assert.notNull(queueName, "queueName must be not null!");
        Assert.notNull(routeKey, "routeKey must be not null!");

        Queue queue = new Queue(queueName);
        bindingQueue(queue, routeKey);
    }

    /**
     * 为当前exchange绑定queue
     *
     * @param queue
     */
    public void bindingQueue(Queue queue) {
        bindingQueue(queue, DEFAULT_ROUTE_KEY);
    }

    /**
     * 为当前exchange绑定queue
     *
     * @param queue
     * @param routeKey
     */
    public void bindingQueue(Queue queue, String routeKey) {
        Assert.notNull(queue, "listener must be not null!");
        Assert.notNull(routeKey, "routeKey must be not null!");

        connector.getRabbitAdmin().declareQueue(queue);
        this.binding(exchangeInfo, queue, routeKey);
    }

    /**
     * 为当前exchange解除绑定queue
     *
     * @param queueName
     */
    public void unbindingQueue(String queueName) {
        unbindingQueue(queueName, DEFAULT_ROUTE_KEY);
    }

    /**
     * 为当前exchange解除绑定queue
     *
     * @param queueName
     * @param routeKey
     */
    public void unbindingQueue(String queueName, String routeKey) {
        Assert.notNull(queueName, "queueName must be not null!");
        Assert.notNull(routeKey, "routeKey must be not null!");

        Queue queue = new Queue(queueName);
        unbindingQueue(queue, routeKey);
    }

    /**
     * 为当前exchange解除绑定queue
     *
     * @param queue
     */
    public void unbindingQueue(Queue queue) {
        unbindingQueue(queue, DEFAULT_ROUTE_KEY);
    }

    /**
     * 为当前exchange解除绑定queue
     *
     * @param queue
     * @param routeKey
     */
    public void unbindingQueue(Queue queue, String routeKey) {
        Assert.notNull(queue, "listener must be not null!");
        Assert.notNull(routeKey, "routeKey must be not null!");

        this.unbinding(exchangeInfo, queue, routeKey);
    }


}
