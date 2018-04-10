package com.xp.common.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.cxc.common.beans.SpringBeans;
import com.cxc.common.code.GlobalCode;
import com.cxc.common.exception.ApplicationException;
import com.cxc.entity.PageResult;

/**
 * json传输父类
 * requset、session、response接口实现action
 * @author yanglei
 *
 */
public class BaseControl {
	
	/**
	 * Request对象
	 */
	private HttpServletRequest request;

	/**
	 * Response对象
	 */
	private HttpServletResponse response;
	
	/**
	 * JSON对象
	 */
	private ResultValue result;
	
	protected void info(String msg,Object data){
		long time = new Date().getTime();
		if (null != data) {
			if(data instanceof java.lang.Class){
				logger().info("日志："+ip()+":"+time+":"+msg+":"+parseBeanJson(data));
			}else if(data instanceof java.util.List){
				logger().info("日志："+ip()+":"+time+":"+msg+":"+parseBeanJsonList(data));
			}else if(data instanceof Integer){
				logger().info("日志："+ip()+":"+time+":"+msg+":"+((Integer) data).intValue());
			}else if(data instanceof java.lang.String){
				logger().info("日志："+ip()+":"+time+":"+msg+":"+((String)data));
			}else if(data instanceof java.lang.Double){
				logger().info("日志："+ip()+":"+time+":"+msg+":"+(((Double) data).doubleValue()));
			}else{
				try {
					ResultWarpper warpper = new ResultWarpper();
					logger().info("日志："+ip()+":"+time+":"+msg+":"+warpper.single(data));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	
	
	/**
	 * 单对象结果
	 * @param state
	 * @param msgCode
	 * @param data
	 */
	protected void data(int state, String msgCode, Object data) {
		try {
			resultProcessor().resultData(state, msgCode, data);
		} catch (IllegalArgumentException e) {
			throw new ApplicationException("数据集转换失败 ，非法参数", e);
		} catch (IllegalAccessException e) {
			throw new ApplicationException("数据集转换失败 ， 参数禁止访问", e);
		}
	}
	
	/***
	 * list
	 * @param list
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected static JSONArray parseBeanJsonList(Object obj){
		ArrayList<Object> list = (ArrayList<Object>) obj;
		JSONArray jsonArg = new JSONArray();
		for(Object bean: list) {
			JSONObject jsonObject = JSONObject.fromObject(bean);
			JSONObject json =retJson(jsonObject);
			jsonArg.add(json);
		}
		return jsonArg;
	}
	
	
	private static JSONObject parseBeanJson(Object bean){
		JSONObject jsonObject = JSONObject.fromObject(bean);
		JSONObject json =retJson(jsonObject);
		return json;
	}
	
	@SuppressWarnings("rawtypes")
	private static JSONObject retJson(JSONObject jsonObject){
		Iterator it = jsonObject.keys();  
		JSONObject json =new  JSONObject();
        while (it.hasNext()) {  
            String key = (String) it.next();  
            String value = jsonObject.getString(key);  
            if(value != null && !value.equals("null")){
            	json.put(key, value);
            }
        } 
        return json;
	}
	
	
	public static  ResultValue dataSource(int state, String msgCode, Object data,Long countByExample){
		ResultValue value = new ResultValue();
		value.setStatus(state);
		value.setMsg(msgCode);
		value.setTotal(countByExample);
		ResultWarpper warpper = new ResultWarpper();
		if (null != data) {
			if(data instanceof Class){
				value.setData(parseBeanJson(data));
			}else if(data instanceof java.util.List){
				value.setData(parseBeanJsonList(data));
			}else if(data instanceof Integer){
				value.setData(((Integer) data).intValue());
			}else if(data instanceof java.lang.String){
				value.setData((String)data );
			}else if(data instanceof java.lang.Double){
				value.setData(((Double) data).doubleValue());
			}else if( data instanceof Serializable){
				value.setData(parseBeanJson(data));
			}else{
				try {
					value.setData(warpper.single(data));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		//JSONObject jsonObject = JSONObject.fromObject(value);
		return value;
	}
	
	/**
	 * 初始化返回结果数据
	 * @param state
	 * @param message
	 * @return
	 */
	@SuppressWarnings("unused")
	private static ResultValue initResultValue(int state, String message) {
		ResultValue value = new ResultValue();
		value.setStatus(state);
		value.setMsg(message);
		return value;
	}
	
	/**
	 * 分页结果集
	 * @param result
	 */
	protected void pageList (PageResult result) {
		data(GlobalCode.SUCCESS, StringUtils.EMPTY, result);
	}
	
	/**
	 * 返回成功
	 * @param msgCode
	 */
	protected void success(String msgCode) {
		resultProcessor().resultSuccess(msgCode);
	}
	
	/**
	 * 返回失败
	 * @param msgCode
	 */
	protected void error(String msgCode) {
		resultProcessor().resultError(msgCode);
	}
	
	protected Logger logger() {
		return LogManager.getLogger(this.getClass());
	}
	
	/**
	 * JSON对象
	 * 
	 * @return
	 */
	public ResultValue getResult() {
		return result;
	}

	public void setResult(ResultValue result) {
		this.result = result;
	}
	
	/**
	 * 获取服务类
	 * @param clz 类对象
	 * @return
	 */
	protected <T> T server(Class<T> clz) {
		return SpringBeans.get(clz);
	}
	
	/**
	 * 获取参数
	 * @param clz 类对象
	 * @return
	 */
	protected String getParameter(String name) {
		return getRequest().getParameter(name);
	}
	
	
	/**
     * 设置request,response对象
     * @param model
     */
	@ModelAttribute  
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){  
        this.request = request;  
        this.response = response;  
    } 
	
	public HttpServletResponse getResponse() {
		return response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}
	
	protected String ip() {
		String ip = getRequest().getHeader("x-forwarded-for");
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = (String) getRequest().getAttribute("X-real-ip");
	    }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = getRequest().getHeader("Proxy-Client-IP"); 
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = getRequest().getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = getRequest().getRemoteAddr();
        }
        if(StringUtils.isNotBlank(ip)) {
            ip = ip.split(",")[0];
        }
        return ip;
	}
	
	//处理表单属性 如vo.account
	@InitBinder("vo")  
	protected void initInfoBinder(WebDataBinder binder){   
        binder.setFieldDefaultPrefix("vo.");  
    }  
	
	//处理表单属性 如pg.start
	@InitBinder("pg") 
	protected void initLoginBinder(WebDataBinder binder){  
        binder.setFieldDefaultPrefix("pg.");  
    }
	/**
	 * 获取返回数据处理工具类对象
	 * 
	 * @return
	 */
	private ResultProcessor resultProcessor() {
		return new ResultProcessor(this);
	}
	
}
