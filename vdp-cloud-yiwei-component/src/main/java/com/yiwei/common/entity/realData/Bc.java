package com.yiwei.common.entity.realData;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yiwei.common.component.anotation.DictMapping;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class Bc {
    @ApiModelProperty("燃料电池工作状态")
    private Integer fuelCellWorkingState;
    @ApiModelProperty("0:自检（上电自检） 上电各部件状态自检\n" +
            "1:待机（准备就绪) 自检完成后燃料电池系统待机中\n" +
            "2:正常启动,启动完成可以进行功率输出，但满足可加载功率>=目标功率\n" +
            "3:低温启动 低温条件燃电工作\n" +
            "4:自动运行(运行） 正常响应 VCU 功率请求\n" +
            "5:手动运行 燃电调试时自行加载功率\n" +
            "6:正常停机（关机OK） 停机\n" +
            "7:低温吹扫停机 低温状态下吹扫关机\n" +
            "8:紧急停机（紧急关机）紧急状态下停机\n" +
            "9:故障状态 正常故障下，按照流程停机\n" +
            "10:启动中,燃料电池响应整车开关机指令\n"+
            "11：关机中,燃料电池正在关机,执行关机流程"
    )
    @DictMapping(dictCode = "fuelCellWorkingState",sourceField = "fuelCellWorkingState")
    private String fuelCellWorkingStateStr;
    @ApiModelProperty("燃料电池开机指令")
    private Integer fuelCellStartupCommand;
    @ApiModelProperty("0x01：开机,0x02：正常关机,0x03：临时关机")
    @DictMapping(dictCode = "fuelCellStartupCommand",sourceField = "fuelCellStartupCommand")
    private String fuelCellStartupCommandStr;
    @ApiModelProperty("紧急指令")
    private Integer emergencyInstructions;
    @ApiModelProperty("0x00：NORMAL,0x01：ESTOP")
    @DictMapping(dictCode = "emergencyInstructions",sourceField = "emergencyInstructions")
    private String emergencyInstructionsStr;
    @ApiModelProperty("目标输出功率")
    private BigDecimal targetOutputPower;
    @ApiModelProperty("燃电系统当前输出功率")
    private BigDecimal outputPowerOfFuelCellSystem;
    @ApiModelProperty("氢气系统剩余质量SOC百分比")
    @JsonProperty("SOCOfHydrogenSystem")
    private Integer SOCOfHydrogenSystem;
    @ApiModelProperty("累计氢耗")
    private Integer cumulativeHydrogenConsumption;
    @ApiModelProperty("燃料电池累计工作时间")
    private Float accumulatedWorkingTimeOfFuelCell;
    @ApiModelProperty("故障等级")
    private Integer faultLevel;
    @ApiModelProperty("0x00：不需要处理\n" +
            "0x01：警告，不需要处理\n" +
            "0x02：系统自动降载，执行关机指令，清除此故障后需重新复位开机命令\n" +
            "0x03：系统会立即关机（上报最高等级故障）")
    @DictMapping(dictCode = "faultLevel",sourceField = "faultLevel")
    private String faultLevelStr;
    @ApiModelProperty("有sb")
    private Integer sb;
    @ApiModelProperty("燃料电池系统故障码")
    private String fuelCellSystemFaultCode;
    @ApiModelProperty("故障设备代号")
    private String faultDeviceCode;
    @ApiModelProperty("升压DCDC输出电流")
    private BigDecimal boostDCDCOutputCurrent;
    @ApiModelProperty("升压DCDC输出电压")
    private BigDecimal boostDCDCOutputVoltage;
    @ApiModelProperty("升压DCDC输入电压")
    private BigDecimal boostDCDCInputVoltage;
    @ApiModelProperty("降压DCDC状态")
    private Integer stepDownDCDCStatus;
    @ApiModelProperty("0x01:工作,0x02:断开,0xFE:异常,0xFF:无效")
    @DictMapping(dictCode = "stepDownDCDCStatus",sourceField = "stepDownDCDCStatus")
    private String stepDownDCDCStatusStr;
    @ApiModelProperty("降压DCDC输出电流")
    private Integer stepDownDCDCOutputCurrent;
    @ApiModelProperty("降压DCDC输出电压")
    private BigDecimal stepDownDCDCOutputVoltage;
    @ApiModelProperty("降压DCDC故障码")
    private String stepDownDCDCFaultCode;
    @ApiModelProperty("降压DCDC温度")
    private Integer stepDownDCDCTemperature;
    @ApiModelProperty("燃电系统氢气最高压力")
    private BigDecimal maximumHydrogenPressureOfFuelCellSystem;
    @ApiModelProperty("燃料电池最高温度")
    private Integer maxTemperatureOfFuelCell;
    @ApiModelProperty("燃料电池最低温度")
    private Integer minTemperatureOfFuelCell;
    @ApiModelProperty("水泵工作电压")
    private Integer workingVoltageOfWaterPump;
    @ApiModelProperty("水泵工作电流")
    private Integer workingCurrentOfWaterPump;
    @ApiModelProperty("电堆电池个数")
    private Integer numberOfPileBatteries;
    @ApiModelProperty("燃料电池系统个数")
    private Integer numberOfFuelCellSystems;
    @ApiModelProperty("扩展报文37字节7")
    private Integer extendedMessage37_7;
    @ApiModelProperty("扩展报文37字节8")
    private Integer extendedMessage37_8;
    @ApiModelProperty("扩展报文38字节6")
    private Integer extendedMessage38_6;
    @ApiModelProperty("扩展报文38字节7")
    private Integer extendedMessage38_7;
    @ApiModelProperty("扩展报文38字节8")
    private Integer extendedMessage38_8;
    @ApiModelProperty("空压机状态")
    private Integer airCompressorStatus;
    @ApiModelProperty("0x00：初始化        0x01：待机\n" +
            "0x02：启动          0x03：停止\n" +
            "0x04：运行          0x05：失败\n" +
            "0x06：停机          0x07：准备关机\n" +
            "0x08：待冷却\n" +"其余无效")
    @DictMapping(dictCode = "airCompressorStatus",sourceField = "airCompressorStatus")
    private String airCompressorStatusStr;
    @ApiModelProperty("空压机运行模式")
    private Integer airCompressorOperationModel;
    @ApiModelProperty("0x00：Neutral,x03：Ev")
    @DictMapping(dictCode = "airCompressorOperationModel",sourceField = "airCompressorOperationModel")
    private String airCompressorOperationModelStr;
    @ApiModelProperty("空压机电机转速")
    private Integer airCompressorMotorSpeed;
    @ApiModelProperty("水泵实际转速")
    private Integer actualSpeedOfWaterPump;
    @ApiModelProperty("氢循环泵实际转速")
    private Integer actualSpeedOfHydrogenPump;
    @ApiModelProperty("电堆系统水压力")
    private BigDecimal waterPressureOfPileSystem;
    @ApiModelProperty("电堆系统氢气进气压力")
    private BigDecimal hydrogenInletPressureOfPileSystem;
    @ApiModelProperty("二级减压氢气进气压力")
    private BigDecimal secondaryHydrogenInletPressure;
    @ApiModelProperty("电堆氢气进气压力")
    private BigDecimal hydrogenInletPressureOfPile;
    @ApiModelProperty("电堆氢气压力降")
    private BigDecimal hydrogenPressureDropOfPile;
    @ApiModelProperty("电堆空气进气压力")
    private BigDecimal airInletPressureOfPile;
    @ApiModelProperty("大气压力")
    private Integer atmosphericPressure;
    @ApiModelProperty("燃电系统最大允许功率")
    private BigDecimal maxAllowablePowerOfFuelCellSystem;
    @ApiModelProperty("去离子水电导率")
    private BigDecimal conductivityOfDeionizedWater;
    @ApiModelProperty("电堆内部氢气开启请求")
    private Integer hydrogenOpeningRequestOfFuelCell;
    @ApiModelProperty("0x00：关闭         0x01：开启\n" +
            "0x02：信号错误     0x03：无效")
    @DictMapping(dictCode = "hydrogenOpeningRequestOfFuelCell",sourceField = "hydrogenOpeningRequestOfFuelCell")
    private String hydrogenOpeningRequestOfFuelCellStr;
    @ApiModelProperty("燃料电池系统端绝缘电阻值")
    private Integer insulationResistanceOfFuelCellSystem;
    @ApiModelProperty("烟雾监测状态")
    private Integer smokeMonitoringStatus;
    @ApiModelProperty("0x00：异常      0x01：正常")
    @DictMapping(dictCode = "smokeMonitoringStatus",sourceField = "smokeMonitoringStatus")
    private String smokeMonitoringStatusStr;
    @ApiModelProperty("空气流量")
    private BigDecimal airFlowRate;
    @ApiModelProperty("扩展报文40字节8")
    private Integer extendedMessage40_8;
    @ApiModelProperty("扩展报文41字节8")
    private Integer extendedMessage41_8;
    @ApiModelProperty("电堆系统入水温度")
    private Integer waterInletTemperatureOfPileSystem;
    @ApiModelProperty("电堆系统出水温度")
    private Integer waterOutletTemperatureOfPileSystem;
    @ApiModelProperty("压缩空气温度")
    private Integer compressedAirTemperature;
    @ApiModelProperty("系统辅件入水温度")
    private Integer waterInletTemperatureOfSystemAccessory;
    @ApiModelProperty("系统辅件出水温度")
    private Integer waterOutletTemperatureOfSystemAccessory;
    @ApiModelProperty("空压机温度")
    private Integer airCompressorTemperature;
    @ApiModelProperty("水泵温度")
    private Integer waterPumpTemperature;
    @ApiModelProperty("氢循环泵温度")
    private Integer hydrogenCirculationPumpTemperature;
    @ApiModelProperty("单电池电压最高值")
    private BigDecimal maxSingleBatteryVoltage;
    @ApiModelProperty("单电池电压最低值")
    private BigDecimal minSingleBatteryVoltage;
    @ApiModelProperty("单电池电压平均值")
    private BigDecimal aveSingleBatteryVoltage;
    @ApiModelProperty("FCU供电电压")
    private BigDecimal supplyVoltageOfFCU;
    @ApiModelProperty("系统氢气浓度传感器个数")
    private Integer numberOfHydrogenConcentrationSensors;
    @ApiModelProperty("氢瓶总数")
    private Integer numberOfHydrogenBottles;
    @ApiModelProperty("系统氢气浓度值列表")
    private List<Integer> systemHydrogenConcentrationList=new ArrayList<>();
    @ApiModelProperty("氢瓶温度值列表")
    private List<Integer> hydrogenBottleTemperatureList=new ArrayList<>();

}
