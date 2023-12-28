package com.yiwei.common.dataConsts;

/**
 * @ClassName: GBCmdConst
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: guozhen
 * @date: 2017年6月10日 下午4:20:09
 * 
 */
public class GBCmdConst {
	/**
	 * @Fields param Key : 参数
	 */
	public final static String PARAM_KEY = "PARAM";
	/**
	 * @Fields CMD_CONTOROL_UPGRADE : 升级
	 */
	public final static String UPGRADE = "UPGRADE";

	public final static String VCU_UPGRADE = "VCU_UPGRADE";
	/**
	 * @Fields CMD_ID_UPLOAD_CAN_FILE : 上传CAN文件到服务器
	 */
	public final static String UPLOAD_CAN_FILE = "UPLOAD_CAN_FILE";
	/**
	 * @Fields SHUTDOWN : 车载终端关机
	 */
	public final static String SHUTDOWN = "SHUTDOWN";
	/**
	 * @Fields RESET : 车载终端复位
	 */
	public final static String RESET = "RESET";
	/**
	 * @Fields FACTORY_RESET : 恢复出厂设置
	 */
	public final static String FACTORY_RESET = "FACTORY_RESET";
	/**
	 * @Fields BROKEN_LINK : 断开数据通信链路
	 */
	public final static String BROKEN_LINK = "BROKEN_LINK";
	/**
	 * @Fields TERMINAL_WARN : 终端报警/预警
	 */
	public final static String TERMINAL_WARN = "TERMINAL_WARN";
	/**
	 * @Fields OPEN_SAMPLE_LINK : 开启抽样监测链路
	 */
	public final static String OPEN_SAMPLE_LINK = "OPEN_SAMPLE_LINK";
	/**
	 * 自定义指令 之远程车辆控制
	 */
	public final static String CUSTOM_REMOTE_CONTROL = "CUSTOM_REMOTE_CONTROL";
	/** 自定义指令 之远程车身控制 */
	public static final String CUSTOM_REMOTE_CARBODY_CONTROL = "CUSTOM_REMOTE_CARBODY_CONTROL";
	/** 自定义指令 之远程车身控制 的开关值中的开值 */
	public static final int CUSTOM_REMOTE_CARBODY_CONTROL_STATUS_ON = 0x55;
	/** 自定义指令 之远程车身控制 的开关值中的关值 */
	public static final int CUSTOM_REMOTE_CARBODY_CONTROL_STATUS_OFF = 0xAA;
	/**
	 * 自定义指令 之平台透传终端数据
	 */
	public static final String PLATFORM_TERMINAL_DATA = "PLATFORM_TERMINAL_DATA";

	/** 自定义指令 之湖州矿车进出电子围栏告警下发 */
	public static final String HuZhouKuangChe_FenceAlarm = "HuZhouKuangChe_FenceAlarm";

	public static final String CONTROL_LOCK = "CONTROL_LOCK";



	/** 自定义指令 之湖州矿车进出电子围栏告警 事件类型 */
	public enum HuZhouKuangChe_FenceAlarm_EventType_Enum {
		/** 事件类型(未知) */
		UNKNOWN(0),
		/** 事件类型(进围栏) */
		ENTER(1),
		/** 事件类型(出围栏) */
		EXIT(2);
		/** 枚举的类型值 */
		public Integer intData;
		private HuZhouKuangChe_FenceAlarm_EventType_Enum(Integer intData) { this.intData = intData; }
	};

	/**
	 * 自定义指令 之湖州矿车进出电子围栏告警 事件类型(未知)
	 */
	public static final int HuZhouKuangChe_FenceAlarm_EventType_Unknown = 0x0;
	/**
	 * 自定义指令 之湖州矿车进出电子围栏告警 事件类型(进围栏)
	 */
	public static final int HuZhouKuangChe_FenceAlarm_EventType_Enter = 0x1;
	/**
	 * 自定义指令 之湖州矿车进出电子围栏告警 事件类型(出围栏)
	 */
	public static final int HuZhouKuangChe_FenceAlarm_EventType_Exit = 0x2;




	
}
 