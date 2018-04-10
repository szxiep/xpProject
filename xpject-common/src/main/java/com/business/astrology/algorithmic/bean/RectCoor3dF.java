package com.business.astrology.algorithmic.bean;

import com.business.astrology.algorithmic.api.ICoor3d;

public class RectCoor3dF implements ICoor3d {

	private double x;
	private double y;
	private double z;

	public RectCoor3dF(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	@Override
	public PolarCoor3dF toPolarCoor3dF() {
		return null;
	}

	@Override
	public RectCoor3dF toRectCoor3dF() {
		return this;
	}

}
