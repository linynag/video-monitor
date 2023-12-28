package com.yiwei.common.rabbitmq.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * rabbitmq配置类
 */
@ConfigurationProperties(prefix = "system.rabbitmq")
@Component
public class RabbitmqProps {
    private String host;
    private Integer port;
    private Integer webPort;
    private String username;
    private String password;
    private boolean publisherConfirms = false;
    private String virtualHost = "/";
    private List<String> handlers;
    private Boolean startupInit = true;


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
        this.webPort = Integer.valueOf("1" + port.toString());
    }

    public Integer getWebPort() {
        return webPort;
    }

    public void setWebPort(Integer webPort) {
        this.webPort = webPort;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPublisherConfirms() {
        return publisherConfirms;
    }

    public void setPublisherConfirms(boolean publisherConfirms) {
        this.publisherConfirms = publisherConfirms;
    }

    public String getVirtualHost() {
        return virtualHost;
    }

    public void setVirtualHost(String virtualHost) {
        this.virtualHost = virtualHost;
    }

    public List<String> getHandlers() {
        return handlers;
    }

    public void setHandlers(List<String> handlers) {
        this.handlers = handlers;
    }

    public Boolean isStartupInit() {
        return startupInit;
    }

    public void setStartupInit(Boolean startupInit) {
        this.startupInit = startupInit;
    }


}