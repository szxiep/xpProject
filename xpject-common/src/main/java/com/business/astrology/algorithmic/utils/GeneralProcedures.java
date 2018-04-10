package com.business.astrology.algorithmic.utils;

public class GeneralProcedures {

	/*
	 ******************************************************************************
	 ** General Procedures.
	 ******************************************************************************
	 */

	/* Swap two floating point values. */

	public static void SwapR(double[] d, int i, int j) {
		double temp;

		temp = d[i];
		d[i] = d[j];
		d[j] = temp;
	}
	//
	//
	/// * Return the length of a string (not counting the null terminator). */
	//
	// int CchSz(CONST char *sz)
	// {
	// CONST char *pch = sz;
	//
	// while (*pch)
	// pch++;
	// return (int)(pch - sz);
	// }
	//
	//
	/// * Compare two strings. Return 0 if they are equal, a positive value if */
	/// * the first string is greater, and a negative if the second is greater. */
	//
	// int NCompareSz(CONST char *sz1, CONST char *sz2)
	// {
	// while (*sz1 && *sz1 == *sz2)
	// sz1++, sz2++;
	// return (uchar)*sz1 - (uchar)*sz2;
	// }
	//
	//
	/// * Return whether the first string matches the second, case insensitively. */
	/// * The first string may be truncated, but the first three chars must match.
	/// */
	//
	// int FMatchSz(CONST char *sz1, CONST char *sz2)
	// {
	// CONST char *szStart = sz1;
	//
	// while (*sz1 && ChCap(*sz1) == ChCap(*sz2))
	// sz1++, sz2++;
	// return *sz2 == chNull || (*sz1 == chNull && sz1 - szStart >= 3);
	// }
	//
	//
	/// * Set a given number of bytes to zero given a starting pointer. */
	//
	// void ClearB(lpbyte pb, int cb)
	// {
	// while (cb-- > 0)
	// *pb++ = 0;
	// }
	//
	//
	/// * Copy a given number of bytes from one location to another. */
	//
	// void CopyRgb(byte *pbSrc, byte *pbDst, int cb)
	// {
	// while (cb-- > 0)
	// *pbDst++ = *pbSrc++;
	// }
	//
	//
	/// * Determine the sign of a number: -1 if value negative, +1 if value */
	/// * positive, and 0 if it's zero. */
	//
	public static double RSgn(double r) {
		return Math.abs(r) < Constants.rSmall ? 0.0 : Macro.RSgn2(r);
	}

	/* Given an x and y coordinate, return the angle formed by a line from the */
	/* origin to this coordinate. This is just converting from rectangular to */
	/* polar coordinates; however, we don't determine the radius here. */

	public static double Angle(double x, double y) {
		double a;

		if (Math.abs(x) > Constants.rSmall) {
			if (Math.abs(y) > Constants.rSmall)
				a = Math.atan(y / x);
			else
				a = x < 0.0 ? Constants.rPi : 0.0;
		} else
			a = y < 0.0 ? -Constants.rPiHalf : Constants.rPiHalf;
		if (a < 0.0)
			a += Constants.rPi;
		if (y < 0.0)
			a += Constants.rPi;
		return a;
	}

	/* Modulus function for floating point values, where we bring the given */
	/* parameter to within the range of 0 to 360. */

	public static double Mod(double d) {
		if (d >= Constants.rDegMax) /* In most cases, our value is only slightly */
			d -= Constants.rDegMax; /* out of range, so we can test for it and */
		else if (d < 0.0) /* avoid the more complicated arithmetic. */
			d += Constants.rDegMax;
		if (d >= 0 && d < Constants.rDegMax)
			return d;
		return (d - Macro.RFloor(d / Constants.rDegMax) * Constants.rDegMax);
	}

	/* A similar modulus function: convert an integer to value from 1..12. */
	public static int Mod12(int i) {
		while (i > Constants.cSign)
			i -= Constants.cSign;
		while (i < 1)
			i += Constants.cSign;
		return i;
	}

	/* Another modulus function, this time for the range of 0 to 2 Pi. */
	public static double ModRad(double r) {
		while (r >= Constants.rPi2) /* We assume our value is only slightly out of */
			r -= Constants.rPi2; /* range, so test and never do any complicated math. */
		while (r < 0.0)
			r += Constants.rPi2;
		return r;
	}

	//
	/// * Integer division - like the "/" operator but always rounds result down. */
	//
	// long Dvd(long x, long y)
	// {
	// long z;
	//
	// if (y == 0)
	// return x;
	// z = x / y;
	// if (((x >= 0) == (y >= 0)) || x-z*y == 0)
	// return z;
	// return z - 1;
	// }
	//
	//
	/// * Lookup a string within a table (case insensitively) returning the index */
	/// * that goes with the matched string, or -1 if the string is not found. */
	//
	// int SzLookup(CONST StrLook *rgStrLook, CONST char *sz)
	// {
	// CONST char *pch1, *pch2;
	// int irg;
	//
	// for (irg = 0; rgStrLook[irg].isz >= 0; irg++) {
	// for (pch1 = sz, pch2 = rgStrLook[irg].sz;
	// *pch1 && ChCap(*pch1) == ChCap(*pch2); pch1++, pch2++)
	// ;
	// if (*pch1 == chNull && pch1 - sz >= 3)
	// return rgStrLook[irg].isz;
	// }
	// return -1;
	// }
}
