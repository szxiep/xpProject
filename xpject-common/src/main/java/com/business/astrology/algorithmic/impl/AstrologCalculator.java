package com.business.astrology.algorithmic.impl;

import com.business.astrology.algorithmic.AstrologFeatures;
import com.business.astrology.algorithmic.api.IAstrologCalculator;
import com.business.astrology.algorithmic.api.INatal;
import com.business.astrology.algorithmic.bean.CI;
import com.business.astrology.algorithmic.bean.Flag;
import com.business.astrology.algorithmic.bean.Natal;
import com.business.astrology.algorithmic.bean.PolarCoor3dF;
import com.business.astrology.algorithmic.bean.PolarCoorF;
import com.business.astrology.algorithmic.bean.Profile;
import com.business.astrology.algorithmic.bean.RectCoor3dF;
import com.business.astrology.algorithmic.bean.RectCoorF;
import com.business.astrology.algorithmic.bean.RefVariant;
import com.business.astrology.algorithmic.table.GlobalTables;
import com.business.astrology.algorithmic.table.ObjectCalculationTables;
import com.business.astrology.algorithmic.utils.AstrologyProcedures;
import com.business.astrology.algorithmic.utils.Constants;
import com.business.astrology.algorithmic.utils.GeneralProcedures;
import com.business.astrology.algorithmic.utils.Macro;
import com.business.astrology.algorithmic.utils.MatrixEphemeris;

public class AstrologCalculator extends AstrologContext implements IAstrologCalculator {

	public AstrologCalculator(Profile profile, CI ciCore) {
		this.profile = profile;
		this.ciCore = ciCore;
		this.us = profile;
		this.fDate = Flag.TRUE;// TODO:
		this.ap = new AstrologyProcedures();
		this.matrix = new MatrixEphemeris(this);
	}

	@Override
	public INatal calc() {
		double[] housetemp = new double[Constants.cSign + 1];
		double j;
		RefVariant Off = new RefVariant();
		RefVariant vtx = new RefVariant();
		RefVariant ep = new RefVariant();

		int i, k, k2;

		if (ciCore.zon == 24.0) {
			ciCore.zon = ciCore.lon / 15.0;
		}
		if (ciCore.dst == 24.0) {
			ciCore.dst = is.fDst.toDouble();
		}
		CI ci = new CI(ciCore);

		if (ciCore.mon == -1) {
			/* Hack: If month is negative, then know chart was read in through a */
			/* -o0 position file, so planet positions are already in the arrays. */
			is.MC = planet[Constants.oMC];
			is.Asc = planet[Constants.oAsc];
		} else {
			cp0.clear(); /* On ecliptic unless we say so. */
			// ClearB((lpbyte)spacex, (oNorm+1)*sizeof(real));
			// ClearB((lpbyte)spacey, (oNorm+1)*sizeof(real));
			// ClearB((lpbyte)spacez, (oNorm+1)*sizeof(real));
			Off.from(ProcessInput(fDate));
			if (AstrologFeatures.MATRIX) {
				ComputeVariables(vtx);
				if (us.fGeodetic.toBoolean()) {/* Check for -G geodetic chart. */
					is.RA = Macro.RFromD(GeneralProcedures.Mod(-ciCore.lon));
				}
				is.MC = matrix.CuspMidheaven(); /* Calculate Ascendant & Midheaven. */
				is.Asc = matrix.CuspAscendant();
				ep.from(matrix.CuspEastPoint());
				ComputeHouses(us.nHouseSystem); /* Go calculate house cusps. */
			}

			/* Go calculate planet, Moon, and North Node positions. */
			if (AstrologFeatures.MATRIX && us.fMatrixPla.toBoolean()
					&& (!us.fEphemFiles.toBoolean() || (us.fPlacalcPla.toBoolean() && us.fUranian.toBoolean()))) {
				matrix.ComputePlanets();
				if (0 == ignore[Constants.oMoo] || 0 == ignore[Constants.oNod] || 0 == ignore[Constants.oSou]
						|| 0 == ignore[Constants.oFor]) {
					RefVariant objMoo = new RefVariant();
					RefVariant altMoo = new RefVariant();
					RefVariant objNod = new RefVariant();
					RefVariant altNod = new RefVariant();
					matrix.ComputeLunar(objMoo, altMoo, objNod, altNod);
					planet[Constants.oMoo] = objMoo.toDouble();
					planetalt[Constants.oMoo] = altMoo.toDouble();
					planet[Constants.oNod] = objNod.toDouble();
					planetalt[Constants.oNod] = altNod.toDouble();
					ret[Constants.oNod] = -1.0;
				}
			}

			/* Compute more accurate ephemeris positions for certain objects. */
			if (AstrologFeatures.EPHEM && us.fEphemFiles.toBoolean()) {
				ComputeEphem(is.T);
			}

			/* Certain objects are positioned directly opposite to other objects. */
			i = us.objCenter == Constants.oEar ? Constants.oSun : Constants.oEar;
			planet[us.objCenter] = GeneralProcedures.Mod(planet[i] + Constants.rDegHalf);
			planetalt[us.objCenter] = -planetalt[i];
			ret[us.objCenter] = ret[i];
			planet[Constants.oSou] = GeneralProcedures.Mod(planet[Constants.oNod] + Constants.rDegHalf);
			if (Flag.FALSE == us.fEphemFiles) {
				if (Flag.FALSE == us.fVelocity) {
					ret[Constants.oNod] = ret[Constants.oSou] = -0.053;
					ret[Constants.oMoo] = 12.2;
				} else
					ret[Constants.oNod] = ret[Constants.oSou] = ret[Constants.oMoo] = 1.0;
			}

			/* Calculate position of Part of Fortune. */
			j = planet[Constants.oMoo] - planet[Constants.oSun];
			if (us.nArabicNight < 0 || (us.nArabicNight == 0
					&& HousePlaceIn(planet[Constants.oSun], planetalt[Constants.oSun]) < Constants.sLib))
				j = -j;
			j = Macro.RAbs(j) < Constants.rDegQuad ? j : j - GeneralProcedures.RSgn(j) * Constants.rDegMax;
			planet[Constants.oFor] = GeneralProcedures.Mod(j + is.Asc);

			/* Fill in "planet" positions corresponding to house cusps. */
			planet[Constants.oVtx] = vtx.toDouble();
			planet[Constants.oEP] = ep.toDouble();
			for (i = 1; i <= Constants.cSign; i++)
				planet[Constants.cuspLo + i - 1] = chouse[i];
			if (Flag.FALSE == us.fHouseAngle) {
				planet[Constants.oAsc] = is.Asc;
				planet[Constants.oMC] = is.MC;
				planet[Constants.oDes] = GeneralProcedures.Mod(is.Asc + Constants.rDegHalf);
				planet[Constants.oNad] = GeneralProcedures.Mod(is.MC + Constants.rDegHalf);
			}
			for (i = Constants.oFor; i <= Constants.cuspHi; i++)
				ret[i] = Constants.rDegMax;
		}

		/* Go calculate star positions if -U switch in effect. */
		if (0 != us.nStar) {
			ComputeStars((us.fSidereal.toBoolean() ? 0.0 : -Off.toDouble()) + us.rZodiacOffset);
		}

		/* Transform ecliptic to equatorial coordinates if -sr in effect. */
		if (us.fEquator.toBoolean()) {
			for (i = 0; i <= Constants.cObj; i++)
				if (0 == ignore[i]) {
					planet[i] = Macro.RFromD(matrix.Tropical(planet[i]));
					planetalt[i] = Macro.RFromD(planetalt[i]);
					RefVariant obj = new RefVariant(planet[i]);
					RefVariant alt = new RefVariant(planetalt[i]);
					matrix.EclToEqu(obj, alt);
					planet[i] = obj.toDouble();
					planetalt[i] = alt.toDouble();
					planet[i] = Macro.DFromR(planet[i]);
					planetalt[i] = Macro.DFromR(planetalt[i]);
				}
		}

		/* Now, we may have to modify the base positions we calculated above */
		/* based on what type of chart we are generating. */
		if (us.fProgress.toBoolean() && us.fSolarArc.toBoolean()) { /* Are we doing -p0 solar arc chart? */
			j = (is.JDp - Macro.JulianDayFromTime(is.T) - 0.5) / us.rProgDay;
			for (i = 0; i <= Constants.cObj; i++)
				planet[i] = GeneralProcedures.Mod(planet[i] + j);
			for (i = 1; i <= Constants.cSign; i++)
				cp0.cusp[i] = GeneralProcedures.Mod(cp0.cusp[i] + j);
		}
		if (us.rHarmonic != 1.0) { /* Are we doing a -x harmonic chart? */
			for (i = 0; i <= Constants.cObj; i++)
				planet[i] = GeneralProcedures.Mod(planet[i] * us.rHarmonic);
		}

		/* If -Y1 chart rotation in effect, then rotate the planets accordingly. */
		if (us.objRot1 != us.objRot2 || us.fObjRotWhole.toBoolean()) {
			j = planet[us.objRot2];
			if (us.fObjRotWhole.toBoolean())
				j = (double) ((Macro.SFromZ(j) - 1) * 30);
			j -= planet[us.objRot1];
			for (i = 0; i <= Constants.cObj; i++)
				planet[i] = GeneralProcedures.Mod(planet[i] + j);
		}

		/* If -1 or -2 solar chart in effect, then rotate the houses accordingly. */
		if (0 != us.objOnAsc) {
			j = planet[Math.abs(us.objOnAsc) - 1];
			if (us.fSolarWhole.toBoolean())
				j = (double) ((Macro.SFromZ(j) - 1) * 30);
			j -= (us.objOnAsc > 0 ? is.Asc : is.MC);
			for (i = 1; i <= Constants.cSign; i++)
				cp0.cusp[i] = GeneralProcedures.Mod(cp0.cusp[i] + j + Constants.rSmall);
		}

		/* Check to see if we are -F forcing any objects to be particular values. */
		for (i = 0; i <= Constants.cObj; i++) {
			if (force[i] != 0.0) {
				if (force[i] > 0) {
					planet[i] = force[i] - Constants.rDegMax;
					planetalt[i] = ret[i] = 0.0;
				} else {
					k = (-(int) force[i]) - 1;
					k2 = k % Constants.cObj;
					k /= Constants.cObj;
					planet[i] = AstrologyProcedures.Midpoint(planet[k], planet[k2]);
					planetalt[i] = (planetalt[k] + planetalt[k2]) / 2.0;
					ret[i] = (ret[k] + ret[k2]) / 2.0;
				}
			}
		}

		/* If -f domal chart switch in effect, switch planet and house positions. */
		if (us.fFlip.toBoolean()) {
			ComputeInHouses();
			for (i = 0; i <= Constants.cObj; i++) {
				k = inhouse[i];
				inhouse[i] = Macro.SFromZ(planet[i]);
				planet[i] = Macro.ZFromS(k) + AstrologyProcedures.MinDistance(chouse[k], planet[i])
						/ AstrologyProcedures.MinDistance(chouse[k], chouse[AstrologyProcedures.Mod12(k + 1)]) * 30.0;
			}
			for (i = 1; i <= Constants.cSign; i++) {
				k = HousePlaceIn2D(Macro.ZFromS(i));
				housetemp[i] = Macro.ZFromS(k) + AstrologyProcedures.MinDistance(chouse[k], Macro.ZFromS(i))
						/ AstrologyProcedures.MinDistance(chouse[k], chouse[AstrologyProcedures.Mod12(k + 1)]) * 30.0;
			}
			for (i = 1; i <= Constants.cSign; i++)
				chouse[i] = housetemp[i];
		}

		/* If -3 decan chart switch in effect, edit planet positions accordingly. */
		if (us.fDecan.toBoolean()) {
			for (i = 0; i <= Constants.cObj; i++)
				planet[i] = Decan(planet[i]);
		}

		/* If -9 navamsa chart switch in effect, edit positions accordingly. */
		if (us.fNavamsa.toBoolean()) {
			for (i = 0; i <= Constants.cObj; i++)
				planet[i] = Navamsa(planet[i]);
		}

		ComputeInHouses(); /* Figure out what house everything falls in. */
		ciCore = ci;
		return new Natal(cp0);
	}

	/* Wrappers around Swiss ephemeris Julian Day conversion routines. */

	private double swissJulDay(int month, int day, int year, double hour, int gregflag) {
		return swe_julday(year, month, day, hour, gregflag);
	}

	private double swe_julday(int year, int month, int day, double hour, int gregflag) {
		double jd;
		double u, u0, u1, u2;
		u = year;
		if (month < 3)
			u -= 1;
		u0 = u + 4712.0;
		u1 = month + 1.0;
		if (u1 < 4)
			u1 += 12.0;
		jd = Math.floor(u0 * 365.25) + Math.floor(30.6 * u1 + 0.000001) + day + hour / 24.0 - 63.5;
		if (gregflag == 1) {
			u2 = Math.floor(Math.abs(u) / 100) - Math.floor(Math.abs(u) / 400);
			if (u < 0.0)
				u2 = -u2;
			jd = jd - u2 + 2;
			if ((u < 0.0) && (u / 100 == Math.floor(u / 100)) && (u / 400 != Math.floor(u / 400)))
				jd -= 1;
		}
		return jd;
	}

	private double julday(int month, int day, int year, double hour, int gregflag) {
		double jd, u, u0, u1, u2;

		u = year;
		if (month < 3)
			u -= 1;
		u0 = u + 4712.0;
		u1 = month + 1.0;
		if (u1 < 4)
			u1 += 12.0;
		jd = Math.floor(u0 * 365.25) + Math.floor(30.6 * u1 + 0.000001) + day + hour / 24.0 - 63.5;
		if (gregflag != 0) {
			u2 = Math.floor(Math.abs(u) / 100) - Math.floor(Math.abs(u) / 400);
			if (u < 0.0)
				u2 = -u2;
			jd = jd - u2 + 2;
			if ((u < 0.0) && (u / 100 == Math.floor(u / 100)) && (u / 400 != Math.floor(u / 400)))
				jd -= 1;
		}
		return jd;
	}

	/* Given a month, day, and year, convert it into a single Julian day value, */
	/* i.e. the number of days passed since a fixed reference date. */

	long MdyToJulian(int mon, int day, int yea) {
		if (AstrologFeatures.MATRIX && !us.fEphemFiles.toBoolean()) {
			long im, j;

			im = 12 * ((long) yea + 4800) + (long) mon - 3;
			j = (2 * (im % 12) + 7 + 365 * im) / 12;
			j += (long) day + im / 48 - 32083;
			if (j > 2299171) /* Take care of dates in */
				j += im / 4800 - im / 1200 + 38; /* Gregorian calendar. */
			return j;
		}

		Flag fGreg = Flag.TRUE;
		double jd;

		if (yea < Constants.yeaJ2G
				|| (yea == Constants.yeaJ2G && (mon < Constants.monJ2G || (mon == Constants.monJ2G && day < 15)))) {
			fGreg = Flag.FALSE;
		}

		jd = !us.fPlacalcPla.toBoolean() ? (swissJulDay(mon, day, yea, 12.0, fGreg.toInt()) + Constants.rRound)
				: (julday(mon, day, yea, 12.0, fGreg.toInt()) + Constants.rRound);

		return (long) Math.floor(jd);
	}

	/* Determine the sign of a number: -1 if value negative, +1 if value */
	/* positive, and 0 if it's zero. */
	private double rSgn(double r) {
		return r == 0.0d ? 0.0d : Macro.RSgn2(r);
	}

	/* This is a subprocedure of CastChart(). Once we have the chart parameters */
	/* calculate a few important things related to the date, i.e. the Greenwich */
	/* time, the Julian day and fractional part of the day, the offset to the */
	/* sidereal, and a couple of other things. */
	public double ProcessInput(Flag fDate) {
		ciCore.tim = rSgn(ciCore.tim) * Math.floor(Math.abs(ciCore.tim)) + Macro.RFract(Math.abs(ciCore.tim))
				+ (ciCore.zon - ciCore.dst);
		ciCore.lat = Math.min(ciCore.lat,
				Constants.rDegQuad - Constants.rSmall); /* Make sure the chart isn't being cast */
		ciCore.lat = Math.max(ciCore.lat,
				-(Constants.rDegQuad - Constants.rSmall)); /* on the precise North or South Pole. */
		ciCore.lat = Macro.RFromD(ciCore.lat);

		/* if parameter 'fDate' isn't set, then we can assume that the true time */
		/* has already been determined (as in a -rm switch time midpoint chart). */

		if (fDate.toBoolean()) {
			is.JD = (double) MdyToJulian(ciCore.mon, ciCore.day, ciCore.yea);
			is.T = (is.JD + ciCore.tim / 24.0);
			if (us.fProgress.toBoolean() && !us.fSolarArc.toBoolean()) {
				/* Determine actual time that a progressed chart is to be cast for. */
				is.T += ((is.JDp - is.T) / us.rProgDay);
			}
			is.T = (is.T - 2415020.5) / 36525.0;
		}

		if (AstrologFeatures.MATRIX && !(us.fEphemFiles.toBoolean() && !us.fPlacalcPla.toBoolean())) {
			double Ln, Off;

			/* Compute angle that the ecliptic is inclined to the Celestial Equator */
			is.OB = Macro.RFromD(23.452294 - 0.0130125 * is.T);

			Ln = GeneralProcedures.Mod((933060 - 6962911 * is.T + 7.5 * is.T * is.T) / 3600.0); /* Mean lunar node */
			Off = (259205536.0 * is.T + 2013816.0) / 3600.0; /* Mean Sun */
			Off = 17.23 * Math.sin(Macro.RFromD(Ln)) + 1.27 * Math.sin(Macro.RFromD(Off))
					- (5025.64 + 1.11 * is.T) * is.T;
			Off = (Off - 84038.27) / 3600.0;
			is.rSid = (us.fSidereal.toBoolean() ? Off : 0.0) + us.rZodiacOffset;
			return Off;
		}
		return 0.0;
	}

	/* This is another subprocedure of CastChart(). Calculate a few variables */
	/* corresponding to the chart parameters that are used later on. The */
	/* astrological vertex (object number 20) is also calculated here. */
	protected void ComputeVariables(RefVariant vtx) {
		double B, L, G, tim = ciCore.tim;

		if (us.fProgress.toBoolean() && !us.fSolarArc.toBoolean()) {
			tim = Macro.JulianDayFromTime(is.T) + 0.5;
			tim = Macro.RFract(tim) * 24.0;
		}
		is.RA = Macro.RFromD(GeneralProcedures
				.Mod((6.6460656 + 2400.0513 * is.T + 2.58E-5 * is.T * is.T + tim) * 15.0 - ciCore.lon));
		L = is.RA + Constants.rPi;
		B = Constants.rPiHalf - Macro.RAbs(ciCore.lat);
		if (ciCore.lat < 0.0)
			B = -B;
		G = RecToSph(B, L, -is.OB);
		vtx.from(GeneralProcedures.Mod(is.rSid + Macro.DFromR(G + Constants.rPiHalf))); /* Vertex */
	}

	/* Convert rectangular to spherical coordinates. */
	public static double RecToSph(double B, double L, double O) {
		double Q, G;
		PolarCoorF pc = new PolarCoorF(1.0, B);
		RectCoorF rc = null;

		rc = pc.toRectCoorF();
		Q = rc.getY();
		pc = new PolarCoorF(rc.getX(), L);

		rc = pc.toRectCoorF();
		G = rc.getX();
		rc = new RectCoorF(rc.getY(), Q);

		pc = rc.toPolarCoorF();
		pc = new PolarCoorF(pc.getR(), pc.getA() + O);

		rc = pc.toRectCoorF();
		Q = Math.acos(rc.getY());
		rc = new RectCoorF(G, rc.getX());

		pc = rc.toPolarCoorF();
		if (pc.getA() < 0.0)
			pc = new PolarCoorF(pc.getR(), pc.getA() + 2 * Constants.rPi);
		G = pc.getA();

		return G; /* We only ever care about and return one of the coordinates. */
	}

	/*
	 ******************************************************************************
	 ** House Cusp Calculations.
	 ******************************************************************************
	 */

	/* This is a subprocedure of ComputeInHouses(). Given a zodiac position, */
	/* return which of the twelve houses it falls in. Remember that a special */
	/* check has to be done for the house that spans 0 degrees Aries. */

	private int HousePlaceIn(double rLon, double rLat) {
		int i, di;

		if (!us.fHouse3D.toBoolean()) {
			rLon = GeneralProcedures.Mod(rLon + Constants.rSmall);
			di = AstrologyProcedures.MinDifference(chouse[1], chouse[2]) >= 0.0 ? 1 : -1;
			i = 0;
			do {
				i++;
			} while (!(i >= Constants.cSign || (rLon >= chouse[i] && rLon < chouse[AstrologyProcedures.Mod12(i + di)])
					|| (chouse[i] > chouse[AstrologyProcedures.Mod12(i + di)]
							&& (rLon >= chouse[i] || rLon < chouse[AstrologyProcedures.Mod12(i + di)]))));
			if (di < 0)
				i = AstrologyProcedures.Mod12(i - 1);
		} else
			i = Macro.SFromZ(HousePlaceIn3D(rLon, rLat));
		return i;
	}

	private int HousePlaceIn2D(double rLon) {
		return HousePlaceIn(rLon, 0.0);
	}

	/* Compute 3D houses, or the house postion of a 3D location. Given a */
	/* zodiac position and latitude, return the house position as a decimal */
	/* number, which includes how far through the house the coordinates are. */
	private double HousePlaceIn3D(double rLon, double rLat) {
		RefVariant lonM = new RefVariant();
		RefVariant latM = new RefVariant();
		RefVariant lon = new RefVariant();
		RefVariant lat = new RefVariant();

		lonM.from(Macro.RFromD(matrix.Tropical(is.MC)));
		latM.from(0.0);
		matrix.EclToEqu(lonM, latM);
		lon.from(Macro.RFromD(matrix.Tropical(rLon)));
		lat.from(Macro.RFromD(rLat));
		matrix.EclToEqu(lon, lat);
		lon.from(Macro
				.RFromD(GeneralProcedures.Mod(Macro.DFromR(lonM.toDouble() - lon.toDouble() + Constants.rPiHalf))));
		matrix.EquToLocal(lon, lat, -Macro.RFromD(ciMain.lat));
		lon.from(Constants.rDegMax - Macro.DFromR(lon.toDouble()));
		return GeneralProcedures.Mod(lon.toDouble() + Constants.rSmall);
	}

	/* For each object in the chart, determine what house it belongs in. */

	public void ComputeInHouses() {
		int i;

		for (i = 0; i <= Constants.cObj; i++)
			inhouse[i] = HousePlaceIn(planet[i], planetalt[i]);

		/* 3D Campanus cusps should always be in the corresponding house. */
		if (us.fHouse3D.toBoolean() && us.nHouseSystem == Constants.hsCampanus)
			for (i = Constants.cuspLo; i <= Constants.cuspHi; i++)
				inhouse[i] = i - Constants.cuspLo + 1;
	}
	/*
	 ******************************************************************************
	 ** Star Position Calculations.
	 ******************************************************************************
	 */

	/* This is used by the chart calculation routine to calculate the positions */
	/* of the fixed stars. Since the stars don't move in the sky over time, */
	/* getting their positions is mostly just reading info from an array and */
	/* converting it to the correct reference frame. However, we have to add */
	/* in the correct precession for the tropical zodiac, and sort the final */
	/* index list based on what order the stars are supposed to be printed in. */

	void ComputeStars(double SD) {
		int i, j;
		double x, y, z;

		/* Read in star positions. */

		for (i = 1; i <= Constants.cStar; i++) {
			x = ObjectCalculationTables.rStarData[i * 6 - 6];
			y = ObjectCalculationTables.rStarData[i * 6 - 5];
			z = ObjectCalculationTables.rStarData[i * 6 - 4];
			planet[Constants.oNorm + i] = Macro
					.RFromD(x * Constants.rDegMax / 24.0 + y * 15.0 / 60.0 + z * 0.25 / 60.0);
			x = ObjectCalculationTables.rStarData[i * 6 - 3];
			y = ObjectCalculationTables.rStarData[i * 6 - 2];
			z = ObjectCalculationTables.rStarData[i * 6 - 1];
			if (x < 0.0) {
				y = -y;
				z = -z;
			}
			planetalt[Constants.oNorm + i] = Macro.RFromD(x + y / 60.0 + z / 60.0 / 60.0);
			/* Convert to ecliptic zodiac coordinates. */
			RefVariant obj = new RefVariant(planet[Constants.oNorm + i]);
			RefVariant alt = new RefVariant(planetalt[Constants.oNorm + i]);
			matrix.EquToEcl(obj, alt);
			planet[Constants.oNorm + i] = obj.toDouble();
			planetalt[Constants.oNorm + i] = alt.toDouble();
			planet[Constants.oNorm + i] = GeneralProcedures
					.Mod(Macro.DFromR(planet[Constants.oNorm + i]) + Constants.rEpoch2000 + SD);
			planetalt[Constants.oNorm + i] = Macro.DFromR(planetalt[Constants.oNorm + i]);
			if (!us.fSidereal.toBoolean())
				ret[Constants.oNorm + i] = Constants.rDegMax / 25765.0 / Constants.rDayInYear;
			starname[i] = i;
		}

		/* Sort the index list if -Uz, -Ul, -Un, or -Ub switch in effect. */

		if (us.nStar > 1)
			for (i = 2; i <= Constants.cStar; i++) {
				j = i - 1;

				/* Compare star names for -Un switch. */

				if (us.nStar == 'n')
					while (j > 0 && GlobalTables.szObjName[Constants.oNorm + starname[j]]
							.compareTo(GlobalTables.szObjName[Constants.oNorm + starname[j + 1]]) > 0) {
						Macro.SwapN(starname, j, j + 1);
						j--;

						/* Compare star brightnesses for -Ub switch. */

					}
				else if (us.nStar == 'b')
					while (j > 0
							&& ObjectCalculationTables.rStarBright[starname[j]] > ObjectCalculationTables.rStarBright[starname[j
									+ 1]]) {
						Macro.SwapN(starname, j, j + 1);
						j--;

						/* Compare star zodiac locations for -Uz switch. */

					}
				else if (us.nStar == 'z')
					while (j > 0 && planet[Constants.oNorm + starname[j]] > planet[Constants.oNorm + starname[j + 1]]) {
						Macro.SwapN(starname, j, j + 1);
						j--;

						/* Compare star declinations for -Ul switch. */

					}
				else if (us.nStar == 'l')
					while (j > 0 && planetalt[Constants.oNorm + starname[j]] < planetalt[Constants.oNorm
							+ starname[j + 1]]) {
						Macro.SwapN(starname, j, j + 1);
						j--;
					}
			}
	}
	/*
	 ******************************************************************************
	 ** Chart Calculation.
	 ******************************************************************************
	 */

	/* Given a zodiac degree, transform it into its Decan sign, where each */
	/* sign is trisected into the three signs of its element. For example, */
	/* 1 Aries -> 3 Aries, 10 Leo -> 0 Sagittarius, 25 Sagittarius -> 15 Leo. */

	public double Decan(double deg) {
		int sign;
		double unit;

		sign = Macro.SFromZ(deg);
		unit = deg - Macro.ZFromS(sign);
		sign = AstrologyProcedures.Mod12(sign + 4 * ((int) Math.floor(unit / 10.0)));
		unit = (unit - Math.floor(unit / 10.0) * 10.0) * 3.0;
		return Macro.ZFromS(sign) + unit;
	}

	/* Given a zodiac degree, transform it into its Navamsa position, where */
	/* each sign is divided into ninths, which determines the number of signs */
	/* after a base element sign to use. Degrees within signs are unaffected. */

	double Navamsa(double deg) {
		int sign, sign2;
		double unit;

		sign = Macro.SFromZ(deg);
		unit = deg - Macro.ZFromS(sign);
		sign2 = AstrologyProcedures.Mod12(((sign - 1 & 3) ^ (2 * Macro.FOdd(sign - 1))) * 3 + (int) (unit * 0.3) + 1);
		return Macro.ZFromS(sign2) + unit;
	}

	/* Compute the positions of the planets at a certain time using the Swiss */
	/* Ephemeris accurate formulas. This will supersede the Matrix routine */
	/* values and is only called when the -b switch is in effect. Not all */
	/* objects or modes are available using this, but some additional values */
	/* such as Moon and Node velocities not available without -b are. (This is */
	/* the main place in Astrolog which calls the Swiss Ephemeris functions.) */
	public boolean ComputeEphem(double t) {
		if (!AstrologFeatures.EPHEM)
			return false;
		int i;
		RefVariant r1 = new RefVariant();
		RefVariant r2 = new RefVariant();
		RefVariant r3 = new RefVariant();
		RefVariant r4 = new RefVariant();

		/* We can compute the positions of Sun through Pluto, Chiron, the four */
		/* asteroids, Lilith, and the North Node using ephemeris files. */
		for (i = Constants.oSun; i <= Constants.uranHi; i++) {
			if ((0 != ignore[i] && i != us.objCenter && i > Constants.oMoo
					&& (i != Constants.oNod || 0 != ignore[Constants.oSou]))
					|| Macro.FBetween(i, Constants.oFor, Constants.cuspHi)
					|| (us.fPlacalcPla.toBoolean() && i >= Constants.oFor)
					|| (us.fPlacalcAst.toBoolean() && Macro.FBetween(i, Constants.oCer, Constants.oVes)))
				continue;
			r4.from(0.0);

			/* Compute x,y,z coordinates from azimuth, altitude, and distance. */
			RectCoor3dF rc = new PolarCoor3dF(0.0, planet[i], planetalt[i]).toRectCoor3dF();
			spacex[i] = rc.getX();
			spacey[i] = rc.getY();
			spacez[i] = rc.getZ();
		}

		/* If heliocentric, move Earth position to object slot zero. */
		if (0 == ignore[Constants.oSou]) {
			spacex[Constants.oSou] = -spacex[Constants.oNod];
			spacey[Constants.oSou] = -spacey[Constants.oNod];
			spacez[Constants.oSou] = -spacez[Constants.oNod];
			ret[Constants.oSou] = ret[Constants.oNod];
		}
		if (us.objCenter == Constants.oEar)
			return false;
		planet[Constants.oEar] = planet[Constants.oSun];
		planetalt[Constants.oEar] = planetalt[Constants.oSun];
		ret[Constants.oEar] = ret[Constants.oSun];
		spacex[Constants.oEar] = spacex[Constants.oSun];
		spacey[Constants.oEar] = spacey[Constants.oSun];
		spacez[Constants.oEar] = spacez[Constants.oSun];
		planet[Constants.oSun] = planetalt[Constants.oSun] = spacex[Constants.oSun] = spacey[Constants.oSun] = spacez[Constants.oSun] = 0.0;
		for (i = Constants.oNod; i <= Constants.oLil; i++)
			if (0 == ignore[i]) {
				spacex[i] += spacex[Constants.oEar];
				spacey[i] += spacey[Constants.oEar];
				spacez[i] += spacez[Constants.oEar];
			}
		if (us.objCenter == Constants.oSun)
			return false;

		/* If other planet centered, shift all positions by central planet. */
		for (i = 0; i <= Constants.oNorm; i++)
			if (0 == ignore[i] && i != us.objCenter) {
				spacex[i] -= spacex[us.objCenter];
				spacey[i] -= spacey[us.objCenter];
				spacez[i] -= spacez[us.objCenter];
				matrix.ProcessPlanet(i, 0.0);
			}
		planet[us.objCenter] = planetalt[us.objCenter] = spacex[us.objCenter] = spacey[us.objCenter] = spacez[us.objCenter] = 0.0;
		return true;
	}

	/* This house system is just like the Equal system except that we start */
	/* our 12 equal segments from the Midheaven instead of the Ascendant. */

	private void HouseEqualMidheaven() {
		int i;

		for (i = 1; i <= Constants.cSign; i++)
			chouse[i] = GeneralProcedures.Mod(is.MC - 270.0 + 30.0 * (double) (i - 1));
	}

	/* Compute the cusp positions using the Alcabitius house system. */

	private void HouseAlcabitius() {
		double rDecl, rSda, rSna, r, rLon;
		int i;

		rDecl = Macro.RAsin(Macro.RSin(is.OB) * Macro.RSinD(is.Asc));
		r = -Macro.RTan(ciCore.lat) * Macro.RTan(rDecl);
		rSda = Macro.DFromR(Macro.RAcos(r));
		rSna = Constants.rDegHalf - rSda;
		chouse[7] = Macro.DFromR(is.RA) - rSna;
		chouse[8] = Macro.DFromR(is.RA) - rSna * 2.0 / 3.0;
		chouse[9] = Macro.DFromR(is.RA) - rSna / 3.0;
		chouse[10] = Macro.DFromR(is.RA);
		chouse[11] = Macro.DFromR(is.RA) + rSda / 3.0;
		chouse[12] = Macro.DFromR(is.RA) + rSda * 2.0 / 3.0;
		for (i = 7; i <= 12; i++) {
			r = Macro.RFromD(GeneralProcedures.Mod(chouse[i]));
			/* The transformation below is also done in CuspMidheaven(). */
			rLon = Macro.RAtn(Macro.RTan(r) / Macro.RCos(is.OB));
			if (rLon < 0.0)
				rLon += Constants.rPi;
			if (r > Constants.rPi)
				rLon += Constants.rPi;
			chouse[i] = GeneralProcedures.Mod(Macro.DFromR(rLon) + is.rSid);
		}
		for (i = 1; i <= 6; i++)
			chouse[i] = GeneralProcedures.Mod(chouse[i + 6] + Constants.rDegHalf);
	}

	/* This is a newer house system similar in philosophy to Porphyry houses, */
	/* and therefore (at least in the past) has also been called Neo-Porphyry. */
	/* Instead of just trisecting the difference in each quadrant, we do a */
	/* smooth sinusoidal distribution of the difference around all the cusps. */
	/* Note that middle houses become 0 sized if a quadrant is <= 30 degrees. */

	private void HousePullenSinusoidalDelta() {
		double rQuad, rDelta;
		int iHouse;

		/* Solve equations: x+n + x + x+n = q, x+3n + x+4n + x+3n = 180-q. */
		rQuad = AstrologyProcedures.MinDistance(is.MC, is.Asc);
		rDelta = (rQuad - Constants.rDegQuad) / 4.0;
		chouse[Constants.sLib] = GeneralProcedures.Mod(is.Asc + Constants.rDegHalf);
		chouse[Constants.sCap] = is.MC;
		if (rQuad >= 30.0) {
			chouse[Constants.sAqu] = GeneralProcedures.Mod(chouse[Constants.sCap] + 30.0 + rDelta);
			chouse[Constants.sPis] = GeneralProcedures.Mod(chouse[Constants.sAqu] + 30.0 + rDelta * 2.0);
		} else
			chouse[Constants.sAqu] = chouse[Constants.sPis] = AstrologyProcedures.Midpoint(chouse[Constants.sCap],
					is.Asc);
		if (rQuad <= 150.0) {
			chouse[Constants.sSag] = GeneralProcedures.Mod(chouse[Constants.sCap] - 30.0 + rDelta);
			chouse[Constants.sSco] = GeneralProcedures.Mod(chouse[Constants.sSag] - 30.0 + rDelta * 2.0);
		} else
			chouse[Constants.sSag] = chouse[Constants.sSco] = AstrologyProcedures.Midpoint(chouse[Constants.sCap],
					chouse[Constants.sLib]);
		for (iHouse = Constants.sAri; iHouse < Constants.sLib; iHouse++)
			chouse[iHouse] = GeneralProcedures.Mod(chouse[iHouse + 6] + Constants.rDegHalf);
	}

	/* This is a new house system very similar to Sinusoidal Delta. Instead of */
	/* adding a sine wave offset, multiply a sine wave ratio. */

	private void HousePullenSinusoidalRatio() {
		double qSmall, rRatio, rRatio3, rRatio4, xHouse, rLo, rHi;
		int iHouse, dir;

		/* Start by determining the quadrant sizes. */
		qSmall = AstrologyProcedures.MinDistance(is.MC, is.Asc);
		dir = qSmall <= Constants.rDegQuad ? 1 : -1;
		if (dir < 0)
			qSmall = Constants.rDegHalf - qSmall;

		// #if TRUE
		/* Solve equations: rx + x + rx = q, xr^3 + xr^4 + xr^3 = 180-q. Solve */
		/* quartic for r, then compute x given 1st equation: x = q / (2r + 1). */
		if (qSmall > 0.0) {
			rLo = (2.0 * Math.pow(qSmall * qSmall - 270.0 * qSmall + 16200.0, 1.0 / 3.0)) / Math.pow(qSmall, 2.0 / 3.0);
			rHi = Macro.RSqr(rLo + 1.0);
			rRatio = 0.5 * rHi + 0.5 * Macro.RSqr(-6.0 * (qSmall - 120.0) / (qSmall * rHi) - rLo + 2.0) - 0.5;
		} else
			rRatio = 0.0;
		rRatio3 = rRatio * rRatio * rRatio;
		rRatio4 = rRatio3 * rRatio;
		xHouse = qSmall / (2.0 * rRatio + 1.0);

		// #else
		// /* Can also solve equations empirically. Given candidate for r, compute x */
		// /* given 1st equation: x = q / (2r + 1), then compare both against 2nd: */
		// /* 2xr^3 + xr^4 = 180-q, to see whether current r is too large or small. */
		// /* Before binary searching, first keep doubling rHi until too large. */
		//
		// real qLarge = rDegHalf - qSmall;
		// flag fBinarySearch = fFalse;
		//
		// rLo = rRatio = 1.0;
		// loop {
		// rRatio = fBinarySearch ? (rLo + rHi) / 2.0 : rRatio * 2.0;
		// rRatio3 = rRatio * rRatio * rRatio; rRatio4 = rRatio3 * rRatio;
		// xHouse = qSmall / (2.0 * rRatio + 1.0);
		// if ((fBinarySearch && (rRatio <= rLo || rRatio >= rHi)) || xHouse <= 0.0)
		// break;
		// if (2.0 * xHouse * rRatio3 + xHouse * rRatio4 >= qLarge) {
		// rHi = rRatio;
		// fBinarySearch = fTrue;
		// } else if (fBinarySearch)
		// rLo = rRatio;
		// }
		// #endif

		/* xHouse and rRatio have been calculated. Fill in the house cusps. */
		if (dir < 0)
			Macro.neg(xHouse);
		chouse[Constants.sAri] = is.Asc;
		chouse[Constants.sCap] = is.MC;
		chouse[Constants.sLib] = GeneralProcedures.Mod(is.Asc + Constants.rDegHalf);
		chouse[Constants.sCap + dir] = GeneralProcedures.Mod(chouse[Constants.sCap] + xHouse * rRatio);
		chouse[Constants.sCap + dir * 2] = GeneralProcedures
				.Mod(chouse[GeneralProcedures.Mod12(Constants.sCap + dir * 3)] - xHouse * rRatio);
		chouse[Constants.sCap - dir] = GeneralProcedures.Mod(chouse[Constants.sCap] - xHouse * rRatio3);
		chouse[Constants.sCap - dir * 2] = GeneralProcedures
				.Mod(chouse[GeneralProcedures.Mod12(Constants.sCap - dir * 3)] + xHouse * rRatio3);
		for (iHouse = Constants.sTau; iHouse < Constants.sLib; iHouse++)
			chouse[iHouse] = GeneralProcedures.Mod(chouse[iHouse + 6] + Constants.rDegHalf);
	}

	/* The "Whole" house system is like the Equal system with 30 degree houses, */
	/* where the 1st house starts at zero degrees of the sign of the Ascendant. */

	private void HouseWhole() {
		int i;

		for (i = 1; i <= Constants.cSign; i++)
			chouse[i] = GeneralProcedures.Mod((double) ((Macro.SFromZ(is.Asc) - 1) * 30) + Macro.ZFromS(i));
	}

	/* The Sripati house system is like the Porphyry system except each house */
	/* starts in the middle of the previous house as defined by Porphyry. */

	private void HouseSripati() {
		int iHouse;
		double[] rgr = new double[Constants.cSign + 1];
		double rQuad;

		rgr[Constants.sAri] = is.Asc;
		rgr[Constants.sCap] = is.MC;
		rQuad = AstrologyProcedures.MinDistance(is.Asc, is.MC);
		rgr[Constants.sAqu] = GeneralProcedures.Mod(is.MC + rQuad / 3.0);
		rgr[Constants.sPis] = GeneralProcedures.Mod(is.MC + rQuad * 2.0 / 3.0);
		rQuad = Constants.rDegHalf - rQuad;
		rgr[Constants.sSag] = GeneralProcedures.Mod(is.MC - rQuad / 3.0);
		rgr[Constants.sSco] = GeneralProcedures.Mod(is.MC - rQuad * 2.0 / 3.0);
		for (iHouse = Constants.sTau; iHouse <= Constants.sLib; iHouse++)
			rgr[iHouse] = GeneralProcedures.Mod(rgr[GeneralProcedures.Mod12(iHouse + 6)] + Constants.rDegHalf);
		for (iHouse = Constants.sAri; iHouse <= Constants.sPis; iHouse++)
			chouse[iHouse] = AstrologyProcedures.Midpoint(rgr[iHouse], rgr[GeneralProcedures.Mod12(iHouse - 1)]);
	}

	/* The "Vedic" house system is like the Equal system except each house */
	/* starts 15 degrees earlier. The Asc falls in the middle of the 1st house. */

	private void HouseVedic() {
		int i;

		for (i = 1; i <= Constants.cSign; i++)
			chouse[i] = GeneralProcedures.Mod(is.Asc - 15.0 + Macro.ZFromS(i));
	}

	/* In "null" houses, the cusps are fixed to start at their corresponding */
	/* sign, i.e. the 1st house is always at 0 degrees Aries, etc. */

	private void HouseNull() {
		int i;

		for (i = 1; i <= Constants.cSign; i++)
			chouse[i] = GeneralProcedures.Mod(Macro.ZFromS(i));
	}

	/* Calculate the house cusp positions, using the specified algorithm. */

	private void ComputeHouses(int housesystem) {
		char[] sz = new char[Constants.cchSzDef];

		/* Don't allow polar latitudes if system not defined in polar zones. */
		if (((housesystem == Constants.hsPlacidus || housesystem == Constants.hsKoch)
				&& Macro.RAbs(ciCore.lat) >= Macro.RFromD(Constants.rDegQuad - Macro.DFromR(is.OB)))) {
			// sprintf(sz,
			// "The %s system of houses is not defined at extreme latitudes.",
			// szSystem[housesystem]);
			// PrintWarning(sz);
			housesystem = Constants.hsPorphyry;
		}

		/* Flip the Ascendant or MC if it falls in the wrong half of the zodiac. */
		if (AstrologyProcedures.MinDifference(is.MC, is.Asc) < 0.0) {
			if (us.fPolarAsc.toBoolean())
				is.MC = GeneralProcedures.Mod(is.MC + Constants.rDegHalf);
			else
				is.Asc = GeneralProcedures.Mod(is.Asc + Constants.rDegHalf);
		}

		switch (housesystem) {
		//// #ifdef MATRIX
		case Constants.hsPlacidus:
			matrix.HousePlacidus();
			break;
		case Constants.hsKoch:
			matrix.HouseKoch();
			break;
		case Constants.hsEqual:
			matrix.HouseEqual();
			break;
		case Constants.hsCampanus:
			matrix.HouseCampanus();
			break;
		case Constants.hsMeridian:
			matrix.HouseMeridian();
			break;
		case Constants.hsRegiomontanus:
			matrix.HouseRegiomontanus();
			break;
		case Constants.hsPorphyry:
			matrix.HousePorphyry();
			break;
		case Constants.hsMorinus:
			matrix.HouseMorinus();
			break;
		case Constants.hsTopocentric:
			matrix.HouseTopocentric();
			break;
		//// #endif
		case Constants.hsAlcabitius:
			HouseAlcabitius();
			break;
		case Constants.hsEqualMC:
			HouseEqualMidheaven();
			break;
		case Constants.hsSinewaveRatio:
			HousePullenSinusoidalRatio();
			break;
		case Constants.hsSinewaveDelta:
			HousePullenSinusoidalDelta();
			break;
		case Constants.hsWhole:
			HouseWhole();
			break;
		case Constants.hsVedic:
			HouseVedic();
			break;
		case Constants.hsSripati:
			HouseSripati();
			break;
		default:
			HouseNull();
			break;
		}
	}
}
