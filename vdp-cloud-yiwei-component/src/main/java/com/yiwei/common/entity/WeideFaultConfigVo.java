package com.yiwei.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@ApiModel
@Getter
@Setter
public class WeideFaultConfigVo {

    @ApiModelProperty("主机地址")
    private int host;
    @ApiModelProperty("故障报警使能开关 0 关 1 开")
    private int faultAlarmSwitch;
    @ApiModelProperty("电池最大容量")
    private BigDecimal batteryMaxCapacity;
    @ApiModelProperty("电池剩余容量")
    private BigDecimal batteryRemainingCapacity;

}
