package com.cxc.common.weixin;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtil {
	
	
	public static void main(String[] args) {  
        // 如果不设置，只要代理IP和代理端口正确,此项不设置也可以  
        System.getProperties().setProperty("http.proxyHost", "10.22.40.32");  
        System.getProperties().setProperty("http.proxyPort", "8080");  
        // 判断代理是否设置成功  
        // 发送 GET 请求  
        System.out.println(sendGet("http://192.168.1.107:8080/system-db/chart/chart!as.action",""));  
        // 发送 POST 请求  
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
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("http.proxyHost", "39.108.176.85"); 
            connection.setRequestProperty("http.proxyPort", "80");
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            InputStream inputStream = connection.getInputStream(); 
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"UTF-8"); 
            BufferedReader ss = new BufferedReader(inputStreamReader); 
            result =ss.readLine().toString(); 
            
            
            /*Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }*/
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            conn.setRequestProperty("contentCharset", "UTF-8");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
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
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
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
        return result;
    }    
    
    /**  
     * 发送xml数据请求到server端  
     * @param urlStr xml请求数据地址  
     * @param  发送的xml数据流  
     * @return null发送失败，否则返回响应内容  
     */  
    public static String sendPostXml(String urlStr,String xmlString) { 
    	StringBuffer linelist =new StringBuffer();
        try {  
            URL url = new URL(urlStr);  
            URLConnection con = url.openConnection();  
            con.setDoOutput(true);  
            
            // 设置通用的请求属性
            con.setRequestProperty("Pragma:", "no-cache");  
            con.setRequestProperty("Cache-Control", "no-cache");  
            con.setRequestProperty("Content-Type", "text/xml;charset=utf-8");  
  
            OutputStreamWriter out = new OutputStreamWriter(con  
                    .getOutputStream(),"utf-8");      
            String xmlInfo = xmlString;  
           // System.out.println("urlStr=" + urlStr);  
           // System.out.println("xmlInfo=" + xmlInfo);  
            System.out.println(new String(xmlInfo.getBytes("UTF-8")));
            System.out.println();
            out.write(xmlInfo);  
            out.flush();  
            out.close();  
            BufferedReader br = new BufferedReader(new InputStreamReader(con  
                    .getInputStream()));  
            String line = "";  
            
            for (line = br.readLine(); line != null; line = br.readLine()) {  
            	linelist.append(line);
              //  System.out.println(line);  
            }  
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } 
        return linelist.toString();
    } 
    
    /***
     * post请求
     * @param urlPost
     * @param param
     * @param encoding
     * @return
     * @throws Exception
     */
    public static String post(String urlPost, String param, String encoding) throws Exception
	{
		// 提交地址
		URL url = new URL(urlPost);
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setDoOutput(true);
		http.setDoInput(true);
		http.setRequestMethod("POST");
		http.setUseCaches(false);
		http.setConnectTimeout(30000);
		http.setReadTimeout(30000);
		http.setInstanceFollowRedirects(true);
		http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		
		//http.connect();
		// http.getOutputStream() 隐含 http.connect() 如果先调用 http.connect()在weblogic下会报错
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(http.getOutputStream(), encoding));
		out.write(param);
		out.flush();
		out.close();
		
		// 读取post之后的返回值
		BufferedReader in = new BufferedReader(new InputStreamReader((InputStream)http.getInputStream(), encoding));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while((line = in.readLine()) != null)
		{
			sb.append(line);
		}
		in.close();
		http.disconnect();
		
		return sb.toString();
	}
    
	/*public static void main(String args[]) {
		System.out.println(sendPost("https://api.weixin.qq.com/cgi-bin/token","grant_type=client_credential&appid=wxd4022bded62ccbfa&secret=06821c8fbda8f12902d6f777e1d539ed"));
		String access_token ="nBXm9TZW1OEWNBUTqyGLSjL7DaESRqC96GxaI-ntS746tRBMFeqjecLD1RePiNK7CiOJhtnjxhqLy0NYMkDa3RrmD0jXXQlWmQsrdqIZ4uQ";
		StringBuffer xmlString =new StringBuffer();
		xmlString.append("{");
		xmlString.append("\"button\": [");
		xmlString.append("{");
		xmlString.append(" \"type\": \"click\", ");
		xmlString.append(" \"name\": \"测试菜单\", ");
		xmlString.append(" \"key\": \"V1001_TODAY_MUSIC\"");
		xmlString.append(" }, ");
		xmlString.append(" {");
		xmlString.append(" \"name\": \"菜单1\", ");
		xmlString.append(" \"sub_button\": [");
		xmlString.append("{");
		xmlString.append("\"type\": \"view\", ");
		xmlString.append("\"name\": \"搜索1\", ");
		xmlString.append(" \"url\": \"http://www.soso.com/\"");
		xmlString.append("},");
		xmlString.append("{");
		xmlString.append("\"type\": \"view\", ");
		xmlString.append("\"name\": \"视频1\", ");
		xmlString.append(" \"url\": \"http://v.qq.com/\"");
		xmlString.append(" }, ");
		xmlString.append(" {");
		xmlString.append(" \"type\": \"click\", ");
		xmlString.append(" \"name\": \"赞一下我们1\", ");
		xmlString.append(" \"key\": \"V1001_GOOD\"");
		xmlString.append("}]");
		xmlString.append("}]");
		xmlString.append("}");
		//获取用户
		//String openid = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
		
		//System.out.println(sendPostXml("https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+access_token,xmlString.toString()));
		System.out.println(sendPost("https://api.weixin.qq.com/cgi-bin/getcallbackip","access_token="+access_token));
		
		//System.out.println(sendPost("https://api.weixin.qq.com/cgi-bin/getcallbackip","access_token="+access_token));
	}*/
}
