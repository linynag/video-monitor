package com.yiwei.common.dataConsts;

/**
 * 自定义系统字典的相关常量
 * @author: chenxin
 * @date: 2020/1/7 15:36
 */
public class DictConsts {
    /**
     * 告警进度,字典alarmProgressStatus 1-正在报警 2-报警结束
     */
    public static final String PROGRESS_STATUS_WARNING = "1";
    public static final String PROGRESS_STATUS_END = "2";

    /**
     * upgrade_status
     * 0-已回包;  1-升级文件下载成功;  2-升级文件下载失败;   3-VCU升级成功;   4-VCU升级失败
     *
     */
    public static final String UPGRADE_STATUS_START = "0";
    public static final String UPGRADE_STATUS_DOWNLOAD_SUCCESS = "1";
    public static final String UPGRADE_STATUS_DOWNLOAD_FAIL = "2";
    public static final String UPGRADE_STATUS_UPGRADE_SUCCESS = "3";
    public static final String UPGRADE_STATUS_UPGRADE_FAIL = "4";
    /**
     * 文件类型
     * fileType 1-文件夹  2-文件
     */
    public static final String FILE_TYPE_FILE = "2";
    public static final String FILE_TYPE_FOLDER = "1";
    /**
     过检链路类型 0:平台过检 1:车辆过检 2:正式过检
     */
    public static final String VALIDATION_TYPE_PLATFORM = "0";
    public static final String VALIDATION_TYPE_VEHICLE = "1";
    public static final String VALIDATION_TYPE_RIGHT = "2";
    /**
     当前转发状态 0-关闭 1-开启
     */
    public static final String TRANSFER_STATUS_ON = "1";
    public static final String TRANSFER_STATUS_CLOSE = "0";
    /**
     服务状态 0-未更新 1-正常 2-预警 3-报警
     */
    public static final String SERVICE_STATUS_NOT_UPDATED = "0";
    public static final String SERVICE_STATUS_NORMAL = "1";
    public static final String SERVICE_STATUS_EARLY_WARNING = "2";
    public static final String SERVICE_STATUS_WARNING = "3";

    public static final String ORG_TYPE_COMPANY = "1";
    public static final String ALARM_MASK = "1";
    // 告警
    public static final String ALARM_STATUS_NO = "0";
    public static final String ALARM_STATUS_YES = "1";
    public static final String ALARM_STATUS_GB = "11";
    public static final String ALARM_STATUS_QB = "21";
    public static final String ALARM_STATUS_GQB = "22";
    public static final String ALARM_STATUS_UPPER = "31";
    // 告警登记
    public static final String ALARM_LEVEL_ZERO = "0";
    public static final String ALARM_LEVEL_ONE = "1";
    public static final String ALARM_LEVEL_TWO = "2";
    public static final String ALARM_LEVEL_THREE = "3";

    // 点熄火
    public static final String TRIP_FLAME_STARTUP = "1";
    public static final String TRIP_FLAME_STARTOFF = "2";

    /**
     * 删除标识状态,0-否,1-是
     */
    public static final String NOT_DELETE = "0";
    public static final String DELETE = "1";

    /**
     * 绑定状态,0-未绑定/解绑,1-绑定,2-已解绑
     */
    public static final String UNBIND = "0";
    public static final String BIND = "1";
    public static final String RELIEVE_BIND = "2";

    /**
     * 车机被使用状态0、未使用1、正在使用9、故障'
     */
    public static final String DEVICE_NOT_USE = "0";
    public static final String DEVICE_USEED = "1";
    public static final String DEVICE_FAULT = "9";

    /**
     * 平台状态 1、有效
     */
    public static final String PLATFORM_STATUS_VAILD = "1";
    /**
     * 角色类型 1、有效
     */
    public static final String ROLE_TYPE_ONE = "1";

    /**
     * 0-未启用 1-启用
     */
    public static final String START_UP_ZERO = "0";
    public static final String START_UP_ONE = "1";

    /**
     * 指令执行状态：0;未执行, 1:正在执行, 2:执行完毕, 3:执行失败, 4:手动取消'
     */
    public static final String BATCH_ZERO = "0";
    public static final String BATCH_ONE = "1";
    public static final String BATCH_TWO = "2";
    public static final String BATCH_HTREE = "3";
    public static final String BATCH_FOUR = "4";




    /**
     * 车机连接状态 字典:commonOnlineStatus 1-在线 0-离线
     */
    public static final String NETWORK_STATUS_OFFLINE = "0";
    public static final String NETWORK_STATUS_ONLINE = "1";

    /**
     * 车辆状态 字典:vehicleStatus 1-启动 2-熄火 3-其他状态 254-异常 255-无效
     */
    public static final String VEHICLE_STATUS_STARTUP = "1";
    public static final String VEHICLE_STATUS_SHUTDOWN = "2";

    /**
     * 充电状态 字典:chargeStatus 1-停车充电 2-行驶充电 3-未充电状态 4-充电完成 254-异常 255-无效
     */
    public static final String CHARGE_STATUS_PARKING_CHARGE = "1";
    public static final String CHARGE_STATUS_ROAD_CHARGE = "2";
    public static final String CHARGE_STATUS_NOT_CHARGE = "3";
    public static final String CHARGE_STATUS_FINISH_CHARGE = "4";

    /**
     * 文件类型 字典downloadFileType 1-原始数据，2-历史数据',1是企标，0非企标
     */
    public static final String FILE_TYPE_RAW = "1";
    public static final String FILE_TYPE_HISTORY = "2";
    public static final String IS_QB_Y = "1";

    /**
     * 下载状态 字典 downloadStatus 0-失败 1-成功，2-正在生成
     */
    public static final String DOWNLOAD_STATUS_FAIL = "0";
    public static final String DOWNLOAD_STATUS_SUCCESS = "1";
    public static final String DOWNLOAD_STATUS_CREATE = "2";

    /**
     * 字典 COMMONWHETHER 通用-是/否
     */
    public static final String NO = "0";
    public static final String YES = "1";

    /**
     * 字典 excel工具了类型 1-维德电源, 2-清清智橙
     */
    public static final Integer ORG_TPYE_WDDY = 1;
    public static final Integer ORG_TPYE_QQZC = 2;

    /**
     * 字典carPurchase 购车领域 1-私人用车, 2-单位用车
     */
    public static final String CAR_PURCHASE_PRIVATE_VALUE = "1";
    public static final String CAR_PURCHASE_UNIT_VALUE = "2";
}
