package com.business.astrology.algorithmic.api;

import com.business.astrology.algorithmic.bean.CI;
import com.business.astrology.algorithmic.bean.Profile;

public interface IAstrologCalculatorFactory {

	IAstrologCalculator createCalculator(Profile profile, CI ciCore);

	IACGCalculator createACGCalculator(Profile profile, CI ciCore);
}
