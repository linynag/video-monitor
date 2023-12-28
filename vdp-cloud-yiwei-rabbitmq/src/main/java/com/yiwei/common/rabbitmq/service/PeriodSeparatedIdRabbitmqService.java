package com.yiwei.common.rabbitmq.service;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.yiwei.common.rabbitmq.client.ExchangeEnum;
import com.yiwei.common.rabbitmq.client.ExchangeSenders;
import com.yiwei.common.rabbitmq.client.QueueChannel;
import com.yiwei.common.rabbitmq.client.RabbitmqClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.ChannelCallback;

/**
 * 用句号分隔的ID标识的RabbitmqService
 **/
@Slf4j
public class PeriodSeparatedIdRabbitmqService extends AbstractRabbitmqService {

    private static final String ID_SEPARATOR = "\\.";

    public PeriodSeparatedIdRabbitmqService(RabbitmqClient rabbitmqClient) {
        super(rabbitmqClient);
    }

    /**
     * 用句号分隔的ID标识的RabbitmqService
     * 格式为："exchange名称.exchange类型.消费数据的功能简述", 整个字符串为queue的名称
     * 例子： raw_relay.fanout.rawDataValidate
     * <p>
     * exchagneId示例：
     * 1、只创建exchange
     * exchagneId = "raw_relay.fanout" 则会在MQ上创建一个名为"raw_relay"类型为"fanout"的exchange;
     * 2、创建exchange后为其绑定队列（防止没有任何消费者时丢失数据）
     * exchagneId = "raw_relay.fanout.rawDataValidate" ，则会在MQ上创建一个名为"raw_relay"类型为"fanout"的exchange,
     * 并创建一个名为"raw_relay.fanout.rawDataValidate"的queue绑定到"raw_relay"的exchange;
     *
     * @param exchagneId
     * @return
     */
    @Override
    protected ExchangeSenders createExchange(final String exchagneId) {
        ExchangeSenders exchangeSenders = null;
        IdentificationProps idProps = new IdentificationProps(exchagneId);
        String exchangeName = idProps.getExchangeName();
        ExchangeEnum exchangeType = idProps.getExchangeType();
        if (exchangeName != null && exchangeType != null) {
            exchangeSenders = rabbitmqClient.createExchange(exchangeName, exchangeType);
            if (idProps.getConsumerDescription() != null) {
                exchangeSenders.bindingQueue(idProps.getQueueName());
            }
        }
        return exchangeSenders;
    }

    @Override
    protected ExchangeSenders onlyExchange(final String exchagneId) {
        ExchangeSenders exchangeSenders = null;
        IdentificationProps idProps = new IdentificationProps(exchagneId);
        String exchangeName = idProps.getExchangeName();
        ExchangeEnum exchangeType = idProps.getExchangeType();
        if (exchangeName != null && exchangeType != null) {
            exchangeSenders = rabbitmqClient.createExchange(exchangeName, exchangeType);
        }
        return exchangeSenders;
    }

    /**
     * 用句号分隔的ID标识的RabbitmqService
     * 格式为："exchange名称.exchange类型.消费数据的功能简述", 整个字符串为queue的名称
     * 例子： raw_relay.fanout.rawDataValidate
     * <p>
     * queueId示例：
     * 1、queueId = "raw_relay.fanout.rawDataValidate" ，则会在MQ上创建一个名为"raw_relay.fanout.rawDataValidate"的queue，
     * 并将该queue绑定到名为"raw_relay"的exchange
     *
     * @param queueId
     * @return
     */
    @Override
    protected QueueChannel createQueue(final String queueId) {
        QueueChannel queueChannel = null;
        IdentificationProps idProps = new IdentificationProps(queueId);
        if (idProps.getConsumerDescription() != null) {
            queueChannel = rabbitmqClient.createQueueChannel(idProps.getQueueName());
            String exchangeName = idProps.getExchangeName();
            ExchangeEnum exchangeType = idProps.getExchangeType();
            if (exchangeName != null && exchangeType != null) {
                queueChannel.bindingExchange(exchangeName, exchangeType);
            }
        }
        return queueChannel;
    }

    @Override
    public void unBindQueue(final String queueId, final String routingKey) {
        IdentificationProps idProps = new IdentificationProps(queueId);
        if (idProps.getConsumerDescription() != null) {
            String exchangeName = idProps.getExchangeName();
            ExchangeEnum exchangeType = idProps.getExchangeType();
            QueueChannel queueChannel = getQueueById(idProps.getQueueName());
            if (exchangeName != null && exchangeType != null) {
                queueChannel.unbindExchange(exchangeName, exchangeType, routingKey);
            }
        }
    }

    @Override
    public Integer getQueueMsgCount(String queueId) {
        IdentificationProps idProps = new IdentificationProps(queueId);
        if (idProps.getConsumerDescription() != null) {
            AMQP.Queue.DeclareOk declareOk = rabbitmqClient.getConnector().getRabbitTemplate().execute(new ChannelCallback<AMQP.Queue.DeclareOk>() {
                public AMQP.Queue.DeclareOk doInRabbit(Channel channel) throws Exception {
                    return channel.queueDeclarePassive(idProps.getQueueName());
                }
            });

            return declareOk.getMessageCount();
        }
        return 0;
    }

    @Override
    public QueueChannel createQueue(final String queueId, final String routingKey) {
        QueueChannel queueChannel = null;
        IdentificationProps idProps = new IdentificationProps(queueId);
        if (idProps.getConsumerDescription() != null) {
            queueChannel = rabbitmqClient.createQueueChannel(idProps.getQueueName());
            String exchangeName = idProps.getExchangeName();
            ExchangeEnum exchangeType = idProps.getExchangeType();
            if (exchangeName != null && exchangeType != null) {
                queueChannel.bindingExchange(exchangeName, exchangeType, routingKey);
            }
        }
        return queueChannel;
    }

    private class IdentificationProps {

        private String exchangeName;
        private ExchangeEnum exchangeType;
        private String consumerDescription;
        private String queueName;

        private IdentificationProps(String identificationStr) {
            if (identificationStr != null) {
                String[] propArr = identificationStr.split(ID_SEPARATOR);
                exchangeName = propArr.length >= 1 ? propArr[0] : null;
                exchangeType = propArr.length >= 2 ? ExchangeEnum.getExchangeEnumByName(propArr[1]) : null;
                consumerDescription = propArr.length >= 3 ? propArr[2] : null;
                queueName = identificationStr;
            }
        }

        public String getExchangeName() {
            return exchangeName;
        }

        public ExchangeEnum getExchangeType() {
            return exchangeType;
        }

        public String getConsumerDescription() {
            return consumerDescription;
        }

        public String getQueueName() {
            return queueName;
        }
    }
}
