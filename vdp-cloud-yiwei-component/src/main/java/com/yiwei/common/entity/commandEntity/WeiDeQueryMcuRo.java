package com.yiwei.common.entity.commandEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class WeiDeQueryMcuRo {
    @ApiModelProperty("电机类型 高压电机控制器1：1 ,高压电机控制器2：2 ,低压电机控制器1：3 低压电机控制器2：4 无效电机控制器 ：5")
    String motorType;
    @ApiModelProperty("功能码对应地址")
    String paramFunctionAddr;
    @ApiModelProperty("填写的序列号")
    String paramFunctionIndex;
    @ApiModelProperty("读MCU时，为参数个数,默认为1 ，写MCU时，为写入的参数")
    String param = "1";

    public String getMotorType() {
        return motorType;
    }

    public void setMotorType(String motorType) {
        this.motorType = motorType;
    }

    public String getParamFunctionAddr() {
        return paramFunctionAddr;
    }

    public void setParamFunctionAddr(String paramFunctionAddr) {
        this.paramFunctionAddr = paramFunctionAddr;
    }

    public String getParamFunctionIndex() {
        return paramFunctionIndex;
    }

    public void setParamFunctionIndex(String paramFunctionIndex) {
        this.paramFunctionIndex = paramFunctionIndex;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
