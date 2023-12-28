package com.yiwei.common.rabbitmq.listener;

public interface MqDataHandler<T> {

    void handleData(T data);

}
