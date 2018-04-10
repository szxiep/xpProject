package com.business.astrology.util.push;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import com.alibaba.fastjson.JSONObject;
import com.business.astrology.util.Bazi;
import com.business.astrology.util.CharData;
import com.business.astrology.util.Constants;

/**
 * TR(新满月)
 * @author xp
 */
public class TrMoon {
	private CharData cd = new CharData();
	private Bazi bi = new Bazi();
	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	public static void main(String[] args) throws ParseException {
		//
		//new TrMoon().getFirstTime("2000-01-01 00:00", 1000);// 	2050-01-23 12:57
		
		CharData cd = new CharData();
		JSONObject info = cd.getInfo("湖南省衡阳市衡南县", "2000-01-01 00:00");
		String zone = "08:00:00";//info.get("zone").toString();
		String lng = "120,00,00";//info.get("lng").toString();
		String lat = info.get("lat").toString();
		//String ztime = info.get("ztime").toString();
		Double lngTen = Double.valueOf(info.get("lngTen").toString());
		String time = "2001-12-15 04:49";	//  2001-12-15 04:49	270
		Calendar cal = Calendar.getInstance();
		cal.setTime(formatter.parse(time));
		int manHous = 360; //360小时=15天
		//cal.add(Calendar.HOUR_OF_DAY, manHous);//小时制
		
		//Map<String, Object> moonGong = new TrMoon().getMoonGong(lngTen, cal, zone, lng, lat, 1, 0,180) ;
		Map<String, Object> moonGong = new TrMoon().getatarctime(lngTen,Constants.getCalendar(cal), zone, lng, lat, 1, 0,270.0);
		System.out.println(moonGong.get("time"));
	}
	/**
	 * 初一十五
	 * 新月：初一，太阳与月亮发生0度的时候
	 * 满月，十五，太阳与月亮发生180度的时候
	 * @param address   出生地点
	 * @param time		出生时间
	 * @param timeafter	新月时间集
	 * @throws ParseException 
	 */
	public void amissedDate(String address,String time,List<Date> timeafter,Integer sidereal,Integer gongid) throws ParseException{
		//获取 时区，经度，纬度
		JSONObject info = cd.getInfo(address, time);
		String zone = info.get("zone").toString();
		String lng = info.get("lng").toString();
		String lat = info.get("lat").toString();
		String ztime = info.get("ztime").toString();
		
		//内盘
		byte[] ignoreACG = new byte[] { 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, /* Planets */
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, /* Minors */
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, /* Cusps */
				1, 1, 1, 1, 1, 1, 1, 1, 1, /* Uranians */
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, /* Stars */
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		
		//外盘
		byte[] ignoreACG1 = new byte[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, /* Planets */
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, /* Minors */
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, /* Cusps */
				1, 1, 1, 1, 1, 1, 1, 1, 1, /* Uranians */
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, /* Stars */
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		
		//允许相位
		//String[] phase = new String[]{"0,0","180,180","90,270","45,315","135,225"};
		String[] phase = null;
		
		Double lngTen = Double.valueOf(info.get("lngTen").toString());
		
		System.out.println("本命盘时间:"+time+",真太阳时:"+ztime);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(formatter.parse(ztime));
		Map<String, Object> chartContentData = cd.chartContentData(Constants.getCalendar(cal), zone, lng, lat, sidereal, gongid);
		
		double[] obj = (double[]) chartContentData.get("obj");
		double[] cusp = (double[]) chartContentData.get("cusp");
		//double a = obj[1]; 	//日
		//double b = obj[2]; 	//月
		
		Map<String, Object> chartData = new HashMap<String, Object>();
		for (int i = 0; i < timeafter.size(); i++) {
			cal = Calendar.getInstance();
			Date date = timeafter.get(i);	//初一日期
			cal.setTime(date);
			
			//计算真太阳时
			cal = bi.getsunPing(lngTen, cal);
			//计算出新月
			chartData = cd.chartContentData(Constants.getCalendar(cal), zone, lng, lat, sidereal, gongid);
			double[] obj1 = (double[]) chartData.get("obj");
			/*double[] cusp1 = (double[]) chartData.get("cusp");
			double a1 = obj1[1]; 	//日
			double b1 = obj1[2]; 	//月
*/			//int sartTheSart = Constants.getSartTheSart(cusp, b1);
			System.out.println("新月日期:"+formatter.format(cal.getTime()));
			
			ignoreACG[1] = 1;
			//计算新月   外盘对外盘相位
			//List<TrBean> startandStart = AstTrAlgorithm.startandStart1(ignoreACG,ignoreACG1, obj1, obj1, cusp,null, phase, 1);
			//计算新月   外盘对内盘相位
			//List<TrBean> startandStart1 = AstTrAlgorithm.startandStart1(ignoreACG,ignoreACG1, obj1, obj, cusp,null, phase, 1);
			
			/*System.out.println("  外盘对外盘相位");
			//打印
			for (int j = 0; j < startandStart.size(); j++) {
				TrBean trBean = startandStart.get(j);
				System.out.print("      星曜"+trBean.getR1());
				System.out.print("      星曜"+trBean.getR2());
				System.out.print("      相位"+trBean.getR3());
				System.out.print("      宫位"+trBean.getR4());
				System.out.println("      星座"+trBean.getR5());
			}
			System.out.println("  外盘对内盘相位");
			for (int j = 0; j < startandStart1.size(); j++) {
				TrBean trBean = startandStart1.get(j);
				System.out.print("      星曜"+trBean.getR1());
				System.out.print("      星曜"+trBean.getR2());
				System.out.print("      相位"+trBean.getR3());
				System.out.print("      宫位"+trBean.getR4());
				System.out.println("      星座"+trBean.getR5());
			}
			System.out.println();*/
			
			
			//计算满月
			int manHous = 360; //360小时=15天
			cal.add(Calendar.HOUR_OF_DAY, manHous);//小时制
			Map<String, Object> moonGong = getMoonGong(lngTen,Constants.getCalendar(cal), zone, lng, lat, gongid, sidereal,180);
			if(null != moonGong){
				String times = String.valueOf(moonGong.get("time"));
				if(null != times){
					double[] obj2 = (double[]) moonGong.get("obj");
					//double[] cusp2 = (double[]) moonGong.get("cusp");
					//double a2 = obj2[1]; 	//日
					//double b2 = obj2[2]; 	//月
					//int sartTheSart1 = Constants.getSartTheSart(cusp, b2);
					System.out.println("满月日期:"+times);
					ignoreACG[1] = 0;
					//List<TrBean> startandStart2 = AstTrAlgorithm.startandStart1(ignoreACG,ignoreACG1, obj2, obj2, cusp,null, phase, 1);
					//List<TrBean> startandStart3 = AstTrAlgorithm.startandStart1(ignoreACG,ignoreACG1, obj2, obj, cusp,null, phase, 1);
					
					//System.out.println("  外盘对外盘相位");
					//打印
					/*for (int j = 0; j < startandStart2.size(); j++) {
						TrBean trBean = startandStart2.get(j);
						System.out.print("      星曜"+trBean.getR1());
						System.out.print("      星曜"+trBean.getR2());
						System.out.print("      相位"+trBean.getR3());
						System.out.print("      宫位"+trBean.getR4());
						System.out.println("      星座"+trBean.getR5());
					}
					System.out.println("  外盘对内盘相位");
					for (int j = 0; j < startandStart3.size(); j++) {
						TrBean trBean = startandStart3.get(j);
						System.out.print("      星曜"+trBean.getR1());
						System.out.print("      星曜"+trBean.getR2());
						System.out.print("      相位"+trBean.getR3());
						System.out.print("      宫位"+trBean.getR4());
						System.out.println("      星座"+trBean.getR5());
					}
					System.out.println();*/
				}
			}
		}
	}
	
	public void starc(String address,String time,Integer sidereal,Integer gongid) throws ParseException{
		//获取 时区，经度，纬度
		JSONObject info = cd.getInfo(address, time);
		String zone = info.get("zone").toString();
		String lng = info.get("lng").toString();
		String lat = info.get("lat").toString();
		String ztime = info.get("ztime").toString();
		
		Double lngTen = Double.valueOf(info.get("lngTen").toString());
		
		System.out.println("本命盘时间:"+time+",真太阳时:"+ztime);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(formatter.parse(ztime));
		Map<String, Object> chartContentData = cd.chartContentData(Constants.getCalendar(cal), zone, lng, lat, sidereal, gongid);
		
		double[] obj = (double[]) chartContentData.get("obj");
		//double[] cusp = (double[]) chartContentData.get("cusp");
		double a = obj[1]; 	//日
		//double b = obj[2]; 	//月
		
		int manHous = 24*365; //360小时=15天
		cal.add(Calendar.HOUR_OF_DAY, manHous);//小时制
		Map<String, Object> moonGong = getSunGong(lngTen,Constants.getCalendar(cal), zone, lng, lat, gongid, sidereal,a);
		System.out.println(moonGong.get("time"));
	}
	
	//日反
	public Map<String, Object> getSunGong(Double lngTen,Calendar cal ,String zone,String lng,String lat,Integer gongid,Integer sidereal,double NAa) throws ParseException{
		synchronized (cal) {
			//long start = System.currentTimeMillis();
			//计算真太阳时
			cal = bi.getsunPing(lngTen, cal);
			Map<String, Object> datas = cd.chartContentData(Constants.getCalendar(cal), zone, lng, lat, sidereal, gongid);
			double[] obj = (double[]) datas.get("obj");
			double a = obj[1]; 	//日
			//double b = obj[2]; 	//月
			
			/**
			 * 度数相减，相差0.01可以忽略不计
			 * 日月相差14度左右约等于1天
			 * 0.001约等于1分钟
			 * 太阳1度约等于108分钟
			 */
			Map<String, Object> chartData = new HashMap<String, Object>();
			boolean f = true;
			int index = 1;
			
			double mm = 0.0;
			//小范围调整
			while (f) {
				//判断是前进或者后退
				int zf = 1;
				mm = Math.abs(NAa - a);
				if(mm > 180){//跨越了0度
					if(a > NAa){	//
						zf = 1;
					}else{
						zf = -1;
					}
					//判断相差多少度
					mm = 360 - mm;
					
				}else{
					if(a > NAa){
						zf = -1;
					}else{
						zf = 1;
					}
				}
				
				if(mm > 1){
					int znm = (int) (zf*(mm/0.008));
					cal.add(Calendar.MINUTE,znm);		//分
				}else{
					int[] aa = Constants.get_df(a);
					int[] NAbb = Constants.get_df(NAa);
					
					if(aa[0] == NAbb[0] && aa[1] == NAbb[1]){//跳出循环
						f = false;
						chartData.put("time", formatter.format(cal.getTime()));
						//System.out.println("定位成功，花费"+index+"次");
						break;
					}
					
					int an = aa[0];
					int bn = NAbb[0];
					if(an + bn == 29){
						if(an == 0){
							an = 30;
						}
						if(bn == 0){
							bn = 30;
						}
					}
					
					int anum = an*60+aa[1];
					int bnum = bn*60+NAbb[1];
					int abs = Math.abs(anum - bnum);
					/*if(anum > bnum){
						zf = 1;
					}else{
						zf = -1;
					}*/
					//太阳周天度1分约等于24分钟
					cal.add(Calendar.MINUTE, zf*abs *24);
				}
				chartData = cd.chartContentData(Constants.getCalendar(cal), zone, lng, lat,sidereal, gongid);
				double[] obj1 = (double[]) chartData.get("obj");
				a = obj1[1]; 	//日
				//b = obj1[2]; 	//月
				
				//日志
				/*String format = formatter.format(cal.getTime());
				System.out.println("第"+ index +"次定位时间:"+ format );
				System.out.println("a="+a);
				System.out.println("b="+b);*/
				
				index++;
				if(index == 100){	//如果超过100次，则退出。
					f = false;
					chartData.put("time", null);
					break;
				}
			}
			//long end = System.currentTimeMillis();
			//System.out.println("定位成功，花费"+index+"次,用时：" + (end - start) / 1000.0 + " 秒");
			return chartData;
		}
	}
	
	//计算满月	num:180则计算满月
	public Map<String, Object> getMoonGong(Double lngTen,Calendar cal ,String zone,String lng,String lat,Integer gongid,Integer sidereal,int num) throws ParseException{
		synchronized (cal) {
			//long start = System.currentTimeMillis();
			//计算真太阳时
			//System.out.println(formatter.format(cal.getTime()));
			//cal = bi.getsunPing(lngTen, cal);
			Map<String, Object> datas = cd.chartContentData(Constants.getCalendar(cal), zone, lng, lat, 0, 1);
			double[] obj = (double[]) datas.get("obj");
			//double[] cusp = (double[]) datas.get("cusp");
			double a = obj[1]; 	//日
			double b = obj[2]; 	//月
			
			/**
			 * 度数相减，相差0.01可以忽略不计
			 * 日月相差14度左右约等于1天
			 * 0.001约等于1分钟
			 * 太阳1度约等于108分钟
			 */
			Map<String, Object> chartData = new HashMap<String, Object>();
			boolean f = true;
			int index = 1;
			//小范围调整
			while (f) {
				double z = b + num;
				if(z > 360){
					z = z - 360;
				}
				double mm = Math.abs(z - a); //月距离对冲或者合相的差值

				int zf = 1;
				if(mm > 180){
					if(z > a){	//月亮超过了日180度对冲
						zf = 1;
					}else{
						zf = -1;
					}
					mm = 360 - mm;
				}else{
					if(z > a){	//月亮超过了日180度对冲
						zf = -1;
					}else{
						zf = 1;
					}
				}
				
				if(mm > 1){
					int znm = zf*(int)(mm/0.008);
					cal.add(Calendar.MINUTE,znm);		//分
				}else{
					int[] aa = Constants.get_df(a);
					int[] bb = Constants.get_df(b);
					
					if(aa[0] == bb[0] && aa[1] == bb[1]){//跳出循环
						f = false;
						chartData.put("time", formatter.format(cal.getTime()));
						chartData.put("cal", cal);
						
						//System.out.println("定位成功，花费"+index+"次");
						break;
					}
					
					int an = aa[0];
					int bn = bb[0];
					if(an + bn == 29){
						if(an == 0){
							an = 30;
						}
						if(bn == 0){
							bn = 30;
						}
					}
					
					int anum = an*60+aa[1];
					int bnum = bn*60+bb[1];
					int abs = Math.abs(anum - bnum);
					/*if(anum > bnum){
						zf = 1;
					}else{
						zf = -1;
					}*/
					cal.add(Calendar.MINUTE, zf*abs);
				}
				chartData = cd.chartContentData(Constants.getCalendar(cal), zone, lng, lat,sidereal, gongid);
				double[] obj1 = (double[]) chartData.get("obj");
				a = obj1[1]; 	//日
				b = obj1[2]; 	//月
				
				//日志
				/*String format = formatter.format(cal.getTime());
				System.out.println("第"+ index +"次定位时间:"+ format );
				System.out.println("a="+a);
				System.out.println("b="+b);*/
				
				index++;
				if(index == 100){	//如果超过100次，则退出。
					f = false;
					chartData.put("time", null);
					chartData.put("cal", null);
					break;
				}
			}
			//long end = System.currentTimeMillis();
			//System.out.println("定位成功，花费"+index+"次,用时：" + (end - start) / 1000.0 + " 秒");
			return chartData;
		}
	}
	
	//计算日往前走所需时间
	public Map<String, Object> getatarctime(Double lngTen,Calendar cal ,String zone,String lng,String lat,Integer gongid,Integer sidereal,Double b) throws ParseException{
		synchronized (cal) {
			//long start = System.currentTimeMillis();
			//计算真太阳时
			//System.out.println(formatter.format(cal.getTime()));
			//cal = bi.getsunPing(lngTen, cal);
			Map<String, Object> datas = cd.chartContentData(Constants.getCalendar(cal), zone, lng, lat, 0, 1);
			double[] obj = (double[]) datas.get("obj");
			//double[] cusp = (double[]) datas.get("cusp");
			double a = obj[1]; 	//日
			//double b = obj[2]; 	//月
			
			/**
			 * 度数相减，相差0.01可以忽略不计
			 * 日月相差14度左右约等于1天
			 * 0.001约等于1分钟
			 * 太阳1度约等于108分钟
			 */
			Map<String, Object> chartData = new HashMap<String, Object>();
			boolean f = true;
			int index = 1;
			//小范围调整
			while (f) {
				/*double z = b + num;
				if(z > 360){
					z = z - 360;
				}*/
				double mm = Math.abs(b - a); //月距离对冲或者合相的差值

				int zf = 1;
				if(mm > 180){
					/*if(b > a){	//月亮超过了日180度对冲
						zf = 1;
					}else{
						zf = -1;
					}*/
					mm = 360 - mm;
				}else{
					/*if(a > b){	//月亮超过了日180度对冲
						zf = -1;
					}else{
						zf = 1;
					}*/
				}
				
				if(mm > 1){
					int znm = zf*(int)(mm/0.008 *10);
					cal.add(Calendar.MINUTE,znm);		//分
				}else{
					int[] aa = Constants.get_df(a);
					int[] bb = Constants.get_df(b);
					
					if(aa[0] == bb[0] && aa[1] == bb[1]){//跳出循环
						f = false;
						chartData.put("time", formatter.format(cal.getTime()));
						chartData.put("cal", cal);
						
						//System.out.println("定位成功，花费"+index+"次");
						break;
					}
					
					int an = aa[0];
					int bn = bb[0];
					if(an + bn == 29){
						if(an == 0){
							an = 30;
						}
						if(bn == 0){
							bn = 30;
						}
					}
					
					int anum = an*60+aa[1];
					int bnum = bn*60+bb[1];
					int abs = Math.abs(anum - bnum);
					/*if(anum > bnum){
						zf = 1;
					}else{
						zf = -1;
					}*/
					cal.add(Calendar.MINUTE, zf*abs*10);
				}
				chartData = cd.chartContentData(Constants.getCalendar(cal), zone, lng, lat,sidereal, gongid);
				double[] obj1 = (double[]) chartData.get("obj");
				a = obj1[1]; 	//日
				//b = obj1[2]; 	//月
				
				//日志
				/*String format = formatter.format(cal.getTime());
				System.out.println("第"+ index +"次定位时间:"+ format );
				System.out.println("a="+a);
				System.out.println("b="+b);*/
				
				index++;
				if(index == 100){	//如果超过100次，则退出。
					f = false;
					chartData.put("time", null);
					chartData.put("cal", null);
					break;
				}
			}
			//long end = System.currentTimeMillis();
			//System.out.println("定位成功，花费"+index+"次,用时：" + (end - start) / 1000.0 + " 秒");
			return chartData;
		}
	}
	
	//月反
	public Map<String, Object> MoonGong(Double lngTen,Calendar cal ,String zone,String lng,String lat,Integer gongid,Integer sidereal,double NAb) throws ParseException{
		synchronized (cal) {
			//long start = System.currentTimeMillis();
			//计算真太阳时
			cal = bi.getsunPing(lngTen, cal);
			Map<String, Object> datas = cd.chartContentData(Constants.getCalendar(cal), zone, lng, lat, sidereal, gongid);
			double[] obj = (double[]) datas.get("obj");
			double b = obj[2]; 	//月
			
			Map<String, Object> chartData = new HashMap<String, Object>();
			boolean f = true;
			int index = 1;
			double mm = 0.0;
			//小范围调整
			while (f) {
				//判断是前进或者后退
				int zf = 1;
				mm = Math.abs(NAb - b);
				if(mm > 180){//跨越了0度
					if(b > NAb){	//
						zf = 1;
					}else{
						zf = -1;
					}
					//判断相差多少度
					mm = 360 - mm;
					
				}else{
					if(b > NAb){
						zf = -1;
					}else{
						zf = 1;
					}
				}
				
				if(mm > 1){
					int znm = (int) (zf*(mm/0.008));
					cal.add(Calendar.MINUTE,znm);		//分
				}else{
					int[] aa = Constants.get_df(b);
					int[] NAbb = Constants.get_df(NAb);
					
					if(aa[0] == NAbb[0] && aa[1] == NAbb[1]){//跳出循环
						f = false;
						chartData.put("time", formatter.format(cal.getTime()));
						//System.out.println("定位成功，花费"+index+"次");
						break;
					}
					
					int an = aa[0];
					int bn = NAbb[0];
					if(an + bn == 29){
						if(an == 0){
							an = 30;
						}
						if(bn == 0){
							bn = 30;
						}
					}
					int anum = an*60+aa[1];
					int bnum = bn*60+NAbb[1];
					int abs = Math.abs(anum - bnum);
					cal.add(Calendar.MINUTE, zf*abs);
				}
				chartData = cd.chartContentData(Constants.getCalendar(cal), zone, lng, lat,sidereal, gongid);
				double[] obj1 = (double[]) chartData.get("obj");
				b = obj1[2]; 	//月
				
				//日志
				/*String format = formatter.format(cal.getTime());
				System.out.println("第"+ index +"次定位时间:"+ format );
				System.out.println("a="+a);
				System.out.println("b="+b);*/
				
				index++;
				if(index == 100){	//如果超过100次，则退出。
					f = false;
					chartData.put("time", null);
					break;
				}
			}
			//long end = System.currentTimeMillis();
			//System.out.println("定位成功，花费"+index+"次,用时：" + (end - start) / 1000.0 + " 秒");
			return chartData;
		}
	}
	
	//八字用到
	private Map<String, Object> getfirstMoon(Double lngTen,Calendar cal ,String zone,String lng,String lat,Integer gongid,Integer sidereal) throws ParseException{
		//synchronized (cal) {
			//long start = System.currentTimeMillis();
			//计算真太阳时
			cal = bi.getsunPing(lngTen, cal);
			//System.out.println(formatter.format(cal.getTime()));
			Map<String, Object> datas = cd.chartContentData(Constants.getCalendar(cal), zone, lng, lat, sidereal, gongid);
			double[] obj = (double[]) datas.get("obj");
			//double[] cusp = (double[]) datas.get("cusp");
			double a = obj[1]; 	//日
			double b = obj[2]; 	//月
			
			/**
			 * 度数相减，相差0.01可以忽略不计
			 * 日月相差14度左右约等于1天
			 * 0.001约等于1分钟
			 * 太阳1度约等于108分钟
			 */
			Map<String, Object> chartData = new HashMap<String, Object>();
			boolean f = true;
			int index = 1;
			//小范围调整
			while (f) {
				double mm = Math.abs(a - b); //月距离对冲或者合相的差值

				int zf = 1;
				if(mm > 180){
					if(b > a){	//月亮超过了日180度对冲
						zf = 1;
					}else{
						zf = -1;
					}
					mm = 360 - mm;
				}else{
					if(b > a){	//月亮超过了日180度对冲
						zf = -1;
					}else{
						zf = 1;
					}
				}
				
				if(mm > 1){
					int znm = zf*(int)(mm/0.008);
					cal.add(Calendar.MINUTE,znm);		//分
				}else{
					int[] aa = Constants.get_df(a);
					int[] bb = Constants.get_df(b);
					
					if(aa[0] == bb[0] && aa[1] == bb[1]){//跳出循环
						f = false;
						chartData.put("time", formatter.format(cal.getTime()));
						chartData.put("cal", cal);
						
						//System.out.println("定位成功，花费"+index+"次");
						break;
					}
					
					int an = aa[0];
					int bn = bb[0];
					if(an + bn == 29){
						if(an == 0){
							an = 30;
						}
						if(bn == 0){
							bn = 30;
						}
					}
					
					int anum = an*60+aa[1];
					int bnum = bn*60+bb[1];
					int abs = Math.abs(anum - bnum);
					/*if(anum > bnum){
						zf = 1;
					}else{
						zf = -1;
					}*/
					cal.add(Calendar.MINUTE, zf*abs);
				}
				chartData = cd.chartContentData(Constants.getCalendar(cal), zone, lng, lat,sidereal, gongid);
				double[] obj1 = (double[]) chartData.get("obj");
				a = obj1[1]; 	//日
				b = obj1[2]; 	//月
				
				//日志
				/*String format = formatter.format(cal.getTime());
				System.out.println("第"+ index +"次定位时间:"+ format );
				System.out.println("a="+a);
				System.out.println("b="+b);*/
				
				index++;
				if(index == 100){	//如果超过100次，则退出。
					f = false;
					chartData.put("time", null);
					chartData.put("cal", null);
					break;
				}
			}
			//long end = System.currentTimeMillis();
			//System.out.println("定位成功，花费"+index+"次,用时：" + (end - start) / 1000.0 + " 秒");
			return chartData;
		//}
	}
	
	/**
	 * 如果从2050-01-23 12:57 开始循环往下推，25122次到终点.
	 * @param time 
	 * @param num	循环次数
	 * @throws ParseException
	 */
	public List<String> getFirstTime(String time,int num) throws ParseException{
		List<String> list = new ArrayList<String>();
		Integer sidereal = 1;
		
		Integer gongid = 1;
		//获取 时区，经度，纬度
		JSONObject info = cd.getInfo("湖南省衡阳市衡南县", time);
		String zone = "08:00:00";//info.get("zone").toString();
		String lng = "120,00,00";//info.get("lng").toString();
		String lat = info.get("lat").toString();
		//String ztime = info.get("ztime").toString();
		
		Double lngTen = Double.valueOf(info.get("lngTen").toString());
		
		//System.out.println("第1个新月时间:"+time);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(formatter.parse(time));
		
		int manHous = -(int)(29.5*24); //360小时=15天
		int haom = (int)(29.5 * 24 * 60 * 60 *1000);
		for(int i =0;i<num;i++){
			
			//cal.add(Calendar.HOUR_OF_DAY, manHous);//小时制
			long time2 = cal.getTime().getTime() + haom;
			Date da = new Date(time2);
			cal.setTime(da);
			
			/*if(i == 212 || i ==213){
				System.out.println(12345);
				System.out.println(formatter.format(cal.getTime()));
			}*/
			Map<String, Object> moonGong1 = getfirstMoon(lngTen, Constants.getCalendar(cal), zone, lng, lat, gongid, sidereal);
			if(null != moonGong1){
				String times = String.valueOf(moonGong1.get("time"));
				cal = (Calendar)moonGong1.get("cal");
				if(null != times){
					list.add(times);
					System.out.println("第"+i+"个新月时间:"+times);
					cal.setTime(formatter.parse(times));
				}
			}
		}
		return list;
	}
	
	public double[] getlv(int index){
		double[] a = new double[2];
		if(index == 1){	//日
			a[0] = 0.008;
			a[1] = 24;
		}
		if(index == 2){	//月
			a[0] = 0.008;
			a[1] = 1;
		}
		if(index == 3){	//水
			a[0] = 1;
			a[1] = 30;
		}
		if(index == 4){	//金
			a[0] = 1;
			a[1] = 20;
		}
		if(index == 5){	//火
			a[0] = 1;
			a[1] = 40;
		}
		if(index == 6){	//木
			a[0] = 1;
			a[1] = 135;
		}
		if(index == 7){	//土  11小时 
			a[0] = 1;
			a[1] = 20;
		}
		if(index == 8){	//天王   快的话6小时走1分,逆行可能60小时
			a[0] = 1;
			a[1] = 20;
		}
		if(index == 9){	//海王 16小时走1分
			a[0] = 0.001;
			a[1] = 16 * 60;
		}
		if(index == 10){//冥王    10小时30分走1分
			a[0] = 0.0002;
			a[1] = 10 * 60 + 30;
		}
		return a;
	}
	
}
