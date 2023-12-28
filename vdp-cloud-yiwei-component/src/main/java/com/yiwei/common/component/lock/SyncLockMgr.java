package com.yiwei.common.component.lock;

import com.yiwei.common.component.utils.SnMaker;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SyncLockMgr {

	private Map<Long, SyncLock> queryLockMap = new ConcurrentHashMap<>();

	private volatile static SyncLockMgr instance_ = null;

	private SyncLockMgr() {
	}

	public static SyncLockMgr getInstance() {
		if (instance_ == null) {
			synchronized (SyncLockMgr.class) {
				if (instance_ == null) {
					instance_ = new SyncLockMgr();
				}
			}
		}
		return instance_;
	}

	public SyncLock createLock(int timeout) {
		long sn = SnMaker.getSN();
		SyncLock lock = new SyncLock(sn, timeout);
		queryLockMap.put(sn, lock);
		return lock;
	}

	public SyncLock getLock(long sn) {
		return queryLockMap.get(sn);
	}

	public boolean contains(long sn) {
		return queryLockMap.containsKey(sn);
	}

	public SyncLock removeLock(long sn) {
		if (queryLockMap.containsKey(sn))
			return queryLockMap.remove(sn);
		return null;
	}
}
