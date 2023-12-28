package com.yiwei.common.rabbitmq.client;

import org.springframework.amqp.core.*;
import org.springframework.util.Assert;

/**
 * 交换机和队列的绑定关系处理类
 **/
public class RabbitmqHandler {

    protected static final String DEFAULT_ROUTE_KEY = "default";

    protected RabbitmqConnector connector;

    public RabbitmqHandler(RabbitmqConnector connector) {
        this.connector = connector;
    }

    public RabbitmqConnector getConnector() {
        return connector;
    }

    /**
     * 绑定exchange与queue之间的关联关系
     *
     * @param exchange
     * @param queue
     */
    protected void binding(Exchange exchange, Queue queue) {
        binding(exchange, queue, DEFAULT_ROUTE_KEY);
    }

    /**
     * 绑定exchange与queue之间的关联关系
     *
     * @param exchange 交换机信息
     * @param queue    队列信息
     * @param routeKey 路由key
     */
    protected void binding(Exchange exchange, Queue queue, String routeKey) {
        Assert.notNull(exchange, "exchange must be not null!");
        Assert.notNull(queue, "listener must be not null!");
        Assert.notNull(routeKey, "routeKey must be not null!");

        Binding binding = newBindingObj(exchange, queue, routeKey);
        connector.getRabbitAdmin().declareBinding(binding);
    }

    /**
     * 解除绑定exchange与queue之间的关联关系
     *
     * @param exchange
     * @param queue
     */
    protected void unbinding(Exchange exchange, Queue queue) {
        unbinding(exchange, queue, DEFAULT_ROUTE_KEY);
    }

    /**
     * 解除绑定exchange与queue之间的关联关系
     *
     * @param exchange
     * @param queue
     * @param routeKey
     */
    protected void unbinding(Exchange exchange, Queue queue, String routeKey) {
        Assert.notNull(exchange, "exchange must be not null!");
        Assert.notNull(queue, "listener must be not null!");
        Assert.notNull(routeKey, "routeKey must be not null!");

        Binding binding = newBindingObj(exchange, queue, routeKey);
        connector.getRabbitAdmin().removeBinding(binding);
    }

    /**
     * 创建一个绑定对象，但不会向MQ服务器声明关系
     *
     * @param exchange   交换机信息
     * @param queue      队列信息
     * @param routingKey 路由key
     * @return
     */
    private Binding newBindingObj(Exchange exchange, Queue queue, String routingKey) {
        Binding binding = null;
        switch (exchange.getType()) {
            case ExchangeTypes.DIRECT:
                DirectExchange direct = (DirectExchange) exchange;
                binding = BindingBuilder.bind(queue).to(direct).with(routingKey);
                break;
            case ExchangeTypes.TOPIC:
                TopicExchange topic = (TopicExchange) exchange;
                binding = BindingBuilder.bind(queue).to(topic).with(routingKey);
                break;
            case ExchangeTypes.FANOUT:
                FanoutExchange fanout = (FanoutExchange) exchange;
                binding = BindingBuilder.bind(queue).to(fanout);
                break;
            default:
                throw new NullPointerException("exchange type [" + exchange.getType() + "] can not handler!");
        }
        return binding;
    }

    /**
     * 创建一个exchange对象，但不会向MQ服务器声明
     *
     * @param exchangeType 交换机类型
     * @param exchangeName 交换机名称
     * @return
     */
    protected Exchange newExchangeObj(ExchangeEnum exchangeType, String exchangeName) {
        Exchange exchange = null;
        switch (exchangeType) {
            case FANOUT:
                exchange = new FanoutExchange(exchangeName);
                break;
            case DIRECT:
                exchange = new DirectExchange(exchangeName);
                break;
            case TOPIC:
                exchange = new TopicExchange(exchangeName);
                break;
        }
        return exchange;
    }

}
