package com.yiwei.common.rabbitmq.config;

import com.yiwei.common.component.utils.SpringContextUtils;
import com.yiwei.common.rabbitmq.client.RabbitmqClient;
import com.yiwei.common.rabbitmq.client.RabbitmqConnector;
import com.yiwei.common.rabbitmq.service.PeriodSeparatedIdRabbitmqService;
import com.yiwei.common.rabbitmq.service.RabbitmqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * 根据指定的条件来决定是否创建某个Bean。
 **/
@Configuration
@Slf4j
public class RabbitmqInitConfig {

    @Autowired
    private RabbitmqProps rabbitmqProps;

    @Bean
    @Conditional({MqRegisterCondition.class})
    public RabbitmqConnector rabbitmqConnector() {
        if (rabbitmqProps.getHost() == null && rabbitmqProps.getPort() == null) {
            log.warn("system.rabbitmq.host,system.rabbitmq.port没有在配置文件中找到对应的值，因此不初始化rabbitmq!");
            return null;
        } else {
            return new RabbitmqConnector(rabbitmqProps);
        }
    }

    /**
     * 必须要在Spring bean工厂里面注册RabbitTemplate不然会自动用localhost:5672再创建一个连接，从而报错无法启动项目
     *
     * @param connector
     * @return
     */
    @Bean
    @Conditional({MqRegisterCondition.class})
    public RabbitTemplate rabbitTemplate(RabbitmqConnector connector) {
        return connector != null ? connector.getRabbitTemplate() : null;
    }

    @Bean
    @Conditional({MqRegisterCondition.class})
    public RabbitAdmin rabbitAdmin(RabbitmqConnector connector) {
        return connector != null ? connector.getRabbitAdmin() : null;
    }

    @Bean
    @Conditional({MqRegisterCondition.class})
    public RabbitmqClient rabbitmqClient(RabbitmqConnector connector) {
        return connector != null ? new RabbitmqClient(connector) : null;
    }

    @Bean
    @Conditional({MqRegisterCondition.class})
    public RabbitmqService rabbitmqService(RabbitmqClient rabbitmqClient) {
        return rabbitmqClient != null ? new PeriodSeparatedIdRabbitmqService(rabbitmqClient) : null;
    }

}
