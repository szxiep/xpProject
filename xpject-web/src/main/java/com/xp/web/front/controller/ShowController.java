package com.xp.web.front.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xp.sys.api.SysBannerMapper;
import com.xp.sys.api.SysNewsMapper;
import com.xp.sys.api.SysNoticeMapper;
import com.xp.sys.api.SysOverviewMapper;
import com.xp.sys.api.SysSignupMapper;
import com.xp.sys.entity.SysBanner;
import com.xp.sys.entity.SysNews;
import com.xp.sys.entity.SysNotice;
import com.xp.sys.entity.SysOverview;
import com.xp.sys.entity.SysSignup;

/**
 * 前台Controller
 * @author xp
 */
@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/show")
public class ShowController {

	@Autowired
	private SysBannerMapper sysBannerMapper;	//banner轮播图
	
	@Autowired
	private SysNewsMapper sysNewsMapper;		//新闻
	
	@Autowired
	private SysNoticeMapper sysNoticeMapper;	//通告
	
	@Autowired
	private SysOverviewMapper sysOverviewMapper;//学院概况
	
	@Autowired
	private SysSignupMapper sysSignupMapper;	//报名
	
	/* SerializerFeature
    QuoteFieldNames———-输出key时是否使用双引号,默认为true 
    WriteMapNullValue——–是否输出值为null的字段,默认为false 
    WriteNullNumberAsZero—-数值字段如果为null,输出为0,而非null 
    WriteNullListAsEmpty—–List字段如果为null,输出为[],而非null 
    WriteNullStringAsEmpty—字符类型字段如果为null,输出为”“,而非null 
    WriteNullBooleanAsFalse–Boolean字段如果为null,输出为false,而非null 
    */
	
	/**
	 * 获取banner
	 * @param example
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getBanner")//,method=RequestMethod.POST
	public JSONObject getBanner(SysBanner example){
		JSONObject obj = new JSONObject();
		try {
			if((null != example && null == example.getOrderByClause())|| null == example){
				example.setOrderByClause("createtime desc");
			}
			
			List<SysBanner> selectByExample = sysBannerMapper.selectByExample(example);
			if(null != selectByExample && selectByExample.size() > 0){
				String json = JSONArray.toJSONString(selectByExample,SerializerFeature.WriteMapNullValue);
				long countByExample = sysBannerMapper.countByExample(example);
				obj.put("status", 1);
				obj.put("msg", "OK!");
				obj.put("rows", JSONArray.parse(json));
				obj.put("total", countByExample);
			}else{
				obj.put("status", 0);
				obj.put("msg", "无数据");
			}
		} catch (Exception e) {
			e.printStackTrace();
			obj.put("status", -1);
			obj.put("msg", "异常");
		}
		return obj;
	}
	
	/**
	 * 获取新闻
	 * @param example
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getNews",method=RequestMethod.POST)
	public JSONObject getNews(SysNews example){
		JSONObject obj = new JSONObject();
		try {
			if(null == example || null == example.getType()){
				obj.put("status", 2);
				obj.put("msg", "参数有误");
			}else{
				List<SysNews> selectByExample = sysNewsMapper.selectByExample(example);
				if(null != selectByExample && selectByExample.size() > 0){
					String json = JSONArray.toJSONString(selectByExample,SerializerFeature.WriteMapNullValue);
					long countByExample = sysNewsMapper.countByExample(example);
					obj.put("status", 1);
					obj.put("msg", "OK!");
					obj.put("rows", JSONArray.parse(json));
					obj.put("total", countByExample);
				}else{
					obj.put("status", 0);
					obj.put("msg", "无数据");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			obj.put("status", -1);
			obj.put("msg", "异常");
		}
		return obj;
	}
	
	
	/**
	 * 获取通告
	 * @param example
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getNotice",method=RequestMethod.POST)
	public JSONObject getNotice(SysNotice example){
		JSONObject obj = new JSONObject();
		try {
			if(null == example){
				obj.put("status", 2);
				obj.put("msg", "参数有误");
			}else{
				List<SysNotice> selectByExample = sysNoticeMapper.selectByExample(example);
				if(null != selectByExample && selectByExample.size() > 0){
					String json = JSONArray.toJSONString(selectByExample,SerializerFeature.WriteMapNullValue);
					long countByExample = sysNoticeMapper.countByExample(example);
					obj.put("status", 1);
					obj.put("msg", "OK!");
					obj.put("rows", JSONArray.parse(json));
					obj.put("total", countByExample);
				}else{
					obj.put("status", 0);
					obj.put("msg", "无数据");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			obj.put("status", -1);
			obj.put("msg", "异常");
		}
		return obj;
	}
	
	/**
	 * 获取学院概况
	 * @param example
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getOverview",method=RequestMethod.POST)
	public JSONObject getOverview(SysOverview example){
		JSONObject obj = new JSONObject();
		try {
			if(null == example){
				obj.put("status", 2);
				obj.put("msg", "参数有误");
			}else{
				List<SysOverview> selectByExample = sysOverviewMapper.selectByExample(example);
				if(null != selectByExample && selectByExample.size() > 0){
					String json = JSONArray.toJSONString(selectByExample,SerializerFeature.WriteMapNullValue);
					long countByExample = sysOverviewMapper.countByExample(example);
					obj.put("status", 1);
					obj.put("msg", "OK!");
					obj.put("rows", JSONArray.parse(json));
					obj.put("total", countByExample);
				}else{
					obj.put("status", 0);
					obj.put("msg", "无数据");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			obj.put("status", -1);
			obj.put("msg", "异常");
		}
		return obj;
	}
	
	/**
	 * 报名
	 * @param example
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/addSignup",method=RequestMethod.POST)
	public JSONObject addSignup(SysSignup example){
		JSONObject obj = new JSONObject();
		try {
			if(null == example){
				obj.put("status", 2);
				obj.put("msg", "参数有误");
			}else{
				example.setStatus(1);
				example.setCreatetime(new Date());
				int insert = sysSignupMapper.insert(example);
				if(insert > 0){
					obj.put("status", 1);
					obj.put("msg", "OK!");
				}else{
					obj.put("status", 0);
					obj.put("msg", "无数据");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			obj.put("status", -1);
			obj.put("msg", "异常");
		}
		return obj;
	}
	
	
	
	
	public static void main(String[] args) {
		double[] arr = new double[]{30.0,50.0,45.0,45.0,30.0,30.0,30.0,30.0,47.5,30.0,30.0,30.0,30.0,50.0,30.0,
				40.0,30.0,50.0,50.0,30.0,30.0,30.0,30.0,80.0,80.0,80.0,45.0,30.0,40.0,30.0};
		
		System.out.print("原始数据");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print("  ");
		}
		
		double minVal = 30.0;
		boolean f = false;
		int startIndex = 0;	//记录索引
		for (int i = 1; i < arr.length; i++) {
			double v = arr[i];
			if(!f && minVal == v){	//如果当前值是最小值,开始最小值周期
				f = true;
				startIndex = i;
			}
			
			if(f && minVal != v){	//最小值周期结束
				f = false;
				int length = i - startIndex + 1;
				
				double d = arr[startIndex-1];
				double e = arr[i];
				double abs = Math.abs(d-e);
				double h = abs/length;
				
				for (int j = startIndex; j < i; j++) {
					if(d > e){	//则减
						arr[j] = arr[j-1] - h;
					}else{
						arr[j] = arr[j-1] + h;
					}
				}
			}
		}
		System.out.println();
		System.out.print("改后数据");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print("  ");
		}
	
	
	}
}
