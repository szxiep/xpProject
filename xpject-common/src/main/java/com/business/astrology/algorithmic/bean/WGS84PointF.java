package com.business.astrology.algorithmic.bean;

public class WGS84PointF {

	private double lon;		//经度
	private double lat;

	public WGS84PointF(double lon, double lat) {
		super();
		this.lon = lon;
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public double getLat() {
		return lat;
	}
}
