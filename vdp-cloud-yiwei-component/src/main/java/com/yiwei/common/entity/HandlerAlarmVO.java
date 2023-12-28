package com.yiwei.common.entity;

import java.io.Serializable;

/**
 * Created by chenxin on 2022/4/19.
 */
public class HandlerAlarmVO implements Serializable {
    private String vinCode;
    private String alarmType;
    private String alarmCode;
    private String alarmStatus;

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    public String getAlarmCode() {
        return alarmCode;
    }

    public void setAlarmCode(String alarmCode) {
        this.alarmCode = alarmCode;
    }

    public String getAlarmStatus() {
        return alarmStatus;
    }

    public void setAlarmStatus(String alarmStatus) {
        this.alarmStatus = alarmStatus;
    }
}
