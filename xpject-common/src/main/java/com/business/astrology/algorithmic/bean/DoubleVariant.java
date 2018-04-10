package com.business.astrology.algorithmic.bean;

import com.business.astrology.algorithmic.api.IVariant;

public class DoubleVariant implements IVariant {

	private double value;

	public DoubleVariant(double value) {
		super();
		this.value = value;
	}

	@Override
	public int toInteger() {
		return (int) Math.round(this.value);
	}

	@Override
	public double toDouble() {
		return this.value;
	}

}
