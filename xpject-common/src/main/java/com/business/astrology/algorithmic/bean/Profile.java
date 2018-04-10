package com.business.astrology.algorithmic.bean;

//系统设置
public class Profile extends US {
	
	public void setSidereal(boolean bSidereal){
		this.fSidereal = bSidereal? Flag.TRUE : Flag.FALSE;
	}
	
	public void setHouseSys(int iHouseSys) {
		this.nHouseSystem = iHouseSys;
	}
	
}
