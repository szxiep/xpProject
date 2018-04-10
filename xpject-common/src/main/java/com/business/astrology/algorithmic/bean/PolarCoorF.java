package com.business.astrology.algorithmic.bean;

import com.business.astrology.algorithmic.api.ICoor;

public class PolarCoorF implements ICoor {

	private double r;
	private double a;

	public PolarCoorF(double r, double a) {
		super();
		this.r = r;
		this.a = a;
	}

	public double getA() {
		return a;
	}

	public double getR() {
		return r;
	}

	@Override
	public PolarCoorF toPolarCoorF() {
		return this;
	}

	@Override
	public final RectCoorF toRectCoorF() {
		return new RectCoorF(r * Math.cos(a), r * Math.sin(a));
	}
}
