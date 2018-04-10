package com.business.astrology.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Bazi {

	public static void main(String[] args) {
		SolarTerm st =new SolarTerm();
		Map<Integer,String> jq=st.JQtest(2049);
		System.out.println("======================");
		System.out.println(jq);
		
		String address="河南省郑州市管城回族区";//地址
		String dateTime = "2018-02-01 09:40:00";//时间
		Bazi bz =new Bazi();
		Calendar mancal = bz.getCalendarfromString(dateTime, "yyyy-MM-dd HH:mm:ss");
		MapBaidu bd = new MapBaidu();
		String time =bd.timeDifference(address);//平太阳时间差
		Calendar cl = bz.getlocaltime(time, mancal);
		System.out.println("平太阳时>>>>>"+bz.outputCalendar(cl));//获取正式时间（平太阳时）
		Calendar ts = bz.TrueSun(cl);//算出正太阳时
		System.out.println("真太阳时>>>>>"+bz.outputCalendar(ts));//获取正式时间（真太阳时）
		bz.paipan(ts);
		
		System.out.println(time);
		bz.timeZone(time);//得出时区

		
	}
	
	/***
	 * 根据时间和经度获取真太阳时
	 * @param lng 经度
	 * @param datetime 公历时间
	 * @return
	 */
	public Calendar getsunPing(Double lng,Calendar datetime){
		MapBaidu bd = new MapBaidu();
		String time = bd.getTransform(lng);//平太阳时间差
		Calendar cl = getlocaltime(time, datetime);//获取正式时间（平太阳时）
		Calendar ts = TrueSun(cl);//获取正式时间（真太阳时）
		return ts;
		
	}
	
	/***
	 * 根据时间和经度获取真太阳时
	 * @param lng 经度
	 * @param datetime 公历时间
	 * @return
	 */
	public Calendar getsunPing(Double lng,String datetime){
		MapBaidu bd = new MapBaidu();
		String time = bd.getTransform(lng);//平太阳时间差
		Calendar mancal = getCalendarfromString(datetime, "yyyy-MM-dd HH:mm:ss");
		Calendar cl = getlocaltime(time, mancal);//获取正式时间（平太阳时）
		Calendar ts = TrueSun(cl);//获取正式时间（真太阳时）
		return ts;
		
	}
	
	/***
	 * 获取相对时区
	 * @param paramString
	 * @return
	 */
	public String timeZone(String paramString){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = "2017-12-20 08:00:00";//时区  
		Date date =null;
		try {
			date = formatter.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String str = paramString.substring(0, 1);  
	    String[] arrayOfString = paramString.substring(1).split(":"); 
	    long cha=(Integer.valueOf(arrayOfString[0])*3600+Integer.valueOf(arrayOfString[1])*60+Integer.valueOf(arrayOfString[2]))*1000;
	    Date st =new Date();
	    if(str.equals("-")){
	    	st.setTime(date.getTime()-cha);
	    }else{
	    	st.setTime(date.getTime()+cha);
	    }
	    SimpleDateFormat formatter2 = new SimpleDateFormat("HH:mm:ss");
	    String dateCha = formatter2.format(st);
	    //System.out.println("时间差："+dateCha);
	    return dateCha;
	}
	
	public Map<String,String> paipan(Calendar cal){
		TrueSun lunar = new TrueSun(cal);
		Double hous =(double) cal.get(Calendar.HOUR_OF_DAY); 
		int time =  (int) Math.ceil(hous/2);
		
		
		String GanZhi = lunar.getYearGanZhi(time,cal);//取八字 
		System.out.println("此人农历的日期【"+lunar.toString()+"】");  
	    System.out.println("此人八字【" + lunar.getYearGanZhi(time,cal) + "】"); 
	    //获取生肖  
	    System.out.println("此人的农历生肖【" + lunar.animalsYear() + "】");  
		String[] tempchar = GanZhi.split(",");  
		//我修改原来的，用,分割  
        String ganziyear = tempchar[0];//年柱  
        String ganzimonth = tempchar[1];//月柱  
        String ganziday = tempchar[2];//日柱  
        String ganzitime = tempchar[3];//时柱  
		System.out.println("年柱："+ganziyear);
		System.out.println("月柱："+ganzimonth);
		System.out.println("日柱："+ganziday);
		System.out.println("时柱："+ganzitime);
		Map<String,String> map =  new HashMap<String, String>();
		map.put("lunar", lunar.toString());//农历显示时间
		map.put("lunartime", lunar.toInt());//农历时间(时间格式yyyy-MM-dd)
		map.put("lunartime",String.valueOf(lunar.getDate().getTime()));//农历毫秒数
		map.put("zodiac", lunar.animalsYear());//生肖
   	 	map.put("year", ganziyear);//年柱
   	 	map.put("month", ganzimonth);//月柱
   	 	map.put("day", ganziday);//日柱
   	 	map.put("hour", ganzitime);//时柱
        return map;
	}
		
	
	 /** 
     * 计算平太阳时间差 
     * 
     * @param paramString 时间差 
     * @param cal 当前时间 
     * @return 返回计算好的时间 
     */  
    public  Calendar getlocaltime(String paramString, Calendar cal) {  
        Calendar returnCalendar = (Calendar) cal.clone();  
        String str = paramString.substring(0, 1);  
        String[] arrayOfString = paramString.substring(1).split(":");  
        int n;  
        if(arrayOfString.length == 3){//地区时间差存在小时  
            n = 3600 * Integer.parseInt(arrayOfString[0]) + 60 * Integer.parseInt(arrayOfString[1]) + Integer.parseInt(arrayOfString[2]);  
        }else{ //日期 时间差只有分钟  
            n = 60 * Integer.parseInt(arrayOfString[0]) + Integer.parseInt(arrayOfString[1]);  
        }
        if (str.equals("+")) {  
            returnCalendar.add(Calendar.SECOND, n);  
        } else {  
            returnCalendar.add(Calendar.SECOND, n * -1);   
        }  
        return returnCalendar;  
    } 
    
    
    /***
     * 获取时间
     * @param c
     * @return
     */
    public String  outputCalendar(Calendar c) {  
        System.out.print(c.get(Calendar.YEAR) + "年" + "\t");//得到年份  
        System.out.print(c.get(Calendar.MONTH) + 1 + "月" + "\t");//得到月份 月份加1，JAVA月份从0开始 可以说是BUG  
        System.out.print(c.get(Calendar.DATE) + "日" + "\t");//得到日份  
        System.out.print(c.get(Calendar.HOUR_OF_DAY) + "点" + "\t");//得到小时  
        System.out.print(c.get(Calendar.MINUTE) + "分" + "\t");//得到分钟  
        System.out.print(c.get(Calendar.SECOND) + " 秒" + "\t");//得到分钟  
        System.out.println("");  
        /*StringBuffer sb = new StringBuffer();
        sb.append(c.get(Calendar.YEAR)+"-");
        sb.append(c.get(Calendar.MONTH)+1+"-");
        sb.append(c.get(Calendar.DATE)+" ");
        sb.append(c.get(Calendar.HOUR_OF_DAY)+":");
        sb.append(c.get(Calendar.MINUTE)+":");
        sb.append(c.get(Calendar.SECOND));
        return sb.toString();*/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(c.getTime());
        return dateStr;
    }
    
    /***
     * 时间格式转换
     * @param year
     * @param DateFormat
     * @return
     * @throws ParseException
     */
    public Calendar getCalendarfromString(String year, String DateFormat) {  
        SimpleDateFormat sdf = new SimpleDateFormat(DateFormat);  
        Calendar cal = Calendar.getInstance();  
        try {
			cal.setTime(sdf.parse(year));
		} catch (ParseException e) {
			e.printStackTrace();
		}  
        return cal;  
    } 
    
    /***
     * 根据平太阳时获取真太阳时
     * 
     * 真太阳时＝平太阳时+真平太阳时差。
     *	2.1.1  平太阳时(地方标准时间)=北京标准时间+4分×(地方经度—120度)。
     *	2.1.2  真平太阳时差(真太阳时—平太阳时)= 9.5m*Sin(2L)—7.7m*Sin(L+78°)，其中L=280°+0.9856°t (m为分钟；Sin为三角函数；t为每年自1月1日以后的天数,不包括1月1日)。（此节内容参见了《北京标准时间与各地真太阳时的换算法》，孙吉山，洪薇）
	 *	3 计算举例
  	 *	试计算重庆市万州区2009年10月2日11时43分21秒(北京时间)的真太阳时。
  	 *	3.1 查询重庆市万州区的经度：可通过“易地图”（http://maps.eeeeee.org/51ditu/province/none/50/）查询，经度为：108.2度。
  	 *	3.2 计算t值：t=2009年1月1日至10月2日相距的天数=31+28+31+30+31+30+31+31+30+2-1=274
  	 *	3.3 计算L值:  L=280+0.9856*274=550.0544.
  	 *	3.4 计算真平太阳时差=9.5m*sin(2*550.0544)-7.7m*sin(550.0544+78)
	 *	=9.5m*(0.3438)-7.7m*(-0.9994)
	 *	=3.2661m+7.6954m
	 *	=10.96m(10分58秒)
     * 	3.5 计算平太阳时=11时43分21秒+4分*(108.2-120)
	 *	=11时43分21秒-47分12秒
	 *	=10时56分09秒
	 *	3.6计算真太阳时= 平太阳时+真平太阳时差
	 *	=10时56分9秒+10分58秒
	 *	=11时07分07秒
     * @param cl
     * @return
     */
    public Calendar TrueSun(Calendar cl){
     	int t= cl.get(Calendar.DAY_OF_YEAR) -1;//获取是第多少天
     	Double L=280+0.9856*t;
     	//System.out.println("LLLLLLLLLLLLLL:"+L);
     	//System.out.println(Math.sin(2*L));
     	//System.out.println((7.7*60)*Math.sin(2*78));
     	Double cha =(9.5*60) * Math.sin((2*L)%180* Math.PI / 180)-(7.7*60)*Math.sin((2*78)%180* Math.PI / 180);
     	//System.out.println(">>>>>>>>>>>>>>>>>>>>>"+cha);
     	int zhen=(int) Math.floor(cha);
     	cl.add(Calendar.SECOND, -zhen); 
     	//System.out.println(zhen);
     	//System.out.println("<><><><><>+"+Math.sin((2*550.0544)%180* Math.PI / 180));
     	//System.out.println(9.5*Math.sin(2*550.0544)-7.7*Math.sin(550.0544+78));
     	return cl;
    }
}
