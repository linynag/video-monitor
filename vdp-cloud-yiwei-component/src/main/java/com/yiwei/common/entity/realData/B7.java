package com.yiwei.common.entity.realData;

import com.yiwei.common.component.anotation.DictMapping;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class B7 {
    @ApiModelProperty("牵引踏板踏板电压2")
    private BigDecimal tractionPedalPedalVoltage2;
    @ApiModelProperty("真空泵传感器电压")
    private Integer vacuumPumpSensorVoltage;
    @ApiModelProperty("低压蓄电池电压")
    private BigDecimal lowVoltageBatteryVoltage;
    @ApiModelProperty("车载充电机输出电流")
    private BigDecimal outputCurrentOfCarCharger;
    @ApiModelProperty("车载充电机设定电流")
    private BigDecimal setCurrentOfCarCharger;
    @ApiModelProperty("车载充电机状态")
    private Integer carChargerStatus;
    @ApiModelProperty("1,待机，OBC 高压输入已完成， \n" +
            "等待充电指令 \n" +
            " 2：恒流充电，OBC 恒流工作 \n" +
            " 3：恒压充电，OBC 恒压工作 \n" +
            " 4：充电完成，OBC 充电完成 \n" +
            " 5：休眠，OBC 进入休眠 \n" +
            " 6：故障，OBC 检测到有故障发生 \n" +
            "254:异常 255:无效")
    @DictMapping(dictCode = "carChargerStatus", sourceField = "carChargerStatus")
    private String carChargerStatusStr;
    @ApiModelProperty("2秒内加速度极大值")
    private BigDecimal maximumAccelerationIn2Seconds;
    @ApiModelProperty("2秒内减速度极大值")
    private Integer maximumDecelerationIn2Seconds;
    @ApiModelProperty("车载充电机启动指令")
    private Integer carChargerStartupInstruction;
    @ApiModelProperty("0:停止充电 1,启动充电，254,异常 255,异常")
    @DictMapping(dictCode = "carChargerStartupInstruction", sourceField = "carChargerStartupInstruction")
    private String carChargerStartupInstructionStr;
    @ApiModelProperty("车载充电机输出电压")
    private Integer outputVoltageOfCarCharger;
    @ApiModelProperty("牵引踏板踏板电压1")
    private Integer tractionPedalPedalVoltage1;
    @ApiModelProperty("整车计次日期")
    private Integer fullCarNumberingDate;
    @ApiModelProperty("百公里电耗")
    private BigDecimal powerConsumption100km;
    @ApiModelProperty("平均百公里电耗")
    private BigDecimal averagePowerConsumptionOf100Kilometers;
    @ApiModelProperty("真空泵启停计次")
    private Integer startstopCountingOfVacuumPump;
    @ApiModelProperty("VCU程序版本号")
    private String vcuProgramVersionNumber;
    @ApiModelProperty("低压掉电计次")
    private Integer lowVoltagePowerDownMeter;
    @ApiModelProperty("冷藏机组冷藏箱温度")
    private Integer refrigeratorTemperature;
    @ApiModelProperty("制动踏板踏板电压2")
    private BigDecimal brakePedalVoltage2;
    @ApiModelProperty("制动踏板踏板电压1")
    private Integer brakePedalVoltage1;
}
