package com.yiwei.common.entity.realData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class B8 {
    @ApiModelProperty("BMS电池故障总数")
    private Integer totalBmsBatteryFailures;
    @ApiModelProperty("BMS直流充电需求电流")
    private BigDecimal dcChargingCurrentRequirementForBms;
    private String dcChargingCurrentRequirementForBmsStr;
    @ApiModelProperty("2秒内总线电压最小值")
    private BigDecimal minimumBusVoltageIn2Seconds;
    @ApiModelProperty("2秒内总线电压平均值")
    private BigDecimal averageBusVoltageIn2Seconds;
    @ApiModelProperty("2秒内总线电压最大值")
    private BigDecimal maximumBusVoltageIn2Seconds;
    @ApiModelProperty("BMS直流充电握手状态")
    private Integer bmsDcChargingHandshakeStatus;
    @ApiModelProperty("BMS电池系统状态")
    private Integer bmsBatterySystemStatus;
    @ApiModelProperty("BMS直流充电结束原因")
    private Integer reasonForEndOfBmsDcCharging;
    @ApiModelProperty("BMS直流充电需求电压")
    private BigDecimal bmsDcChargingRequirementVoltage;
    private String bmsDcChargingRequirementVoltageStr;
    @ApiModelProperty("2秒内总线电流最大值")
    private Integer maximumBusCurrentIn2Seconds;
    @ApiModelProperty("BMS电池最小温度编号")
    private Integer bmsBatteryMinimumTemperatureNumber;
    @ApiModelProperty("BMS电池最大温度编号")
    private Integer bmsBatteryMaximumTemperatureNumber;
    @ApiModelProperty("故障代码通道2")
    private Integer failureCodeChannel2;
    @ApiModelProperty("故障代码通道3")
    private Integer failureCodeChannel3;
    @ApiModelProperty("故障代码通道1")
    private Integer failureCodeChannel1;
    @ApiModelProperty("BMS电池最小温度")
    private Integer bmsBatteryMinimumTemperature;
    @ApiModelProperty("2秒内总线电流平均值")
    private BigDecimal averageBusCurrentIn2Seconds;
    @ApiModelProperty("故障代码通道4")
    private Integer failureCodeChannel4;
    @ApiModelProperty("2秒内总线电流最小值")
    private Integer minimumBusCurrentIn2Seconds;
    @ApiModelProperty("BMS单体压差")
    private BigDecimal bmsMonomerPressureDifference;
    @ApiModelProperty("BMS电池系统模式状态")
    private Integer bmsBatterySystemModelStatus;
}
