package com.business.astrology.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


public class FromHttp {
	
	
	
	/***
	 * 获取
	 * @param isgong 1公历，0农历
	 * @param gnian 公历年
	 * @param gyue  公历月
	 * @param gri 公历日
	 */
	public static String connectionUrl(String isgong,String gnian,String gyue ,String gri){
        String url = "http://www.hjqing.com/find/2000/index.asp";

        String responseMessage = ""; 
        StringBuffer response = new StringBuffer(); 
        HttpURLConnection httpConnection = null; 
        OutputStreamWriter out = null; 
        BufferedReader reader = null; 
        try { 
          URL urlPost = new URL(url); 
          httpConnection = (HttpURLConnection) urlPost.openConnection(); 
          httpConnection.setDoOutput(true); 
          httpConnection.setDoInput(true); 
          // 参数长度太大，不能用get方式 
          httpConnection.setRequestMethod("POST"); 
          // 不使用缓存 
          httpConnection.setUseCaches(false); 
          // URLConnection.setInstanceFollowRedirects是成员函数，仅作用于当前函数 
          httpConnection.setInstanceFollowRedirects(true); 
          // 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的 
          // 意思是正文是urlencoded编码过的form参数 
          httpConnection.setRequestProperty("Connection", "Keep-Alive");
          // 设置请求头信息
          httpConnection.setRequestProperty("Charset", "UTF-8");
          // 设置边界
          String BOUNDARY = "----------" + System.currentTimeMillis();
          httpConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
          //httpConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 

          // 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成， 
          // 要注意的是connection.getOutputStream会隐含的进行connect。 
          // 实际上只是建立了一个与服务器的tcp连接，并没有实际发送http请求。 

          httpConnection.connect(); 
          out = new OutputStreamWriter(httpConnection.getOutputStream(),"UTF-8"); 

          // 正文，正文内容其实跟get的URL中'?'后的参数字符串一致 

          /*JSONObject jsonObject=new JSONObject(); 
          try{
              jsonObject.put("username", username); 
              jsonObject.put("password", password); 
              jsonObject.put("captcha", captcha); 
          }catch(Exception e){
              e.printStackTrace();
          }*/
          /*
          Map parames = new HashMap<String, String>();  
            parames.put("username", "username");  
            parames.put("username", "username");  
            parames.put("captcha", "captcha");  
          */
          // 构建请求参数  
            StringBuffer sb = new StringBuffer(); 
            sb.append("isgong="+isgong+"&gnian="+gnian+"&gyue="+gyue+"&gri="+gri);
          //写入参数,DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写道流里面 
          out.write(sb.toString()); 
          System.out.println("send_url:" + url);  
          System.out.println("send_data:" + sb.toString());  
          // flush and close 
          out.flush(); 

        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
             try { 
                if (null != out) { 
                  out.close(); 
                } 
                if (null != reader) { 
                  reader.close(); 
                } 
                if (null != httpConnection) { 
                  httpConnection.disconnect(); 
                } 
              } catch (Exception e2) { 
                  e2.printStackTrace();
              }
        }  

        try {
          reader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream(),"GBK")); 
          while ((responseMessage = reader.readLine()) != null) { 
              response.append(responseMessage); 
              response.append("\n"); 
          } 

          if (!"failure".equals(response.toString())) { 
              System.out.println("success");
          } else { 
              System.out.println("failue");
          } 
          // 将该url的配置信息缓存起来 
          System.out.println(response.toString()); 
          System.out.println(httpConnection.getResponseCode());
          return response.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	
	
	/**
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @param 作者：罗杰
     * @param 时间：2015年2月4日9:24:59
     * @return URL 所代表远程资源的响应结果
     */
	 public static String sendPost(String url, String param) {
	        PrintWriter out = null;
	        BufferedReader in = null;
	        String result = "";
	        StringBuffer response =new StringBuffer();
	        try {
	            URL realUrl = new URL(url);
	            // 打开和URL之间的连接
	            URLConnection conn = realUrl.openConnection();
	            // 设置通用的请求属性
	            conn.setRequestProperty("accept", "*/*");
	            conn.setRequestProperty("connection", "Keep-Alive");
	           // conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
	            conn.setRequestProperty("contentCharset", "UTF-8");
	            conn.setRequestProperty("user-agent",
	                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
	            conn.setRequestProperty("Content-Type",  
	                    "application/x-www-form-urlencoded");  
	            // 发送POST请求必须设置如下两行
	            conn.setDoOutput(true);
	            conn.setDoInput(true);
	            // 获取URLConnection对象对应的输出流
	            out = new PrintWriter(conn.getOutputStream());
	            // 发送请求参数
	            out.print(param);
	            // flush输出流的缓冲
	            out.flush();
	            // 定义BufferedReader输入流来读取URL的响应
	            in = new BufferedReader(
	                    new InputStreamReader(conn.getInputStream(),"GBK"));
	            String line;
	            while ((line = in.readLine()) != null) {
	                //result += line;
	            	response.append(line);
	                response.append("\n"); 
	            }
	        } catch (Exception e) {
	            System.out.println("发送 POST 请求出现异常！"+e);
	            e.printStackTrace();
	        }
	        //使用finally块来关闭输出流、输入流
	        finally{
	            try{
	                if(out!=null){
	                    out.close();
	                }
	                if(in!=null){
	                    in.close();
	                }
	            }
	            catch(IOException ex){
	                ex.printStackTrace();
	            }
	        }
	        return response.toString();
	    }    
	
	 
	/***
	 * 获取时间
	 * @param gnian
	 * @param gyue
	 * @param gri
	 * @return
	 */
	public static String gettime(String gnian,String gyue,String gri){
		String urlStr ="http://www.hjqing.com/find/2000/index.asp";;
		String isgong="1";// 1公历，0农历
		/*String gnian ="1938";// 公历年
		String gyue ="9";// 公历月
		String gri ="23"; //公历日
*/		String msg = sendPost(urlStr,"isgong="+isgong+"&gnian="+gnian+"&gyue="+gyue+"&gri="+gri);
		//System.out.println(msg);
		String[]  strs=msg.split("农历:");
		//System.out.println(strs[1]);
		String[] split = strs[1].split("</font>");
		//System.out.println(split[0].trim());
		return split[0].trim();
	}
	public static void main(String[] args){
	   // connectionUrl("1","1936","2","23");
		
		System.out.println(gettime("1938","9","23"));
	}
}
