package com.yiwei.common.entity.realData;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class B5 {
    @ApiModelProperty("电池SOH")
    private Integer batterySoh;
    @ApiModelProperty("电池最大可用放电电流（SOF）")
    private Integer maximumAvailableDischargeCurrentForBatteriesSof;
    @ApiModelProperty("电池模块第四低电压")
    private Integer batteryModuleFourthLowVoltage;
    @ApiModelProperty("电池CSC通信状态")
    private Integer batteryCscCommunicationStatus;
    @ApiModelProperty("电池模块第三低电压")
    private BigDecimal batteryModuleThirdLowVoltage;
    @ApiModelProperty("电池模块第三高电压")
    private BigDecimal thirdHighVoltageOfBatteryModule;
    @ApiModelProperty("车辆放电电量")
    private Integer vehicleDischargeVolume;
    @ApiModelProperty("电池放电容量")
    private BigDecimal batteryDischargeCapacity;
    @ApiModelProperty("电池模块第四高电压")
    private Integer batteryModule4thHighVoltage;
    @ApiModelProperty("电池故障等级")
    private Integer batteryFailureLevel;
    @ApiModelProperty("电池最大可用充电电电流（SOF）")
    private Integer maximumAvailableChargeCurrentForBatteriesSof;
    @ApiModelProperty("车辆充电电量")
    private Integer vehicleChargingPower;
    @ApiModelProperty("电池实际容量")
    private Integer actualBatteryCapacity;
    @ApiModelProperty("电池模块第二高电压")
    private BigDecimal secondHighVoltageOfBatteryModule;
    @ApiModelProperty("电池模块第二低电压")
    private BigDecimal batteryModuleSecondLowVoltage;
    @ApiModelProperty("车辆制动回收能量")
    private Integer vehicleBrakingEnergyRecovery;
    @ApiModelProperty("电池系统故障码")
    private Integer batterySystemFailureCode;
    @ApiModelProperty("电池充电容量")
    private Integer batteryChargingCapacity;

}
