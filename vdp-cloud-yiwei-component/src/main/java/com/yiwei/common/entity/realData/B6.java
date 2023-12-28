package com.yiwei.common.entity.realData;

import com.yiwei.common.component.anotation.DictMapping;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class B6 {
    @Data
    public static class relayStatus5 {
        @ApiModelProperty("手刹状态")
        private String handBrakeStatus;
        @ApiModelProperty("手刹状态字典 0-释放; 1-刹车 254-异常,255-无效")
        @DictMapping(dictCode = "handBrakeStatus", sourceField = "handBrakeStatus")
        private String handBrakeStatusStr;
        @ApiModelProperty("MCU 就绪标志 ")
        private String mcuReadyFlag;
        @ApiModelProperty("整车就绪标志")
        private String vehicleReadySign;
        @ApiModelProperty("AC 启动开关 ")
        private String acStartSwitch;
        @ApiModelProperty("PTC 请求开关")
        private String ptcRequestSwitch;
        @ApiModelProperty("BMS 就绪标志")
        private String bmsReadyFlag;
        @ApiModelProperty("上装工作状态 ")
        private String uploadWorkingState;
        @ApiModelProperty("制动开关")
        private String brakeSwitch;
    }

    @Data
    public static class relayStatus6 {
        @ApiModelProperty("交流充电就绪标志")
        private String acChargeReadyFlag;
        @ApiModelProperty("高压上电完成标志")
        private String highVoltagePowerUpCompletionMark;
        @ApiModelProperty("整车漏电报警")
        private String fullVehicleLeakageAlarm;
        @ApiModelProperty("直流充电就绪标志:与充电机建立通信")
        private String dcChargingReadySignEstablishCommunicationWithCharger;
        @ApiModelProperty("上装水泵开关")
        private String uploadPumpSwitch;
        @ApiModelProperty("上装雾炮开关")
        private String uploadFogGunSwitch;
        @ApiModelProperty("充电完成标志")
        private String chargeCompletionMark;
        @ApiModelProperty("档位锁止标志")
        private String gearLockSign;
    }

    @Data
    public static class relayStatus3 {
        @ApiModelProperty("交流充电电阻继电器")
        private String acChargingResistanceRelay;
        @ApiModelProperty("DCDC 控制指令")
        private String dcdcControlInstructions;
        @ApiModelProperty("气泵 DCAC 控制指令 ")
        private String gasPumpDcacControlInstruction;
        @ApiModelProperty("油泵 DCAC 控制指令")
        private String oilPumpDcacControlInstruction;
        @ApiModelProperty("真空泵继电器控制")
        private String vacuumPumpRelayControl;
        @ApiModelProperty("ACC 继电器 ")
        private String accRelay;
        @ApiModelProperty("行车互锁继电器 ")
        private String drivingInterlockRelay;
        @ApiModelProperty("快充低压控制")
        private String fastChargingAndLowVoltageControl;
    }

    @ApiModelProperty("继电器状态5")
    private String relayStatus5Mask;
    private relayStatus5 relayStatus5;

    @Data
    public static class relayStatus4 {
        @ApiModelProperty("空调压缩机控制指令")
        private String airConditioningCompressorControlInstructions;
        @ApiModelProperty("MCU 低压继电器控制")
        private String mcuLowVoltageRelayControl;
        @ApiModelProperty("唤醒信号:插枪信号")
        private String wakeupSignalGunInsertionSignal;
        @ApiModelProperty("BMS 上下电指令")
        private String bmsPowerUpAndDownInstruction;
        @ApiModelProperty("钥匙 ON 档信号")
        private String keyOnSignal;
        @ApiModelProperty("BMS 向 VCU 发送的充电控 \n" +
                "制指令：反馈插枪信号")
        private String chargingControlSentByBmsToVcuDirectiveFeedbackInsertionSignal;
        @ApiModelProperty("VCU 允许 BMS 充电指令")
        private String vcuAllowBmsChargingInstruction;
        @ApiModelProperty("ABS 激活状态")
        private String absActivationState;
    }

    @Data
    public static class relayStatus7 {
        @ApiModelProperty("VCU 休眠允许标志")
        private String vcuSleepAllowFlag;
        @ApiModelProperty("真空泵工作状态 ")
        private String workingStateOfVacuumPump;
    }

    @ApiModelProperty("继电器状态2")
    private String relayStatus2Mask;
    private relayStatus2 relayStatus2;
    @ApiModelProperty("继电器状态4")
    private String relayStatus4Mask;
    private relayStatus4 relayStatus4;
    @ApiModelProperty("继电器状态6")
    private String relayStatus6Mask;
    private relayStatus6 relayStatus6;
    @ApiModelProperty("继电器状态7")
    private String relayStatus7Mask;
    private relayStatus7 relayStatus7;

    @Data
    public static class relayStatus1 {
        @ApiModelProperty("DCDC 低压继电器控制")
        private String dcdcLowVoltageRelayControl;
        @ApiModelProperty("主正继电器控制 ")
        private String masterAndPositiveRelayControl;
        @ApiModelProperty("DCDC 高压继电器控制")
        private String dcdcHighVoltageRelayControl;
        @ApiModelProperty("BMS 主负继电器控制")
        private String bmsPrimaryAndNegativeRelayControl;
        @ApiModelProperty("BMS 主正继电器控制")
        private String bmsMasterAndPositiveRelayControl;
        @ApiModelProperty("PTC 高压继电器控制 ")
        private String ptcHighVoltageRelayControl;
        @ApiModelProperty("主负继电器控制")
        private String primaryAndNegativeRelayControl;
        @ApiModelProperty("预充继电器控制")
        private String prechargingRelayControl;
    }

    @ApiModelProperty("继电器状态3")
    private String relayStatus3Mask;
    private relayStatus3 relayStatus3;

    @Data
    public static class relayStatus2 {
        @ApiModelProperty("上装水泵 DCAC 控制 ")
        private String uploadingPumpDcacControl;
        @ApiModelProperty("交流充电继电器控制")
        private String acChargingRelayControl;
        @ApiModelProperty("直流充电继电器控制")
        private String dcChargingRelayControl;
        @ApiModelProperty("空调压缩机高压继电器控制")
        private String highPressureRelayControlForAirConditioningCompressor;
        @ApiModelProperty("上装雾炮 DCAC 控制")
        private String dcacControlOfLoadingFogGun;
        @ApiModelProperty("水泵继电器控制")
        private String pumpRelayControl;
        @ApiModelProperty("散热风扇继电器控制")
        private String coolingFanRelayControl;
        @ApiModelProperty("空调压缩机低压继电器控制")
        private String lowVoltageRelayControlForAirConditioningCompressor;
    }

    @ApiModelProperty("继电器状态1")
    private String relayStatus1Mask;
    private relayStatus1 relayStatus1;
}
