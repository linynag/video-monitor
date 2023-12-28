package com.yiwei.common.dataConsts;

public class VDPConst {
	public final static int MSG_COMMAND = 0x1003;

	public final static int MSG_COMMAND_RESPONSE = 0x1004;
	/**
	 * 如果返回结果只包含一个数据包，类型设置为 MSG_COMMAND_RESPONSE (默认)<br>
	 * 如果返回结果包含多个数据包，第一包的类型设置为 MSG_COMMAND_RESPONSE_START . <br>
	 * 最后一包设置为 TYPE_RES_PACKAGES_END <br>
	 * 其余包均为 MSG_COMMAND_RESPONSE_MID 客户端收到 MSG_COMMAND_RESPONSE_START ，直到收到
	 * MSG_COMMAND_RESPONSE_END才算是完全接收结果
	 */

	public final static int MSG_COMMAND_RESPONSE_START = 0x1005;
	public final static int MSG_COMMAND_RESPONSE_MID = 0x1006;
	public final static int MSG_COMMAND_RESPONSE_END = 0x1007;
	public final static int MSG_COMMAND_NODATA = 0x1008;
	public final static int MSG_COMMAND_ERROR = 0x1009;

	public final static String DATA_GPSDATA = "GPSDATA";//GPS数据

	public final static String DATA_EXPAND = "EXPAND"; // 拓展数据
	public final static String DATA_AGENT_CONNECT = "CONNECT";// 设备连接信息
	public final static String DATA_RTINFO = "RTINFO";// 实时数据
	public final static String DATA_CANINFO = "CANINFO";// 实时数据
	public final static String VCU_STATUS = "VCUSTATUS";// 实时数据
	public final static String DATA_ShuChiCanData = "RTINFO_ShuChiCanData";// 实时数据中的舒驰数据
	public final static String DATA_FIXINFO = "FIXINFO"; // 补发数据
	public final static String DATA_SCDATA = "SCDATA";// SC数据
	public final static String DATA_STATE = "EDATA"; // 车辆状态数据
	public final static String DATA_ALARM = "ALARM"; // 告警数据
	public final static String DATA_QB_ALARM = "QB_ALARM"; // 告警数据
	public final static String DATA_UPPER_ALARM = "UPPER_ALARM"; // 告警数据
	public final static String DATA_FAULT_CODE = "FAULTCODE"; // 故障码
	public final static String DATA_RAW = "RAW"; // 原始数据
	public final static String DATA_CAN_RAW = "CAN_RAW"; // 原始数据
	public final static String DATA_NULL = "NULL"; // 空数据
	public final static String DATA_SNAP = "SNAP"; // 快照数据
	public final static String DATA_EVENT = "EVENT"; // 事件数据
	public final static String DATA_COMMAND = "COMMAND"; // 事件数据
	public final static String DATA_BMS = "BMS"; // 电池数据
	public final static String DATA_PHOTO_REQ = "PHOTO_REQ"; // 事件数据
	public final static String DATA_PHOTO = "PHOTO"; // 事件数据
	public final static String DATA_PHOTO_RES = "PHOTO_RES"; // 事件数据
	public final static String DATA_VLOGIN = "VLOGIN"; // 登入数据
	public final static String DATA_VLOGOUT = "VLOGOUT"; // 登出数据

	public final static String EVENT_CHARGE_START = "EVENT_CHARGE_START"; // 事件充电开始
	public final static String EVENT_CHARGE_END = "EVENT_CHARGE_END"; // 事件充电结束

	public final static String EVENT_FAULT_START = "EVENT_FAULT_START"; // 事件充电开始
	public final static String EVENT_FAULT_END = "EVENT_FAULT_END"; // 事件充电结束

	public final static String EVENT_FANCE_ENTER = "EVENT_FANCE_ENTER"; // 进入围栏
	public final static String EVENT_FANCE_LEAVE = "EVENT_FANCE_LEAVE"; // 离开围栏

	/**
	 * 原始数据归档key
	 */
	public interface RAW_DATA{
		String OBJECTID = "_id";
		String DEVCODE = "DEVCODE";
		String RECVTIME = "RECVTIME";
		String FUNID = "FUNID";
		String SN = "SN";
		String NAME = "NAME";
		String DATA = "DATA";
		String RESPONSE = "RESPONSE";
		String RESPONSETIME = "RESPONSETIME";
		String REPSN = "REPSN";
		String DEVTIME = "DEVTIME";
		String CHECK = "CHECK";//原始数据报文正确校验标识, 0代表报文错误, 1代表报文正确
		String DATASIZE = "DATASIZE";//原始报文长度标识
		String BUSID = "BUSID";//业务唯一标识ID(vin码+数据产生时间+报文标识)
		String FAILURE_CODES = "FAILURE_CODES";//报文校验错误码
	}

}
