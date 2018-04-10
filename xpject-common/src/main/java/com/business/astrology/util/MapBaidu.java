package com.business.astrology.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

/***
 * 根据地址得出经纬度（http://lbsyun.baidu.com/apiconsole/key）
 * @author Administrator
 *http://lbsyun.baidu.com/index.php?title=uri/api/web
 *http://blog.csdn.net/ljj821061514/article/details/52121995
 */
public class MapBaidu {

	private static String AK="Y6OK9HEThGEIIInOMtNdT1I7";//百度密钥
	private static String URL= "http://api.map.baidu.com/geocoder/v2/";//查询地址的对应的经纬度接口
	private static Integer LNG= 120;//北京时间，8时区
	
	
	public static void main(String[] args) throws IOException {  
        MapBaidu getLatAndLngByBaidu = new MapBaidu();  
          
        Map<String,Double> map=getLatAndLngByBaidu.getLngAndLat("深圳罗湖");  
        System.out.println("经度："+map.get("lng")+"---纬度："+map.get("lat")); 
        Double lng = 121.558;
        getLatAndLngByBaidu.getTransform(lng);
    }  
    
	
	/***
	 * 根据地址获取与北京时间的时间差
	 * @param address
	 * @return
	 */
	public String timeDifference(String address){
		Map<String,Double> addressMap = getLngAndLat(address);//根据地址获取
		//System.out.println("经度："+addressMap.get("lng")+"---纬度："+addressMap.get("lat")); 
		String time = getTransform(addressMap.get("lng"));//根据经度获取与当前时间的时间差
		//String time = getTransform(114.);//根据经度获取与当前时间的时间差
		return time;
	}
	
	
	
	/***
	 * 根据地址获取
	 * @param address
	 * @return
	 */
    public  Map<String,Double> getLngAndLat(String address){  
        Map<String,Double> map=new HashMap<String, Double>();  
        StringBuffer url= new StringBuffer();
        url.append(URL);
        url.append("?");
        url.append("address="+address);
        url.append("&output=json");
        url.append("&ak="+AK);
        String json = loadJSON(url.toString());  
        JSONObject obj = JSONObject.fromObject(json);  
        if(obj.get("status").toString().equals("0")){  
            double lng=obj.getJSONObject("result").getJSONObject("location").getDouble("lng");  
            double lat=obj.getJSONObject("result").getJSONObject("location").getDouble("lat");  
            map.put("lng", lng);  
            map.put("lat", lat);  
            //System.out.println("经度："+lng+"---纬度："+lat);  
        }else{  
            //System.out.println("未找到相匹配的经纬度！");  
        }  
        return map;  
    }  
    
    
     /***
      * 百度经纬度返回的值解析
      * @param url
      * @return
      */
     private  String loadJSON (String url) {  
        StringBuilder json = new StringBuilder();  
        try {  
            URL oracle = new URL(url);  
            URLConnection yc = oracle.openConnection();  
            BufferedReader in = new BufferedReader(new InputStreamReader(  
                                        yc.getInputStream(),"UTF-8"));  
            String inputLine = null;  
            while ( (inputLine = in.readLine()) != null) {  
                json.append(inputLine);  
            }  
            in.close();  
        } catch (MalformedURLException e) {  
        } catch (IOException e) {  
        }  
        return json.toString();  
    }
     
     
     public String getTransform(Double val){
    	 int start=(int) Math.floor(val);//获取头部数值
    	 //System.out.println("获取小时数："+start);
    	 
    	 //System.out.println(val%1);
    	 String minuteZhi =new java.text.DecimalFormat("0.0000").format(val%1);//获取小数点4为（val%1是了只要整数后面的值）
    	 //System.out.println("minuteZhi:"+minuteZhi);
    	 Double minuteVal = Double.valueOf(minuteZhi);
    	 //System.out.println("minuteVal:"+minuteVal);
    	 
    	 
    	Integer endMiao= (int) Math.floor(minuteVal*240);
    	 //System.out.println("现在经度时间的秒："+endMiao);
    	 if(start < LNG){
    		 int m =(LNG-start)*4*60-endMiao;//3600-120=3480
    		 int hour=(int) Math.floor(m/3600);//小时
    		 //System.out.println("小时："+hour);
    		 int fen=(int) Math.floor((m%3600)/60);//分钟
    		 //System.out.println("分钟："+fen);
    		 int miao=(int) Math.floor(m%60);//秒
    		 //System.out.println("秒："+miao);
    		 StringBuffer sb= new StringBuffer();
    		 sb.append("-");
    		 sb.append(hour+":");
    		 sb.append(fen+":");
    		 sb.append(miao);
    		 //System.out.println("结果："+sb);
    		 return sb.toString();
    	 }else if(start >= LNG){
    		 int m =(start-LNG)*4*60+endMiao;
    		 int hour=(int) Math.floor(m/3600);//获取头部数值获取小时
    		 //System.out.println("小时："+hour);
    		 int fen=(int) Math.floor((m%3600)/60);//获取头部数值
    		 //System.out.println("分钟："+fen);
    		 int miao=(int) Math.floor(m%60);//秒
    		 //System.out.println("秒："+miao);
    		 StringBuffer sb= new StringBuffer();
    		 sb.append("+");
    		 sb.append(hour+":");
    		 sb.append(fen+":");
    		 sb.append(miao);
    		 //System.out.println("结果："+sb);
    		 return sb.toString();
    	 }else {
			 //System.out.println("结果："+"+0:0:00");
    		 return "+0:0:00"; 
    	 }
    
     }
     
     
}
