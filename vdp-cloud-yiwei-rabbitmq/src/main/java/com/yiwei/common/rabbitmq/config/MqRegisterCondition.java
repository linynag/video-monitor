package com.yiwei.common.rabbitmq.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MqRegisterCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment environment = conditionContext.getEnvironment();
        Boolean startupInit = environment.getProperty("system.rabbitmq.startupInit", Boolean.class);
        if (startupInit == null)
            return true;
        return startupInit;
    }
}
