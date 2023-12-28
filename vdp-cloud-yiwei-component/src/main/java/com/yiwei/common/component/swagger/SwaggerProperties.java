package com.yiwei.common.component.swagger;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName SwaggerProperties
 * @Description 加载swagger的配置文件
 */
@Configuration
@ConfigurationProperties(prefix = "system.swagger")
@ConditionalOnExpression("${system.swagger.enable:false}")
public class SwaggerProperties {
    /**
     protocol: http          //协议，http或https
     base-package: com.vdp   //一定要写对，会在这个路径下扫描controller定义
     title: REST接口定义
     version: 1.0
     description: vdp-cloud项目RESTful API
     **/
    private boolean enable;
    private String protocol;
    private String basePackage;
    private String title;
    private String version;
    private String description;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
