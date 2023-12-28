package com.yiwei.common.entity.realData;

import com.yiwei.common.component.anotation.DictMapping;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class B2 {
    @ApiModelProperty("电机温度")
    private Integer motorTemperature;
    @ApiModelProperty("电机控制器起停次数")
    private Integer numberOfStartAndStopOfMotorController;
    @ApiModelProperty("钥匙在On挡计次")
    private Integer keysCountInOnGear;
    @ApiModelProperty("BMS低速充电次数")
    private Integer bmsLowSpeedChargingNumber;
    @ApiModelProperty("DCDC起停次数")
    private Integer numberOfDcdcStartsAndStops;
    @ApiModelProperty("加速踏板单周期内最大变化率")
    private Integer maximumChangeRateOfAcceleratedPedalInOneCycle;
    @ApiModelProperty("空调启停状态")
    private Integer startStopStatusOfAirConditioning;
    @ApiModelProperty("0,停止 1,启动，254,异常 255,无效")
    @DictMapping(dictCode = "statusOfAirConditioning", sourceField = "startStopStatusOfAirConditioning")
    private String startStopStatusOfAirConditioningStr;
    @ApiModelProperty("电机状态")
    private Integer motorStatus;
    @ApiModelProperty("钥匙在Off挡计次")
    private Integer keysCountedInOffGear;
    @ApiModelProperty("钥匙在Acc挡计次")
    private Integer keysInAccStop;
    @ApiModelProperty("整车模式")
    private Integer fullVehicleMode;
    @ApiModelProperty("0,停机 1,前进 2,故障 3,调试 4,倒车 8,充电 9,紧急 254:异常 255:无效")
    @DictMapping(dictCode = "fullVehicleMode", sourceField = "fullVehicleMode")
    private String fullVehicleModeStr;
    @ApiModelProperty("BMS放电过程次数")
    private Integer numberOfBmsDischargeProcesses;
    @ApiModelProperty("电机序号2")
    private Integer totalNumberOfSequence2;  //修改
    @ApiModelProperty("电机控制器温度")
    private Integer motorControllerTemperature;
    @ApiModelProperty("油门踏板计数")
    private Integer throttlePedalCount;
    @ApiModelProperty("电机总数2")
    private Integer totalNumberOfMotors2;
    @ApiModelProperty("预留3")
    private Integer stay3;
    @ApiModelProperty("预留4")
    private Integer stay4;
    @ApiModelProperty("预留1")
    private Integer stay1;
    @ApiModelProperty("电机控制器直流侧电压")
    private BigDecimal dcSideVoltageOfMotorController;
    @ApiModelProperty("预留2")
    private Integer stay2;
    @ApiModelProperty("DCAC起停次数")
    private Integer numberOfDcacStartsAndStops;
    @ApiModelProperty("预留5")
    private Integer stay5;
    @ApiModelProperty("制动踏板计数")
    private Integer brakePedalCount;
    @ApiModelProperty("制动踏板单周期内最大变化率")
    private Integer maximumChangeRateOfBrakePedalInOneCycle;
    @ApiModelProperty("车辆单次起停计次")
    private Integer singleStartstopCountingOfVehicles;

}
