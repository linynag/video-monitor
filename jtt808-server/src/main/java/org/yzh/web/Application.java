package org.yzh.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching
@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages = {"org.yzh.init", "com.yiwei.common"})
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        // Hikari连接池提供的JDBC Connection连接有效性检测,默认为500毫秒
        System.setProperty("com.zaxxer.hikari.aliveBypassWindowMs", "2000");
        SpringApplication.run(Application.class, args);
        log.info("***Spring 启动成功***");
    }
}