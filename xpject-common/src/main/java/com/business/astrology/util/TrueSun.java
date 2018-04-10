package com.business.astrology.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.business.astrology.util.push.TrMoon;

/***
 * 根据西元的生日时辰获取某个人的生辰八字，以及农历生日 
 * @author Administrator
 *
 */
public class TrueSun {
	
	private final static Integer yearInitial=1900;//初始年
	private final static Integer monthInitial = 1;//初始月
	private final static Integer dayInitial = 31;//初始日
	
	 private int year;  
	    private int month;  
	    private int day;  
	    private boolean leap;  
	    Date baseDate = null;  
	   final static String chineseNumber[] = {"一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "腊"};  
	   final static String chineseNumberInt[] = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};  
	   final static String chineseNumberInts[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "11", "12"};  
	   public final static String[] Gan = {"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};  
	   public final static String[] Zhi = {"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};  
	   
	   private static final HashMap<String, String> GanKey= new HashMap<String,String>() {{ //年的初始月
		   put("甲","丙"); put("己","丙"); put("乙","戊"); put("庚","戊");
		   put("丙","庚");put("辛","庚"); put("丁","壬");put("壬","壬");
		   put("戊","甲");put("癸","甲");
	   }};
	   private static final HashMap<String, Integer> GanKeys= new HashMap<String,Integer>() {{ //天干的下标
		   put("甲",0);put("丙",2); put("戊",4); put("庚",6);put("壬",8);
	   }};
	   
	   public final static String[] jqr = {"丑","寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥","子"}; 
	   private static final HashMap<String, Integer> jqrs= new HashMap<String,Integer>() {{ //天干的下标
		   put("寅",0);put("卯",1); put("辰",2); put("巳",3);put("午",4);put("未",5);
		   put("申",6);put("酉",7); put("戌",8); put("亥",9);put("子",10);put("丑",11);
	   }};
	    static SimpleDateFormat chineseDateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	    final static long[] lunarInfo = new long[]{
	    	0x04bd8, 0x04ae0, 0x0a570, 0x054d5, 0x0d260, 0x0d950, 0x16554, 0x056a0, 0x09ad0, 0x055d2,  
	        0x04ae0, 0x0a5b6, 0x0a4d0, 0x0d250, 0x1d255, 0x0b540, 0x0d6a0, 0x0ada2, 0x095b0, 0x14977,  
	        0x04970, 0x0a4b0, 0x0b4b5, 0x06a50, 0x06d40, 0x1ab54, 0x02b60, 0x09570, 0x052f2, 0x04970,  
	        0x06566, 0x0d4a0, 0x0ea50, 0x06e95, 0x05ad0, 0x02b60, 0x186e3, 0x092e0, 0x1c8d7, 0x0c950,  
	        0x0d4a0, 0x1d8a6, 0x0b550, 0x056a0, 0x1a5b4, 0x025d0, 0x092d0, 0x0d2b2, 0x0a950, 0x0b557,  
	        0x06ca0, 0x0b550, 0x15355, 0x04da0, 0x0a5d0, 0x14573, 0x052d0, 0x0a9a8, 0x0e950, 0x06aa0,  
	        0x0aea6, 0x0ab50, 0x04b60, 0x0aae4, 0x0a570, 0x05260, 0x0f263, 0x0d950, 0x05b57, 0x056a0,  
	        0x096d0, 0x04dd5, 0x04ad0, 0x0a4d0, 0x0d4d4, 0x0d250, 0x0d558, 0x0b540, 0x0b5a0, 0x195a6,  
	        0x095b0, 0x049b0, 0x0a974, 0x0a4b0, 0x0b27a, 0x06a50, 0x06d40, 0x0af46, 0x0ab60, 0x09570,  
	        0x04af5, 0x04970, 0x064b0, 0x074a3, 0x0ea50, 0x06b58, 0x055c0, 0x0ab60, 0x096d5, 0x092e0,  
	        0x0c960, 0x0d954, 0x0d4a0, 0x0da50, 0x07552, 0x056a0, 0x0abb7, 0x025d0, 0x092d0, 0x0cab5,  
	        0x0a950, 0x0b4a0, 0x0baa4, 0x0ad50, 0x055d9, 0x04ba0, 0x0a5b0, 0x15176, 0x052b0, 0x0a930,  
	        0x07954, 0x06aa0, 0x0ad50, 0x05b52, 0x04b60, 0x0a6e6, 0x0a4e0, 0x0d260, 0x0ea65, 0x0d530,  
	        0x05aa0, 0x076a3, 0x096d0, 0x04bd7, 0x04ad0, 0x0a4d0, 0x1d0b6, 0x0d250, 0x0d520, 0x0dd45,  
	        0x0b5a0, 0x056d0, 0x055b2, 0x049b0, 0x0a577, 0x0a4b0, 0x0aa50, 0x1b255, 0x06d20, 0x0ada0  
	    };  
		   /* 0x0ada0  0x06d20  0x1b255  0x0aa50  0x0a4b0  0x0a577  0x049b0  0x055b2  0x056d0  0x0b5a0
			  0x0dd45  0x0d520  0x0d250  0x1d0b6  0x0a4d0  0x04ad0  0x04bd7  0x096d0  0x076a3  0x05aa0
			  0x0d530  0x0ea65  0x0d260  0x0a4e0  0x0a6e6  0x04b60  0x05b52  0x0ad50  0x06aa0  0x07954
			  0x0a930  0x052b0  0x15176  0x0a5b0  0x04ba0  0x055d9  0x0ad50  0x0baa4  0x0b4a0  0x0a950
			  0x0cab5  0x092d0  0x025d0  0x0abb7  0x056a0  0x07552  0x0da50  0x0d4a0  0x0d954  0x0c960
			  0x092e0  0x096d5  0x0ab60  0x05ac0  0x06b58  0x0ea50  0x074a3  0x064b0  0x04970  0x04af5
			  0x09570  0x0ab60  0x0af46  0x06d40  0x06a50  0x0b27a  0x0a4b0  0x0a974  0x049b0  0x095b0
			  0x195a6  0x0b6a0  0x0b540  0x0d558  0x0d250  0x0d4d4  0x0a4d0  0x04ad0  0x04dd5  0x096d0
			  0x056a0  0x05b57  0x0d950  0x0f263  0x05260  0x0a570  0x0aae4  0x04b60  0x0ab50  0x0aea6
			  0x06aa0  0x0e950  0x0a9a8  0x052b0  0x14573  0x0a5b0  0x04da0  0x15355  0x0b550  0x06ca0
			  0x0b557  0x0a950  0x0d2b2  0x092d0  0x025d0  0x1a5b4  0x056a0  0x0b550  0x1d8a6  0x0d4a0
			  0x0c950  0x1c8d7  0x092e0  0x186e3  0x02b60  0x05ad0*/
	    
	   // 0x06e95   0x0d6a0
	   // 0x16a95
	        /** 
	     * @return the month 
	     */  
	    public String getMonth() {  
	        return chineseNumber[month- 1] ;  
	    }  
	  
	    /** 
	     * @return the year 
	     */  
	    public String getYear() {  
	        return getYearStr(year);  
	    }  
	      
	     /** 
	     * @return the year 
	     */  
	    public int getnumberYear() {  
	        return year;  
	    }  
	      
	       /** 
	     * @return the year 
	     */  
	    public int getnumbermonth() {  
	        return month;  
	    }  
	        /** 
	     * @return the year 返回年的顺序，子0 丑2 
	     */  
	    public int getYearindex() {  
	          return (year - 4) % 12;  
	    }  
	  
	    /** 
	     * @return the day 
	     */  
	    public String getDay() {  
	        return getChinaDayString(day);  
	    }  
	    /** 
	     * 六十甲子 
	     */  
	    public static final String[] jiazhi = {  
	        "甲子", "乙丑", "丙寅", "丁卯", "戊辰", "己巳", "庚午", "辛未", "壬申", "癸酉",  
	        "甲戌", "乙亥", "丙子", "丁丑", "戊寅", "己卯", "庚辰", "辛巳", "壬午", "癸未",  
	        "甲申", "乙酉", "丙戌", "丁亥", "戊子", "己丑", "庚寅", "辛卯", "壬辰", "癸巳",  
	        "甲午", "乙未", "丙申", "丁酉", "戊戌", "己亥", "庚子", "辛丑", "壬寅", "癸卯",  
	        "甲辰", "乙巳", "丙午", "丁未", "戊申", "己酉", "庚戌", "辛亥", "壬子", "癸丑",  
	        "甲寅", "乙卯", "丙辰", "丁巳", "戊午", "己未", "庚申", "辛酉", "壬戌", "癸亥"  
	    };  
	    
	    private static final HashMap<String, Integer> jiazi= new HashMap<String,Integer>() {{ 
	        put("甲子",1);  put("乙丑",2);  put("丙寅",3);  put("丁卯",4);  put("戊辰",5);  put("己巳",6);  put("庚午",7);  put("辛未",8); put("壬申",9); put("癸酉",10);
	        put("甲戌",11); put("乙亥",12); put("丙子",13); put("丁丑",14); put("戊寅",15); put("己卯",16); put("庚辰",17); put("辛巳",18);put("壬午",19);put("癸未",20);
	        put("甲申",21); put("乙酉",22); put("丙戌",23); put("丁亥",24); put("戊子",25); put("己丑",26); put("庚寅",27); put("辛卯",28);put("壬辰",29);put("癸巳",30);
	        put("甲午",31); put("乙未",32); put("丙申",33); put("丁酉",34); put("戊戌",35); put("己亥",36); put("庚子",37); put("辛丑",38);put("壬寅",39);put("癸卯",40);
	        put("甲辰",41); put("乙巳",42); put("丙午",43); put("丁未",44); put("戊申",45); put("己酉",46); put("庚戌",47); put("辛亥",48);put("壬子",49);put("癸丑",50);
	        put("甲寅",51); put("乙卯",52); put("丙辰",53); put("丁巳",54); put("戊午",55); put("己未",56); put("庚申",57); put("辛酉",58);put("壬戌",59);put("癸亥",60);
		}}; 
		
		private static final HashMap<Integer,String> jiazhitwo= new HashMap<Integer,String>() {{ 
	        put(1,"甲子"); put(2,"乙丑"); put(3,"丙寅"); put(4,"丁卯"); put(5,"戊辰"); put(6,"己巳"); put(7,"庚午"); put(8,"辛未");put(9,"壬申");put(10,"癸酉");
	        put(11,"甲戌"); put(12,"乙亥"); put(13,"丙子"); put(14,"丁丑"); put(15,"戊寅"); put(16,"己卯"); put(17,"庚辰"); put(18,"辛巳");put(19,"壬午");put(20,"癸未");
	        put(21,"甲申"); put(22,"乙酉"); put(23,"丙戌"); put(24,"丁亥"); put(25,"戊子"); put(26,"己丑"); put(27,"庚寅"); put(28,"辛卯");put(29,"壬辰");put(30,"癸巳");
	        put(31,"甲午"); put(32,"乙未"); put(33,"丙申"); put(34,"丁酉"); put(35,"戊戌"); put(36,"己亥"); put(37,"庚子"); put(38,"辛丑");put(39,"壬寅");put(40,"癸卯");
	        put(41,"甲辰"); put(42,"乙巳"); put(43,"丙午"); put(44,"丁未"); put(45,"戊申"); put(46,"己酉"); put(47,"庚戌"); put(48,"辛亥");put(49,"壬子");put(50,"癸丑");
	        put(51,"甲寅"); put(52,"乙卯"); put(53,"丙辰"); put(54,"丁巳"); put(55,"戊午"); put(56,"己未"); put(57,"庚申"); put(58,"辛酉");put(59,"壬戌");put(60,"癸亥");
		}}; 
	    
	    private Calendar cal;  
	    /** 
	     * @param hour 这里的时间范围是1-12，具体几点到几点是子时、丑时请参考相关文档 
	     * 具体的选择如下 "子：1", "丑：2", "寅：3", "卯：4", "辰：5", "巳：6", "午：7", "未：8", "申：9", "酉：10", "戌：11", "亥：12"  
	     * @author kongqz 
	     * */  
	    public String getYearGanZhi(int hour,Calendar cal) {  
	        //1864年是甲子年，每隔六十年一个甲子  
	    	SolarTerm st =new SolarTerm();
	    	int years = cal.get(Calendar.YEAR)-1;    //获取年
	    	System.out.println("yearsyearsyears:"+years);
	    	Map<Integer,String> jq=st.JQtest(years);
	    	SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	Date solar=null;//立春时间
	    	try {
				 solar = sdf.parse(jq.get(2)) ;
			} catch (ParseException e) {
				e.printStackTrace();
			}
	    	int idx =0;
	    	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+sdf.format(cal.getTime().getTime()));
	    	System.out.println("1>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+sdf.format(solar));
	    	System.out.println("2>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+jq.get(2));
	    	if(cal.get(Calendar.YEAR) == year && cal.getTime().getTime() < solar.getTime()){//已经过年，并且还未立春
	    		idx = (year-1 - 1864) % 60;  
	    	}else if(cal.get(Calendar.YEAR) == year && cal.getTime().getTime() > solar.getTime()){//已经过年，已经立春
	    		idx = (year- 1864) % 60; 
	    	}else if(cal.get(Calendar.YEAR) > year && cal.getTime().getTime() < solar.getTime()){//还未过年，还未立春
	    		idx = (year- 1864) % 60; 
	    	}else if(cal.get(Calendar.YEAR) > year && cal.getTime().getTime() > solar.getTime()){//还未过年，已经未立春
	    		idx = (year+1 - 1864) % 60; 
	    	}else if(cal.get(Calendar.YEAR) > year && cal.getTime().getTime() == solar.getTime()){
	    		idx = (year- 1864) % 60;
	    	}
	    	
	        //没有过春节的话那么年还算上一年的，此处求的年份的干支  
	        String y = jiazhi[idx];  
	          
	        String m="";  
	        String d="";  
	        String h="";  
	        idx = idx % 5;  
	        int idxm=0;  
	        /** 
	         * 年上起月 
	         * 甲己之年丙作首，乙庚之岁戊为头， 
	         * 丙辛必定寻庚起，丁壬壬位顺行流， 
	         * 更有戊癸何方觅，甲寅之上好追求。 
	         */  
	        idxm=(idx+1)*2;  
	        if(idxm==10) idxm=0;  
	        //求的月份的干支  
	        /*int s=month;
	        int mon =  getJieqi(cal);
	        if(mon > 12){
	        	mon =1;
	        }
	        m=Gan[(idxm+mon-1)%10]+Zhi[(1+mon)%12]; */ 
	        
	        
	        
	        String monthEarthly=null;//月地支
	        String monthtian=null;//月天干
	        Date jiq=null;//节气时间
	        Date jiqtwo =null;//上一个节气时间
	        int months = cal.get(Calendar.MONTH)+1;    //获取月
	        Map<Integer,String> jqtwo=st.JQtest(years+1);
	        try {
		        if(months <= 3){
					jiq = sdf.parse(jq.get(months*2-2));
		        }else if(months == 12){
		        	String sj =jqtwo.get(0);
		        	jiq = sdf.parse(sj);
		        	String sjs =jqtwo.get(22);
		        	jiqtwo = sdf.parse(sjs);
		        }else{
		        	String sj =jqtwo.get(months*2-2);
		        	jiq = sdf.parse(sj);
		        	
		        }
	        } catch (ParseException e) {
				e.printStackTrace();
			}
	        if(cal.getTime().getTime() < jiq.getTime()){
	        	if(months == 1){
	        		monthEarthly = jqr[11];
	        	}else if(months == 2){
	        		monthEarthly = jqr[0];
	        	}else if(months == 12){
	        		if(cal.getTime().getTime() > jiqtwo.getTime()){
	        			monthEarthly = jqr[11];
	        		}else{
	        			monthEarthly = jqr[months-2];
	        		}
	        	}else{
	        		monthEarthly = jqr[months-2];
	        	}
	        }else{
	        	if(months == 1){
	        		monthEarthly = jqr[0];
	        	}else{
	        		monthEarthly = jqr[months-1];
	        	}
	        	
	        }
	        monthtian = getMonthTian(y,cal,jiq,monthEarthly);
	        m= monthtian+monthEarthly;
	        
	        //m=Gan[(idxm+month-1)%10]+Zhi[(month+2-1)%12];  
	         
	          
	        /*求出和yearInitial1900年1月31日甲辰日相差的天数  
	         * 甲辰日是第四十天 
	        */  
	        System.out.println((cal.getTime().getTime()+3600000L - baseDate.getTime()) / 86400000L);
	        int ho = cal.get(Calendar.HOUR_OF_DAY);  //获取时辰
	        int offset=0;
	        if(ho == 22){//晚上十点50多会有误差，统一30分钟
	        	 cal.set(Calendar.MINUTE, 30);
	        	 offset = (int) ((cal.getTime().getTime()+3600000 - baseDate.getTime()) / 86400000L); 
	        }else{
	        	 offset = (int) ((cal.getTime().getTime()+3600000 - baseDate.getTime()) / 86400000L); 
	        }
	        
	        offset=(offset+40)%60;  
	        //求的日的干支  
	      
	        d=jiazhi[offset];
	       
	          
	          
	        /** 
	         * 日上起时 
	         * 甲己还生甲，乙庚丙作初， 
	         * 丙辛从戊起，丁壬庚子居， 
	         * 戊癸何方发，壬子是真途。   
	         */   
	          
	        offset=(offset % 5 )*2;  
	        //求得时辰的干支   
	        /*int hos=0;
	        if(hour%2 == 0){
	        	hos=hour+1;
	        }else{
	        	hos=hour;
	        }*/
	        int hou = 0;
	        if(hour == 12){
	        	hou =0;
	        }else{
	        	hou =hour;
	        }
	        int zi=0;
	        if(hour != 12){
	        	zi =hour;
	        }
	        h=Gan[(offset+hou)%10]+Zhi[zi];  
	        //在此处输出我们的年月日时的天干地支  
	        return y+","+m+","+d+","+h;  
	    }  
	    public String getShichenFromDay(int offset){  
	         
	        return null;  
	    }  
	//====== 传回农历 y年的总天数  
	    final private static int yearDays(int y) {  
	        int i,  sum = 348;  
	        for (i = 0x8000; i > 0x8; i >>= 1) {  
	            if ((lunarInfo[y - yearInitial] & i) != 0) {  
	                sum += 1;  
	            }  
	        }  
	        return (sum + leapDays(y));  
	    }  
	//====== 传回农历 y年闰月的天数  
	    final private static int leapDays(int y) {  
	        if (leapMonth(y) != 0) {  
	            if ((lunarInfo[y - yearInitial] & 0x10000) != 0) {  
	                return 30;  
	            } else {  
	                return 29;  
	            }  
	        } else {  
	            return 0;  
	        }  
	    }  
	//====== 传回农历 y年闰哪个月 1-12 , 没闰传回 0  
	    final private static int leapMonth(int y) {  
	        return (int) (lunarInfo[y - yearInitial] & 0xf);  
	    }  
	//====== 传回农历 y年m月的总天数  
	    final private static int monthDays(int y, int m) {  
	        if ((lunarInfo[y - yearInitial] & (0x10000 >> m)) == 0) {  
	            return 29;  
	        } else {  
	            return 30;  
	        }  
	    }  
	/***  
	 * @return 传回农历 y年的生肖 
	 */  
	    final public String animalsYear() {  
	        final String[] Animals = new String[]{"鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪"};  
	        return Animals[(year - 4) % 12];  
	    }  
	//====== 传入 月日的offset 传回干支, 0=甲子  
	    final private static String cyclicalm(int num) {  
	        return (Gan[num % 10] + Zhi[num % 12]);  
	    }  
	//====== 传入 offset 传回干支, 0=甲子  
	    final public String cyclical() {  
	        int num = year - 1900 + 36;  
	        return (cyclicalm(num));  
	    }  
	    /** 
	     * 传出y年m月d日对应的农历. 
	     * yearCyl3:农历年与1864的相差数 ? 
	     * monCyl4:从1900年1月31日以来,闰月数 
	     * dayCyl5:与1900年1月31日相差的天数,再加40 ? 
	     * 
	     * @param cal 
	     * @return 
	     */  
	    public TrueSun(Calendar cal) {  
	        this.cal=cal;  
	        int yearCyl,  monCyl,  dayCyl;  
	        int leapMonth = 0;  
	          
	        try {  
	            baseDate = chineseDateFormat.parse(yearInitial+"-"+monthInitial+"-"+dayInitial);  
	        } catch (ParseException e) {  
	            e.printStackTrace(); //To change body of catch statement use Options | File Templates.  
	        }  
	//求出和1900年1月31日相差的天数  
	        int offset = (int) ((cal.getTime().getTime() - baseDate.getTime()) / 86400000L);  
	        dayCyl = offset + 40;  
	        monCyl = 14;  
	//用offset减去每农历年的天数  
	// 计算当天是农历第几天  
	//i最终结果是农历的年份  
	//offset是当年的第几天  
	        int iYear,  daysOfYear = 0;  
	        for (iYear = yearInitial; iYear < 2050 && offset > 0; iYear++) {  
	            daysOfYear = yearDays(iYear);  
	            offset -= daysOfYear;  
	            monCyl += 12;  
	        }  
	        if (offset < 0) {  
	            offset += daysOfYear;  
	            iYear--;  
	            monCyl -= 12;  
	        }  
	//农历年份  
	        year = iYear;  
	        yearCyl = iYear - 1864;  
	        leapMonth = leapMonth(iYear); //闰哪个月,1-12  
	        leap = false;  
	//用当年的天数offset,逐个减去每月（农历）的天数，求出当天是本月的第几天  
	        int iMonth,  daysOfMonth = 0;  
	        for (iMonth = 1; iMonth < 13 && offset > 0; iMonth++) {  
	//闰月  
	            if (leapMonth > 0 && iMonth == (leapMonth + 1) && !leap) {  
	                --iMonth;  
	                leap = true;  
	                daysOfMonth = leapDays(year);  
	            } else {  
	                daysOfMonth = monthDays(year, iMonth);  
	            }  
	            offset -= daysOfMonth;  
	//解除闰月  
	            if (leap && iMonth == (leapMonth + 1)) {  
	                leap = false;  
	            }  
	            if (!leap) {  
	                monCyl++;  
	            }  
	        }  
	//offset为0时，并且刚才计算的月份是闰月，要校正  
	        if (offset == 0 && leapMonth > 0 && iMonth == leapMonth + 1) {  
	            if (leap) {  
	                leap = false;  
	            } else {  
	                leap = true;  
	                --iMonth;  
	                --monCyl;  
	            }  
	        }  
	//offset小于0时，也要校正  
	        if (offset < 0) {  
	            offset += daysOfMonth; 
	      
	            --iMonth;  
	            --monCyl;  
	        }  
	        month = iMonth; 
	        day = offset + 1;  
	    }  
	    public static String getChinaDayString(int day) {  
	        String chineseTen[] = {"初", "十", "廿", "卅"};  
	        int n = day % 10 == 0 ? 9 : day % 10 - 1;  
	        if (day > 30) {  
	            return "";  
	        }  
	        if (day == 10) {  
	            return "初十";  
	        } else {  
	            return chineseTen[day / 10] + chineseNumber[n];  
	        }  
	    }  
	    
	    public static String getChinaDayInt(int day) {  
	        String chineseTen[] = {"0", "1", "2", "3"};  
	        int n = day % 10 == 0 ? 9 : day % 10 - 1;  
	        if (day > 30) {  
	            return "";  
	        }  
	        if (day == 10) {  
	            return "10";  
	        } else {  
	            return chineseTen[day / 10] + chineseNumberInts[n];  
	        }  
	    }  
	    
	    
	    
	    
	    public String toString() {  
	        return getYearStr(year) + "年" + (leap ? "闰" : "") + chineseNumber[month-1] + "月" + getChinaDayString(day);  
	    }
	    
	    public String toInt() {  
	    	int mo =month;
	    	if(month == 12){
	    		mo =0;
	    	}else{
	    		mo =month-1;
	    	}
	        return getYearInt(year) + "-" + chineseNumberInt[month-1] + "-" + getChinaDayInt(day);  
	    }
	    
	    public Date getDate(){
	    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	Date date;
	    	try {
				date = formatter.parse(year+"-"+month+"-"+ day +" 00:00:00");
				return date;
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
	    }
	      
	    public String getYearStr(int year) {  
	        String[] chineseword = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};  
	        String ys = "";  
	        int index = year / 1000;  
	        ys += chineseword[index];  
	        year = year % 1000;  
	        index = year / 100;  
	        ys += chineseword[index];  
	        year = year % 100;  
	        index = year / 10;  
	        ys += chineseword[index];  
	        year = year % 10;  
	        index = year;  
	        ys += chineseword[index];  
	        return ys;  
	    }  
	    
	    
	    public String getYearInt(int year) {  
	        String[] chineseword = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};  
	        String ys = "";  
	        int index = year / 1000;  
	        ys += chineseword[index];  
	        year = year % 1000;  
	        index = year / 100;  
	        ys += chineseword[index];  
	        year = year % 100;  
	        index = year / 10;  
	        ys += chineseword[index];  
	        year = year % 10;  
	        index = year;  
	        ys += chineseword[index];  
	        return ys;  
	    }  
	    
	    
	    
	    public static String getSixtyDay() {  
	        String temp = "";  
	        for (int i = 0; i < 60; i++) {  
	            temp += ",/" + cyclicalm(i) + "/";  
	        }  
	        return temp;  
	    } 
	    
	    
	    /***
	     * 原本是按照农历介绍改成按照节气结算月份
	     * @param cal 出生时间
	     * @return
	     */
	    private Integer getJieqi(Calendar cal){
	    	SolarTerm st =new SolarTerm();
	    	int years = cal.get(Calendar.YEAR)-1;    //获取年
	    	Map<Integer,String> jq=st.JQtest(years);//（前一年的节气以及当年节气到惊蛰3月）
	    	Map<Integer,String> jq2=st.JQtest(cal.get(Calendar.YEAR));//获取惊蛰后的节气
	    	SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	 int mon = cal.get(Calendar.MONTH)+1;//出生时间的当前月份
	    	 Date solar=null;//立春时间
	    	try {
	    		if(mon < 5){
	    			solar = sdf.parse(jq.get(mon*2-2)) ;
	    		}else{
	    			solar = sdf.parse(jq2.get(mon*2-2)) ;
	    		}
				 
			} catch (ParseException e) {
				e.printStackTrace();
			}
	    	 if(mon == 1){
	    		 if((month == 11 && cal.getTime().getTime() < solar.getTime()) ||
	    				( month == 12 && cal.getTime().getTime() >= solar.getTime()) ||
	    				month == 1){
	    			return month;
	    		 }else if(month == 11 && cal.getTime().getTime() >= solar.getTime()){
	    			 return month+1;
	    		 }else if(month == 12 && cal.getTime().getTime() < solar.getTime()){
	    			 return month-1;
	    		 }
	    	 }else if(mon == 2){
	    		 if((month == 12 && cal.getTime().getTime() < solar.getTime()) ||
	    				( month == 1 && cal.getTime().getTime() > solar.getTime()) ||
	    				month == 2){
	    			return month;
	    		 }else if(month == 12 && cal.getTime().getTime() >= solar.getTime()){
	    			 return month+1;
	    		 }else if(month == 1 && cal.getTime().getTime() < solar.getTime()){
	    			 return month-1;
	    		 }
	    	 }else{
	    		 if((month == (mon-2) && cal.getTime().getTime() < solar.getTime()) ||
	    				( month == (mon-1) && cal.getTime().getTime() >=  solar.getTime()) ||
	    				month == mon){
	    			return month;
	    		 }else if(month ==(mon-2) && cal.getTime().getTime() >= solar.getTime()){
	    			 return month+1;
	    		 }else if(month == (mon-1) && cal.getTime().getTime() < solar.getTime()){
	    			 return month-1;
	    		 }
	    	 }
	    	 return null;
	    }
	    
	    
	    /***
	     * 根据年获取月干
	     * @param year 年的天干地支
	     * @param ms 出生月份
	     * @param datetime 出生时间
	     * @param jiq 出生时间
	     * @return
	     */
	    private String getMonthTian(String year,Calendar cal,Date jiq,String monthEarthly){
	    	int months = cal.get(Calendar.MONTH)+1;    //获取月
	    	String tianYear =year.substring(0,1);//获取年的天干
	    	String month = GanKey.get(tianYear);//获取年的第一个月
	    	int jz = jiazi.get(month+"寅");//六十甲子下标
	    	/*int zo= 0;
	    	if(months == 1){
	    		zo= jz+11;//最终下标
	    	}else{
	    		zo= jz+months-1;//最终下标
	    	}
	    	if(cal.getTime().getTime() < jiq.getTime()){
	    		if(zo == 0){
	    			zo =11;
	    		}else{
	    			zo = zo -1;
	    		}
	    	}*/
	    	int number = (jz+jqrs.get(monthEarthly))%60;
	    	if(number == 0){
	    		number =60;
	    	}
	    	String z= jiazhitwo.get(number);
	    	return z.substring(0,1);
	    }
	      
	    /** 
	     * 针对一个在西元 1983-01-10 中午12：30生的人的计算。 
	     * 这里12点半在中国的古代历书中算是午时 
	     * 子时24.00－2.00,丑时2.00－4.00,寅时4.00－6.00,卯时6.00－8.00, 
	     * 辰时8.00－10.00,巳时10.00－12.00,午时12.00－14.00,未时14.00－16.00 
	     * 申时16.00－18.00,酉时18.00－20.00,戌时20.00－22.00,亥时22.00－24.00 
	     * */  
	    public static void main(String[] args){  
	        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	        Calendar cal = Calendar.getInstance();  
	        try {  
	                //设定此人的西元时间为1983-01-10  
	                cal.setTime(sdf.parse("1900-01-30 17:40:00"));  
	                Double d = (double) cal.get(Calendar.HOUR_OF_DAY);
	                int s= (int) Math.ceil(d/2)+1;
	                System.out.println(">>>>>>>>>>>>>>>>>>>>"+s);
	                TrueSun lunar = new TrueSun(cal);  
	                System.out.println("此人农历的日期【"+lunar.toString()+"】");  
	                //此处是为了获取时间在中国的八字学说上的显示，此人是午时生的  
	                Double hous =(double) cal.get(Calendar.HOUR_OF_DAY); 
	        		int time =  (int) Math.ceil(hous/2);
	                System.out.println("此人八字【"+lunar.getYearGanZhi(time,cal)+"】");  
	                //获取生肖  
	                System.out.println("此人的农历生肖【"+lunar.animalsYear()+"】");  
	        }catch(Exception e){  
	            e.printStackTrace();  
	        }*/  
	    	/*System.out.println(Integer.parseInt("04bd8",16));
	    	System.out.println(Integer.parseInt("04ae0",16));
	    	System.out.println(Integer.toHexString(19416));
	    	System.out.println(Integer.toHexString(19168));
	    	
	    	System.out.println(Integer.parseInt("1c8d7",16));
	    	System.out.println(Integer.toHexString(116951));*/
	    	
	    	//十六进制转成十进制
	    	/*System.out.println(Integer.parseInt("05f46",16));
	    	System.out.println(Integer.parseInt("0af46",16));*/
	    	//十进制转成十六进制
	    	//System.out.println(Integer.toHexString(38320));
	    	// 0x06e95   0x0d6a0
	 	   // 0x16a95
	    	//十六进制转成二进制
	    	System.out.println(Integer.toBinaryString(Integer.valueOf("06e95",16)));
	    	System.out.println(Integer.toBinaryString(Integer.valueOf("16a95",16)));
	    	System.out.println(Integer.toHexString(Integer.parseInt("1011010101000000", 2)));
	    	//101111101000110
	    	//1010111101000110
	    	/*//二进制转十进制
	    	Integer.valueOf("0101",2).toString();*/
	    	//二进制转十六进制
	    	/*System.out.println(Integer.toHexString(Integer.parseInt("1011010101000000", 2)));*/
	    	//0x15176
	    	//1900 0x04bd8
	    	//十六进制转成二进制
	    	/*System.out.println(Integer.toBinaryString(Integer.valueOf("15176",16)));*/
	    	
	    	/*List<Long> list =new ArrayList<Long>();
	    	for (long l : TrueSun.lunarInfo) {
				for(long t:list){
					if(l == t){
						System.out.println(l);
					}
					break;
				}
				list.add(l);
			}*/
	    	TrueSun.suiyu();
	    	
	    }  
	    
	    
	    
	    
	    public static void suiyu(){
	    	TrMoon core = new TrMoon();
	    	try {
	    		//第1246个新月时间:1979-02-27 00:45
	    		//第877个新月时间:1979-01-28 14:20
	    		//第1248个新月时间:1949-01-29 10:46
	    		//25404
	    		SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    		SimpleDateFormat datetime= new SimpleDateFormat("yyyy年MM月dd日");
	    		String k="1590-02-05 00:23";//每12个月的前一个月
				List<String> firstTime = core.getFirstTime(k, 300);
	            StringBuffer sb =new StringBuffer();
	            String run = null;//是否为闰月,闰月有值
	            int maxmin = -1;//1为润月大月，2为闰月小月
	            List<String> list = new ArrayList<String>();
	            list.add(k);
	            int yearMax=0;//年的数量
	            for(int i=0;i<firstTime.size();i++){
	            	
	            	Calendar c = Calendar.getInstance();
					Date date=format.parse(firstTime.get(i));
					c.setTime(date);
					c.add(Calendar.DATE, -1);    //得到前一天
					int year = c.get(GregorianCalendar.YEAR);
					int month = c.get(GregorianCalendar.MONTH)+1;
					int day = c.get(GregorianCalendar.DAY_OF_MONTH);
	            	String starttime = FromHttp.gettime(String.valueOf(year),String.valueOf(month),String.valueOf(day));
	            	
            		if(i == 0){
						Calendar cshier = Calendar.getInstance();
						Date dateshier=format.parse(k);
						cshier.setTime(dateshier);
						cshier.add(Calendar.DATE, -1);    //得到前一天
						int yearshier = cshier.get(GregorianCalendar.YEAR);
						int monthshier = cshier.get(GregorianCalendar.MONTH)+1;
						int dayshier = cshier.get(GregorianCalendar.DAY_OF_MONTH);
			            String time = FromHttp.gettime(String.valueOf(yearshier),String.valueOf(monthshier),String.valueOf(dayshier));
			            if(time.contains(" 闰")){//是否是闰月
			            	time=time.replaceAll(" 闰","");
			            	if(time.contains("年2月")){
			            		String[]  strs=time.split("月");
			            		String[] end =strs[1].split("日");
			            		if(end[0].equals("29")){//是小月
			            			cshier.add(Calendar.DATE, 1);    //后一天数据
			    					int yearmax = cshier.get(GregorianCalendar.YEAR);
			    					int monthmax = cshier.get(GregorianCalendar.MONTH)+1;
			    					int daymax = cshier.get(GregorianCalendar.DAY_OF_MONTH);
			    	            	String starttimemax = FromHttp.gettime(String.valueOf(yearmax),String.valueOf(monthmax),String.valueOf(daymax));
			    	            	starttimemax=starttimemax.replaceAll(" 闰","");
			    	            	String[]  strsmax=starttimemax.split("月");
				            		String[] endmax =strsmax[1].split("日");
				            		run = geterjin(2);
			    	            	if(endmax[0].equals("30")){//计算原因变成30天实际是大月
			    	            		maxmin = 1;
			    	            	}else{//小月
			    	            		maxmin = 2;
			    	            	}
			            		}else if(end[0].equals("30")){//大月
			            			run = geterjin(2);
			            			maxmin = 1;
			            		}else if(end[0].equals("28")){//计算原因变成28天实际是29天小月
			            			run = geterjin(2);
			            			maxmin = 2;
			            		}else if(end[0].equals("1")){//计算原因变成下个月1号
			            			cshier.add(Calendar.DATE, -1);    //得到前一天
			    					int yearmax = cshier.get(GregorianCalendar.YEAR);
			    					int monthmax = cshier.get(GregorianCalendar.MONTH)+1;
			    					int daymax = cshier.get(GregorianCalendar.DAY_OF_MONTH);
			    	            	String starttimemax = FromHttp.gettime(String.valueOf(yearmax),String.valueOf(monthmax),String.valueOf(daymax));
			    	            	if(starttimemax.contains(" 闰")){
			    	            		run = geterjin(1);//因为是1号，所以时间向前推一天就会变成1月
			    	            		starttimemax=starttimemax.replaceAll(" 闰","");
				    	            	String[]  strsmax=starttimemax.split("月");
					            		String[] endmax =strsmax[1].split("日");
				    	            	if(endmax[0].equals("30")){//计算原因变成30天实际是大月
				    	            		maxmin = 1;
				    	            	}else{//小月
				    	            		maxmin = 2;
				    	            	}
			    	            	}else{
			    	            		String[]  strsmax=starttimemax.split("月");
					            		String[] endmax =strsmax[1].split("日");
			    	            		if(endmax[0].equals("30")){//计算原因变成30天实际是大月
				    	            		sb.insert(0,"1");
				    	            	}else{
				    	            		sb.insert(0,"0");
				    	            	}
			    	            	}
			    	            	
			            		}
			            	}else{
			            		Calendar runtime = Calendar.getInstance();
								Date stime=datetime.parse(time);
								runtime.setTime(stime);
								if(runtime.get(Calendar.DAY_OF_MONTH) == 29){//是小月
									Date s=format.parse(k);//重新赋值
									runtime.setTime(s);
									runtime.add(Calendar.DATE, 1);    //后一天数据
			    					int yearmax = runtime.get(GregorianCalendar.YEAR);
			    					int monthmax = runtime.get(GregorianCalendar.MONTH)+1;
			    					int daymax = runtime.get(GregorianCalendar.DAY_OF_MONTH);
			    	            	String starttimemax = FromHttp.gettime(String.valueOf(yearmax),String.valueOf(monthmax),String.valueOf(daymax));
			    	            	starttimemax=starttimemax.replaceAll(" 闰","");
			    	            	String[]  strsmax=starttimemax.split("月");
				            		String[] endmax =strsmax[1].split("日");
				            		int smonth = runtime.get(Calendar.MONTH) + 1;   //获取月份，0表示1月份
									run = geterjin(smonth-1);
			    	            	if(endmax[0].equals("30")){//计算原因变成30天实际是大月
			    	            		maxmin = 1;
			    	            	}else{//小月
			    	            		maxmin = 2;
			    	            	}
								}else if(runtime.get(Calendar.DAY_OF_MONTH) == 30){//大月
									int smonth = runtime.get(Calendar.MONTH) + 1;   //获取月份，0表示1月份
									run = geterjin(smonth);
									maxmin = 1;
								}else if(runtime.get(Calendar.DAY_OF_MONTH) == 28){
									int smonth = runtime.get(Calendar.MONTH) + 1;   //获取月份，0表示1月份
									run = geterjin(smonth);
									maxmin = 2;
								}else if(runtime.get(Calendar.DAY_OF_MONTH) == 1){
									Date s=format.parse(k);//重新赋值
									runtime.setTime(s);
									runtime.add(Calendar.DATE, -2); //得到前一天
			    					int yearmax = runtime.get(GregorianCalendar.YEAR);
			    					int monthmax = runtime.get(GregorianCalendar.MONTH)+1;
			    					int daymax = runtime.get(GregorianCalendar.DAY_OF_MONTH);
			    	            	String starttimemax = FromHttp.gettime(String.valueOf(yearmax),String.valueOf(monthmax),String.valueOf(daymax));
			    	            	starttimemax=starttimemax.replaceAll(" 闰","");
			    	            	String[]  strsmax=starttimemax.split("月");
				            		String[] endmax =strsmax[1].split("日");
				            		int smonth = runtime.get(Calendar.MONTH) + 1;   //获取月份，0表示1月份
									run = geterjin(smonth);
			    	            	if(endmax[0].equals("30")){//计算原因变成30天实际是大月
			    	            		maxmin = 1;
			    	            	}else{//小月
			    	            		maxmin = 2;
			    	            	}
								}
			            	}
			            }else{
			            	if(time.contains("年2月")){
			            		String[]  strs=time.split("月");
			            		String[] end =strs[1].split("日");
			            		if(end[0].equals("29")){//是小月
			            			Date s=format.parse(k);
			            			cshier.setTime(s);
			    					int yearmax = cshier.get(GregorianCalendar.YEAR);
			    					int monthmax = cshier.get(GregorianCalendar.MONTH)+1;
			    					int daymax = cshier.get(GregorianCalendar.DAY_OF_MONTH);
			    	            	String starttimemax = FromHttp.gettime(String.valueOf(yearmax),String.valueOf(monthmax),String.valueOf(daymax));
			    	            	String[]  strsmax=starttimemax.split("月");
				            		String[] endmax =strsmax[1].split("日");
			    	            	if(endmax[0].equals("30")){//计算原因变成30天实际是大月
			    	            		sb.insert(0,"1");
			    	            	}else{
			    	            		sb.insert(0,"0");
			    	            	}
			            		}else if(end[0].equals("30")){//大月
			            			sb.insert(0,"1");
			            		}else if(end[0].equals("1")){
			            			Date dates=format.parse(k);
			            			cshier.setTime(dates);
			            			cshier.add(Calendar.DATE, -2);    //得到前一天
			    					int yearmax = cshier.get(GregorianCalendar.YEAR);
			    					int monthmax = cshier.get(GregorianCalendar.MONTH)+1;
			    					int daymax = cshier.get(GregorianCalendar.DAY_OF_MONTH);
			    	            	String starttimemax = FromHttp.gettime(String.valueOf(yearmax),String.valueOf(monthmax),String.valueOf(daymax));
			    	            	String[]  strsmax=starttimemax.split("月");
				            		String[] endmax =strsmax[1].split("日");
			    	            	if(endmax[0].equals("30")){//计算原因变成30天实际是大月
			    	            		sb.insert(0,"1");
			    	            	}else{//小月
			    	            		sb.insert(0,"0");
			    	            	}
			            		}
			            	}else{
			            		Calendar runtime = Calendar.getInstance();
								Date stime=datetime.parse(time);
								runtime.setTime(stime);
								if(runtime.get(Calendar.DAY_OF_MONTH) == 29){//是小月
									Date dates=format.parse(k);
									runtime.setTime(dates);
									runtime.add(Calendar.DATE, 1);    //后一天数据
			    					int yearmax = runtime.get(GregorianCalendar.YEAR);
			    					int monthmax = runtime.get(GregorianCalendar.MONTH)+1;
			    					int daymax = runtime.get(GregorianCalendar.DAY_OF_MONTH);
			    	            	String starttimemax = FromHttp.gettime(String.valueOf(yearmax),String.valueOf(monthmax),String.valueOf(daymax));
			    	            	String[]  strsmax=starttimemax.split("月");
				            		String[] endmax =strsmax[1].split("日");
			    	            	if(endmax[0].equals("30")){//计算原因变成30天实际是大月
			    	            		starttime =starttimemax;
			    	            		sb.insert(0,"1");
			    	            	}else{
			    	            		sb.insert(0,"0");
			    	            	}
								}else if(runtime.get(Calendar.DAY_OF_MONTH) == 30){//大月
									sb.insert(0,"1");
								}else if(runtime.get(Calendar.DAY_OF_MONTH) == 1){//1号数据向后推了一天
									Date dates=format.parse(k);
									runtime.setTime(dates);
									runtime.add(Calendar.DATE, -2);    //后一天数据
			    					int yearmax = runtime.get(GregorianCalendar.YEAR);
			    					int monthmax = runtime.get(GregorianCalendar.MONTH)+1;
			    					int daymax = runtime.get(GregorianCalendar.DAY_OF_MONTH);
			    	            	String starttimemax = FromHttp.gettime(String.valueOf(yearmax),String.valueOf(monthmax),String.valueOf(daymax));
			    	            	starttimemax=starttimemax.replaceAll(" 闰","");
			    	            	String[]  strsmax=starttimemax.split("月");
				            		String[] endmax =strsmax[1].split("日");
			    	            	if(endmax[0].equals("30")){
			    	            		sb.insert(0,"1");
			    	            	}else{
			    	            		sb.insert(0,"0");
			    	            	}
								}
			            	}
			            }
			            
			            //System.out.println(time.contains(" 闰"));
			           // System.out.println(time);
					}
					
		            String time = FromHttp.gettime(String.valueOf(year),String.valueOf(month),String.valueOf(day));
		            if(time.contains(" 闰")){//是否是闰月
		            	time=time.replaceAll(" 闰","");
		            	if(time.contains("年2月")){
		            		String[]  strs=time.split("月");
		            		String[] end =strs[1].split("日");
		            		if(end[0].equals("29")){//是小月
		            			c.add(Calendar.DATE, 1);    //后一天数据
		    					int yearmax = c.get(GregorianCalendar.YEAR);
		    					int monthmax = c.get(GregorianCalendar.MONTH)+1;
		    					int daymax = c.get(GregorianCalendar.DAY_OF_MONTH);
		    	            	String starttimemax = FromHttp.gettime(String.valueOf(yearmax),String.valueOf(monthmax),String.valueOf(daymax));
		    	            	starttimemax=starttimemax.replaceAll(" 闰","");
		    	            	String[]  strsmax=starttimemax.split("月");
			            		String[] endmax =strsmax[1].split("日");
			            		run = geterjin(2);
		    	            	if(endmax[0].equals("30")){//计算原因变成30天实际是大月
		    	            		maxmin = 1;
		    	            	}else{//小月
		    	            		
		    	            		maxmin = 2;
		    	            	}
		            		}else if(end[0].equals("30")){//大月
		            			maxmin = 1;
		            		}else if(end[0].equals("28")){//小月
		            			maxmin = 2;
		            		}else if(end[0].equals("1")){//计算原因变成下个月1号
		            			c.add(Calendar.DATE, -1);    //得到前一天
		    					int yearmax = c.get(GregorianCalendar.YEAR);
		    					int monthmax = c.get(GregorianCalendar.MONTH)+1;
		    					int daymax = c.get(GregorianCalendar.DAY_OF_MONTH);
		    	            	String starttimemax = FromHttp.gettime(String.valueOf(yearmax),String.valueOf(monthmax),String.valueOf(daymax));
		    	            	if(starttimemax.contains(" 闰")){
		    	            		run = geterjin(1);//因为是1号，所以时间向前推一天就会变成1月
		    	            		starttimemax=starttimemax.replaceAll(" 闰","");
			    	            	String[]  strsmax=starttimemax.split("月");
				            		String[] endmax =strsmax[1].split("日");
			    	            	if(endmax[0].equals("30")){//计算原因变成30天实际是大月
			    	            		maxmin = 1;
			    	            	}else{//小月
			    	            		maxmin = 2;
			    	            	}
		    	            	}else{
		    	            		String[]  strsmax=starttimemax.split("月");
				            		String[] endmax =strsmax[1].split("日");
		    	            		if(endmax[0].equals("30")){//计算原因变成30天实际是大月
			    	            		sb.insert(0,"1");
			    	            	}else{
			    	            		sb.insert(0,"0");
			    	            	}
		    	            	}
		            		}
		            	}else{
			            	Calendar runtime = Calendar.getInstance();
							Date stime=datetime.parse(time);
							runtime.setTime(stime);
							if(runtime.get(Calendar.DAY_OF_MONTH) == 29){//是小月
								c.add(Calendar.DATE, 1);    //后一天数据
		    					int yearmax = c.get(GregorianCalendar.YEAR);
		    					int monthmax = c.get(GregorianCalendar.MONTH)+1;
		    					int daymax = c.get(GregorianCalendar.DAY_OF_MONTH);
		    	            	String starttimemax = FromHttp.gettime(String.valueOf(yearmax),String.valueOf(monthmax),String.valueOf(daymax));
		    	            	starttimemax=starttimemax.replaceAll(" 闰","");
		    	            	String[]  strsmax=starttimemax.split("月");
			            		String[] endmax =strsmax[1].split("日");
			            		Date stimes=datetime.parse(starttimemax);
								runtime.setTime(stimes);
								int smonth = runtime.get(Calendar.MONTH) + 1;   //获取月份，0表示1月份
								run = geterjin(smonth-1);
		    	            	if(endmax[0].equals("30")){//计算原因变成30天实际是大月
		    	            		maxmin = 1;
		    	            	}else{//小月
		    	            		maxmin = 2;
		    	            	}
							}else if(runtime.get(Calendar.DAY_OF_MONTH) == 30){//大月
								int smonth = runtime.get(Calendar.MONTH) + 1;   //获取月份，0表示1月份
								run = geterjin(smonth);
								maxmin = 1;
							}else if(runtime.get(Calendar.DAY_OF_MONTH) == 28){//小月
								int smonth = runtime.get(Calendar.MONTH) + 1;   //获取月份，0表示1月份
								run = geterjin(smonth);
								maxmin = 2;
							}else if(runtime.get(Calendar.DAY_OF_MONTH) == 1){
								c.add(Calendar.DATE, -1);    //得到前一天
		    					int yearmax = c.get(GregorianCalendar.YEAR);
		    					int monthmax = c.get(GregorianCalendar.MONTH)+1;
		    					int daymax = c.get(GregorianCalendar.DAY_OF_MONTH);
		    	            	String starttimemax = FromHttp.gettime(String.valueOf(yearmax),String.valueOf(monthmax),String.valueOf(daymax));
		    	            	starttimemax=starttimemax.replaceAll(" 闰","");
		    	            	String[]  strsmax=starttimemax.split("月");
			            		String[] endmax =strsmax[1].split("日");
			            		Date stimes=datetime.parse(starttimemax);
								runtime.setTime(stimes);
			            		int smonth = runtime.get(Calendar.MONTH) + 1;   //获取月份，0表示1月份
								run = geterjin(smonth);
		    	            	if(endmax[0].equals("30")){//计算原因变成30天实际是大月
		    	            		maxmin = 1;
		    	            	}else{//小月
		    	            		maxmin = 2;
		    	            	}
							}
		            	}
		            }else{
		            	if(time.contains("年2月")){
		            		String[]  strs=time.split("月");
		            		String[] end =strs[1].split("日");
		            		if(end[0].equals("29")){//是小月
		            			c.add(Calendar.DATE, 1);    //后一天数据
		    					int yearmax = c.get(GregorianCalendar.YEAR);
		    					int monthmax = c.get(GregorianCalendar.MONTH)+1;
		    					int daymax = c.get(GregorianCalendar.DAY_OF_MONTH);
		    	            	String starttimemax = FromHttp.gettime(String.valueOf(yearmax),String.valueOf(monthmax),String.valueOf(daymax));
		    	            	String[]  strsmax=starttimemax.split("月");
			            		String[] endmax =strsmax[1].split("日");
		    	            	if(endmax[0].equals("30")){//计算原因变成30天实际是大月
		    	            		starttime =starttimemax;
		    	            		sb.insert(0,"1");
		    	            	}else{
		    	            		sb.insert(0,"0");
		    	            	}
		            		}else if(end[0].equals("30")){//大月
		            			sb.insert(0,"1");
		            		}else if(end[0].equals("1")){
		            			c.add(Calendar.DATE, -1);    //后一天数据
		    					int yearmax = c.get(GregorianCalendar.YEAR);
		    					int monthmax = c.get(GregorianCalendar.MONTH)+1;
		    					int daymax = c.get(GregorianCalendar.DAY_OF_MONTH);
		    	            	String starttimemax = FromHttp.gettime(String.valueOf(yearmax),String.valueOf(monthmax),String.valueOf(daymax));
		    	            	Calendar runtime = Calendar.getInstance();
								Date stime=datetime.parse(starttimemax);
								runtime.setTime(stime);
								starttime =starttimemax;
								if(runtime.get(Calendar.DAY_OF_MONTH) == 29){//是小月
									sb.insert(0,"0");
								}else if(runtime.get(Calendar.DAY_OF_MONTH) == 30){//大月
									sb.insert(0,"1");
								}
		            		}else if(end[0].equals("28")){
		            			sb.insert(0,"0");
		            		}
		            	}else{
			            	Calendar runtime = Calendar.getInstance();
							Date stime=datetime.parse(time);
							runtime.setTime(stime);
							if(runtime.get(Calendar.DAY_OF_MONTH) == 29){//是小月
								c.add(Calendar.DATE, 1);    //后一天数据
		    					int yearmax = c.get(GregorianCalendar.YEAR);
		    					int monthmax = c.get(GregorianCalendar.MONTH)+1;
		    					int daymax = c.get(GregorianCalendar.DAY_OF_MONTH);
		    	            	String starttimemax = FromHttp.gettime(String.valueOf(yearmax),String.valueOf(monthmax),String.valueOf(daymax));
		    	            	String[]  strsmax=starttimemax.split("月");
			            		String[] endmax =strsmax[1].split("日");
		    	            	if(endmax[0].equals("30")){//计算原因变成30天实际是大月
		    	            		starttime =starttimemax;
		    	            		sb.insert(0,"1");
		    	            	}else{
		    	            		sb.insert(0,"0");
		    	            	}
							}else if(runtime.get(Calendar.DAY_OF_MONTH) == 30){//大月
		    	            	sb.insert(0,"1");
							}else if(runtime.get(Calendar.DAY_OF_MONTH) == 1){//小月
								c.add(Calendar.DATE, -1);    //后二天天数据
		    					int yearmax = c.get(GregorianCalendar.YEAR);
		    					int monthmax = c.get(GregorianCalendar.MONTH)+1;
		    					int daymax = c.get(GregorianCalendar.DAY_OF_MONTH);
		    	            	String starttimemax = FromHttp.gettime(String.valueOf(yearmax),String.valueOf(monthmax),String.valueOf(daymax));
		    	            	starttimemax=starttimemax.replaceAll(" 闰","");
		    	            	String[]  strsmax=starttimemax.split("月");
			            		String[] endmax =strsmax[1].split("日");
			            		starttime =starttimemax;
		    	            	if(endmax[0].equals("30")){
		    	            		sb.insert(0,"1");
		    	            	}else{
		    	            		sb.insert(0,"0");
		    	            	}
							}
		            	}
		            }
		           // System.out.println(time.contains(" 闰"));
		           // System.out.println(time);
		           
		            if(starttime.contains("年1月")){//是否12个月
		            	if(run !=null){
		            		sb.append(run);
		            		if(maxmin == 1){
		            			sb.insert(0,"0001");
		            		}else{
		            			sb.insert(0,"0000");
		            		}
		            	}else{
		            		sb.append("0000");
		            	}
		            	
		            	//System.out.println(sb.toString());
		            	//成二进制转十六进制
		            	//System.out.println(Integer.toHexString(Integer.parseInt(sb.toString(), 2)));
		            	//十六进制转成二进制
		    	    	//System.out.println(Integer.toBinaryString(Integer.valueOf("1b255",16)));

		            	yearMax++;
		            	if(String.valueOf(Integer.toHexString(Integer.parseInt(sb.toString(), 2)).toString()).length() == 4){
		            		if(yearMax%10 == 0){
		            			System.out.println("  0x0"+Integer.toHexString(Integer.parseInt(sb.toString(), 2)));
		            		}else{
		            			System.out.print("  0x0"+Integer.toHexString(Integer.parseInt(sb.toString(), 2)));
		            		}
		            	}else{
		            		if(yearMax%10 == 0){
		            			System.out.println("  0x"+Integer.toHexString(Integer.parseInt(sb.toString(), 2)));
		            		}else{
		            			System.out.print("  0x"+Integer.toHexString(Integer.parseInt(sb.toString(), 2)));
		            		}
		            	}
		            	
		            	//重新计算
		            	k = firstTime.get(i);
	            		run =null;
	            		maxmin = -1;//1为润月大月，2为闰月小月
	            		sb.delete(0,sb.length());
		            }
	            	list.add(firstTime.get(i));
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
	    }
	    
	    
	    /***
	     * 月的二进制
	     * @param month
	     * @return
	     */
	    private static String geterjin(int month){
	    	if(month == 1){
	    		return "0001";
	    	}else if(month == 2){
	    		return "0010";
	    	}else if(month == 3){
	    		return "0011";
	    	}else if(month == 4){
	    		return "0100";
	    	}else if(month == 5){
	    		return "0101";
	    	}else if(month == 6){
	    		return "0110";
	    	}else if(month == 7){
	    		return "0111";
	    	}else if(month == 8){
	    		return "1000";
	    	}else if(month == 9){
	    		return "1001";
	    	}else if(month == 10){
	    		return "1010";
	    	}else if(month == 11){
	    		return "1111";
	    	}else if(month == 12){
	    		return "1100";
	    	}
	    	return null;
	    }
	    
}
