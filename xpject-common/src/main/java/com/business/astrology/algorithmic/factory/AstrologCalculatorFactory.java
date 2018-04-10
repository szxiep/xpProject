package com.business.astrology.algorithmic.factory;

import com.business.astrology.algorithmic.api.IACGCalculator;
import com.business.astrology.algorithmic.api.IAstrologCalculator;
import com.business.astrology.algorithmic.api.IAstrologCalculatorFactory;
import com.business.astrology.algorithmic.bean.CI;
import com.business.astrology.algorithmic.bean.Profile;
import com.business.astrology.algorithmic.impl.ACGCalculator;
import com.business.astrology.algorithmic.impl.AstrologCalculator;

public class AstrologCalculatorFactory implements IAstrologCalculatorFactory {

	@Override
	public IAstrologCalculator createCalculator(Profile profile, CI ciCore) {
		return new AstrologCalculator(profile, ciCore);
		//return new AstrologTestCaseProvider();
	}

	@Override
	public IACGCalculator createACGCalculator(Profile profile, CI ciCore) {
		return new ACGCalculator(profile, ciCore);
	}

}
