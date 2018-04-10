package com.business.astrology.util.ecl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.business.astrology.util.Constants;

/**
 * 中点星耀
 * @author xp
 */
public class MidpointStar {
	
	public static void getMidpointStar(Map<String, List<String>> base_point,double[] obj){
		Map<Integer,List<String>> maplist = new HashMap<Integer,List<String>>();
		for (Entry<String, List<String>> map : base_point.entrySet()) {
			String key = map.getKey();
			List<String> lis = map.getValue();
			for (int i = 0; i < lis.size(); i++) {
				String string = lis.get(i);
				String[] split = string.split(",");
				if(split[2].equals(key)){
					
					double d = Double.valueOf(split[3]);
					
					
					System.out.println("星座"+key+"上，"+split[0]+"/"+split[1]+",度数="+d);
				}
			}
		}
	}
	
	/**
	 * 
	 * @param a   中点行星key
	 * @param b   中点行星key
	 * @param r   需计算行星度数
	 * @param d[] 计算行星的中点数组 
	 * @return
	 */
	public static List<String> getzd(int a,int b,double r, double[] d){
		int[] phase1 = Constants.phase1;
		int[] phase2 = Constants.phase2;
		double MSAD = Constants.MSAD;
		
		//行星a,行星b,
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < d.length; i++) {
			double abs = Math.abs(r - d[i]);

			for (int j = 0; j < phase1.length; j++) {
				double val1 = abs - phase1[j];
				double val2 = abs - phase2[j];
				if((-MSAD < val1 && val1 < MSAD )||(-MSAD < val2 && val2 < MSAD)){
					String v = a+","+b+","+phase1[j]+"/"+phase2[j];
					//System.out.println(v);
					list.add(v);
				}
			}
		}
		return list;
		/*for (int i = 0; i < obj.length; i++) {
			if(Constants.ignoreACG[i] == 0 && key != i){
				double abs = Math.abs(obj[key] - obj[i]);
				4
				List<String> list = new ArrayList<String>();
				for (int j = 0; j < phase1.length; j++) {
					
					double val1 = abs - phase1[j];
					double val2 = abs - phase2[j];
					if((-MSAD < val1 && val1 < MSAD )||(-MSAD < val2 && val2 < MSAD)){
						String v = "";
						list.add(v);
					}
				}
			}
		}*/
	}
	
}
