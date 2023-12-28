package com.yiwei.common.dataConsts;

/**
 * 给每个事件都定编码，如果不定，其他事件状态都是1，就没办法判别是哪种事件
 * @author chenjt
 *
 */
public interface EventStateConstKey {

	/** redis中用于标识存档后的事件类型 */
	public final String EVENT_TYPE = "EVENT_TYPE";

	String ALAR_EVENT_TYPE_JSON ="ALAR_EVENT_TYPE_JSON";

	/**
	 * 点熄火事件状态
	 */
	class VSTSTE {
		// 0x01：点火；0x02：熄火；0x03：其他状态；“0xFE”表示异常，“0xFF”表示无效 10001
		/** 点火 */
		public final static int STARTUP = 10001; // 点火
		/** 熄火 */
		public final static int STALL = 10002; // 熄火
		public final static int OTHER = 10003; // 其他
		public final static int ERROR = 10254; // 错误
		public final static int INVALID = 10255; // 无效
	}

	/**
	 * 车辆充电状态
	 */
	class CHARGE {
		// 0x01：停车充电；0x02：行驶充电；0x03：未充电状态；0x04：充电完成；“0xFE”表示异常，“0xFF”表示无效
		/** 停车充电 */
		public final static int PARKING_CHARGE = 20001;
		/** 行驶充电 */
		public final static int DRIVING_CHARGE = 20002;
		/** 未充电 */
		public final static int NOT_CHARGE = 20003;
		/** 充电完成 */
		public final static int COMPLETE_CHARGE = 20004;// 充电完成
		/** 错误 */
		public final static int ERROR = 20254; // 错误
		/** 无效 */
		public final static int INVALID = 20255; // 无效
	}

	/**
	 * 车辆进出电子围栏状态
	 */
	class LOCATION {
		public final static int LOCATION_IN = 30001; // 进
		public final static int LOCATION_OUT = 30002; // 出
	}

	public final static String ELECTRONIC_FENCE_ID = "ELECTRONIC_FENCE_ID";

	/**
	 * 告警数据
	 */
	class ALARM {
		/** alarm的msg type用于在APP项目判断是否是国标告警 */
		public final static int GB_ALARM_MSG_TYPE = 40_000;

		/** alarm的msg type用于在APP项目判断是否是国标告警 */
		public final static int WEIDE_ALARM_MSG_TYPE = 70_000;

		/** alarm的msg type用于在APP项目判断是否是舒驰告警 */
		public final static int SHUCHI_ALARM_MSG_TYPE = 60_000;

		public final static int MAX_ALARM_LEVEL = 40001;
		/**
		 * @Fields ALARM_MASK : 通用报警标志
		 */
		public final static int ALARM_MASK = 40002;
		/**
		 * @Fields CELL_ALARM_NUM : 可充电储能装置故障总数
		 */
		public final static int CELL_ALARM_NUM = 40003;
		/**
		 * @Fields ELECTRICMOTOR_ALARM_NUM : 驱动电机故障总数
		 */
		public final static int ELECTRICMOTOR_ALARM_NUM = 40004;
		/**
		 * @Fields MOTOR_ALARM_NUM : 发动机故障总数
		 */
		public final static int MOTOR_ALARM_NUM = 40005;
		/**
		 * @Fields OTHER_ALARM_NUM : 其他故障总数
		 */
		public final static int OTHER_ALARM_NUM = 40006;
		/**
		 * @Fields CELL_ALARM_LIST : 可充电储能装置故障列表
		 */
		public final static int CELL_ALARM_LIST = 40007;
		/**
		 * @Fields ELECTRICMOTOR_ALARM_LIST : 驱动电机故障列表
		 */
		public final static int ELECTRICMOTOR_ALARM_LIST = 40008;
		/**
		 * @Fields MOTOR_ALARM_LIST : 发动机故障列表
		 */
		public final static int MOTOR_ALARM_LIST = 40009;
		/**
		 * @Fields OTHER_ALARM_LIST : 其他故障列表
		 */
		public final static int OTHER_ALARM_LIST = 40010;

	}

	/**
	 * 最高告警等级
	 */
	class MAX_ALARM_LEVEL {
		public final static int MAX_ALARM_LEVEL_NO = 401000;//
		public final static int MAX_ALARM_LEVEL_ONE = 401001;// 一级障碍
		public final static int MAX_ALARM_LEVEL_TWO = 401002;// 二级障碍
		public final static int MAX_ALARM_LEVEL_THREE = 401003;// 三级障碍
		public final static int ERROR = 401254; // 错误
		public final static int INVALID = 401255; // 无效
	}

	/**
	 * 驱动电机故障
	 */
	class ELECTRICMOTOR_ALARM {// 402001--402253表示数量
		public final static int ERROR = 402254; // 错误
		public final static int INVALID = 402255; // 无效
	}

	/**
	 * 发动机故障
	 */
	class MOTOR_ALARM {// 403001--403253表示数量
		public final static int ERROR = 403254; // 错误
		public final static int INVALID = 403255; // 无效
	}

	/**
	 * 其他故障
	 */
	class OTHER_ALARM {// 404001--404253表示数量
		public final static int ERROR = 404254; // 错误
		public final static int INVALID = 404255; // 无效
	}

	/**
	 * 可充电储能装置故障
	 */
	class CELL_ALARM {
		// 405001--405253表示数量
		public final static int ERROR = 405254; // 错误
		public final static int INVALID = 405255; // 无效
	}

}
