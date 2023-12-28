package com.yiwei.common.component.exitHandle;

/**
 * 进程关闭时的监听器接口，用于程序退出时进行一些清理处理
 * 如：
 *  1、断开MQ监听把内存队列的数据消费完
 *  2、对内存缓存的数据保存到redis或文件进行数据快照
 *  3、释放某些系统资源等
 * @program: vdp-cloud-V2.0
 * @description:
 * @author: xiazj
 * @create: 2019-06-20 15:51
 **/
public interface AppExitListener {

    /**
     * 异步执行程序退出前需要处理的工作,调用者会使用线程池创建一条线程来调用
     */
    void doExitPreparations();

    /**
     * 检查需处理的工作是否完成
     */
    boolean isFinish();

}
