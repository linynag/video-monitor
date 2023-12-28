package com.yiwei.common.entity.realData;

import com.yiwei.common.component.anotation.DictMapping;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class B9 {
    @ApiModelProperty("BMS放电循环次数")
    private Integer numberOfBmsDischargeCycles;
    @ApiModelProperty("BMS电池系统编码")
    private String bmsBatterySystemCode;
    @ApiModelProperty("BMS加热次数")
    private Integer bmsHeatingNumber;
    @ApiModelProperty("BMS均衡次数")
    private Integer bmsBalanceNumber;
    @ApiModelProperty("电池最大温度箱体号")
    private Integer maximumBatteryTemperatureBoxNumber;
    @ApiModelProperty("BMS电池状态信号5")
    private Integer bmsBatteryStatusSignal5;
    @ApiModelProperty("BMS电池欧姆内阻")
    private Integer ohmicInternalResistanceOfBmsBattery;
    @ApiModelProperty("BMS电池状态信号6")
    private Integer bmsBatteryStatusSignal6;
    @ApiModelProperty("电池最大电压箱体号")
    private Integer maximumBatteryVoltageBoxNumber;
    @ApiModelProperty("CC值")
    private Integer ccValue;
    @ApiModelProperty("CP值")
    private Integer cpValue;
    @ApiModelProperty("BMS绝缘电阻")
    private Integer bmsInsulationResistance;
    @ApiModelProperty("BMS算法发散状态")
    private Integer bmsAlgorithmDivergenceState;
    @ApiModelProperty("BMS电池状态信号14")
    private Integer bmsBatteryStatusSignal14;
    @ApiModelProperty("电池最小电压箱体号")
    private Integer batteryMinimumVoltageBoxNumber;
    @ApiModelProperty("BMS充电循环次数")
    private Integer numberOfBmsChargingCycles;
    @ApiModelProperty("BMS电池状态信号13")
    private Integer bmsBatteryStatusSignal13;
    @ApiModelProperty("系统版本号")
    private Integer systemVersionNumber;
    @ApiModelProperty("BMS电池单体总数")
    private Integer totalNumberOfBmsBatteryMonomers;
    @ApiModelProperty("BMS算法发散次数")
    private Integer bmsAlgorithmDivergenceNumber;
    @ApiModelProperty("CC2值")
    private Integer cc2Value;
    @ApiModelProperty("BMS硬件运行状态")
    private Integer bmsHardwareStatus;
    @ApiModelProperty("BMS电池开路电压")
    private Integer bmsBatteryOpenCircuitVoltage;
    @ApiModelProperty("BMS驻车时间")
    private Integer bmsParkingTime;
    @ApiModelProperty("BMS控制器唤醒源（插枪信号）")
    private Integer bmsControllerWakeUpSourceInsertGunSignal;
    @ApiModelProperty("0:无效 1,有效 254,异常")
    @DictMapping(dictCode = "bmsControllerWakeUpSourceInsertGunSignal", sourceField = "bmsControllerWakeUpSourceInsertGunSignal")
    private String bmsControllerWakeUpSourceInsertGunSignalStr;
    @ApiModelProperty("电池箱体个数")
    private Integer numberOfBatteryBoxes;
    @ApiModelProperty("应用层版本号")
    private Integer applicationLayerVersionNumber;
    @ApiModelProperty("BMS电池系统信号1")
    private Integer bmsBatterySystemSignal1;
    @ApiModelProperty("BMS电池极化内阻")
    private Integer polarizationInternalResistanceOfBmsBattery;
    @ApiModelProperty("BMS电池极化电容")
    private Integer bmsBatteryPolarizationCapacitance;
    @ApiModelProperty("电池最小温度箱体号")
    private Integer batteryMinimumTemperatureBoxSize;
    @ApiModelProperty("BMS电池均衡状态")
    private Integer bmsBatteryBalanceStatus;
    @DictMapping(dictCode = "bmsBatteryBalanceStatus",sourceField = "bmsBatteryBalanceStatus")
    private String bmsBatteryBalanceStatusStr;
    @ApiModelProperty("BMS采集温度总数")
    private Integer totalTemperatureCollectedByBms;
}
