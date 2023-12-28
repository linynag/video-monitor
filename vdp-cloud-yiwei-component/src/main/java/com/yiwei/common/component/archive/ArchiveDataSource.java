/**
 * @Title CSTDataBuff.java
 * @Package com.gdcp.archiver.buffmgr
 * @Description
 * @author 张世江 [zhangsj@cstonline.cn]
 * @date 2014-6-15 下午5:19:18
 * @version V1.0
 */
package com.yiwei.common.component.archive;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ArchiveDataSource<T> {

	/**
	 * 数据存放的标识（如mysql的table name、MongoDB的collection name等）
	 *
	 */
	private String storageId;
	/**
	 * 最后一次获取数据时间
	 *
	 */
	private long lastGetDataTime;
	/**
	 * 写入阈值
	 */
	private int writeThreshold;

	private BlockingQueue<T> dbObjQueue = new ArrayBlockingQueue<>(20000);


	public ArchiveDataSource(String storageId, int writeThreshold) {
		this.storageId = storageId;
		this.lastGetDataTime = System.currentTimeMillis();
		this.writeThreshold = writeThreshold;
	}

	public String getStorageId() {
		return storageId;
	}

	public long getLastGetDataTime() {
		return lastGetDataTime;
	}

	public int getWriteThreshold() {
		return writeThreshold;
	}

	/**
	 * 添加数据
	 * @param data
	 * @throws Exception
	 */
	public void pushData(ArchiveData<T> data) throws InterruptedException {
		dbObjQueue.put(data.getData());
	}

	/**
	 * 返回与写入阀值长度相等的数据集合
	 * @return
	 */
	public List<T> getDataList(){
		List<T> dataList = new ArrayList<>();
		if(!isEmpty()){
			dbObjQueue.drainTo(dataList, writeThreshold);
			lastGetDataTime = System.currentTimeMillis();
		}
		return dataList;
	}

	/**
	 * 获取当前数据仓库的长度
	 *
	 * @Title size
	 * @Description (这里用一句话描述这个方法的作用)
	 * @return
	 */
	public int size(){
		return dbObjQueue.size();
	}

	/**
	 * 判断是否超时, true 超时 | flase 没有超时
	 *
	 * @param outTime
	 *            单位秒
	 * @return
	 */
	public boolean isTimeOut(long outTime) {
		long l = (System.currentTimeMillis() - lastGetDataTime) / 1000;
		// 判断是否超时,单位毫秒
        return l >= outTime;
    }

	/**
	 * 是否已经到达写入阈值
	 *
	 * @Title isFull
	 * @Description (这里用一句话描述这个方法的作用)
	 * @return boolean
	 * @return
	 */
	public boolean isFull() {
        return this.size() >= writeThreshold;

    }

	/**
	 * 判断可读内容是否为空
	 *
	 * @return true 为空 | false 有内容
	 */
	public boolean isEmpty() {
		if (this.size() == 0) {
			return true;
		}
		return false;
	}

}
