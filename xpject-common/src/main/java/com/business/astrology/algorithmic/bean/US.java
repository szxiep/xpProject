package com.business.astrology.algorithmic.bean;

public class US {
	/* Chart types */
	public Flag fListing = new Flag(1); /* -v */
	public Flag fWheel = new Flag(0); /* -w */
	public Flag fGrid = new Flag(0); /* -g */
	public Flag fAspList = new Flag(0); /* -a */
	public Flag fMidpoint = new Flag(0); /* -m */
	public Flag fHorizon = new Flag(0); /* -Z */
	public Flag fOrbit = new Flag(0); /* -S */
	public Flag fSector = new Flag(0); /* -l */
	public Flag fInfluence = new Flag(0); /* -j */
	public Flag fEsoteric = new Flag(0); /* -7 */
	public Flag fAstroGraph = new Flag(0); /* -L */
	public Flag fCalendar = new Flag(0); /* -K */
	public Flag fInDay = new Flag(0); /* -d */
	public Flag fInDayInf = new Flag(0); /* -D */
	public Flag fEphemeris = new Flag(0); /* -E */
	public Flag fTransit = new Flag(0); /* -t */
	public Flag fTransitInf = new Flag(0); /* -T */

	/* Chart suboptions */
	public Flag fVelocity = new Flag(0); /* -v0 */
	public Flag fWheelReverse = new Flag(0); /* -w0 */
	public Flag fGridConfig = new Flag(1); /* -g0 */
	public Flag fAppSep = new Flag(0); /* -ga */
	public Flag fParallel = new Flag(0); /* -gp */
	public Flag fAspSummary = new Flag(1); /* -a0 */
	public Flag fMidSummary = new Flag(1); /* -m0 */
	public Flag fMidAspect = new Flag(0); /* -ma */
	public Flag fPrimeVert = new Flag(0); /* -Z0 */
	public Flag fHorizonSearch = new Flag(0); /* -Zd */
	public Flag fSectorApprox = new Flag(0); /* -l0 */
	public Flag fInfluenceSign = new Flag(1); /* -j0 */
	public Flag fLatitudeCross = new Flag(1); /* -L0 */
	public Flag fCalendarYear = new Flag(0); /* -Ky */
	public Flag fInDayMonth = new Flag(0); /* -dm */
	public Flag fArabicFlip = new Flag(0); /* -P0 */

	/* Table chart types */
	public Flag fCredit = new Flag(0); /* -Hc */
	public Flag fSwitch = new Flag(0); /* -H */
	public Flag fSwitchRare = new Flag(0); /* -Y */
	public Flag fKeyGraph = new Flag(0); /* -HX */
	public Flag fSign = new Flag(0); /* -HC */
	public Flag fObject = new Flag(0); /* -HO */
	public Flag fAspect = new Flag(0); /* -HA */
	public Flag fConstel = new Flag(0); /* -HF */
	public Flag fOrbitData = new Flag(0); /* -HS */
	public Flag fRay = new Flag(0); /* -H7 */
	public Flag fMeaning = new Flag(0); /* -HI */

	/* Main flags */
	public Flag fLoop = new Flag(0); /* -Q */
	public Flag fSidereal = new Flag(0); /* -s */
	public Flag fCusp = new Flag(1); /* -C */
	public Flag fUranian = new Flag(1); /* -u */
	public Flag fProgress = new Flag(0); /* Are we doing a -p progressed chart? */
	public Flag fInterpret = new Flag(0); /* Is -I interpretation switch in effect? */
	public Flag fHouse3D = new Flag(0); /* -c3 */
	public Flag fDecan = new Flag(0); /* -3 */
	public Flag fFlip = new Flag(0); /* -f */
	public Flag fGeodetic = new Flag(0); /* -G */
	public Flag fVedic = new Flag(0); /* -J */
	public Flag fNavamsa = new Flag(0); /* -9 */
	public Flag fEphemFiles = new Flag(0); /* -b */
	public Flag fWriteFile = new Flag(0); /* -o */
	public Flag fAnsiColor = new Flag(0); /* -k */
	public Flag fGraphics = new Flag(1); /* -X */

	/* Main subflags */
	public Flag fNoSwitches = new Flag(0);
	public Flag fLoopInit = new Flag(0); /* -Q0 */
	public Flag fSeconds = new Flag(0); /* -b0 */
	public Flag fPlacalcAst = new Flag(0); /* -ba */
	public Flag fPlacalcPla = new Flag(0); /* -bp */
	public Flag fMatrixPla = new Flag(1); /* -bm */
	public Flag fEquator = new Flag(0); /* -sr */
	public Flag fSolarArc = new Flag(0); /* -p0 */
	public Flag fWritePos = new Flag(0); /* -o0 */
	public Flag fAnsiChar = new Flag(0); /* -k0 */
	public Flag fSolarWhole = new Flag(0); /* -10 */

	/* Rare flags */
	public Flag fTruePos = new Flag(0); /* -YT */
	public Flag fTopoPos = new Flag(0); /* -YV */
	public Flag fTrueNode = new Flag(0); /* -Yn */
	public Flag fEuroDate = new Flag(0); /* -Yd */
	public Flag fEuroTime = new Flag(0); /* -Yt */
	public Flag fEuroDist = new Flag(0); /* -Yv */
	public Flag fRound = new Flag(0); /* -Yr */
	public Flag fSmartCusp = new Flag(1); /* -YC */
	public Flag fSmartSave = new Flag(1); /* -YO */
	public Flag fClip80 = new Flag(1); /* -Y8 */
	public Flag fWriteOld = new Flag(0); /* -Yo */
	public Flag fHouseAngle = new Flag(0); /* -Yc */
	public Flag fPolarAsc = new Flag(0); /* -Yp */
	public Flag fObjRotWhole = new Flag(0); /* -Y10 */
	public Flag fIgnoreSign = new Flag(0); /* -YR0 */
	public Flag fIgnoreDir = new Flag(0); /* -YR0 */
	public Flag fNoWrite = new Flag(0); /* -0o */
	public Flag fNoRead = new Flag(0); /* -0i */
	public Flag fNoQuit = new Flag(0); /* -0q */
	public Flag fNoGraphics = new Flag(0); /* -0X */

	/* Value settings */
	public int nEphemYears; /* -Ey */
	public int nArabic; /* -P */
	public int nRel; /* What relationship chart are we doing, if any? */
	public int nHouseSystem; /* -c */
	public int nAsp = 5; /* -A */
	public int objCenter =0; /* -h */
	public int nStar = 1; /* -U */
	public double rHarmonic = 1.0000000000000000; /* Harmonic chart value passed to -x switch. */
	public int objOnAsc; /* Planet value passed to -1 or -2 switch. */
	public int dayDelta; /* -+, -- */
	public int nDegForm; /* -s */
	public int nDivision = 48; /* -d */
	public int nScreenWidth = 80; /* -I */
	public double dstDef = 24.000000000000000; /* -z0 */
	public double zonDef = 8.0000000000000000; /* -z */
	public double lonDef = 122.33305555555555; /* -zl */
	public double latDef = 47.609722222222224; /* -zl */
	public double elvDef = 50.901600000000002; /* -zv */
	public StringBuilder namDef = new StringBuilder("Current moment now"); /* -zj */
	public StringBuilder locDef = new StringBuilder("Seattle, WA"); /* -zj */

	/* Value subsettings */
	public int nWheelRows = 4; /* Number of rows per house to use for -w wheel. */
	public int nAstroGraphStep = 2; /* Latitude step rate passed to -L switch. */
	public int nArabicParts = 177; /* Arabic parts to include value passed to -P. */
	public double rZodiacOffset = 0.00000000000000000; /* Position shifting value passed to -s switch. */
	public double rProgDay = 365.24218999999999; /* Progression day value passed to -pd switch. */
	public int nRatio1 = 1; /* Chart ratio factors passed to -rc or -rm. */
	public int nRatio2 = 1;
	public int nScrollRow; /* -YQ */
	public long lTimeAddition; /* -Yz */
	public int objRot1; /* -Y1 */
	public int objRot2; /* -Y1 */
	public int nArabicNight; /* -YP */
	public int nBioday = 14; /* -Yb */
}
