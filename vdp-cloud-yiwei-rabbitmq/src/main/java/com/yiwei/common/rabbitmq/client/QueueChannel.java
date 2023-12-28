package com.yiwei.common.rabbitmq.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;

import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.util.Assert;

/**
 * 队列通道对象，对象初始化后会向MQ创建对应的queue
 * 可在MQ上对对应的queue进行创建、删除、绑定exchange、解除exchange绑定、进行监听、解除监听操作
 * @program: vdp-cloud
 * @author: xiazj
 **/
@Slf4j
public class QueueChannel extends RabbitmqHandler{

    private Queue queue;
    private volatile SimpleMessageListenerContainer listenerContainer;
    private volatile boolean isListenerRunning = false;

    protected QueueChannel(String queueName, RabbitmqConnector connector) {
        super(connector);
        queue = new Queue(queueName);
        createQueue();
    }

    /**
     * 获取queue名称
     * @return
     */
    public String getQueueName(){
        return queue.getName();
    }

    /**
     * 获取Spring-rabbitMQ API的queue对象
     * @return
     */
    public Queue getQueue(){
        return queue;
    }

    /**
     * 向MQ服务器声明创建queue
     */
    public void createQueue(){
        connector.getRabbitAdmin().declareQueue(queue);
    }

    /**
     * 向MQ服务器声明删除queue
     */
    public void deleteQueue(){
        if(!isListenerRunning)
            connector.getRabbitAdmin().deleteQueue(getQueueName());
        else
            log.error("listener listener is running!please stop listening and try again!");
    }


    /**
     * 为当前queue绑定exchange
     * @param exchangeName
     * @param exchangeType
     */
    public void bindingExchange(String exchangeName, ExchangeEnum exchangeType){
        bindingExchange(exchangeName, exchangeType, DEFAULT_ROUTE_KEY);
    }

    /**
     * 为当前queue绑定exchange
     * @param exchangeName
     * @param exchangeType
     * @param routingKey
     */
    public void bindingExchange(String exchangeName, ExchangeEnum exchangeType, String routingKey){
        Assert.notNull(exchangeName, "exchangeName must be not null!");
        Assert.notNull(exchangeType, "exchangeType must be not null!");
        Assert.notNull(routingKey, "routingKey must be not null!");

        Exchange exchange = this.newExchangeObj(exchangeType, exchangeName);
        bindingExchange(exchange, routingKey);
    }

    /**
     * 为当前queue绑定exchange
     * @param exchange
     */
    public void bindingExchange(Exchange exchange){
        bindingExchange(exchange, DEFAULT_ROUTE_KEY);
    }

    /**
     * 为当前queue绑定exchange
     * @param exchange
     * @param routingKey
     */
    public void bindingExchange(Exchange exchange, String routingKey){
        Assert.notNull(exchange, "exchange must be not null!");
        Assert.notNull(routingKey, "routingKey must be not null!");

        this.binding(exchange, queue, routingKey);
    }

    /**
     * 为当前queue解除绑定exchange
     * @param exchangeName
     * @param exchangeType
     */
    public void unbindExchange(String exchangeName, ExchangeEnum exchangeType){
        unbindExchange(exchangeName, exchangeType, DEFAULT_ROUTE_KEY);
    }

    /**
     * 为当前queue解除绑定exchange
     * @param exchangeName
     * @param exchangeType
     * @param routingKey
     */
    public void unbindExchange(String exchangeName, ExchangeEnum exchangeType, String routingKey){
        Assert.notNull(exchangeName, "exchangeName must be not null!");
        Assert.notNull(exchangeType, "exchangeType must be not null!");
        Assert.notNull(routingKey, "routingKey must be not null!");

        Exchange exchange = this.newExchangeObj(exchangeType, exchangeName);
        unbindExchange(exchange, routingKey);
    }

    /**
     * 为当前queue解除绑定exchange
     * @param exchange
     */
    public void unbindExchange(Exchange exchange){
        unbindExchange(exchange, DEFAULT_ROUTE_KEY);
    }

    /**
     * 为当前queue解除绑定exchange
     * @param exchange
     * @param routingKey
     */
    public void unbindExchange(Exchange exchange, String routingKey){
        Assert.notNull(exchange, "exchange must be not null!");
        Assert.notNull(routingKey, "routingKey must be not null!");

        this.unbinding(exchange, queue, routingKey);
    }

    /**
     * 监听消费当前queue的消息
     * @param listener
     */
    public void startListening(ChannelAwareMessageListener listener){
        startListening(AcknowledgeMode.AUTO, listener);
    }

    /**
     * 监听消费当前queue的消息
     * @param acknowledgeMode
     * @param listener
     */
    public void startListening(AcknowledgeMode acknowledgeMode, ChannelAwareMessageListener listener){
        Assert.notNull(acknowledgeMode, "acknowledgeMode must be not null!");
        Assert.notNull(listener, "listener must be not null!");

        if(!isListenerRunning){
            synchronized(this){
                if(!isListenerRunning){
                    listenerContainer = createListenerContainer(acknowledgeMode, listener);
                    listenerContainer.start();
                    isListenerRunning = listenerContainer.isRunning();
                }
            }
        }else{
            log.error("listener:[{}] is start running,please do not again! If you want to restart listening,please stop listening and try again!", queue.getName());
        }
    }

    /**
     * 停止监听消费当前queue的消息
     */
    public void stopListening(){
        if(isListenerRunning){
            synchronized(this){
                listenerContainer.destroy();
                isListenerRunning = listenerContainer.isRunning();
            }
        }
    }

    /**
     * 获取当前queue对象是否监听消费队列数据
     * @return
     */
    public boolean isListening(){
        return isListenerRunning;
    }

    private SimpleMessageListenerContainer createListenerContainer(AcknowledgeMode acknowledgeMode, ChannelAwareMessageListener listener) {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer(connector.getConnectionFactory());
        simpleMessageListenerContainer.addQueues(queue);//添加队列到容器中
        simpleMessageListenerContainer.setExposeListenerChannel(true);
        simpleMessageListenerContainer.setMaxConcurrentConsumers(1);//最大并发消费者数量
        simpleMessageListenerContainer.setConcurrentConsumers(1);//指定并发消费者的数量
        simpleMessageListenerContainer.setAcknowledgeMode(acknowledgeMode);
        simpleMessageListenerContainer.setMessageListener(listener);
        return simpleMessageListenerContainer;
    }

}
