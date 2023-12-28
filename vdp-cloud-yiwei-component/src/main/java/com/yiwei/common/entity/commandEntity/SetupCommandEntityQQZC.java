package com.yiwei.common.entity.commandEntity;

import com.yiwei.common.component.anotation.MyAnotationQueryKeyInteger;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SetupCommandEntityQQZC {

    @ApiModelProperty(value = "经纬度状态")
    @MyAnotationQueryKeyInteger(value = 1)
    private Integer gpsValidByte;

    @ApiModelProperty(value = "纬度")
    @MyAnotationQueryKeyInteger(value = 3)
    private String gpsLatitude;

    @ApiModelProperty(value = "经度")
    @MyAnotationQueryKeyInteger(value = 2)
    private String gpsLongitude;

    @ApiModelProperty(value = "停车/启动")
    @MyAnotationQueryKeyInteger(value = 4)
    private Integer vehicleState;

    @ApiModelProperty(value = "目标车速’")
    @MyAnotationQueryKeyInteger(value = 5)
    private Integer currentSpeed;

    @ApiModelProperty(value = "目标曲率/转向角")
    @MyAnotationQueryKeyInteger(value = 6)
    private String rotationAngle;

    public Integer getGpsValidByte() {
        return gpsValidByte;
    }

    public void setGpsValidByte(Integer gpsValidByte) {
        this.gpsValidByte = gpsValidByte;
    }

    public String getGpsLatitude() {
        return gpsLatitude;
    }

    public void setGpsLatitude(String gpsLatitude) {
        this.gpsLatitude = gpsLatitude;
    }

    public String getGpsLongitude() {
        return gpsLongitude;
    }

    public void setGpsLongitude(String gpsLongitude) {
        this.gpsLongitude = gpsLongitude;
    }

    public Integer getVehicleState() {
        return vehicleState;
    }

    public void setVehicleState(Integer vehicleState) {
        this.vehicleState = vehicleState;
    }

    public Integer getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(Integer currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public String getRotationAngle() {
        return rotationAngle;
    }

    public void setRotationAngle(String rotationAngle) {
        this.rotationAngle = rotationAngle;
    }
}
