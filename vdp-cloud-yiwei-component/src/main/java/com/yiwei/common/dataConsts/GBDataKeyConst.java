package com.yiwei.common.dataConsts;

public interface GBDataKeyConst {
	String ID="_id";
	String TIME = "DEVTIME";
	String DATATAG = "DATATAG";
	String TAG = "TAG";
	String NEED_VALIDATE = "NEED_VALIDATE";
	String DEVCODE = "DEVCODE";
	String ONLINE = "ONLINE";
	String RECVTIME = "RECVTIME";
	String SN = "SN";
	String PKG_CONTEXT = "PKG_CONTEXT";//二进制流的报文中的真正的业务数据信息 ,即[数据单元]
	String CONNECT_SN = "CONNECT_SN";
	String CONNECTOR = "CONNECTOR";
	String RAW_DATA_ERROR = "RAW_DATA_ERROR";//原始数据校验码校验错误KEY
	String RAW_DATA_CHECK_RESULT = "RAW_DATA_CHECK_RESULT";//原始数据解析之后校验错误结果集
	interface DataType {
		/**
		 * @Fields VEHICLE : 整车数据
		 */
		byte VEHICLE = 0x01;
		/**
		 * @Fields ELECTRIC_MOTOR : 驱动电机数据
		 */
		byte ELECTRIC_MOTOR = 0x02;
		/**
		 * @Fields FUELCELL :  燃料电池数据
		 */
		byte FUELCELL = 0x03;
		/**
		 * @Fields MOTOR :  发动机数据
		 */
		byte MOTOR = 0x04;
		/**
		 * @Fields LOCATION :  车辆位置
		 */
		byte LOCATION = 0x05;
		/**
		 * @Fields EXTREME_VALUE :  极值数据
		 */
		byte EXTREME_VALUE = 0x06;
		/**
		 * @Fields ALARM :  报警数据
		 */
		byte ALARM= 0x07;
		/**
		 * @Fields CELL_VOLTAGE :  可充电储能装置电压数据
		 */
		byte CELL_VOLTAGE= 0x08;
		/**
		 * @Fields CELL_TEMP :  可充电储能装置温度数据
		 */
		byte CELL_TEMP= 0x09;
		/**
		 * @Fields EXT_DATA :  附加数据
		 */
		int EXT_DATA= 0x8A;
		/**
		 * @Fields FUEL_DATA :  国标氢燃料附加数据
		 */
		short FUEL_DATA= 0x80;
		/**
		 * @Fields EXT_DATA :  OBD数据
		 */
		int TEQI_OBD_DATA= 0x8B;



	}

	/**
	 * @ClassName: VehicleKey
	 * @Description:整车数据字段key 常量定义
	 * @author: guozhen
	 * @date: 2017年6月6日 下午3:31:50
	 *
	 */
	interface VehicleKey {

		/**
		 * @Fields KEY ：整车数据key
		 */
		String KEY = "VEHICLE";
		/**
		 * @Fields V_STATE :车辆状态
		 */
		String V_STATE = "V_STATE";
		/**
		 * @Fields RUN_STATE :充电状态
		 */
		String CHARGE_STATE = "CHARGE_STATE";
		/**
		 * @Fields RUN_MODE :运行模式
		 */
		String RUN_MODE = "RUN_MODE";
		/**
		 * @Fields SPEED :车速
		 */
		String SPEED = "SPEED";

		/**
		 * @Fields SPEED :手闸状态
		 */
		String HANDBRAK_STATUS = "HANDBRAK_STATUS";

		/**
		 * @Fields SPEED :SOH
		 */
		String SOH = "SOH";

		/**
		 * @Fields SPEED :累计运行时长
		 */
		String RUN_TIME = "RUN_TIME";





		/**
		 * @Fields SPEED :车速模式
		 *
		 */
		String SPEED_MODE = "SPEED_MODE";

		/**
		 * @Fields MILEAGE : 车机累计里程
		 */
		String MILEAGE = "MILEAGE";
		/**
		 * @Fields MILEAGE : GPS累计里程
		 */
		String GPS_MILEAGE = "GPS_MILEAGE";

		/**
		 * @Fields VOLTAGE : 总电压
		 */
		String VOLTAGE = "VOLTAGE";
		/**
		 * @Fields FLOW : 总电流
		 */
		String FLOW = "FLOW";
		/**
		 * @Fields SOC : SOC
		 */
		String SOC = "SOC";
		/**
		 * @Fields DC_STATE : DC-DC状态
		 */
		String DC_STATE = "DC_STATE";
		/**
		 * @Fields GEAR : 挡位
		 */
		String GEAR = "GEAR";

		/**
		 * @Fields GEAR_VALUE : 挡位值
		 * 0000:空挡 ，0001:1档 ，N...... ，1101:倒挡， 1110:自动D档, 1111:停车P档
		 */
		String GEAR_VALUE = "GEAR_VALUE";
		String RUN_STATE = "RUN_STATE";
		/**
		 * @Fields GEAR_IS_BRAKE : 挡位 有无制动力 1有 0无
		 */
		String GEAR_IS_BRAKE = "GEAR_IS_BRAKE";
		/**
		 * @Fields GEAR_IS_DRIVE : 挡位 有无驱动力 1有 0无
		 */
		String GEAR_IS_DRIVE = "GEAR_IS_DRIVE";
		/**
		 * @Fields DEVICE_IN_REISSUE : 车机是否处于补发状态中 1是 0否
		 */
		String DEVICE_IN_REISSUE = "DEVICE_IN_REISSUE";
		/**
		 * @Fields RESISTOR : 绝缘电阻
		 */
		String RESISTOR = "RESISTOR";
		/**
		 * @Fields RESISTOR : 加速踏板行程值
		 */
		String AP_TRAVEL = "AP_TRAVEL";
		/**
		 * @Fields RESISTOR : 制动状态
		 */
		String BRAKE_STATE = "BRAKE_STATE";

		String SURPLUS_VOLUME = "SURPLUS_VOLUME";

		String LIFE_SIGNAL = "LIFE_SIGNAL";

		String ROTATION_ANGLE = "ROTATION_ANGLE";

	}
	interface WeiDeDataType{
		/**
		 * @Fields ALARM :  报警数据
		 */
		int ALARM= 0x8D;

		/**
		 * @Fields CRUX_PARTS :  关键零件数据
		 */
		int CRUX_PARTS= 0x8F;

		/**
		 * @Fields CRUX_PARTS :  关键零件数据
		 */
		int EXTEND_PARTS= 0x90;
	}

	/**
	 *
	 * @ClassName: ElectricMotorKey
	 * @Description:驱动电机数据key 常量定义
	 * @author: guozhen
	 * @date: 2017年6月6日 下午3:35:29
	 *
	 */
	interface ElectricMotorKey {

		/**
		 * @Fields KEY ：驱动电机数据key
		 */
		String KEY = "ELECTRIC_MOTOR";
		/**
		 * @Fields MOTOR_NUM : 驱动电机个数
		 */
		String MOTOR_NUM = "MOTOR_NUM";
		/**
		 * @Fields MOTOR_INFO : 驱动电机总成信息列表
		 */
		String MOTOR_INFO = "MOTOR_INFO";
		/**
		 * @Fields MOTOR_ID : 驱动电机序号
		 */
		String MOTOR_ID = "MOTOR_ID";
		/**
		 * @Fields MOTOR_STATE : 驱动电机状态
		 */
		String MOTOR_STATE = "MOTOR_STATE";
		/**
		 * @Fields CTRL_TEMPERATURE : 驱动电机控制温度
		 */
		String CTRL_TEMPERATURE = "CTRL_TEMPERATURE";
		/**
		 * @Fields MOTOR_RPM : 驱动电机转速
		 */
		String MOTOR_RPM = "MOTOR_RPM";
		/**
		 * @Fields MOTOR_TORQUE : 驱动电机转矩
		 */
		String MOTOR_TORQUE = "MOTOR_TORQUE";
		/**
		 * @Fields MOTOR_TEMPERATURE : 驱动电机温度
		 */
		String MOTOR_TEMPERATURE = "MOTOR_TEMPERATURE";
		/**
		 * @Fields MOTOR_VOLTAGE : 电机控制器输入电压
		 */
		String MOTOR_VOLTAGE = "MOTOR_VOLTAGE";
		/**
		 * @Fields MOTOR_FLOW : 电机控制器直流母线电流
		 */
		String MOTOR_FLOW = "MOTOR_FLOW";


		/**
		 * @Fields MOTOR_FLOW : 电机三项电流
		 */
		String MOTOR_THREE_FLOW = "MOTOR_THREE_FLOW";
	}

	/**
	 * @ClassName: FuelCellKey
	 * @Description:燃料数据key 常量定义
	 * @author: guozhen
	 * @date: 2017年6月6日 下午3:49:54
	 *
	 */
	interface FuelCellKey {

		/**
		 * @Fields KEY ：燃料电池数据key
		 */
		String KEY = "FUEL_CELL";
		/**
		 * @Fields VOLTAGE :   电压
		 */
		String VOLTAGE = "VOLTAGE";
		/**
		 * @Fields FLOW :   电流
		 */
		String FLOW = "FLOW";
		/**
		 * @Fields CONSUMPTION_RATE :   燃料消耗率
		 */
		String CONSUMPTION_RATE = "CONSUMPTION_RATE";
		/**
		 * @Fields DETECTOR_NUM :   温度探针数量
		 */
		String DETECTOR_NUM = "DETECTOR_NUM";
		/**
		 * @Fields TEMPERATURE_LIST :   探针温度列表
		 */
		String TEMPERATURE_LIST = "TEMPERATURE_LIST";
		/**
		 * @Fields MAX_TEMPERATURE :   氢系统最高温度
		 */
		String MAX_TEMPERATURE = "MAX_TEMPERATURE";
		/**
		 * @Fields MAX_TEMPERATURE_ID :   氢系统最高温度探针代号
		 */
		String MAX_TEMPERATURE_ID = "MAX_TEMPERATURE_ID";
		/**
		 * @Fields MAX_CONCENTRATION :   氢系统最高浓度
		 */
		String MAX_CONCENTRATION  = "MAX_CONCENTRATION";
		/**
		 * @Fields MAX_CONCENTRATION_ID :   氢系统最高浓度传感器代号
		 */
		String MAX_CONCENTRATION_ID = "MAX_CONCENTRATION_ID";
		/**
		 * @Fields MAX_PRESSURE :   氢系统最高压力
		 */
		String MAX_PRESSURE = "MAX_PRESSURE";
		/**
		 * @Fields MAX_PRESSURE_ID :   氢系统最高压力传感器代号
		 */
		String MAX_PRESSURE_ID = "MAX_PRESSURE_ID";
		/**
		 * @Fields HIGH_DC_STATE :   高压DC/DC状态
		 */
		String HIGH_DC_STATE = "HIGH_DC_STATE";
	}
	/**
	 * @ClassName:  MotorKey
	 * @Description:发动机数据key 常量定义
	 * @author: guozhen
	 * @date:   2017年6月6日 下午4:17:11
	 *
	 */
	interface MotorKey {

		/**
		 * @Fields KEY ：发动机数据key
		 */
		String KEY = "MOTOR";
		/**
		 * @Fields MOTOR_STATE :    发动机状态
		 */
		String MOTOR_STATE = "MOTOR_STATE";
		/**
		 * @Fields MOTOR_RPM :    曲轴转速
		 */
		String MOTOR_RPM = "MOTOR_RPM";
		/**
		 * @Fields CONSUMPTION_RATE :    燃料消耗率
		 */
		String CONSUMPTION_RATE = "CONSUMPTION_RATE";
	}

	/**
	 * @ClassName:  LocationKey
	 * @Description:位置 数据key 常量定义
	 * @author: guozhen
	 * @date:   2017年6月6日 下午4:17:11
	 *
	 */
	interface LocationKey {

		/**
		 * @Fields KEY ：车辆位置数据key
		 */
		String KEY = "LOCATION";
		/**
		 * @Fields STATE :    定位状态
		 */
		String STATE = "STATE";
		/**
		 * @Fields ISVALID :    有效状态 0有效 1无效
		 */
		String ISVALID = "ISVALID";
		/**
		 * @Fields ISNS :    0南纬，1北纬
		 */
		String ISNS = "ISNS";
		/**
		 * @Fields ISEW :    0东经，1西经
		 */
		String ISEW = "ISEW";
		/**
		 * @Fields LONGITUDE :    经度
		 */
		String LONGITUDE = "LONGITUDE";
		/**
		 * @Fields LATITUDE :   维度
		 */
		String LATITUDE = "LATITUDE";
		/**
		 * @Fields SPEED :
		 */
		String SPEED = "SPEED";
		/**
		 * @Fields DIRECTOIN :
		 */
		String DIRECTOIN = "DIRECTOIN";

	}
	/**
	 * @ClassName:  ExtremeValueKey
	 * @Description:极值 数据key 常量定义
	 * @author: guozhen
	 * @date:   2017年6月6日 下午4:39:59
	 *
	 */
	interface ExtremeValueKey {

		/**
		 * @Fields KEY ：报警数据key
		 */
		String KEY = "EXTREME_VALUE";
		/**
		 * @Fields MAX_VOLTAGE_CELL :  最高电压电池子系统号
		 */
		String MAX_VOLTAGE_CELL = "MAX_VOLTAGE_CELL";
		/**
		 * @Fields MAX_VOLTAGE_UNIT :  最高电压电池单体代号
		 */
		String MAX_VOLTAGE_UNIT = "MAX_VOLTAGE_UNIT";
		/**
		 * @Fields MAX_UNIT_VOLTAGE :  电池单体电压最高值
		 */
		String MAX_UNIT_VOLTAGE = "MAX_UNIT_VOLTAGE";
		/**
		 * @Fields MIN_VOLTAGE_CELL :  最低电压电池子系统号
		 */
		String MIN_VOLTAGE_CELL = "MIN_VOLTAGE_CELL";
		/**
		 * @Fields MIN_VOLTAGE_UNIT :  最低电压电池单体代号
		 */
		String MIN_VOLTAGE_UNIT = "MIN_VOLTAGE_UNIT";
		/**
		 * @Fields MIN_UNIT_VOLTAGE :  电池单体电压最低值
		 */
		String MIN_UNIT_VOLTAGE = "MIN_UNIT_VOLTAGE";
		/**
		 * @Fields MAX_TEMPERATURE_CELL :  最高温度子系统号
		 */
		String MAX_TEMPERATURE_CELL = "MAX_TEMPERATURE_CELL";
		/**
		 * @Fields MAX_TEMPERATURE_UNIT :  最高温度探针序号
		 */
		String MAX_TEMPERATURE_UNIT = "MAX_TEMPERATURE_UNIT";
		/**
		 * @Fields MAX_UNIT_TEMPERATURE :  最高温度值
		 */
		String MAX_UNIT_TEMPERATURE = "MAX_UNIT_TEMPERATURE";
		/**
		 * @Fields MIN_TEMPERATURE_CELL :  最低温度子系统号
		 */
		String MIN_TEMPERATURE_CELL = "MIN_TEMPERATURE_CELL";
		/**
		 * @Fields MIN_TEMPERATURE_UNIT :  最低温度探针序号
		 */
		String MIN_TEMPERATURE_UNIT = "MIN_TEMPERATURE_UNIT";
		/**
		 * @Fields MIN_UNIT_TEMPERATURE :  最低温度值
		 */
		String MIN_UNIT_TEMPERATURE = "MIN_UNIT_TEMPERATURE";
	}
	/**
	 * @ClassName:  AlarmKey
	 * @Description:报警 数据key 常量定义
	 * @author: guozhen
	 * @date:   2017年6月6日 下午4:39:59
	 *
	 */
	interface AlarmKey {

		/**
		 * @Fields KEY ：报警数据key
		 */
		String KEY = "ALARM";
		/**
		 * @Fields MAX_ALARM_LEVEL :  最高报警等级
		 */
		String MAX_ALARM_LEVEL = "MAX_ALARM_LEVEL";

		/**
		 * @Fields MAX_ALARM_LEVEL :  最高报警等级
		 */
		String ERROR_CODE = "ERROR_CODE";


		/**
		 * @Fields ALARM_MASK :  通用报警标志
		 */
		String ALARM_MASK = "ALARM_MASK";
		/**
		 * @Fields CELL_ALARM_NUM :  可充电储能装置故障总数
		 */
		String CELL_ALARM_NUM = "CELL_ALARM_NUM";
		/**
		 * @Fields ELECTRICMOTOR_ALARM_NUM :  驱动电机故障总数
		 */
		String ELECTRICMOTOR_ALARM_NUM = "ELECTRICMOTOR_ALARM_NUM";
		/**
		 * @Fields MOTOR_ALARM_NUM :  发动机故障总数
		 */
		String MOTOR_ALARM_NUM = "MOTOR_ALARM_NUM";
		/**
		 * @Fields OTHER_ALARM_NUM :  其他故障总数
		 */
		String OTHER_ALARM_NUM = "OTHER_ALARM_NUM";
		/**
		 * @Fields CELL_ALARM_LIST :  可充电储能装置故障列表
		 */
		String CELL_ALARM_LIST = "CELL_ALARM_LIST";
		/**
		 * @Fields ELECTRICMOTOR_ALARM_LIST :  驱动电机故障列表
		 */
		String ELECTRICMOTOR_ALARM_LIST = "ELECTRICMOTOR_ALARM_LIST";
		/**
		 * @Fields MOTOR_ALARM_LIST :  发动机故障列表
		 */
		String MOTOR_ALARM_LIST = "MOTOR_ALARM_LIST";
		/**
		 * @Fields OTHER_ALARM_LIST :  其他故障列表
		 */
		String OTHER_ALARM_LIST = "OTHER_ALARM_LIST";
		/**
		 * @Fields ALARM_MASK_TEMP_DIFF :  1温度差异报警 0正常
		 */
		String ALARM_MASK_TEMP_DIFF = "ALARM_MASK_TEMP_DIFF";
		/**
		 * @Fields ALARM_MASK_CELL_HIGH_TEMP :  1电池高温报警 0正常
		 */
		String ALARM_MASK_CELL_HIGH_TEMP = "ALARM_MASK_CELL_HIGH_TEMP";
		/**
		 * @Fields ALARM_MASK_ENERGY_STORAGE_OVER_VOLTAGE :  1 车载储能装置设备类型过压报警 0 正常
		 */
		String ALARM_MASK_ENERGY_STORAGE_OVER_VOLTAGE = "ALARM_MASK_ENERGY_STORAGE_OVER_VOLTAGE";
		/**
		 * @Fields ALARM_MASK_ENERGY_STORAGE_UNDER_VOLTAGE :  1 车载储能装置设备类型欠压报警 0 正常
		 */
		String ALARM_MASK_ENERGY_STORAGE_UNDER_VOLTAGE = "ALARM_MASK_ENERGY_STORAGE_UNDER_VOLTAGE";
		/**
		 * @Fields ALARM_MASK_SOC_LOW :  1 SOC低报警 0 正常
		 */
		String ALARM_MASK_SOC_LOW = "ALARM_MASK_SOC_LOW";
		/**
		 * @Fields ALARM_MASK_SINGLE_CELL_OVER_VOLTAGE : 1 单体电池过压报警 0 正常
		 */
		String ALARM_MASK_SINGLE_CELL_OVER_VOLTAGE = "ALARM_MASK_SINGLE_CELL_OVER_VOLTAGE";
		/**
		 * @Fields ALARM_MASK_SINGLE_CELL_UNDER_VOLTAGE :  1 单体电池欠压报警 0 正常
		 */
		String ALARM_MASK_SINGLE_CELL_UNDER_VOLTAGE = "ALARM_MASK_SINGLE_CELL_UNDER_VOLTAGE";
		/**
		 * @Fields ALARM_MASK_SOC_HIGH :   1 SOC过高报警 0 正常
		 */
		String ALARM_MASK_SOC_HIGH = "ALARM_MASK_SOC_HIGH";
		/**
		 * @Fields ALARM_MASK_SOC_SALTUS :  1 SOC跳变报警 0 正常
		 */
		String ALARM_MASK_SOC_SALTUS = "ALARM_MASK_SOC_SALTUS";
		/**
		 * @Fields ALARM_MASK_CELL_UNMATCHED :  1 可充电储能系统不匹配 0正常
		 */
		String ALARM_MASK_CELL_UNMATCHED = "ALARM_MASK_CELL_UNMATCHED";
		/**
		 * @Fields ALARM_MASK_SINGLE_CELL_UNIFORMITY :  1电池单体一致性差 0 正常
		 */
		String ALARM_MASK_SINGLE_CELL_UNIFORMITY = "ALARM_MASK_SINGLE_CELL_UNIFORMITY";
		/**
		 * @Fields ALARM_MASK_INSULATION :  1 绝缘报警 0正常
		 */
		String ALARM_MASK_INSULATION = "ALARM_MASK_INSULATION";
		/**
		 * @Fields ALARM_MASK_DCDC_TEMP : 1 DC-DC 温度报警 0 正常
		 */
		String ALARM_MASK_DCDC_TEMP = "ALARM_MASK_DCDC_TEMP";
		/**
		 * @Fields ALARM_MASK_BRAKE :  1 制动系统报警 0 正常
		 */
		String ALARM_MASK_BRAKE = "ALARM_MASK_BRAKE";
		/**
		 * @Fields ALARM_MASK_DCDC_STATE : 1 DC-DC状态报警 0 正常
		 */
		String ALARM_MASK_DCDC_STATE = "ALARM_MASK_DCDC_STATE";
		/**
		 * @Fields ALARM_MASK_CONTROL_TEMP : 1驱动电机控制器温度报警 0 正常
		 */
		String ALARM_MASK_CONTROL_TEMP = "ALARM_MASK_CONTROL_TEMP";
		/**
		 * @Fields ALARM_MASK_HVIL_STATE :  1 高压互锁状态报警 0 正常
		 */
		String ALARM_MASK_HVIL_STATE = "ALARM_MASK_HVIL_STATE";
		/**
		 * @Fields ALARM_MASK_ELECTRIC_MOTOR_TEMP :  1驱动电机温度报警 0正常
		 */
		String ALARM_MASK_ELECTRIC_MOTOR_TEMP = "ALARM_MASK_ELECTRIC_MOTOR_TEMP";
		/**
		 * @Fields ALARM_MASK_ENERGY_STORAGE_OVER_CHARGE :  1 车载储能装置设备类型过充报警 0 正常
		 */
		String ALARM_MASK_ENERGY_STORAGE_OVER_CHARGE = "ALARM_MASK_ENERGY_STORAGE_OVER_CHARGE";

		/**
		 * @Fields  1 电池故障 0 正常
		 */
		String ALARM_MASK_BATTERY_STATE = "ALARM_MASK_BATTERY_STATE";
		/**
		 * @Fields  1 电机故障 0 正常
		 */
		String ALARM_MASK_ELECTRICMOTOR_STATE = "ALARM_MASK_ELECTRICMOTOR_STATE";
		/**
		 * @Fields  1 转向故障 0 正常
		 */
		String ALARM_MASK_DIRECTION_STATE = "ALARM_MASK_DIRECTION_STATE";
		/**
		 * @Fields  1 遥控器故障 0 正常
		 */
		String ALARM_MASK_REMOTE_CONTROL_STATE = "ALARM_MASK_REMOTE_CONTROL_STATE";
		/**
		 * @Fields  1 激光雷达故障 0 正常
		 */
		String ALARM_MASK_LASER_RADAR_STATE = "ALARM_MASK_LASER_RADAR_STATE";
		/**
		 * @Fields  1 毫米波雷达故障 0 正常
		 */
		String ALARM_MASK_MILLIMETER_WAVE_RADAR_STATE = "ALARM_MASK_MILLIMETER_WAVE_RADAR_STATE";
		/**
		 * @Fields  1 相机故障 0 正常
		 */
		String ALARM_MASK_CAMERA_STATE = "ALARM_MASK_CAMERA_STATE";
		/**
		 * @Fields  1 导航故障 0 正常
		 */
		String ALARM_MASK_NAVIGATION_STATE = "ALARM_MASK_NAVIGATION_STATE";
		/**
		 * @Fields  1：HMI（人机交互）故障； 0：正常
		 */
		String ALARM_MASK_HMI_STATE="ALARM_MASK_HMI_STATE";
		/**
		 * @Fields  1：上装故障； 0：正常
		 */
		String ALARM_TOP_STATE="ALARM_TOP_STATE";

	}
	/**
	 * @ClassName:  CellVoltageKey
	 * @Description:电池电压数据 key定义
	 * @author: guozhen
	 * @date:   2017年6月9日 下午12:46:10
	 *
	 */
	/**
	 * @ClassName:  CellVoltageKey
	 * @Description:TODO(这里用一句话描述这个类的作用)
	 * @author: guozhen
	 * @date:   2017年6月9日 下午12:56:27
	 *
	 */
	interface CellVoltageKey {

		/**
		 * @Fields KEY ：电池电压数据 key
		 */
		String KEY = "CELL_VOLTAGE";
		/**
		 * @Fields CELL_VOLTAGE_LIST :  电池电压数据 列表
		 */
		String CELL_VOLTAGE_LIST = "CELL_VOLTAGE_LIST";
		/**
		 * @Fields CELL_NUM :  电池个数
		 */
		String CELL_NUM = "CELL_NUM";
		/**
		 * @Fields ID :  可充电储能子系统号
		 */
		String CELL_ID = "CELL_ID";
		/**
		 * @Fields ID :  可充电储能子系统 电池信息列表
		 */
		String CELL_FRAME_INFO_LIST = "CELL_FRAME_INFO_LIST";
		/**
		 * @Fields VOLTAGE :  可充电储能装置电压
		 */
		String VOLTAGE = "VOLTAGE";
		/**
		 * @Fields FLOW :  可充电储能装置电流
		 */
		String FLOW = "FLOW";
		/**
		 * @Fields UNITS :  单体电池总数
		 */
		String UNITS = "UNITS";
		/**
		 * @Fields CURRENT_ID :  本帧起始电池序号
		 */
		String CURRENT_ID = "CURRENT_ID";
		/**
		 * @Fields CURRENT_UNITS :  本帧单体电池总数
		 */
		String CURRENT_UNITS_NUM = "CURRENT_UNITS_NUM";
		/**
		 * @Fields UNITS_VOLTAGE :  单体电池电压
		 */
		String UNITS_VOLTAGE_LIST = "UNITS_VOLTAGE_LIST";

	}
	/**
	 * @ClassName:  CellTempKey
	 * @Description:电池温度数据 key定义
	 * @author: guozhen
	 * @date:   2017年6月9日 下午12:46:58
	 *
	 */
	interface CellTempKey {

		/**
		 * @Fields KEY ：电池温度数据key
		 */
		String KEY = "CELL_TEMP";
		/**
		 * @Fields CELL_VOLTAGE_LIST :  电池温度数据 列表
		 */
		String CELL_TEMP_LIST = "CELL_TEMP_LIST";
		/**
		 * @Fields CELL_NUM :  电池个数
		 */
		String CELL_NUM = "CELL_NUM";
		/**
		 * @Fields ID :  可充电储能子系统号
		 */
		String CELL_ID = "CELL_ID";
		/**
		 * @Fields DETECTOR_NUM :  可充电储能温度探针个数
		 */
		String DETECTOR_NUM = "DETECTOR_NUM";
		/**
		 * @Fields DETECTOR_VALUE_LIST :  可充电储能温度探针温度值 集合
		 */
		String DETECTOR_VALUE_LIST = "DETECTOR_VALUE_LIST";

	}

	/**
	 * @ClassName:  VLoginKey
	 * @Description: 车辆登入 数据key 常量定义
	 * @author: guozhen
	 * @date:   2017年6月8日 下午7:58:43
	 *
	 */
	interface VLoginKey {

		/**
		 * @Fields KEY ：车辆登入数据key
		 */
		String KEY = "VLOGIN";
		/**
		 * @Fields LOGIN_SN :  登入流水号
		 */
		String LOGIN_SN = "LOGIN_SN";
		/**
		 * @Fields ICCID :  ICCID
		 */
		String ICCID = "ICCID";
		/**
		 * @Fields CELL_NUM :  可充电储能子系统数
		 */
		String CELL_NUM = "CELL_NUM";
		/**
		 * @Fields CELL_CODE_LENGTH :  可充电储能子系统编码长度
		 */
		String CELL_CODE_LENGTH = "CELL_CODE_LENGTH";
		/**
		 * @Fields CELL_CODE :  可充电储能子系统编码
		 */
		String CELL_CODE = "CELL_CODE";
	}
	/**
	 * 计算后的可充电储能装备电压/温度的最大最小值、电机中最大的控制器温度和驱动电机温度
	 * @ClassName MaxMinKey
	 */
	interface MaxMinKey {

		String KEY = "MAXMIN_KEY";
		/**
		 * 可充电储能装备电压数据的最大电压
		 */
		String VOLTAGE_MAX_DATA = "VOLTAGE_MAX_DATA";

		/**
		 * 可充电储能装备电压数据的最大电压对应下标
		 */
		String VOLTAGE_MAX_INDEX = "VOLTAGE_MAX_INDEX";
		/**
		 * 可充电储能装备电压数据的最小电压
		 */
		String VOLTAGE_MIN_DATA = "VOLTAGE_MIN_DATA";
		/**
		 * 可充电储能装备电压数据的最小电压对应下标
		 */
		String VOLTAGE_MIN_INDEX = "VOLTAGE_MIN_INDEX";
		/**
		 * 可充电储能装备温度数据的最大温度
		 */
		String TEMP_MAX_DATA = "TEMP_MAX_DATA";
		/**
		 * 可充电储能装备温度数据的最大温度对应下标
		 */
		String TEMP_MAX_INDEX = "TEMP_MAX_INDEX";
		/**
		 * 可充电储能装备温度数据的最小温度
		 */
		String TEMP_MIN_DATA = "TEMP_MIN_DATA";
		/**
		 * 可充电储能装备温度数据的最小温度对应下标
		 */
		String TEMP_MIN_INDEX = "TEMP_MIN_INDEX";
		/**
		 * 驱动电机数据的最大控制器温度
		 */
		String CTRL_TEMPERATURE_MAX_DATA = "CTRL_TEMPERATURE_MAX_DATA";
		/**
		 * 驱动电机数据的最大电机温度
		 */
		String MOTOR_TEMPERATURE_MAX_DATA = "MOTOR_TEMPERATURE_MAX_DATA";

	}
	/**
	 * @ClassName:  VLogoutKey
	 * @Description:车辆登出 数据key
	 * @author: guozhen
	 * @date:   2017年6月8日 下午8:23:31
	 *
	 */
	interface VLogoutKey {

		/**
		 * @Fields KEY ：车辆登出数据key
		 */
		String KEY = "VLOGOUT";
		/**
		 * @Fields LOGOUT_SN :  车辆登出序列号
		 */
		String LOGOUT_SN = "LOGOUT_SN";
	}


	/**
	 * @ClassName:  QueryCmdKey
	 * @Description:查询参数数据key定义
	 * @author: guozhen
	 * @date:   2017年6月9日 下午6:00:01
	 *
	 */
	interface QueryCmdKey {

		/**
		 * @Fields KEY ：查询参数数据key
		 */
		String KEY = "QUERY";
		/**
		 * @Fields PARAM_NUM :  参数总数
		 */
		String PARAM_NUM = "PARAM_NUM";
		/**
		 * @Fields PARAM_LIST :  参数值列表
		 */
		String PARAM_LIST = "PARAM_LIST";

		/**
		 * @Fields PARAM_ID_CACHE_CYCLE :  终端缓存周期
		 */
		int PARAM_ID_CACHE_CYCLE = 0x01;
		/**
		 * @Fields PARAM_ID_UPLOAD_CYCLE :  正常上报周期
		 */
		int PARAM_ID_UPLOAD_CYCLE = 0x02;
		/**
		 * @Fields PARAM_ID_WARN_UPLOAD_CYCLE :  报警时，上报周期
		 */
		int PARAM_ID_WARN_UPLOAD_CYCLE = 0x03;
		/**
		 * @Fields PARAM_ID_DOMIN_LENGTH :  远程服务与管理平台域名长度
		 */
		int PARAM_ID_DOMIN_LENGTH = 0x04;
		/**
		 * @Fields PARAM_ID_DOMIN :  远程服务与管理平台域名
		 */
		int PARAM_ID_DOMIN = 0x05;
		/**
		 * @Fields PARAM_ID_DOMIN_PORT :  远程服务与管理平台域名端口
		 */
		int PARAM_ID_DOMIN_PORT = 0x06;
		/**
		 * @Fields PARAM_ID_HARDWARE_VERSION :  硬件版本
		 */
		int PARAM_ID_HARDWARE_VERSION = 0x07;
		/**
		 * @Fields PARAM_ID_SOFTWARE_VERSION :  固件版本
		 */
		int PARAM_ID_SOFTWARE_VERSION = 0x08;
		/**
		 * @Fields PARAM_ID_HEART_CYCLE :  心跳发送周期
		 */
		int PARAM_ID_HEART_CYCLE = 0x09;
		/**
		 * @Fields PARAM_ID_TERMINAL_RESPONSE_OVER_TIME :  终端应答超时周期
		 */
		int PARAM_ID_TERMINAL_RESPONSE_OVER_TIME = 0x0A;
		/**
		 * @Fields PARAM_ID_PLATFORM_RESPONSE_OVER_TIME :  平台应答超时周期
		 */
		int PARAM_ID_PLATFORM_RESPONSE_OVER_TIME = 0x0B;
		/**
		 * @Fields PARAM_ID_LOGIN_INTERVAL_TIME :  登录三次失败后的间隔周期
		 */
		int PARAM_ID_LOGIN_INTERVAL_TIME = 0x0C;
		/**
		 * @Fields PARAM_ID_PUBLIC_DOMIN_LENGTH :  公共平台域名长度
		 */
		int PARAM_ID_PUBLIC_DOMIN_LENGTH = 0x0D;
		/**
		 * @Fields PARAM_ID_PUBLIC_DOMIN :  公共平台域名
		 */
		int PARAM_ID_PUBLIC_DOMIN = 0x0E;
		/**
		 * @Fields PARAM_ID_PUBLIC_DOMIN_PORT :  公共平台域名端口
		 */
		int PARAM_ID_PUBLIC_DOMIN_PORT = 0x0F;
		/**
		 * @Fields PARAM_ID_IS_SAMPLING_INSPECTION :  是否处于抽样检测中
		 */
		int PARAM_ID_IS_SAMPLING_INSPECTION = 0x10;

		/**
		 * @Fields PARAM_ID_BMS_VERSION :  BMS版本
		 */
		int PARAM_ID_BMS_VERSION = 0x93;




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

		int PAARM_ID_CMD_SET_QQZC=0x8F;
		//--------新增需求结束


		//-------以下需求新增于2017.07.20
		/**
		 * 终端SN号
		 */
		int PARAM_ID_TERMINAL_SN = 0xE0;
		/**
		 * SPI_FLASH状态
		 */
		int PARAM_ID_SPI_FLASH_STATE = 0xE1;
		/**
		 * GPS状态
		 */
		int PARAM_ID_GPS_STATE = 0xE2;
		/**
		 * GPS卫星颗数
		 */
		int PARAM_ID_GPS_SATELLITE_COUNT = 0xE3;
		/**
		 * GSM信号强度
		 */
		int PARAM_ID_GSM_SIGNAL_INTENSITY = 0xE4;
		/**
		 * Gsensor状态
		 */
		int PARAM_ID_GSENSOR_STATE = 0xE5;
		/**
		 * CAN状态
		 */
		int PARAM_ID_CAN_STATE = 0xE6;
		/**
		 * 其它IO状态
		 */
		int PARAM_ID_OTHER_IO_STATE = 0xE7;
		/**
		 * 主电电压
		 */
		int PARAM_ID_MAIN_POWER_VALUE = 0xE8;
		/**
		 * Car VIN
		 */
		int PARAM_ID_CAR_VIN = 0xE9;
		/**
		 * Sim卡ICCID值
		 */
		public static final int PARAM_ID_SIM_ICCID = 0xEA;
		//--------新增需求结束

	}

	/**
	 * @ClassName:  SetCmdKey
	 * @Description:设置参数数据key定义
	 * @author: guozhen
	 * @date:   2017年6月9日 下午6:00:01
	 *
	 */
	interface SetCmdKey {

		/**
		 * @Fields KEY ：设置参数数据key
		 */
		String KEY = "SET";
	}
	/**
	 * @ClassName:  ControlCmdKey
	 * @Description:控制命令数据key定义
	 * @author: guozhen
	 * @date:   2017年6月9日 下午6:00:01
	 *
	 */
	interface ControlCmdKey {

		/**
		 * @Fields KEY ：控制命令数据key
		 */
		String KEY = "CONTROL";
		/**
		 * @Fields CMD_ID :  命令ID
		 */
		String CMD_ID = "CMD_ID";
		/**
		 * @Fields CMD_ID_NONE :
		 */
		int CMD_ID_NONE = 0x00;
		/**
		 * @Fields CMD_ID_UPGRADE :
		 */
		int CMD_ID_UPGRADE = 0x01;

		/**
		 * @Fields CMD_ID_UPGRADE :
		 */
		int CMD_VCU_UPGRADE = 0x96;
		/**
		 * @Fields CMD_ID_SHUTDOWN :
		 */
		int CMD_ID_SHUTDOWN = 0x02;
		/**
		 * @Fields CMD_ID_RESET :
		 */
		int CMD_ID_RESET = 0x03;
		/**
		 * @Fields CMD_ID_FACTORY_RESET :
		 */
		int CMD_ID_FACTORY_RESET = 0x04;
		/**
		 * @Fields CMD_ID_BROKEN_LINK :
		 */
		int CMD_ID_BROKEN_LINK = 0x05;
		/**
		 * @Fields CMD_ID_TERMINAL_WARN :
		 */
		int CMD_ID_TERMINAL_WARN = 0x06;
		/**
		 * @Fields CMD_ID_OPEN_SAMPLE_LINK :
		 */
		int CMD_ID_OPEN_SAMPLE_LINK = 0x07;
		//TODO
		/**
		 * 用户自定义  之远程车辆控制
		 */
		int CMD_ID_CUSTOM_REMOTE_CONTROL = 0x80;
		/**
		 * 用户自定义  之远程车身控制
		 */
		public static final int CMD_ID_CUSTOM_REMOTE_CARBODY_CONTROL = 0x81;
		/**
		 * 用户自定义  之平台透传终端数据
		 */
		public static final int PLATFORM_TERMINAL_DATA = 0x83;
		/**
		 * 用户自定义  之湖州矿车电子围栏告警
		 */
		public static final int HuZhouKuangChe_FenceAlarm = 0x84;
		/**
		 * @Fields CMD_ID_UPLOAD_CAN  上传原始CAN文件 :
		 */
		int CMD_ID_UPLOAD_CAN_FILE = 0x92;
		/**
		 * @Fields UPGRADE :  升级
		 */
		String UPGRADE = "UPGRADE";
		/**
		 * @Fields UPGRADE_NAME :  拨号点名称
		 */
		String UPGRADE_NAME = "UPGRADE_NAME";
		/**
		 * @Fields UPGRADE_USERNAME :  用户名
		 */
		String UPGRADE_USERNAME = "UPGRADE_USERNAME";
		/**
		 * @Fields UPGRADE_PASS :  密码
		 */
		String UPGRADE_PASS = "UPGRADE_PASS";
		/**
		 * @Fields UPGRADE_ADDRESS :  地址
		 */
		String UPGRADE_ADDRESS = "UPGRADE_ADDRESS";
		/**
		 * @Fields UPGRADE_PORT :  端口
		 */
		String UPGRADE_PORT = "UPGRADE_PORT";
		/**
		 * @Fields UPGRADE_TERMINAL_MAKER :  制造商
		 */
		String UPGRADE_TERMINAL_MAKER = "UPGRADE_TERMINAL_MAKER";
		/**
		 * @Fields UPGRADE_HARDWARE_VERSION :  硬件版本
		 */
		String UPGRADE_HARDWARE_VERSION = "UPGRADE_HARDWARE_VERSION";
		/**
		 * @Fields UPGRADE_SOFTWARE_VERSION :  固件版本
		 */
		String UPGRADE_SOFTWARE_VERSION = "UPGRADE_SOFTWARE_VERSION";
		/**
		 * @Fields UPGRADE_URL :  升级URL地址
		 */
		String UPGRADE_URL = "UPGRADE_URL";
		/**
		 * @Fields UPGRADE_LIMIT_TIME :  连接到升级服务器时限
		 */
		String UPGRADE_LIMIT_TIME = "UPGRADE_LIMIT_TIME";
		/**
		 * @Fields UPLOAD_CAN_FILE :  上传CAN文件
		 */
		String UPLOAD_CAN_FILE = "UPLOAD_CAN_FILE";
		/**
		 * @Fields UPLOAD_CAN_FILE_TIME :  上传CAN文件的时间
		 */
		String UPLOAD_CAN_FILE_TIME = "UPLOAD_CAN_FILE_TIME";
		/**
		 * @Fields UPLOAD_CAN_FILE_USERNAME :  上传CAN文件的用户名
		 */
		String  UPLOAD_CAN_FILE_USERNAME = "UPLOAD_CAN_FILE_USERNAME";
		/**
		 * @Fields UPLOAD_CAN_FILE_PASS :  上传CAN文件的密码
		 */
		String  UPLOAD_CAN_FILE_PASS = "UPLOAD_CAN_FILE_PASS";
		/**
		 * @Fields UPLOAD_CAN_FILE_HOST :  上传CAN文件的IP地址
		 */
		String UPLOAD_CAN_FILE_HOST = "UPLOAD_CAN_FILE_HOST";
		/**
		 * @Fields UPLOAD_CAN_FILE_PORT :  上传CAN文件的端口
		 */
		String UPLOAD_CAN_FILE_PORT = "UPLOAD_CAN_FILE_PORT";
		/**
		 * @Fields UPLOAD_CAN_FILE_PATH :  上传CAN文件的保存路径
		 */
		String UPLOAD_CAN_FILE_PATH = "UPLOAD_CAN_FILE_PATH";
		/**
		 * @Fields WARN :
		 */
		String WARN = "WARN";
		/**
		 * @Fields WARN_LEVEL :  警告等级
		 */
		String WARN_LEVEL = "WARN_LEVEL";

		/**
		 * @Fields PLATEFORM_TERMINAL_DATA :  平台透传终端数据
		 */
		String PLATEFORM_TERMINAL_DATA = "PLATEFORM_TERMINAL_DATA";

	}

	interface ExtDataKey {

		/**
		 * @Fields KEY ：附加数据key
		 */
		String KEY = "EXT_DATA";
		/**
		 * @Fields KEY ：硬件功能状态 数据key
		 */
		String EXT_DATA_HARDWARE = "EXT_DATA_HARDWARE";
		/**
		 * @Fields KEY ： 无线通信网络信号强度 数据key
		 */
		String EXT_DATA_NETWORK_SIGNAL = "EXT_DATA_NETWORK_SIGNAL";

		/**
		 * @Fields KEY ： GNSS 定位卫星数 数据key
		 */
		String EXT_DATA_GNSS = "EXT_DATA_GNSS";

		/**
		 * @Fields 硬件功能状态的32位二进制字符串 :
		 */
		String EXT_DATA_DATATYPE_HARDWARE_32STRING = "EXT_DATA_DATATYPE_HARDWARE_32STRING";

		/**
		 * @Fields 硬件功能状态 :
		 */
		int EXT_DATA_DATATYPE_HARDWARE = 0x01;
		/**
		 * @Fields 无线通信网络信号强度 :
		 */
		int EXT_DATA_DATATYPE_NETWORK_SIGNAL = 0x02;
		/**
		 * @Fields GNSS 定位卫星数：
		 */
		int EXT_DATA_DATATYPE_GNSS = 0x03;


		/**
		 * @Fields KEY ：GPRS功能验证运行状态 0表示异常工作，1表示正常工作
		 */
		String EXT_DATA_HARDWARE_STATES_GPRS = "EXT_DATA_HARDWARE_STATES_GPRS";
		/**
		 * @Fields KEY ：GPS功能验证运行状态 0表示异常工作，1表示正常工作
		 */
		String EXT_DATA_HARDWARE_STATES_GPS = "EXT_DATA_HARDWARE_STATES_GPS";
		/**
		 * @Fields KEY ：BT功能验证运行状态 0表示异常工作，1表示正常工作
		 */
		String EXT_DATA_HARDWARE_STATES_BT = "EXT_DATA_HARDWARE_STATES_BT";
		/**
		 * @Fields KEY ：DI1DO1功能验证运行状态 0表示异常工作，1表示正常工作
		 */
		String EXT_DATA_HARDWARE_STATES_DI1DO1 = "EXT_DATA_HARDWARE_STATES_DI1DO1";
		/**
		 * @Fields KEY : DI2DO2功能验证运行状态
		 */
		String EXT_DATA_HARDWARE_STATES_DI2DO2 = "EXT_DATA_HARDWARE_STATES_DI2DO2";
		/**
		 * @Fields KEY : DI3DO3功能验证运行状态
		 */
		String EXT_DATA_HARDWARE_STATES_DI3DO3 = "EXT_DATA_HARDWARE_STATES_DI3DO3";
		/**
		 * @Fields KEY : DI4DO4功能验证运行状态
		 */
		String EXT_DATA_HARDWARE_STATES_DI4DO4 = "EXT_DATA_HARDWARE_STATES_DI4DO4";
		/**
		 * @Fields KEY : DI5DO5功能验证运行状态
		 */
		String EXT_DATA_HARDWARE_STATES_DI5DO5 = "EXT_DATA_HARDWARE_STATES_DI5DO5";
		/**
		 * @Fields KEY : AI功能验证运行状态
		 */
		String EXT_DATA_HARDWARE_STATES_AI = "EXT_DATA_HARDWARE_STATES_AI";
		/**
		 * @Fields KEY : 互锁功能验证运行状态
		 */
		String EXT_DATA_HARDWARE_STATES_INTERLOCK = "EXT_DATA_HARDWARE_STATES_INTERLOCK";
		/**
		 * @Fields KEY : CAN功能验证运行状态
		 */
		String EXT_DATA_HARDWARE_STATES_CAN = "EXT_DATA_HARDWARE_STATES_CAN";
		/**
		 * @Fields KEY : 232串口功能验证运行状态
		 */
		String EXT_DATA_HARDWARE_STATES_232SERIAL = "EXT_DATA_HARDWARE_STATES_232SERIAL";
		/**
		 * @Fields KEY : SD卡功能验证运行状态
		 */
		String EXT_DATA_HARDWARE_STATES_SD = "EXT_DATA_HARDWARE_STATES_SD";
		/**
		 * @Fields KEY : FLASH功能验证运行状态
		 */
		String EXT_DATA_HARDWARE_STATES_FLASH = "EXT_DATA_HARDWARE_STATES_FLASH";
		/**
		 * @Fields KEY : 三轴加速功能验证运行状态
		 */
		String EXT_DATA_HARDWARE_STATES_TRIAXIALACCELERATE = "EXT_DATA_HARDWARE_STATES_TRIAXIALACCELERATE";

	}

	/**
	 * 自定义数据组之 舒驰协议CAN数据 的常量定义(会在json中使用)
	 * @author ql
	 * 2018年3月23日
	 */
	interface ShuChiCanData {
		/**
		 * 在JSON结果中的KEY
		 */
		String KEY = "ShuChiCanData";
		/**
		 * 终端消息体长度
		 */
		String TerminalMessageLength = "TerminalMessageLength";
		/**
		 * CAN网络消息体长度
		 */
		String CanMessageLength = "CanMessageLength";
		/**
		 * 消息流水号
		 */
		String MessageSN = "MessageSN";
		/**
		 * 终端ID\SN
		 */
		String TerminalID = "TerminalID";
		/**
		 * 子设备代码
		 */
		String SubDeviceCode = "SubDeviceCode";
		/**
		 * 密钥(加密规则)
		 */
		String Encrypted = "Encrypted";
		/**
		 * GPS供应商代码
		 */
		String GpsSupplierCode = "GpsSupplierCode";

		/**
		 * 终端数据消息体 内的内容
		 * @author ql
		 * 2018年3月27日
		 */
		interface TerminalMessageBody {
			/**
			 * 在JSON结果中的KEY
			 */
			String KEY = "TerminalMessageBody";
			/**
			 * 数据上报原因
			 */
			String ReportReason = "ReportReason";
			/**
			 * 经度
			 */
			String Longitude = "Longitude";
			/**
			 * 纬度
			 */
			String Latitude = "Latitude";
			/**
			 * 速度
			 */
			String Speed = "Speed";
			/**
			 * 高度
			 */
			String Height = "Height";
			/**
			 * 方向角
			 */
			String ForDirect = "ForDirect";
			/**
			 * 里程(行驶距离)
			 */
			String Distance = "Distance";
			/**
			 * 硬件版本号
			 */
			String HardwareVersion = "HardwareVersion";
			/**
			 * 软件版本号
			 */
			String SoftwareVersion = "SoftwareVersion";
			/**
			 * 时间(GPS的时间)
			 */
			String GpsTime = "GpsTime";
			/**
			 * GPS模块状态
			 */
			String GpsState = "GpsState";
		}

		/**
		 * CAN网络消息体 内的内容
		 * @author ql
		 * 2018年3月23日
		 */
		interface CanMessageBody {
			/**
			 * 定义数据的CanFrame类型
			 */
			String CanFrameType = "CanFrameType";
			/**
			 * 在JSON结果中的KEY
			 */
			String KEY = "CanMessageBody";
			/**
			 * 数据上报原因
			 */
			String ReportReason = "ReportReason";
			/**
			 * 上报数据包序列号
			 */
			String DataSN = "DataSN";
			/**
			 * 经度
			 */
			String Longitude = "Longitude";
			/**
			 * 纬度
			 */
			String Latitude = "Latitude";
			/**
			 * 速度
			 */
			String Speed = "Speed";
			/**
			 * 高度
			 */
			String Height = "Height";
			/**
			 * 方向角
			 */
			String ForDirect = "ForDirect";
			/**
			 * 起始帧时间
			 */
			String InitialFrameTime = "InitialFrameTime";
			/**
			 * CAN数据格式
			 */
			String CanDataForm = "CanDataForm";
			/**
			 * CAN数据包个数 (因车机程序原因, 上传的值可能不准确)
			 */
			String CanDataPackagesCount = "CanDataPackagesCount";

			/**
			 * CAN网络数据消息体中的 CAN帧包中的共同部分的KEY值(不同部分的KEY值需另从配置文件中取)
			 * @author ql
			 * 2018年3月23日
			 */
			interface CanFrame {
				String KEY = "PleaseGetFromConfigurationFile";
				/**
				 * 和上包CAN数据的时间间隔
				 */
				String IntervalWithPrevious = "IntervalWithPrevious";
				/**
				 * CAN数据帧ID
				 */
				String CanFrameId = "CanFrameId";
				/**
				 * CAN数据帧所属通道
				 */
				String CanFrameChannel = "CanFrameChannel";
				/**
				 * 标识此CAN数据是舒驰的数据 或武汉理工特汽 或湖州矿车的数据
				 * @author ql
				 * 2018年4月21日 下午4:27:57
				 */
				enum CanFrameType {
					ShuChiCanData,WuhanligongTeQi,HuZhouKuangChe
				}
			}
		}
	}

	/**
	 *
	 * @ClassName: HFuelKey
	 * @Description:氢燃料国标附加数据key 常量定义
	 * @author: weizhiheng
	 * @date: 2023年3月6日 下午3:53:29
	 *
	 */
	interface FuelDataKey {
		/**
		 * @Fields KEY ：氢燃料国标附加数据key
		 */
		String KEY = "FUEL_DATA";
		/**
		 * @Fields RESERVE : 预留
		 */
		String RESERVE = "RESERVE";
		/**
		 * @Fields STACK_TEMPERATURE : 电堆温度
		 */
		String STACK_TEMPERATURE = "STACK_TEMPERATURE";
		/**
		 * @Fields AIR_COMPRESSOR_VOLTAGE : 空气压缩机电压
		 */
		String AIR_COMPRESSOR_VOLTAGE = "AIR_COMPRESSOR_VOLTAGE";
		/**
		 * @Fields AIR_COMPRESSOR_CURRENT : 空气压缩机电流
		 */
		String AIR_COMPRESSOR_CURRENT = "AIR_COMPRESSOR_CURRENT";
		/**
		 * @Fields HYDROGEN_CIRCULATING_PUMP_VOLTAGE : 氢气循环泵电压
		 */
		String HYDROGEN_CIRCULATING_PUMP_VOLTAGE = "HYDROGEN_CIRCULATING_PUMP_VOLTAGE";
		/**
		 * @Fields HYDROGEN_CIRCULATING_PUMP_CURRENT : 氢气循环泵电流
		 */
		String HYDROGEN_CIRCULATING_PUMP_CURRENT = "HYDROGEN_CIRCULATING_PUMP_CURRENT";

	}
	/**
	 * OBD数据
	 * @author chenjt
	 *
	 */
	interface TEQI_OBD_Data{
		/**
		 * @Fields KEY ：OBD数据key
		 */
		String KEY = "TEQI_OBD_Data";

	}
}
