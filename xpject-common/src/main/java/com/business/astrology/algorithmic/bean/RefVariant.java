package com.business.astrology.algorithmic.bean;

import com.business.astrology.algorithmic.api.IVariant;

public class RefVariant implements IVariant {

	private IVariant value = null;

	public RefVariant() {
	}

	public RefVariant(double value) {
		this.from(value);
	}
	
	public RefVariant(int value) {
		this.from(value);
	}

	public void from(int value) {
		this.value = new IntegerVariant(value);
	}

	public void from(double value) {
		this.value = new DoubleVariant(value);
	}

	@Override
	public double toDouble() {
		if (null != this.value) {
			return this.value.toDouble();
		}
		return 0.0;
	}

	@Override
	public int toInteger() {
		if (null != this.value) {
			return this.value.toInteger();
		}
		return 0;
	}
}
