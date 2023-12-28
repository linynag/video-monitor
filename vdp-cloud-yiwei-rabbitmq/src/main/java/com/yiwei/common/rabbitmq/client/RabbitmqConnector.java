package com.yiwei.common.rabbitmq.client;

import com.yiwei.common.rabbitmq.config.RabbitmqProps;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.util.Assert;

/**
 * rabbitmq连接工具类
 **/
public class RabbitmqConnector {

    private RabbitmqProps rabbitmqProps;

    private ConnectionFactory connectionFactory;
    private RabbitAdmin rabbitAdmin;
    private RabbitTemplate rabbitTemplate;

    public RabbitmqConnector(RabbitmqProps rabbitmqProps) {
        this.rabbitmqProps = rabbitmqProps;
        init();
    }
    public void setRabbitmqProps(RabbitmqProps rabbitmqProps){
        this.rabbitmqProps = rabbitmqProps;
        init();
    }

    public ConnectionFactory getConnectionFactory() {
        return connectionFactory;
    }

    public RabbitAdmin getRabbitAdmin() {
        return rabbitAdmin;
    }

    public RabbitTemplate getRabbitTemplate() {
        return rabbitTemplate;
    }

    public void init(){
        Assert.notNull(rabbitmqProps.getHost(), "host must be not null!");
        Assert.notNull(rabbitmqProps.getUsername(), "username must be not null!");
        Assert.notNull(rabbitmqProps.getPassword(), "password must be not null!");
        Assert.notNull(rabbitmqProps.getPort(), "port must be not null!");
        Assert.notNull(rabbitmqProps.getVirtualHost(), "port must be not null!");

        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setAddresses(rabbitmqProps.getHost() + ":" + rabbitmqProps.getPort());
        factory.setUsername(rabbitmqProps.getUsername());
        factory.setPassword(rabbitmqProps.getPassword());
        factory.setVirtualHost(rabbitmqProps.getVirtualHost());
        /** 如果要进行消息回调，则这里必须设置为true */
       // factory.setPublisherConfirms(rabbitmqProps.isPublisherConfirms());

        connectionFactory = factory;
        // 该对象用于对RabbitMQ执行管理操作，例如声明队列和交换器。
        rabbitAdmin = new RabbitAdmin(factory);
        // 该对象用于向RabbitMQ发送和接收消息。
        rabbitTemplate = new RabbitTemplate(factory);
        /**若使用confirm-callback或return-callback，必须要配置publisherConfirms或publisherReturns为true
         * 每个rabbitTemplate只能有一个confirm-callback和return-callback*/
       // rabbitTemplate.setConfirmCallback(new MsgSendConfirmCallBack());
        /**
         * 使用return-callback时必须设置mandatory为true，或者在配置中设置mandatory-expression的值为true，可针对每次请求的消息去确定’mandatory’的boolean值，
         * 只能在提供’return -callback’时使用，与mandatory互斥*/
        rabbitTemplate.setReturnCallback(new MsgSendReturnCallback());
        // 这指定消息必须路由到至少一个队列，否则将返回给发送者。
        rabbitTemplate.setMandatory(true);
    }

}
