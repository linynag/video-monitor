package com.yiwei.common.entity.realData;

import com.yiwei.common.component.anotation.DictMapping;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class B4 {
    @ApiModelProperty("运行模式")
    private Integer runningMode;
    @ApiModelProperty("1,纯电动模式 2,混动模式 3,燃油模式 14,异常 15,无效")
    @DictMapping(dictCode = "runningMode", sourceField = "runningMode")
    private String runningModeStr;
    @ApiModelProperty("电池模块第四高电压串号")
    private Integer batteryModule4thHighVoltageSerialNumber;
    @ApiModelProperty("绝缘电阻")
    private Integer insulationResistance;
    @ApiModelProperty("预留9")
    private String stay9;
    @ApiModelProperty("电池模块第三高电压串号")
    private Integer thirdHighVoltageSerialNumberOfBatteryModule;
    @ApiModelProperty("电池模块第二高电压串号")
    private Integer secondHighVoltageSerialNumberOfBatteryModule;
    @ApiModelProperty("当前总里程")
    private Integer currentTotalMileage;
    @ApiModelProperty("气泵DCAC温度")
    private Integer airPumpDcacTemperature;
    @ApiModelProperty("电池模块第一高电压串号")
    private Integer firstHighVoltageSerialNumberOfBatteryModule;
    @ApiModelProperty("电池模块第四低电压串号")
    private Integer batteryModule4thLowVoltageSerialNumber;
    @ApiModelProperty("车辆启动状态")
    private Integer vehicleStartupStatus;
    @ApiModelProperty("1,启动 2,熄火 3,其他 14,异常 15,无效")
    @DictMapping(dictCode = "vehicleStartupStatus", sourceField = "vehicleStartupStatus")
    private String vehicleStartupStatusStr;
    @ApiModelProperty("电池模块第二低电压串号")
    private Integer secondLowVoltageSerialNumberOfBatteryModule;
    @ApiModelProperty("电池模块第三低电压串号")
    private Integer batteryModuleThirdLowVoltageSerialNumber;
    @ApiModelProperty("气泵DCAC故障代码")
    private GasPumpDcacFaultCode gasPumpDcacFaultCode;

    @Data
    public static class GasPumpDcacFaultCode {
        @ApiModelProperty("输出过流")
        private String outputOvercurrent;
        @ApiModelProperty("低压故障")
        private String lowVoltageFailure;
        @ApiModelProperty("过热故障")
        private String overheatFault;
        @ApiModelProperty("缺相保护")
        private String missingPhaseProtection;
        @ApiModelProperty("输入过压")
        private String inputOvervoltage;
        @ApiModelProperty("气泵DCAC的运行状态")
        private String operationStatusOfAirPumpDcac;
        @ApiModelProperty("霍尔故障")
        private String hallFault;
        @ApiModelProperty("输入欠压")
        private String inputUndervoltage;
    }

    @ApiModelProperty("区间里程A")
    private Integer intervalMileageA;
    @ApiModelProperty("气泵DCAC故障代码")
    private Integer gasPumpDcacFaultCodeMask;
    @ApiModelProperty("数据发送请求")
    private Integer dataSendRequest;
    @ApiModelProperty("剩余续驶里程")
    private Integer remainingDrivingMileage;
    @ApiModelProperty("低于百米总里程")
    private Integer lessThan100MetersTotalMileage;
    @ApiModelProperty("电池模块第一低电压串号")
    private Integer firstLowVoltageSerialNumberOfBatteryModule;
    @ApiModelProperty("预留7")
    private Integer stay7;
    @ApiModelProperty("预留11")
    private String stay11;
    @ApiModelProperty("预留8")
    private Integer stay8;
    @ApiModelProperty("预留10")
    private String stay10;
    @ApiModelProperty("预留6")
    private Integer stay6;
    @ApiModelProperty("气泵DCAC输入电压")
    private Integer gasPumpDcacInputVoltage;

}
