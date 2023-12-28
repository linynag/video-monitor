package com.yiwei.common.entity.commandEntity;

import com.yiwei.common.component.anotation.MyAnotationQueryKeyInteger;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SetupCommandEntity {
	
	@ApiModelProperty(value = "车载终端本地存储时间周期(ms),范围:0-60000(0ms-60000ms),‘0xFF,0xFE表示异常,0xFF,0xFF表示无效’")
	@MyAnotationQueryKeyInteger(value=1)
	private Integer param_id_cache_cycle;
	
	@ApiModelProperty(value = "正常时信息上报时间周期(s),范围:1-600(1s-600s),‘0xFF,0xFE表示异常,0xFF,0xFF表示无效’")
	@MyAnotationQueryKeyInteger(value=2)
	private Integer param_id_upload_cycle;
	
	@ApiModelProperty(value = "报警时信息上报时间周期(ms),范围:0-60000(0ms-60000ms),‘0xFF,0xFE表示异常,0xFF,0xFF表示无效’")
	@MyAnotationQueryKeyInteger(value=3)
	private Integer param_id_warn_upload_cycle;
	
	/*@ApiModelProperty(value = "远程服务与管理平台域名长度",example="",notes="")
	@MyAnotationQueryKeyInteger(value=4)
	private String param_id_domin_length;*/
	
	@ApiModelProperty(value = "远程服务与管理平台域名")
	@MyAnotationQueryKeyInteger(value=5)
	private String param_id_domin;
	
	@ApiModelProperty(value = "远程服务与管理平台域名端口,范围:0-65531,‘0xFF,0xFE表示异常,0xFF,0xFF表示无效’")
	@MyAnotationQueryKeyInteger(value=6)
	private Integer param_id_domin_port;
	
	@ApiModelProperty(value = "硬件版本")
	@MyAnotationQueryKeyInteger(value=7)
	private String param_id_hardware_version;
	
	@ApiModelProperty(value = "固件版本")
	@MyAnotationQueryKeyInteger(value=8)
	private String param_id_software_version;
	
	@ApiModelProperty(value = "心跳发送周期(s),范围:1-240(1s-240s),‘0xFE表示异常,0xFF表示无效’")
	@MyAnotationQueryKeyInteger(value=9)
	private Integer param_id_heart_cycle;
	
	@ApiModelProperty(value = "终端应答超时周期(s),范围:1-600(1s-600s),‘0xFF,0xFE表示异常,0xFF,0xFF表示无效’")
	@MyAnotationQueryKeyInteger(value=10)
	private Integer param_id_terminal_response_over_time;
	
	@ApiModelProperty(value = "平台应答超时周期(s),范围:1-600(1s-600s),‘0xFF,0xFE表示异常,0xFF,0xFF表示无效’")
	@MyAnotationQueryKeyInteger(value=11)
	private Integer param_id_platform_response_over_time;
	
	@ApiModelProperty(value = "登录三次失败后的间隔周期(min),范围:1-240(1min-240min),‘0xFE表示异常,0xFF表示无效’")
	@MyAnotationQueryKeyInteger(value=12)
	private Integer param_id_login_interval_time;
	
	/*@ApiModelProperty(value = "公共平台域名长度",example="",notes="")
	@MyAnotationQueryKeyInteger(value=13)
	private String param_id_public_domin_length;*/

	@ApiModelProperty(value = "公共平台域名")
	@MyAnotationQueryKeyInteger(value=14)
	private String param_id_public_domin;
	
	@ApiModelProperty(value = "公共平台域名端口,范围:0-65531,‘0xFF,0xFE表示异常,0xFF,0xFF表示无效’")
	@MyAnotationQueryKeyInteger(value=15)
	private Integer param_id_public_domin_port;
	
	@ApiModelProperty(value = "是否处于抽样检测中,1:是 2:否,‘0xFE表示异常,0xFF表示无效’")
	@MyAnotationQueryKeyInteger(value=16)
	private Integer param_id_is_sampling_inspection;
	

	public Integer getParam_id_cache_cycle() {
		return param_id_cache_cycle;
	}

	public void setParam_id_cache_cycle(Integer param_id_cache_cycle) {
		this.param_id_cache_cycle = param_id_cache_cycle;
	}

	public Integer getParam_id_upload_cycle() {
		return param_id_upload_cycle;
	}

	public void setParam_id_upload_cycle(Integer param_id_upload_cycle) {
		this.param_id_upload_cycle = param_id_upload_cycle;
	}

	public Integer getParam_id_warn_upload_cycle() {
		return param_id_warn_upload_cycle;
	}

	public void setParam_id_warn_upload_cycle(Integer param_id_warn_upload_cycle) {
		this.param_id_warn_upload_cycle = param_id_warn_upload_cycle;
	}

	public String getParam_id_domin() {
		return param_id_domin;
	}

	public void setParam_id_domin(String param_id_domin) {
		this.param_id_domin = param_id_domin;
	}

	public Integer getParam_id_domin_port() {
		return param_id_domin_port;
	}

	public void setParam_id_domin_port(Integer param_id_domin_port) {
		this.param_id_domin_port = param_id_domin_port;
	}

	public String getParam_id_hardware_version() {
		return param_id_hardware_version;
	}

	public void setParam_id_hardware_version(String param_id_hardware_version) {
		this.param_id_hardware_version = param_id_hardware_version;
	}

	public String getParam_id_software_version() {
		return param_id_software_version;
	}

	public void setParam_id_software_version(String param_id_software_version) {
		this.param_id_software_version = param_id_software_version;
	}

	public Integer getParam_id_heart_cycle() {
		return param_id_heart_cycle;
	}

	public void setParam_id_heart_cycle(Integer param_id_heart_cycle) {
		this.param_id_heart_cycle = param_id_heart_cycle;
	}

	public Integer getParam_id_terminal_response_over_time() {
		return param_id_terminal_response_over_time;
	}

	public void setParam_id_terminal_response_over_time(Integer param_id_terminal_response_over_time) {
		this.param_id_terminal_response_over_time = param_id_terminal_response_over_time;
	}

	public Integer getParam_id_platform_response_over_time() {
		return param_id_platform_response_over_time;
	}

	public void setParam_id_platform_response_over_time(Integer param_id_platform_response_over_time) {
		this.param_id_platform_response_over_time = param_id_platform_response_over_time;
	}

	public Integer getParam_id_login_interval_time() {
		return param_id_login_interval_time;
	}

	public void setParam_id_login_interval_time(Integer param_id_login_interval_time) {
		this.param_id_login_interval_time = param_id_login_interval_time;
	}

	public String getParam_id_public_domin() {
		return param_id_public_domin;
	}

	public void setParam_id_public_domin(String param_id_public_domin) {
		this.param_id_public_domin = param_id_public_domin;
	}

	public Integer getParam_id_public_domin_port() {
		return param_id_public_domin_port;
	}

	public void setParam_id_public_domin_port(Integer param_id_public_domin_port) {
		this.param_id_public_domin_port = param_id_public_domin_port;
	}

	public Integer getParam_id_is_sampling_inspection() {
		return param_id_is_sampling_inspection;
	}

	public void setParam_id_is_sampling_inspection(Integer param_id_is_sampling_inspection) {
		this.param_id_is_sampling_inspection = param_id_is_sampling_inspection;
	}
	

	
	@ApiModelProperty(value = "终端SN号",example="",notes="")
	@MyAnotationQueryKeyInteger(value=224)
	private String param_id_terminal_sn;
	
	@ApiModelProperty(value = "SPI_FLASH状态",example="",notes="")
	@MyAnotationQueryKeyInteger(value=225)
	private String param_id_spi_flash_state;
	
	@ApiModelProperty(value = "GPS状态",example="",notes="")
	@MyAnotationQueryKeyInteger(value=226)
	private String param_id_gps_state;
	
	@ApiModelProperty(value = "GPS卫星颗数",example="",notes="")
	@MyAnotationQueryKeyInteger(value=227)
	private String param_id_gps_satellite_count;
	
	@ApiModelProperty(value = "GSM信号强度",example="",notes="")
	@MyAnotationQueryKeyInteger(value=228)
	private String param_id_gsm_signal_intensity;
	
	@ApiModelProperty(value = "Gsensor状态",example="",notes="")
	@MyAnotationQueryKeyInteger(value=229)
	private String param_id_gsensor_state;
	
	@ApiModelProperty(value = "CAN状态",example="",notes="")
	@MyAnotationQueryKeyInteger(value=230)
	private String param_id_can_state;
	
	@ApiModelProperty(value = "其它IO状态",example="",notes="")
	@MyAnotationQueryKeyInteger(value=231)
	private String param_id_other_io_state;
	
	@ApiModelProperty(value = "主电电压",example="",notes="")
	@MyAnotationQueryKeyInteger(value=232)
	private String param_id_main_power_value;
	
	@ApiModelProperty(value = "Car VIN",example="",notes="")
	@MyAnotationQueryKeyInteger(value=233)
	private String param_id_car_vin;
	
	@ApiModelProperty(value = "Sim卡ICCID值",example="",notes="")
	@MyAnotationQueryKeyInteger(value=234)
	private String param_id_sim_iccid;



	@ApiModelProperty(value = "BMS版本")
	@MyAnotationQueryKeyInteger(value=147)
	private String param_id_bms_version;

	@ApiModelProperty(value = "BMS版本状态")
	private String param_id_bms_version_state;

	public String getParam_id_bms_version_state() {
		return param_id_bms_version_state;
	}

	public void setParam_id_bms_version_state(String param_id_bms_version_state) {
		this.param_id_bms_version_state = param_id_bms_version_state;
	}

	public String getParam_id_bms_version() {
		return param_id_bms_version;
	}

	public void setParam_id_bms_version(String param_id_bms_version) {
		this.param_id_bms_version = param_id_bms_version;
	}

	public String getParam_id_terminal_sn() {
		return param_id_terminal_sn;
	}

	public void setParam_id_terminal_sn(String param_id_terminal_sn) {
		this.param_id_terminal_sn = param_id_terminal_sn;
	}

	public String getParam_id_spi_flash_state() {
		return param_id_spi_flash_state;
	}

	public void setParam_id_spi_flash_state(String param_id_spi_flash_state) {
		this.param_id_spi_flash_state = param_id_spi_flash_state;
	}

	public String getParam_id_gps_state() {
		return param_id_gps_state;
	}

	public void setParam_id_gps_state(String param_id_gps_state) {
		this.param_id_gps_state = param_id_gps_state;
	}

	public String getParam_id_gps_satellite_count() {
		return param_id_gps_satellite_count;
	}

	public void setParam_id_gps_satellite_count(String param_id_gps_satellite_count) {
		this.param_id_gps_satellite_count = param_id_gps_satellite_count;
	}

	public String getParam_id_gsm_signal_intensity() {
		return param_id_gsm_signal_intensity;
	}

	public void setParam_id_gsm_signal_intensity(String param_id_gsm_signal_intensity) {
		this.param_id_gsm_signal_intensity = param_id_gsm_signal_intensity;
	}

	public String getParam_id_gsensor_state() {
		return param_id_gsensor_state;
	}

	public void setParam_id_gsensor_state(String param_id_gsensor_state) {
		this.param_id_gsensor_state = param_id_gsensor_state;
	}

	public String getParam_id_can_state() {
		return param_id_can_state;
	}

	public void setParam_id_can_state(String param_id_can_state) {
		this.param_id_can_state = param_id_can_state;
	}

	public String getParam_id_other_io_state() {
		return param_id_other_io_state;
	}

	public void setParam_id_other_io_state(String param_id_other_io_state) {
		this.param_id_other_io_state = param_id_other_io_state;
	}

	public String getParam_id_main_power_value() {
		return param_id_main_power_value;
	}

	public void setParam_id_main_power_value(String param_id_main_power_value) {
		this.param_id_main_power_value = param_id_main_power_value;
	}

	public String getParam_id_car_vin() {
		return param_id_car_vin;
	}

	public void setParam_id_car_vin(String param_id_car_vin) {
		this.param_id_car_vin = param_id_car_vin;
	}

	public String getParam_id_sim_iccid() {
		return param_id_sim_iccid;
	}

	public void setParam_id_sim_iccid(String param_id_sim_iccid) {
		this.param_id_sim_iccid = param_id_sim_iccid;
	}
}
