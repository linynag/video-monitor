package com.yiwei.common.entity;

import com.alibaba.fastjson.JSONArray;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 企标告警封装
 * Created by chenxin on 2022/3/29.
 */
public class QbAlarmStatus {

    private String devCode;
    private Date dataTime;
    // 整车故障状态 按照整车故障码或上装故障类别不为0，或者改变时（不为0），产生故障告警事件
    private Boolean vehicleAlarmStatus;
    private Boolean vehicleAlarmStatusFlag;
    // 整车故障代码
    private String vehicleAlarmMask;
    private String vehicleAlarmEndMask;
    private ConcurrentHashMap<String, Long> alarmTimeMap;


    public String getDevCode() {
        return devCode;
    }

    public void setDevCode(String devCode) {
        this.devCode = devCode;
    }

    public Date getDataTime() {
        return dataTime;
    }

    public void setDataTime(Date dataTime) {
        this.dataTime = dataTime;
    }

    public Boolean getVehicleAlarmStatus() {
        return vehicleAlarmStatus;
    }

    public void setVehicleAlarmStatus(Boolean vehicleAlarmStatus) {
        this.vehicleAlarmStatus = vehicleAlarmStatus;
    }

    public Boolean getVehicleAlarmStatusFlag() {
        return vehicleAlarmStatusFlag;
    }

    public void setVehicleAlarmStatusFlag(Boolean vehicleAlarmStatusFlag) {
        this.vehicleAlarmStatusFlag = vehicleAlarmStatusFlag;
    }

    public String getVehicleAlarmMask() {
        return vehicleAlarmMask;
    }

    public void setVehicleAlarmMask(String vehicleAlarmMask) {
        this.vehicleAlarmMask = vehicleAlarmMask;
    }

    public String getVehicleAlarmEndMask() {
        return vehicleAlarmEndMask;
    }

    public void setVehicleAlarmEndMask(String vehicleAlarmEndMask) {
        this.vehicleAlarmEndMask = vehicleAlarmEndMask;
    }

    public ConcurrentHashMap<String, Long> getAlarmTimeMap() {
        return alarmTimeMap;
    }

    public void setAlarmTimeMap(ConcurrentHashMap<String, Long> alarmTimeMap) {
        this.alarmTimeMap = alarmTimeMap;
    }
}
