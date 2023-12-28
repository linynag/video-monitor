package com.yiwei.common.component.config;

/**
 * Created by victorlau on 2020/5/13.
 */
public enum  HuZhouKuangChe_FenceAlarm_EventType_Enum {
    /** 事件类型(未知) */
    UNKNOWN(0),
    /** 事件类型(进围栏) */
    ENTER(1),
    /** 事件类型(出围栏) */
    EXIT(2);
    /** 枚举的类型值 */
    public Integer intData;
    private HuZhouKuangChe_FenceAlarm_EventType_Enum(Integer intData) { this.intData = intData; }
}
