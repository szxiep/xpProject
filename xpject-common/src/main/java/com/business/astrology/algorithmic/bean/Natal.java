package com.business.astrology.algorithmic.bean;

import com.business.astrology.algorithmic.api.INatal;

/**
 * 星座命盘
 * 
 * @author tad
 */
public class Natal extends CP implements INatal {

	public Natal(CP cp) {
		super();
		this.obj = cp.obj;
		this.alt = cp.alt;
		this.dir = cp.dir;
		this.cusp = cp.cusp;
		this.house = cp.house;
	}

	@Override
	public double[] getObj() {
		return obj;
	}

	@Override
	public double[] getAlt() {
		return alt;
	}

	@Override
	public double[] getDir() {
		return dir;
	}

	@Override
	public double[] getCusp() {
		return cusp;
	}

	@Override
	public int[] getHouse() {
		return house;
	}
}
