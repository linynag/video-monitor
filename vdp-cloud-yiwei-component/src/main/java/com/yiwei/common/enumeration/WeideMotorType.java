package com.yiwei.common.enumeration;

public enum WeideMotorType {
    HIGH_VOLTAGE_MOTOR_ONE("00 00 E0 49"),
    HIGH_VOLTAGE_MOTOR_TWO("00 00 E0 4A"),
    LOW_VOLTAGE_MOTOR_ONE("00 00 E0 79"),
    LOW_VOLTAGE_MOTOR_TWO("00 00 E0 7A"),
    INVALI_VOLTAGE_MOTOR("FF FF FF FF");
    private String type;

    WeideMotorType(String type) {
        this.type=type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
