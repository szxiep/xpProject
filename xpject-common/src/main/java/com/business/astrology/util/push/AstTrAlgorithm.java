package com.business.astrology.util.push;

import java.util.ArrayList;
import java.util.List;

import com.business.astrology.util.Constants;

/**
 * 占星规则算法
 * @author xp
 */
public class AstTrAlgorithm {

	//推运相位
	//public String[] phase = new String[]{"0","45,315","90,270","135,225","180"};
	
	/**
	 * 规则1
	 * 计算星耀与宫头发生相位
	 * @param obj	星曜
	 * @param cusp	分宫位
	 * @param cusp1	整宫位
	 * @param phase	相位
	 * @param r		容许度
	 * @return String[]  0=分宫,1=整宫  value=宫头_相位
	 */
	public static String[] sartPalace(double obj,double[] cusp,double[] cusp1,String[] phase,double r){
		List<String> list = new ArrayList<String>();
		String[] arr = new String[2];
		if(obj > 0){
			StringBuffer sb = new StringBuffer();
			for (int i = 1; i < cusp.length; i++) {
				double gwei = cusp[i];//宫头
				String[] phase2 = Constants.calculationPhase(obj, gwei, phase, r);
				if(null != phase2){
					sb.append(i).append("_").append(phase2[0]).append(",");
					//list.add(i+"_"+phase2);
				}
			}
			//分宫
			arr[0] = sb.toString();
			
			sb = new StringBuffer();
			for (int i = 1; i < cusp1.length; i++) {
				double gwei = cusp1[i];//宫头
				String[] phase2 = Constants.calculationPhase(obj, gwei, phase, r);
				if(null != phase2){
					sb.append(i).append("_").append(phase2[0]).append(",");
					//list.add(i+"_"+phase2);
				}
			}
			//整宫
			arr[1] = sb.toString();
		}
		return arr;
	}
	
	/**
	 * 规则表2 (TR)
	 * 外盘星耀与本命星耀发生相位,外盘星耀在本命盘cusp哪个宫位内
	 * @param ignoreACG	内盘
	 * @param ignoreACG1外盘
	 * @param obj		外盘星耀
	 * @param obj1		本命星耀
	 * @param cusp		本命分宫位
	 * @param cusp1		本命整宫位
	 * @param phase		相位集合
	 * @param r			容许度
	 * @param fr		土天海冥 容许度特殊计算(null 则忽略fr，只计算r)
	 * @return list     外盘星耀,本命星耀,多少度相位,本命星耀在本命盘第几宫,obj所在星座,外盘星耀与本命宫头发生相位
	 */
	public static List<TrBean> startandStart(byte[] ignoreACG,byte[] ignoreACG1,double[] obj,double[] obj1,double[] cusp,double[] cusp1,String[] phase,double r,Double fr){
		List<TrBean> list = new ArrayList<TrBean>();
		for (int i = 0; i < obj.length; i++) {
			if(ignoreACG[i] == 0){
				double xyao = obj[i];
				
				List<TrBean> erlist = new ArrayList<TrBean>();
				
				//计算与本命星曜关系
				for (int j = 0; j < obj1.length; j++) {
					if(ignoreACG1[j] == 0){
						double xyao1 = obj1[j];
						TrBean tb = new TrBean();
						tb.setR1(i);
						tb.setR2(j);
						
						//特殊处理，土木天海冥,内外盘
						String[] phase2 = null;
						/*if(null != fr && (i == 6 || i == 7 || i == 8|| i == 9|| i == 10) && (j == 6 || j == 7 || j == 8|| j == 9|| j == 10)){
							phase2 = Constants.calculationPhase(xyao, xyao1, phase, fr);
						}else{
							phase2 = Constants.calculationPhase(xyao, xyao1, phase, r);
						}*/
						if(null != fr && (i == 6 || i == 7 || i == 8|| i == 9|| i == 10)){
							phase2 = Constants.calculationPhase(xyao, xyao1, phase, fr);
						}else{
							phase2 = Constants.calculationPhase(xyao, xyao1, phase, r);
						}
						
						if(null != phase2 && phase2.length>0){
							tb.setR3(phase2[0]);
							tb.setR9(Double.valueOf(phase2[1]));
						}
						
						//宫位
						int sartTheSart = Constants.getSartTheSart(cusp, xyao);
						tb.setR4(sartTheSart);
						if(null != cusp1){
							int sartTheSart1 = Constants.getSartTheSart(cusp1, xyao);
							tb.setR4z(sartTheSart1);
						}
						
						//计算所在星座
						int whoConstellation = Constants.whoConstellation(xyao);
						tb.setR5(whoConstellation);
						
						//守护宫(整宫制)
						String constellation = Constants.StarGong(j);
						//判断该星座在哪个宫位
						if(null != constellation){
							String[] split = constellation.split("/");
							StringBuffer sb = new StringBuffer();
							for (int k = 0; k < split.length; k++) {
								double is_360 = is_360(cusp1[Integer.valueOf(split[k])] - cusp1[1]);
								int sartTheSart1 = Constants.getSartTheSart(cusp1, is_360);
								//sartTheSart1++;
								if(sartTheSart1 > 12){
									sartTheSart1 = 1;
								}
								sb.append(sartTheSart1).append(",");
							}
							tb.setR6(sb.toString());
						}
						
						//计算宫头
						if(cusp.length > 0){
							String[] sartPalace = sartPalace(xyao, cusp,cusp1, phase, r);
							tb.setR7(sartPalace[0]);	//分
							tb.setR7z(sartPalace[1]);	//整
						}
						//计算司掌宫位
						String palmSecretary = Constants.palmSecretary(j);
						tb.setR8(palmSecretary);
						
						erlist.add(tb);
					}
				}
				//过滤空，并保留最少一条
				List<TrBean> tanlist = new ArrayList<TrBean>();
				int size = erlist.size();
				if(size > 1){
					int index = size - 1;
					for (int j = 0; j < size; j++) {
						TrBean trBean = erlist.get(j);
						String r3 = trBean.getR3();
						if((null != r3 && !"".equals(r3))|| (j == index)){
							tanlist.add(trBean);
							index++;
						}
						
					}
				}
				//合并
				list.addAll(tanlist);
			}
		}
		return list;
	}
	
	/**
	 * 规则表2 (TR)branch
	 * 外盘星耀与本命星耀发生相位,外盘星耀在本命盘cusp哪个宫位内
	 * @param ignoreACG	内盘
	 * @param ignoreACG1外盘
	 * @param obj		外盘星耀
	 * @param obj1		本命星耀
	 * @param cusp		本命分宫位
	 * @param cusp1		本命整宫位
	 * @param phase		相位集合
	 * @param r			容许度
	 * @param fr		土天海冥 容许度特殊计算(null 则忽略fr，只计算r)
	 * @return list     外盘星耀,本命星耀,多少度相位,本命星耀在本命盘第几宫,obj所在星座,外盘星耀与本命宫头发生相位
	 */
	public static List<TrBean> startandStart_branch(byte[] ignoreACG,byte[] ignoreACG1,double[] obj,double[] obj1,double[] cusp,double[] cusp1,String[] phase,double r,Double fr){
		List<TrBean> list = new ArrayList<TrBean>();
		for (int i = 0; i < obj.length; i++) {
			if(ignoreACG[i] == 0){
				double xyao = obj[i];
				
				List<TrBean> erlist = new ArrayList<TrBean>();
				
				//计算与本命星曜关系
				for (int j = 0; j < obj1.length; j++) {
					if(ignoreACG1[j] == 0){
						double xyao1 = obj1[j];
						TrBean tb = new TrBean();
						tb.setR1(i);
						tb.setR2(j);
						
						//特殊处理，土木天海冥,内外盘
						String[] phase2 = null;
						/*if(null != fr && (i == 6 || i == 7 || i == 8|| i == 9|| i == 10) && (j == 6 || j == 7 || j == 8|| j == 9|| j == 10)){
							phase2 = Constants.calculationPhase(xyao, xyao1, phase, fr);
						}else{
							phase2 = Constants.calculationPhase(xyao, xyao1, phase, r);
						}*/
						if(null != fr && (i == 3 || i == 4)){
							phase2 = Constants.calculationPhase(xyao, xyao1, phase, fr);
						}else{
							phase2 = Constants.calculationPhase(xyao, xyao1, phase, r);
						}
						
						
						if(null != phase2){
							tb.setR3(phase2[0]);
						}
						
						//宫位
						int sartTheSart = Constants.getSartTheSart(cusp, xyao);
						tb.setR4(sartTheSart);
						if(null != cusp1){
							int sartTheSart1 = Constants.getSartTheSart(cusp1, xyao);
							tb.setR4z(sartTheSart1);
						}
						
						//计算所在星座
						int whoConstellation = Constants.whoConstellation(xyao);
						tb.setR5(whoConstellation);
						
						//守护宫(整宫制)
						String constellation = Constants.StarGong(j);
						//判断该星座在哪个宫位
						if(null != constellation){
							String[] split = constellation.split("/");
							StringBuffer sb = new StringBuffer();
							for (int k = 0; k < split.length; k++) {
								double is_360 = is_360(cusp1[Integer.valueOf(split[k])] - cusp1[1]);
								int sartTheSart1 = Constants.getSartTheSart(cusp1, is_360);
								//sartTheSart1++;
								if(sartTheSart1 > 12){
									sartTheSart1 = 1;
								}
								sb.append(sartTheSart1).append(",");
							}
							tb.setR6(sb.toString());
						}
						
						//计算宫头
						if(cusp.length > 0){
							String[] sartPalace = sartPalace(xyao, cusp,cusp1, phase, r);
							tb.setR7(sartPalace[0]);	//分
							tb.setR7z(sartPalace[1]);	//整
						}
						//计算司掌宫位
						String palmSecretary = Constants.palmSecretary(j);
						tb.setR8(palmSecretary);
						
						erlist.add(tb);
					}
				}
				//过滤空，并保留最少一条
				List<TrBean> tanlist = new ArrayList<TrBean>();
				int size = erlist.size();
				if(size > 1){
					int index = size - 1;
					for (int j = 0; j < size; j++) {
						TrBean trBean = erlist.get(j);
						String r3 = trBean.getR3();
						if((null != r3 && !"".equals(r3))|| (j == index)){
							tanlist.add(trBean);
							index++;
						}
						
					}
				}
				//合并
				list.addAll(tanlist);
			}
		}
		return list;
	}
	
	/**
	 * 规则表2 (TR)
	 * 外盘星耀与本命星耀发生相位,外盘星耀在本命盘cusp哪个宫位内
	 * @param ignoreACG	内盘
	 * @param ignoreACG1外盘
	 * @param obj		外盘星耀
	 * @param obj1		本命星耀
	 * @param cusp		本命分宫位
	 * @param cusp1		本命整宫位
	 * @param phase		相位集合
	 * @param r			容许度
	 * @param fr		土天海冥 容许度特殊计算(null 则忽略fr，只计算r)
	 * @return list     外盘星耀,本命星耀,多少度相位,本命星耀在本命盘第几宫,obj所在星座,外盘星耀与本命宫头发生相位
	 */
	public static List<TrMonyBean> startandStartmony(byte[] ignoreACG,byte[] ignoreACG1,double[] obj,double[] obj1,double[] cusp,double[] cusp1,String[] phase,double r,Double fr){
		List<TrMonyBean> list = new ArrayList<TrMonyBean>();
		for (int i = 0; i < obj.length; i++) {
			if(ignoreACG[i] == 0){
				double xyao = obj[i];
				
				List<TrMonyBean> erlist = new ArrayList<TrMonyBean>();
				
				//计算与本命星曜关系
				for (int j = 0; j < obj1.length; j++) {
					if(ignoreACG1[j] == 0){
						double xyao1 = obj1[j];
						TrMonyBean tb = new TrMonyBean();
						tb.setR1(i);
						tb.setR2(j);
						
						//特殊处理，天海冥土木,内外盘
						String[] phase2 = null;
						if(null != fr && (i == 6 || i == 7 || i == 8|| i == 9|| i == 10) && (j == 6 || j == 7 || j == 8|| j == 9|| j == 10)){
							phase2 = Constants.calculationPhase(xyao, xyao1, phase, fr);
						}else{
							phase2 = Constants.calculationPhase(xyao, xyao1, phase, r);
						}
						
						if(null != phase2){
							tb.setR3(phase2[0]);
						}
						
						//tr星曜在第几宫(分)
						int sartTheSart = Constants.getSartTheSart(cusp, xyao);
						tb.setR4(sartTheSart);
						if(null != cusp1){
							int sartTheSart1 = Constants.getSartTheSart(cusp1, xyao);
							tb.setR4z(sartTheSart1);
						}
						
						//na星曜在第几宫(分)
						int sartTheSart2 = Constants.getSartTheSart(cusp, xyao1);
						tb.setR5(sartTheSart2);
						if(null != cusp1){
							int sartTheSart2s = Constants.getSartTheSart(cusp1, xyao1);
							tb.setR5z(sartTheSart2s);
						}
						
						//计算所在星座
						int whoConstellation = Constants.whoConstellation(xyao);
						tb.setR6(whoConstellation);
						
						erlist.add(tb);
					}
				}
				//过滤空，并保留最少一条
				List<TrMonyBean> tanlist = new ArrayList<TrMonyBean>();
				int size = erlist.size();
				if(size > 1){
					int index = size - 1;
					for (int j = 0; j < size; j++) {
						TrMonyBean trBean = erlist.get(j);
						String r3 = trBean.getR3();
						if((null != r3 && !"".equals(r3))|| (j == index)){
							tanlist.add(trBean);
							index++;
						}
						
					}
				}
				//合并
				list.addAll(tanlist);
			}
		}
		return list;
	}
	/**
	 * 规则表2 (本命，不计算相同星曜)
	 * 外盘星耀与本命星耀发生相位,外盘星耀在本命盘cusp哪个宫位内
	 * @param ignoreACG	内盘
	 * @param ignoreACG1外盘
	 * @param obj		外盘星耀
	 * @param obj1		本命星耀
	 * @param cusp		分宫
	 * @param cusp1		整宫
	 * @param phase		相位集合
	 * @param r			容许度
	 * @param r1		针对 容许度
	 * @return list     外盘星耀,本命星耀,多少度相位,本命星耀在本命盘第几宫
	 */
	public static List<TrBean> startandStart1(byte[] ignoreACG,byte[] ignoreACG1,double[] obj,double[] obj1,double[] cusp,double[] cusp1,String[] phase){
		List<TrBean> list = new ArrayList<TrBean>();
		for (int i = 0; i < obj.length; i++) {
			if(ignoreACG[i] == 0){
				double xyao = obj[i];
				
				List<TrBean> erlist = new ArrayList<TrBean>();
				//计算星耀关系
				for (int j = 0; j < obj1.length; j++) {
					if(ignoreACG1[j] == 0 && i != j){
						double xyao1 = obj1[j];
						TrBean tb = new TrBean();
						tb.setR1(i);
						tb.setR2(j);
						
						String phase2 = Constants.calculationNaPhase(xyao, xyao1, phase);
						if(null != phase2){
							tb.setR3(phase2);
						}
						//宫位
						int sartTheSart = Constants.getSartTheSart(cusp, xyao);
						tb.setR4(sartTheSart);
						if(null != cusp1){
							int sartTheSart1 = Constants.getSartTheSart(cusp1, xyao);
							tb.setR4z(sartTheSart1);
						}
						
						//星座
						int whoConstellation = Constants.whoConstellation(xyao);
						tb.setR5(whoConstellation);
						
						//守护宫(整宫制)
						String constellation = Constants.StarGong(i);
						//判断该星座在哪个宫位
						if(null != constellation){
							String[] split = constellation.split("/");
							StringBuffer sb = new StringBuffer();
							for (int k = 0; k < split.length; k++) {
								double is_360 = is_360(cusp1[Integer.valueOf(split[k])] - cusp1[1]);
								int sartTheSart1 = Constants.getSartTheSart(cusp1, is_360);
								//sartTheSart1++;
								if(sartTheSart1 > 12){
									sartTheSart1 = 1;
								}
								sb.append(sartTheSart1).append(",");
							}
							tb.setR6(sb.toString());
						}
						
						//计算司掌宫位
						String palmSecretary = Constants.palmSecretary(i);
						tb.setR8(palmSecretary);
						erlist.add(tb);
					}
				}
				//过滤空，并保留最少一条
				List<TrBean> tanlist = new ArrayList<TrBean>();
				int size = erlist.size();
				if(size > 1){
					int index = size - 1;
					for (int j = 0; j < size; j++) {
						TrBean trBean = erlist.get(j);
						String r3 = trBean.getR3();
						if((null != r3 && !"".equals(r3))|| (j == index)){
							tanlist.add(trBean);
							index++;
						}
						
					}
				}
				//合并
				list.addAll(tanlist);
			}
		}
		return list;
	}
	
	/**
	 * 规则表2 (整宫制,不计算相同星曜)
	 * @param ignoreACG	内盘
	 * @param obj		外盘星耀
	 * @param cusp		本命宫位
	 * @return list     
	 */
	public static List<TrBean> startandStart2(byte[] ignoreACG,double[] obj,double[] cusp){
		List<TrBean> list = new ArrayList<TrBean>();
		for (int i = 0; i < obj.length; i++) {
			if(ignoreACG[i] == 0){
				double xyao = obj[i];
				TrBean tb = new TrBean();
				tb.setR1(i);
				
				//宫位
				int sartTheSart = Constants.getSartTheSart(cusp, xyao);
				tb.setR4(sartTheSart);
				
				//星座
				int whoConstellation = Constants.whoConstellation(xyao);
				tb.setR5(whoConstellation);
				
				list.add(tb);
			}
		}
		return list;
	}
	
	/**
	 * 规则2-1
	 * TR星耀对应 本命盘星耀,守护宫位,宫主星 
	 * @param ignoreACG 
	 * @param startandStart	规则表2 
	 * @param cusp			本命盘宫位
	 * @param r
	 * @return  value=外盘星耀,本命星耀,多少度相位,第几宫 ,星座,守护星耀
	 */
	public static List<TrBean> trGuardGong24(byte[] ignoreACG,List<TrBean> startandStart,double[] cusp){
		List<TrBean> list = new ArrayList<TrBean>();
		for (int i = 0; i < startandStart.size(); i++) {
			TrBean tb = startandStart.get(i);	//外盘星耀,本命星耀,多少度相位,第几宫
			//星座
			int whoConstellation = Constants.whoConstellation(cusp[1]);
			
			
			//String constellation2 = Constants.getConstellation(tb.getR1());
			//tb.setR9(constellation2);
			list.add(tb);
			//list.add(strarr+","+whoConstellation+","+constellation);
		}
		return list;
	}
	
	/**
	 * 计算出入相位
	 * v1 = get_planet_sd(index1)*v1;
	 * v2 = get_planet_sd(index2)*v2;
	 * @param a
	 * @param b
	 * @param av
	 * @param bv
	 * @param val
	 * @param rxd
	 */
	public String compare_speed(double d1,double d2,double v1,double v2,int val,double rxdval){
		//如果是月亮，则速率设为最大
	    if(v1 == 0 || v1 == 360){
	        v1 = 1;
	    }
	    if(v2 == 0 || v2 == 360){ 
	        v2 = 1;
	    }
	    
	    if(v1 > v2){
	        //慢星=d2
	    	double y1 = d2 + val;
	    	double y2 = d2 - val;

	        if(y1 + rxdval < d1||y1 - rxdval <d1){
	            if(d1 > y1){
	                return "S";
	            }else{
	                return "A";
	            }
	        }
	        if(y2 + rxdval < d1||y2 - rxdval <d1){
	            if(d1 > y2){
	                return "S";
	            }else{
	                return "A";
	            }
	        }
	    }else{
	        //慢星=d1
	    	double y1 = d1 + val;
	    	double y2 = d1 - val;

	        if(y1 + rxdval < d2||y1 - rxdval <d2){
	            if(d2 > y1){
	                return "S";
	            }else{
	                return "A";
	            }
	        }
	        if(y2 + rxdval < d2||y2 - rxdval <d2){
	            if(d2 > y2){
	                return "S";
	            }else{
	                return "A";
	            }
	        }
	    }
		return null;
	}
	
	//临时处理整宫制度数
	public static double[] house_asc_sign(double[] cusp){
		double[] json = new double[13];
		//取第一个
		double c1 = cusp[1];
		double d = get_house_d(c1);
		json[0] = 0;
		json[1] = d;
	    for(int i=1;i<12;i++){
	    	json[i+1] = is_360(d + i * 30);
	    }
	    return json;
	}
	
	//处理整宫制始度数
	private static double get_house_d(double d){
	    for(int i = 0; i<12;i++){
	    	double a = i *30;
	    	double b = (i+1) *30;
	        if(a<d && d<b){
	            return a;
	        }
	    }
	    return 0;
	}
	
	private static double is_360(double du){
	    if(du > 360){
	        return du - 360;
	    }
	    if(du < 0){
	        return 360 + du;
	    }
	    return du;
	}
	
	//返回行星速度
	private double get_planet_sd(int index){
	    if(index == 1){
	        return 1;
	    }
	    if(index == 2){
	        return 13;
	    }
	    if(index == 3){
	        return 4.090909;
	    }
	    if(index == 4){
	        return 1.48148148;
	    }
	    if(index == 5){
	        return 0.366;
	    }
	    if(index == 6){
	        return 0.083;
	    }
	    if(index == 7){
	        return 0.0333;
	    }
	    if(index == 8){
	        return 0.0117351;
	    }
	    if(index == 9){
	        return 0.0059817;
	    }
	    if(index == 10){
	        return 0.0039726;
	    }
	    if(index == 16){
	        return 0.053;
	    }
	    if(index == 17){
	        return 0.053;
	    }
	    if(index == 22){
	        return 0.00001;
	    }
	    if(index == 31){
	        return 0.00001;
	    }
	    return 0;
	}
}