package com.yiwei.common.component.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class SyncLock {
	/**
	 * 正在执行
	 */
	public static final String STATE_RUN = "RUN";
	/**
	 * 执行完毕
	 */
	public static final String STATE_END = "END";
	
	/**执行完毕，但是执行过程，业务方法有异常 add by lijian 2014-07-28*/
	public static final String STATE_END_BUT_ERROR = "END_BUT_ERROR";
	
	/**
	 * 执行异常
	 */
	public static final String STATE_ERROR = "ERROR";
	private long SN;
	private int timeout;
	private Object result;
	private String state;
	private String msg;

	private Lock _lock = new ReentrantLock();
	private Condition condition = _lock.newCondition();

	public SyncLock(int timeout) {
		this.timeout = timeout;
	}

	public SyncLock(long sn, int timeout) {
		this.SN = sn;
		this.timeout = timeout;
	}

	public void lock() throws InterruptedException {
		// log.logDebug("LOCK OBJ {}", this.SN);
		try {
			_lock.lock();
			if (!condition.await(timeout, TimeUnit.SECONDS)) {
				this.setState(STATE_ERROR);
				this.setMsg("请求超时，" + timeout + "秒未响应！");
			}
		} catch (Exception e) {
			this.setState(STATE_ERROR);
			this.setMsg(e.getMessage());
		} finally {
			_lock.unlock();
		}

	}

	public void lock(LockExec exec) throws InterruptedException {
		// log.logDebug("LOCK OBJ {}", this.SN);
		try {
			_lock.lock();
			if (exec != null) {
				// log.logDebug("LOCK EXEC {}", this.SN);

				exec.exec();
			}
			if (!condition.await(timeout, TimeUnit.SECONDS)) {
				this.setState(STATE_ERROR);
				this.setMsg("请求超时，" + timeout + "秒未响应！");
			}
		} catch (Exception e) {
			this.setState(STATE_ERROR);
			this.setMsg(e.getMessage());
			log.error("", e);
		} finally {
			_lock.unlock();
		}

	}

	public void end() {
		// log.logDebug("UNLOCK OBJ {}", this.SN);
		try {
			_lock.lock();
			this.setState(STATE_END);
			this.setMsg("执行完毕");
			condition.signal();
		} finally {
			_lock.unlock();
		}
	}
	
	/**
	 * 执行完毕，但是执行过程，业务方法有异常
	 */
	public void endButError() {
		// log.logDebug("UNLOCK OBJ {}", this.SN);
		try {
			_lock.lock();
			this.setState(STATE_END_BUT_ERROR);
			this.setMsg("执行完毕，但是执行过程，业务方法有异常");
			condition.signal();
		} finally {
			_lock.unlock();
		}
	}
	

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public long getSN() {
		return SN;
	}

	public void setSN(long sN) {
		SN = sN;
	}
}
