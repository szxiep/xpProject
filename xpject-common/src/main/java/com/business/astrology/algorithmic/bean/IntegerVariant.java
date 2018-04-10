package com.business.astrology.algorithmic.bean;

import com.business.astrology.algorithmic.api.IVariant;

public class IntegerVariant implements IVariant {

	private int value;

	public IntegerVariant(int value) {
		super();
		this.value = value;
	}

	@Override
	public int toInteger() {
		return this.value;
	}

	@Override
	public double toDouble() {
		return (double) this.value;
	}

}
