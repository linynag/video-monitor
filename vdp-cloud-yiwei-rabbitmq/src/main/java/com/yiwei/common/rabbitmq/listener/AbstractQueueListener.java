package com.yiwei.common.rabbitmq.listener;

import com.rabbitmq.client.Channel;
import com.yiwei.common.component.exitHandle.AppExitListener;
import com.yiwei.common.component.queue.status.QueueStatus;
import com.yiwei.common.component.timer.TimeScheduler;
import com.yiwei.common.rabbitmq.client.QueueChannel;
import com.yiwei.common.rabbitmq.service.RabbitmqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 抽象的MQ监听队列，已实现AppExitListener保证内存队列的数据在程序退出前处理完全部数据才会退出
 *
 **/
@Slf4j
public abstract class AbstractQueueListener<T> implements AppExitListener {

    protected volatile static boolean isStart = false;
    private RabbitmqService rabbitmqService;
    private List<MqDataHandler<T>> handlerList = new ArrayList<>();
    private AbstractDataHandleQueue<T> handleQueue;

    public AbstractQueueListener(RabbitmqService rabbitmqService) {
        this.rabbitmqService = rabbitmqService;
    }

    protected List<MqDataHandler<T>> getHandlerList() {
        return handlerList;
    }

    protected abstract String getMqQueueId();

    protected abstract T parseData(Message message, Channel channel);

    protected void putData(T data) {
        try {
            handleQueue.putData(data);
        } catch (Exception ex) {
            log.error("handleQueue外部putData出错:{}",ex);
        }
    }

    public AbstractQueueListener addMqDataHandler(MqDataHandler<T> handler) {
        if (!isStart) {
            if (handler != null)
                handlerList.add(handler);
        } else {
            log.error("QueueListener 已经初始化完成，无法再继续添加处理器！");
        }
        return this;
    }

    public AbstractQueueListener addMqDataHandlerList(List<MqDataHandler<T>> handlerList) {
        if (!isStart) {
            if (handlerList != null && !handlerList.isEmpty())
                handlerList.addAll(handlerList);
        } else {
            log.error("QueueListener 已经初始化完成，无法再继续添加处理器！");
        }
        return this;
    }

    protected abstract AbstractDataHandleQueue<T> createAndStartDataHandleQueue();

    public void start() {
        //创建数据处理的队列,返回的队列必须要start后才返回
        handleQueue = createAndStartDataHandleQueue();
        //启动定时器，定时输出队列容量信息
        commitScheduleTask();
        //监听MQ队列
        listeningQueue();
        isStart = true;
    }

    private void commitScheduleTask() {
        TimeScheduler.instance().registerScheduledTask(() -> {
            handleQueue.infoQueue();
        }, 5, 5, TimeUnit.SECONDS);
    }


    private void listeningQueue() {
        String queueName = getMqQueueId();
        Assert.hasText(queueName, "method:[getMqQueueId] return value must be not null and not empty!!");
        try {
            rabbitmqService.receive(queueName, (message, channel) -> {
                try {
                    T data = parseData(message, channel);
                    handleQueue.putData(data);
                } catch (Exception e) {
                    log.error("解析MQ数据出错！", e);
                }
            });
        } catch (Exception e) {
            log.error("监听mq失败！队列名称：【{}】", queueName, e);
        }
    }

    @Override
    public void doExitPreparations() {
        //断开MQ监听的通道，不再接收MQ的数据
        String queueId = getMqQueueId();
        QueueChannel queue = rabbitmqService.getQueueById(queueId);
        queue.stopListening();
        log.info("mq queue [{}] is stop listen!", queueId);
    }

    @Override
    public boolean isFinish() {
        boolean isFinish = true;
        List<QueueStatus> queueStatus = handleQueue.getQueueStatus();
        for (QueueStatus status : queueStatus) {
            if (status.getQueuelength() > 0) {
                isFinish = false;
                handleQueue.infoQueue();
                break;
            }
        }
        return isFinish;
    }
}
