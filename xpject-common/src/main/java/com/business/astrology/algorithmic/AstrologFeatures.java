package com.business.astrology.algorithmic;

public class AstrologFeatures {
	public static final boolean ASTROLOG = true;
	public static final boolean MATRIX = true;
	public static final boolean SWISS = false;
	public static final boolean PLACALC = false;
	public static final boolean EPHEM = SWISS || PLACALC;
	public static final boolean EPHEM2 = SWISS && PLACALC;
}
