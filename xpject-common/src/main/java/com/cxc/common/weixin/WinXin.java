package com.cxc.common.weixin;


import java.io.UnsupportedEncodingException;

import net.sf.json.JSONObject;


/***
 * 微信(开放平台)相关接口
 * @author Administrator
 *
 */
public class WinXin {
 
	public final static String  APPID="wx00b1c4324abcc49e";//微信开放平台
	public final static String APPSECRET="b8ebd7b73679d8dbccc8d70da91e9523";//微信开放平台
	
	/***
	 * 通过code获取access_token
	 * @param code
	 * @return
	 */
	public static JSONObject getAccessToken(String code){
		String urlStr = "https://api.weixin.qq.com/sns/oauth2/access_token?";
		String msg =  HttpUtil.sendPost(urlStr,"appid="+APPID+"&secret="+APPSECRET+"&code="+code+"&grant_type=authorization_code");
		JSONObject  json = JSONObject.fromObject(msg);
		return  json;
	}
	
	public static void main(String[] args) {
		JSONObject json=  WinXin.getAccessToken("071GRcY20FQxxC1TOtX20ylcY20GRcYX");
		System.out.println(json);
		
		//{"access_token":"4_FfFCu8zt6wF5yMop7GGx-0QMEJu6Uquxn4xiPS-AnWlAOp68Gu-oaVDLh8H2ujx9w5P3kFy8tLNMOAdK73TBOA","expires_in":7200,"refresh_token":"4_z1knjlDCZPZTZWTdRQyOShlKFsAo7X83x9dgTBoOiyzcSeuUbSVx4Y59BvKDvjrER5ia13-drLWIaov6_t39pw","openid":"oinQp1XxNmBermbsa_ZWivpOwB-4","scope":"snsapi_login","unionid":"ovYW-1MO-e_M9o_Ajl4DuI2Uy-Nk"}
	}
	
	
	/***
	 * 获取用户信息
	 * 查看获取的字段：(https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1419316518&token=&lang=zh_CN)
	 * @param accessToken
	 * @param openid
	 * @return
	 */
	public static JSONObject userinfo(String accessToken,String openid){
		String urlStr = "https://api.weixin.qq.com/sns/userinfo";
		String msg =  HttpUtil.sendGet(urlStr,"access_token="+accessToken+"&openid="+openid+"&lang=zh_CN");
		JSONObject  json = JSONObject.fromObject(msg);
		return  json;
	}
}
