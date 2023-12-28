package com.yiwei.common.entity;

import com.yiwei.common.component.anotation.WddyQueryBms;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@ApiModel("三级报警为最高等级报警-配置参数")
public class AlarmConfigWddyVO {

    @ApiModelProperty("累计充电容量")
    @WddyQueryBms(bytelength = 4,precision = 0.1,offset = 0,sort = 1)
    private BigDecimal totalChargeCapacity;

    @ApiModelProperty("温度过低报警消除")
    @WddyQueryBms(bytelength = 1,precision = 1,offset = -50,sort = 2)
    private Integer temperatureLowAlarmOff;

    @ApiModelProperty("温度过低一级报警")
    @WddyQueryBms(bytelength = 1,precision = 1,offset = -50,sort = 3)
    private Integer temperatureLowAlarmOne;

    @ApiModelProperty("温度过低二级报警")
    @WddyQueryBms(bytelength = 1,precision = 1,offset = -50,sort = 4)
    private Integer temperatureLowAlarmTwo;

    @ApiModelProperty("温度过低三级报警")
    @WddyQueryBms(bytelength = 1,precision = 1,offset = -50,sort = 5)
    private Integer temperatureLowAlarmThree;

    @ApiModelProperty("温度过高报警消除")
    @WddyQueryBms(bytelength = 1,precision = 1,offset = -50,sort = 6)
    private Integer temperatureHighAlarmOff;

    @ApiModelProperty("温度过高一级报警")
    @WddyQueryBms(bytelength = 1,precision = 1,offset = -50,sort = 7)
    private Integer temperatureHighAlarmOne;

    @ApiModelProperty("温度过高二级报警")
    @WddyQueryBms(bytelength = 1,precision = 1,offset = -50,sort = 8)
    private Integer temperatureHighAlarmTwo;

    @ApiModelProperty("温度过高三级报警")
    @WddyQueryBms(bytelength = 1,precision = 1,offset = -50,sort = 9)
    private Integer temperatureHighAlarmThree;

    @ApiModelProperty("单体过低报警消除")
    @WddyQueryBms(bytelength = 2,precision = 1,offset = 0,sort = 10)
    private Integer monomerLowAlarmOff;

    @ApiModelProperty("单体过低一级报警")
    @WddyQueryBms(bytelength = 2,precision = 1,offset = 0,sort = 11)
    private Integer monomerLowAlarmOne;

    @ApiModelProperty("单体过低二级报警")
    @WddyQueryBms(bytelength = 2,precision = 1,offset = 0,sort = 12)
    private Integer monomerLowAlarmTwo;

    @ApiModelProperty("单体过低三级报警")
    @WddyQueryBms(bytelength = 2,precision = 1,offset = 0,sort = 13)
    private Integer monomerLowAlarmThree;

    @ApiModelProperty("单体过高报警消除")
    @WddyQueryBms(bytelength = 2,precision = 1,offset = 0,sort = 14)
    private Integer monomerHighAlarmOff;

    @ApiModelProperty("单体过高一级报警")
    @WddyQueryBms(bytelength = 2,precision = 1,offset = 0,sort = 15)
    private Integer monomerHighAlarmOne;

    @ApiModelProperty("单体过高二级报警")
    @WddyQueryBms(bytelength = 2,precision = 1,offset = 0,sort = 16)
    private Integer monomerHighAlarmTwo;

    @ApiModelProperty("单体过高三级报警")
    @WddyQueryBms(bytelength = 2,precision = 1,offset = 0,sort = 17)
    private Integer monomerHighAlarmThree;

    @ApiModelProperty("总压过低报警消除")
    @WddyQueryBms(bytelength = 2,precision = 0.1,offset = 0,sort = 18)
    private BigDecimal voltageLowAlarmOff;

    @ApiModelProperty("总压过低一级报警")
    @WddyQueryBms(bytelength = 2,precision = 0.1,offset = 0,sort = 19)
    private BigDecimal voltageLowAlarmOne;

    @ApiModelProperty("总压过低二级报警")
    @WddyQueryBms(bytelength = 2,precision = 0.1,offset = 0,sort = 20)
    private BigDecimal voltageLowAlarmTwo;

    @ApiModelProperty("总压过低三级报警")
    @WddyQueryBms(bytelength = 2,precision = 0.1,offset = 0,sort = 21)
    private BigDecimal voltageLowAlarmThree;

    @ApiModelProperty("总压过高报警消除")
    @WddyQueryBms(bytelength = 2,precision = 0.1,offset = 0,sort = 22)
    private BigDecimal voltageHighAlarmOff;

    @ApiModelProperty("总压过高一级报警")
    @WddyQueryBms(bytelength = 2,precision = 0.1,offset = 0,sort = 23)
    private BigDecimal voltageHighAlarmOne;

    @ApiModelProperty("总压过高二级报警")
    @WddyQueryBms(bytelength = 2,precision = 0.1,offset = 0,sort = 24)
    private BigDecimal voltageHighAlarmTwo;

    @ApiModelProperty("总压过高三级报警")
    @WddyQueryBms(bytelength = 2,precision = 0.1,offset = 0,sort = 25)
    private BigDecimal voltageHighAlarmThree;

    @ApiModelProperty("放电过流报警消除")
    @WddyQueryBms(bytelength = 2,precision = 0.1,offset = 0,sort = 26)
    private BigDecimal electricDischargeAlarmOff;

    @ApiModelProperty("放电过流一级报警")
    @WddyQueryBms(bytelength = 2,precision = 0.1,offset = 0,sort = 27)
    private BigDecimal electricDischargeAlarmOne;

    @ApiModelProperty("放电过流二级报警")
    @WddyQueryBms(bytelength = 2,precision = 0.1,offset = 0,sort = 28)
    private BigDecimal electricDischargeAlarmTwo;

    @ApiModelProperty("放电过流三级报警")
    @WddyQueryBms(bytelength = 2,precision = 0.1,offset = 0,sort = 29)
    private BigDecimal electricDischargeAlarmThree;

    @ApiModelProperty("充电过流报警消除")
    @WddyQueryBms(bytelength = 2,precision = 0.1,offset = 0,sort = 30)
    private BigDecimal electricChargeAlarmOff;

    @ApiModelProperty("充电过流一级报警")
    @WddyQueryBms(bytelength = 2,precision = 0.1,offset = 0,sort = 31)
    private BigDecimal electricChargeAlarmOne;

    @ApiModelProperty("充电过流二级报警")
    @WddyQueryBms(bytelength = 2,precision = 0.1,offset = 0,sort = 32)
    private BigDecimal electricChargeAlarmTwo;

    @ApiModelProperty("充电过流三级报警")
    @WddyQueryBms(bytelength = 2,precision = 0.1,offset = 0,sort = 33)
    private BigDecimal electricChargeAlarmThree;

    @ApiModelProperty("回馈过流报警消除")
    @WddyQueryBms(bytelength = 2,precision = 0.1,offset = 0,sort = 34)
    private BigDecimal electricFeedbackAlarmOff;

    @ApiModelProperty("回馈过流一级报警")
    @WddyQueryBms(bytelength = 2,precision = 0.1,offset = 0,sort = 35)
    private BigDecimal electricFeedbackAlarmOne;

    @ApiModelProperty("回馈过流二级报警")
    @WddyQueryBms(bytelength = 2,precision = 0.1,offset = 0,sort = 36)
    private BigDecimal electricFeedbackAlarmTwo;

    @ApiModelProperty("回馈过流三级报警")
    @WddyQueryBms(bytelength = 2,precision = 0.1,offset = 0,sort = 37)
    private BigDecimal electricFeedbackAlarmThree;

    @ApiModelProperty("压差过大报警消除")
    @WddyQueryBms(bytelength = 2,precision = 1,offset = 0,sort = 38)
    private Integer voltageDifferGreatAlarmOff;

    @ApiModelProperty("压差过大一级报警")
    @WddyQueryBms(bytelength = 2,precision = 1,offset = 0,sort = 39)
    private Integer voltageDifferGreatAlarmOne;

    @ApiModelProperty("压差过大二级报警")
    @WddyQueryBms(bytelength = 2,precision = 1,offset = 0,sort = 40)
    private Integer voltageDifferGreatAlarmTwo;

    @ApiModelProperty("压差过大三级报警")
    @WddyQueryBms(bytelength = 2,precision = 1,offset = 0,sort = 41)
    private Integer voltageDifferGreatAlarmThree;

    @ApiModelProperty("温差过大报警消除")
    @WddyQueryBms(bytelength = 1,precision = 1,offset = 0,sort = 42)
    private Integer temperatureDifferGreatAlarmOff;

    @ApiModelProperty("温差过大一级报警")
    @WddyQueryBms(bytelength = 1,precision = 1,offset = 0,sort = 43)
    private Integer temperatureDifferGreatAlarmOne;

    @ApiModelProperty("温差过大二级报警")
    @WddyQueryBms(bytelength = 1,precision = 1,offset = 0,sort = 44)
    private Integer temperatureDifferGreatAlarmTwo;

    @ApiModelProperty("温差过大三级报警")
    @WddyQueryBms(bytelength = 1,precision = 1,offset = 0,sort = 45)
    private Integer temperatureDifferGreatAlarmThree;

    @ApiModelProperty("SOC 过低报警消除")
    @WddyQueryBms(bytelength = 1,precision = 0.5,offset = 0,sort = 46)
    private BigDecimal socLowAlarmOff;

    @ApiModelProperty("SOC 过低一级报警")
    @WddyQueryBms(bytelength = 1,precision = 0.5,offset = 0,sort = 47)
    private BigDecimal socLowAlarmOne;

    @ApiModelProperty("SOC 过低二级报警")
    @WddyQueryBms(bytelength = 1,precision = 0.5,offset = 0,sort = 48)
    private BigDecimal socLowAlarmTwo;

    @ApiModelProperty("SOC 过低三级报警")
    @WddyQueryBms(bytelength = 1,precision = 0.5,offset = 0,sort = 49)
    private BigDecimal socLowAlarmThree;

    @ApiModelProperty("绝缘一级报警")
    @WddyQueryBms(bytelength = 2,precision = 1,offset = 0,sort = 50)
    private Integer insulationAlarmOne;

    @ApiModelProperty("绝缘二级报警")
    @WddyQueryBms(bytelength = 2,precision = 1,offset = 0,sort = 51)
    private Integer insulationAlarmTwo;

    @ApiModelProperty("绝缘三级报警")
    @WddyQueryBms(bytelength = 2,precision = 1,offset = 0,sort = 52)
    private Integer insulationAlarmThree;

    @ApiModelProperty("充电循环次数")
    @WddyQueryBms(bytelength = 2,precision = 1,offset = 0,sort = 53)
    private Integer chargeCircleCount;

    @ApiModelProperty("电池循环寿命")
    @WddyQueryBms(bytelength = 2,precision = 1,offset = 0,sort = 54)
    private Integer chargeCircleLive;

    @ApiModelProperty("电池类型")
    @WddyQueryBms(bytelength = 1,precision = 1,offset = 0,sort = 55)
    private Integer batteryType;

    @ApiModelProperty("电池内阻")
    @WddyQueryBms(bytelength = 2,precision = 0.001,offset = 0,sort = 56)
    private BigDecimal batteryInternalResistance;

    @ApiModelProperty("电芯额定电压")
    @WddyQueryBms(bytelength = 2,precision = 1,offset = 0,sort = 57)
    private Integer cellRatedVoltage;

    @ApiModelProperty("单体上限电压")
    @WddyQueryBms(bytelength = 2,precision = 1,offset = 0,sort = 58)
    private Integer monomerCeilingVoltage;

    @ApiModelProperty("单体下限电压")
    @WddyQueryBms(bytelength = 2,precision = 1,offset = 0,sort = 59)
    private Integer monomerFloorVoltage;

    @ApiModelProperty("SOC 上限")
    @WddyQueryBms(bytelength = 1,precision = 0.5,offset = 0,sort = 60)
    private BigDecimal socCeiling;

    @ApiModelProperty("SOC 下限")
    @WddyQueryBms(bytelength = 1,precision = 0.5,offset = 0,sort = 61)
    private BigDecimal socFloor;

}
