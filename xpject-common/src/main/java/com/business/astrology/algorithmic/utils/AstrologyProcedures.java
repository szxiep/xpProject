package com.business.astrology.algorithmic.utils;

public class AstrologyProcedures {
	/*
	 ******************************************************************************
	 ** General Astrology Procedures.
	 ******************************************************************************
	 */

	/* A similar modulus function: convert an integer to value from 1..12. */

	public static int Mod12(int i) {
		while (i > Constants.cSign)
			i -= Constants.cSign;
		while (i < 1)
			i += Constants.cSign;
		return i;
	}

	/// * Convert an inputed fractional degrees/minutes value to a true decimal */
	/// * degree quantity. For example, the user enters the decimal value "10.30" */
	/// * to mean 10 degrees and 30 minutes; this will return 10.5, i.e. 10 */
	/// * degrees and 30 minutes expressed as a floating point degree value. */
	//
	// real DecToDeg(real d)
	// {
	// return RSgn(d)*(RFloor(RAbs(d))+RFract(RAbs(d))*100.0/60.0);
	// }
	//
	//
	/// * This is the inverse of the above function. Given a true decimal value */
	/// * for a zodiac degree, adjust it so the degrees are in the integer part */
	/// * and the minute expressed as hundredths, e.g. 10.5 degrees -> 10.30 */
	//
	// real DegToDec(real d)
	// {
	// return RSgn(d)*(RFloor(RAbs(d))+RFract(RAbs(d))*60.0/100.0);
	// }

	/* Return the shortest distance between two degrees in the zodiac. This is */
	/* normally their difference, but we have to check if near the Aries point. */
	public static double MinDistance(double deg1, double deg2) {
		double i;

		i = Math.abs(deg1 - deg2);
		return i < Constants.rDegHalf ? i : Constants.rDegMax - i;
	}

	/* This is just like the above routine, except the min distance value */
	/* returned will either be positive or negative based on whether the */
	/* second value is ahead or behind the first one in a circular zodiac. */

	public static double MinDifference(double deg1, double deg2) {
		double i;

		i = deg2 - deg1;
		if (Math.abs(i) < Constants.rDegHalf)
			return i;
		return GeneralProcedures.RSgn(i) * (Math.abs(i) - Constants.rDegMax);
	}

	/* Return the degree of the midpoint between two zodiac positions, making */
	/* sure we return the true midpoint closest to the positions in question. */
	public static double Midpoint(double deg1, double deg2) {
		double mid;

		mid = (deg1 + deg2) / 2.0;
		return MinDistance(deg1, mid) < Constants.rDegQuad ? mid : GeneralProcedures.Mod(mid + Constants.rDegHalf);
	}

	/// * Given a planet and sign, determine whether: The planet rules the sign or
	/// */
	/// * is in detriment in the sign, the planet exalts in sign or is in fall / */
	/// * debilitated in sign, the planet esoterically and hierarchically and ray */
	/// * rules or is in detriment in the sign, and return an appropriate string. */
	//
	// char *Dignify(int obj, int sign)
	// {
	// static char szDignify[7];
	// int sign2 = Mod12(sign+6), ray, ich;
	//
	// sprintf(szDignify, "-_____");
	// if (obj > oNorm)
	// goto LExit;
	//
	// /* Check standard rulerships. */
	// if (!ignore7[0]) {
	// if (ruler1[obj] == sign || ruler2[obj] == sign)
	// szDignify[1] = 'R';
	// else if (ruler1[obj] == sign2 || ruler2[obj] == sign2)
	// szDignify[1] = 'd';
	// }
	// if (!ignore7[3]) {
	// if (exalt[obj] == sign)
	// szDignify[4] = 'X';
	// else if (exalt[obj] == sign2)
	// szDignify[4] = 'f';
	// }
	//
	// /* Check esoteric rulerships. */
	// if (!ignore7[1]) {
	// if (rgObjEso1[obj] == sign || rgObjEso2[obj] == sign)
	// szDignify[2] = 'S';
	// else if (rgObjEso1[obj] == sign2 || rgObjEso2[obj] == sign2)
	// szDignify[2] = 's';
	// }
	// if (!ignore7[2]) {
	// if (rgObjHie1[obj] == sign || rgObjHie2[obj] == sign)
	// szDignify[3] = 'H';
	// else if (rgObjHie1[obj] == sign2 || rgObjHie2[obj] == sign2)
	// szDignify[3] = 'h';
	// }
	// if (!ignore7[4]) {
	// ray = rgObjRay[obj];
	// if (ray > 0) {
	// if (rgSignRay2[sign][ray] > 0)
	// szDignify[5] = 'Y';
	// else if (rgSignRay2[sign2][ray] > 0)
	// szDignify[5] = 'z';
	// }
	// }
	//
	// LExit:
	// for (ich = 1; ich <= 5; ich += ich == 1 ? 3 :
	// (ich == 4 ? -2 : (ich == 3 ? 2 : 1))) {
	// if (szDignify[ich] != '_') {
	// szDignify[0] = szDignify[ich];
	// break;
	// }
	// }
	// return szDignify;
	// }
	//
	//
	/// * Process the list of each sign's rays, creating a grid based on it */
	/// * indicating whether each ray applies to a sign, and its proportion. */
	//
	// void EnsureRay()
	// {
	// int i, j, c, n;
	//
	// for (i = 1; i <= cSign; i++) {
	// for (j = 1; j <= cRay; j++)
	// rgSignRay2[i][j] = 0;
	// c = 0;
	// n = rgSignRay[i];
	// while (n) {
	// j = n % 10;
	// n /= 10;
	// if (!FBetween(j, 1, cRay))
	// continue;
	// rgSignRay2[i][j] = 1;
	// c++;
	// }
	// for (j = 1; j <= cRay; j++)
	// rgSignRay2[i][j] *= 420 / c;
	// }
	// }
	//
	//
	/// * Determine the number of days in a particular month. The year is needed, */
	/// * too, because we have to check for leap years in the case of February. */
	//
	// int DayInMonth(int month, int year)
	// {
	// int d;
	//
	// if (month == mSep || month == mApr || month == mJun || month == mNov)
	// d = 30;
	// else if (month != mFeb)
	// d = 31;
	// else {
	// d = 28;
	// if (year % 4 == 0 &&
	// (year % 100 != 0 || year % 400 == 0 || year <= yeaJ2G))
	// d++;
	// }
	// return d;
	// }
	//
	//
	/// * Return the actual number of days in a particular month. Normally, this */
	/// * is the same as the above routine which determines the index of the last */
	/// * day of the month, but the values can differ when changing between */
	/// * calendar systems (Julian to Gregorian) in which one can jump over days. */
	//
	// int DaysInMonth(int month, int year)
	// {
	// int d;
	//
	// d = DayInMonth(month, year);
	// if (year == yeaJ2G && month == monJ2G)
	// d -= (dayJ2G2 - dayJ2G1 - 1);
	// return d;
	// }
	//
	//
	/// * Return the day of the week (Sunday is 0) of the specified given date. */
	//
	// int DayOfWeek(int month, int day, int year)
	// {
	// int d;
	//
	// d = (int)((MdyToJulian(month, day, year) + 1) % 7);
	// return d < 0 ? d+7 : d;
	// }
	//
	//
	/// * Given a day, and the month and year it falls in, add a number of days */
	/// * to it and return the new day index. As month changes are not checked for
	/// */
	/// * here, this is mostly just adding the offset to the day; however we need */
	/// * to check for calendar changes for when days in a month may be skipped. */
	//
	// int AddDay(int month, int day, int year, int delta)
	// {
	// int d;
	//
	// d = day + delta;
	// if (year == yeaJ2G && month == monJ2G) { /* Check for Julian to */
	// if (d > dayJ2G1 && d < dayJ2G2) /* Gregorian crossover. */
	// d += NSgn(delta)*(dayJ2G2-dayJ2G1-1);
	// }
	// return d;
	// }
	//
	//
	/// * Given an aspect and two objects making that aspect with each other, */
	/// * return the maximum orb allowed for such an aspect. Normally this only */
	/// * depends on the aspect itself, but some objects require narrow orbs, */
	/// * and some allow wider orbs, so check for these cases. */
	//
	// real GetOrb(int obj1, int obj2, int asp)
	// {
	// real orb, r;
	//
	// orb = rAspOrb[asp];
	// r = rObjOrb[Min(obj1, oNorm1)];
	// orb = Min(orb, r);
	// r = rObjOrb[Min(obj2, oNorm1)];
	// orb = Min(orb, r);
	// orb += rObjAdd[Min(obj1, oNorm1)];
	// orb += rObjAdd[Min(obj2, oNorm1)];
	// return orb;
	// }
	//
	//
	/// * Return the three letter abbreviation for an aspect. */
	//
	// CONST char *SzAspectAbbrev(int asp)
	// {
	// if (us.fParallel && asp <= aOpp)
	// asp += cAspect;
	// return szAspectAbbrev[asp];
	// }
}
