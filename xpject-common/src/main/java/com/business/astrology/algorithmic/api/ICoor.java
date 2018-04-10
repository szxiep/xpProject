package com.business.astrology.algorithmic.api;

import com.business.astrology.algorithmic.bean.PolarCoorF;
import com.business.astrology.algorithmic.bean.RectCoorF;

public interface ICoor {

	PolarCoorF toPolarCoorF();

	RectCoorF toRectCoorF();
}
