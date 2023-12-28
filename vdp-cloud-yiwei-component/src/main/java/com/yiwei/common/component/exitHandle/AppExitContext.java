package com.yiwei.common.component.exitHandle;

import com.yiwei.common.component.utils.SpringContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import sun.misc.Signal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @program: vdp-cloud-V2.0
 * @description:
 * @author: xiazj
 * @create: 2019-06-19 17:39
 **/
@Component
@Slf4j
public class AppExitContext{

    private final static String DEFAULT_SIGNAL_NAME = "TERM";
    private final Executor exitExecutor = Executors.newFixedThreadPool(2);

    public AppExitContext() {
        registerSignal();
    }

    protected void registerSignal() {
        Signal signal = new Signal(DEFAULT_SIGNAL_NAME);
        Signal.handle(signal, (signalObj) -> doExit(signalObj) );
    }

    protected void doExit(Signal signal) {
        try {
            //获取Spring中所有程序监听器
            List<AppExitListener> listeners = getAllAppExitListener();

            //判断目前程序有没有程序退出监听器
            if(!listeners.isEmpty()){
                //通知所有程序退出监听器进行收尾工作,并定时检查退出监听器是否已完成
                notifyAndCheckListener(listeners);
            }

        }catch (Exception e){
            log.error("程序退出前处理收尾工作时发生异常！", e);
        }

        log.info("------------------------------------------");
        log.info("|          system just be exitting!!     |");
        log.info("|          see you next time!!           |");
        log.info("------------------------------------------");
        System.exit(0);
    }

    private void notifyAndCheckListener(List<AppExitListener> listeners) throws InterruptedException {
        //通知所有程序退出监听器进行程序退出前需要处理的工作
        listeners.forEach((listener) -> exitExecutor.execute(() -> listener.doExitPreparations()));

        boolean isFinish = false;
        while (!isFinish){
            Thread.sleep(500);

            for (AppExitListener listener : listeners) {
                isFinish = listener.isFinish();
                if(!isFinish){
                    log.info("程序关闭监听器:[{}]尚未收尾完成,导致程序还无法退出,程序半秒后再次检查！", listener.getClass().getName());
                    break;
                }
            }
        }
    }

    private List<AppExitListener> getAllAppExitListener() {
        List<AppExitListener> listeners = new ArrayList<>();

        ApplicationContext applicationContext = SpringContextUtils.getApplicationContext();
//        String[] names = applicationContext.getBeanNamesForType(AppExitListener.class);
//        for(String name:names){
//            AppExitListener appExitListener = (AppExitListener)applicationContext.getBean(name);
//            listeners.add(appExitListener);
//        }
        Map<String, AppExitListener> listenerMap = applicationContext.getBeansOfType(AppExitListener.class);
        listenerMap.forEach((key, value) -> {
            listeners.add(value);
            log.info("获取到AppExitListener:[{}]", key);
        });

        return listeners;
    }
}
