package com.business.astrology.util;

import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * 公共参数,函数
 * @author xp
 */
public class Constants {
	
	public static void main(String[] args) {
		JSONObject j1 = new JSONObject();
		j1.put("name", "qqqq");  
		j1.put("age", "24");  
        
		JSONObject j2 = new JSONObject();
		j2.put("name", "wwwwww");  
		j2.put("age1", "241");
		
		j1.putAll(j2);
		System.out.println(j1.toString());
	}
	
	
	/**
	 * 每种类型分男女,男:b,女:g
	 */
	
	//性格
	/**
	 * 本我,社会面具,潜意识,一句话概括,闪光点,兴趣爱好,社交展现,温馨忠告
	 */
	public static final String[] X_XGSTRARR = new String[]{"cy1","cy2","cy3","cy4","cy5","cy6","cy7","cy8"};
	public static final int[] X_XGIDARR_B = new int[]{100,101,102,154,104,105,106,107};
	public static final int[] X_XGIDARR_G = new int[]{100,101,102,154,104,105,106,107};
	////////财运
	/**
	 * 财值风险,财运解析,爆发机会,合作收益,博彩收益,房产投资,证券投资,风险投资,收藏投资,遗产赠予,储蓄保险,经营收益,薪金收益
	 */
	public static final String[] X_CYSTRARR = new String[]{"cy1","cy2","cy3","cy4","cy5","cy6","cy7","cy8","cy9","cy10","cy11","cy12","cy13"};
	public static final int[] X_CYIDARR_B = new int[]{38,18,108,159,158,157,160,155,37,36,35,21,20};
	public static final int[] X_CYIDARR_G = new int[]{38,18,108,159,158,157,160,155,37,36,35,21,20};
	////////情感
	/**
	 * 适合恋爱的	年份适合结婚的年份  ,在 TR类型里	（恋爱时机  没了）
	 * 喜欢的他，适合的他(分男女)
	 * 魅力,爱情分析,恋爱态度,恋爱风格,魅力展现,喜欢的他,适合的他,太阳星座优秀,月亮星座优秀,适合恋爱的年份,适合结婚的年份,
	 * 恋爱时机,桃花,愉悦,稳定,欲望,旺夫,宠妻,太阳星座良好,月亮星座良好,太阳星座尚可,月亮星座尚可
	 */
	public static final String[] X_QGSTRARR = new String[]{"cy1","cy2","cy3","cy4","cy5","cy6","cy7","cy8","cy9","cy10","cy11","cy12","cy13","cy14","cy15","cy16","cy17","cy18","cy19","cy20","cy21","cy22"};
	public static final int[] X_QGIDARR_B = new int[]{45,117,118,119,122,121,124,125,126,147,148,127,46,47,51,113,114,115,162,163,164,165};
	public static final int[] X_QGIDARR_G = new int[]{45,117,118,119,122,120,123,125,126,147,148,127,46,47,51,113,114,115,162,163,164,165};
	////////事业
	/**
	 * 适宜从事行业,有利事业星座，有利团队星座，有利人脉星座,事业分析,责任感,执行力,沟通能力,应急能力,团队协作
	 */
	public static final String[] X_SYSTRARR = new String[]{"cy1","cy2","cy3","cy4","cy5","cy6","cy7","cy8","cy9","cy10"};
	public static final int[] X_SYIDARR_B = new int[]{111,112,152,153,11,131,132,133,134,66};
	public static final int[] X_SYIDARR_G = new int[]{111,112,152,153,11,131,132,133,134,66};
	////////健康
	/**
	 * 需要注意的问题及部位,恢复能力,免疫能力,适宜食品,呼吸系统,消化系统,神经系统,泌尿生殖系统,血循环系统
	 */
	public static final String[] X_JKSTRARR = new String[]{"cy1","cy2","cy3","cy4","cy5","cy6","cy7","cy8","cy9"};
	public static final int[] X_JKIDARR_B = new int[]{129,130,144,0,137,138,139,140,143};
	public static final int[] X_JKIDARR_G = new int[]{129,130,144,0,137,138,139,140,143};
	
	
	////////////////////////////TR
	/**'
	 * 日运
	 * 财运,情感(通用),事业,出行,健康,情感(分男女),健康（男女）
	 */
	public static final String[] T_RIARR = new String[]{"cy1","cy2","cy3","cy4","cy5","cy2","cy5"};
	public static final String[] T_RIARR1 = new String[]{"yy1","yy2","yy3","yy4","yy5","yy2","yy5"};
	public static final int[] T_RIARR_B = new int[]{94,96,95,179,97,173,218};
	public static final int[] T_RIARR_G = new int[]{94,96,95,179,97,174,180};
	
	/**
	 * 月运
	 * 财运,情感(通用),事业,出行,健康,情感(分男女),健康（男女）
	 */
	public static final String[] T_MYARR = new String[]{"cy1","cy2","cy3","cy4","cy5","cy2","cy5"};
	public static final String[] T_MYARR1 = new String[]{"yy1","yy2","yy3","yy4","yy5","yy2","yy5"};
	public static final int[] T_MYARR_B = new int[]{204,205,203,207,206,216,214};
	public static final int[] T_MYARR_G = new int[]{204,205,203,207,206,217,215};
	
	/**
	 * 新满月(月运分支)
	 * 财运,情感(通用),事业,出行,健康,情感(分男女),健康（男女）
	 */
	public static final String[] T_NMYARR = new String[]{"cy1","cy2","cy3","cy4","cy5","cy2","cy5"};
	public static final int[] T_NMYARR_B = new int[]{169,170,168,172,171,182,220};
	public static final int[] T_NMYARR_G = new int[]{169,170,168,172,171,183,184};
	
	/**
	 * 年运
	 * 财运,情感(通用),事业,健康,情感(分男女),健康（男女）
	 */
	public static final String[] T_NYARR = new String[]{"cy1","cy2","cy3","cy4","cy2","cy4"};
	public static final String[] T_NYARR1 = new String[]{"yy1","yy2","yy3","yy4","yy2","yy4"};
	public static final int[] T_NYARR_B = new int[]{191,194,190,192,195,212};
	public static final int[] T_NYARR_G = new int[]{191,194,190,192,196,193};
	
	/**
	 * 大运
	 * 财运,情感(通用),事业,健康,情感(分男女),健康（男女）
	 */
	public static final String[] T_DYARR = new String[]{"cy1","cy2","cy3","cy4","cy2","cy4"};
	public static final String[] T_DYARR1 = new String[]{"yy1","yy2","yy3","yy4","yy2","yy4"};
	public static final int[] T_DYARR_B = new int[]{200,201,199,202,210,208};
	public static final int[] T_DYARR_G = new int[]{200,201,199,202,211,209};
	
	//临时财运
	public static String tempTxt1 = "得失之间，需要以平常心处之；须知塞翁失马，焉知非福。";
	//临时情感
	public static String tempTxt2 = "充分调整好自己的身心状态，才能去面对好一段关系。";
	//临时事业
	public static String tempTxt3 = "《易》曰：“战战兢兢，如履薄冰”，小心使得万年船，谨慎行事为佳。";
	//临时健康
	public static String tempTxt4 = "饮食起居有度，适度运动与静养结合，多听碱性音乐，让情绪平和，有百利而无一害。";
		
	public static final int sAri = 1;     	//白羊
	public static final int sTau = 2;	  	//金牛
	public static final int sGem = 3;	    //双子
	public static final int sCan = 4;		//巨蟹
	public static final int sLeo = 5;		//狮子
	public static final int sVir = 6;		//处女
	public static final int sLib = 7;		//天枰
	public static final int sSco = 8;		//天蝎
	public static final int sSag = 9;		//射手
	public static final int sCap = 10;		//摩羯
	public static final int sAqu = 11;		//水瓶
	public static final int sPis = 12;		//双鱼
	
	public static String getConste(int index){
		String str = "";
		if(index == 1){
			str = "白羊座";
		}
		if(index == 2){
			str = "金牛座";
		}
		if(index == 3){
			str = "双子座";
		}
		if(index == 4){
			str = "巨蟹座";
		}
		if(index == 5){
			str = "狮子座";
		}
		if(index == 6){
			str = "处女座";
		}
		if(index == 7){
			str = "天秤座";
		}
		if(index == 8){
			str = "天蝎座";
		}
		if(index == 9){
			str = "射手座";
		}
		if(index == 10){
			str = "摩羯座";
		}
		if(index == 11){
			str = "水瓶座";
		}
		if(index == 12){
			str = "双鱼座";
		}
		return str;
	}
	
	//0表示计算，1表示不计算
	public static final byte[] ignoreACG = new byte[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, /* Planets */
			1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, /* Minors */
			1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, /* Cusps */
			1, 1, 1, 1, 1, 1, 1, 1, 1, /* Uranians */
			1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, /* Stars */
			1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
	
	/**
	 * 星耀中点容许度 正负
	 */
	public static double MSAD = 2.5;
	/**
	 * 星耀中点相位计算点
	 */
	public static int[] phase1 = new int[]{0,180,90,45,135};
	public static int[] phase2 = new int[]{0,180,270,315,225};
	
	
	public static int get_astindex(double d){
		d = zh360(d);
		int index = 0;
		if(0 < d && d < 30){
			index = 1;
		}
		if(30 < d && d < 60){
			index = 2;
		}
		if(60 < d && d < 90){
			index = 3;
		}
		if(90 < d && d < 120){
			index = 4;
		}
		if(120 < d && d < 150){
			index = 5;
		}
		if(150 < d && d < 180){
			index = 6;
		}
		if(180 < d && d < 210){
			index = 7;
		}
		if(210 < d && d < 240){
			index = 8;
		}
		if(240 < d && d < 270){
			index = 9;
		}
		if(270 < d && d < 300){
			index = 10;
		}
		if(300 < d && d < 330){
			index = 11;
		}
		if(330 < d && d < 360){
			index = 12;
		}
		return index;
	}
	
	public static double zh360(double d){
		int n = Math.abs((int)(d/360));
		if(n ==0)
			n =1;
		if(d >360){
			d = d - n *360;
		}
		if(d < 0){
			d = d + (n+1) *360;
		}
		return d;
	}
	
	/**
	 * 根据度数判断在哪个星座
	 * @param d
	 * @return 星座索引
	 */
	public static int whoConstellation(double d){
		return (int) Math.ceil(d/30);
	}
	
	/**
	 * 返回度数d在cusp哪个宫位内
	 * @param cusp
	 * @param d
	 */
	public static int getSartTheSart(double[] cusp,double d){
		/*cusp=new double[]{0.0, 
						273.3990507941221, 
						305.82335365170417, 
						343.11179315457093, 
						18.824687056856497, 
						42.25078581839464, 
						66.38989904472226, 
						93.39905079412208, 
						125.82335365170408, 
						163.11179315457102, 
						198.82468705685648, 
						222.2507858183946, 
						246.3898990447222};*/
		for (int i = 1; i < cusp.length-1; i++) {
			double e1 = cusp[i];
			double e2 = cusp[i+1];
			
			double abs = Math.abs(e1 -e2);
			if(abs > 180){  //第1宫与12宫之间
				if(e1 < d || d < e2){
					return i;
				}
			}else{
				if(e1 <= d && d < e2){
					return i;
				}
			}
		}
		return 12;
	}
	
	/**
	 * 计算相位（na）
	 * @param a		星耀a
	 * @param b		星耀b
	 * @param phase 需计算的相位数组
	 * @param r		容许度
	 * @return null=没有发生相位，否则反之
	 */
	public static String calculationNaPhase(double a,double b,String[] phase){
		if(null != phase){
			double abs = Math.abs(a - b);
			for (int i = 0; i < phase.length; i++) {
				String[] parr = phase[i].split("_");
				
				String[] xw = parr[0].split(",");	//相位
				double r = Double.valueOf(parr[1]);	//容许度
				
				for (int k = 0; k < xw.length; k++) {
					double val = abs - Double.valueOf(xw[k]);
					if(-r < val && val < r){
						return xw[k];
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * 计算相位（tr）
	 * @param a		星耀a
	 * @param b		星耀b
	 * @param phase 需计算的相位数组
	 * @param r		容许度
	 * @return null=没有发生相位，否则反之
	 */
	public static String[] calculationPhase(double a,double b,String[] phase,double r){
		if(null != phase){
			String[] str = new String[2];
			double abs = Math.abs(a - b);
			for (int i = 0; i < phase.length; i++) {
				int j = 0;
				String[] parr = phase[i].split(",");
				if(parr[0].equals(parr[1])){
					j = 1;
				}
				for (j = 0; j < parr.length; j++) {
					double val = abs - Double.valueOf(parr[j]);
					if(-r < val && val < r){
						str[0] = parr[j];
						str[1] = val+"";
						return str;
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * 返回守护宫主星耀
	 * @param index  第一宫头星座
	 */
	/*public static Map<String,String> getGustTopxz(int index){
		int[] xzarr = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12};
		String[] xxarr = new String[]{"0","5","4","3","2","1","3","4","5,10","6","7","7,8","6,9"};
		Map<String,String> map = new HashMap<String,String>();
		
		for (int i = 0; i < 12; i++) {
			int a = i + index;
			if(a >12){
				a = a - 12;
			}
			String str = xxarr[xzarr[a]];
			map.put(a+"", str);
		}
		return map;
	}*/
	
	/**
	 * 转换度分格式
	 * @param str
	 * @return
	 */
	public static int[] get_df(Double str){
		int[] arr = new int[3];
		Double s = str%30;
		Double m = (s - s.intValue())*60;//分
	    //var ms=(m-parseInt(m))*60;
	    /*if(ms >30){
	        m+=1;
	    }*/
		arr[0] = Math.abs(s.intValue());
		arr[1] = Math.abs(m.intValue());
		//arr[2] = Math.abs(s.intValue() + m.intValue());
	    return arr;
	}
	
	/**
	 * 保留1位小数
	 * @param f
	 */
	public static Double m1(Double f) {
		DecimalFormat df = new DecimalFormat("#.0");
		return Double.valueOf(df.format(f));
	}
	
	/**
	 * 保留2位小数
	 * @param f
	 */
	public static Double m2(Double f) {
		DecimalFormat df = new DecimalFormat("#.00");
		return Double.valueOf(df.format(f));
	}
	
	/**
	 * 保留3位小数
	 * @param f
	 */
	public static Double m3(Double f) {
		DecimalFormat df = new DecimalFormat("#.000");
		return Double.valueOf(df.format(f));
	}
	
	/**
	 * 根据星座返回守护星耀
	 * @param StarIndex	星座
	 * @return 守护星曜
	 */
	public static Integer GuardStar(int StarIndex){
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		map.put(1, 5);
		map.put(2, 4);
		map.put(3, 3);
		map.put(4, 2);
		map.put(5, 1);
		map.put(6, 3);
		map.put(7, 4);
		map.put(8, 5);
		map.put(9, 6);
		map.put(10, 7);
		map.put(11, 7);
		map.put(12, 6);
		return map.get(StarIndex);
	}
	
	/**
	 * 根据星耀返回守护宫
	 * @param StarIndex	星曜
	 * @return 星座Index
	 */
	public static String StarGong(int StarIndex){
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(1, "5");
		map.put(2, "4");
		map.put(3, "3/6");
		map.put(4, "2/7");
		map.put(5, "1/8");
		map.put(6, "9/12");
		map.put(7, "10/11");
		return map.get(StarIndex);
	}
	
	public static boolean isStarGong(String a ,String b){
		if(null != a && null != b && !"".equals(a) && !"".equals(b)){
			String[] split = b.split(",");
			for (int i = 0; i < split.length; i++) {
				if(a.equals(split[i])){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 根据星曜返回司掌宫位
	 * @param index
	 * @return
	 */
	public static String palmSecretary(int index){
		/*1土
		2木
		3火
		4日
		5金
		6水
		7月
		8土
		9木
		10火
		11日
		12金*/
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(1, "4,11");
		map.put(2, "7");
		map.put(3, "6");
		map.put(4, "5,12");
		map.put(5, "3,10");
		map.put(6, "2,9");
		map.put(7, "1,8");
		return map.get(index);
	}
	
	
	/**
	 * 根据星耀返回守护宫
	 * @param index	星耀index
	 * @return 星座index,星座index
	 */
	public static String getConstellation(int index){
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(1, "5");
		map.put(2, "4");
		map.put(3, "3_6");
		map.put(4, "2_7");
		map.put(5, "1_8");
		map.put(6, "9_12");
		map.put(7, "10_11");
		map.put(8, "11");
		map.put(9, "12");
		map.put(10, "8");
		return map.get(index);
	}
	
	//合相
	public static List<Date> combinationData(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		StringBuffer sb = new StringBuffer();
		/*sb.append("2017-12-18 14:30").append(",")
		.append("2018-01-17 10:18").append(",")
		.append("2018-02-16 05:05").append(",")
		.append("2018-03-17 21:12").append(",")
		.append("2018-04-16 09:58").append(",")
		.append("2018-05-15 19:49").append(",")
		.append("2018-06-14 03:44").append(",");*/
		
		sb.append("2017-12-18 14:30").append(",");
		
		List<Date> datalist = new ArrayList<Date>();
		String[] split = sb.toString().split(",");
		for (int i = 0; i < split.length; i++) {
			String str = split[i];
			if(null != str){
				try {
					datalist.add(formatter.parse(str));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return datalist;
	}
	
	public static List<Date> getTimeafter(List<Date> datalist,Date dt1){
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		if(null != dt1){
			for (int i = 0; i < datalist.size(); i++) {
				Date dt2 = datalist.get(i);
				if (dt1.getTime() < dt2.getTime()) {
	                return datalist.subList(i, datalist.size());
				}
			}
		}
		return null;
	}
	
	public static Calendar getCalendar(Calendar cal){
		synchronized (cal) {
			Calendar a = Calendar.getInstance();
			a.setTime(cal.getTime());
			return a;
		}
	}
	
	/**
	 * 判断相位是否相等
	 * @param a	单个相位
	 * @param b	可能带有/的相位
	 * @param c 切割字符
	 * @return
	 */
	public static boolean isPhass(String a,String b,String c){
		if(null != a && null != b){
			String mapPhass = getMapPhass(a);
			if(null != mapPhass){
				String[] split = b.split(c);
				String[] ffrom = mapPhass.split("/");
				for (int i = 0; i < ffrom.length; i++) {
					String s = ffrom[i];
					
					for (int j = 0; j < split.length;j++) {
						String str = split[j];
						if(s.equals(str)){
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	/*public static void main(String[] args) {
		System.out.println(isPhass("135", "0/90/180", "/"));
	}*/
	/**
	 * 判断宫头相位是否相等
	 * @param a	宫头，发生的相位
	 * @param b	规则相位，可能多个
	 * @param c 整宫 宫头
	 * @param d 分宫 宫头
	 * @return
	 */
	public static Boolean isGongPhass(String a,String b,Integer c,Integer d){
		if(null != a && null != c && null != d){
			String[] split2 = a.split(",");
			for (int i = 0; i < split2.length; i++) {
				String arr = split2[i];
				if(null != arr && arr.length() >0){
					String[] split = arr.split("_");
					for (int j = 0; j < split.length; j++) {
						String index = split[0];//宫头
						String val = split[1];	//相位
						if((null != index && index.equals(c+"")) || (null != index && index.equals(d+""))){
							if(isPhass(val, b,"/")){
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * 判断多个相位是否相等
	 * @param a	单个相位
	 * @param b	可能带有/的相位
	 * @param c 切割字符
	 * @return
	 */
	public static boolean isPhassArr(String a,String b,String c){
		if(null != a && !"".equals(a) && null != b && !"".equals(b)){
			String[] split2 = b.split(c);
			for (int j = 0; j < split2.length; j++) {
				String mapPhass = getMapPhass(split2[j]);
				if(null != mapPhass){
					String[] split = mapPhass.split("/");
					for (int i = 0; i < split.length; i++) {
						String str = split[i];
						if(a.equals(str)){
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * 判断多个宫位
	 * @param str   1,2,3
	 * @param g		3	
	 * @return
	 */
	public static Boolean isManyGong(String str,Integer g){
		if(null != str && null != g){
			String[] split = str.split(",");
			for (int i = 0; i < split.length; i++) {
				String a = split[i];
				if(null != a && a.length() > 0){
					if(Integer.valueOf(a).equals(g)){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	/**
	 * 判断守护宫
	 * @param a
	 * @param b
	 * @return
	 */
	public static Boolean isShowGong(String a,String b){
		if(null != a && null != b){
			String[] split = b.split("_");
			for (int i = 0; i < split.length; i++) {
				String str = split[i];
				if(a.equals(str)){
					return true;
				}
			}
		}
		return false;
	}
	
	public static String getMapPhass(String v){
		Map<String,String> map = new HashMap<String, String>();
		map.put("0", "0");
		map.put("45", "45/315");
		map.put("60", "60/300");
		map.put("90", "90/270");
		map.put("120", "120/240");
		map.put("135", "135/225");
		map.put("180", "180");
		
		map.put("300", "60/300");
		map.put("270", "90/270");
		map.put("315", "45/315");
		map.put("270", "90/270");
		map.put("225", "135/225");
		return map.get(v);
	}
	
	/**
	 * 反射注入值，在返回bean
	 * @param cc
	 * @param obj
	 * @param strarr
	 * @param idarr
	 * @return
	 */
	public static Object ReflexEntity(Class<?> cc,JSONObject obj,String[] strarr,int[] idarr){
		Object classobj = null;
		try {
			classobj=cc.newInstance();//初始化一个实例
			for (int i = 0; i < idarr.length; i++) {
				
				if(0 != idarr[i]){
					Object object = obj.get(idarr[i]+"");
					if(null != object){
						String os = (String)object;
						String str = strarr[i];
						String mname = str.substring(0, 1).toUpperCase()+str.substring(1, str.length()).toLowerCase();
						Method m2 = cc.getMethod("get"+mname);
						Object invoke = m2.invoke(classobj);
						Method m3 = cc.getMethod("set"+mname, String.class);
						if(null != invoke){
							m3.invoke(classobj, (String)invoke+"_"+os); 
						}else{
							m3.invoke(classobj, os); 
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classobj;
	}
	
	/**
	 * 根据星曜返回影响天数
	 * @param sartindex	星曜index
	 * @return 天数
	 */
	public static Integer getTrtimeinterval(int sartindex){
		if(sartindex == 1){
			return 1;
		}
		if(sartindex == 2){
			return 7;
		}
		if(sartindex == 3){
			return 1;
		}
		if(sartindex == 4){
			return 1;
		}
		if(sartindex == 5){
			return 2;
		}
		if(sartindex == 6){
			return 4;
		}
		if(sartindex == 7){
			return 7;
		}
		if(sartindex == 8){
			return 7;
		}
		if(sartindex == 9){
			return 14;
		}
		if(sartindex == 10){
			return 30;
		}
		return null;
	}
	
	/*public static void main(String[] args) throws ParseException {
		System.out.println(isPhass("45","0"));
		List<Date> combinationData = combinationData();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String time = "2018-01-17 15:05";
		Date dt1 = formatter.parse(time);
		List<Date> timeafter = getTimeafter(combinationData, dt1);
		for(int i=0;i<timeafter.size();i++){
			Date date = timeafter.get(i);
			System.out.println(formatter.format(date));
		}
	}*/
}