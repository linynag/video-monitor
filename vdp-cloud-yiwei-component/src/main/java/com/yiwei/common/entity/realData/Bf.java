package com.yiwei.common.entity.realData;

import com.yiwei.common.component.anotation.DictMapping;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Bf {
    @ApiModelProperty("整车类型")
    private Integer vehicleType;
    @ApiModelProperty("0x00:未知 0x01:洒水车 0x02:抑尘车 0x03:高压清洗车 0x04:路面养护车 0x05:护栏清洗车\n" +
            "0x06:洗扫车 0x07:吸尘车 0x08:扫路车 0x09:吸污吸粪车 0x0A:餐厨垃圾车 0x0B:勾臂车\n" +
            "0x0C:桶装垃圾车 0x0D:压缩垃圾车 0x0E:自装卸式垃圾车（船形）\n" +
            "0x0F:自卸式垃圾车 0x10:自装卸式垃圾车（侧挂） 0x11:搅拌车")
    @DictMapping(dictCode = "vehicleType",sourceField = "vehicleType")
    private String vehicleTypeStr;
    @ApiModelProperty("遥控器按键初始状态值")
    private Bf.RemoteControlInitialValue remoteControlInitialValue;
    @Data
    public static class RemoteControlInitialValue{
        @ApiModelProperty("键1")
        private String button1;
        @ApiModelProperty("键2")
        private String button2;
        @ApiModelProperty("键3")
        private String button3;
        @ApiModelProperty("键4")
        private String button4;
        @ApiModelProperty("键5")
        private String button5;
        @ApiModelProperty("键6")
        private String button6;
        @ApiModelProperty("键7")
        private String button7;
        @ApiModelProperty("键8")
        private String button8;
        @ApiModelProperty("键9")
        private String button9;
        @ApiModelProperty("键10")
        private String button10;
        @ApiModelProperty("键11")
        private String button11;
        @ApiModelProperty("键12")
        private String button12;
        @ApiModelProperty("键13")
        private String button13;
        @ApiModelProperty("键14")
        private String button14;
        @ApiModelProperty("键15")
        private String button15;
        @ApiModelProperty("键16")
        private String button16;
    }
    @ApiModelProperty("遥控器按键对应功能")
    private Bf.RemoteControlFunction remoteControlFunction;
    @Data
    public static class RemoteControlFunction{
        @ApiModelProperty("键1Str")
        private String button1Str;
        @ApiModelProperty("键2Str")
        private String button2Str;
        @ApiModelProperty("键3Str")
        private String button3Str;
        @ApiModelProperty("键4Str")
        private String button4Str;
        @ApiModelProperty("键5Str")
        private String button5Str;
        @ApiModelProperty("键6Str")
        private String button6Str;
        @ApiModelProperty("键7Str")
        private String button7Str;
        @ApiModelProperty("键8Str")
        private String button8Str;
        @ApiModelProperty("键9Str")
        private String button9Str;
        @ApiModelProperty("键10Str")
        private String button10Str;
        @ApiModelProperty("键11Str")
        private String button11Str;
        @ApiModelProperty("键12Str")
        private String button12Str;
        @ApiModelProperty("键13Str")
        private String button13Str;
        @ApiModelProperty("键14Str")
        private String button14Str;
        @ApiModelProperty("键15Str")
        private String button15Str;
        @ApiModelProperty("键16Str")
        private String button16Str;
    }
    @ApiModelProperty("硅胶面板按键原始状态")
    private Bf.SiliconePanelInitialValue siliconePanelInitialValue;
    @Data
    public static class SiliconePanelInitialValue{
        @ApiModelProperty("键A1")
        private String buttonA1;
        @ApiModelProperty("键B1")
        private String buttonB1;
        @ApiModelProperty("键C1")
        private String buttonC1;
        @ApiModelProperty("键D1")
        private String buttonD1;
        @ApiModelProperty("键A2")
        private String buttonA2;
        @ApiModelProperty("键B2")
        private String buttonB2;
        @ApiModelProperty("键C2")
        private String buttonC2;
        @ApiModelProperty("键D2")
        private String buttonD2;
        @ApiModelProperty("键A3")
        private String buttonA3;
        @ApiModelProperty("键B3")
        private String buttonB3;
        @ApiModelProperty("键C3")
        private String buttonC3;
        @ApiModelProperty("键D3")
        private String buttonD3;
        @ApiModelProperty("键A4")
        private String buttonA4;
        @ApiModelProperty("键B4")
        private String buttonB4;
        @ApiModelProperty("键C4")
        private String buttonC4;
        @ApiModelProperty("键D4")
        private String buttonD4;
    }
    @ApiModelProperty("硅胶面板按键对应功能")
    private Bf.SiliconePanelFunction siliconePanelFunction;
    @Data
    public static class SiliconePanelFunction{
        @ApiModelProperty("键A1Str")
        private String buttonA1Str;
        @ApiModelProperty("键B1Str")
        private String buttonB1Str;
        @ApiModelProperty("键C1Str")
        private String buttonC1Str;
        @ApiModelProperty("键D1Str")
        private String buttonD1Str;
        @ApiModelProperty("键A2Str")
        private String buttonA2Str;
        @ApiModelProperty("键B2Str")
        private String buttonB2Str;
        @ApiModelProperty("键C2Str")
        private String buttonC2Str;
        @ApiModelProperty("键D2Str")
        private String buttonD2Str;
        @ApiModelProperty("键A3Str")
        private String buttonA3Str;
        @ApiModelProperty("键B3Str")
        private String buttonB3Str;
        @ApiModelProperty("键C3Str")
        private String buttonC3Str;
        @ApiModelProperty("键D3Str")
        private String buttonD3Str;
        @ApiModelProperty("键A4Str")
        private String buttonA4Str;
        @ApiModelProperty("键B4Str")
        private String buttonB4Str;
        @ApiModelProperty("键C4Str")
        private String buttonC4Str;
        @ApiModelProperty("键D4Str")
        private String buttonD4Str;
    }
    @ApiModelProperty("输入信号")
    private Bf.InputSignal inputSignal;
    @Data
    public static class InputSignal{
        @ApiModelProperty("外部输入高压上电完成")
        private String inputSignal0;
        @ApiModelProperty("左转信号")
        private String inputSignal1;
        @ApiModelProperty("右转信号")
        private String inputSignal2;
        @ApiModelProperty("倒挡信号")
        private String inputSignal3;
        @ApiModelProperty("冷却液报警（风机）")
        private String inputSignal4;
        @ApiModelProperty("冷却液报警（油泵）")
        private String inputSignal5;
        @ApiModelProperty("冷却液报警\n" +
                "(低压水泵)")
        private String inputSignal6;
        @ApiModelProperty("冷却液报警\n" +
                "(高压水泵)")
        private String inputSignal7;
        @ApiModelProperty("冷却液报警\n" +
                "(其他动力)")
        private String inputSignal8;
        @ApiModelProperty("清水箱报警")
        private String inputSignal9;
        @ApiModelProperty("雾炮左转到位信号")
        private String inputSignal10;
        @ApiModelProperty("雾炮右转到位信号")
        private String inputSignal11;
        @ApiModelProperty("雾炮上升到位信号")
        private String inputSignal12;
        @ApiModelProperty("雾炮下降到位信号")
        private String inputSignal13;
        @ApiModelProperty("后喷雾操作开关")
        private String inputSignal14;
        @ApiModelProperty("后喷雾水阀打开信号")
        private String inputSignal15;
    }
    @ApiModelProperty("通用输出")
    private Bf.GeneralOutput generalOutput;
    @Data
    public static class GeneralOutput{
        @ApiModelProperty("对外输出高压上电请求")
        private String outputHighTensionPowerOn;
        @ApiModelProperty("传感器供电")
        private String sensorSupply;
        @ApiModelProperty("音乐喇叭供电")
        private String musicLoudspeakerSupply;
        @ApiModelProperty("风机单元风扇启动")
        private String fanStartUp;
        @ApiModelProperty("低压水泵风扇启动")
        private String lowerHydroPumpFan;
        @ApiModelProperty("左箭头灯")
        private String leftHeadlight;
        @ApiModelProperty("右箭头灯")
        private String rightHeadlight;
        @ApiModelProperty("工作灯")
        private String workLamp;
    }
    @ApiModelProperty("专用输出1")
    private Bf.SpecialOutput1 specialOutput1;
    @Data
    public static class SpecialOutput1{
        @ApiModelProperty("左前洒/冲水")
        private String specialOutput1_1;
        @ApiModelProperty("右前洒/冲水")
        private String specialOutput1_2;
        @ApiModelProperty("左后洒/冲水")
        private String specialOutput1_3;
        @ApiModelProperty("右后洒/冲水")
        private String specialOutput1_4;
        @ApiModelProperty("左右前角喷杆喷水")
        private String specialOutput1_5;
        @ApiModelProperty("绕盘喷水")
        private String specialOutput1_6;
        @ApiModelProperty("前喷架喷水")
        private String specialOutput1_7;
        @ApiModelProperty("高压水路卸荷阀")
        private String specialOutput1_8;
    }
    @ApiModelProperty("专用输出2")
    private Bf.SpecialOutput2 specialOutput2;
    @Data
    public static class SpecialOutput2{
        @ApiModelProperty("前喷架上行")
        private String specialOutput2_1;
        @ApiModelProperty("前喷架下行")
        private String specialOutput2_2;
        @ApiModelProperty("前喷架左转")
        private String specialOutput2_3;
        @ApiModelProperty("前喷架右转")
        private String specialOutput2_4;
        @ApiModelProperty("左右前喷杆伸出")
        private String specialOutput2_5;
        @ApiModelProperty("左右前喷杆缩回")
        private String specialOutput2_6;
        @ApiModelProperty("后喷雾喷水")
        private String specialOutput2_7;
        @ApiModelProperty("预留1（右前角/警示灯）")
        private String specialOutput2_8;
    }
    @ApiModelProperty("专用输出3")
    private Bf.SpecialOutput3 specialOutput3;
    @Data
    public static class SpecialOutput3{
        @ApiModelProperty("高压水左喷杆喷水")
        private String specialOutput3_1;
        @ApiModelProperty("高压水右喷角")
        private String specialOutput3_2;
        @ApiModelProperty("高压水左喷角")
        private String specialOutput3_3;
        @ApiModelProperty("高压水吸嘴喷水")
        private String specialOutput3_4;
        @ApiModelProperty("高压水泵离合")
        private String specialOutput3_5;
        @ApiModelProperty("箱体自洁")
        private String specialOutput3_6;
        @ApiModelProperty("喷淋泵水阀")
        private String specialOutput3_7;
        @ApiModelProperty("吸嘴喷淋泵")
        private String specialOutput3_8;
    }
    @ApiModelProperty("专用输出4")
    private Bf.SpecialOutput4 specialOutput4;
    @Data
    public static class SpecialOutput4{
        @ApiModelProperty("左扫喷淋泵")
        private String specialOutput4_1;
        @ApiModelProperty("右扫喷淋泵")
        private String specialOutput4_2;
        @ApiModelProperty("后喷雾")
        private String specialOutput4_3;
        @ApiModelProperty("喷杆左摆出")
        private String specialOutput4_4;
        @ApiModelProperty("喷杆右摆出")
        private String specialOutput4_5;
        @ApiModelProperty("扫盘中速")
        private String specialOutput4_6;
        @ApiModelProperty("扫盘低速")
        private String specialOutput4_7;
        @ApiModelProperty("低压水左前冲洗")
        private String specialOutput4_8;
    }
    @ApiModelProperty("专用输出5")
    private Bf.SpecialOutput5 specialOutput5;
    @Data
    public static class SpecialOutput5{
        @ApiModelProperty("低压水右前冲洗")
        private String specialOutput5_1;
        @ApiModelProperty("低压水左后冲洗")
        private String specialOutput5_2;
        @ApiModelProperty("低压水右后冲洗")
        private String specialOutput5_3;
        @ApiModelProperty("预留 1（风机离合）")
        private String specialOutput5_4;
        @ApiModelProperty("预留 2（喷枪水阀）")
        private String specialOutput5_5;
    }
    @ApiModelProperty("提醒状态1,喇叭：随动作")
    private Bf.ReminderStatus1 reminderStatus1;
    @Data
    public static class ReminderStatus1{
        @ApiModelProperty("倒车请注意")
        private String reminderStatus1_1;
        @ApiModelProperty("车辆转弯请注意安全")
        private String reminderStatus1_2;
        @ApiModelProperty("垃圾桶上升请注意")
        private String reminderStatus1_3;
        @ApiModelProperty("垃圾桶下降请注意")
        private String reminderStatus1_4;
        @ApiModelProperty("箱体举升请")
        private String reminderStatus1_5;
        @ApiModelProperty("箱体下降请注意")
        private String reminderStatus1_6;
        @ApiModelProperty("后门开启请注意")
        private String reminderStatus1_7;
        @ApiModelProperty("后门关闭请注意")
        private String reminderStatus1_8;
        @ApiModelProperty("提醒状态1_9")
        private String reminderStatus1_9;
        @ApiModelProperty("提醒状态1_10")
        private String reminderStatus1_10;
        @ApiModelProperty("提醒状态1_11")
        private String reminderStatus1_11;
        @ApiModelProperty("提醒状态1_12")
        private String reminderStatus1_12;
        @ApiModelProperty("提醒状态1_13")
        private String reminderStatus1_13;
        @ApiModelProperty("提醒状态1_14")
        private String reminderStatus1_14;
        @ApiModelProperty("提醒状态1_15")
        private String reminderStatus1_15;
        @ApiModelProperty("提醒状态1_16")
        private String reminderStatus1_16;
    }
    @ApiModelProperty("扩展报文45，字节3")
    private Integer extendedMessage45_3;
    @ApiModelProperty("提醒状态2,喇叭：播三次")
    private Bf.ReminderStatus2 reminderStatus2;
    @Data
    public static class ReminderStatus2{
        @ApiModelProperty("清水箱水位低")
        private String reminderStatus2_1;
        @ApiModelProperty("冷却液位低")
        private String reminderStatus2_2;
        @ApiModelProperty("填料器未下降，请注意")
        private String reminderStatus2_3;
    }
    @ApiModelProperty("扩展报文45,字节5")
    private Integer extendedMessage45_5;
    @ApiModelProperty("扩展报文45，字节6")
    private Integer extendedMessage45_6;
    @ApiModelProperty("提醒状态,喇叭：无,显示：文字")
    private Bf.ReminderStatus3 reminderStatus3;
    @Data
    public static class ReminderStatus3{
        @ApiModelProperty("请配置洒水模式")
        private String reminderStatus3_1;
        @ApiModelProperty("推铲强制已开启")
        private String reminderStatus3_2;
        @ApiModelProperty("压力循环模式已开启")
        private String reminderStatus3_3;
    }
    @ApiModelProperty("扩展报文45，字节8")
    private Integer extendedMessage45_8;
    @ApiModelProperty("控制命令1")
    private Bf.ControlCommand1 controlCommand1;
    @Data
    public static class ControlCommand1{
        @ApiModelProperty("工作灯开关")
        private String workLampSwitch;
        @ApiModelProperty("箭头灯开/关")
        private String arrowLightSwitch;
        @ApiModelProperty("语音喇叭开关")
        private String voiceHornSwitch;
        @ApiModelProperty("控制命令1_4")
        private String controlCommand1_4;
        @ApiModelProperty("控制命令1_5")
        private String controlCommand1_5;
        @ApiModelProperty("控制命令1_6")
        private String controlCommand1_6;
        @ApiModelProperty("控制命令1_7")
        private String controlCommand1_7;
        @ApiModelProperty("控制命令1_8")
        private String controlCommand1_8;
    }
    @ApiModelProperty("控制命令2")
    private Bf.ControlCommand2 controlCommand2;
    @Data
    public static class ControlCommand2{
        @ApiModelProperty("喷架开关")
        private String controlCommand2_1;
        @ApiModelProperty("排冲热水开关")
        private String controlCommand2_2;
        @ApiModelProperty("点喷开关")
        private String controlCommand2_3;
        @ApiModelProperty("绕盘开关")
        private String controlCommand2_4;
        @ApiModelProperty("冷水水路开关")
        private String controlCommand2_5;
        @ApiModelProperty("绕盘2开关")
        private String controlCommand2_6;
        @ApiModelProperty("热水水路开关")
        private String controlCommand2_7;
        @ApiModelProperty("控制命令2_8")
        private String controlCommand2_8;
    }
    @ApiModelProperty("控制命令3")
    private Bf.ControlCommand3 controlCommand3;
    @Data
    public static class ControlCommand3{
        @ApiModelProperty("喷架上转")
        private String controlCommand3_1;
        @ApiModelProperty("喷架下转")
        private String controlCommand3_2;
        @ApiModelProperty("喷架左转")
        private String controlCommand3_3;
        @ApiModelProperty("喷架右转")
        private String controlCommand3_4;
        @ApiModelProperty("点喷上转")
        private String controlCommand3_5;
        @ApiModelProperty("点喷下转")
        private String controlCommand3_6;
        @ApiModelProperty("点喷左转")
        private String controlCommand3_7;
        @ApiModelProperty("点喷右转")
        private String controlCommand3_8;
    }
    @ApiModelProperty("控制命令4")
    private Bf.ControlCommand4 controlCommand4;
    @Data
    public static class ControlCommand4{
        @ApiModelProperty("点火线圈")
        private String controlCommand4_1;
        @ApiModelProperty("鼓风机继电器")
        private String controlCommand4_2;
        @ApiModelProperty("热水电机启停")
        private String controlCommand4_3;
        @ApiModelProperty("冷水电机启停")
        private String controlCommand4_4;
        @ApiModelProperty("供油继电器")
        private String controlCommand4_5;
        @ApiModelProperty("音乐开关")
        private String controlCommand4_6;
        @ApiModelProperty("卸料模式开关")
        private String controlCommand4_7;
        @ApiModelProperty("调试模式开关")
        private String controlCommand4_8;
    }
    @ApiModelProperty("强度/速度/模式")
    private Bf.IntensityMode intensityMode;
    @Data
    public static class IntensityMode{
        @ApiModelProperty("作业强度")
        private String work_1;
        @ApiModelProperty("0x00：标准 0x01：节能 0x02：强力")
        @DictMapping(dictCode = "work_1",sourceField = "work_1")
        private String work_1Str;
        @ApiModelProperty("扫盘速度")
        private String work_2;
        @ApiModelProperty("0x00：中速 0x01：低速 0x02：高速")
        @DictMapping(dictCode = "work_2",sourceField = "work_2")
        private String work_2Str;
        @ApiModelProperty("作业模式")
        private String work_3;
        @ApiModelProperty("0x00：洗扫模式， 0x01：洗吸模式， 0x02：干扫模式")
        @DictMapping(dictCode = "work_3",sourceField = "work_3")
        private String work_3Str;
        @ApiModelProperty("模式4")
        private String work_4;
        @ApiModelProperty("作业4")
        @DictMapping(dictCode = "work_4",sourceField = "work_4")
        private String work_4Str;
    }
    @ApiModelProperty("扩展报文62，字节6")
    private Bf.ExtendedMessage62_6 extendedMessage62_6;
    @Data
    public static class ExtendedMessage62_6{
        @ApiModelProperty("扩展报文62_6_1")
        private String byte62_6_1;
        @ApiModelProperty("扩展报文62_6_2")
        private String byte62_6_2;
        @ApiModelProperty("扩展报文62_6_3")
        private String byte62_6_3;
        @ApiModelProperty("扩展报文62_6_4")
        private String byte62_6_4;
        @ApiModelProperty("扩展报文62_6_5")
        private String byte62_6_5;
        @ApiModelProperty("扩展报文62_6_6")
        private String byte62_6_6;
        @ApiModelProperty("扩展报文62_6_7")
        private String byte62_6_7;
        @ApiModelProperty("扩展报文62_6_8")
        private String byte62_6_8;
    }
    @ApiModelProperty("扩展报文62，字节7")
    private Integer extendedMessage62_7;
//    @Data
//    public static class ExtendedMessage62_7{
//        @ApiModelProperty("扩展报文62_7_1")
//        private String byte62_7_1;
//        @ApiModelProperty("扩展报文62_7_2")
//        private String byte62_7_2;
//        @ApiModelProperty("扩展报文62_7_3")
//        private String byte62_7_3;
//        @ApiModelProperty("扩展报文62_7_4")
//        private String byte62_7_4;
//        @ApiModelProperty("扩展报文62_7_5")
//        private String byte62_7_5;
//        @ApiModelProperty("扩展报文62_7_6")
//        private String byte62_7_6;
//        @ApiModelProperty("扩展报文62_7_7")
//        private String byte62_7_7;
//        @ApiModelProperty("扩展报文62_7_8")
//        private String byte62_7_8;
//    }
    @ApiModelProperty("扩展报文62，字节8")
    private Integer extendedMessage62_8;
    //    @Data
//    public static class ExtendedMessage62_8{
//        @ApiModelProperty("扩展报文62_8_1")
//        private String byte62_8_1;
//        @ApiModelProperty("扩展报文62_8_2")
//        private String byte62_8_2;
//        @ApiModelProperty("扩展报文62_8_3")
//        private String byte62_8_3;
//        @ApiModelProperty("扩展报文62_8_4")
//        private String byte62_8_4;
//        @ApiModelProperty("扩展报文62_8_5")
//        private String byte62_8_5;
//        @ApiModelProperty("扩展报文62_8_6")
//        private String byte62_8_6;
//        @ApiModelProperty("扩展报文62_8_7")
//        private String byte62_8_7;
//        @ApiModelProperty("扩展报文62_8_8")
//        private String byte62_8_8;
//    }
    @ApiModelProperty("标定参数1")
    private Bf.CalibrationParam1 calibrationParam1;
    @Data
    public static class CalibrationParam1{
        @ApiModelProperty("标定参数1_1")
        private String calibrationParam1_1;
        @ApiModelProperty("标定参数1_2")
        private String calibrationParam1_2;
        @ApiModelProperty("标定参数1_3")
        private String calibrationParam1_3;
        @ApiModelProperty("标定参数1_4")
        private String calibrationParam1_4;
        @ApiModelProperty("标定参数1_5")
        private String calibrationParam1_5;
        @ApiModelProperty("标定参数1_6")
        private String calibrationParam1_6;
        @ApiModelProperty("标定参数1_7")
        private String calibrationParam1_7;
        @ApiModelProperty("标定参数1_8")
        private String calibrationParam1_8;
    }
    @ApiModelProperty("参数组序号")
    private Integer paramGroupOrder;

    @ApiModelProperty("参数组序号mask")
    private String paramGroupOrderBitMask;

    @ApiModelProperty("参数组序号bit")
    private Bf.ParamGroupOrderBit paramGroupOrderBit;
    @Data
    public static class ParamGroupOrderBit {
        @ApiModelProperty("参数组序号1")
        private String paramGroupOrder1;
        @ApiModelProperty("参数组序号2")
        private String paramGroupOrder2;
        @ApiModelProperty("参数组序号3")
        private String paramGroupOrder3;
        @ApiModelProperty("参数组序号4")
        private String paramGroupOrder4;
        @ApiModelProperty("参数组序号5")
        private String paramGroupOrder5;
        @ApiModelProperty("参数组序号6")
        private String paramGroupOrder6;
        @ApiModelProperty("参数组序号7")
        private String paramGroupOrder7;
        @ApiModelProperty("参数组序号8")
        private String paramGroupOrder8;
    }
    @ApiModelProperty("标定参数2")
    private Integer calibrationParam2;
    @ApiModelProperty("标定参数3")
    private Integer calibrationParam3;
    @ApiModelProperty("标定参数4")
    private Integer calibrationParam4;
    @ApiModelProperty("标定参数5")
    private Integer calibrationParam5;
    @ApiModelProperty("标定参数6")
    private Integer calibrationParam6;
    @ApiModelProperty("标定参数7")
    private Integer calibrationParam7;

    @ApiModelProperty("动力单元列表")
    private Bf.ParamList paramList;
    @Data
    public static class ParamList {
        @ApiModelProperty("标定参数2_0")
        private Integer calibrationParam2_0=0;
        @ApiModelProperty("标定参数2_1")
        private Integer calibrationParam2_1=0;
        @ApiModelProperty("标定参数2_2")
        private Integer calibrationParam2_2=0;
        @ApiModelProperty("标定参数3_0")
        private Integer calibrationParam3_0=0;
        @ApiModelProperty("标定参数3_1")
        private Integer calibrationParam3_1=0;
        @ApiModelProperty("标定参数3_2")
        private Integer calibrationParam3_2=0;
        @ApiModelProperty("标定参数4_0")
        private Integer calibrationParam4_0=0;
        @ApiModelProperty("标定参数4_1")
        private Integer calibrationParam4_1=0;
        @ApiModelProperty("标定参数4_2")
        private Integer calibrationParam4_2=0;
        @ApiModelProperty("标定参数5_0")
        private Integer calibrationParam5_0=0;
        @ApiModelProperty("标定参数5_1")
        private Integer calibrationParam5_1=0;
        @ApiModelProperty("标定参数5_2")
        private Integer calibrationParam5_2=0;
        @ApiModelProperty("标定参数6_0")
        private Integer calibrationParam6_0=0;
        @ApiModelProperty("标定参数6_1")
        private Integer calibrationParam6_1=0;
        @ApiModelProperty("标定参数6_2")
        private Integer calibrationParam6_2=0;
        @ApiModelProperty("标定参数7_0")
        private Integer calibrationParam7_0=0;
        @ApiModelProperty("标定参数7_1")
        private Integer calibrationParam7_1=0;
        @ApiModelProperty("标定参数7_2")
        private Integer calibrationParam7_2=0;
    }

}
