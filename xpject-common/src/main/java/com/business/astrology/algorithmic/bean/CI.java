package com.business.astrology.algorithmic.bean;

//出生数据
public class CI {
	public CI() {
	}

	public CI(CI other) {
		super();
		this.day = other.day;
		this.mon = other.mon;
		this.yea = other.yea;
		this.tim = other.tim;
		this.dst = other.dst;
		this.zon = other.zon;
		this.lon = other.lon;
		this.lat = other.lat;
		this.nam = other.nam;
		this.loc = other.loc;
	}
	
	public CI(int day, int mon, int yea, double tim, double dst, double zon, double lon, double lat, String nam,
			String loc) {
		super();
		this.day = day;
		this.mon = mon;
		this.yea = yea;
		this.tim = tim;
		this.dst = dst;
		this.zon = zon;
		this.lon = lon;
		this.lat = lat;
		this.nam = nam;
		this.loc = loc;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMon() {
		return mon;
	}

	public void setMon(int mon) {
		this.mon = mon;
	}

	public int getYea() {
		return yea;
	}

	public void setYea(int yea) {
		this.yea = yea;
	}

	public double getTim() {
		return tim;
	}

	public void setTim(double tim) {
		this.tim = tim;
	}

	public double getDst() {
		return dst;
	}

	public void setDst(double dst) {
		this.dst = dst;
	}

	public double getZon() {
		return zon;
	}

	public void setZon(double zon) {
		this.zon = zon;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public String getNam() {
		return nam;
	}

	public void setNam(String nam) {
		this.nam = nam;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public int day; /* Day */
	public int mon; /* Month */
	public int yea; /* Year */
	public double tim; /* Time in hours */
	public double dst; /* Daylight offset */
	public double zon; /* Time zone */
	public double lon; /* Longitude */
	public double lat; /* Latitude */
	public String nam; /* Name for chart */
	public String loc; /* Name of location */
}
