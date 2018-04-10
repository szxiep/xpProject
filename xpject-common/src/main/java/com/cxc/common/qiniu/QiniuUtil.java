package com.cxc.common.qiniu;



/***
 * 七牛相关信息
 * @author Administrator
 *
 */
public class QiniuUtil {
	
	
	public final static String HEAD ="http://head.chenxingce.com";//头像域名的前缀
	private final static String  accessKey="axZAI38mBlMpnJp0RWlbAndlPCjsoMHTToV4N25m";//AK
	private final static String secretKey = "ahhlIckAkEoAshjR7il4eNE2AaJHdygaTLfKfCPh";//SK
	
	
	/***
	 * 根据空间名创建token
	 * @param bucket
	 * @return
	 */
	public String getbucket(String bucket){
		Auth auth =Auth.create(accessKey, secretKey);
		String buk = auth.uploadToken(bucket);
		return buk;
	}
	
	public static void main(String[] args) {
		QiniuUtil qn =new QiniuUtil();
		String token = qn.getbucket("headimg");
		System.out.println(token);
	}
}
