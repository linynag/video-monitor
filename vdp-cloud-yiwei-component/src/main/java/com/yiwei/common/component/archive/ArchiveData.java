package com.yiwei.common.component.archive;

/**   
 * @ClassName:  ArchiveData   
 * @Description:归档数据模型   
 */
public class ArchiveData<T> {
	/**
	 * 需要存储到数据的地方标识（如：mysql、MongoDB等）
	 */
	private String storageType;
	/**
	 * 数据存放的标识（如mysql的表名、MongoDB的collection等）
	 */
	private String storageId;
	/**
	 * 需要保存的数据
	 */
	private T data;

	public ArchiveData(String storageId, T data) {
		this(null, storageId, data);
	}

	public ArchiveData(String storageType, String storageId, T data) {
		this.storageType = storageType;
		this.storageId = storageId;
		this.data = data;
	}

	public String getStorageType() {
		return storageType;
	}

	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}

	public String getStorageId() {
		return storageId;
	}

	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
