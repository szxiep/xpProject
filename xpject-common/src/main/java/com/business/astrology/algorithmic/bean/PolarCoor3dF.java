package com.business.astrology.algorithmic.bean;

import com.business.astrology.algorithmic.api.ICoor3d;

public class PolarCoor3dF implements ICoor3d {

	private double r;
	private double azi;
	private double alt;

	public PolarCoor3dF(double r, double azi, double alt) {
		this.r = r;
		this.azi = azi;
		this.alt = alt;
	}

	@Override
	public PolarCoor3dF toPolarCoor3dF() {
		return this;
	}

	@Override
	public RectCoor3dF toRectCoor3dF() {
		double z = r * Math.sin(alt);
		double rT = r * Math.cos(alt);
		double x = rT * Math.cos(azi);
		double y = rT * Math.sin(azi);
		return new RectCoor3dF(x, y, z);
	}
}
