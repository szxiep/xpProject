package com.business.astrology.algorithmic.utils;

public class Constants {

	public static final int fNone = 0;

	public static final int FALSE = 0;
	public static final int TRUE = 1;

	public static final int OK = 0;
	public static final int ERR = (-1);
	public static final int NOT_AVAILABLE = (-2);
	public static final int BEYOND_EPH_LIMITS = (-3);

	public static final int cSign = 12;

	public static final String szAppNameCore = "Astrolog";
	public static final String szVersionCore = "6.20";
	public static final String szArchCore = "32 bit";
	public static final String szDateCore = "March 2017";
	public static final String szAddressCore = "Astara@msn.com - http://www.astrolog.org/astrolog.htm";
	public static final String szNowCore = "now";
	public static final String szTtyCore = "tty";
	public static final String szSetCore = "set";
	public static final String szNulCore = "nul";

	/* Month index values */

	public static final int mJan = 1;
	public static final int mFeb = 2;
	public static final int mMar = 3;
	public static final int mApr = 4;
	public static final int mMay = 5;
	public static final int mJun = 6;
	public static final int mJul = 7;
	public static final int mAug = 8;
	public static final int mSep = 9;
	public static final int mOct = 10;
	public static final int mNov = 11;
	public static final int mDec = 12;

	/* Elements */

	public static final int eFir = 0;
	public static final int eEar = 1;
	public static final int eAir = 2;
	public static final int eWat = 3;
	public static final int cElem = 4;

	/* Zodiac signs */

	public static final int sAri = 1;
	public static final int sTau = 2;
	public static final int sGem = 3;
	public static final int sCan = 4;
	public static final int sLeo = 5;
	public static final int sVir = 6;
	public static final int sLib = 7;
	public static final int sSco = 8;
	public static final int sSag = 9;
	public static final int sCap = 10;
	public static final int sAqu = 11;
	public static final int sPis = 12;

	/* Aspects */

	public static final int aDir = -2;
	public static final int aSig = -1;
	public static final int aCon = 1;
	public static final int aOpp = 2;
	public static final int aSqu = 3;
	public static final int aTri = 4;
	public static final int aSex = 5;
	public static final int aInc = 6;
	public static final int aSSx = 7;
	public static final int aSSq = 8;
	public static final int aSes = 9;
	public static final int aQui = 10;
	public static final int aBQn = 11;
	public static final int aSQn = 12;
	public static final int aSep = 13;
	public static final int aNov = 14;
	public static final int aBNv = 15;
	public static final int aBSp = 16;
	public static final int aTSp = 17;
	public static final int aQNv = 18;

	public static final int cchSzDef = 80;
	public static final int cchSzMax = 255;
	public static final int nDegMax = 360;
	public static final int nDegHalf = 180;
	public static final int yeaJ2G = 1582;
	public static final int monJ2G = mOct;
	public static final int dayJ2G1 = 4;
	public static final int dayJ2G2 = 15;

	public static final double rSqr2 = 1.41421356237309504880;
	public static final double rPi = 3.14159265358979323846;
	public static final double rPi2 = (rPi * 2.0);
	public static final double rPiHalf = (rPi / 2.0);
	public static final double rDegMax = 360.0;
	public static final double rDegHalf = 180.0;
	public static final double rDegQuad = 90.0;
	public static final double rDegRad = (rDegHalf / rPi);
	public static final double rFtToM = 0.3048;
	public static final double rInToCm = 2.54;
	public static final double rDayInYear = 365.24219;
	public static final double rEarthDist = 149.59787;
	public static final double rEpoch2000 = (-24.736467);
	public static final double rAxis = 23.44578889;
	public static final double rSmall = (1.7453E-09);
	public static final double rLarge = 10000.0;
	public static final double rRound = 0.5;

	public static final char chNull = '\0';
	public static final char chEscape = '\33';
	public static final char chBell = '\7';
	public static final char chReturn = '\r';
	public static final char chTab = '\t';
	public static final char chDelete = '\b';
	public static final char chBreak = '\3';
	public static final char chRet = 'R';

	/* Object array index values */

	public static final int oMain = 10;
	public static final int oCore = 21;
	public static final int cUran = 9;
	public static final int cStar = 47;
	public static final int cuspLo = (oCore + 1);
	public static final int cuspHi = (cuspLo + cSign - 1);
	public static final int uranLo = (cuspHi + 1);
	public static final int uranHi = (uranLo + cUran - 1);
	public static final int oNorm = uranHi;
	public static final int starLo = (uranHi + 1);
	public static final int oNorm1 = starLo;
	public static final int starHi = (starLo + cStar - 1);

	/* Objects 星体 */

	public static final int oEar = 0;//地球
	public static final int oSun = 1;//太阳
	public static final int oMoo = 2;//月亮
	public static final int oMer = 3;//水
	public static final int oVen = 4;//金
	public static final int oMar = 5;//火
	public static final int oJup = 6;//木
	public static final int oSat = 7;//土
	public static final int oUra = 8;//天王
	public static final int oNep = 9;//海王
	public static final int oPlu = 10;//冥王
	public static final int oChi = 11;//凯龙星
	public static final int oCer = 12;//谷神星
	public static final int oPal = 13;//智神星
	public static final int oJun = 14;//婚神星
	public static final int oVes = 15;//灶神星
	public static final int oNod = 16;// 北交点
	public static final int oSou = 17;// 南交点
	public static final int oLil = 18;//莉莉兹
	public static final int oFor = 19;//福点
	public static final int oVtx = 20;// 宿命点
	public static final int oEP = 21;//东方点
	public static final int oAsc = 22;//上升点(第一宫宫首)
	public static final int o2nd = 23;//第二宫宫首
	public static final int o3rd = 24;
	public static final int oNad = 25;
	public static final int o5th = 26;
	public static final int o6th = 27;
	public static final int oDes = 28;
	public static final int o8th = 29;
	public static final int o9th = 30;
	public static final int oMC = 31;// 天顶(第十宫宫首)
	public static final int o11t = 32;
	public static final int o12t = 33;//第12宫宫首
	public static final int oVul = 34;//火神星，往后依次是丘比特、哈德斯、波塞冬、宙斯、克洛诺斯、
									//阿波罗、阿德门图斯、弗卡努斯、普罗赛比娜
	
	public static final int oOri = (starLo - 1 + 10);
	public static final int oAnd = (starLo - 1 + 47);

	public static final int cPlanet = oVes;
	public static final int cThing = oLil;

	/* Array index limits */

	public static final int cObj = 89;
	public static final int cObjInt = uranHi;
	public static final int objMax = (cObj + 1);
	public static final int cAspect = 18;
	public static final int cCnstl = 88;
	public static final int cZone = 69;
	public static final int cSector = 36;
	public static final int cPart = 177;
	public static final int cWeek = 7;
	public static final int cColor = 16;
	public static final int cRay = 7;
	public static final int xFont = 6;
	public static final int yFont = 10;
	// public static final int xFontT = (xFont * gi.nScaleText * gi.nScaleT);
	// public static final int yFontT = (yFont * gi.nScaleText * gi.nScaleT);
	// public static final int xSideT = (SIDESIZE * gi.nScaleText * gi.nScaleT);

	/* House systems */

	public static final int hsPlacidus = 0;
	public static final int hsKoch = 1;
	public static final int hsEqual = 2;
	public static final int hsCampanus = 3;
	public static final int hsMeridian = 4;
	public static final int hsRegiomontanus = 5;
	public static final int hsPorphyry = 6;
	public static final int hsMorinus = 7;
	public static final int hsTopocentric = 8;
	public static final int hsAlcabitius = 9;
	public static final int hsKrusinski = 10;
	public static final int hsEqualMC = 11;
	public static final int hsSinewaveRatio = 12;
	public static final int hsSinewaveDelta = 13;
	public static final int hsWhole = 14;
	public static final int hsVedic = 15;
	public static final int hsSripati = 16;
	public static final int hsNull = 17;
	public static final int cSystem = 18;

	/* Biorhythm cycle constants */

	public static final double brPhy = 23.0;
	public static final double brEmo = 28.0;
	public static final double brInt = 33.0;

	/* Relationship chart modes */

	public static final int rcNone = 0;
	public static final int rcSynastry = 1;
	public static final int rcComposite = 2;
	public static final int rcMidpoint = 3;
	public static final int rcDifference = 4;
	public static final int rcBiorhythm = 5;
	public static final int rcDual = -1;
	public static final int rcTriWheel = -2;
	public static final int rcQuadWheel = -3;
	public static final int rcTransit = -4;
	public static final int rcProgress = -5;

	/* Aspect configurations */

	public static final int acS3 = 0; // Stellium (3 planets)
	public static final int acGT = 1; // Grand Trine
	public static final int acTS = 2; // T-Square
	public static final int acY = 3; // Yod
	public static final int acGC = 4; // Grand Cross
	public static final int acC = 5; // Cradle
	public static final int acS4 = 6; // Stellium (4 planets)
	public static final int cAspConfig = 7;

	/* Graphics chart modes */

	public static final int gWheel = 1;
	public static final int gHouse = 2;
	public static final int gGrid = 3;
	public static final int gHorizon = 4;
	public static final int gOrbit = 5;
	public static final int gSector = 6;
	public static final int gCalendar = 7;
	public static final int gDisposit = 8;
	public static final int gEsoteric = 9;
	public static final int gAstroGraph = 10;
	public static final int gEphemeris = 11;
	public static final int gWorldMap = 12;
	public static final int gGlobe = 13;
	public static final int gPolar = 14;
	public static final int gBiorhythm = 15;
	public static final int gAspect = 16;
	public static final int gMidpoint = 17;
	public static final int gArabic = 18;
	public static final int gSign = 19;
	public static final int gObject = 20;
	public static final int gHelpAsp = 21;
	public static final int gConstel = 22;
	public static final int gPlanet = 23;
	public static final int gMeaning = 24;
	public static final int gRay = 25;
	public static final int gSwitch = 26;
	public static final int gObscure = 27;
	public static final int gKeystroke = 28;
	public static final int gCredit = 29;
	public static final int gRising = 30;
	public static final int gTraTraHit = 31;
	public static final int gTraTraInf = 32;
	public static final int gTraNatHit = 33;
	public static final int gTraNatInf = 34;

	/* Colors */

	public static final int kReverse = -2;
	public static final int kDefault = -1;
	public static final int kBlack = 0;
	public static final int kMaroon = 1;
	public static final int kDkGreen = 2;
	public static final int kOrange = 3;
	public static final int kDkBlue = 4;
	public static final int kPurple = 5;
	public static final int kDkCyan = 6;
	public static final int kLtGray = 7;
	public static final int kDkGray = 8;
	public static final int kRed = 9;
	public static final int kGreen = 10;
	public static final int kYellow = 11;
	public static final int kBlue = 12;
	public static final int kMagenta = 13;
	public static final int kCyan = 14;
	public static final int kWhite = 15;
	public static final int kElement = 16;
	public static final int kRay = 17;
	public static final int kNull = 16;

	/* Arabic parts */

	public static final int apFor = 0;
	public static final int apSpi = 1;

	/* Calculation methods */

	public static final int cmSwiss = 0;
	public static final int cmPlacalc = 1;
	public static final int cmMatrix = 2;
	public static final int cmNone = 3;
	public static final int cmMax = 4;

	/* Draw text formatting flags */

	public static final int dtCent = 0x0; // Default: Center text at coordinates
	public static final int dtLeft = 0x1; // Left justify text at X coordinate
	public static final int dtTop = 0x2; // Y coordinate is top of text
	public static final int dtBottom = 0x4; // Y coordinate is bottom of text
	public static final int dtErase = 0x8; // Erase background behind text
	public static final int dtScale = 0x10; // Scale text by -Xs character scale
	public static final int dtScale2 = 0x20; // Scale text by -XS text scale

	/* User string parse modes */

	public static final int pmMon = 1;
	public static final int pmDay = 2;
	public static final int pmYea = 3;
	public static final int pmTim = 4;
	public static final int pmDst = 5;
	public static final int pmZon = 6;
	public static final int pmLon = 7;
	public static final int pmLat = 8;
	public static final int pmElv = 9;
	public static final int pmLength = 10;
	public static final int pmObject = 11;
	public static final int pmAspect = 12;
	public static final int pmSystem = 13;
	public static final int pmSign = 14;
	public static final int pmColor = 15;

	/* Termination codes */

	public static final int tcError = -1;
	public static final int tcOK = 0;
	public static final int tcFatal = 1;
	public static final int tcForce = 2;
}