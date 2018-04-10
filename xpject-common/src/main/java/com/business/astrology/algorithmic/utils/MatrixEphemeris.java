package com.business.astrology.algorithmic.utils;

import com.business.astrology.algorithmic.bean.Flag;
import com.business.astrology.algorithmic.bean.PolarCoorF;
import com.business.astrology.algorithmic.bean.RectCoorF;
import com.business.astrology.algorithmic.bean.RefVariant;
import com.business.astrology.algorithmic.impl.AstrologContext;
import com.business.astrology.algorithmic.table.ObjectCalculationTables;

public class MatrixEphemeris {

	private AstrologContext context;

	public MatrixEphemeris(AstrologContext context) {
		super();
		this.context = context;
	}

	public void EclToEqu(RefVariant Z, RefVariant L) {
		CoorXform(Z, L, context.is.OB);
	}

	public void EquToEcl(RefVariant Z, RefVariant L) {
		CoorXform(Z, L, -context.is.OB);
	}

	public void EquToLocal(RefVariant Z, RefVariant L, double T) {
		CoorXform(Z, L, T);
	}

	public static double JulianDayFromTime(double t) {
		return ((t) * 36525.0 + 2415020.0);
	}

	public static int IoeFromObj(int obj) {
		return ((obj) < Constants.oMoo ? 0
				: ((obj) <= Constants.cPlanet ? (obj) - 2 : (obj) - Constants.uranLo + Constants.cPlanet - 2));
	}

	public double Tropical(double deg) {
		return (deg - context.is.rSid + context.us.rZodiacOffset);
	}

	/* Given three values, return them combined as the coefficients of a */
	/* quadratic equation as a function of the chart time. */

	public double ReadThree(double r0, double r1, double r2) {
		return Macro.RFromD(r0 + r1 * context.is.T + r2 * context.is.T * context.is.T);
	}

	/* Do a coordinate transformation: Given a longitude and latitude value, */
	/* return the new longitude and latitude values that the same location */
	/* would have, were the equator tilted by a specified number of degrees. */
	/* In other words, do a pole shift! This is used to convert among ecliptic, */
	/* equatorial, and local coordinates, each of which have zero declination */
	/*
	 * in different planes. In other words, take into account the Earth's
	 * axcontext.is.
	 */

	public void CoorXform(RefVariant azi, RefVariant alt, double tilt) {
		double x, y, a1, l1;
		double sinalt, cosalt, sinazi, sintilt, costilt;

		sinalt = Math.sin(alt.toDouble());
		cosalt = Math.cos(alt.toDouble());
		sinazi = Math.sin(azi.toDouble());
		sintilt = Math.sin(tilt);
		costilt = Math.cos(tilt);

		x = cosalt * sinazi * costilt;
		y = sinalt * sintilt;
		x -= y;
		a1 = cosalt;
		y = cosalt * Math.cos(azi.toDouble());
		l1 = GeneralProcedures.Angle(y, x);
		a1 = a1 * sinazi * sintilt + sinalt * costilt;
		a1 = Math.asin(a1);
		azi.from(l1);
		alt.from(a1);
	}

	public void HousePlacidus() {
		int i;

		context.cp0.cusp[1] = GeneralProcedures.Mod(context.is.Asc - context.is.rSid);
		context.cp0.cusp[4] = GeneralProcedures.Mod(context.is.MC + Constants.rDegHalf - context.is.rSid);
		context.cp0.cusp[5] = CuspPlacidus(30.0, 3.0, Flag.FALSE) + Constants.rDegHalf;
		context.cp0.cusp[6] = CuspPlacidus(60.0, 1.5, Flag.FALSE) + Constants.rDegHalf;
		context.cp0.cusp[2] = CuspPlacidus(120.0, 1.5, Flag.TRUE);
		context.cp0.cusp[3] = CuspPlacidus(150.0, 3.0, Flag.TRUE);
		for (i = 1; i <= Constants.cSign; i++) {
			if (i <= 6)
				context.cp0.cusp[i] = GeneralProcedures.Mod(context.cp0.cusp[i] + context.is.rSid);
			else
				context.cp0.cusp[i] = GeneralProcedures.Mod(context.cp0.cusp[i - 6] + Constants.rDegHalf);
		}
	}

	public void HouseKoch() {
		double A1, A2, A3, KN, D, X;
		int i;

		A1 = Macro.RSin(context.is.RA) * Macro.RTan(context.ciCore.lat) * Macro.RTan(context.is.OB);
		A1 = Macro.RAsin(A1);
		for (i = 1; i <= Constants.cSign; i++) {
			D = GeneralProcedures.Mod(60.0 + 30.0 * (double) i);
			A2 = D / Constants.rDegQuad - 1.0;
			KN = 1.0;
			if (D >= Constants.rDegHalf) {
				KN = -1.0;
				A2 = D / Constants.rDegQuad - 3.0;
			}
			A3 = Macro.RFromD(GeneralProcedures.Mod(Macro.DFromR(context.is.RA) + D + A2 * Macro.DFromR(A1)));
			X = GeneralProcedures.Angle(Macro.RCos(A3) * Macro.RCos(context.is.OB)
					- KN * Macro.RTan(context.ciCore.lat) * Macro.RSin(context.is.OB), Macro.RSin(A3));
			context.cp0.cusp[i] = GeneralProcedures.Mod(Macro.DFromR(X) + context.is.rSid);
		}
	}

	public void HouseEqual() {
		int i;

		for (i = 1; i <= Constants.cSign; i++)
			context.cp0.cusp[i] = GeneralProcedures.Mod(context.is.Asc + Macro.ZFromS(i));
	}

	public void HouseCampanus() {
		double KO, DN, X;
		int i;

		for (i = 1; i <= Constants.cSign; i++) {
			KO = Macro.RFromD(60.000001 + 30.0 * (double) i);
			DN = Macro.RAtn(Macro.RTan(KO) * Macro.RCos(context.ciCore.lat));
			if (DN < 0.0)
				DN += Constants.rPi;
			if (Macro.RSin(KO) < 0.0)
				DN += Constants.rPi;
			X = GeneralProcedures.Angle(
					Macro.RCos(context.is.RA + DN) * Macro.RCos(context.is.OB)
							- Macro.RSin(DN) * Macro.RTan(context.ciCore.lat) * Macro.RSin(context.is.OB),
					Macro.RSin(context.is.RA + DN));
			context.cp0.cusp[i] = GeneralProcedures.Mod(Macro.DFromR(X) + context.is.rSid);
		}
	}

	public void HouseMeridian() {
		double D, X;
		int i;

		for (i = 1; i <= Constants.cSign; i++) {
			D = Macro.RFromD(60.0 + 30.0 * (double) i);
			X = GeneralProcedures.Angle(Macro.RCos(context.is.RA + D) * Macro.RCos(context.is.OB),
					Macro.RSin(context.is.RA + D));
			context.cp0.cusp[i] = GeneralProcedures.Mod(Macro.DFromR(X) + context.is.rSid);
		}
	}

	public void HouseRegiomontanus() {
		double D, X;
		int i;

		for (i = 1; i <= Constants.cSign; i++) {
			D = Macro.RFromD(60.0 + 30.0 * (double) i);
			X = GeneralProcedures.Angle(
					Macro.RCos(context.is.RA + D) * Macro.RCos(context.is.OB)
							- Macro.RSin(D) * Macro.RTan(context.ciCore.lat) * Macro.RSin(context.is.OB),
					Macro.RSin(context.is.RA + D));
			context.cp0.cusp[i] = GeneralProcedures.Mod(Macro.DFromR(X) + context.is.rSid);
		}
	}

	public void HousePorphyry() {
		double X, Y;
		int i;

		X = context.is.Asc - context.is.MC;
		if (X < 0.0)
			X += Constants.rDegMax;
		Y = X / 3.0;
		for (i = 1; i <= 2; i++)
			context.cp0.cusp[i + 4] = GeneralProcedures.Mod(Constants.rDegHalf + context.is.MC + i * Y);
		X = GeneralProcedures.Mod(Constants.rDegHalf + context.is.MC) - context.is.Asc;
		if (X < 0.0)
			X += Constants.rDegMax;
		context.cp0.cusp[1] = context.is.Asc;
		Y = X / 3.0;
		for (i = 1; i <= 3; i++)
			context.cp0.cusp[i + 1] = GeneralProcedures.Mod(context.is.Asc + i * Y);
		for (i = 1; i <= 6; i++)
			context.cp0.cusp[i + 6] = GeneralProcedures.Mod(context.cp0.cusp[i] + Constants.rDegHalf);
	}

	public void HouseMorinus() {
		double D, X;
		int i;

		for (i = 1; i <= Constants.cSign; i++) {
			D = Macro.RFromD(60.0 + 30.0 * (double) i);
			X = GeneralProcedures.Angle(Macro.RCos(context.is.RA + D),
					Macro.RSin(context.is.RA + D) * Macro.RCos(context.is.OB));
			context.cp0.cusp[i] = GeneralProcedures.Mod(Macro.DFromR(X) + context.is.rSid);
		}
	}

	double CuspTopocentric(double deg) {
		double OA, X, LO;

		OA = GeneralProcedures.ModRad(context.is.RA + Macro.RFromD(deg));
		X = Macro.RAtn(Macro.RTan(context.ciCore.lat) / Macro.RCos(OA));
		LO = Macro.RAtn(Macro.RCos(X) * Macro.RTan(OA) / Macro.RCos(X + context.is.OB));
		if (LO < 0.0)
			LO += Constants.rPi;
		if (Macro.RSin(OA) < 0.0)
			LO += Constants.rPi;
		return LO;
	}

	public void HouseTopocentric() {
		double TL, P1, P2, LT;
		int i;

		context.cp0.cusp[4] = GeneralProcedures
				.ModRad(Macro.RFromD(context.is.MC + Constants.rDegHalf - context.is.rSid));
		TL = Macro.RTan(context.ciCore.lat);
		P1 = Macro.RAtn(TL / 3.0);
		P2 = Macro.RAtn(TL / 1.5);
		LT = context.ciCore.lat;
		context.ciCore.lat = P1;
		context.cp0.cusp[5] = CuspTopocentric(30.0) + Constants.rPi;
		context.ciCore.lat = P2;
		context.cp0.cusp[6] = CuspTopocentric(60.0) + Constants.rPi;
		context.ciCore.lat = LT;
		context.cp0.cusp[1] = CuspTopocentric(90.0);
		context.ciCore.lat = P2;
		context.cp0.cusp[2] = CuspTopocentric(120.0);
		context.ciCore.lat = P1;
		context.cp0.cusp[3] = CuspTopocentric(150.0);
		context.ciCore.lat = LT;
		for (i = 1; i <= 6; i++) {
			context.cp0.cusp[i] = GeneralProcedures.Mod(Macro.DFromR(context.cp0.cusp[i]) + context.is.rSid);
			context.cp0.cusp[i + 6] = GeneralProcedures.Mod(context.cp0.cusp[i] + Constants.rDegHalf);
		}
	}

	/* These are various different algorithms for calculating the house cusps: */

	public double CuspPlacidus(double deg, double FF, Flag fNeg) {
		double LO, R1, XS, X;
		int i;

		R1 = context.is.RA + Macro.RFromD(deg);
		X = fNeg.toBoolean() ? 1.0 : -1.0;
		/* Looping 10 times is arbitrary, but it's what other programs do. */
		for (i = 1; i <= 10; i++) {

			/* This formula works except at 0 latitude (AA == 0.0). */

			XS = X * Macro.RSin(R1) * Macro.RTan(context.is.OB)
					* Macro.RTan(context.ciCore.lat == 0.0 ? 0.0001 : context.ciCore.lat);
			XS = Macro.RAcos(XS);
			if (XS < 0.0)
				XS += Constants.rPi;
			R1 = context.is.RA + (fNeg.toBoolean() ? Constants.rPi - (XS / FF) : (XS / FF));
		}
		LO = Macro.RAtn(Macro.RTan(R1) / Macro.RCos(context.is.OB));
		if (LO < 0.0)
			LO += Constants.rPi;
		if (Macro.RSin(R1) < 0.0)
			LO += Constants.rPi;
		return Macro.DFromR(LO);
	}

	/* The following three functions calculate the Midheaven, Ascendant, and */
	/* East Point of the chart in question, based on time and location. The */
	/* first two are also used in some of the house cusp calculation routines */
	/* as a quick way to get the 10th and 1st cusps. The East Point object is */
	/* technically defined as the Ascendant's position at zero latitude. */

	public double CuspMidheaven() {
		double MC;

		MC = Macro.RAtn(Macro.RTan(context.is.RA) / Macro.RCos(context.is.OB));
		if (MC < 0.0)
			MC += Constants.rPi;
		if (context.is.RA > Constants.rPi)
			MC += Constants.rPi;
		return GeneralProcedures.Mod(Macro.DFromR(MC) + context.is.rSid);
	}

	public double CuspAscendant() {
		double Asc;

		Asc = GeneralProcedures.Angle(-Macro.RSin(context.is.RA) * Macro.RCos(context.is.OB)
				- Macro.RTan(context.ciCore.lat) * Macro.RSin(context.is.OB), Macro.RCos(context.is.RA));
		return GeneralProcedures.Mod(Macro.DFromR(Asc) + context.is.rSid);
	}

	public double CuspEastPoint() {
		double EP;

		EP = GeneralProcedures.Angle(-Macro.RSin(context.is.RA) * Macro.RCos(context.is.OB), Macro.RCos(context.is.RA));
		return GeneralProcedures.Mod(Macro.DFromR(EP) + context.is.rSid);
	}

	/* Convert polar to rectangular coordinates. */

	void PolToRec(double a, double r, RefVariant x, RefVariant y) {
		// if (a == 0.0)
		if (Macro.RAbs(a) < Constants.rSmall) {
			a = Constants.rSmall;
		}
		x.from(r * Macro.RCos(a));
		y.from(r * Macro.RSin(a));
	}

	/* Convert rectangular to polar coordinates. */

	void RecToPol(double x, double y, RefVariant a, RefVariant r) {
		// if (y == 0.0)
		if (Macro.RAbs(y) < Constants.rSmall) {
			y = Constants.rSmall;
		}
		r.from(Macro.RSqr(x * x + y * y));
		a.from(GeneralProcedures.Angle(x, y));
	}

	/* Another coordinate transformation. This is used by the ComputePlanets() */
	/* procedure to rotate rectangular coordinates by a certain amount. */

	void RecToSph2(double AP, double AN, double _IN, RefVariant X, RefVariant Y, RefVariant G) {
		RefVariant R = new RefVariant();
		RefVariant D = new RefVariant();
		RefVariant A = new RefVariant();

		RecToPol(X.toDouble(), Y.toDouble(), A, R);
		A.from(A.toDouble() + AP);
		PolToRec(A.toDouble(), R.toDouble(), X, Y);
		D.from(X.toDouble());
		X.from(Y.toDouble());
		Y.from(0.0);
		RecToPol(X.toDouble(), Y.toDouble(), A, R);
		A.from(A.toDouble() + _IN);
		PolToRec(A.toDouble(), R.toDouble(), X, Y);
		G.from(Y.toDouble());
		Y.from(X.toDouble());
		X.from(D.toDouble());
		RecToPol(X.toDouble(), Y.toDouble(), A, R);
		A.from(A.toDouble() + AN);
		if (A.toDouble() < 0.0)
			A.from(A.toDouble() + 2.0 * Constants.rPi);
		PolToRec(A.toDouble(), R.toDouble(), X, Y);
	}

	/* Calculate some harmonic delta error correction factors to add onto the */
	/* coordinates of Jupiter through Pluto, for better accuracy. */

	void ErrorCorrect(int ind, RefVariant x, RefVariant y, RefVariant z) {
		double U, V, W, A, S0;
		double[] T0 = new double[4];
		int pr;
		int IK, IJ, irError;

		irError = ObjectCalculationTables.cErrorCount[ind - Constants.oJup];

		pr = ObjectCalculationTables.iErrorOffset[ind - Constants.oJup];

		for (IK = 1; IK <= 3; IK++) {
			if (ind == Constants.oJup && IK == 3) {
				T0[3] = 0.0;
				break;
			}
			if (IK == 3)
				irError--;
			S0 = ReadThree(ObjectCalculationTables.rErrorData[pr], ObjectCalculationTables.rErrorData[pr + 1],
					ObjectCalculationTables.rErrorData[pr + 2]);
			pr += 3;
			A = 0.0;
			for (IJ = 1; IJ <= irError; IJ++) {
				U = ObjectCalculationTables.rErrorData[pr++];
				V = ObjectCalculationTables.rErrorData[pr++];
				W = ObjectCalculationTables.rErrorData[pr++];
				A += Macro.RFromD(U) * Macro.RCos((V * context.is.T + W) * Constants.rPi / Constants.rDegHalf);
			}
			T0[IK] = Macro.DFromR(S0 + A);
		}
		x.from(x.toDouble() + T0[2]);
		y.from(y.toDouble() + T0[1]);
		z.from(z.toDouble() + T0[3]);
	}

	/* This is probably the heart of the whole program of Astrolog. Calculate */
	/* the position of each body that orbits the Sun. A heliocentric chart is */
	/* most natural; extra calculation is needed to have other central bodies. */

	public void ComputePlanets() {
		double[] helioret = new double[Constants.oNorm + 1];
		double[] heliox = new double[Constants.oNorm + 1];
		double[] helioy = new double[Constants.oNorm + 1];
		double[] helioz = new double[Constants.oNorm + 1];
		double aber = 0.0;
		double AU, E, EA, E1, M, XW, YW, AP, AN, _IN;
		RefVariant X = new RefVariant();
		RefVariant Y = new RefVariant();
		RefVariant G = new RefVariant();
		RefVariant XS = new RefVariant();
		RefVariant YS = new RefVariant();
		RefVariant ZS = new RefVariant();

		RefVariant ind = new RefVariant(Constants.oSun);
		int i;
		ObjectCalculationTables.OE poe;

		while (ind.toInteger() <= (context.us.fUranian.toBoolean() ? Constants.oNorm : Constants.cPlanet)) {
			if (context.ignore[ind.toInteger()] != 0 && ind.toInteger() > Constants.oSun) {
				LNextPlanet(ind);
			} else {
				poe = ObjectCalculationTables.rgoe[IoeFromObj(ind.toInteger())];

				EA = M = GeneralProcedures.ModRad(ReadThree(poe.ma0, poe.ma1, poe.ma2));
				E = Macro.DFromR(ReadThree(poe.ec0, poe.ec1, poe.ec2));
				for (i = 1; i <= 5; i++)
					EA = M + E * Macro.RSin(EA); /* Solve Kepler's equation */
				AU = poe.sma; /* Semi-major axis */
				E1 = 0.01720209 / (Math.pow(AU, 1.5) * (1.0 - E * Macro.RCos(EA))); /* Begin velocity coordinates */
				XW = -AU * E1 * Macro.RSin(EA); /* Perifocal coordinates */
				YW = AU * E1 * Math.pow(1.0 - E * E, 0.5) * Macro.RCos(EA);
				AP = ReadThree(poe.ap0, poe.ap1, poe.ap2);
				AN = ReadThree(poe.an0, poe.an1, poe.an2);
				_IN = ReadThree(poe.in0, poe.in1, poe.in2); /* Calculate inclination */
				X.from(XW);
				Y.from(YW);

				RecToSph2(AP, AN, _IN, X, Y, G); /* Rotate velocity coords */
				heliox[ind.toInteger()] = X.toDouble();
				helioy[ind.toInteger()] = Y.toDouble();
				helioz[ind.toInteger()] = G.toDouble(); /* Helio ecliptic rectangular */
				X.from(AU * (Macro.RCos(EA) - E)); /* Perifocal coordinates for */
				Y.from(AU * Macro.RSin(EA) * Math.pow(1.0 - E * E, 0.5)); /* rectangular position coordinates */
				RecToSph2(AP, AN, _IN, X, Y, G); /* Rotate for rectangular */
				XS.from(X.toDouble());
				YS.from(Y.toDouble());
				ZS.from(G.toDouble()); /* position coordinates */
				if (Macro.FBetween(ind.toInteger(), Constants.oJup, Constants.oPlu)) {
					ErrorCorrect(ind.toInteger(), XS, YS, ZS);
				}
				context.ret[ind.toInteger()] = Macro.DFromR((XS.toDouble() * helioy[ind.toInteger()]
						- YS.toDouble() * heliox[ind.toInteger()])
						/ (XS.toDouble() * XS.toDouble() + YS.toDouble() * YS.toDouble())); /* Helio daily motion */
				context.spacex[ind.toInteger()] = XS.toDouble();
				context.spacey[ind.toInteger()] = YS.toDouble();
				context.spacez[ind.toInteger()] = ZS.toDouble();
				ProcessPlanet(ind.toInteger(), 0.0);
				LNextPlanet(ind);
			}
		}

		context.spacex[Constants.oEar] = context.spacex[Constants.oSun];
		context.spacey[Constants.oEar] = context.spacey[Constants.oSun];
		context.spacez[Constants.oEar] = context.spacez[Constants.oSun];
		context.planet[Constants.oEar] = context.planet[Constants.oSun];
		context.planetalt[Constants.oEar] = context.planetalt[Constants.oSun];
		context.ret[Constants.oEar] = context.ret[Constants.oSun];
		heliox[Constants.oEar] = heliox[Constants.oSun];
		helioy[Constants.oEar] = helioy[Constants.oSun];
		helioret[Constants.oEar] = helioret[Constants.oSun] = Macro.RFromD(1.0);
		context.spacex[Constants.oSun] = context.spacey[Constants.oSun] = context.spacez[Constants.oSun] = context.planet[Constants.oSun] = context.planetalt[Constants.oSun] = heliox[Constants.oSun] = helioy[Constants.oSun] = 0.0;
		if (context.us.objCenter == Constants.oSun) {
			if (context.us.fVelocity.toBoolean())
				for (i = 0; i <= Constants.oNorm; i++) /* Use relative velocity */
					context.ret[i] = 1.0; /* if -v0 is in effect. */
			return;
		}

		/* A second loop is needed for geocentric charts or central bodies other */
		/* than the Sun. For example, we can't find the position of Mercury in */
		/* relation to Pluto until we know the position of Pluto in relation to */
		/* the Sun, and since Mercury is calculated first, another pass needed. */

		ind.from(context.us.objCenter);
		for (i = 0; i <= Constants.oNorm; i++) {
			helioret[i] = context.ret[i];
			if (i != Constants.oMoo && i != ind.toInteger()) {
				context.spacex[i] -= context.spacex[ind.toInteger()];
				context.spacey[i] -= context.spacey[ind.toInteger()];
				context.spacez[i] -= context.spacez[ind.toInteger()];
			}
		}
		for (i = Constants.oEar; i <= (context.us.fUranian.toBoolean() ? Constants.oNorm
				: Constants.cPlanet); i += (i == Constants.oSun ? 2
						: (i != Constants.cPlanet ? 1 : Constants.uranLo + 1 - Constants.cPlanet))) {
			if ((0 != context.ignore[i] && i > Constants.oSun) || i == ind.toInteger()) {
				continue;
			}
			XS.from(context.spacex[i]);
			YS.from(context.spacey[i]);
			ZS.from(context.spacez[i]);

			context.ret[i] = Macro.DFromR((XS.toDouble() * (helioy[i] - helioy[ind.toInteger()])
					- YS.toDouble() * (heliox[i] - heliox[ind.toInteger()]))
					/ (XS.toDouble() * XS.toDouble() + YS.toDouble() * YS.toDouble()));
			if (ind.toInteger() == Constants.oEar && !context.us.fTruePos.toBoolean()) {
				aber = 0.0057756 * Macro.RSqr(
						XS.toDouble() * XS.toDouble() + YS.toDouble() * YS.toDouble() + ZS.toDouble() * ZS.toDouble())
						* context.ret[i]; /* Aberration */
			}
			ProcessPlanet(i, aber);
			if (context.us.fVelocity.toBoolean()) /* Use relative velocity */
				context.ret[i] = context.ret[i] / helioret[i]; /* if -v0 is in effect */
		}
		context.spacex[ind.toInteger()] = context.spacey[ind.toInteger()] = context.spacez[ind.toInteger()] = 0.0;
	}

	/* Another subprocedure of the ComputeEphem() routine. Convert the final */
	/* rectangular coordinates of a planet to zodiac position and declination. */
	public void ProcessPlanet(int ind, double aber) {
		double ang, rad;
		PolarCoorF pc = null;

		pc = new RectCoorF(context.spacex[ind], context.spacey[ind]).toPolarCoorF();
		ang = pc.getA();
		rad = pc.getR();
		context.planet[ind] = GeneralProcedures.Mod(Macro.DFromR(ang) - aber + context.is.rSid);
		pc = new RectCoorF(rad, context.spacez[ind]).toPolarCoorF();
		ang = pc.getA();
		rad = pc.getR();
		if (context.us.objCenter == Constants.oSun && ind == Constants.oSun)
			ang = 0.0;
		ang = Macro.DFromR(ang);
		while (ang > Constants.rDegQuad) /* Ensure declination is from -90..+90 degrees. */
			ang -= Constants.rDegHalf;
		while (ang < -Constants.rDegQuad)
			ang += Constants.rDegHalf;
		context.planetalt[ind] = ang;
	}

	public static void LNextPlanet(RefVariant rind) {
		rind.from(rind.toInteger() + (rind.toInteger() == Constants.oSun ? 2
				: (rind.toInteger() != Constants.cPlanet ? 1 : Constants.uranLo + 1 - Constants.cPlanet)));
	}

	/*
	 ******************************************************************************
	 ** Lunar Position Calculations
	 ******************************************************************************
	 */

	/* Calculate the position and declination of the Moon, and the Moon's North */
	/* Node. This has to be done separately from the other planets, because they */
	/* all orbit the Sun, while the Moon orbits the Earth. */

	public void ComputeLunar(RefVariant moonlo, RefVariant moonla, RefVariant nodelo, RefVariant nodela) {
		double LL, G, N, G1, D, L, ML, L1, MB, T1, Y, M = 3600.0, T2;

		T2 = context.is.T * context.is.T;
		LL = 973563.0 + 1732564379.0 * context.is.T - 4.0 * T2; /* Compute mean lunar longitude */
		G = 1012395.0 + 6189.0 * context.is.T; /* Sun's mean longitude of perigee */
		N = 933060.0 - 6962911.0 * context.is.T + 7.5 * T2; /* Compute mean lunar node */
		G1 = 1203586.0 + 14648523.0 * context.is.T - 37.0 * T2; /* Mean longitude of lunar perigee */
		D = 1262655.0 + 1602961611.0 * context.is.T - 5.0 * T2; /* Mean elongation of Moo from Sun */
		L = (LL - G1) / M;
		L1 = ((LL - D) - G) / M; /* Some auxiliary angles */
		T1 = (LL - N) / M;
		D = D / M;
		Y = 2.0 * D;

		/* Compute Moon's perturbations. */

		ML = 22639.6 * Macro.RSinD(L) - 4586.4 * Macro.RSinD(L - Y) + 2369.9 * Macro.RSinD(Y)
				+ 769.0 * Macro.RSinD(2.0 * L) - 669.0 * Macro.RSinD(L1) - 411.6 * Macro.RSinD(2.0 * T1)
				- 212.0 * Macro.RSinD(2.0 * L - Y) - 206.0 * Macro.RSinD(L + L1 - Y);
		ML += 192.0 * Macro.RSinD(L + Y) - 165.0 * Macro.RSinD(L1 - Y) + 148.0 * Macro.RSinD(L - L1)
				- 125.0 * Macro.RSinD(D) - 110.0 * Macro.RSinD(L + L1) - 55.0 * Macro.RSinD(2.0 * T1 - Y)
				- 45.0 * Macro.RSinD(L + 2.0 * T1) + 40.0 * Macro.RSinD(L - 2.0 * T1);

		moonlo.from(G = GeneralProcedures.Mod((LL + ML) / M + context.is.rSid)); /* Lunar longitude */

		/* Compute lunar latitude. */

		MB = 18461.5 * Macro.RSinD(T1) + 1010.0 * Macro.RSinD(L + T1) - 999.0 * Macro.RSinD(T1 - L)
				- 624.0 * Macro.RSinD(T1 - Y) + 199.0 * Macro.RSinD(T1 + Y - L) - 167.0 * Macro.RSinD(L + T1 - Y);
		MB += 117.0 * Macro.RSinD(T1 + Y) + 62.0 * Macro.RSinD(2.0 * L + T1) - 33.0 * Macro.RSinD(T1 - Y - L)
				- 32.0 * Macro.RSinD(T1 - 2.0 * L) - 30.0 * Macro.RSinD(L1 + T1 - Y);
		moonla.from(MB = GeneralProcedures.RSgn(MB)
				* ((Math.abs(MB) / M) / Constants.rDegMax - Math.floor((Math.abs(MB) / M) / Constants.rDegMax))
				* Constants.rDegMax);

		/* Compute position of the North Lunar Node, either True or Mean. */

		if (context.us.fTrueNode.toBoolean())
			N = N + 5392.0 * Macro.RSinD(2.0 * T1 - Y) - 541.0 * Macro.RSinD(L1) - 442.0 * Macro.RSinD(Y)
					+ 423.0 * Macro.RSinD(2.0 * T1) - 291.0 * Macro.RSinD(2.0 * L - 2.0 * T1);
		nodelo.from(GeneralProcedures.Mod(N / M + context.is.rSid));
		nodela.from(0.0);
	}
}

