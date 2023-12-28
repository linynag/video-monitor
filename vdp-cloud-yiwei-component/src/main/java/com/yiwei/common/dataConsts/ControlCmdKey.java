package com.yiwei.common.dataConsts;

/**   
 * @ClassName:  ControlCmdKey   
 * @Description:控制命令数据key定义   
 * @author: guozhen 
 * @date:   2017年6月9日 下午6:00:01   
 *     
 */
public interface ControlCmdKey {

	/**
	 * @Fields KEY ：控制命令数据key
	 */
	public final static String KEY = "CONTROL";
	/**
	 * @Fields CMD_ID :  命令ID
	 */  
	public final static String CMD_ID = "CMD_ID";
	/**
	 * @Fields CMD_ID_NONE :  
	 */  
	public final static int CMD_ID_NONE = 0x00;
	/**
	 * @Fields CMD_ID_UPGRADE :  
	 */  
	public final static int CMD_ID_UPGRADE = 0x01;
	/**
	 * @Fields CMD_ID_SHUTDOWN :  
	 */  
	public final static int CMD_ID_SHUTDOWN = 0x02;
	/**
	 * @Fields CMD_ID_RESET :  
	 */  
	public final static int CMD_ID_RESET = 0x03;
	/**
	 * @Fields CMD_ID_FACTORY_RESET :  
	 */  
	public final static int CMD_ID_FACTORY_RESET = 0x04;
	/**
	 * @Fields CMD_ID_BROKEN_LINK :  
	 */  
	public final static int CMD_ID_BROKEN_LINK = 0x05;
	/**
	 * @Fields CMD_ID_TERMINAL_WARN :  
	 */  
	public final static int CMD_ID_TERMINAL_WARN = 0x06;
	/**
	 * @Fields CMD_ID_OPEN_SAMPLE_LINK :  
	 */  
	public final static int CMD_ID_OPEN_SAMPLE_LINK = 0x07;
	/**
	 * @Fields UPGRADE :  升级
	 */  
	public final static String UPGRADE = "UPGRADE";
	/**
	 * @Fields UPGRADE_NAME :  拨号点名称
	 */  
	public final static String UPGRADE_NAME = "UPGRADE_NAME";
	/**
	 * @Fields UPGRADE_USERNAME :  用户名
	 */  
	public final static String UPGRADE_USERNAME = "UPGRADE_USERNAME";
	/**
	 * @Fields UPGRADE_PASS :  密码
	 */  
	public final static String UPGRADE_PASS = "UPGRADE_PASS";
	/**
	 * @Fields UPGRADE_ADDRESS :  地址
	 */  
	public final static String UPGRADE_ADDRESS = "UPGRADE_ADDRESS";
	/**
	 * @Fields UPGRADE_PORT :  端口
	 */  
	public final static String UPGRADE_PORT = "UPGRADE_PORT";
	/**
	 * @Fields UPGRADE_TERMINAL_MAKER :  制造商
	 */  
	public final static String UPGRADE_TERMINAL_MAKER = "UPGRADE_TERMINAL_MAKER";
	/**
	 * @Fields UPGRADE_HARDWARE_VERSION :  硬件版本
	 */  
	public final static String UPGRADE_HARDWARE_VERSION = "UPGRADE_HARDWARE_VERSION";
	/**
	 * @Fields UPGRADE_SOFTWARE_VERSION :  固件版本
	 */  
	public final static String UPGRADE_SOFTWARE_VERSION = "UPGRADE_SOFTWARE_VERSION";
	/**
	 * @Fields UPGRADE_URL :  升级URL地址
	 */  
	public final static String UPGRADE_URL = "UPGRADE_URL";
	/**
	 * @Fields UPGRADE_LIMIT_TIME :  连接到升级服务器时限
	 */  
	public final static String UPGRADE_LIMIT_TIME = "UPGRADE_LIMIT_TIME";
	/**
	 * @Fields WARN :  
	 */  
	public final static String WARN = "WARN";
	/**
	 * @Fields WARN_LEVEL :  警告等级
	 */  
	public final static String WARN_LEVEL = "WARN_LEVEL";

	

}