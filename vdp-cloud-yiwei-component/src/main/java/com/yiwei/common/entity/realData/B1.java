package com.yiwei.common.entity.realData;

import com.yiwei.common.component.anotation.DictMapping;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class B1 {
    @ApiModelProperty("海拔")
    private Integer altitude;
    @ApiModelProperty("DC-DC状态")
    private Integer dcDcStatus;
    @ApiModelProperty("1:工作 2:断开  3:异常 4:无效（其他值）")
    @DictMapping(dictCode = "dcDcStatus", sourceField = "dcDcStatus")
    private String dcDcStatusStr;
    @ApiModelProperty("纬度")
    private BigDecimal latitude;
    @ApiModelProperty("DCDC输出电流")
    private BigDecimal dcdcOutputCurrent;
    @ApiModelProperty("储能单体最低电压箱号")
    private Integer minimumVoltageBoxNumberOfEnergyStorageUnit;
    @ApiModelProperty("电机转速")
    private Integer motorSpeed;
    @ApiModelProperty("储能模块最高温度")
    private Integer maximumTemperatureOfEnergyStorageModule;
    @ApiModelProperty("电机控制器直流侧电流")
    private Integer dcSideCurrentOfMotorController;
    @ApiModelProperty("储能模块温度级差")
    private Integer temperatureDifferenceOfStorageModule;
    @ApiModelProperty("储能系统状态")
    private Integer storageSystemStatus;
    @ApiModelProperty("1,停车充电 2,行车充电 3,未充电 4,充电完成 65534,异常  65535,无效")
    @DictMapping(dictCode = "storageSystemStatus", sourceField = "storageSystemStatus")
    private String storageSystemStatusStr;
    @ApiModelProperty("电机转矩")
    private Integer motorTorque;
    @ApiModelProperty("终端号")
    private String devicecode;
    @ApiModelProperty("充电状态")
    private Integer chargingStatus;
    @ApiModelProperty("1,停车充电 2,行车充电 3,未充电  4,充电完成 65534,异常  65535,无效")
    @DictMapping(dictCode = "chargingStatus", sourceField = "chargingStatus")
    private String chargingStatusStr;
    @ApiModelProperty("经度")
    private BigDecimal longitude;
    @ApiModelProperty("方向")
    private Integer direction;
    @ApiModelProperty("储能系统SOC")
    private Integer storageSystemSoc;
    @ApiModelProperty("充电方式")
    private Integer chargingMethod;
    @ApiModelProperty("0,未充电 1,交流充电（慢充） 2,直流充电（快充） 3,行车充电（能量回馈） 4：无效(其他值)")
    @DictMapping(dictCode = "chargingMethod", sourceField = "chargingMethod")
    private String chargingMethodStr;
    @ApiModelProperty("电机控制器工作状态")
    private Integer motorControllerWorkingStatus;
    @ApiModelProperty("1,耗电 2,发电 3,关闭 4,准备就绪 65534,异常  65535,无效")
    @DictMapping(dictCode = "motorControllerWorkingStatus", sourceField = "motorControllerWorkingStatus")
    private String motorControllerWorkingStatusStr;
    @ApiModelProperty("DCDC温度")
    private Integer dcdcTemperature;
    @ApiModelProperty("DCDC输出电压")
    private BigDecimal dcdcOutputVoltage;
    @ApiModelProperty("GPS速度")
    private Integer gpsSpeed;
    @ApiModelProperty("角速度")
    private Integer angularVelocity;
    @ApiModelProperty("电机总数")
    private Integer totalNumberOfMotors;
    @ApiModelProperty("储能单体最高电压")
    private BigDecimal maximumVoltageOfEnergyStorageUnit;
    @ApiModelProperty("电机序号")
    private Integer motorSequenceNumber;
    @ApiModelProperty("储能单体最高电压箱号")
    private Integer maximumVoltageBoxNumberOfEnergyStorageUnit;
    @ApiModelProperty("DCDC输入电压")
    private BigDecimal dcdcInputVoltage;
    @ApiModelProperty("预留0")
    private Integer stay0;
    @ApiModelProperty("储能单体最低电压")
    private BigDecimal minimumVoltageOfEnergyStorageMonomer;
}
