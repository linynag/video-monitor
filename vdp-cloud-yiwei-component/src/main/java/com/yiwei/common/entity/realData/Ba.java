package com.yiwei.common.entity.realData;

import com.yiwei.common.component.anotation.DictMapping;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Ba {
    @ApiModelProperty("BMS高压控制命令")
    private Integer bmsHighVoltageControlCommand;
    @ApiModelProperty("0:下高压电 1,上高压电 254,异常 255,无效")
    @DictMapping(dictCode = "bmsHighVoltageControlCommand", sourceField = "bmsHighVoltageControlCommand")
    private String bmsHighVoltageControlCommandStr;

    private whetherToGenerateWorkOrderFlag whetherToGenerateWorkOrderFlag;

    @Data
    public static class whetherToGenerateWorkOrderFlag {
        @ApiModelProperty("工单故障码2生成标志")
        private String workOrderFaultCode2GenerationFlag;
        @ApiModelProperty("工单故障码1生成标志")
        private String workOrderFailureCode1GenerationFlag;
        @ApiModelProperty("工单故障码3生成标志")
        private String workListFailureCode3GenerationFlag;
        @ApiModelProperty("工单故障码4生成标志")
        private String workOrderFailureCode4GenerationFlag;
    }

    @ApiModelProperty("BMS第三高温度")
    private Integer bmsThirdHighTemperature;
    @ApiModelProperty("工单故障码1")
    private String workOrderFailureCode1;
    @ApiModelProperty("VCU休眠控制指令")
    private Integer vcuSleepControlInstruction;
    @ApiModelProperty("0:无效 1,有效 254,异常 255,无效")
    @DictMapping(dictCode = "vcuSleepControlInstruction", sourceField = "vcuSleepControlInstruction")
    private String vcuSleepControlInstructionStr;
    @ApiModelProperty("BMS第三高温度模块编号")
    private Integer bms3rdHighTemperatureModuleNumber;
    @ApiModelProperty("BMS交流充电状态")
    private Integer bmsAcChargingStatus;
    @ApiModelProperty("1：待机，OBC 高压输入已完成， \n" +
            "等待充电指令 \n" +
            " 2：恒流充电，OBC 恒流工作 \n" +
            " 3：恒压充电，OBC 恒压工作 \n" +
            " 4：充电完成，OBC 充电完成 \n" +
            " 5：休眠，OBC 进入休眠 \n" +
            " 6：故障，OBC 检测到有故障发生\n" +
            "254:异常 255:无效")
    @DictMapping(dictCode = "bmsAcChargingStatus", sourceField = "bmsAcChargingStatus")
    private String bmsAcChargingStatusStr;
    @ApiModelProperty("BMS发送的休眠控制指令")
    private Integer hibernationControlInstructionsSentByBms;
    @ApiModelProperty("BMS第二高温度")
    private Integer bmsSecondHighTemperature;
    @ApiModelProperty("BMS直流充电状态")
    private Integer bmsDcChargingStatus;
    @ApiModelProperty("1：物理连接完成 \n" +
            "2：低压辅助上电 \n" +
            "3：充电握手阶段 \n" +
            "4：充电参数配置阶段 \n" +
            "5：充电阶段 \n" +
            "6：充电结束阶段 \n" +
            "254:异常  255:无效")
    @DictMapping(dictCode = "bmsDcChargingStatus", sourceField = "bmsDcChargingStatus")
    private String bmsDcChargingStatusStr;
    @ApiModelProperty("VCU高压反馈状态")
    private Integer vcuHighVoltageFeedbackStatus;
    @ApiModelProperty("0:外部高压回路断开 1:外部高压回路闭合  254:异常 255:无效")
    @DictMapping(dictCode = "vcuHighVoltageFeedbackStatus", sourceField = "vcuHighVoltageFeedbackStatus")
    private String vcuHighVoltageFeedbackStatusStr;
    @ApiModelProperty("工单故障码3")
    private String workOrderFailureCode3;
    @ApiModelProperty("工单故障码2")
    private String workOrderFailureCode2;
    @ApiModelProperty("工单故障码4")
    private String workOrderFailureCode4;
    @ApiModelProperty("BMS第四高温度")
    private Integer bms4thHighTemperature;
    @ApiModelProperty("BMS最高温度模块编号")
    private Integer bmsMaximumTemperatureModuleNumber;
    @ApiModelProperty("是否生成工单标志")
    private String whetherToGenerateWorkOrderFlagMask;
    @ApiModelProperty("BMS第四高温度模块编号")
    private Integer bms4thHighTemperatureModuleNumber;
    @ApiModelProperty("BMS第二高温度模块编号")
    private Integer bmsSecondHighTemperatureModuleNumber;
    @ApiModelProperty("电池高压回路状态")
    private Integer batteryHighVoltageLoopStatus;
    @ApiModelProperty("0:回路断开 1,回路闭合 254,异常 255,无效")
    @DictMapping(dictCode = "batteryHighVoltageLoopStatus", sourceField = "batteryHighVoltageLoopStatus")
    private String batteryHighVoltageLoopStatusStr;
}
