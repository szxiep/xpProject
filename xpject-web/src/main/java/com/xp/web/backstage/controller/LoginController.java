package com.xp.web.backstage.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cxc.common.encryption.MD5Util;
import com.xp.common.result.BaseControl;
import com.xp.sys.api.SysUserMapper;
import com.xp.sys.entity.SysUser;

/**
 * 登录
 * @author xp
 */
@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/admin/")
public class LoginController extends BaseControl{

	//最大session过期时间
	private final int maxInactiveInterval = 18000;
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	// 登陆
	@ResponseBody
	@RequestMapping(value="/login")
	public JSONObject login(HttpSession session,String username,String password){
		JSONObject obj = new JSONObject();
		try {
			if(null == username && null == password){
				obj.put("status", 0);
				obj.put("msg", "账号密码输入有误");
			}else{
				SysUser user = new SysUser();
				user.setUsername(username);
				user.setPassword(MD5Util.md5(password));
				List<SysUser> selectByExample = sysUserMapper.selectByExample(user);
				if(null != selectByExample && selectByExample.size() > 0){
					// 在session中保存用户身份信息
			        session.setAttribute("username", username);
			        session.setMaxInactiveInterval(maxInactiveInterval);
					obj.put("status", 1);
					obj.put("msg", "OK!");
				}else{
					obj.put("status", 2);
					obj.put("msg", "用户不存在");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			obj.put("status", -1);
			obj.put("msg", "异常");
		}
		return obj;
	}
	
	// 新增用户
	@ResponseBody
	@RequestMapping(value="/adduser")
	public JSONObject adduser(SysUser user){
		JSONObject obj = new JSONObject();
		try {
			if(null == user){
				obj.put("status", 0);
				obj.put("msg", "对象为空，请检查参数");
			}else{
				SysUser isuser = new SysUser();
				isuser.setUsername(user.getUsername());
				List<SysUser> selectByExample = sysUserMapper.selectByExample(isuser);
				if(null != selectByExample && selectByExample.size() > 0){
					obj.put("status", 2);
					obj.put("msg", "用户已经存在");
				}else{
					user.setStatus(1);
					user.setCreatetime(new Date());
					user.setType(1);
					user.setPassword(MD5Util.md5(user.getPassword()));
					int insert = sysUserMapper.insert(user);
					if(insert > 0){
						obj.put("status", 1);
						obj.put("msg", "OK!");
					}else{
						obj.put("status", 3);
						obj.put("msg", "新增失败");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			obj.put("status", -1);
			obj.put("msg", "异常");
		}
		return obj;
	}
	
	// 删除 or 禁用用户
	@ResponseBody
	@RequestMapping(value="/disabledUser")
	public JSONObject disabledUser(Integer userid){
		JSONObject obj = new JSONObject();
		try {
			if(null == userid){
				obj.put("status", 0);
				obj.put("msg", "对象为空，请检查参数");
			}else{
				sysUserMapper.disabledUser(userid);
				obj.put("status", 1);
				obj.put("msg", "OK!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			obj.put("status", -1);
			obj.put("msg", "异常");
		}
		return obj;
	}
		
	// 退出
    @RequestMapping("/logout")
    public String logout(HttpSession session) throws Exception {
        // 清除session
        session.invalidate();
        // 重定向到页面
        return "redirect：/items/queryItems.action";
    }
    
    // 验证用户登录状态   1正常  0 失效
    @RequestMapping("/islogin")
    public String islogin(HttpSession session) throws Exception {
        // 清除session
    	Object sess = session.getAttribute("username");
    	if(null != sess){
    		return "1";
    	}else{
    		return "0";
    	}
    }
}
