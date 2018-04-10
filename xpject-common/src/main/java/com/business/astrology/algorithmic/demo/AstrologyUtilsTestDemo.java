package com.business.astrology.algorithmic.demo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.business.astrology.algorithmic.api.IACG;
import com.business.astrology.algorithmic.api.IACGCalculator;
import com.business.astrology.algorithmic.api.IAstrologCalculator;
import com.business.astrology.algorithmic.api.IAstrologCalculatorFactory;
import com.business.astrology.algorithmic.api.INatal;
import com.business.astrology.algorithmic.bean.CI;
import com.business.astrology.algorithmic.bean.Profile;
import com.business.astrology.algorithmic.bean.WGS84PointF;
import com.business.astrology.algorithmic.factory.AstrologCalculatorFactory;

public class AstrologyUtilsTestDemo {

	public static double DM(double d, double m) {
		return ((d) + (m) / 60.0);
	}

	public static double DMS(double d, double m, double s) {
		return (DM(d, m) + (s) / 3600.0);
	}

	public static double ZD(double z, double d) {
		return ((double) (((z) - 1) * 30) + (d));
	}

	public static void main(String[] args) {
		System.out.println("AstrologyUtils Test");

		Profile profile = new Profile();
		CI ciCore = new CI();
		// 录入功能
		/*ciCore.setYea(2017); // 日期-年
		ciCore.setMon(8); // 日期-月
		ciCore.setDay(8); // 日期-日
		ciCore.setTim(20 + 24 / 60.0); // 时间-时分
		ciCore.setDst(0.0);
		ciCore.setZon(-7.5); // 时区
		ciCore.setLon(DMS(-106, -19, -4)); //经度-度分秒
		ciCowre.setLat(DMS(30, 07, 07)); //纬度-度分秒
		ciCore.setNam("");
		ciCore.setLoc("");*/
		
		ciCore.setYea(1582); // 日期-年
		ciCore.setMon(10); // 日期-月
		ciCore.setDay(16); // 日期-日
		ciCore.setTim(23.0D + 16 / 60.0D); // 时间-时分
		ciCore.setDst(0.0D);
		//ciCore.setZon(DMS(-6,-50,-04)); // 时区
		ciCore.setZon(-6.833333333333335D); // 时区
		ciCore.setLon(DMS(-102.0D, -38.0D, -57.0D)); //经度-度分秒
		ciCore.setLat(DMS(25.0D, 15.0D, 40.0D)); //纬度-度分秒
		ciCore.setNam("");
		ciCore.setLoc("");

		// 设置功能--系统信息设置（profile属性设置） 
		profile.setSidereal(true);//坐标系统 false-恒星黄道坐标  true-回归黄道坐标
		profile.setHouseSys(1);//宫制 0-Placidus 1-koch 2-house Asc Sign 3-...

		IAstrologCalculatorFactory factory = new AstrologCalculatorFactory();
		IAstrologCalculator calculator = factory.createCalculator(profile, ciCore);
		INatal natal = calculator.calc();
//		
		double[] obj = natal.getObj();//对应星体黄道角度，下标范围0~89，对应枚举类型 Constants。oEar~Constants.oAnd
//		double[] alt = natal.getAlt();//对应星体赤纬
		double[] dir = natal.getDir();//行星逆行角速度
		double[] cusp = natal.getCusp(); // 12宫宫头角度，下标范围1~12
//		int[] house = natal.getHouse();//预留
		System.out.println("月:"+obj[2]);
		//"1":253.45795285199702,"2":285.3963832405892,"3":320.8542430565649,"4":355.8478536297275,
		//"1":253.45795285199702,"2"+:283.457952851997,"3":313.457952851997,"4":343.457952851997,"5":13.457952851996993,
		
		
		/*System.out.println("obj:   "+textjson2(obj));
		System.out.println(dir.toString());
		System.out.println("cusp:  "+textjson2(cusp));*/
		
		IACGCalculator acgcalculator = factory.createACGCalculator(profile, ciCore);
		IACG acg = acgcalculator.calcACG();
		
		WGS84PointF[] z = acg.getZeniths();//对应星体轨迹天顶点投影坐标
		WGS84PointF[] n = acg.getNadirs();//对应星体轨迹天底点投影坐标
		WGS84PointF[] a = acg.getAscs();//对应星体轨迹上升点投影坐标
		WGS84PointF[] d = acg.getDscs();//对应星体轨迹下降点投影坐标
		WGS84PointF[][] as = acg.getAscSets();
		WGS84PointF[][] ds = acg.getDscSets();

		assert (null != acg);

		/*System.out.println("z= "+testjson(z));
		System.out.println("n= "+testjson(n));
		System.out.println("a= "+testjson(a));
		System.out.println("d= "+testjson(d));
		System.out.println("as= "+testjson1(as));
		System.out.println("ds= "+testjson1(ds));*/
		
	}

	private static String textjson2(double[] d){
		JSONObject obj = new JSONObject();
		for (int i = 0; i < d.length; i++) {
			obj.put(i, d[i]);
		}
		return obj.toString();
	}
	
	private static String testjson(WGS84PointF[] z){
		JSONArray arr = new JSONArray();
		for (int i = 1; i < z.length; i++) {
			if(null==z[i])
				continue;
			JSONObject oo = new JSONObject();
			oo.put("lon", z[i].getLon());
			oo.put("lat", z[i].getLat());
			arr.add(oo);
		}
		return arr.toString();
	}
	
	private static String testjson1(WGS84PointF[][] z){
		JSONObject obj = new JSONObject();
		for (int i = 1; i < z.length; i++) {
			if(null==z[i])
				continue;
			WGS84PointF[] zz = z[i];
			JSONArray arr = new JSONArray();
			for(int j = 0;j<zz.length;j++){
				if(null == zz[j])
					continue;
				JSONObject oo = new JSONObject();
				oo.put("lon", zz[j].getLon());
				oo.put("lat", zz[j].getLat());
				arr.add(oo);
			}
			obj.put(i, arr);
		}
		return obj.toString();
	}
	
	public static String get_liujz(Double zon) {
		Double fen = (zon-zon.intValue()) *60;
		Double miao = (fen-fen.intValue()) *60;
		return zon.intValue()+"°"+fen.intValue()+"′"+miao.intValue()+"″";
	}
}