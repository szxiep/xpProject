package com.business.astrology.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.business.astrology.algorithmic.api.IACG;
import com.business.astrology.algorithmic.api.IACGCalculator;
import com.business.astrology.algorithmic.api.IAstrologCalculator;
import com.business.astrology.algorithmic.api.IAstrologCalculatorFactory;
import com.business.astrology.algorithmic.api.INatal;
import com.business.astrology.algorithmic.bean.CI;
import com.business.astrology.algorithmic.bean.Profile;
import com.business.astrology.algorithmic.bean.WGS84PointF;
import com.business.astrology.algorithmic.factory.AstrologCalculatorFactory;
import com.business.astrology.util.ecl.BasePoint;
import com.business.astrology.util.ecl.EclCon;
import com.business.astrology.util.ecliptic.EclipticBean;

/**
 * 星盘数据
 * @author xp
 */
public class CharData {

	public static void main(String[] args) {
		CharData cc = new CharData();
		JSONObject info = cc.getInfo("深圳市罗湖区梧桐山", "2018-11-11 12:00");
		System.out.println(info);
	}
	
	// 获取真太阳时，经度纬度
	public JSONObject getInfo(String address, String time) {
		JSONObject obj = new JSONObject();
		if (null != address && !"".equals(address) && null != time
				&& !"".equals(time)) {
			MapBaidu getLatAndLngByBaidu = new MapBaidu();
			Map<String, Double> map = getLatAndLngByBaidu.getLngAndLat(address);
			if(null != map && map.size() >0){
				Bazi bz = new Bazi();
				MapBaidu bd = new MapBaidu();
				String times = bd.timeDifference(address);// 平太阳时间差
				String timeZone = bz.timeZone(times);// 得出时区
				obj.put("status", 1);
				obj.put("zone", timeZone);
				obj.put("lng", get_liujz(map.get("lng")));//十六进制
				obj.put("lat", get_liujz(map.get("lat")));//十六进制
				obj.put("lngTen", map.get("lng"));//十进制
				obj.put("latTen", map.get("lat"));//十进制
				Calendar getsunPing = bz.getsunPing(map.get("lng"), time + ":00");
				obj.put("ztime", datechange(getsunPing.getTime(), "yyyy-MM-dd HH:mm"));
			}else{
				obj.put("status", 2);
			}
		} else {
			obj.put("status", 0);
		}
		return obj;
	}

	/**
	 * 获取经纬度时区
	 * @return
	 */
	public JSONObject getlnglat(String address) {
		JSONObject obj = new JSONObject();
		if (null != address && !"".equals(address)) {
			MapBaidu getLatAndLngByBaidu = new MapBaidu();
			Map<String, Double> map = getLatAndLngByBaidu.getLngAndLat(address);
			if(null != map && map.size() >0){
				Bazi bz = new Bazi();
				MapBaidu bd = new MapBaidu();
				String times = bd.timeDifference(address);// 平太阳时间差
				String timeZone = bz.timeZone(times);// 得出时区
				obj.put("status", 1);
				obj.put("zone", timeZone);
				obj.put("lng", get_liujz(map.get("lng")));
				obj.put("lat", get_liujz(map.get("lat")));
			}else{
				obj.put("status", 2);
			}
		} else {
			obj.put("status", 0);
		}
		return obj;
	}

	/**
	 * 太阳弧 获取经纬度时区
	 * @return
	 */
	public JSONObject getlnglat1(String address, String time) {
		JSONObject obj = new JSONObject();
		if (null != address && !"".equals(address) && null != time) {
			MapBaidu getLatAndLngByBaidu = new MapBaidu();
			Map<String, Double> map = getLatAndLngByBaidu.getLngAndLat(address);
			if(null != map && map.size() >0){
				Bazi bz = new Bazi();
				MapBaidu bd = new MapBaidu();
				String times = bd.timeDifference(address);// 平太阳时间差
				String timeZone = bz.timeZone(times);// 得出时区
				obj.put("status", 1);
				obj.put("zone", timeZone);
				obj.put("lng", get_liujz(map.get("lng")));
				obj.put("lat", get_liujz(map.get("lat")));
				// 真太阳时
				Bazi bb = new Bazi();
				Calendar getsunPing = bb.getsunPing(map.get("lng"), time + ":00");
				obj.put("ztime", datechange(getsunPing.getTime(), "yyyy-MM-dd HH:mm"));
			}else{
				obj.put("status", 2);
			}
		} else {
			obj.put("status", 0);
		}
		return obj;
	}

	/***
	 * 根据时间和经度获取真太阳时
	 * @param lng 经度
	 * @param datetime 公历时间
	 * @return
	 */
	public JSONObject getsunPing(String lng, String time) {
		JSONObject obj = new JSONObject();
		System.out.println("lng=" + lng);
		if (null != lng && !"".equals(lng) && null != time) {
			String[] lngarr = lng.split(",");
			double dms = DMS(Integer.valueOf(lngarr[0]), Integer.valueOf(lngarr[1]), Integer.valueOf(lngarr[2]));
			Bazi bb = new Bazi();
			Calendar getsunPing = bb.getsunPing(dms, time + ":00");
			obj.put("status", 1);
			obj.put("ztime", datechange(getsunPing.getTime(), "yyyy-MM-dd HH:mm"));
		} else {
			obj.put("status", 0);
		}
		return obj;
	}

	/**
	 * 只排星盘数据
	 * @return
	 */
	public Map<String,Object> chartContentData(Calendar cal,String zontime, String lng,String lat, int sidereal, int gongid){
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			if (null != cal && null != zontime && null != lng && null != lat) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				/*Calendar cal = Calendar.getInstance();
				Date date = formatter.parse(time);
				cal.setTime(date);*/
				// 如果是夏令时
				SavingUtil ss = new SavingUtil();
				boolean sav = ss.getSaving(cal.getTime());
				if (sav) {
					cal.add(Calendar.HOUR_OF_DAY, -1);// 1小时前
				}
				
				//返回真太阳时
				map.put("suntime", formatter.format(cal.getTime()));
				
				int year = cal.get(Calendar.YEAR);// 获取年份
				int month = cal.get(Calendar.MONTH) + 1;// 获取月份
				int day = cal.get(Calendar.DATE);// 获取日
				int hour = cal.get(Calendar.HOUR_OF_DAY);// 小时
				int minute = cal.get(Calendar.MINUTE);// 分
				// int second=cal.get(Calendar.SECOND);//秒
				
				CI ciCore = new CI();
				// 录入功能
				ciCore.setYea(year); // 日期-年
				ciCore.setMon(month); // 日期-月
				ciCore.setDay(day); // 日期-日
				ciCore.setTim(hour + minute / 60.0); // 时间-时分
				String[] spl = zontime.split(":");
				ciCore.setZon(DMS(-Double.valueOf(spl[0]), -Double.valueOf(spl[1]), -Double.valueOf(spl[2]))); // 时区
				String[] lngarr = lng.split(",");
				String[] latarr = lat.split(",");
				ciCore.setLon(DMS(-Double.valueOf(lngarr[0]), -Double.valueOf(lngarr[1]), -Double.valueOf(lngarr[2]))); // 经度-度分秒
				ciCore.setLat(DMS(Double.valueOf(latarr[0]), Double.valueOf(latarr[1]), Double.valueOf(latarr[2]))); // 纬度-度分秒
				// ciCore.setLoc("");
				// ciCore = getCI(year, month, day, hour, minute);
				// 设置功能--系统信息设置（profile属性设置

				Profile profile = new Profile();
				// 坐标系统 false-黄道坐标 true-赤道坐标
				if (sidereal == 0) {
					profile.setSidereal(false);
				} else {
					profile.setSidereal(true);
				}
				profile.setHouseSys(gongid);// 宫制 0-Placidus 1-koch 2-house Asc Sign

				IAstrologCalculatorFactory factory = new AstrologCalculatorFactory();

				IAstrologCalculator calculator = factory.createCalculator(profile, ciCore);
				INatal natal = calculator.calc();

				/*
				 * double[] obj = null; //对应星体角度 double[] alt = null; //预留
				 * double[] dir = null; //行星逆行 double[] cusp =null;
				 * //12宫宫头角度，下标范围1~12 int[] house = null; //各星体所在宫
				 */
				double[] obj = natal.getObj();// 对应星体角度，下标范围0~89，对应枚举类型 // Constants。oEar~Constants.oAnd
				// double[] alt = natal.getAlt();//预留
				double[] dir = natal.getDir();// 行星逆行
				double[] cusp = natal.getCusp(); // 12宫宫头角度，下标范围1~12
				int[] house = natal.getHouse();// 各星体所在宫

				// 如果太阳在夜晚则改变福点的计算规则
				Boolean day_night = EclCon.day_night(cusp[1], obj[1]);
				if (day_night) {// 日生
					double dd = obj[22] + obj[2] - obj[1];
					obj[19] = dd;
				} else {
					double dd = obj[22] + obj[1] - obj[2];
					obj[19] = dd;
				}
				map.put("day_night", day_night);
				map.put("status", 1);
				map.put("obj", obj);
				map.put("cusp", cusp);
				map.put("dir", dir);
			}else{
				map.put("status", 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 星盘,acg,列表等数据
	 * @return
	 * @throws ParseException
	 */
	public JSONObject getChartData(String time, String zontime, String lng,
			String lat, int sidereal, int gongid, int type)
			throws ParseException {
		JSONObject objjson = new JSONObject();
		if (null != time && null != zontime && null != lng && null != lat) {
			try {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				Calendar cal = Calendar.getInstance();
				Date date = formatter.parse(time);
				cal.setTime(date);
				
				// 如果是夏令时
				SavingUtil ss = new SavingUtil();
				boolean sav = ss.getSaving(cal.getTime());
				if (sav) {
					cal.add(Calendar.HOUR_OF_DAY, -1);// 1小时前
				}
				//返回真太阳时
				objjson.put("suntime", formatter.format(cal.getTime()));
				
				int year = cal.get(Calendar.YEAR);// 获取年份
				int month = cal.get(Calendar.MONTH) + 1;// 获取月份
				int day = cal.get(Calendar.DATE);// 获取日
				int hour = cal.get(Calendar.HOUR_OF_DAY);// 小时
				int minute = cal.get(Calendar.MINUTE);// 分
				// int second=cal.get(Calendar.SECOND);//秒
				
				CI ciCore = new CI();
				// 录入功能
				ciCore.setYea(year); // 日期-年
				ciCore.setMon(month); // 日期-月
				ciCore.setDay(day); // 日期-日
				ciCore.setTim(hour + minute / 60.0); // 时间-时分
				String[] spl = zontime.split(":");
				ciCore.setZon(DMS(-Double.valueOf(spl[0]), -Double.valueOf(spl[1]), -Double.valueOf(spl[2]))); // 时区
				String[] lngarr = lng.split(",");
				String[] latarr = lat.split(",");
				ciCore.setLon(DMS(-Double.valueOf(lngarr[0]), -Double.valueOf(lngarr[1]), -Double.valueOf(lngarr[2]))); // 经度-度分秒
				ciCore.setLat(DMS(Double.valueOf(latarr[0]), Double.valueOf(latarr[1]), Double.valueOf(latarr[2]))); // 纬度-度分秒
				// ciCore.setLoc("");
				// ciCore = getCI(year, month, day, hour, minute);
				// 设置功能--系统信息设置（profile属性设置

				Profile profile = new Profile();
				// 坐标系统 false-黄道坐标 true-赤道坐标
				if (sidereal == 0) {
					profile.setSidereal(false);
				} else {
					profile.setSidereal(true);
				}
				profile.setHouseSys(gongid);// 宫制 0-Placidus 1-koch 2-house Asc Sign

				IAstrologCalculatorFactory factory = new AstrologCalculatorFactory();

				IAstrologCalculator calculator = factory.createCalculator(profile, ciCore);
				INatal natal = calculator.calc();

				/*
				 * double[] obj = null; //对应星体角度 double[] alt = null; //预留
				 * double[] dir = null; //行星逆行 double[] cusp =null;
				 * //12宫宫头角度，下标范围1~12 int[] house = null; //各星体所在宫
				 */
				double[] obj = natal.getObj();// 对应星体角度，下标范围0~89，对应枚举类型 // Constants。oEar~Constants.oAnd
				// double[] alt = natal.getAlt();//预留
				double[] dir = natal.getDir();// 行星逆行
				double[] cusp = natal.getCusp(); // 12宫宫头角度，下标范围1~12
				int[] house = natal.getHouse();// 各星体所在宫

				// 如果太阳在夜晚则改变福点的计算规则
				Boolean day_night = EclCon.day_night(cusp[1], obj[1]);
				if (day_night) {// 日生
					double dd = obj[22] + obj[2] - obj[1];
					obj[19] = dd;
				} else {
					double dd = obj[22] + obj[1] - obj[2];
					obj[19] = dd;
				}
				objjson.put("day_night", day_night);
				
				if (type == 0) {//本命盘数据
					objjson.put("status", 1);
					objjson.put("obj", obj);
					objjson.put("cusp", cusp);
					objjson.put("dir", dir);
				}
				if (type == 1) {// TR推运
					objjson.put("status", 1);
					objjson.put("obj", obj);
					objjson.put("cusp", cusp);
					objjson.put("dir", dir);
					objjson.put("house", house);
					String[] arr = new String[obj.length];
					for (int i = 0; i < obj.length; i++) {
						String get_position = EclCon.get_position(cusp[1],
								obj[i]);
						arr[i] = get_position;
					}
					objjson.put("objhouse", arr);// 所属星座,度数
				}
				if (type == 2) {// 太阳弧
					objjson.put("status", 1);
					objjson.put("obj", obj);
					objjson.put("cusp", cusp);
					objjson.put("dir", dir);
				}
				if (type == 3) {// 合盘
					objjson.put("status", 1);
					objjson.put("obj", obj);
					objjson.put("cusp", cusp);
					objjson.put("dir", dir);
				}
				if (type == 4) {// 只取宫位数据
					objjson.put("status", 1);
					objjson.put("cusp", cusp);
				}
				//System.out.println("obj:" + testobj(obj));
				//System.out.println("cusp:" + testobj(cusp));

				// 列表
				List<EclipticBean> get_hdstatus = EclCon.get_hdstatus(cusp[1], obj, dir); // 黄道状态1
				Map<String, List<String>> base_point = BasePoint.base_point(cusp[1], obj); // 本命中点
				Map<String, List<String>> pointStar = BasePoint.pointStar(cusp[1], obj); // 本命中点星耀
				Map<String, List<String>> fadasStarLimited = BasePoint.fadasStarLimited(day_night, cal.getTime());// 法达星限
				
				objjson.put("list1", get_hdstatus);
				objjson.put("list2", get_hdstatus2(obj, dir, cusp[1])); // 黄道状态2
				objjson.put("list4", base_point);
				objjson.put("list5", pointStar);
				objjson.put("list6", fadasStarLimited);
				
			} catch (Exception e) {
				e.printStackTrace();
				objjson.put("status", 0);
			}
		} else {
			objjson.put("status", 0);
		}
		return objjson;
	}
	
	/**
	 * acg世界地图
	 * @param sidereal  坐标系统 false-黄道坐标 true-赤道坐标
	 * @param gongid	宫制 0-Placidus 1-koch 2-house Asc // Sign 3-...
	 * @param zontime	时区
	 * @param lng		经度
	 * @param lat		纬度
	 * @param time		时间
	 * @return
	 */
	public JSONObject getAcg(int sidereal,int gongid,String zontime, String lng, String lat, String time){
		JSONObject objjson = new JSONObject();
		
		if(null == time || null== lng || null==lat || null==zontime){
			return null;
		}
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Calendar cal = Calendar.getInstance();
			Date date = formatter.parse(time);
			cal.setTime(date);
			// 如果是夏令时
			SavingUtil ss = new SavingUtil();
			boolean sav = ss.getSaving(date);
			if (sav) {
				cal.add(Calendar.HOUR_OF_DAY, -1);// 1小时前
			}

			int year = cal.get(Calendar.YEAR);// 获取年份
			int month = cal.get(Calendar.MONTH) + 1;// 获取月份
			int day = cal.get(Calendar.DATE);// 获取日
			int hour = cal.get(Calendar.HOUR_OF_DAY);// 小时
			int minute = cal.get(Calendar.MINUTE);// 分
			CI ciCore1 = getCI(zontime,lng,lat,year, month, day, hour, minute);
			
			Profile profile = new Profile();
			// 坐标系统 false-黄道坐标 true-赤道坐标
			if (sidereal == 0) {
				profile.setSidereal(false);
			} else {
				profile.setSidereal(true);
			}
			profile.setHouseSys(gongid);// 宫制 0-Placidus 1-koch 2-house Asc Sign 3-...
			IAstrologCalculatorFactory factory = new AstrologCalculatorFactory();
			IACGCalculator acgcalculator = factory.createACGCalculator(profile, ciCore1); 
			IACG acg = acgcalculator.calcACG(); 
			WGS84PointF[] z = acg.getZeniths();// 对应星体轨迹天顶点投影坐标 
			WGS84PointF[] n = acg.getNadirs();// 对应星体轨迹天底点投影坐标
			WGS84PointF[] a = acg.getAscs();// 对应星体轨迹上升点投影坐标 
			WGS84PointF[] d = acg.getDscs();// 对应星体轨迹下降点投影坐标
			WGS84PointF[][] as = acg.getAscSets(); 
			WGS84PointF[][] ds = acg.getDscSets();
			
			System.out.println("开始世界地图"); 
			JSONArray jz = testjson(z);
			JSONArray jn = testjson(n); 
			JSONArray ja = testjson(a); 
			JSONArray jd = testjson(d); 
			JSONObject jas = testjson1(as); 
			JSONObject jds = testjson1(ds);
			 
			JSONObject jsonz = new JSONObject();
			jsonz.put("z", jz); 
			jsonz.put("n", jn); 
			jsonz.put("a", ja); 
			jsonz.put("d", jd); 
			jsonz.put("as", jas);
			jsonz.put("ds", jds);
			objjson.put("status", 1);
			objjson.put("acg", jsonz);
		} catch (Exception e) {
			objjson.put("status", -1);
			return null;
		}
		return objjson;
	}

	// 黄道状态2
	private JSONObject get_hdstatus2(double[] obj, double[] dir, double baiy) {
		Constants cc = new Constants();
		// List<String> glist = cc.groupedZodiac(baiy);//划分星座度数区间
		JSONObject json = new JSONObject();
		// 阿拉伯点
		double d = obj[19];
		json.put("good", Constants.get_astindex(d) + "," + d); // 福点
		double spiritual = getSpirit(obj[1], 0.0, obj[2]);
		json.put("spiritual", Constants.get_astindex(spiritual) + ","
				+ spiritual); // 精神点
		double material = getGoods(obj[22], obj[23], obj[23]);
		json.put("material", Constants.get_astindex(material) + "," + material); // 物质点
		double sons = getSons(obj[22], obj[6], obj[2]);
		json.put("male", Constants.get_astindex(sons) + "," + sons); // 儿子点
		double girl = getDaughter(obj[22], obj[4], obj[2]);
		json.put("girl", Constants.get_astindex(girl) + "," + girl); // 女儿点
		// json.put("children", obj[19]);
		// 小行星
		// Constants.get_astindex()
		json.put("chiron", Constants.get_astindex(obj[11]) + "," + obj[11]); // 凯龙星
		json.put("ceres", Constants.get_astindex(obj[12]) + "," + obj[12]); // 谷神星
		json.put("pallas", Constants.get_astindex(obj[13]) + "," + obj[13]); // 智神星
		json.put("juno", Constants.get_astindex(obj[14]) + "," + obj[14]); // 婚神星
		json.put("vesta", Constants.get_astindex(obj[15]) + "," + obj[15]); // 灶神星
		json.put("lilith", Constants.get_astindex(obj[18]) + "," + obj[18]); // 莉莉丝
		return json;
	}

	/**
	 * 儿子点
	 * @param a 上升点
	 * @param b  木星
	 * @param c 月亮
	 * @return
	 */
	private double getSons(double a, double b, double c) {
		return Constants.zh360(a + b - c);
	}

	/**
	 * 女子点
	 * @param a 上升点
	 * @param b  金星
	 * @param c 月亮
	 * @return
	 */
	private double getDaughter(double a, double b, double c) {
		return Constants.zh360(a + b - c);
	}

	/**
	 * 物质点
	 * @param a  上升点
	 * @param b 二宫始
	 * @param c 二宫主度数
	 * @return
	 */
	private double getGoods(double a, double b, double c) {
		return Constants.zh360(a + b - c);
	}

	/**
	 * 精神点
	 * @param a 太阳
	 * @param b 命度
	 * @param c 月亮
	 * @return
	 */
	private double getSpirit(double a, double b, double c) {
		return Constants.zh360(a + b - c);
	}

	/**
	 * 爱情点
	 * @param a 金星
	 * @param b 命度
	 * @param c 太阳
	 * @return
	 */
	private double getLove(double a, double b, double c) {
		return Constants.zh360(a + b - c);
	}

	/**
	 * 婚姻点
	 * @param a 第七宫宫头
	 * @param b 命度
	 * @param c 金星
	 * @return
	 */
	private double getMarriage(double a, double b, double c) {
		return Constants.zh360(a + b - c);
	}

	/*private JSONObject testobj(double[] obj) {
		JSONObject o = new JSONObject();
		for (int i = 0; i < obj.length; i++) {
			o.put(i, obj[i]);
		}
		return o;
	}*/

	private JSONArray testjson(WGS84PointF[] z) {
		JSONArray arr = new JSONArray();
		for (int i = 0; i < z.length; i++) {
			if (null == z[i]) {
				JSONObject oo = new JSONObject();
				oo.put("lon", "");
				oo.put("lat", "");
				arr.add(oo);
			} else {
				JSONObject oo = new JSONObject();
				oo.put("lon", z[i].getLon());
				oo.put("lat", z[i].getLat());
				arr.add(oo);
			}
		}
		return arr;
	}

	private JSONObject testjson1(WGS84PointF[][] z) {
		JSONObject obj = new JSONObject();
		for (int i = 0; i < z.length; i++) {
			if (null == z[i])
				continue;
			WGS84PointF[] zz = z[i];
			JSONArray arr = new JSONArray();
			for (int j = 0; j < zz.length; j++) {
				if (null == zz[j])
					continue;
				JSONObject oo = new JSONObject();
				oo.put("lon", zz[j].getLon());
				oo.put("lat", zz[j].getLat());
				arr.add(oo);
			}
			obj.put(i+"", arr);
		}
		return obj;
	}

	private String get_liujz(Double zon) {
		// System.out.println(11 + 1 / 60.0);
		Double fen = (zon - zon.intValue()) * 60;
		Double miao = (fen - fen.intValue()) * 60;
		return zon.intValue() + "," + fen.intValue() + "," + miao.intValue();
	}

	private String datechange(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String demo = sdf.format(date);
		return demo;
	}

	private double DMS(double d, double m, double s) {
		return (DM(d, m) + (s) / 3600.0);
	}

	private double DM(double d, double m) {
		return ((d) + (m) / 60.0);
	}

	private CI getCI(String zontime, String lng, String lat, int year,
			int month, int day, int hour, int minute) {
		CI cc = new CI();
		cc.setYea(year); // 日期-年
		cc.setMon(month); // 日期-月
		cc.setDay(day); // 日期-日
		cc.setTim(hour + minute / 60.0); // 时间-时分
		String[] spl = zontime.split(":");
		cc.setZon(DMS(-Double.valueOf(spl[0]), -Double.valueOf(spl[1]), -Double.valueOf(spl[2]))); // 时区
		String[] lngarr = lng.split(",");
		String[] latarr = lat.split(",");
		cc.setLon(DMS(-Double.valueOf(lngarr[0]), -Double.valueOf(lngarr[1]), -Double.valueOf(lngarr[2]))); // 经度-度分秒
		cc.setLat(DMS(Double.valueOf(latarr[0]), Double.valueOf(latarr[1]), Double.valueOf(latarr[2]))); // 纬度-度分秒
		return cc;
	}
}
