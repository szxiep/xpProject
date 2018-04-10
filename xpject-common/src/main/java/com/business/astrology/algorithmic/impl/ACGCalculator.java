package com.business.astrology.algorithmic.impl;

import com.business.astrology.algorithmic.api.IACG;
import com.business.astrology.algorithmic.api.IACGCalculator;
import com.business.astrology.algorithmic.api.INatal;
import com.business.astrology.algorithmic.bean.ACGData;
import com.business.astrology.algorithmic.bean.CI;
import com.business.astrology.algorithmic.bean.Flag;
import com.business.astrology.algorithmic.bean.Profile;
import com.business.astrology.algorithmic.bean.RefVariant;
import com.business.astrology.algorithmic.bean.WGS84PointF;
import com.business.astrology.algorithmic.utils.Constants;
import com.business.astrology.algorithmic.utils.GeneralProcedures;
import com.business.astrology.algorithmic.utils.Macro;

public class ACGCalculator extends AstrologCalculator implements IACGCalculator {

	// #define WHEELCOLS 15 /* Affects width of each house in wheel display. */
	// #define WHEELROWS 11 /* Max no. of objects that can be in a wheel house. */
	// #define SCREENWIDTH 80 /* Number of columns to print interpretations in. */
	// #define MONTHSPACE 3 /* Number of spaces between each calendar column. */
	// #define MAXINDAY 150 /* Max number of aspects or transits displayable. */
	public static final int MAXCROSS = 750; /* Max number of latitude crossings displayable. */
	// #define CREDITWIDTH 74 /* Number of text columns in the -Hc credit screen. */
	// #define MAXSWITCHES 32 /* Max number of switch parameters per input line. */
	// #define PSGUTTER 9 /* Points of white space on PostScript page edge. */

	public static class CrossInfo {
		double[] lat = new double[MAXCROSS];
		double[] lon = new double[MAXCROSS];
		int[] obj1 = new int[MAXCROSS];
		int[] obj2 = new int[MAXCROSS];
	}

	private WGS84PointF[] zeniths;
	private WGS84PointF[] nadirs;
	private WGS84PointF[] ascs;
	private WGS84PointF[] dscs;
	private WGS84PointF[][] asc;
	private WGS84PointF[][] dsc;

	private double[] planet1 = new double[Constants.objMax];
	private double[] planet2 = new double[Constants.objMax];
	private double[] mc = new double[Constants.objMax];
	private double[] ic = new double[Constants.objMax];
	private double lo;

	public ACGCalculator(Profile profile, CI ciCore) {
		super(profile, ciCore);
		lo = ciCore.lon;
	}

	@Override
	public IACG calcACG() {

		us.fAstroGraph = new Flag(1);// 理论上是没影响，为确保后续拓展，保留

		us.fRound = new Flag(0);
		us.fSeconds = new Flag(1);

		this.calc();

		lo = lo < 0.0 ? lo + Constants.rDegMax : lo;

		this.zeniths = new WGS84PointF[Constants.objMax];
		ComputePlanetsZeniths();

		this.nadirs = new WGS84PointF[Constants.objMax];
		ComputePlanetsNadirs();

		this.ascs = new WGS84PointF[Constants.objMax];
		ComputePlanetsAscs();

		this.dscs = new WGS84PointF[Constants.objMax];
		ComputePlanetsDscs();

		CrossInfo c = new CrossInfo();
		double[] asc = new double[Constants.objMax];
		double[] des = new double[Constants.objMax];
		double[] asc1 = new double[Constants.objMax];
		double[] des1 = new double[Constants.objMax];
		double longm, w, x, y, z, ad, oa, am, od, dm;
		double[] cp2dir = new double[Constants.objMax];
		int cCross = 0, tot = Constants.cObj;

		/* Print the Zenith latitude locations. */
		// PrintSz("\nZenith : ");
		for (int i = 0; i <= tot; i++)
			if (0 == ignoreACG[i] && FThing(i)) {
				// AnsiColor(kObjA[i]);
				// y = Macro.DFromR(planet2[i]);
				// if (is.fSeconds) {
				// sprintf(sz, " %s ", SzLocation(0.0, y));
				// for (j = 1; sz[j] = sz[j+11]; j++)
				// ;
				// } else {
				// sprintf(sz, "%3.0f%c", RAbs(y), y < 0.0 ? 's' : 'n');
				// }
				// PrintSz(sz);
				asc[i] = des[i] = asc1[i] = des1[i] = Constants.rLarge;
			}
		// PrintL2();

		int latMax = 89 - (89 % us.nAstroGraphStep);
		int latMin = -90;
		this.asc = new WGS84PointF[Constants.objMax][(latMax - latMin) / us.nAstroGraphStep];
		this.dsc = new WGS84PointF[Constants.objMax][(latMax - latMin) / us.nAstroGraphStep];
		int[] ascCount = new int[Constants.objMax], dscCount = new int[Constants.objMax];

		/* Now print the locations of Ascendant and Descendant lines. Since these */
		/* are curvy, we loop through the latitudes, and for each object at each */
		/* latitude, print the longitude location of the line in question. */

		longm = Macro.RFromD(GeneralProcedures.Mod(Macro.DFromR(planet1[Constants.oMC]) + lo));
		for (int j = latMax; j > latMin; j -= us.nAstroGraphStep) {
			// AnsiColor(kDefault);
			// sprintf(sz, "Asc@%2d%c: ", j >= 0 ? j : -j, j < 0 ? 's' : 'n');
			// PrintSz(sz);
			for (int i = 0; i <= tot; i++) {
				if (0 == ignoreACG[i] && FThing(i)) {
					// AnsiColor(kObjA[i]);
					ad = Math.tan(planet2[i]) * Math.tan(Macro.RFromD(j));
					if (ad * ad > 1.0) {
						// PrintSz(" --");
						// if (is.fSeconds)
						// PrintSz("------ ");
						// PrintCh(' ');
						asc1[i] = des1[i] = cp2dir[i] = Constants.rLarge;
					} else {
						ad = Math.asin(ad);
						oa = planet1[i] - ad;
						if (oa < 0.0)
							oa += 2.0 * Constants.rPi;
						am = oa - Constants.rPiHalf;
						if (am < 0.0)
							am += 2.0 * Constants.rPi;
						z = longm - am;
						if (z < 0.0)
							z += 2.0 * Constants.rPi;
						if (z > Constants.rPi)
							z -= 2.0 * Constants.rPi;
						asc1[i] = asc[i];
						asc[i] = z = Macro.DFromR(z);
						cp2dir[i] = ad;
						// if (is.fSeconds) {
						// sprintf(sz, "%s ", SzLocation(z, 0.0)); sz[11] = chNull;
						// } else
						// sprintf(sz, "%3.0f%c", RAbs(z), z < 0.0 ? 'e' : 'w');
						// PrintSz(sz);
						this.asc[i][ascCount[i]++] = getFixedCoord(new WGS84PointF(z, j));
					}
				}
			}

			/* Again, the Descendant position is related to the Ascendant's, */
			/* being a mirror image, so it can be calculated somewhat easier. */

			// AnsiColor(kDefault);
			// sprintf(sz, "\nDsc@%2d%c: ", j >= 0 ? j : -j, j < 0 ? 's' : 'n');
			// PrintSz(sz);
			for (int i = 0; i <= tot; i++)
				if (0 == ignoreACG[i] && FThing(i)) {
					// AnsiColor(kObjA[i]);
					ad = cp2dir[i];
					if (ad == Constants.rLarge) {
						// PrintSz(" --");
						// if (is.fSeconds)
						// PrintSz("------ ");
						// PrintCh(' ');
					} else {
						od = planet1[i] + ad;
						dm = od + Constants.rPiHalf;
						z = longm - dm;
						if (z < 0.0)
							z += 2.0 * Constants.rPi;
						if (z > Constants.rPi)
							z -= 2.0 * Constants.rPi;
						des1[i] = des[i];
						des[i] = z = Macro.DFromR(z);
						// if (is.fSeconds) {
						// sprintf(sz, "%s ", SzLocation(z, 0.0)); sz[11] = chNull;
						// } else
						// sprintf(sz, "%3.0f%c", RAbs(z), z < 0.0 ? 'e' : 'w');
						// PrintSz(sz);
						this.dsc[i][dscCount[i]++] = getFixedCoord(new WGS84PointF(z, j));
					}
				}
			// PrintL();

			// /* Now, if the -L0 switch is in effect, then take these line positions, */
			// /* which we saved in an array above as we were printing them, and */
			// /* calculate and print the latitude crossings. */
			//
			// if (us.fLatitudeCross.toBoolean()) {
			// for (int l = 0; l <= Constants.cObj; l++) {
			// if (0 != ignoreACG[l])
			// continue;
			// for (int k = 0; k <= Constants.cObj; k++) {
			// if (0 != ignoreACG[k])
			// continue;
			// for (int n = 0; n <= 1; n++) {
			// x = 0 != n ? des1[l] : asc1[l];
			// y = 0 != n ? des[l] : asc[l];
			// for (int m = 0; m <= 1; m++) {
			//
			// /* Check if Ascendant/Descendant cross Midheaven/Nadir. */
			//
			// z = 0 != m ? ic[k] : mc[k];
			// if (cCross < MAXCROSS && Math.abs(x - y) < Constants.rDegHalf
			// && GeneralProcedures.RSgn(z - x) != GeneralProcedures.RSgn(z - y)) {
			// c.obj1[cCross] = 0 != n ? -l : l;
			// c.obj2[cCross] = 0 != m ? -k : k;
			// c.lat[cCross] = (double) j + 5.0 * Math.abs(z - y) / Math.abs(x - y);
			// c.lon[cCross] = z;
			// cCross++;
			// }
			//
			// /* Check if Ascendant/Descendant cross another Asc/Des. */
			//
			// w = 0 != m ? des1[k] : asc1[k];
			// z = 0 != m ? des[k] : asc[k];
			// if (cCross < MAXCROSS && k > l && Math.abs(x - y) + Math.abs(w - z) <
			// Constants.rDegHalf
			// && GeneralProcedures.RSgn(w - x) != GeneralProcedures.RSgn(z - y)
			// && !(k == Constants.oSou && l == Constants.oNod)) {
			// c.obj1[cCross] = 0 != n ? -l : l;
			// c.obj2[cCross] = 100 + (0 != m ? -k : k);
			// c.lat[cCross] = (double) j
			// + 5.0 * Math.abs(y - z) / (Math.abs(x - w) + Math.abs(y - z));
			// c.lon[cCross] = Math.min(x, y)
			// + Math.abs(x - y) * Math.abs(y - z) / (Math.abs(x - w) + Math.abs(y - z));
			// cCross++;
			// }
			// }
			// }
			// }
			// }
			// }
		}
		//
		// /* Now, print out all the latitude crossings we found. */
		// /* First, we sort them in order of decreasing latitude. */
		//
		// for (int i = 1; i < cCross; i++) {
		// int j = i - 1;
		// while (j >= 0 && c.lat[j] < c.lat[j + 1]) {
		// Macro.SwapN(c.obj1, j, j + 1);
		// Macro.SwapN(c.obj2, j, j + 1);
		// GeneralProcedures.SwapR(c.lat, j, j + 1);
		// GeneralProcedures.SwapR(c.lon, j, j + 1);
		// j--;
		// }
		// }
		// for (int i = 0; i < cCross; i++) { // 枚举所有轨迹点
		// int j = Math.abs(c.obj1[i]); // 计算轨迹点所对应星体
		// AnsiColor(kObjA[j]);
		// sprintf(sz, "%.3s ", szObjName[j]); PrintSz(sz);
		// AnsiColor(kElemA[c.obj1[i] > 0 ? eFir : eAir]);
		// PrintSz(c.obj1[i] > 0 ? "Ascendant " : "Descendant");
		// AnsiColor(kMainA[1]);
		// PrintSz(" crosses ");
		// j = Math.abs(c.obj2[i] - (c.obj2[i] < 50 ? 0 : 100));
		// AnsiColor(kObjA[j]);
		// sprintf(sz, "%.3s ", szObjName[j]); PrintSz(sz);
		// AnsiColor(kElemA[c.obj2[i] < 50 ?
		// (c.obj2[i] > 0 ? eEar : eWat) : (c.obj2[i] > 100 ? eFir : eAir)]);
		// sprintf(sz, "%s ", c.obj2[i] < 50 ? (c.obj2[i] > 0 ? "Midheaven " :
		// "Nadir ") : (c.obj2[i] > 100 ? "Ascendant " : "Descendant"));
		// PrintSz(sz);
		// AnsiColor(kDefault);
		// sprintf(sz, "at %s%c,", SzDegree(c.lon[i]),
		// c.lon[i] < 0.0 ? 'E' : 'W'); PrintSz(sz);
		// j = (int) (Macro.RFract(Math.abs(c.lat[i])) * 60.0);
		// sprintf(sz, "%s%c\n", SzDegree(c.lat[i]),
		// c.lat[i] < 0.0 ? 'S' : 'N'); PrintSz(sz);
		// }
		// DeallocateP(c);
		// if (!cCross) {
		// AnsiColor(kDefault);
		// PrintSz("No latitude crossings.\n");
		// }

		FixedACGDataForDisplay();
		
		// 添加上升轨迹的顶点
		WGS84PointF[][] ascPaths = new WGS84PointF[this.asc.length][];
		for(int i = 0; i < ascPaths.length; ++ i) {
			if(null == this.ascs[i] || null == this.dscs[i])
				continue;
			int count = 0;
			for(WGS84PointF unknown : this.asc[i]) {
				if(null == unknown)
					break;
				++ count;
			}
			ascPaths[i] = new WGS84PointF[count + 2];
			WGS84PointF top, bottom;
			if(this.ascs[i].getLat() > this.dscs[i].getLat()) {
				top = this.ascs[i];
				bottom = this.dscs[i];
			} else {
				top = this.dscs[i];
				bottom = this.ascs[i];
			}
			ascPaths[i][0] = top;
			ascPaths[i][count + 1] = bottom;
			System.arraycopy(this.asc[i], 0, ascPaths[i], 1, count);
		}
		// 添加下降轨迹的顶点
		WGS84PointF[][] dscPaths = new WGS84PointF[this.dsc.length][];
		for(int i = 0; i < dscPaths.length; ++ i) {
			if(null == this.ascs[i] || null == this.dscs[i])
				continue;
			int count = 0;
			for(WGS84PointF unknown : this.dsc[i]) {
				if(null == unknown)
					break;
				++ count;
			}
			dscPaths[i] = new WGS84PointF[count + 2];
			WGS84PointF top, bottom;
			if(this.ascs[i].getLat() > this.dscs[i].getLat()) {
				top = this.ascs[i];
				bottom = this.dscs[i];
			} else {
				top = this.dscs[i];
				bottom = this.ascs[i];
			}
			dscPaths[i][0] = top;
			dscPaths[i][count + 1] = bottom;
			System.arraycopy(this.dsc[i], 0, dscPaths[i], 1, count);
		}

		return new ACGData(this.zeniths, this.nadirs, this.ascs, this.dscs, ascPaths, dscPaths);
	}

	// 计算各星体天顶点
	public void ComputePlanetsZeniths() {

		RefVariant p1 = new RefVariant();
		RefVariant p2 = new RefVariant();

		int index = 0;

		double x = 0.0d;
		double z = 0.0d;

		for (index = 0; index <= Constants.cObj; index++) {

			if (0 == ignoreACG[index] || Constants.oMC == index) {

				p1.from(Macro.RFromD(matrix.Tropical(index == Constants.oMC ? is.MC : planet[index])));
				p2.from(Macro.RFromD(planetalt[index]));

				matrix.EclToEqu(p1, p2);

				planet1[index] = p1.toDouble();
				planet2[index] = p2.toDouble();
			}
		}

		for (index = 0; index <= Constants.cObj; index++) {

			if (0 == ignoreACG[index]) {

				x = planet1[Constants.oMC] - planet1[index];

				if (x < 0.0) {
					x += 2.0 * Constants.rPi;
				}

				if (x > Constants.rPi) {
					x -= 2.0 * Constants.rPi;
				}

				z = lo + Macro.DFromR(x);
				if (z > Constants.rDegHalf) {
					z -= Constants.rDegMax;
				}
				mc[index] = z;

				zeniths[index] = new WGS84PointF(z, Macro.DFromR(planet2[index]));
			}
		}
	}

	// 计算各星体天底点
	public void ComputePlanetsNadirs() {

		int index = 0;
		double z = 0.0d;

		for (index = 0; index <= Constants.cObj; index++) {

			if (0 == ignoreACG[index]) {

				z = zeniths[index].getLon() + Constants.rDegHalf;

				if (z > Constants.rDegHalf) {
					z -= Constants.rDegMax;
				}

				nadirs[index] = new WGS84PointF(z, -zeniths[index].getLat());
			}
		}

	}

	// 计算各星体上升点
	public void ComputePlanetsAscs() {

		int index = 0;
		double lat = 0.0d;

		for (index = 0; index <= Constants.cObj; index++) {

			if (0 == ignoreACG[index]) {

				lat = nadirs[index].getLat() + Constants.rDegQuad;
				ascs[index] = new WGS84PointF(nadirs[index].getLon(), lat > 90.0d ? lat - 180 : lat);
			}
		}
	}

	// 计算各星体下降点
	public void ComputePlanetsDscs() {

		int index = 0;
		double lat = 0.0d;

		for (index = 0; index <= Constants.cObj; index++) {

			if (0 == ignoreACG[index]) {

				lat = zeniths[index].getLat() + Constants.rDegQuad;

				dscs[index] = new WGS84PointF(zeniths[index].getLon(), lat > 90 ? lat - Constants.rDegHalf : lat);
			}

		}
	}

	// 修正星体轨迹投影经纬度显示
	public void FixedACGDataForDisplay() {

		int index = 0;
		for (index = 0; index <= Constants.cObj; index++) {
			if (0 == ignoreACG[index]) {
				zeniths[index] = getFixedCoord(zeniths[index]);
				nadirs[index] = getFixedCoord(nadirs[index]);
				ascs[index] = getFixedCoord(ascs[index]);
				dscs[index] = getFixedCoord(dscs[index]);
			}
		}
	}

	public WGS84PointF getFixedCoord(WGS84PointF wgs) {
		return null == wgs ? null : new WGS84PointF(getFixedCoord(wgs.getLon()), getFixedCoord(wgs.getLat()));
	}

	// 坐标值修正
	public double getFixedCoord(double r) {
		return GeneralProcedures.RSgn(r) * (us.fRound.toBoolean()
				? Macro.RAbs(r) + (is.fSeconds.toBoolean() ? Constants.rRound / 60.0 / 60.0 : Constants.rRound / 60.0)
				: (Macro.RAbs(r) + Constants.rSmall));
	}

	private boolean FThing(int i) {
		return true;
	}
}
