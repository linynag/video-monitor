package com.yiwei.common.entity.realData;

import com.yiwei.common.component.anotation.DictMapping;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class B3 {
    @ApiModelProperty("电机工作模式指令")
    private String motorOperationModeInstructionMask;
    @ApiModelProperty("报警信号")
    private Integer alarmSignal;
    @ApiModelProperty("0:无故障 1,一级故障 2,二级故障 3,三级故障 254:异常 255:无效")
    @DictMapping(dictCode = "alarmSignal", sourceField = "alarmSignal")
    private String alarmSignalStr;
    @ApiModelProperty("电机控制器接触器状态")
    private Integer motorControllerContactorStatus;
    @ApiModelProperty("0：预充断开,主正断开\n" +
            "1：预充吸合，主正断开\n" +
            "2：预充吸合，主正吸合 \n" +
            "3：预充断开，主正吸合 \n" +
            " 254:异常   255:无效")
    @DictMapping(dictCode = "motorControllerContactorStatus", sourceField = "motorControllerContactorStatus")
    private String motorControllerContactorStatusStr;
    @ApiModelProperty("整车控制器LIFE")
    private Integer fullVehicleControllerLife;
    @ApiModelProperty("动力电源电压")
    private BigDecimal powerSupplyVoltage;
    @ApiModelProperty("整车控制器故障代码")
    private String fullVehicleControllerFailureCode;
    @ApiModelProperty("动力电源电流")
    private Integer powerSupplyCurrent;
    @ApiModelProperty("车速")
    private Integer speed;
    @ApiModelProperty("故障等级")
    private Integer failureLevel;
    @ApiModelProperty("0:无故障 1,一级故障 2,二级故障 3,三级故障 254,异常 255,无效")
    @DictMapping(dictCode = "failureLevel", sourceField = "failureLevel")
    private String failureLevelStr;
    @ApiModelProperty("电机故障代码")
    private Integer motorFaultCode;
    @ApiModelProperty("电机故障代码")
    @DictMapping(dictCode = "motorFaultCode",sourceField = "motorFaultCode")
    private String motorFaultCodeStr;
    @ApiModelProperty("电机目标输出转矩")
    private Integer motorTargetOutputTorque;
    @ApiModelProperty("动力电机总数")
    private Integer totalNumberOfPowerMotors;
    @ApiModelProperty("接地信号")
    private Integer groundSignal;
    @ApiModelProperty("电机工作模式指令")
    private MotorOperationModeInstruction motorOperationModeInstruction;


    @Data
    public static class MotorOperationModeInstruction {
        @ApiModelProperty("停机")
        private String downtime;
        @ApiModelProperty("下电请求")
        private String powerDownRequest;
        @ApiModelProperty("向前")
        private String forward;
        @ApiModelProperty("ready")
        private String ready;
        @ApiModelProperty("向后")
        private String backward;
        @ApiModelProperty("模式")
        private String model;
        @ApiModelProperty("驱动")
        private String drive;
        @ApiModelProperty("制动")
        private String braking;
    }

    @ApiModelProperty("方向信号")
    private Integer directionalSignal;
    @ApiModelProperty("0:空档 1:1档 2:2档 3:3档 4:4档 5:5档 5:5档 6:6档 7:7档 8:8档 9:9档 10:10档 11:11档  12:12档 13:倒挡 14:自动D档 15:P档")
    @DictMapping(dictCode = "directionalSignal", sourceField = "directionalSignal")
    private String directionalSignalStr;
    @ApiModelProperty("充电信号")
    private Integer chargingSignal;
    @ApiModelProperty("0:无插枪 1,已插枪 254:异常  255:无效")
    @DictMapping(dictCode = "chargingSignal", sourceField = "chargingSignal")
    private String chargingSignalStr;
    @ApiModelProperty("牵引踏板信号")
    private Integer tractionPedalSignal;
    @ApiModelProperty("动力电机序号")
    private Integer powerMotorSequenceNumber;
    @ApiModelProperty("制动踏板信号")
    private Integer brakePedalSignal;

}
