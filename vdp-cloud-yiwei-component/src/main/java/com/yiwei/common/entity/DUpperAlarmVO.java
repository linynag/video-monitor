package com.yiwei.common.entity;

import com.yiwei.common.component.anotation.DictMapping;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("上装故障信息")
@Data
public class DUpperAlarmVO {
    @ApiModelProperty("整车类型")
    private Integer vehicleType=0;
    @ApiModelProperty("0x00:未知 0x01:洒水车 0x02:抑尘车 0x03:高压清洗车 0x04:路面养护车 0x05:护栏清洗车\n" +
            "0x06:洗扫车 0x07:吸尘车 0x08:扫路车 0x09:吸污吸粪车 0x0A:餐厨垃圾车 0x0B:勾臂车\n" +
            "0x0C:桶装垃圾车 0x0D:压缩垃圾车 0x0E:自装卸式垃圾车（船形）\n" +
            "0x0F:自卸式垃圾车 0x10:自装卸式垃圾车（侧挂） 0x11:搅拌车")
    @DictMapping(dictCode = "vehicleType",sourceField = "vehicleType")
    private String vehicleTypeStr="";

    @ApiModelProperty(value = "中控屏通信故障")
    private Integer centerControlPanel=0;
    @ApiModelProperty(value = "音乐喇叭通信故障")
    private Integer musicalHorn=0;
    @ApiModelProperty(value = "上装控制器")
    private Integer topController =0;
    @ApiModelProperty(value = "VCU通信故障")
    private Integer vehicleController=0;
    @ApiModelProperty(value = "硅胶面板通信故障")
    private Integer siliconePanel=0;
    @ApiModelProperty(value = "无线遥控器通信故障")
    private Integer remoteController=0;
//    @ApiModelProperty(value = "液压压力传感器")
//    private Integer hydraulicPressureSensor=0;

    @ApiModelProperty(value = "高压水压压力传感器")
    private Integer highPressureWaterPressureSensor=0;

    @ApiModelProperty(value = "清水位高度压力传感器")
    private Integer clearWaterLevelPressureSensor=0;

    @ApiModelProperty(value = "真空压力传感器")
    private Integer vacuumPressureSensor=0;

    @ApiModelProperty(value = "接近开关1故障")
    private Integer proximitySwitch1=0;
    @ApiModelProperty(value = "接近开关2故障")
    private Integer proximitySwitch2=0;
    @ApiModelProperty(value = "接近开关3故障")
    private Integer proximitySwitch3=0;
    @ApiModelProperty(value = "接近开关4故障")
    private Integer proximitySwitch4=0;
    @ApiModelProperty(value = "接近开关5故障")
    private Integer proximitySwitch5=0;
    @ApiModelProperty(value = "接近开关6故障")
    private Integer proximitySwitch6=0;
    @ApiModelProperty(value = "接近开关7故障")
    private Integer proximitySwitch7=0;
    @ApiModelProperty(value = "接近开关8故障")
    private Integer proximitySwitch8=0;
    @ApiModelProperty(value = "接近开关9故障")
    private Integer proximitySwitch9=0;

    @ApiModelProperty(value = "各种DCAC")
    private Integer hasDCAC=0;
    @ApiModelProperty(value = "风机DCAC")
    private Integer airBlowerDCAC=0;
    @ApiModelProperty(value = "低压水泵DCAC")
    private Integer lowPressurePumpDCAC=0;
    @ApiModelProperty(value = "油泵DCAC")
    private Integer oilPumpDCAC=0;
    @ApiModelProperty(value = "高压水泵DCAC")
    private Integer highPressureWaterPumpDCAC=0;
    @ApiModelProperty(value = "其他DCAC")
    private Integer otherDCAC=0;
    //    洒水车
    @ApiModelProperty(value = "液位传感器")
    private Integer liquidLevelSensor=0;
    @ApiModelProperty(value = "液压传感器")
    private Integer hydraulicSensor=0;
    @ApiModelProperty(value = "污水位开关")
    private Integer sewageLevelSwitch=0;
    @ApiModelProperty(value = "液位开关")
    private Integer liquidLevelSwitch=0;
    @ApiModelProperty(value = "接近开关(后门)")
    private Integer proximitySwitchUpper=0;
    @ApiModelProperty(value = "接近开关(支撑杆)")
    private Integer proximitySwitchDown=0;
    @ApiModelProperty(value = "接近开关")
    private Integer proximitySwitch=0;

    //    压缩车
    @ApiModelProperty(value = "推铲回位到位")
    private Integer pushShovelBack=0;
    @ApiModelProperty(value = "填料器举升到位")
    private Integer fillerLift=0;
    @ApiModelProperty(value = "填料器下降到位")
    private Integer fillerDown=0;
    @ApiModelProperty(value = "刮板开到位")
    private Integer scraperOpen=0;
    @ApiModelProperty(value = "刮板闭到位")
    private Integer scraperClose=0;
    @ApiModelProperty(value = "滑板上升到位")
    private Integer skateboardAscent=0;
    @ApiModelProperty(value = "滑板下降到位")
    private Integer skateboardDescent=0;



}