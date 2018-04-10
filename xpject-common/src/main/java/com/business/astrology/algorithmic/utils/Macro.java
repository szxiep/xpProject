package com.business.astrology.algorithmic.utils;

import com.business.astrology.algorithmic.bean.RefVariant;

public class Macro {

	// public static double BLo(w) ((byte)(w))
	// public static double BHi(w) ((byte)((word)(w) >> 8 & 0xFF))
	// public static double WLo(l) ((word)(dword)(l))
	// public static double WHi(l) ((word)((dword)(l) >> 16 & 0xFFFF))
	// public static double WFromBB(bLo, bHi) ((word)BLo(bLo) | (word)((byte)(bHi))
	// << 8)
	// public static double LFromWW(wLo, wHi) ((dword)WLo(wLo) |
	// (dword)((word)(wHi)) << 16)
	// public static double LFromBB(b1, b2, b3, b4) LFromWW(WFromBB(b1, b2),
	// WFromBB(b3, b4))
	// public static double RGBR(l) BLo(l)
	// public static double RGBG(l) BHi(l)
	// public static double RGBB(l) ((byte)((dword)(l) >> 16 & 0xFF))
	// public static double ChHex(n) (char)((n) < 10 ? '0' + (n) : 'a' + (n) - 10)
	//
	// public static double Max(v1, v2) ((v1) > (v2) ? (v1) : (v2))
	// public static double Min(v1, v2) ((v1) < (v2) ? (v1) : (v2))
	// public static double NSgn(n) ((n) < 0 ? -1 : (n) > 0)
	
	public static double neg(double r) {
		return (-r);
	}

	public static double fmod(double x, double y) {
		return (x - Math.floor(x / y) * y);
	}

	public static double JulianDayFromTime(double t) {
		return (t * 36525.0 + 2415020.0);
	}

	public static double RSgn2(double r) {
		return (r < 0.0 ? -1.0 : 1.0);
	}

	public static int FOdd(int n) {
		return (n & 1);
	}

	public static boolean FBetween(double v, double v1, double v2) {
		return ((v >= v1) && (v <= v2));
	}

	public static boolean FBetween(int v, int v1, int v2) {
		return ((v >= v1) && (v <= v2));
	}

	public static double RFract(double r) {
		return (r - RFloor(r));
	}

	// public static double ChCap(ch) ((ch) >= 'a' && (ch) <= 'z' ? (ch) - 'a' + 'A'
	// : (ch))
	// public static double ChUncap(ch) (FCapCh(ch) ? (ch) - 'A' + 'a' : (ch))
	// public static double FCapCh(ch) ((ch) >= 'A' && (ch) <= 'Z')
	// public static double FNumCh(ch) ((ch) >= '0' && (ch) <= '9')
	// public static double NMultDiv(n1, n2, n3) ((int)((long)(n1) * (n2) / (n3)))
	// public static double Ratio(v1, v2, v3) ((v1) + ((v2) - (v1)) * (v3))
	public static double ZFromS(int s) {
		return ((double) ((s - 1) * 30));
	}

	public static int SFromZ(double r) {
		return (((int) r) / 30 + 1);
	}

	public static double RFromD(double r) {
		return (r / Constants.rDegRad);
	}

	public static double DFromR(double r) {
		return (r * Constants.rDegRad);
	}

	// public static double GFromO(o) ((rDegMax - (o))/10.0)
	public static double RAbs(double r) {
		return Math.abs(r);
	}

	// public static double NAbs(n) abs(n)
	public static double RFloor(double r) {
		return Math.floor(r);
	}

	// public static double NFloor(r) ((int)RFloor(r))
	
	public static double RSqr(double r) {
		return Math.sqrt(r);
	}
	public static double RSin(double r) {
		return Math.sin(r);
	}

	public static double RCos(double r) {
		return Math.cos(r);
	}

	public static double RTan(double r) {
		return Math.tan(r);
	}
	public static double RAtn(double r) {
		return Math.atan(r);
	}
	public static double RAsin(double r) {
		return Math.asin(r);
	}
	public static double RAcos(double r) {
		return Math.acos(r);
	}
	public static double RSinD(double r) {
		return Math.sin(RFromD(r));
	}
	// public static double RCosD(r) RCos(RFromD(r))
	// public static double NSinD(nR, nD) ((int)((real)(nR)*RSinD((real)nD)))
	// public static double NCosD(nR, nD) ((int)((real)(nR)*RCosD((real)nD)))

	// #define FItem(obj) FBetween(obj, 0, cObj)
	// #define FNorm(obj) FBetween(obj, 0, oNorm)
	// #define FCusp(obj) FBetween(obj, cuspLo, cuspHi)
	// #define FAngle(obj) (FCusp(obj) && ((obj)-cuspLo)%3 == 0)
	// #define FMinor(obj) (FCusp(obj) && ((obj)-cuspLo)%3 != 0)
	// #define FUranian(obj) FBetween(obj, uranLo, uranHi)
	// #define FStar(obj) FBetween(obj, starLo, starHi)
	// #define FObject(obj) ((obj) <= oVes || (obj) >= uranLo)
	// #define FThing(obj) ((obj) <= cThing || (obj) >= uranLo)
	// #define FHelio(obj) (FNorm(obj) && FObject(obj) && (obj) != oMoo)
	// #define FAspect(asp) FBetween(asp, 1, cAspect)
	// #define FSector(s) FBetween(s, 1, cSector)
	// #define ChDashF(f) (f ? '=' : '_')
	// #define SzNumF(f) (f ? "1 " : "0 ")
	// #define ChDst(dst) (dst == 0.0 ? 'S' : (dst == 1.0 ? 'D' : \
	// (dst != 24.0 ? 'A' : (is.fDst ? 'D' : 'S'))))
	// #define DayInYearHi(yea) (365-28+DayInMonth(2, yea))
	// #define FChSwitch(ch) \
	// ((ch) == '-' || (ch) == '/' || (ch) == '_' || (ch) == '=' || (ch) == ':')
	//
	// #define FValidMon(mon) FBetween(mon, 1, 12)
	// #define FValidDay(day, mon, yea) ((day) >= 1 && (day) <= DayInMonth(mon,
	// yea))
	// #define FValidYea(yea) FBetween(yea, -32000, 32000)
	// #define FValidTim(tim) ((tim) > -2.0 && (tim) < 24.0)
	// #define FValidDst(dst) FValidZon(dst)
	// #define FValidZon(zon) FBetween(zon, -24.0, 24.0)
	// #define FValidLon(lon) FBetween(lon, -rDegHalf, rDegHalf)
	// #define FValidLat(lat) FBetween(lat, -rDegQuad, rDegQuad)
	// #define FValidAspect(asp) FBetween(asp, 0, cAspect)
	// #define FValidSystem(n) FBetween(n, 0, cSystem-1)
	// #define FValidDivision(n) FBetween(n, 1, 2880)
	// #define FValidOffset(r) FBetween(r, -rDegMax, rDegMax)
	// #define FValidCenter(obj) (FBetween(obj, oEar, uranHi) && FThing(obj))
	// #define FValidHarmonic(r) FBetween(r, -32000.0, 32000.0)
	// #define FValidWheel(n) FBetween(n, 1, WHEELROWS)
	// #define FValidAstrograph(n) ((n) > 0 && (n) < 90)
	// #define FValidPart(n) FBetween(n, 1, cPart)
	// #define FValidBioday(n) FBetween(n, 1, 199)
	// #define FValidScreen(n) FBetween(n, 20, 200)
	// #define FValidMacro(n) FBetween(n, 1, 48)
	// #define FValidGlyphs(n) FBetween(n, 0, 2232)
	// #define FValidGrid(n) FBetween(n, 1, cObj)
	// #define FValidEsoteric(n) FBetween(n, 1, 32000)
	// #define FValidScale(n) (FBetween(n, 100, MAXSCALE) && (n)%100 == 0)
	// #define FValidGraphx(x) (FBetween(x, BITMAPX1, BITMAPX) || (x) == 0)
	// #define FValidGraphy(y) (FBetween(y, BITMAPY1, BITMAPY) || (y) == 0)
	// #define FValidRotation(n) FBetween(n, 0, nDegMax-1)
	// #define FValidTilt(n) FBetween(n, -rDegQuad, rDegQuad)
	// #define FValidColor(n) FBetween(n, 0, cColor - 1)
	// #define FValidBmpmode(ch) \
	// ((ch) == 'N' || (ch) == 'C' || (ch) == 'V' || (ch) == 'A' || (ch) == 'B')
	// #define FValidTimer(n) FBetween(n, 1, 32000)
	//
	// #define DM(d, m) ((d) + (m)/60.0)
	// #define DMS(d, m, s) (DM(d, m) + (s)/3600.0)
	// #define ZD(z, d) ((real)(((z)-1)*30) + (d))
	// #define ZDMS(z, d, m, s) ((real)(((z)-1)*30) + DMS(d, m, s))
	// #define HM(h, m) ((h) + (m)/60.0)
	// #define HMS(h, m, s) (HM(h, m) + (s)/3600.0)
	//
	// #define kSignA(s) kObjA[cuspLo-1+(s)]
	// #define kSignB(s) kObjB[cuspLo-1+(s)]
	// #define kModeA(m) kElemA[(m) <= 1 ? (m) : eWat]
	// #define kModeB(m) kElemB[(m) <= 1 ? (m) : eWat]
	// #define FInterpretObj(obj) ((obj) <= cObjInt && szMindPart[obj][0])
	// #define FInterpretAsp(asp) ((asp) > 0 && szInteract[asp][0])
	// #define szPerson (ciMain.nam[0] ? ciMain.nam : "This person")
	// #define szPerson0 (ciMain.nam[0] ? ciMain.nam : "the person")
	// #define szPerson1 (ciMain.nam[0] ? ciMain.nam : "Person1")
	// #define szPerson2 (ciTwin.nam[0] ? ciTwin.nam : "Person2")
	// #define FIgnore(i) ignore[i]
	// #define FIgnore2(i) ignore2[i]
	// #define fNoTimeOrSpace (Mon == -1)
	//
	// #define loop for (;;)
	// #define inv(v) v = !(v)
	public static void neg(RefVariant v) {
		v.from(-v.toDouble());
	}
	// #define PrintL() PrintCh('\n')
	// #define PrintL2() PrintSz("\n\n")
	// #define PrintF(sz) fprintf(file, sz)
	// #define PrintFSz() fprintf(file, sz)
	public static void SwapN(int[] a, int n1, int n2) {
		(a[n1]) ^= (a[n2]) ^= (a[n1]) ^= (a[n2]);
	}
	// #define FSwitchF(f) ((((f) | fOr) & !fAnd) ^ fNot)
	// #define SwitchF(f) f = FSwitchF(f)
	// #define SwitchF2(f) f = (((f) | (fOr || fNot)) & !fAnd)
	// #define SetCI(ci, M, D, Y, T, S, Z, O, A) \
	// ci.mon = M; ci.day = D; ci.yea = Y; \
	// ci.tim = T; ci.dst = S; ci.zon = Z; ci.lon = O; ci.lat = A
	//
	// #define CONST const
	// #define PAllocateCore(cb) malloc(cb)
	// #define DeallocateP(p) free(p)
	// #ifndef PC
	// #define chDirSep '/'
	// #define chSwitch '-'
	// #ifndef MACOLD
	// #define ldTime 2440588L
	// #else
	// #define ldTime 2416481L
	// #endif
	// #else /* PC */
	// #define chDirSep '\\'
	// #define chSwitch '/'
	// #define ldTime 2440588L
	// #endif /* PC */
	//
	// #ifdef GRAPH
	// #ifdef WIN
	// #define API FAR PASCAL
	// #define hdcNil ((HDC)NULL)
	// #define SetWindowOrg(hdc, x, y) SetWindowOrgEx(hdc, x, y, NULL)
	// #define SetWindowExt(hdc, x, y) SetWindowExtEx(hdc, x, y, NULL)
	// #define SetViewportOrg(hdc, x, y) SetViewportOrgEx(hdc, x, y, NULL)
	// #define SetViewportExt(hdc, x, y) SetViewportExtEx(hdc, x, y, NULL)
	// #define MoveTo(hdc, x, y) MoveToEx(hdc, x, y, NULL)
	// #endif
	//
	// /* Should an object in the outer wheel be restricted? */
	// #define FProper2(i) (!(us.nRel == rcTransit ? ignore2[i] : ignore[i]))
	//
	// /* Are particular coordinates on the chart? */
	// #define FInRect(x, y, x1, y1, x2, y2) \
	// ((x) >= (x1) && (x) < (x2) && (y) >= (y1) && (y) < (y2))
	// #define FOnWin(X, Y) FInRect((X), (Y), 0, 0, gs.xWin, gs.yWin)
	//
	// /* Get a coordinate based on chart radius, a fraction, and (co)sin value. */
	// #define POINT1(U, R, S) ((int)(((U)+1.4)*(R)*(S)))
	// #define POINT2(U, R, S) ((int)(((U)-0.3)*(R)*(S)))
	//
	// /* Determine (co)sin factors based on zodiac angle and chart orientation. */
	// #define PX(A) RCosD(A)
	// #define PY(A) RSinD(A)
	// #define PZ(A) PlaceInX(A)
	//
	// /* Compute Mollewide projection in pixel scale given latitude. */
	// #define NMollewide(y) \
	// ((int)(RSqr((real)(180L*nScl*180L*nScl - 4L*(y)*nScl*(y)*nScl))+rRound))
	//
	// /* Do settings indicate the current chart should have the info sidebar? */
	// #define fSidebar ((gi.nMode == gWheel || gi.nMode == gHouse || \
	// gi.nMode == gSector) && gs.fText && !us.fVelocity)
	//
	// /* Is the current chart most properly displayed as a square graphic? */
	// #define fSquare \
	// (gi.nMode == gWheel || gi.nMode == gHouse || gi.nMode == gGrid || \
	// (gi.nMode == gHorizon && us.fPrimeVert) || gi.nMode == gDisposit || \
	// gi.nMode == gOrbit || gi.nMode == gGlobe || gi.nMode == gPolar)
	//
	// /* Does the current chart have to be displayed in a map rectangle? */
	// #define fMap \
	// (gi.nMode == gAstroGraph || gi.nMode == gWorldMap)
	//
	// /* Do settings indicate the current chart should have an outer border? */
	// #define fDrawBorder \
	// ((gs.fBorder || gi.nMode == gGrid) && gi.nMode != gGlobe && \
	// gi.nMode != gPolar && (gi.nMode != gWorldMap || !gs.fMollewide))
	//
	// /* Do settings indicate current chart should have chart info at its bottom?
	// */
	// #define fDrawText \
	// (gs.fText && gi.nMode != gCalendar && gi.nMode != gWorldMap && \
	// gi.nMode != gGlobe && gi.nMode != gPolar && ((gi.nMode != gWheel && \
	// gi.nMode != gHouse && gi.nMode != gSector) || us.fVelocity))
	// #endif /* GRAPH */

}
