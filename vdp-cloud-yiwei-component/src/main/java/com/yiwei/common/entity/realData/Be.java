package com.yiwei.common.entity.realData;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yiwei.common.component.anotation.DictMapping;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class Be {
    @ApiModelProperty("底盘品牌")
    private Integer chassisBrand;
    @ApiModelProperty("0x00：未知,0x01：壹为\n" +
            "0x02：东风股份,0x03：东风商用\n" +
            "0x04：比亚迪,0x05：上汽跃进\n" +
            "0x06：大运,0x07：北汽福田\n" +
            "0x08：河北长安")
    @DictMapping(dictCode = "chassisBrand",sourceField = "chassisBrand")
    private String chassisBrandStr;
    @ApiModelProperty("新能源类型")
    private Integer newEnergyType;
    @ApiModelProperty("0x00：未知,0x01：纯电动\n" +
            "0x02：氢燃料,0x03：混合动力（增程式）")
    @DictMapping(dictCode = "newEnergyType",sourceField = "newEnergyType")
    private String newEnergyTypeStr;
    @ApiModelProperty("电池布置方式")
    private Integer batteryArrangement;
    @ApiModelProperty("0x00：中置,0x01：后背\n" +
            "0x02：侧挂,0x03：其他")
    @DictMapping(dictCode = "batteryArrangement",sourceField = "batteryArrangement")
    private String batteryArrangementStr;
    @ApiModelProperty("总质量")
    private Integer totalMass;
    @ApiModelProperty("0x00：未知,0x01：2.7T\n" +
            "0x02：3.5T,0x03：4.3T\n" +
            "0x04：4.5T,0x05：7.3T\n" +
            "0x06：8.5T,0x07：9T\n" +
            "0x08：12T,0x09：18T\n" +
            "0x0A：25T,0x0B：32T,0x0C：49T")
    @DictMapping(dictCode = "totalMass",sourceField = "totalMass")
    private String totalMassStr;
    @ApiModelProperty("电池品牌")
    private Integer batteryBrand;
    @ApiModelProperty("0x00：未知 0x01：亿纬锂能\n" +
            "0x02：中航锂电 0x03：宁德时代\n" +
            "0x04：星盈 0x05：比克")
    @DictMapping(dictCode = "batteryBrand",sourceField = "batteryBrand")
    private String batteryBrandStr;
    @ApiModelProperty("PACK包总电量值")
    @JsonProperty("PACKTotalPowerValue")
    private BigDecimal PACKTotalPowerValue;
    @ApiModelProperty("动力单元总数")
    private Integer totalNumberOfPowerUnits;
    @ApiModelProperty("动力单元列表")
    private List<Be.PowerUnitInformation> powerUnitsList=new ArrayList<>();
    @Data
    public static class PowerUnitInformation {
        @ApiModelProperty("动力单元类型")
        private Integer powerUnitType;
        @ApiModelProperty("0x00：保留 0x01：风机动力单元\n" +
                "0x02：油泵动力单元 0x03：低压水泵动力单元\n" +
                "0x04：高压水泵动力单元 0x05：真空泵动力单元\n" +
                "0x06：雾炮水泵动力单元 0x07：一拖多动力单元")
        @DictMapping(dictCode = "powerUnitType", sourceField = "powerUnitType")
        private String powerUnitTypeStr;
        @ApiModelProperty("动力单元控制器（DCAC）软件版本")
        @JsonProperty("DCACSoftwareVersion")
        private String DCACSoftwareVersion;
        @ApiModelProperty("动力单元控制器（DCAC）供应商")
        @JsonProperty("DCACSupplier")
        private Integer DCACSupplier;
        @ApiModelProperty("0x00：壹为 0x01：蓝海华腾 0x02：西斯特\n" +
                "0x03：吉泰科 0x04：清泰科 0x05：理工通宇")
        @DictMapping(dictCode = "DCACSupplier",sourceField = "DCACSupplier")
        @JsonProperty("DCACSupplierStr")
        private String DCACSupplierStr;
        @ApiModelProperty("电机温度")
        private Integer motorTemperature;
        @ApiModelProperty("电控（ECU）温度")
        @JsonProperty("ECUTemperature")
        private Integer ECUTemperature;
        @ApiModelProperty("实际转速")
        private Integer actualSpeed;
        @ApiModelProperty("目标转速")
        private Integer targetSpeed;
        @ApiModelProperty("瞬时功率")
        private BigDecimal instantaneousPower;
        @ApiModelProperty("输入电压")
        private Integer inputVoltage;
        @ApiModelProperty("输入电流")
        private BigDecimal inputCurrent;
        @ApiModelProperty("动力单元状态")
        private Be.PowerUnitInformation.PowerUnitState powerUnitState;
        @Data
        public static class PowerUnitState{
            @ApiModelProperty("启停指令")
            private String startStopCommand;
            @ApiModelProperty("电机旋转方向")
            private String motorRotationDirection;
            @ApiModelProperty("部件状态")
            private String componentStatus;
            @ApiModelProperty("0b00:停机 0b01:故障 0b10:工作/运行\n" +
                    "0b11:其他")
            @DictMapping(dictCode = "componentStatus",sourceField = "componentStatus")
            private String componentStatusStr;
            @ApiModelProperty("动力单元类型")
            private String powerUnitTypeBit;
            @ApiModelProperty("0x00：保留 0x01：风机动力单元\n" +
                    "0x02：油泵动力单元 0x03：低压水泵动力单元\n" +
                    "0x04：高压水泵动力单元 0x05：真空泵动力单元\n" +
                    "0x06：雾炮水泵动力单元 0x07：一拖多动力单元")
            @DictMapping(dictCode = "powerUnitTypeBit",sourceField = "powerUnitTypeBit")
            private String powerUnitTypeBitStr;
        }
    }

    @ApiModelProperty("上装操作时间")
    private String upperOperationTime="2023-01-13 14:29:29";
    @ApiModelProperty("年")
    private Integer year;
    @ApiModelProperty("月")
    private Integer month;
    @ApiModelProperty("日")
    private Integer day;
    @ApiModelProperty("时")
    private Integer hour;
    @ApiModelProperty("分")
    private Integer min;
    @ApiModelProperty("秒")
    private Integer secede;
    @ApiModelProperty("中控屏软件版本")
    private String softwareVersionOfCentralControlScreen;
    @ApiModelProperty("上装控制器软件版本")
    private String  softwareVersionOfUpperControl;
    @ApiModelProperty("高压水泵压力")
    private BigDecimal hydroPumpPressure;
    @ApiModelProperty("液压油泵1压力")
    private BigDecimal hydraulicOilPumpPressure1;
    @ApiModelProperty("液压油泵2压力")
    private BigDecimal hydraulicOilPumpPressure2;;
    @ApiModelProperty("真空度对应压力")
    private BigDecimal vacuumDegreePressure;
    @ApiModelProperty("清水位高度对应压力")
    private BigDecimal waterLevelPressure;
    @ApiModelProperty("扩展报文 40（上装压力类）字节 7")
    private Integer extendedMessage40_7;
    @ApiModelProperty("扩展报文 40（上装压力类）字节 8")
    private Integer extendedMessage40_8;
    @ApiModelProperty("风机风量")
    private Integer fanAirVolume;
    @ApiModelProperty("油泵流量")
    private Integer hydraulicOilPumpFlow;
    @ApiModelProperty("低压水泵流量")
    private BigDecimal lowerHydroPumpFlow;
    @ApiModelProperty("高压水泵流量")
    private Integer hydroPumpFlow;
    @ApiModelProperty("真空抽速")
    private Integer vacuumPumpSpeed;
    @ApiModelProperty("雾炮喷雾流量")
    private BigDecimal sprayFlowRate;
    @ApiModelProperty("液压油温")
    private Integer hydraulicOilPumpTemperature;

    @ApiModelProperty("设定播放号")
    private Integer setPlayingNumber;
    @ApiModelProperty("设定播放音量")
    private Integer setPlayingVolume;
    @ApiModelProperty("实际播放号")
    private Integer actualPlayingNumber;
    @ApiModelProperty("实际播放音量")
    private Integer actualPlayingVolume;
    @ApiModelProperty("值12")
    private Be.Value12 value12;
    @Data
    public static class Value12{
        @ApiModelProperty("播放/停止控制")
        private String palyControl;
        @ApiModelProperty("单曲/顺序控制")
        private String loopControl;
    }
    @ApiModelProperty("值13")
    private Be.Value13 value13;
    @Data
    public static class Value13{
        @ApiModelProperty("音乐喇叭故障")
        private String musicHornFault;
        @ApiModelProperty("实际播放方式")
        private String actualPalyMode;
    }
    @ApiModelProperty("故障代码")
    private String faultCode;
    @ApiModelProperty("上装系统故障码")
    private String faultCodeOfUpper;
    @ApiModelProperty("累计作业电耗")
    private BigDecimal accumulatedPowerConsumption;
    @ApiModelProperty("本次作业电耗")
    private BigDecimal currentPowerConsumption;
    @ApiModelProperty("扩展报文47字节7,8")
    private Integer extendedMessage47_78;
    @ApiModelProperty("累计作业时间")
    private Float accumulatedOperationTime;
    @ApiModelProperty("本次作业时间")
    private Float currentOperationTime;
    @ApiModelProperty("扩展报文48字节7,8")
    private Integer extendedMessage48_78;

}
