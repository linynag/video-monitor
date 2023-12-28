package com.yiwei.common.entity.commandEntity;

import com.yiwei.common.component.anotation.MyAnotationQueryKeyInteger;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class CarControlEntity {
	
	@ApiModelProperty(value="点火，开：true，关：false")
	@MyAnotationQueryKeyInteger(value=0)
	private Boolean ignition; 
	
	@ApiModelProperty(value="车门，开：true，关：false")
	@MyAnotationQueryKeyInteger(value=1)
	private Boolean car_door;
	
	@ApiModelProperty(value="车锁，开：true，关：false")
	@MyAnotationQueryKeyInteger(value=2)
	private Boolean car_lock;
	
	@ApiModelProperty(value="远光灯，开：true，关：false")
	@MyAnotationQueryKeyInteger(value=3)
	private Boolean high_beam;
	
	@ApiModelProperty(value="近光灯，开：true，关：false")
	@MyAnotationQueryKeyInteger(value=4)
	private Boolean low_beam;
	
	@ApiModelProperty(value="天窗，开：true，关：false")
	@MyAnotationQueryKeyInteger(value=5)
	private Boolean skyLight;
	
	@ApiModelProperty(value="后备箱，开：true，关：false")
	@MyAnotationQueryKeyInteger(value=6)
	private Boolean trunk;
	
	@ApiModelProperty(value="双闪和喇叭，开：true，关：false")
	@MyAnotationQueryKeyInteger(value=7)
	private Boolean flashAndHorn;
	
	@ApiModelProperty(value="寻车，开：true，关：false")
	@MyAnotationQueryKeyInteger(value=8)
	private Boolean findcar;
	
	@ApiModelProperty(value="BMS充电，开：true，关：false")
	@MyAnotationQueryKeyInteger(value=13)
	private Boolean bms_charging;

	public Boolean getIgnition() {
		return ignition;
	}

	public void setIgnition(Boolean ignition) {
		this.ignition = ignition;
	}

	public Boolean getCar_door() {
		return car_door;
	}

	public void setCar_door(Boolean car_door) {
		this.car_door = car_door;
	}

	public Boolean getCar_lock() {
		return car_lock;
	}

	public void setCar_lock(Boolean car_lock) {
		this.car_lock = car_lock;
	}

	public Boolean getHigh_beam() {
		return high_beam;
	}

	public void setHigh_beam(Boolean high_beam) {
		this.high_beam = high_beam;
	}

	public Boolean getLow_beam() {
		return low_beam;
	}

	public void setLow_beam(Boolean low_beam) {
		this.low_beam = low_beam;
	}

	public Boolean getSkyLight() {
		return skyLight;
	}

	public void setSkyLight(Boolean skyLight) {
		this.skyLight = skyLight;
	}

	public Boolean getTrunk() {
		return trunk;
	}

	public void setTrunk(Boolean trunk) {
		this.trunk = trunk;
	}

	public Boolean getFlashAndHorn() {
		return flashAndHorn;
	}

	public void setFlashAndHorn(Boolean flashAndHorn) {
		this.flashAndHorn = flashAndHorn;
	}

	public Boolean getFindcar() {
		return findcar;
	}

	public void setFindcar(Boolean findcar) {
		this.findcar = findcar;
	}

	public Boolean getBms_charging() {
		return bms_charging;
	}

	public void setBms_charging(Boolean bms_charging) {
		this.bms_charging = bms_charging;
	}

	
}
