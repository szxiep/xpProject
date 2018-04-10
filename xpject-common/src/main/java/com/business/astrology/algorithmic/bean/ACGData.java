package com.business.astrology.algorithmic.bean;

import com.business.astrology.algorithmic.api.IACG;

public class ACGData implements IACG {

	public WGS84PointF[] zeniths;
	public WGS84PointF[] nadirs;
	public WGS84PointF[] ascs;
	public WGS84PointF[] dscs;
	public WGS84PointF[][] asc;
	public WGS84PointF[][] dsc;

	public ACGData(WGS84PointF[] zeniths, WGS84PointF[] nadirs, WGS84PointF[] ascs, WGS84PointF[] dscs,
			WGS84PointF[][] asc, WGS84PointF[][] dsc) {
		super();
		this.zeniths = zeniths;
		this.nadirs = nadirs;
		this.ascs = ascs;
		this.dscs = dscs;
		this.asc = asc;
		this.dsc = dsc;
	}

	@Override
	public WGS84PointF[] getZeniths() {
		return this.zeniths;
	}

	@Override
	public WGS84PointF[] getNadirs() {
		return this.nadirs;
	}

	@Override
	public WGS84PointF[] getAscs() {
		return this.ascs;
	}

	@Override
	public WGS84PointF[] getDscs() {
		return this.dscs;
	}

	@Override
	public WGS84PointF[][] getAscSets() {
		return this.asc;
	}

	@Override
	public WGS84PointF[][] getDscSets() {
		return this.dsc;
	}
}
