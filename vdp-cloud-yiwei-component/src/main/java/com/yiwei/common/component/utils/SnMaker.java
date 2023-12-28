package com.yiwei.common.component.utils;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class SnMaker {
	private static AtomicLong reqSerialNum = new AtomicLong(0);
	private static AtomicInteger cmdSerialNum = new AtomicInteger(0);

	// private volatile static CSTSnMaker instance_ = null;

	// private CSTSnMaker() {
	// }
	//
	// public static CSTSnMaker getInstance() {
	// if (instance_ == null) {
	// synchronized (CSTSnMaker.class) {
	// if (instance_ == null) {
	// instance_ = new CSTSnMaker();
	// }
	// }
	// }
	// return instance_;
	// }

	public static long getSN() {
		return reqSerialNum.addAndGet(1);
	}

	public static int getCmdSN() {
		if (cmdSerialNum.get() >= 0xffff) {
			cmdSerialNum.set(0x00);
		}
		return cmdSerialNum.addAndGet(1);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10000000; i++) {
			System.out.println(getCmdSN());
		}
	}
}
