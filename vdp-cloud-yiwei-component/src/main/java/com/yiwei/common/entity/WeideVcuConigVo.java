package com.yiwei.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class WeideVcuConigVo {

    @ApiModelProperty("内存校验：0x01；读数据：0x02；写数据：0x03；固化数据：0x04；无效会话：0XFF；")
    private Byte handleType;
    @ApiModelProperty("默认为1201")
    private String stationAddr;
    @ApiModelProperty("协议版本号")
    private String protocoVersion;
    @ApiModelProperty("传输内存地址")
    private String memoryAddr;
    @ApiModelProperty("数据类型 Int16、FLOAT32")
    private String memoryAddrType;
    @ApiModelProperty("校验数据块大小")
    private String checkDataSize;
    @ApiModelProperty("读/写 字节长度")
    private Short byteCount;
    @ApiModelProperty("数据")
    private String data;

    public Byte getHandleType() {
        return handleType;
    }

    public void setHandleType(Byte handleType) {
        this.handleType = handleType;
    }

    public String getStationAddr() {
        return stationAddr;
    }

    public void setStationAddr(String stationAddr) {
        this.stationAddr = stationAddr;
    }

    public String getProtocoVersion() {
        return protocoVersion;
    }

    public void setProtocoVersion(String protocoVersion) {
        this.protocoVersion = protocoVersion;
    }

    public String getMemoryAddr() {
        return memoryAddr;
    }

    public void setMemoryAddr(String memoryAddr) {
        this.memoryAddr = memoryAddr;
    }

    public String getMemoryAddrType() {
        return memoryAddrType;
    }

    public void setMemoryAddrType(String memoryAddrType) {
        this.memoryAddrType = memoryAddrType;
    }

    public String getCheckDataSize() {
        return checkDataSize;
    }

    public void setCheckDataSize(String checkDataSize) {
        this.checkDataSize = checkDataSize;
    }

    public Short getByteCount() {
        return byteCount;
    }

    public void setByteCount(Short byteCount) {
        this.byteCount = byteCount;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
