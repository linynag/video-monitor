package com.yiwei.common.rabbitmq.client;

/**
 * rabbitmq客户端，提供对mq收和发的api
 **/
public class RabbitmqClient {

    private RabbitmqConnector connector;

    public RabbitmqClient(RabbitmqConnector connector) {
        this.connector = connector;
    }

    public RabbitmqConnector getConnector() {
        return connector;
    }

    /**
     * 创建一个exchange对象，对象初始化时会自动向MQ服务器声明创建exchange
     * exchange对象可进行创建、删除、发送数据、绑定队列操作
     * @param exchangeName
     * @param exchangeType
     * @return
     */
    public ExchangeSenders createExchange(String exchangeName ,ExchangeEnum exchangeType){
        return new ExchangeSenders(exchangeName, exchangeType, connector);
    }

    /**
     * 创建一个队列通道对象，对象初始化时会自动向MQ服务器声明创建queue
     * queue对象可进行创建、删除、绑定exchange、解除exchange绑定、进行监听、解除监听操作
     * @param queueName
     * @return
     */
    public QueueChannel createQueueChannel(String queueName){
        return new QueueChannel(queueName, connector);
    }

}
