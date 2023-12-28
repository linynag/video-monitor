package org.yzh.init;

import com.yiwei.common.rabbitmq.service.RabbitmqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.yzh.conts.RabbitmqCons;
import org.yzh.server.DataHandleQueue;

@Component("initApplicationListener") // 用注解就不需要在配置文件中添加注入
@Slf4j
public class SCInitApplicationListener implements ApplicationListener<ApplicationReadyEvent> {

    private final SCProps scProps;
    private final RabbitmqService rabbitmqService;

    @Autowired
    public SCInitApplicationListener(SCProps scProps, RabbitmqService rabbitmqService) {
        this.scProps = scProps;
        this.rabbitmqService = rabbitmqService;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent contextRefreshedEvent) {
        initDevService();
        initService();
        rabbitmqService.initExchange(RabbitmqCons.MQ_EXCHANGE_RAW_DATA_VALIDATE);
        rabbitmqService.initExchange(RabbitmqCons.MQ_EXCHANGE_SCDATA);
        rabbitmqService.initExchange(RabbitmqCons.MQ_EXCHANGE_RTINFO);
    }

    /**
     * 显示的初始化了SC的服务
     */
    private void initService() {

        try {
            // 启动车机原始数据队列
            DataHandleQueue.getInstance().start("DataHandleQueue", scProps.getDataHandle().getThreadNum(),
                    scProps.getDataHandle().getQueueDepth());


            //
            // log.info("################从REDIS中更新报警对照################");
            // // alarmTypeMapping.updateLocalAlarmMapping();
            //
            // log.info("################初始化ShuChiCanFrameTypeHolder################");
            // ShuChiCanFrameTypeHolder.init(); // 预先初始化RedisClient及CAN数据类型存放类,防止解析器匆忙时拿不到链接
            //
            // log.info("################初始化【车机数据处理队列】DataHandleQueue################");
            //
            //
            // log.info("################初始化车机认证组件DeviceVerifyQueue################");
            // DeviceVerifyQueue.getInstance();
            //
            // log.info("################初始化【车机适配器目录】AdaptorImplCatalog################");
            // // ## 初始化车机适配器目录,例如初始化国标的适配器和车葫芦的适配器
            // AdaptorImplCatalog.getInstance();
            //
            // // ## 初始化命令锁 管理工具类
            // log.info("################初始化【命令锁管理类】CmdLockMgr################");
            // CmdLockMgr.getInstance();

        } catch (Exception e) {
            log.error("执行initService()方法发生异常", e);
        }
    }

    /**
     * @Description 初始化车机基础服务, 包括车机连接服务端, 车机命令下发等
     * @Author longxiaonan@163.com
     * @Date 15:41 2018/7/27
     **/
    private void initDevService() {

        try {
            // log.info("################初始化车机适配器管理AdaptorMgr################");
            // // ## 初始化车机适配器管理类
            // AdaptorMgr.getInstance().commitScheduleTask();
            //
            // log.info("################启动车机连接服务CarAgentServer################");
            // // ## 初始化车机代理服务
            // CarAgentServer caragentserver = new CarAgentServer();
            // // TODO 通过配置文件获取
            // // String agentUrl = "mina#127.0.0.1:8702:-1";
            // String agentUrl = scProps.getDevConnect().getAgentUrl();
            // caragentserver.start(agentUrl);

        } catch (Exception e) {
            log.error("执行initDevService()方法发生异常", e);
        }
    }
}