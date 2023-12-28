package org.yzh.init;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName ScProperties
 * @Description SC为服务的内部服务配置类
 */
@ConfigurationProperties(prefix = "sc.server")
@Component
public class SCProps {

    private final DevConnect devConnect = new DevConnect();
    private final DevAuthentication devAuthentication = new DevAuthentication();
    private final DataHandle dataHandle = new DataHandle();
    @Value("${server.port}")
    private int port;
    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${rawDataMQTransfer}")
    private boolean rawDataMQTransfer;
    @Value("${rawDataCheckTimeDiff}")
    private int rawDataCheckTimeDiff;

    public String getServerName() {
        return this.applicationName;
    }

    public String getServerId() {
        return this.applicationName + ":" + this.port;
    }

    public boolean isRawDataMQTransfer() {
        return rawDataMQTransfer;
    }

    public int getRawDataCheckTimeDiff() {
        return rawDataCheckTimeDiff;
    }

    public void setRawDataCheckTimeDiff(int rawDataCheckTimeDiff) {
        this.rawDataCheckTimeDiff = rawDataCheckTimeDiff;
    }

    public DevAuthentication getDevAuthenticaton() {
        return devAuthentication;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public int getPort() {
        return port;
    }

    public DataHandle getDataHandle() {
        return dataHandle;
    }

    public DevConnect getDevConnect() {
        return devConnect;
    }

    @Data
    public static abstract class queueParam {
        private Integer threadNum;
        private Integer queueDepth;
    }

    /**
     * 数据处理参数实体类
     */
    public static class DataHandle extends queueParam {
    }

    /**
     * 车机连接参数实体类
     */
    @Data
    public static class DevConnect {
        private String agentUrl;
        private String cmdUrl;
    }

    /**
     * 认证参数实体类
     */
    @Data
    public static class DevAuthentication {
        private Boolean open = false;
    }
}
