package com.business.astrology.algorithmic.api;

//获取排盘数据接口
public interface INatal {

	//各星体坐标，角度值，相对于地平线
	double[] getObj();

	double[] getAlt();

	//星体运行方向
	double[] getDir();

	//宫首位置
	double[] getCusp();

	//各星体所在宫
	int[] getHouse();

}
