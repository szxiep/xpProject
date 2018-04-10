package com.xp.web.backstage.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xp.common.result.BaseControl;
import com.xp.sys.api.SysNewsMapper;
import com.xp.sys.entity.SysNews;

/**
 * 管理新闻控制器
 * @author xp
 */
@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/admin/sys/news")
public class NewsController  extends BaseControl{

	@Autowired
	private SysNewsMapper sysNewsMapper;	//新闻
	
	public SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	@ResponseBody
	@RequestMapping(value="/seleList",method=RequestMethod.POST)
	public JSONObject seleList(Integer id){
		JSONObject obj = new JSONObject();
		try {
			SysNews example = new SysNews();
			example.setStatus(1);
			if(null == id){	//查询全部
				example.setId(id);
			}
			List<SysNews> selectByExample = sysNewsMapper.selectByExample(example);
			
			if(null != selectByExample && selectByExample.size() > 0){
				String json = JSONArray.toJSONString(selectByExample);
				long countByExample = sysNewsMapper.countByExample(example);
				obj.put("status", 1);
				obj.put("msg", "OK!");
				obj.put("rows", JSONArray.parse(json));
				obj.put("total", countByExample);
			}else{
				obj.put("status", 0);
				obj.put("msg", "无数据");
			}
		} catch (Exception e) {
			obj.put("status", -1);
			obj.put("msg", "异常");
		}
		return obj;
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteByid")
	public JSONObject deleteByid(SysNews bean){
		JSONObject obj = new JSONObject();
		try {
			if(null != bean &&null != bean.getId()){
				int insert = sysNewsMapper.deleteByExample(bean);
				if(insert > 0){
					obj.put("status", 1);
					obj.put("msg", "删除成功!");
				}else{
					obj.put("status", 2);
					obj.put("msg", "删除失败，请检查参数!");
				}
			}else{
				obj.put("status", 0);
				obj.put("msg", "请检查参数!");
			}
		} catch (Exception e) {
			obj.put("status", -1);
			obj.put("msg", "异常");
		}
		return obj;
	}
	
	@ResponseBody
	@RequestMapping(value="/add")
	public JSONObject add(SysNews bean){
		JSONObject obj = new JSONObject();
		try {
			if(null != bean){
				bean.setStatus(1);
				int insert = sysNewsMapper.insert(bean);
				if(insert > 0){
					obj.put("status", 1);
					obj.put("msg", "新增成功!");
				}else{
					obj.put("status", 2);
					obj.put("msg", "新增失败，请检查参数!");
				}
			}else{
				obj.put("status", 0);
				obj.put("msg", "请检查参数!");
			}
		} catch (Exception e) {
			obj.put("status", -1);
			obj.put("msg", "异常");
		}
		return obj;
	}
	
	@ResponseBody
	@RequestMapping(value="/update")
	public JSONObject update(SysNews bean){
		JSONObject obj = new JSONObject();
		try {
			if(null != bean){
				int insert = sysNewsMapper.updateByExample(bean);
				if(insert > 0){
					obj.put("status", 1);
					obj.put("msg", "修改成功!");
				}else{
					obj.put("status", 2);
					obj.put("msg", "修改失败，请检查参数!");
				}
			}else{
				obj.put("status", 0);
				obj.put("msg", "请检查参数!");
			}
		} catch (Exception e) {
			obj.put("status", -1);
			obj.put("msg", "异常");
		}
		return obj;
	}
}
