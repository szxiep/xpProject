package com.business.astrology.util.ecl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.business.astrology.util.Constants;

/**
 * 本命中点
 * 
 * @author xp
 */
public class BasePoint {

	/**
	 * 法达星限 上线 100年
	 */
	private static int limit_age = 365 * 100;

	/**
	 * 本命中点列表
	 * 
	 * @return 星座index -->行星index/行星index,星座index,度数
	 */
	public static Map<String, List<String>> base_point(Double baiy, double[] obj) {
		byte[] ignoreACG = new byte[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, /* Planets */
		1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, /* Minors */
		0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, /* Cusps */
		1, 1, 1, 1, 1, 1, 1, 1, 1, /* Uranians */
		1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, /* Stars */
		1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };

		Map<String, List<String>> maplist = new HashMap<String, List<String>>();
		//Constants constants = new Constants();
		//List<String> glist = constants.groupedZodiac(baiy);// 划分星座度数区间
		// 划分星座度数区间
		for (int i = 0; i < obj.length; i++) {
			if (ignoreACG[i] == 0) {
				Double d1 = obj[i];

				for (int j = i + 1; j < obj.length; j++) {
					if (ignoreACG[j] == 0) {
						if (i == j) {// 跳过相同的星
							continue;
						}
						Double d2 = obj[j];
						// 计算中点
						double val = midpoint1(d1, d2);

						String pos = EclCon.get_position(baiy, val);
						String[] split = pos.split(",");

						// System.out.println("星座="+split[0]+",i="+i+",j="+j+",val ="+val);
						String t = i + "," + j + "," + split[0] + "," + val;
						List<String> lis = new ArrayList<String>();
						if (maplist.containsKey(split[0])) {
							lis = maplist.get(split[0]);
						}
						lis.add(t);

						// 行星index,行星index,星座index,度数
						maplist.put(split[0], lis);
					}
				}
			}
		}
		return maplist;
	}

	/**
	 * 本命中点星耀列表
	 * 
	 * @return
	 */
	public static Map<String, List<String>> pointStar(Double baiy, double[] obj) {
		Map<String, List<String>> maplist = new HashMap<String, List<String>>();
		List<String> lists = new ArrayList<String>();

		for (int i = 0; i < obj.length; i++) {
			if (Constants.ignoreACG[i] == 0) {
				Double d1 = obj[i];

				for (int j = i + 1; j < obj.length; j++) {
					if (Constants.ignoreACG[j] == 0) {
						if (i == j) {// 跳过相同的星
							continue;
						}
						Double d2 = obj[j];
						double val = midpoint1(d1, d2);
						// 计算相位
						String t = i + "," + j + "," + val;
						lists.add(t);
					}
				}
			}
		}
		// 计算相位
		for (int h = 0; h < obj.length; h++) {
			if (Constants.ignoreACG[h] == 0) {
				double r = obj[h];
				for (int k = 0; k < lists.size(); k++) {
					String string = lists.get(k);
					String[] split = string.split(",");

					Integer a = Integer.valueOf(split[0]);
					Integer b = Integer.valueOf(split[1]);

					if ((a == h) || (b == h)) {
						continue;
					}
					Double du = Double.valueOf(split[2]);
					String getzd = getzd(r, du);

					if (null != getzd) { // 有相位
						// 相位行星index,中点行星index,另一个中点行星index,相位值与度数
						String t = h + "," + a + "," + b + "," + getzd;
						List<String> lis = new ArrayList<String>();
						if (maplist.containsKey(h + "")) {
							lis = maplist.get(h + "");
						}
						lis.add(t);
						maplist.put(h + "", lis);
					}
				}
			}
		}
		return maplist;
	}

	private static Date getD(Date da) {
		Date d = da;
		return d;
	}

	// 法达星限
	public static Map<String, List<String>> fadasStarLimited(Boolean ry,
			Date date) {
		Map<String, List<String>> maplist = new HashMap<String, List<String>>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ss");
		int[] fada = new int[] { 1, 4, 3, 2, 7, 6, 5, 16, 17,     1, 4, 3, 2, 7, 6,5, 16, 17 }; // 日，金，水，月，土，木，火,北交，南交
		int[] fan = new int[] { 10, 8, 13, 9, 11, 12, 7, 3, 2,    10, 8, 13, 9,11, 12, 7, 3, 2 }; // 年（主）限

		if (!ry) { // 夜
			fada = new int[] { 2, 7, 6, 5, 16, 17, 1, 4, 3,     2, 7, 6, 5, 16, 17,1, 4, 3 };
			fan = new int[] { 9, 11, 12, 7, 3, 2, 10, 8, 13,    9, 11, 12, 7, 3,2, 10, 8, 13 };
		}
		Calendar cl = new GregorianCalendar();

		// 累加年
		int num = 0;
		// 如果没有超过上限
		for (int i = 0; i < fada.length; i++) {
			List<String> list = new ArrayList<String>();
			int length = fada.length;
			int j = fan[i];// 星对应年限
			// int y = j%4;
			int z = getDayNum(date, j);// 总天数
			int s = (int) Math.round(z / 7.0 * 60 * 24); // 平均一颗星分钟

			num+=z;
			if(num > limit_age){
				break;
			}
			if (fada[i] == 16) { // 北
				// z = getDayNum(date, 3);
				length = 0;
			}
			if (fada[i] == 17) { // 南
				// z = getDayNum(date, 2);
				length = 0;
			}
			cl.setTime(date);
			if (i != 0) { // 计算初始主星日期
				j = fan[i - 1];
				z = getDayNum(date, j);// 总天数
				int ss = (int) Math.round(z * 60 * 24);
				cl.setTime(date);
				cl.add(Calendar.MINUTE, ss);
			}
			date = cl.getTime();
			String t = sdf.format(date);
			list.add("0," + t);

			Date dates = getD(date);
			int index = 0;
			for (int k = i; k < length; k++) {
				if (fada[i] == fada[k] || (fada[k] == 16 || fada[k] == 17)) {
					continue;
				}
				if(index == 6){
					break;
				}
				cl.setTime(dates);
				cl.add(Calendar.MINUTE, s);
				dates = cl.getTime();
				t = sdf.format(dates);
				list.add(fada[k] + "," + t);
				index++;
			}
			maplist.put(i + "", list);
		}
		return maplist;
	}

	/**
	 * 
	 * @param r
	 *            需计算行星度数
	 * @param d
	 *            计算行星的中点
	 * @return
	 */
	private static String getzd(double r, double d) {
		int[] phase1 = Constants.phase1;
		int[] phase2 = Constants.phase2;
		double MSAD = Constants.MSAD;

		// 相位
		double abs = Math.abs(r - d);
		for (int j = 0; j < phase1.length; j++) {
			double val1 = abs - phase1[j];
			double val2 = abs - phase2[j];
			if (-MSAD < val1 && val1 < MSAD) {
				return phase1[j] + "," + val1;
			}
			if (-MSAD < val2 && val2 < MSAD) {
				return phase2[j] + "," + val2;
			}
		}
		return null;
	}

	/**
	 * 计算中点公式1
	 * @param d1 行星index
	 * @param d2 行星index
	 * @return 中点度数
	 * @author 谢乐
	 */
	private static double midpoint1(double d1, double d2) {
		double val = 0.0;
		double c = (d1 + d2) / 2;
		double d = c - 180;
		double e = 0.0;
		double f = 0.0;
		if (d1 < d2) {
			e = Math.abs(c - d1);
			f = Math.abs(d - d1);
		} else {
			e = Math.abs(c - d2);
			f = Math.abs(d - d2);
		}
		if (e - f < 0) {
			val = c;
		} else {
			val = d;
		}
		return val < 0 ? val + 360 : val;
	}

	/**
	 * 计算中点公式2
	 * 
	 * @param d1
	 *            行星index
	 * @param d2
	 *            行星index
	 * @return 中点度数
	 * @author 陈总
	 */
	private static double midpoint2(double d1, double d2) {
		double val = 0.0;
		double a, b;
		if (d1 < d2) {
			a = d1;
			b = d2;
		} else {
			a = d2;
			b = d1;
		}
		if ((a + 180) > b) {
			if ((a + b) > 360) {
				val = (a + b - 360) / 2;
			} else {
				val = (a + b) / 2;
			}
		} else {
			val = (360 - b + a) / 2 + b;
		}
		return val < 0 ? val + 360 : val;
	}

	public static int getDayNum(Date d, int num) {
		int z = 1;
		Calendar cl = new GregorianCalendar();
		cl.setTime(d);
		int year = cl.get(Calendar.YEAR); // 获取年份
		int month = cl.get(Calendar.MONTH) + 1; // 获取月份
		int day = cl.get(Calendar.DATE); // 获取日
		cl.set(year, Calendar.DECEMBER, 31);
		if (cl.get(Calendar.DAY_OF_YEAR) == 366) {
			if (month <= 2 && day <= 28) {
				z = 366;
			} else {
				z = 365;
			}
		} else {
			z = 365;
		}
		for (int i = year + 1; i < year + num; i++) {
			cl = new GregorianCalendar();
			cl.set(i, Calendar.DECEMBER, 31);
			if (cl.get(Calendar.DAY_OF_YEAR) == 366) {
				z += 366;
			} else {
				z += 365;
			}
		}
		return z;
	}

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ss");
		try {
			testzd1(true, sdf.parse("1985-09-16 5:10"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//
	public static void testzd1(boolean ry, Date date) {
		Map<String, List<String>> base_point = BasePoint.fadasStarLimited(ry,
				date);
		for (Entry<String, List<String>> map : base_point.entrySet()) {
			String key = map.getKey();
			List<String> lis = map.getValue();
			System.out.println("行星=" + key);
			for (int i = 0; i < lis.size(); i++) {
				String string = lis.get(i);
				String[] split = string.split(",");
				System.out.println("          " + string);
			}
			System.out.println();
		}
	}
}
