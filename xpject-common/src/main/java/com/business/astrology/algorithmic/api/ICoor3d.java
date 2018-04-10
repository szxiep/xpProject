package com.business.astrology.algorithmic.api;

import com.business.astrology.algorithmic.bean.PolarCoor3dF;
import com.business.astrology.algorithmic.bean.RectCoor3dF;

public interface ICoor3d {

	PolarCoor3dF toPolarCoor3dF();

	RectCoor3dF toRectCoor3dF();
}
