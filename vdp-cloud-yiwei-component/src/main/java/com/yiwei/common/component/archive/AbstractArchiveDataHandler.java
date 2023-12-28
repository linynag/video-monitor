package com.yiwei.common.component.archive;

import com.yiwei.common.component.exitHandle.AppExitListener;
import com.yiwei.common.component.timer.TimeScheduler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @program: vdp-cloud
 * @description:
 * @author: xiazj
 * @create: 2019-05-30 10:56
 **/
public abstract class AbstractArchiveDataHandler<T> implements AppExitListener{

    private Map<String, ArchiveDataSource> sourceMap = new HashMap<>();

    private int timeOutSecond = 5;
    private int writeThreshold = 500;

    protected AbstractArchiveDataHandler(Integer timeOutSecond, Integer writeThreshold) {
        if(timeOutSecond != null && timeOutSecond > 0)this.timeOutSecond = timeOutSecond;
        if(writeThreshold != null && writeThreshold > 0)this.writeThreshold = writeThreshold;
        commitScheduleTask();
    }

    public abstract String getStorageType();

    protected abstract void saveData(String collectionName, List<? extends T> dataList);

    public void archiveData(ArchiveData<T> data) throws InterruptedException {
        String storageId = data.getStorageId();
        ArchiveDataSource dataSource = sourceMap.get(storageId);
        if(dataSource == null){
            synchronized (sourceMap){
                dataSource = sourceMap.get(storageId);
                if(dataSource == null){
                    dataSource = new ArchiveDataSource(storageId, writeThreshold);
                    sourceMap.put(storageId, dataSource);
                }
            }
        }
        dataSource.pushData(data);
        if(dataSource.isFull()){
            saveData(dataSource.getStorageId(), dataSource.getDataList());
        }
    }

    private void commitScheduleTask() {
        TimeScheduler.instance().registerScheduledTask(() -> checkArchive(timeOutSecond), timeOutSecond, timeOutSecond, TimeUnit.SECONDS);
    }

    private void checkArchive(int timeOut) {
        sourceMap.forEach((key, dataSource) -> {
            if(dataSource.isTimeOut(timeOut) && !dataSource.isEmpty()){
                saveData(dataSource.getStorageId(), dataSource.getDataList());
            }
        });
    }

    @Override
    public void doExitPreparations() {
        checkArchive(0);
    }

    @Override
    public boolean isFinish() {
        boolean isFinish = true;

        for(String key : sourceMap.keySet()){
            ArchiveDataSource dataSource = sourceMap.get(key);
            if(!dataSource.isEmpty()){
                saveData(dataSource.getStorageId(), dataSource.getDataList());
                isFinish = false;
            }
        }
        return isFinish;
    }
}
