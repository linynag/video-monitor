package com.yiwei.common.entity.commandEntity;

import com.yiwei.common.component.anotation.MyAnotationQueryKeyInteger;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class QueryKeyEntity {
	
	@ApiModelProperty(value = "车载终端本地存储时间周期(ms),范围:0-60000(0ms-60000ms),‘0xFF,0xFE表示异常,0xFF,0xFF表示无效’")
	@MyAnotationQueryKeyInteger(value=1)
	private Boolean param_id_cache_cycle;
	
	@ApiModelProperty(value = "正常时信息上报时间周期(s),范围:1-600(1s-600s),‘0xFF,0xFE表示异常,0xFF,0xFF表示无效’")
	@MyAnotationQueryKeyInteger(value=2)
	private Boolean param_id_upload_cycle;
	
	@ApiModelProperty(value = "报警时信息上报时间周期(ms),范围:0-60000(0ms-60000ms),‘0xFF,0xFE表示异常,0xFF,0xFF表示无效’")
	@MyAnotationQueryKeyInteger(value=3)
	private Boolean param_id_warn_upload_cycle;
	
	@ApiModelProperty(value = "远程服务与管理平台域名长度")
	@MyAnotationQueryKeyInteger(value=4)
	private Boolean param_id_domin_length;
	
	@ApiModelProperty(value = "远程服务与管理平台域名")
	@MyAnotationQueryKeyInteger(value=5)
	private Boolean param_id_domin;
	
	@ApiModelProperty(value = "远程服务与管理平台域名端口,范围:0-65531,‘0xFF,0xFE表示异常,0xFF,0xFF表示无效’")
	@MyAnotationQueryKeyInteger(value=6)
	private Boolean param_id_domin_port;
	
	@ApiModelProperty(value = "硬件版本")
	@MyAnotationQueryKeyInteger(value=7)
	private Boolean param_id_hardware_version;
	
	@ApiModelProperty(value = "固件版本")
	@MyAnotationQueryKeyInteger(value=8)
	private Boolean param_id_software_version;
	
	@ApiModelProperty(value = "心跳发送周期(s),范围:1-240(1s-240s),‘0xFE表示异常,0xFF表示无效’")
	@MyAnotationQueryKeyInteger(value=9)
	private Boolean param_id_heart_cycle;
	
	@ApiModelProperty(value = "终端应答超时周期(s),范围:1-600(1s-600s),‘0xFF,0xFE表示异常,0xFF,0xFF表示无效’")
	@MyAnotationQueryKeyInteger(value=10)
	private Boolean param_id_terminal_response_over_time;
	
	@ApiModelProperty(value = "平台应答超时周期(s),范围:1-600(1s-600s),‘0xFF,0xFE表示异常,0xFF,0xFF表示无效’")
	@MyAnotationQueryKeyInteger(value=11)
	private Boolean param_id_platform_response_over_time;
	
	@ApiModelProperty(value = "登录三次失败后的间隔周期(min),范围:1-240(1min-240min),‘0xFE表示异常,0xFF表示无效’")
	@MyAnotationQueryKeyInteger(value=12)
	private Boolean param_id_login_interval_time;
	
	@ApiModelProperty(value = "公共平台域名长度")
	@MyAnotationQueryKeyInteger(value=13)
	private Boolean param_id_public_domin_length;

	@ApiModelProperty(value = "公共平台域名")
	@MyAnotationQueryKeyInteger(value=14)
	private Boolean param_id_public_domin;
	
	@ApiModelProperty(value = "公共平台域名端口,范围:0-65531,‘0xFF,0xFE表示异常,0xFF,0xFF表示无效’")
	@MyAnotationQueryKeyInteger(value=15)
	private Boolean param_id_public_domin_port;
	
	@ApiModelProperty(value = "是否处于抽样检测中,1:是 2:否,‘0xFE表示异常,0xFF表示无效’")
	@MyAnotationQueryKeyInteger(value=16)
	private Boolean param_id_is_sampling_inspection;
	
	@ApiModelProperty(value = "终端SN号")
	@MyAnotationQueryKeyInteger(value=224)
	private Boolean param_id_terminal_sn;
	
	@ApiModelProperty(value = "SPI_FLASH状态")
	@MyAnotationQueryKeyInteger(value=225)
	private Boolean param_id_spi_flash_state;
	
	@ApiModelProperty(value = "GPS状态")
	@MyAnotationQueryKeyInteger(value=226)
	private Boolean param_id_gps_state;
	
	@ApiModelProperty(value = "GPS卫星颗数")
	@MyAnotationQueryKeyInteger(value=227)
	private Boolean param_id_gps_satellite_count;
	
	@ApiModelProperty(value = "GSM信号强度")
	@MyAnotationQueryKeyInteger(value=228)
	private Boolean param_id_gsm_signal_intensity;
	
	@ApiModelProperty(value = "Gsensor状态")
	@MyAnotationQueryKeyInteger(value=229)
	private Boolean param_id_gsensor_state;
	
	@ApiModelProperty(value = "CAN状态")
	@MyAnotationQueryKeyInteger(value=230)
	private Boolean param_id_can_state;
	
	@ApiModelProperty(value = "其它IO状态")
	@MyAnotationQueryKeyInteger(value=231)
	private Boolean param_id_other_io_state;
	
	@ApiModelProperty(value = "主电电压")
	@MyAnotationQueryKeyInteger(value=232)
	private Boolean param_id_main_power_value;
	
	@ApiModelProperty(value = "Car VIN")
	@MyAnotationQueryKeyInteger(value=233)
	private Boolean param_id_car_vin;
	
	@ApiModelProperty(value = "Sim卡ICCID值")
	@MyAnotationQueryKeyInteger(value=234)
	private Boolean param_id_sim_iccid;


	@ApiModelProperty(value = "BMS版本号")
	@MyAnotationQueryKeyInteger(value=147)
	private Boolean param_id_bms_version;

	
	
	public Boolean getParam_id_cache_cycle() {
		return param_id_cache_cycle;
	}

	public void setParam_id_cache_cycle(Boolean param_id_cache_cycle) {
		this.param_id_cache_cycle = param_id_cache_cycle;
	}

	public Boolean getParam_id_upload_cycle() {
		return param_id_upload_cycle;
	}

	public void setParam_id_upload_cycle(Boolean param_id_upload_cycle) {
		this.param_id_upload_cycle = param_id_upload_cycle;
	}

	public Boolean getParam_id_warn_upload_cycle() {
		return param_id_warn_upload_cycle;
	}

	public void setParam_id_warn_upload_cycle(Boolean param_id_warn_upload_cycle) {
		this.param_id_warn_upload_cycle = param_id_warn_upload_cycle;
	}

	public Boolean getParam_id_domin_length() {
		return param_id_domin_length;
	}

	public void setParam_id_domin_length(Boolean param_id_domin_length) {
		this.param_id_domin_length = param_id_domin_length;
	}

	public Boolean getParam_id_domin() {
		return param_id_domin;
	}

	public void setParam_id_domin(Boolean param_id_domin) {
		this.param_id_domin = param_id_domin;
	}

	public Boolean getParam_id_domin_port() {
		return param_id_domin_port;
	}

	public void setParam_id_domin_port(Boolean param_id_domin_port) {
		this.param_id_domin_port = param_id_domin_port;
	}

	public Boolean getParam_id_hardware_version() {
		return param_id_hardware_version;
	}

	public void setParam_id_hardware_version(Boolean param_id_hardware_version) {
		this.param_id_hardware_version = param_id_hardware_version;
	}

	public Boolean getParam_id_software_version() {
		return param_id_software_version;
	}

	public void setParam_id_software_version(Boolean param_id_software_version) {
		this.param_id_software_version = param_id_software_version;
	}

	public Boolean getParam_id_heart_cycle() {
		return param_id_heart_cycle;
	}

	public void setParam_id_heart_cycle(Boolean param_id_heart_cycle) {
		this.param_id_heart_cycle = param_id_heart_cycle;
	}

	public Boolean getParam_id_terminal_response_over_time() {
		return param_id_terminal_response_over_time;
	}

	public void setParam_id_terminal_response_over_time(Boolean param_id_terminal_response_over_time) {
		this.param_id_terminal_response_over_time = param_id_terminal_response_over_time;
	}

	public Boolean getParam_id_platform_response_over_time() {
		return param_id_platform_response_over_time;
	}

	public void setParam_id_platform_response_over_time(Boolean param_id_platform_response_over_time) {
		this.param_id_platform_response_over_time = param_id_platform_response_over_time;
	}

	public Boolean getParam_id_login_interval_time() {
		return param_id_login_interval_time;
	}

	public void setParam_id_login_interval_time(Boolean param_id_login_interval_time) {
		this.param_id_login_interval_time = param_id_login_interval_time;
	}

	public Boolean getParam_id_public_domin_length() {
		return param_id_public_domin_length;
	}

	public void setParam_id_public_domin_length(Boolean param_id_public_domin_length) {
		this.param_id_public_domin_length = param_id_public_domin_length;
	}

	public Boolean getParam_id_public_domin() {
		return param_id_public_domin;
	}

	public void setParam_id_public_domin(Boolean param_id_public_domin) {
		this.param_id_public_domin = param_id_public_domin;
	}

	public Boolean getParam_id_public_domin_port() {
		return param_id_public_domin_port;
	}

	public void setParam_id_public_domin_port(Boolean param_id_public_domin_port) {
		this.param_id_public_domin_port = param_id_public_domin_port;
	}

	public Boolean getParam_id_is_sampling_inspection() {
		return param_id_is_sampling_inspection;
	}

	public void setParam_id_is_sampling_inspection(Boolean param_id_is_sampling_inspection) {
		this.param_id_is_sampling_inspection = param_id_is_sampling_inspection;
	}

	public Boolean getParam_id_terminal_sn() {
		return param_id_terminal_sn;
	}

	public void setParam_id_terminal_sn(Boolean param_id_terminal_sn) {
		this.param_id_terminal_sn = param_id_terminal_sn;
	}

	public Boolean getParam_id_spi_flash_state() {
		return param_id_spi_flash_state;
	}

	public void setParam_id_spi_flash_state(Boolean param_id_spi_flash_state) {
		this.param_id_spi_flash_state = param_id_spi_flash_state;
	}

	public Boolean getParam_id_gps_state() {
		return param_id_gps_state;
	}

	public void setParam_id_gps_state(Boolean param_id_gps_state) {
		this.param_id_gps_state = param_id_gps_state;
	}

	public Boolean getParam_id_gps_satellite_count() {
		return param_id_gps_satellite_count;
	}

	public void setParam_id_gps_satellite_count(Boolean param_id_gps_satellite_count) {
		this.param_id_gps_satellite_count = param_id_gps_satellite_count;
	}

	public Boolean getParam_id_gsm_signal_intensity() {
		return param_id_gsm_signal_intensity;
	}

	public void setParam_id_gsm_signal_intensity(Boolean param_id_gsm_signal_intensity) {
		this.param_id_gsm_signal_intensity = param_id_gsm_signal_intensity;
	}

	public Boolean getParam_id_gsensor_state() {
		return param_id_gsensor_state;
	}

	public void setParam_id_gsensor_state(Boolean param_id_gsensor_state) {
		this.param_id_gsensor_state = param_id_gsensor_state;
	}

	public Boolean getParam_id_can_state() {
		return param_id_can_state;
	}

	public void setParam_id_can_state(Boolean param_id_can_state) {
		this.param_id_can_state = param_id_can_state;
	}

	public Boolean getParam_id_other_io_state() {
		return param_id_other_io_state;
	}

	public void setParam_id_other_io_state(Boolean param_id_other_io_state) {
		this.param_id_other_io_state = param_id_other_io_state;
	}

	public Boolean getParam_id_main_power_value() {
		return param_id_main_power_value;
	}

	public void setParam_id_main_power_value(Boolean param_id_main_power_value) {
		this.param_id_main_power_value = param_id_main_power_value;
	}

	public Boolean getParam_id_car_vin() {
		return param_id_car_vin;
	}

	public void setParam_id_car_vin(Boolean param_id_car_vin) {
		this.param_id_car_vin = param_id_car_vin;
	}

	public Boolean getParam_id_sim_iccid() {
		return param_id_sim_iccid;
	}

	public void setParam_id_sim_iccid(Boolean param_id_sim_iccid) {
		this.param_id_sim_iccid = param_id_sim_iccid;
	}

	public Boolean getParam_id_bms_version() {
		return param_id_bms_version;
	}

	public void setParam_id_bms_version(Boolean param_id_bms_version) {
		this.param_id_bms_version = param_id_bms_version;
	}
}
