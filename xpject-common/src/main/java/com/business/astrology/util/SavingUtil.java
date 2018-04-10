package com.business.astrology.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * 夏令时工具类
 * @author Administrator
 *
 */
public class SavingUtil {
	
	/***
	 * 判断是否在夏令时时间里面
	 * @param date 时间
	 * @return
	 */
	public boolean getSaving(Date date){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		long time = date.getTime();//出生时间
		try {
			/****1991年4月14日至9月15日****/
			long onestart = df.parse("1991-4-14 00:00:00").getTime();
			long oneend = df.parse("1991-9-15 23:59:59").getTime();
			if(onestart < time && time < oneend){
				return true;
			}
			/****1990年4月15日至9月16日 ****/
			long twostart = df.parse("1990-4-15 00:00:00").getTime();
			long twoend = df.parse("1990-9-16 23:59:59").getTime();
			if(twostart < time && time < twoend){
				return true;
			}
			/****1989年4月16日至9月17日  ****/
			long threestart = df.parse("1989-4-16 00:00:00").getTime();
			long threend = df.parse("1989-9-17 23:59:59").getTime();
			if(threestart < time && time < threend){
				return true;
			}
			/****1988年4月10日至9月11日   ****/
			long fourstart = df.parse("1988-4-10 00:00:00").getTime();
			long fourend = df.parse("1988-9-11 23:59:59").getTime();
			if(fourstart < time && time < fourend){
				return true;
			}
			/****1987年4月12日至9月13日  ****/
			long fivestart = df.parse("1987-4-12 00:00:00").getTime();
			long fiveend = df.parse("1987-9-13 23:59:59").getTime();
			if(fivestart < time && time < fiveend){
				return true;
			}
			/****1986年4月13日至9月14日   ****/
			long sixstart = df.parse("1986-4-13 00:00:00").getTime();
			long sixend = df.parse("1986-9-14 23:59:59").getTime();
			if(sixstart < time && time < sixend){
				return true;
			}
			/****1979年7月1日至9月30日   ****/
			long sevenstart = df.parse("1979-7-1 00:00:00").getTime();
			long sevenend = df.parse("1979-9-30 23:59:59").getTime();
			if(sevenstart < time && time < sevenend){
				return true;
			}
			/****1974年至1975年，每年4月1日至10月31日    ****/
			if(gettwo(time)){
				return true;
			}
			
			/****1960年至1961年，每年6月1日至9月30日    ****/
			if(getone(time)){
				return true;
			}
			
			/****1957年至1959年，每年4月1日至9月30日    ****/
			if(getthree(time)){
				return true;
			}
			
			/****1955年至1956年，每年5月1日至9月30日     ****/
			if(getfour(time)){
				return true;
			}
			
			/****1953年至1954年，每年4月1日至10月31日     ****/
			if(getfive(time)){
				return true;
			}
			
			/****1952年3月1日至10月31日     ****/
			if(getsix(time)){
				return true;
			}
			
			/****1935年至1951年，每年5月1日至9月30日 日     ****/
			if(getseven(time)){
				return true;
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	/***
	 * 1974年至1975年，每年4月1日至10月31日
	 * @param date
	 * @return
	 */
	private boolean gettwo(long time){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		try{
			long eightstart = df.parse("1974-4-1 00:00:00").getTime();
			long eightend = df.parse("1974-10-31 23:59:59").getTime();
			if(eightstart < time && time < eightend){
				return true;
			}
			long eighttwostart = df.parse("1975-4-1 00:00:00").getTime();
			long eighttwoend = df.parse("1975-10-31 23:59:59").getTime();
			if(eighttwostart < time && time < eighttwoend){
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	/***
	 * 1960年至1961年，每年6月1日至9月30日
	 * @param date
	 * @return
	 */
	private boolean getone(long time){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		try{
			long ninestart = df.parse("1960-6-1 00:00:00").getTime();
			long nineend = df.parse("1960-9-30 23:59:59").getTime();
			if(ninestart < time && time < nineend){
				return true;
			}
			long ninetwostart = df.parse("1961-6-1 00:00:00").getTime();
			long ninetwoend = df.parse("1961-9-30 23:59:59").getTime();
			if(ninetwostart < time && time < ninetwoend){
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/***
	 * 1957年至1958年，每年4月1日至9月30日 
	 * @param date
	 * @return
	 */
	private boolean getthree(long time){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		try{
			long onetart = df.parse("1957-4-1 00:00:00").getTime();
			long oneend = df.parse("1957-9-30 23:59:59").getTime();
			if(onetart < time && time < oneend){
				return true;
			}
			long twostart = df.parse("1958-4-1 00:00:00").getTime();
			long twoend = df.parse("1958-9-30 23:59:59").getTime();
			if(twostart < time && time < twoend){
				return true;
			}
			long threetart = df.parse("1959-4-1 00:00:00").getTime();
			long threeend = df.parse("1959-9-30 23:59:59").getTime();
			if(threetart < time && time < threeend){
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/***
	 * 1955年至1956年，每年5月1日至9月30日 
	 * @param date
	 * @return
	 */
	private boolean getfour(long time){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		try{
			long onetart = df.parse("1955-5-1 00:00:00").getTime();
			long oneend = df.parse("1955-9-30 23:59:59").getTime();
			if(onetart < time && time < oneend){
				return true;
			}
			long twostart = df.parse("1956-5-1 00:00:00").getTime();
			long twoend = df.parse("1956-9-30 23:59:59").getTime();
			if(twostart < time && time < twoend){
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	/***
	 * 1953年至1954年，每年4月1日至10月31日
	 * @param date
	 * @return
	 */
	private boolean getfive(long time){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		try{
			long onetart = df.parse("1953-4-1 00:00:00").getTime();
			long oneend = df.parse("1953-10-31 23:59:59").getTime();
			if(onetart < time && time < oneend){
				return true;
			}
			long twostart = df.parse("1954-4-1 00:00:00").getTime();
			long twoend = df.parse("1954-10-31 23:59:59").getTime();
			if(twostart < time && time < twoend){
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/***
	 * 1952年3月1日至10月31日
	 * @param date
	 * @return
	 */
	private boolean getsix(long time){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		try{
			long onetart = df.parse("1952-3-1 00:00:00").getTime();
			long oneend = df.parse("1952-10-31 23:59:59").getTime();
			if(onetart < time && time < oneend){
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	/***
	 * 1935年至1951年，每年5月1日至9月30日 
	 * @param date
	 * @return
	 */
	private boolean getseven(long time){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		try{
			long onetart = df.parse("1935-5-1 00:00:00").getTime();
			long oneend = df.parse("1935-9-30 23:59:59").getTime();
			if(onetart < time && time < oneend){
				return true;
			}
			long twotart = df.parse("1936-5-1 00:00:00").getTime();
			long twoend = df.parse("1936-9-30 23:59:59").getTime();
			if(twotart < time && time < twoend){
				return true;
			}
			long threetart = df.parse("1937-5-1 00:00:00").getTime();
			long threeend = df.parse("1937-9-30 23:59:59").getTime();
			if(threetart < time && time < threeend){
				return true;
			}
			long fourtart = df.parse("1938-5-1 00:00:00").getTime();
			long fourend = df.parse("1938-9-30 23:59:59").getTime();
			if(fourtart < time && time < fourend){
				return true;
			}
			long fivetart = df.parse("1939-5-1 00:00:00").getTime();
			long fiveend = df.parse("1939-9-30 23:59:59").getTime();
			if(fivetart < time && time < fiveend){
				return true;
			}
			long sixstart = df.parse("1940-5-1 00:00:00").getTime();
			long sixend = df.parse("1940-9-30 23:59:59").getTime();
			if(sixstart < time && time < sixend){
				return true;
			}
			long seventart = df.parse("1941-5-1 00:00:00").getTime();
			long sevenend = df.parse("1941-9-30 23:59:59").getTime();
			if(seventart < time && time < sevenend){
				return true;
			}
			long eightstart = df.parse("1942-5-1 00:00:00").getTime();
			long eightend = df.parse("1942-9-30 23:59:59").getTime();
			if(eightstart < time && time < eightend){
				return true;
			}
			long ninestart = df.parse("1943-5-1 00:00:00").getTime();
			long nineend = df.parse("1943-9-30 23:59:59").getTime();
			if(ninestart < time && time < nineend){
				return true;
			}
			long tenstart = df.parse("1944-5-1 00:00:00").getTime();
			long tenend = df.parse("1944-9-30 23:59:59").getTime();
			if(tenstart < time && time < tenend){
				return true;
			}
			long elevenstart = df.parse("1945-5-1 00:00:00").getTime();
			long elevenend = df.parse("1945-9-30 23:59:59").getTime();
			if(elevenstart < time && time < elevenend){
				return true;
			}
			long twelvestart = df.parse("1946-5-1 00:00:00").getTime();
			long twelveend = df.parse("1946-9-30 23:59:59").getTime();
			if(twelvestart < time && time < twelveend){
				return true;
			}
			long thirteenstart = df.parse("1947-5-1 00:00:00").getTime();
			long thirteenend = df.parse("1947-9-30 23:59:59").getTime();
			if(thirteenstart < time && time < thirteenend){
				return true;
			}
			long fourteenstart = df.parse("1948-5-1 00:00:00").getTime();
			long fourteenend = df.parse("1948-9-30 23:59:59").getTime();
			if(fourteenstart < time && time < fourteenend){
				return true;
			}
			long fifteenstart = df.parse("1949-5-1 00:00:00").getTime();
			long fifteenend = df.parse("1949-9-30 23:59:59").getTime();
			if(fifteenstart < time && time < fifteenend){
				return true;
			}
			long sixteenstart = df.parse("1950-5-1 00:00:00").getTime();
			long sixteenend = df.parse("1950-9-30 23:59:59").getTime();
			if(sixteenstart < time && time < sixteenend){
				return true;
			}
			long seventeenstart = df.parse("1951-5-1 00:00:00").getTime();
			long seventeenend = df.parse("1951-9-30 23:59:59").getTime();
			if(seventeenstart < time && time < seventeenend){
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}
}
