package com.business.astrology.algorithmic.bean;

import com.business.astrology.algorithmic.api.ICoor;
import com.business.astrology.algorithmic.utils.GeneralProcedures;

public class RectCoorF implements ICoor {

	private double x;
	private double y;

	public RectCoorF(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public PolarCoorF toPolarCoorF() {
		return new PolarCoorF(Math.sqrt(x * x + y * y), GeneralProcedures.Angle(x, y));
	}

	@Override
	public RectCoorF toRectCoorF() {
		return this;
	}
}
