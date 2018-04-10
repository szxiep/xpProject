package com.business.dubbo.ast.service.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 本命文案
 * @author xp
 */
public interface INaCopyService {

	/**
	 * 性格文案
	 * @param userid
	 * @param time
	 * @param address
	 * @param sex
	 * @return
	 */
	public JSONObject getXgCopy(Integer userid,String time,String address,int sex);
	
	/**
	 * 财运文案
	 * @param userid
	 * @param time
	 * @param address
	 * @param sex
	 * @return
	 */
	public JSONObject getCyCopy(Integer userid,String time,String address,int sex);
	
	/**
	 * 事业文案
	 * @param userid
	 * @param time
	 * @param address
	 * @param sex
	 * @return
	 */
	public JSONObject getSyCopy(Integer userid,String time,String address,int sex);
	
	/**
	 * 情感文案
	 * @param userid
	 * @param time
	 * @param address
	 * @param sex
	 * @return
	 */
	public JSONObject getQgCopy(Integer userid,String time,String address,int sex);
	
	/**
	 * 健康文案
	 * @param userid
	 * @param time
	 * @param address
	 * @param sex
	 * @return
	 */
	public JSONObject getJkCopy(Integer userid,String time,String address,int sex);
}
