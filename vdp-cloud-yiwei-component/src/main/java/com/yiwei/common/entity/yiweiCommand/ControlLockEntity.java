package com.yiwei.common.entity.yiweiCommand;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ControlLockEntity {
    private String devCode;
    @ApiModelProperty("1-车辆锁定/解锁指令,2-车辆限速指令,3-上装锁定/解锁指令")
    private Integer commandType;
    @ApiModelProperty("操作类型 0x0000AAAA-锁定,0x0000FFFF 解锁  如果commandType 为2 则直接传最高限制速度")
    private Long controlType;


    public Integer getCommandType() {
        return commandType;
    }

    public void setCommandType(Integer commandType) {
        this.commandType = commandType;
    }


    public Long getControlType() {
        return controlType;
    }

    public void setControlType(Long controlType) {
        this.controlType = controlType;
    }

    public String getDevCode() {
        return devCode;
    }

    public void setDevCode(String devCode) {
        this.devCode = devCode;
    }
}
