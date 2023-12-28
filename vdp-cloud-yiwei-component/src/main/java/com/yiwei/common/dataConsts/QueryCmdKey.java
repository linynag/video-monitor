package com.yiwei.common.dataConsts;

/**
 * @ClassName: GBCmdConst
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: guozhen
 * @date: 2017年6月10日 下午4:20:09
 * 
 */
public interface QueryCmdKey {
 
	/**
	 * @Fields KEY ：下发命令参数key
	 */
	public final static String PARAM_KEY = "PARAM_KEY";
	/**
	 * @Fields KEY ：下发命令参数值key
	 */
	public final static String PARAM_VALUE = "PARAM_VALUE";
	/**
	 * @Fields KEY ：查询参数数据key
	 */
	public final static String KEY = "QUERY";
	/**
	 * @Fields PARAM_NUM : 参数总数
	 */
	public final static String PARAM_NUM = "PARAM_NUM";
	/**
	 * @Fields PARAM_LIST : 参数值列表
	 */
	public final static String PARAM_LIST = "PARAM_LIST";

	/**
	 * @Fields PARAM_ID_CACHE_CYCLE : 终端缓存周期
	 */
	public final static int PARAM_ID_CACHE_CYCLE = 0x01;
	/**
	 * @Fields PARAM_ID_UPLOAD_CYCLE : 正常上报周期
	 */
	public final static int PARAM_ID_UPLOAD_CYCLE = 0x02;
	/**
	 * @Fields PARAM_ID_WARN_UPLOAD_CYCLE : 报警时，上报周期
	 */
	public final static int PARAM_ID_WARN_UPLOAD_CYCLE = 0x03;
	/**
	 * @Fields PARAM_ID_DOMIN_LENGTH : 远程服务与管理平台域名长度
	 */
	public final static int PARAM_ID_DOMIN_LENGTH = 0x04;
	/**
	 * @Fields PARAM_ID_DOMIN : 远程服务与管理平台域名
	 */
	public final static int PARAM_ID_DOMIN = 0x05;
	/**
	 * @Fields PARAM_ID_DOMIN_PORT : 远程服务与管理平台域名端口
	 */
	public final static int PARAM_ID_DOMIN_PORT = 0x06;
	/**
	 * @Fields PARAM_ID_HARDWARE_VERSION : 硬件版本
	 */
	public final static int PARAM_ID_HARDWARE_VERSION = 0x07;
	/**
	 * @Fields PARAM_ID_SOFTWARE_VERSION : 固件版本
	 */
	public final static int PARAM_ID_SOFTWARE_VERSION = 0x08;
	/**
	 * @Fields PARAM_ID_HEART_CYCLE : 心跳发送周期
	 */
	public final static int PARAM_ID_HEART_CYCLE = 0x09;
	/**
	 * @Fields PARAM_ID_TERMINAL_RESPONSE_OVER_TIME : 终端应答超时周期
	 */
	public final static int PARAM_ID_TERMINAL_RESPONSE_OVER_TIME = 0x0A;
	/**
	 * @Fields PARAM_ID_PLATFORM_RESPONSE_OVER_TIME : 平台应答超时周期
	 */
	public final static int PARAM_ID_PLATFORM_RESPONSE_OVER_TIME = 0x0B;
	/**
	 * @Fields PARAM_ID_LOGIN_INTERVAL_TIME : 登录三次失败后的间隔周期
	 */
	public final static int PARAM_ID_LOGIN_INTERVAL_TIME = 0x0C;
	/**
	 * @Fields PARAM_ID_PUBLIC_DOMIN_LENGTH : 公共平台域名长度
	 */
	public final static int PARAM_ID_PUBLIC_DOMIN_LENGTH = 0x0D;
	/**
	 * @Fields PARAM_ID_PUBLIC_DOMIN : 公共平台域名
	 */
	public final static int PARAM_ID_PUBLIC_DOMIN = 0x0E;
	/**
	 * @Fields PARAM_ID_PUBLIC_DOMIN_PORT : 公共平台域名端口
	 */
	public final static int PARAM_ID_PUBLIC_DOMIN_PORT = 0x0F;
	/**
	 * @Fields PARAM_ID_IS_SAMPLING_INSPECTION : 是否处于抽样检测中
	 */
	public final static int PARAM_ID_IS_SAMPLING_INSPECTION = 0x10;
	
	
	//-------以下需求新增于2017.08.10 为车葫芦协议的转移
	/**
	 * 终端属性信息
	 */
	public static final int PARAM_ID_TERMINAL_ATTRIBUTE_INFO = 0x80;
	/**
	 * GPRS通信参数
	 */
	public static final int PARAM_ID_GPRS_COMMUNICATION_PARAMETER = 0x81;
	/**
	 * 车辆数据
	 */
	public static final int PARAM_ID_VEHICLE_DATA = 0x82;
	/**
	 * 当前故障码
	 */
	public static final int PARAM_ID_CURRENT_FAULT_CODE = 0x83;
	/**
	 * 驾驶行为数据
	 */
	public static final int PARAM_ID_DRIVING_BEHAVIOUR_DATA = 0x84;
	/**
	 * 车辆数据回传间隔
	 */
	public static final int PARAM_ID_VEHICLE_DATA_POSTBACK_INTERVAL = 0x85;
	/**
	 * 低电压报警参数
	 */
	public static final int PARAM_ID_LOWBATTERY_ALARM_PARAMETER = 0x86;
	/**
	 * 定位时间过长报警参数
	 */
	public static final int PARAM_ID_LOCATETIME_OVERLONG_ALARM_PARAMETER = 0x87;
	/**
	 * 疲劳驾驶参数
	 */
	public static final int PARAM_ID_FATIGUE_DRIVING_PARAMETER = 0x88;
	/**
	 * 超速报警参数
	 */
	public static final int PARAM_ID_OVERSPEED_ALARM_PARAMETER = 0x89;
	/**
	 * 订单号码
	 */
	public static final int PARAM_ID_ORDER_NUMBER = 0x8A;
	/**
	 * 车辆类型
	 */
	public static final int PARAM_ID_VEHICLE_TYPE = 0x8B;
	/**
	 * 初始总里程总耗油量
	 */
	public static final int PARAM_ID_INITIAL_MILEAGE_FUELCONSUME = 0x8C;
	/**
	 * 蓝牙密码
	 */
	public static final int PARAM_ID_BLUETOOTH_PASSWORD = 0x8D;
	/**
	 * 拍照参数
	 */
	public static final int PARAM_ID_PHOTOGRAPH_PARAMETER = 0x8E;
	//--------新增需求结束	
	
	
	//-------以下需求新增于2017.07.20
	/**
	 * 终端SN号
	 */  
	public final static int PARAM_ID_TERMINAL_SN = 0xE0;
	/**
	 * SPI_FLASH状态
	 */  
	public final static int PARAM_ID_SPI_FLASH_STATE = 0xE1;
	/**
	 * GPS状态
	 */  
	public final static int PARAM_ID_GPS_STATE = 0xE2;
	/**
	 * GPS卫星颗数
	 */  
	public final static int PARAM_ID_GPS_SATELLITE_COUNT = 0xE3;
	/**
	 * GSM信号强度
	 */
	public final static int PARAM_ID_GSM_SIGNAL_INTENSITY = 0xE4;
	/**
	 * Gsensor状态
	 */
	public final static int PARAM_ID_GSENSOR_STATE = 0xE5;
	/**
	 * CAN状态
	 */
	public final static int PARAM_ID_CAN_STATE = 0xE6;
	/**
	 * 其它IO状态
	 */
	public final static int PARAM_ID_OTHER_IO_STATE = 0xE7;
	/**
	 * 主电电压
	 */
	public final static int PARAM_ID_MAIN_POWER_VALUE = 0xE8;
	/**
	 * Car VIN
	 */
	public final static int PARAM_ID_CAR_VIN = 0xE9;
	/**
	 * Sim卡ICCID值
	 */
	public static final int PARAM_ID_SIM_ICCID = 0xEA;
	//--------新增需求结束
	
	
}