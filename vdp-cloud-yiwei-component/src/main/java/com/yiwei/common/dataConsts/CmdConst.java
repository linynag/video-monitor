package com.yiwei.common.dataConsts;

public class CmdConst {
    /**
     * @Fields VLR_IS_ONLINE :  查询是否在线
     */
    public static final String VLR_IS_ONLINE = "VLR_IS_ONLINE";
    /**
     * @Fields VLR_QUERY_SINGLE :  查询单个车机的实时数据
     */
    public static final String VLR_QUERY_SINGLE = "VLR_QUERY_SINGLE";
    /**
     * @Fields VLR_QUERY_BATCH :  批量查询车机实时数据
     */
    public static final String VLR_QUERY_BATCH = "VLR_QUERY_BATCH";
    /**
     * @Fields VLR_QUERY_BATCH_GPS :  批量查询车辆位置信息数据
     */
    public static final String VLR_QUERY_BATCH_GPS = "VLR_QUERY_BATCH_GPS";

    /**
     * @Fields VLR_DEV_VALIDITY_CHECK :  车机合法性校验
     */
    public static final String VLR_DEV_VALIDITY_CHECK = "VLR_DEV_VALIDITY_CHECK";

    /**
     * @Fields VLR_DEV_BIND_VIN :  车机绑定VIN(用于在SC发起绑定命令到VLR进行绑定)
     */
    public static final String VLR_DEV_BIND_VIN = "VLR_DEV_BIND_VIN";

    /**
     * @Fields VLR_DEV_MODIFY_STATUS :  车机绑定VIN(用于在SC发起绑定命令到VLR进行修改指定车机的使用状态)
     */
    public static final String VLR_DEV_MODIFY_STATUS = "VLR_DEV_MODIFY_STATUS";
    /**
     * 查找所有在线的车机id
     */
    public static final String VLR_QUERY_ONLINE_DEVCODE = "VLR_QUERY_ONLINE_DEVCODE";
    public static final String DQS_QUERY_SINGLE = "DQS_QUERY_SINGLE";
    public static final String DQS_QUERY_BATCH = "DQS_QUERY_BATCH";
    /**
     * 分页
     */
    public static final String DQS_QUERY_BATCH_PAGE = "DQS_QUERY_BATCH_PAGE";
    public static final String DQS_QUERY_BATCH_HEAD_TAIL = "DQS_QUERY_BATCH_HEAD_TAIL";

    public static final String DQS_QUERY_SNAP = "DQS_QUERY_SNAP";

    public static final String DQS_QUERY_EVENT = "DQS_QUERY_EVENT";
    public static final String DQS_RAW_BATCH = "DQS_RAW_BATCH";
    /**
     * 分页
     */
    public static final String DQS_RAW_BATCH_PAGE = "DQS_RAW_BATCH_PAGE";

    public static final String CMD_CONTROL = "CMD_CONTROL";

    /**
     * @Fields CMD_CONTROL_GB :  国标控制命令定义
     */
    public static final String CMD_CONTROL_GB = "CMD_CONTROL_GB";
    /**
     * @Fields CMD_SET_GB :  国标设置命令 定义
     */
    public static final String CMD_SET_GB = "CMD_SET_GB";
    public static final String CMD_SET_GB_QQZC = "CMD_SET_GB_QQZC";

    /**
     * @Fields CMD_SET_GB :  国标设置命令 定义
     */
    public static final String CMD_SET_QQZC = "CMD_SET_QQZC";
    /**
     * @Fields CMD_QUERY_GB :  国标查询命令定义
     */
    public static final String CMD_QUERY_GB = "CMD_QUERY_GB";
    public static final String CMD_CONTROL_0424 = "CMD_CONTROL_0424";
    /**
     * 设置蓝牙密码
     */
    public static final String CMD_SETBTPASSWD = "CMD_SETBTPASSWD";
    public static final String CMD_SETBTVAILDATE = "CMD_SETBTVAILDATE";

    /**
     * 终端升级
     */
    public static final String CMD_UPGRADE = "CMD_UPGRADE";
    public static final String CMD_UPGRADE_VERSION = "CMD_UPGRADE_VERSION";
    public static final String CMD_UPGRADE_FTP_ADDRESS = "CMD_UPGRADE_FTP ADDRESS";
    public static final String CMD_UPGRADE_FTP_PORT = "CMD_UPGRADE_FTP_PORT";
    public static final String CMD_UPGRADE_USRE_NAME = "CMD_UPGRADE_USRE_NAME";
    public static final String CMD_UPGRADE_FILE_NAME = "CMD_UPGRADE_FILE_NAME";
    public static final String CMD_UPGRADE_FILE_PATH = "CMD_UPGRADE_FILE_PATH";
    public static final String CMD_UPGRADE_PASSWD = "CMD_UPGRADE_PASSWD";

    /**
     * 设置GPRS参数
     */
    public static final String CMD_GPRS = "CMD_GPRS";
    /**
     * 0--备份通讯参数，下次上线切换    1--立即下线重新上线
     */
    public static final String CMD_GPRS_SWITCH = "CMD_GPRS_SWITCH";
    /**
     * 通讯参数包数, 如"2"表示两个通信参数包
     */
    public static final String CMD_GPRS_PACKNUM = "CMD_GPRS_SWITCH_PACKNUM";
    /**
     * 通讯参数包序号
     */
    public static final String CMD_GPRS_INDEX = "CMD_GPRS_INDEX";
    /**
     * 服务器地址类型	0为IP地址    1为域名
     */
    public static final String CMD_GPRS_FQDN = "CMD_GPRS_FQDN";
    /**
     * 服务器地址
     */
    public static final String CMD_GPRS_ADDRESS = "CMD_GPRS_ADDRESS";
    /**
     * TCP/UDP端口
     */
    public static final String CMD_GPRS_PORT = "CMD_GPRS_PORT";
    /**
     * 域名解析服务器
     */
    public static final String CMD_GPRS_DNS = "CMD_GPRS_DNS";
    /**
     * APN名称
     */
    public static final String CMD_GPRS_APN = "CMD_GPRS_APN";
    /**
     * 用户名
     */
    public static final String CMD_GPRS_USERNAME = "CMD_GPRS_USERNAME";
    /**
     * 密码
     */
    public static final String CMD_GPRS_PASSWORD = "CMD_GPRS_PASSWORD";


    /**
     * 设置车辆类型
     */
    public static final String CMD_CART_TYPE = "CMD_CART_TYPE";
    /**
     * 车型车系ID号 16进制的ASCII， 1E01
     */
    public static final String CMD_CART_TYPE_VEH_ID = "CMD_CART_TYPE_VEH_ID";
    /**
     * 排量 1.0排量为10; 2.5排量为25; 3.2排量为32
     */
    public static final String CMD_CART_TYPE_CONSUM = "CMD_CART_TYPE_CONSUM";

    /**
     * 设置拍照参数
     */
    public static final String CMD_PHOTOSHOT = "CMD_PHOTOSHOT";
    public static final String CMD_PHOTOSHOT_CANID = "CMD_PHOTOSHOT_CANID";
    public static final String CMD_PHOTOSHOT_NUMBER = "CMD_PHOTOSHOT_NUMBER";
    public static final String CMD_PHOTOSHOT_INTERVAL = "CMD_PHOTOSHOT_INTERVAL";
    public static final String CMD_PHOTOSHOT_RATIO = "CMD_PHOTOSHOT_RATIO";
    public static final String CMD_PHOTOSHOT_COMPRESS = "CMD_PHOTOSHOT_COMPRESS";
    /**
     * 点火
     */
    public static final String DEV_CMD_IGNITE = "IGNITE";
    /**
     * 开门
     */
    public static final String DEV_CMD_DOOR = "DOOR";
    /**
     * 开锁
     */
    public static final String DEV_CMD_LOCK = "LOCK";
    /**
     * 远光灯
     */
    public static final String DEV_CMD_HBEAM = "HBEAM";
    /**
     * 近光灯
     */
    public static final String DEV_CMD_LBEAM = "LBEAM";
    /**
     * 天窗
     */
    public static final String DEV_CMD_SKYLIGHT = "SKYLIGHT";
    /**
     * 尾箱
     */
    public static final String DEV_CMD_TRUNK = "TRUNK";
    /**
     * 鸣笛
     */
    public static final String DEV_CMD_WHISTLE = "WHISTLE";
    /**
     * 闪灯
     */
    public static final String DEV_CMD_FLASH_LIGHT = "FLASH_LIGHT";
    /**
     * 闪灯
     */
    public static final String DEV_CMD_BMS = "BMS";
    /**
     * 湖州矿车电子围栏告警 围栏ID
     */
    public static final String HuZhouKuangCheFenceAlarm_FenceId = "FenceId";
    /**
     * 湖州矿车电子围栏告警  事件类型
     */
    public static final String HuZhouKuangCheFenceAlarm_EventType = "EventType";


    /**
     * 维德电源MCU操作
     **/
    public static final String WEIDE_CMD_QUERY_MCU = "WEIDE_CMD_QUERY_MCU";

    /**
     * 维德电源BMS操作
     **/
    public static final String WEIDE_CMD_QUERY_BMS = "WEIDE_CMD_QUERY_BMS";

    /**
     * 维德电源VCU操作
     **/
    public static final String WEIDE_CMD_VCU = "WEIDE_CMD_VCU";
    /**
     * 维德电源VCU操作
     **/
    public static final String WEIDE_CMD_VCU_VERSION = "WEIDE_CMD_VCU_VERSION";
}
