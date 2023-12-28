package com.yiwei.common.entity.realData;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Bb {
    @ApiModelProperty("值8")
    private String value8Mask;
    @ApiModelProperty("后储气罐压力")
    private Integer rearStorageTankPressure;

    @Data
    public static class Value8 {
        @ApiModelProperty("数字量入110")
        private String numberEntry110;
        @ApiModelProperty("数字量入82")
        private String numberEntry82;
        @ApiModelProperty("数字量入91")
        private String numberEntry91;
        @ApiModelProperty("数字量入90")
        private String numberEntry90;
        @ApiModelProperty("数字量入86")
        private String numberEntry86;
        @ApiModelProperty("数字量入85")
        private String numberEntry85;
        @ApiModelProperty("数字量入84")
        private String numberEntry84;
        @ApiModelProperty("数字量入83")
        private String numberEntry83;
    }

    @ApiModelProperty("油泵DCAC故障代码")
    private String oilPumpDcacFaultCodeMask;
    @ApiModelProperty("累计充电电量")
    private Integer cumulativeChargeVolume;
    private String cumulativeChargeVolumeStr;
    @ApiModelProperty("前储气罐压力")
    private Integer frontStorageTankPressure;
    @ApiModelProperty("BMS程序版本")
    private String bmsProgramVersion;
    @ApiModelProperty("累计放电电量")
    private Integer cumulativeDischargeVolume;
    private String cumulativeDischargeVolumeStr;
    @ApiModelProperty("电机控制器输入电压")
    private Integer motorControllerInputVoltage;
    @ApiModelProperty("调试数据")
    private String debuggingData;

    @Data
    public static class Value9 {
        @ApiModelProperty("高边输出控制117")
        private String highEdgeOutputControl117;
        @ApiModelProperty("数字量入111")
        private String numberEntry111;
        @ApiModelProperty("数字量入112")
        private String numberEntry112;
        @ApiModelProperty("数字量入102")
        private String numberEntry102;
        @ApiModelProperty("高边输出控制114")
        private String highEdgeOutputControl114;
        @ApiModelProperty("数字量入103")
        private String numberEntry103;
        @ApiModelProperty("数字量入104")
        private String numberEntry104;
        @ApiModelProperty("数字量入94")
        private String numberEntry94;
    }

    @ApiModelProperty("值1")
    private String value11Mask;
    @ApiModelProperty("MCU程序版本")
    private String mcuProgramVersion;
    @ApiModelProperty("值9")
    private String value9Mask;

    private OilPumpDcacFaultCode oilPumpDcacFaultCode;

    @Data
    public static class OilPumpDcacFaultCode {
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
        @ApiModelProperty("霍尔故障")
        private String hallFault;
        @ApiModelProperty("油泵DCAC的运行状态")
        private String operationStatusOfOilPumpDcac;
        @ApiModelProperty("输入欠压")
        private String inputUndervoltage;
    }

    @ApiModelProperty("油泵DCAC温度")
    private Integer fuelPumpDcacTemperature;
    @ApiModelProperty("油泵DCAC输入电压")
    private Integer fuelPumpDcacInputVoltage;

    @Data
    public static class Value11 {
        @ApiModelProperty("高边输出控制119")
        private String highEdgeOutputControl119;
        @ApiModelProperty("低边输出控制61")
        private String lowEdgeOutputControl61;
        @ApiModelProperty("低边输出控制62")
        private String lowEdgeOutputControl62;
        @ApiModelProperty("低边输出控制81")
        private String lowEdgeOutputControl81;
        @ApiModelProperty("延时断电输出控制80")
        private String delayedOutputControl80;
        @ApiModelProperty("高边输出控制120")
        private String highEdgeOutputControl120;
    }

    @Data
    public static class Value10 {
        @ApiModelProperty("高边输出控制115")
        private String highEdgeOutputControl115;
        @ApiModelProperty("高边输出控制118")
        private String highEdgeOutputControl118;
        @ApiModelProperty("高边输出控制88")
        private String highEdgeOutputControl88;
        @ApiModelProperty("高边输出控制114")
        private String highEdgeOutputControl114;
        @ApiModelProperty("高边输出控制89")
        private String highEdgeOutputControl89;
        @ApiModelProperty("高边输出控制121")
        private String highEdgeOutputControl121;
        @ApiModelProperty("高边输出控制96")
        private String highEdgeOutputControl96;
        @ApiModelProperty("高边输出控制97")
        private String highEdgeOutputControl97;
    }

    @ApiModelProperty("值10")
    private String value10Mask;

    private Value8 value8;
    private Value9 value9;
    private Value10 value10;
    private Value11 value11;
}
