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
import com.xp.sys.api.SysNoticeMapper;
import com.xp.sys.entity.SysNotice;

/**
 * 通告
 * @author xp
 */
@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/admin/sys/notice")
public class NoticeController  extends BaseControl{

	@Autowired
	private SysNoticeMapper sysNoticeMapper;	//通告
	
	public SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	@ResponseBody
	@RequestMapping(value="/seleList",method=RequestMethod.POST)
	public JSONObject seleList(SysNotice example){
		JSONObject obj = new JSONObject();
		try {
			List<SysNotice> selectByExample = sysNoticeMapper.selectByExample(example);
			if(null != selectByExample && selectByExample.size() > 0){
				String json = JSONArray.toJSONString(selectByExample);
				long countByExample = sysNoticeMapper.countByExample(example);
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
	
	@ResponseBody
	@RequestMapping(value="/deleteByid")
	public JSONObject deleteByid(SysNotice bean){
		JSONObject obj = new JSONObject();
		try {
			if(null != bean &&null != bean.getId()){
				int insert = sysNoticeMapper.deleteByExample(bean);
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
	public JSONObject add(SysNotice bean){
		JSONObject obj = new JSONObject();
		try {
			if(null != bean){
				int insert = sysNoticeMapper.insert(bean);
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
	@RequestMapping(value="/update")//method=RequestMethod.POST,produces="text/html;charset=UTF-8"
	public JSONObject update(SysNotice bean){
		JSONObject obj = new JSONObject();
		try {
			if(null != bean){
				int insert = sysNoticeMapper.updateByExample(bean);
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