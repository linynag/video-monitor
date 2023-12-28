package org.yzh.server;

import com.yiwei.common.component.data.DataObj;
import com.yiwei.common.component.queue.SequenceQueue;
import com.yiwei.common.component.timer.TimeScheduler;
import com.yiwei.common.component.utils.SpringContextUtils;
import com.yiwei.common.rabbitmq.service.PeriodSeparatedIdRabbitmqService;
import com.yiwei.common.rabbitmq.service.RabbitmqService;
import lombok.extern.slf4j.Slf4j;
import org.yzh.protocol.basics.JTMessage;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * JT车机数据解析队列
 */
@Slf4j
public class DataHandleQueue extends SequenceQueue<JTMessage> {
    private volatile static DataHandleQueue instance_ = null;
    // private SCProps scProperties = SpringContextUtils.getBean(SCProps.class);
    private RabbitmqService dispatchService = SpringContextUtils.getBean(PeriodSeparatedIdRabbitmqService.class);
    // private DeviceAuthenticationFeignClient deviceAuthenticationFeignClient = SpringContextUtils.getBean(DeviceAuthenticationFeignClient.class);

    private DataHandleQueue() {
    }

    public static DataHandleQueue getInstance() {
        if (instance_ == null) {
            synchronized (DataHandleQueue.class) {
                if (instance_ == null) {
                    instance_ = new DataHandleQueue();
                    instance_.commitScheduleTask();
                }
            }
        }
        return instance_;
    }

    @Override
    public void infoQueue() {
        if (msgQArray_ == null) {
            log.info("发现队列为null");
            return;
        }

        for (int i = 0; i < msgQArray_.length; i++) {
            BlockingQueue<JTMessage> queue = msgQArray_[i];

            if (queue == null) {
                continue;
            }

            log.info("队列索引[{}]的已使用容量为 [{}]，队列的剩余容量为[{}]", i, queue.size(), queue.remainingCapacity());
        }
    }

    private void commitScheduleTask() {
        TimeScheduler.instance().registerScheduledTask(() -> this.infoQueue(), 10, 5, TimeUnit.SECONDS);
    }

    /**
     * 线程执行的方法体
     */
    @Override
    public void svc() {
        while (true) {
            try {
                JTMessage pkg = this.getq();

                // // 解析基础信息
                // DevAdaptor adaptor = pkg.getAdaptor();
                // adaptor.parseBase(pkg);

                // ParseConfig cfg = adaptor.getParseConfig(pkg);

//                 if (cfg == null) {
//                     log.debug("NO CFG FOR [{}]", pkg.getName());
//                     // despatchRawData(pkg);
//                 } else {
// //
//
//                     //转发原始数据
//                     despatchRawData(pkg);
//
//                     //解析原始数据
//                     List<DataObj> dataList = parseData(pkg, adaptor, cfg);
//
//                     //给车机回包
//                     replyDevice(pkg, adaptor, cfg, dataList);
//
//                     //转发解析后的数据
//                     despatchRtInfo(dataList);
//                 }

            } catch (Exception e) {
                log.error("HANDLER ERROR {} ", e);
            }
        }
    }

    private void despatchRtInfo(List<DataObj> dataList) {
        for (DataObj data : dataList) {
            // 转发数据给event服务,改为由校验服务把所有数据包梳理后再转发
//			despatchService.send(RabbitmqConts.MQ_EXCHANGE_RTINFO, data);

            // 转发数据给vlr服务
            // despatchService.send(RabbitmqConts.MQ_EXCHANGE_SCDATA, data);
            // despatchService.send(RabbitmqConts.MQ_EXCHANGE_BAIDU, data);

            // //把数据发去event
            // if (data.getReportDate() != null) {
            //     Long reportMill = data.getReportTime();
            //     if ((reportMill - System.currentTimeMillis()) / 1000 / 60 < scProperties.getRawDataCheckTimeDiff()) {
            //         despatchService.send(RabbitmqConts.MQ_EXCHANGE_RTINFO, data);
            //     }
            // }
        }
    }

//     private void replyDevice(RawPkg pkg, DevAdaptor adaptor, ParseConfig cfg, List<DataObj> dataList) {
//         try {
// //            if (cfg.getDataTag().equals("RTINFO")) {
// //                Thread.sleep(30000);
// //            }
//             Integer flag = 0x01;
//             if ("YIWEIRESPONSE".equals(cfg.getReply())) {
//                 ReturnValue returnValue = deviceAuthenticationFeignClient.modifyVin(dataList.get(0).getString("deviceCode"), dataList.get(0).getString("vin"));
//                 if (ReturnValue.CODE_SUCCESS.equals(returnValue.getCode())) {
//                     String msg = returnValue.getMsg();
//                     String[] res = msg.split(";");
//                     flag = Integer.valueOf(res[0]);
//                     pkg.setOldDevcode(res[1]);
//                 }
//             }
//             if (cfg.getReply() != null) {
//                 log.debug("RESPONSE TYPE IS [{}]", cfg.getReply());
//                 adaptor.makeResponse(pkg, cfg.getReply(), flag);
//             }
//             if ("YIWEIRESPONSE".equals(cfg.getReply())) {
//                 adaptor.disconnect();
//                 log.info("关闭车机连接/{}/!=YIWEIRESPONSE DEVID{}", pkg.getAdaptor().getIp(), pkg.getDevcode());
//                 adaptor.close();
//             }
//         } catch (Exception e) {
//             log.error("给设备回包时发生异常！", e);
//         }
//     }


    // private List<DataObj> parseData(RawPkg pkg, DevAdaptor adaptor, ParseConfig cfg) {
    //     List<DataObj> datalist = new ArrayList<>();
    //     String parserName = cfg.getParser();
    //
    //     if (parserName == null) {
    //         log.debug("PARSER IS NULL");
    //     } else {
    //         log.debug("PARSER WHIT PARSER [{}]", parserName);
    //         IParser parser = (IParser) SpringContextUtils.getBean(parserName);
    //         List<DataObj> parseDatalist = parser.parse(pkg, cfg);
    //
    //         if (parseDatalist != null) {
    //             for (DataObj obj : parseDatalist) {
    //                 log.debug("=======车机【" + pkg.getDevcode() + "】,数据上报时间：【" + obj.getReportTime() + "】,服务器接收时间：【" + obj.getRecvTime().getTime() + "】");
    //                 log.info("HANDLE DATA:{}", obj);
    //                 obj.setConnectSN(adaptor.getSnInt());
    //                 obj.put("CONNECTOR", SpringContextUtils.getBean(SCProps.class).getServerId());
    //
    //                 if (cfg.isResponse()) {// 如果是响应包，则找到对应的下发锁，解锁。不然会抛“60s超时的异常”
    //                     // 3 获取指令同步锁
    //                     int sn = obj.getData().getIntValue("SN");
    //                     SyncLock lock = CmdLockMgr.getInstance().removeLock(obj.getDevid(), sn);
    //                     if (lock != null) {
    //                         log.debug("CMD LOCK UNLONK:DEV[{}] CMD_SN[{}]", obj.getDevid(), sn);
    //                         obj.setResponseType(pkg.getReserve1());
    //                         lock.setResult(obj);
    //                         lock.end();
    //                     }
    //                 } else {
    //                     datalist.add(obj);
    //                 }
    //             }
    //
    //         }
    //     }
    //     return datalist;
    // }

    // private void despatchRawData(RawPkg pkg) {
    //     String devcode = pkg.getDevcode();
    //
    //     // 把原始数据转发到校验服务处理
    //     RawMQPgk mqPgk = new RawMQPgk();
    //     mqPgk.setData(pkg.getData());
    //     mqPgk.setResponse(pkg.getResponse());
    //     mqPgk.setRecvTime(pkg.getRecvTime());
    //     mqPgk.setRespTime(pkg.getRespTime());
    //     despatchService.send(RabbitmqConts.MQ_EXCHANGE_RAW_DATA_VALIDATE, mqPgk.getPackData());
    //
    //     // 把原始数据发送到平台之间透传队列的路由
    //     if (scProperties.isRawDataMQTransfer()) {
    //         despatchService.send(RabbitmqConts.MQ_EXCHANGE_DEVICE_DUPLICATE, pkg.getData());
    //     }
    //
    //     // 把原始数据发生到转去国家平台的路由
    //     boolean allow = VINListConfigLoader.getInstance().isTranferVINForGuoJia(devcode);
    //     log.debug("despatchRawToMQ(pkg),ALLOW[{}]", allow);
    //     if (allow && StringUtils.isNotEmpty(pkg.getRoutingCode()) && StringUtils.isNotBlank(pkg.getRoutingCode())) {
    //         log.info("需要发送的devid:{},orgPath为:{}", pkg.getDevcode(), pkg.getRoutingCode());
    //         despatchService.send(RabbitmqConts.MQ_EXCHANGE_TRANSFER, pkg.getRoutingCode(), pkg.getData());
    //         log.debug("=======车机【" + pkg.getDevcode() + "】,数据接收时间：【" + pkg.getRecvTime().getTime() + "】,数据分发到转发国家平台队列耗时：【" + (System.currentTimeMillis() - pkg.getRecvTime().getTime()) + "】===");
    //     }
    // }

}
