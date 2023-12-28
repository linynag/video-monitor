package com.yiwei.common.entity.commandEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by victorlau on 2020/5/12.
 */
@ApiModel("车机升级指令Ro")
public class UpgradeRo {
    @ApiModelProperty("车机号")
    private String devcode;
    @ApiModelProperty("拨号点名称")
    private String pppDialName;
    @ApiModelProperty("拨号用户名")
    private String pppDialUserName;
    @ApiModelProperty("拨号密码")
    private String pppDialPassword;
    @ApiModelProperty("升级服务器地址")
    private String ip;
    @ApiModelProperty("升级服务器端口")
    private Integer port;
    @ApiModelProperty("终端升级的完整URL地址")
    private String ftpUrl;
    @ApiModelProperty("连接到升级服务器时限(终端收到升级命令后的时限前连回平台)")
    private Integer timeBound;

    public String getDevcode() {
        return devcode;
    }

    public void setDevcode(String devcode) {
        this.devcode = devcode;
    }

    public String getPppDialName() {
        return pppDialName;
    }

    public void setPppDialName(String pppDialName) {
        this.pppDialName = pppDialName;
    }

    public String getPppDialUserName() {
        return pppDialUserName;
    }

    public void setPppDialUserName(String pppDialUserName) {
        this.pppDialUserName = pppDialUserName;
    }

    public String getPppDialPassword() {
        return pppDialPassword;
    }

    public void setPppDialPassword(String pppDialPassword) {
        this.pppDialPassword = pppDialPassword;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getFtpUrl() {
        return ftpUrl;
    }

    public void setFtpUrl(String ftpUrl) {
        this.ftpUrl = ftpUrl;
    }

    public Integer getTimeBound() {
        return timeBound;
    }

    public void setTimeBound(Integer timeBound) {
        this.timeBound = timeBound;
    }
}
