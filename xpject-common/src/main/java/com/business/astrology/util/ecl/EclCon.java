package com.business.astrology.util.ecl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.business.astrology.util.Constants;
import com.business.astrology.util.ecliptic.EclipticBean;

/**
 * 黄道状态实现
 * @author xp
 */
public class EclCon {
	
	public static double[] obj = null;	//行星
	public static double[] dir = null;  //逆行
	
	public static void main(String[] args) {
		EclCon c =new EclCon();
		//行星落入星座，决定后续内容。。。
		Double baiy = 341.32528541488216;
		Constants constants = new Constants();
		
		//测试星耀中点
		testzd1(baiy, obj);
		
		//List<String> glist = constants.groupedZodiac(baiy);//划分星座度数区间
		//String pos = EclCon.get_position(glist, baiy, 325.4258258058921456);
		//System.out.println(pos);
		//testzd(baiy, obj);
		//testzd1(baiy,obj);
		
		/*List<List<String>> base_point = BasePoint.base_point(baiy, obj);
		for (int i = 0; i < base_point.size(); i++) {
			//System.out.print("星座"+(i+1)+"上");
			List<String> list = base_point.get(i);
			for (int j = 0; j < list.size(); j++) {
				String str = list.get(j);
				//星座index,行星index/行星index,度数
				String[] split = str.split(",");
				System.out.println("星座"+split[0]+"上，"+split[1]+",度数="+getDFM(Double.valueOf(split[2])));
			}
		}*/
		
		
		//List<EclipticBean> lists = get_hdstatus(baiy, obj, dir);
		
		//返回星座上有哪些行星
		/*List<Map<Integer, String>> get_positions = get_positions(baiy, obj);
		
		Boolean day_night = day_night(baiy, obj[1]); //true:白天  false:黑夜
		
		Map<Integer, Map<Integer, Double>> maps = get_positionss(glist,baiy, obj);
		
		for (Entry<Integer, Map<Integer, Double>> m : maps.entrySet()) {
			EclipticBean eb = new EclipticBean();
			
			Integer key = m.getKey(); 	//行星Index
			Map<Integer, Double> val = m.getValue();
			
			//只循环一次
			for (Entry<Integer, Double> v : val.entrySet()) {
				Integer xindex = v.getKey(); 		//星座index
				Double du = v.getValue(); 			//度数
				eb.setStar(key);					//星耀
				eb.setLocation(xindex +","+ du);	//黄道位置
				eb.setSpeed(dir[key].toString());	//速度
				eb.setRade(is_rade(dir[key]));		//逆行
				
				Map<Integer, String> map = get_positions.get(xindex-1);
				List<Integer> xlist = new ArrayList<Integer>();
				for (Entry<Integer, String> mm : map.entrySet()) {
					Integer xindexs = mm.getKey();   //行星索引
					//String dus = mm.getValue();		 //行星角度
					xlist.add(xindexs);
				}
				
				String[] mwrx = mwrx(xindex); 
				eb.setTemple(mwrx[0]);  		//庙
				eb.setWang(mwrx[1]);			//旺
				eb.setWeak(mwrx[2]);			//弱
				eb.setDepression(mwrx[3]);		//陷
				
				String jie = jie(key, xindex, du%30);
				eb.setCircles(jie);				//界
				String mian = mian(key, xindex, du%30);
				eb.setNoodles(mian);			//面
				
				String[] three_points = three_points(key, xindex, day_night);
				eb.setTpoints(three_points);	//三分
			}
			lists.add(eb);
		}*/
		/*for (int i = 0; i < lists.size(); i++) {
			EclipticBean eb = lists.get(i);
			System.out.println("星耀="+eb.getStar());
			System.out.println("黄道位置="+eb.getLocation());
			System.out.println("速度="+eb.getSpeed());
			System.out.println("逆行="+eb.getRade());
			System.out.println("庙="+eb.getTemple());
			System.out.println("旺="+eb.getWang());
			
			System.out.print("三分=");
			for (int j = 0; j < eb.getTpoints().length; j++) {
				String str = eb.getTpoints()[j];
				System.out.print(str+"   ");
			}
			System.out.println();
			System.out.println("界="+eb.getCircles());
			System.out.println("面="+eb.getNoodles());
			System.out.println("陷="+eb.getDepression());
			System.out.println("弱="+eb.getWeak());
		}*/
		
		/*for (int i = 0; i < get_positions.size(); i++) {
			Map<Integer, String> map = get_positions.get(i);
			System.out.print("星座"+(i+1)+"上有");
			for (Entry<Integer, String> m : map.entrySet()) {
				Integer key = m.getKey();   //行星索引
				String value = m.getValue();//行星角度
				System.out.print(key+"="+value+",");
			}
			System.out.println();
		}*/
	}
	
	//测试中点
	public static void testzd(Double baiy,double[] obj){
		Map<String, List<String>> base_point = BasePoint.base_point(baiy, obj);
		for (Entry<String, List<String>> map : base_point.entrySet()) {
			String key = map.getKey();
			List<String> lis = map.getValue();
			for (int i = 0; i < lis.size(); i++) {
				String string = lis.get(i);
				String[] split = string.split(",");
				if(split[2].equals(key)){
					System.out.println("星座"+key+"上，"+split[0]+"/"+split[1]+",度数="+getDFM(Double.valueOf(split[3])));
				}
			}
		}
	}
	
	//测试星耀中点
	public static void testzd1(double baiy,double[] obj){
		Map<String, List<String>> base_point = BasePoint.pointStar(baiy,obj);
		for (Entry<String, List<String>> map : base_point.entrySet()) {
			String key = map.getKey();
			List<String> lis = map.getValue();
			System.out.println("行星="+key);
			for (int i = 0; i < lis.size(); i++) {
				String string = lis.get(i);
				String[] split = string.split(",");
				System.out.println("          "+string +"    "+getDFM(Double.valueOf(split[4])));
			}
			System.out.println();
		}
	}
	
	public static double[] bubbleSort(double[] numbers) {   
		double temp; // 记录临时中间值   
	    int size = numbers.length; // 数组大小   
	    for (int i = 0; i < size - 1; i++) {
	        for (int j = i + 1; j < size; j++) {   
	            if (numbers[i] < numbers[j]) { // 交换两数的位置   
	                temp = numbers[i];   
	                numbers[i] = numbers[j];   
	                numbers[j] = temp;   
	            }   
	        }   
	    }
	    return numbers;
	} 
	
	/**
	 * 黄道状态列表
	 * @param baiy 白羊座位置
	 * @param obj  行星集合
	 * @param dir  行星速度集合
	 * @return
	 */
	public static List<EclipticBean> get_hdstatus(double baiy,double[] obj,double[] dir){
		List<EclipticBean> lists = new ArrayList<EclipticBean>();
		//Constants constants = new Constants();
		//List<String> glist = constants.groupedZodiac(baiy);//划分星座度数区间
		
		Boolean day_night = day_night(baiy, obj[1]); //true:白天  false:黑夜
		
		Map<Integer, Map<Integer, Double>> maps = get_positionss(baiy, obj);
		
		for (Entry<Integer, Map<Integer, Double>> m : maps.entrySet()) {
			EclipticBean eb = new EclipticBean();
			
			Integer key = m.getKey(); 	//行星Index
			Map<Integer, Double> val = m.getValue();
			
			//只循环一次
			for (Entry<Integer, Double> v : val.entrySet()) {
				Integer xindex = v.getKey(); 		//星座index
				Double du = v.getValue(); 			//度数
				eb.setStar(key);					//星耀
				eb.setLocation(xindex +","+ du);	//黄道位置
				eb.setSpeed(dir[key]+"");	//速度
				eb.setRade(is_rade(dir[key]));		//逆行
				
				String[] mwrx = mwrx(xindex); 
				eb.setTemple(mwrx[0]);  		//庙
				eb.setWang(mwrx[1]);			//旺
				eb.setWeak(mwrx[2]);			//弱
				eb.setDepression(mwrx[3]);		//陷
				
				String jie = jie(key, xindex, du%30);
				eb.setCircles(jie);				//界
				String mian = mian(key, xindex, du%30);
				eb.setNoodles(mian);			//面
				
				String[] three_points = three_points(key, xindex, day_night);
				eb.setTpoints(three_points);	//三分
			}
			lists.add(eb);
		}
		return lists;
	}
	
	
	/**
	 * 返回行星在哪个星座
	 * @param baiy 白羊座
	 * @param d 行星度数
	 * @return 星座index ，度数
	 */
	public static String get_position(Double baiy,Double d){
		if(null !=baiy && d != null){
			return (int) Math.ceil(d/30)+","+d;
		}
		return null;
	}
	/*public static String get_position(List<String> glist,Double baiy,Double d){
		if(null !=baiy && d != null){
			Double z = baiy - d;
			if(z < 0){
				z = 360 + z;
			}
			//System.out.println("z="+z);
			for (int i = 0; i < glist.size(); i++) {
				String str = glist.get(i);
				if(!StringUtil.isEmpty(str)){
					String[] split = str.split(",");
					Double start = Double.valueOf(split[0]);
					Double end = Double.valueOf(split[1]);
					//System.out.println(start+"        "+end);
					//Double z = 360 -(baiy + xxdu);
					if(start<end){
						//start = start + 360;
						if(start > z || z >end){
							return (i+1)+","+d;
						}
					}
					if(start >= z && z > end){
						return (i+1)+","+d;
					}
				}
			}
		}
		return null;
	}*/
	
	/**
	 * 计算每个行星所在星座
	 * @param baiy 依据白羊座度
	 * @param d 星耀集合
	 * @return 星座=星耀+度数
	 */
	public static List<Map<Integer,Double>> get_positions(Double baiy,double[] obj){
		List<Map<Integer,Double>> list = new ArrayList<>();
		if(null !=baiy && obj != null){
			Constants constants = new Constants();
			//List<String> glist = constants.groupedZodiac(baiy);//划分星座度数区间
			for (int i = 0; i < 12; i++) {//星座
				Map<Integer,Double> map = new HashMap<>();
				for (int j = 0; j < obj.length; j++) {//计算行星
					if(Constants.ignoreACG[j] == 0){
						/*Double z = baiy - obj[j];
						if(z < 0){
							z = 360 + z;
						}*/
						
						String str = get_position(baiy,obj[j]);
						//Double xing_p = xing_p(i, glist, z);
						if(null != str){
							map.put(j, Double.valueOf(str.split(",")[1]));
						}
					}
				}
				list.add(map);
			}
		}
		return list;
	}
	
	/**
	 * 返回星座所属行星
	 * @param baiy 依据白羊座度
	 * @param d 星耀集合
	 * @return 星耀=星座+度数
	 */
	public static Map<Integer,Map<Integer,Double>> get_positionss(double baiy,double[] obj){
		//0表示计算，1表示不计算
		byte[] ignoreACG = new byte[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, /* Planets */
				1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, /* Minors */
				0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, /* Cusps */
				1, 1, 1, 1, 1, 1, 1, 1, 1, /* Uranians */
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, /* Stars */
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		
		Map<Integer,Map<Integer,Double>> maps = new HashMap<>();//行星Index，星座Index=度数
		if(obj != null){
			for (int j = 0; j < obj.length; j++) {//计算行星
				if(ignoreACG[j] == 0){
					Map<Integer,Double> map = new HashMap<>();
					String get_position = get_position(baiy, obj[j]);
					if(null != get_position){
						String[] split = get_position.split(",");
						Integer xindex = Integer.valueOf(split[0]);
						Double du = Double.valueOf(split[1]);
						map.put(xindex, du);
					}
					maps.put(j, map);
				}
			}
		}
		return maps;
	}
	
	
	/**
	 * 计算行星所在星座
	 * @param xz    星座索引
	 * @param glist 星座分值区间
	 * @param xx    处理后的行星角度
	 * @return
	 */
	/*public static Double xing_p(Double baiy,Double d){
		if(null != d){
			String str = get_position(baiy,d);
			if(!StringUtil.isEmpty(str)){
				String[] split = str.split(",");
				Double start = Double.valueOf(split[0]);
				Double end = Double.valueOf(split[1]);
				if(start >= xx && xx >= end){
					return xx;
				}
			}
		}
		return null;
	}*/
	
	/**
	 * 庙
	 * @param baiy 依据白羊座度
	 * @param ydu  星座索引
	 * @param xxdu 行星度数
	 * @return
	 */
	/*public static Boolean miao(Double baiy,Integer zindex,Double xxdu){
		if(null !=baiy && zindex <=12){
			Constants constants = new Constants();
			List<String> glist = constants.groupedZodiac(baiy);
			String str = glist.get(zindex-1);
			if(!StringUtil.isEmpty(str)){
				String[] split = str.split(",");
				Double start = Double.valueOf(split[0]);
				Double end = Double.valueOf(split[1]);
				//Double z = 360 -(baiy + xxdu);
				Double z = baiy - xxdu;
				if(z < 0){
					z = 360 + z;
				}
				if(start >= z && z >= end){
					return true;
				}
			}
		}
		return false;
	}*/
	
	/**
	 * 0庙1旺2弱3陷
	 * @param xzIndex 星座
	 * @param 行星index = 分数
	 */
	public static String[] mwrx(Integer xzIndex){
		String[] arr = new String[]{"","","",""};
		if(null != xzIndex){
			if(xzIndex == 1){ //白羊
				//庙
				arr[0] = 5+"="+5;
				
				//旺
				arr[1] = 1+"="+4;
				
				//弱
				arr[2] = 7+"="+(-4);
				//陷
				arr[3] = 4+"="+(-5);
			}
			if(xzIndex == 2){ //金牛
				//庙
				arr[0] = 4+"="+5;
				//旺
				arr[1] = 2+"="+4;
				//陷
				arr[3] = 5+"="+(-5);
			}
			if(xzIndex == 3){ //双子
				//庙
				arr[0] = 3+"="+5;
				//陷
				arr[3] = 6+"="+(-5);
			}
			if(xzIndex == 4){ //巨蟹
				//庙
				arr[0] = 2+"="+5;
				//旺
				arr[1] = 6+"="+4;
				//弱
				arr[2] = 5+"="+(-4);
				//陷
				arr[3] = 7+"="+(-5);
			}
			if(xzIndex == 5){ //狮子
				//庙
				arr[0] = 1+"="+5;
				//陷
				arr[3] = 7+"="+(-5);
			}
			if(xzIndex == 6){ //处女
				//庙
				arr[0] = 3+"="+5;
				//旺
				arr[1] = 3+"="+4;
				//弱
				arr[2] = 4+"="+(-4);
				//陷
				arr[3] = 7+"="+(-5);
				
			}
			if(xzIndex == 7){ //天枰
				//庙
					arr[0] = 4+"="+5;
				//旺
					arr[1] = 7+"="+4;
				//弱
					arr[2] = 1+"="+(-4);
				//陷
					arr[3] = 5+"="+(-5);
			}
			if(xzIndex == 8){ //天蝎
				//庙
					arr[0] = 5+"="+5;
				//弱
					arr[2] = 2+"="+(-4);
				//陷
					arr[3] = 4+"="+(-5);
			}
			if(xzIndex == 9){ //射手
				//庙
					arr[0] = 6+"="+5;
				//陷
					arr[3] = 3+"="+(-5);
			}
			if(xzIndex == 10){ //摩羯
				//庙
					arr[0] = 7+"="+5;
				//旺
					arr[1] = 5+"="+4;
				//弱
					arr[2] = 6+"="+(-4);
				//陷
					arr[3] = 2+"="+(-5);
			}
			if(xzIndex == 11){ //水瓶
				//庙
					arr[0] = 7+"="+5;
				//陷
					arr[3] = 1+"="+(-5);
			}
			if(xzIndex == 12){ //双鱼
				//庙
					arr[0] = 6+"="+5;
				//旺
					arr[1] = 4+"="+4;
				//弱
					arr[2] = 3+"="+(-4);
				//陷
					arr[3] = 3+"="+(-5);
			}
		}
		return arr;
	}
	
	/**
	 * 0界1面
	 * @param xxIndex 行星
	 * @param xzIndex 星座
	 * @param d 度
	 * @return 行星索引=分值
	 */
	public static String jie(Integer xxIndex,Integer xzIndex,Double d){
		if(null != xxIndex&&null != xzIndex){
			if(xzIndex == 1){ //白羊
				//界
				/*if((xxIndex==6 && 0<d&& d<6)||(xxIndex==4 && 6<d&& d<12)||(xxIndex==3 && 12<d&& d<20)
						||(xxIndex==5 && 20<d&& d<25)||(xxIndex==7 && 25<d&& d<30)){
					arr[0] = 2;
				}*/
				String a = "";
				if(0<d&& d<6){
					return 6+"="+2;
				}
				if(6<=d&& d<12){
					return 4+"="+2;
				}
				if(12<=d&& d<20){
					return 3+"="+2;
				}
				if(20<=d&& d<25){
					return 5+"="+2;
				}
				if(25<=d&& d<30){
					return 7+"="+2;
				}
			}
			if(xzIndex == 2){ //金牛
				//界
				/*if((xxIndex==4 && 0<d&& d<8)||(xxIndex==3 && 8<d&& d<14)||(xxIndex==6 && 14<d&& d<22)
						||(xxIndex==7 && 22<d&& d<27)||(xxIndex==5 && 27<d&& d<30)){
					arr[0] = 2;
				}*/
				if(0<d&& d<8){
					return 4+"="+2;
				}
				if(8<=d&& d<14){
					return 3+"="+2;
				}
				if(14<d&& d<22){
					return 6+"="+2;
				}
				if(22<=d&& d<27){
					return 7+"="+2;
				}
				if(27<=d&& d<30){
					return 5+"="+2;
				}
			}
			if(xzIndex == 3){ //双子
				//界
				/*if((xxIndex==3 && 0<d&& d<6)||(xxIndex==6 && 6<d&& d<12)||(xxIndex==4 && 12<d&& d<17)
						||(xxIndex==5 && 17<d&& d<24)||(xxIndex==7 && 24<d&& d<30)){
					arr[0] = 2;
				}*/
				if(0<d&& d<6){
					return 3+"="+2;
				}
				if(6<=d&& d<12){
					return 6+"="+2;
				}
				if(12<=d&& d<17){
					return 4+"="+2;
				}
				if(17<=d&& d<24){
					return 5+"="+2;
				}
				if(24<=d&& d<30){
					return 7+"="+2;
				}
			}
			if(xzIndex == 4){ //巨蟹
				//界
				/*if((xxIndex==5 && 0<d&& d<7)||(xxIndex==4 && 7<d&& d<13)||(xxIndex==3 && 13<d&& d<19)
						||(xxIndex==6 && 19<d&& d<26)||(xxIndex==7 && 26<d&& d<30)){
					arr[0] = 2;
				}*/
				if(0<d&& d<7){
					return 5+"="+2;
				}
				if(7<=d&& d<13){
					return 4+"="+2;
				}
				if(13<=d&& d<19){
					return 3+"="+2;
				}
				if(19<=d&& d<26){
					return 6+"="+2;
				}
				if(26<=d&& d<30){
					return 7+"="+2;
				}
			}
			if(xzIndex == 5){ //狮子
				//界
				/*if((xxIndex==6 && 0<d&& d<6)||(xxIndex==4 && 6<d&& d<11)||(xxIndex==7 && 11<d&& d<18)
						||(xxIndex==3 && 18<d&& d<24)||(xxIndex==5 && 24<d&& d<30)){
					arr[0] = 2;
				}*/
				if(0<d&& d<6){
					return 6+"="+2;
				}
				if(6<=d&& d<11){
					return 4+"="+2;
				}
				if(11<=d&& d<18){
					return 7+"="+2;
				}
				if(18<=d&& d<24){
					return 3+"="+2;
				}
				if(24<=d&& d<30){
					return 5+"="+2;
				}
			}
			if(xzIndex == 6){ //处女
				//界
				/*if((xxIndex==3 && 0<d&& d<7)||(xxIndex==4 && 7<d&& d<17)||(xxIndex==6 && 17<d&& d<21)
						||(xxIndex==5 && 21<d&& d<28)||(xxIndex==7 && 28<d&& d<30)){
					arr[0] = 2;
				}*/
				if(0<d&& d<7){
					return 3+"="+2;
				}
				if(7<=d&& d<17){
					return 4+"="+2;
				}
				if(17<=d&& d<21){
					return 6+"="+2;
				}
				if(21<=d&& d<28){
					return 5+"="+2;
				}
				if(28<=d&& d<30){
					return 7+"="+2;
				}
			}
			if(xzIndex == 7){ //天枰
				//界
				/*if((xxIndex==7 && 0<d&& d<6)||(xxIndex==3 && 6<d&& d<14)||(xxIndex==6 && 14<d&& d<21)
						||(xxIndex==4 && 21<d&& d<28)||(xxIndex==5 && 28<d&& d<30)){
					arr[0] = 2;
				}*/
				if(0<d&& d<6){
					return 7+"="+2;
				}
				if(6<=d&& d<14){
					return 3+"="+2;
				}
				if(14<=d&& d<21){
					return 6+"="+2;
				}
				if(21<=d&& d<28){
					return 4+"="+2;
				}
				if(28<=d&& d<30){
					return 5+"="+2;
				}
			}
			if(xzIndex == 8){ //天蝎
				//界
				/*if((xxIndex==5 && 0<d&& d<7)||(xxIndex==4 && 7<d&& d<11)||(xxIndex==3 && 11<d&& d<19)
						||(xxIndex==6 && 19<d&& d<24)||(xxIndex==7 && 24<d&& d<30)){
					arr[0] = 2;
				}*/
				if(0<d&& d<7){
					return 5+"="+2;
				}
				if(7<=d&& d<11){
					return 4+"="+2;
				}
				if(11<=d&& d<19){
					return 3+"="+2;
				}
				if(19<=d&& d<24){
					return 6+"="+2;
				}
				if(24<=d&& d<30){
					return 7+"="+2;
				}
			}
			if(xzIndex == 9){ //射手
				//界
				/*if((xxIndex==6 && 0<d&& d<12)||(xxIndex==4 && 12<d&& d<17)||(xxIndex==3 && 17<d&& d<21)
						||(xxIndex==7 && 21<d&& d<26)||(xxIndex==5 && 26<d&& d<30)){
					arr[0] = 2;
				}*/
				if(0<d&& d<12){
					return 6+"="+2;
				}
				if(12<=d&& d<17){
					return 4+"="+2;
				}
				if(17<=d&& d<21){
					return 3+"="+2;
				}
				if(21<=d&& d<26){
					return 7+"="+2;
				}
				if(26<=d&& d<30){
					return 5+"="+2;
				}
			}
			if(xzIndex == 10){ //摩羯
				//界
				/*if((xxIndex==3 && 0<d&& d<7)||(xxIndex==6 && 7<d&& d<14)||(xxIndex==4 && 14<d&& d<22)
						||(xxIndex==7 && 22<d&& d<26)||(xxIndex==5 && 26<d&& d<30)){
					arr[0] = 2;
				}*/
				if(0<d&& d<7){
					return 3+"="+2;
				}
				if(7<=d&& d<14){
					return 6+"="+2;
				}
				if(14<=d&& d<22){
					return 4+"="+2;
				}
				if(22<=d&& d<26){
					return 7+"="+2;
				}
				if(26<=d&& d<30){
					return 5+"="+2;
				}
			}
			if(xzIndex == 11){ //水瓶
				//界
				/*if((xxIndex==3 && 0<d&& d<7)||(xxIndex==4 && 7<d&& d<13)||(xxIndex==6 && 13<d&& d<20)
						||(xxIndex==5 && 20<d&& d<25)||(xxIndex==7 && 25<d&& d<30)){
					arr[0] = 2;
				}*/
				if(0<d&& d<7){
					return 3+"="+2;
				}
				if(7<=d&& d<13){
					return 4+"="+2;
				}
				if(13<=d&& d<20){
					return 6+"="+2;
				}
				if(20<=d&& d<25){
					return 5+"="+2;
				}
				if(25<=d&& d<30){
					return 7+"="+2;
				}
			}
			if(xzIndex == 12){ //双鱼
				//界
				/*if((xxIndex==4 && 0<d&& d<12)||(xxIndex==6 && 12<d&& d<16)||(xxIndex==3 && 16<d&& d<19)
						||(xxIndex==5 && 19<d&& d<28)||(xxIndex==7 && 28<d&& d<30)){
					arr[0] = 2;
				}*/
				if(0<d&& d<12){
					return 4+"="+2;
				}
				if(12<=d&& d<16){
					return 6+"="+2;
				}
				if(16<=d&& d<19){
					return 3+"="+2;
				}
				if(19<=d&& d<28){
					return 5+"="+2;
				}
				if(28<=d&& d<30){
					return 7+"="+2;
				}
			}
		}
		return null;
	}
	
	/**
	 * 面
	 * @param xxIndex 行星
	 * @param xzIndex 星座
	 * @param d 度
	 * @return 行星索引=分值
	 */
	public static String mian(Integer xxIndex,Integer xzIndex,Double d){
		if(null != xxIndex&&null != xzIndex){
			if(xzIndex == 1){ //白羊
				//面
				/*if((xxIndex==5 && 0<d&& d<10)||(xxIndex==1 && 10<d&& d<20)||(xxIndex==4 && 20<d&& d<30)){
					arr[1] = 1;
				}*/
				if(0<d&& d<10){
					return 5+"="+1;
				}
				if(10<=d&& d<20){
					return 1+"="+1;
				}
				if(20<=d&& d<30){
					return 4+"="+1;
				}
			}
			if(xzIndex == 2){ //金牛
				//面
				/*if((xxIndex==3 && 0<d&& d<10)||(xxIndex==2 && 10<d&& d<20)||(xxIndex==7 && 20<d&& d<30)){
					arr[1] = 1;
				}*/
				if(0<d&& d<10){
					return 3+"="+1;
				}
				if(10<=d&& d<20){
					return 2+"="+1;
				}
				if(20<=d&& d<30){
					return 7+"="+1;
				}
			}
			if(xzIndex == 3){ //双子
				//面
				/*if((xxIndex==6 && 0<d&& d<10)||(xxIndex==5 && 10<d&& d<20)||(xxIndex==1 && 20<d&& d<30)){
					arr[1] = 1;
				}*/
				if(0<d&& d<10){
					return 6+"="+1;
				}
				if(10<=d&& d<20){
					return 5+"="+1;
				}
				if(20<=d&& d<30){
					return 1+"="+1;
				}
			}
			if(xzIndex == 4){ //巨蟹
				//面
				/*if((xxIndex==4 && 0<d&& d<10)||(xxIndex==3 && 10<d&& d<20)||(xxIndex==2 && 20<d&& d<30)){
					arr[1] = 1;
				}*/
				if(0<d&& d<10){
					return 4+"="+1;
				}
				if(10<=d&& d<20){
					return 3+"="+1;
				}
				if(20<=d&& d<30){
					return 2+"="+1;
				}
			}
			if(xzIndex == 5){ //狮子
				//面
				/*if((xxIndex==7 && 0<d&& d<10)||(xxIndex==6 && 10<d&& d<20)||(xxIndex==5 && 20<d&& d<30)){
					arr[1] = 1;
				}*/
				if(0<d&& d<10){
					return 7+"="+1;
				}
				if(10<=d&& d<20){
					return 6+"="+1;
				}
				if(20<=d&& d<30){
					return 5+"="+1;
				}
			}
			if(xzIndex == 6){ //处女
				//面
				/*if((xxIndex==1 && 0<d&& d<10)||(xxIndex==4 && 10<d&& d<20)||(xxIndex==3 && 20<d&& d<30)){
					arr[1] = 1;
				}*/
				if(0<d&& d<10){
					return 1+"="+1;
				}
				if(10<=d&& d<20){
					return 4+"="+1;
				}
				if(20<=d&& d<30){
					return 3+"="+1;
				}
			}
			if(xzIndex == 7){ //天枰
				//面
				/*if((xxIndex==2 && 0<d&& d<10)||(xxIndex==7 && 10<d&& d<20)||(xxIndex==6 && 20<d&& d<30)){
					arr[1] = 1;
				}*/
				if(0<d&& d<10){
					return 2+"="+1;
				}
				if(10<=d&& d<20){
					return 7+"="+1;
				}
				if(20<=d&& d<30){
					return 6+"="+1;
				}
			}
			if(xzIndex == 8){ //天蝎
				//面
				/*if((xxIndex==5 && 0<d&& d<10)||(xxIndex==1 && 10<d&& d<20)||(xxIndex==4 && 20<d&& d<30)){
					arr[1] = 1;
				}*/
				if(0<d&& d<10){
					return 5+"="+1;
				}
				if(10<=d&& d<20){
					return 1+"="+1;
				}
				if(20<=d&& d<30){
					return 4+"="+1;
				}
			}
			if(xzIndex == 9){ //射手
				//面
				/*if((xxIndex==3 && 0<d&& d<10)||(xxIndex==2 && 10<d&& d<20)||(xxIndex==7 && 20<d&& d<30)){
					arr[1] = 1;
				}*/
				if(0<d&& d<10){
					return 3+"="+1;
				}
				if(10<=d&& d<20){
					return 2+"="+1;
				}
				if(20<=d&& d<30){
					return 7+"="+1;
				}
			}
			if(xzIndex == 10){ //摩羯
				//面
				/*if((xxIndex==6 && 0<d&& d<10)||(xxIndex==5 && 10<d&& d<20)||(xxIndex==1 && 20<d&& d<30)){
					arr[1] = 1;
				}*/
				if(0<d&& d<10){
					return 6+"="+1;
				}
				if(10<=d&& d<20){
					return 5+"="+1;
				}
				if(20<=d&& d<30){
					return 1+"="+1;
				}
			}
			if(xzIndex == 11){ //水瓶
				//面
				/*if((xxIndex==4 && 0<d&& d<10)||(xxIndex==3 && 10<d&& d<20)||(xxIndex==2 && 20<d&& d<30)){
					arr[1] = 1;
				}*/
				if(0<d&& d<10){
					return 4+"="+1;
				}
				if(10<=d&& d<20){
					return 3+"="+1;
				}
				if(20<=d&& d<30){
					return 2+"="+1;
				}
			}
			if(xzIndex == 12){ //双鱼
				//面
				/*if((xxIndex==7 && 0<d&& d<10)||(xxIndex==6 && 10<d&& d<20)||(xxIndex==5 && 20<d&& d<30)){
					arr[1] = 1;
				}*/
				if(0<d&& d<10){
					return 7+"="+1;
				}
				if(10<=d&& d<20){
					return 6+"="+1;
				}
				if(20<=d&& d<30){
					return 5+"="+1;
				}
			}
		}
		return null;
	} 
	/**
	 * 三分
	 * @param xxIndex 行星
	 * @param xzIndex 星座
	 * @param isday true:白天
	 * @return 行星Index = 分值
	 */
	public static String[] three_points(Integer xxIndex,Integer xzIndex,Boolean isday){
		String[] arr = new String[3];
		if(null != xxIndex&&null != xzIndex){
			if(xzIndex == 1){ //白羊
				String a = "";
				//if(xxIndex == 1){ //3分
					if(isday){
						a = 1+"="+3;
					}else{
						a = 1+"="+2;
					}
					arr[0] = a;
				//}
				//if(xxIndex == 6){ //2分
					if(isday){
						a = 6+"="+2;
					}else{
						a = 6+"="+3;
					}
					arr[1] = a;
				//}
				//if(xxIndex == 7){ //3分
					arr[2] = 7+"="+1;
				//}
			}
			if(xzIndex == 2){ //金牛
				String a = "";
				//if(xxIndex == 4){ //3分
					if(isday){
						a = 4+"="+3;
					}else{
						a = 4+"="+2;
					}
					arr[0] = a;
				//}
				//if(xxIndex == 2){ //2分
					if(isday){
						a = 2+"="+2;
					}else{
						a = 2+"="+3;
					}
					arr[1] = a;
				//}
				//if(xxIndex == 5){ //3分
					arr[2] = 5+"="+1;
				//}
			}
			if(xzIndex == 3){ //双子
				String a = "";
				//if(xxIndex == 7){ //3分
					if(isday){
						a = 7+"="+3;
					}else{
						a = 7+"="+2;
					}
					arr[0] = a;
				//}
				//if(xxIndex == 3){ //2分
					
					if(isday){
						a = 3+"="+2;
					}else{
						a = 3+"="+3;
					}
					arr[1] = a;
				//}
				//if(xxIndex == 6){ //3分
					arr[2] = 6+"="+1;
				//}
			}
			if(xzIndex == 4){ //巨蟹
				String a = "";
				//if(xxIndex == 4){ //3分
					if(isday){
						a = 4+"="+3;
					}else{
						a = 4+"="+2;
					}
					arr[0] = a;
				//}
				//if(xxIndex == 5){ //2分
					if(isday){
						a = 5+"="+2;
					}else{
						a = 5+"="+3;
					}
					arr[1] = a;
				//}
				//if(xxIndex == 5){ //3分
					arr[2] = 5+"="+1;
				//}
			}
			if(xzIndex == 5){ //狮子
				String a = "";
				//if(xxIndex == 1){ //3分
					if(isday){
						a = 1+"="+3;
					}else{
						a = 1+"="+2;
					}
					arr[0] = a;
				//}
				//if(xxIndex == 6){ //2分
					if(isday){
						a = 6+"="+2;
					}else{
						a = 6+"="+3;
					}
					arr[1] = a;
				//}
				//if(xxIndex == 7){ //3分
					arr[2] = 7+"="+1;
				//}
			}
			if(xzIndex == 6){ //处女
				String a = "";
				//if(xxIndex == 4){ //3分
					if(isday){
						a = 4+"="+3;
					}else{
						a = 4+"="+2;
					}
					arr[0] = a;
				//}
				//if(xxIndex == 2){ //2分
					if(isday){
						a = 2+"="+2;
					}else{
						a = 2+"="+3;
					}
					arr[1] = a;
				//}
				//if(xxIndex == 5){ //1分
					arr[2] = 5+"="+1;
				//}
			}
			if(xzIndex == 7){ //天枰
				String a = "";
				//if(xxIndex == 7){ //3分
					if(isday){
						a = 7+"="+3;
					}else{
						a = 7+"="+2;
					}
					arr[0] = a;
				//}
				//if(xxIndex == 3){ //2分
					if(isday){
						a = 3+"="+2;
					}else{
						a = 3+"="+3;
					}
					arr[1] = a;
				//}
				//if(xxIndex == 6){ //3分
					arr[2] = 6+"="+1;
				//}
			}
			if(xzIndex == 8){ //天蝎
				String a = "";
				//if(xxIndex == 4){ //3分
					if(isday){
						a = 4+"="+3;
					}else{
						a = 4+"="+2;
					}
					arr[0] = a;
				//}
				//if(xxIndex == 5){ //2分
					
					if(isday){
						a = 5+"="+2;
					}else{
						a = 5+"="+3;
					}
					arr[1] = a;
				//}
				//if(xxIndex == 2){ //3分
					arr[2] = 2+"="+1;
				//}
			}
			if(xzIndex == 9){ //射手
				String a = "";
				//if(xxIndex == 1){ //3分
					
					if(isday){
						a = 1+"="+3;
					}else{
						a = 1+"="+2;
					}
					arr[0] = a;
				//}
				//if(xxIndex == 6){ //2分
					if(isday){
						a = 6+"="+2;
					}else{
						a = 6+"="+3;
					}
					arr[1] = a;
				//}
				//if(xxIndex == 7){ //3分
					arr[2] = 7+"="+1;
				//}
			}
			if(xzIndex == 10){ //摩羯
				String a = "";
				//if(xxIndex == 4){ //3分
					if(isday){
						a = 4+"="+3;
					}else{
						a = 4+"="+2;
					}
					arr[0] = a;
				//}
				//if(xxIndex == 2){ //2分
					if(isday){
						a = 2+"="+2;
					}else{
						a = 2+"="+3;
					}
					arr[1] = a;
				//}
				//if(xxIndex == 5){ //3分
					arr[2] = 5+"="+1;
				//}
			}
			if(xzIndex == 11){ //水瓶
				String a = "";
				//if(xxIndex == 7){ //3分
					if(isday){
						a = 7+"="+3;
					}else{
						a = 7+"="+2;
					}
					arr[0] = a;
				//}
				//if(xxIndex == 3){ //2分
					if(isday){
						a = 3+"="+2;
					}else{
						a = 3+"="+3;
					}
					arr[1] = a;
				//}
				//if(xxIndex == 6){ //3分
					arr[2] = 6+"="+1;
				//}
			}
			if(xzIndex == 12){ //双鱼
				String a = "";
				//if(xxIndex == 4){ //3分
					if(isday){
						a = 4+"="+3;
					}else{
						a = 4+"="+2;
					}
					arr[0] = a;
				//}
				//if(xxIndex == 5){ //2分
					if(isday){
						a = 5+"="+2;
					}else{
						a = 5+"="+3;
					}
					arr[1] = a;
				//}
				//if(xxIndex == 2){ //1分
					arr[2] = 2+"="+1;
				//}
			}
		}
		return arr;
	}
	
	/**
	 * 返回白天黑夜
	 * @param baiy
	 * @param d 太阳度数
	 * @return true=白，false=夜
	 */
	public static Boolean day_night(Double baiy,Double d){
		if(null != baiy && null != d){
			Double z = baiy - d;
			if(z < 0){
				z = 360 + z;
			}
			if(z >=180){ //夜生
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 负=逆行，反之
	 * @param d
	 * @return
	 */
	private static boolean is_rade(Double d){
		if(d < 0){
			return true;
		}
		return false;
	}
	/**
	 * 十进制转60进制
	 * @param str
	 * @return
	 */
	public static String getDFM(Double str){
		Double s = str%30;
		Double m=(s-s.intValue())*60;
		Double ms=(m-m.intValue())*60;
	    /*if(ms >30){
	        m+=1;
	    }*/
	    return s.intValue()+"°"+m.intValue()+"′"+ms.intValue()+"″";
	}
	
	//十进制转60进制 （时分）
	public static String getDFM1(Double str){
		Double s = str%30;
		Double m=(s-s.intValue())*60;
	    return s.intValue()+"°"+m.intValue()+"′";
	}
	
	public EclCon() {
		//行星
		obj = new double[]{316.17237597189205, 136.17237597189202, 325.19691822468303, 160.77808025924114, 99.18844663126484, 132.23079125495948, 198.10907505423611, 261.3496478569273, 28.541669797129913, 343.56570116922245, 287.38712108235796, 358.9831101097366, 102.3931560969522, 42.64472556085586, 275.939558254148, 163.3168630352785, 144.60152982789896, 324.60152982789896, 0.0, 152.30074316209118, 171.921697463109, 345.92224292690065, 341.32528541488216, 22.058884036449474, 53.181194623194756, 78.07993543520917, 101.313976397842, 127.19284917179596, 161.32528541488216, 202.05888403644948, 233.18119462319476, 258.07993543520917, 281.313976397842, 307.19284917179596, 0.0, 266.43898890892075, 97.2013735097132, 197.7823478089535, 101.0208871572772, 210.73837918204785, 60.69954303402511, 120.04108621452197, 221.87615842934798, 345.56256044922, 88.81492848398437, 354.1505545849176, 60.62609834136486, 70.03632555255436, 82.10484017474874, 77.0767911872353, 81.19353822066319, 82.82209953813475, 83.71048174853925, 89.00182550415872, 90.1575321796397, 97.43449358312145, 105.20625838434518, 99.35177973930828, 104.3283478941027, 111.00884663008347, 113.64172518938102, 110.48767004326544, 116.03240064167653, 113.46281683500689, 147.59257714014424, 173.36883470312063, 212.2101891870406, 147.52547561183246, 150.07633961111796, 135.44655516672358, 222.1146811940945, 216.98454397438584, 221.8912641873962, 159.18366509131923, 204.08824262583838, 177.1830343858815, 234.03798242601607, 204.48175303634613, 239.7254716748666, 250.00923599006603, 264.8324744562376, 265.8461630565818, 275.3257470733007, 285.5615453626072, 302.02252036113333, 294.0651639394965, 335.572213733231, 316.154955398437, 334.1081315967379, 27.970164412036034};
		
		//行星逆行
		dir = new double[]{0.9585682419158309, 0.9585682419158309, 0.0, 0.3747766246455966, 1.1663982859546462, 0.6404486543284645, 0.14902289032515156, -0.02663768173711474, -0.004433329345524167, -0.02365955855515861, -0.020820738928986487, -0.030389163971924052, 0.4089192919481126, 0.2045627299481331, -0.12293926533314936, 0.4765818147122376, -1.0, 0.0, 0.0, 360.0, 360.0, 360.0, 360.0, 360.0, 360.0, 360.0, 360.0, 360.0, 360.0, 360.0, 360.0, 360.0, 360.0, 360.0, 0.0, -0.011586698765640705, 0.01726776794465829, 0.010020107023420979, 0.013892329077431226, 0.0054489260141126865, 0.004728592596819293, 0.013302441712383442, 0.0022697532492444786, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5, 3.8255282712408855E-5};
	}
}
