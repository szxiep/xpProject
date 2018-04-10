package com.business.astrology.algorithmic.bean;

import com.business.astrology.algorithmic.utils.Constants;

public class Flag {
	public static final Flag FALSE = new Flag(Constants.FALSE);
	public static final Flag TRUE = new Flag(Constants.TRUE);

	int flag;

	public Flag(int flag) {
		this.flag = flag;
	}

	public Flag(boolean flag) {
		this.flag = flag ? Constants.TRUE : Constants.FALSE;
	}

	public boolean toBoolean() {
		return Constants.FALSE != flag;
	}

	public double toDouble() {
		return (double) flag;
	}

	public int toInt() {
		return this.flag;
	}

	public Flag non() {
		return Constants.FALSE != this.flag ? FALSE : TRUE;
	}

	public Flag and(int flag) {
		return new Flag(this.flag & flag);
	}

	public Flag or(int flag) {
		return new Flag(this.flag | flag);
	}
}
