package com.yiwei.common.entity.commandEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 远程获取文件  (下发指令后车辆将CAN文件上传到服务器)
 * @author JY
 */
@Data
@ApiModel("远程上传CAN文件指令 【全部必填】")
public class UploadCanFileRO {
    @ApiModelProperty("车机号 实际上是VINCODE 这里有坑 注意")
    private String devcode;
    @ApiModelProperty("上传指定时间的数据 格式202107071342")
    private String fileTime;
    @ApiModelProperty("FTP用户名")
    private String ftpUserName;
    @ApiModelProperty("FTP密码")
    private String ftpPassword;
    @ApiModelProperty("FTP的IP地址")
    private String ftpHost;
    @ApiModelProperty("FTP的端口")
    private Integer ftpPort;
    @ApiModelProperty("FTP上传磁盘路径")
    private String ftpFilePath;

}
