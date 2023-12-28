package org.yzh.conts;

/**
 * @program: vdp-cloud
 * @description:
 * @author: xiazj
 * @create: 2019-06-04 16:15
 **/
public class RabbitmqCons {

    /**
     * 转发到VLR的解析后的数据，因为属于系统核心数据通
     * 道所有创建exchange时也会同时创建对应的队列，防止
     * 消费端还没启动初始化队列时会造成数据丢失
     */
    public static final String MQ_EXCHANGE_SCDATA = "scdata_yiwei.fanout.updateRealTimeData";
    public static final String MQ_EXCHANGE_BAIDU = "baidu_cloud_push_yiwei.fanout.pushToBaiduCloud";
    /**
     * 转发到数据校验服务的原始数据，因为属于系统核心数据通
     * 道所有创建exchange时也会同时创建对应的队列，防止
     * 消费端还没启动初始化队列时会造成数据丢失
     */
    public static final String MQ_EXCHANGE_RAW_DATA_VALIDATE = "raw_validate_yiwei.fanout.rawDataValidate";
    /**
     * 转发到EVENT的解析后的数据，因为属于系统核心数据通
     * 道所有创建exchange时也会同时创建对应的队列，防止
     * 消费端还没启动初始化队列时会造成数据丢失
     */
    public static final String MQ_EXCHANGE_RTINFO = "rtinfo_yiwei.fanout.makeEventData";
    /**
     * 不同平台之间进行数据透传的路由，创建exchange时不会初始化队列
     */
    public static final String MQ_EXCHANGE_DEVICE_DUPLICATE = "raw_deviceDuplicate_yiwei.fanout";
    /**
     * 转发原始数据到国家平台的路由，创建exchange时不会初始化队列
     */
    public static final String MQ_EXCHANGE_TRANSFER = "raw_transfer_yiwei.topic";


}
