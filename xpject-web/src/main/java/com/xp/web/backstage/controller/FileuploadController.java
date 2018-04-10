package com.xp.web.backstage.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xp.common.result.BaseControl;

/**
 * 文件上传
 * @author xp
 */
@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/admin/")
public class FileuploadController extends BaseControl {

	/**
	 * MultipartFile方法说明
	 * byte[] getBytes()：获取文件数据
	 * String getContentType[]：获取文件MIME类型，如image/jpeg等
	 * InputStream getInputStream()：获取文件流
	 * String getName()：获取表单中文件组件的名字
	 * String getOriginalFilename()：获取上传文件的原名
	 * Long getSize()：获取文件的字节大小，单位为byte
	 * boolean isEmpty()：是否有上传文件
	 * void transferTo(File dest)：将上传文件保存到一个目录文件中 
	 */
	
	/**
	 * 单个文件上传
	 * 上传文件会自动绑定到MultipartFile中
	 * @param request
	 * @param description
	 * @param file
	 * @param type	0:banner,1:新闻,2:
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/img_upload", method = RequestMethod.POST)
	public JSONObject img_upload(HttpServletRequest request,
			@RequestParam("file") MultipartFile file,int type) throws Exception {
		JSONObject obj = new JSONObject();
		
		String common_type_filename = common_type_filename(type);
		if(null == common_type_filename){
			obj.put("status", 4);
			obj.put("msg", "type字段参数有误");
			return obj;
		}
		
		// 如果文件不为空，写入上传路径
		if (!file.isEmpty()) {
			String httpimgurl = "/images/" + common_type_filename;
			
			// 上传文件路径
			String path = request.getRealPath(httpimgurl);

			// 获取原始文件名
			String filename = file.getOriginalFilename();
			//获取文件后缀  
	        String suffix = filename.substring(filename.lastIndexOf(".")+1, filename.length());
			
			// 限制上传类型
			if (!suffix.equals("jpg") && !suffix.equals("png")) {
				obj.put("status", 2);
				obj.put("msg", "文件类型仅支持jpg,png格式");
				return obj;
			}
			
			// 限制上传文件大小
			if (file.getSize() >= 20971520) {
				obj.put("status", 3);
				obj.put("msg", "文件大小超过20M");
				return obj;
			}
			
			//新文件名称
			String newFile = create_not_uniquename()+"."+suffix.toLowerCase();
			File filepath = new File(path, newFile);
			// 判断路径是否存在，如果不存在就创建一个
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			String newFileName = path + File.separator + newFile;
			// 将上传文件保存到一个目标文件当中
			file.transferTo(new File(newFileName));
			
			obj.put("status", 1);
			obj.put("fileurl", httpimgurl + newFile);
			obj.put("size", file.getSize());
			obj.put("msg", "上传成功");
		}else {
			obj.put("status", 0);
			obj.put("msg", "文件对象为空");
		}
		return obj;
	}
	
	/**
	 * 多个文件上传
	 * 上传文件会自动绑定到MultipartFile中
	 * @param request
	 * @param description
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/img_much_upload", method = RequestMethod.POST)
	public JSONObject img_muchUpload(HttpServletRequest request,
			@RequestParam("file") MultipartFile[] files,int type) throws Exception {
		JSONObject obj = new JSONObject();
		JSONArray arr= new JSONArray();
		boolean f = true;
		try {
			String common_type_filename = common_type_filename(type);
			if(null == common_type_filename){
				obj.put("status", 4);
				obj.put("msg", "type字段参数有误");
				return obj;
			}
			
			String httpimgurl = "/images/" + common_type_filename;
			
			for (int i = 0; i < files.length; i++) {
				MultipartFile file = files[i];
				
				// 如果文件不为空，写入上传路径
				if (!file.isEmpty()) {
					// 上传文件路径
					String path = request.getRealPath(httpimgurl);

					// 获取原始文件名
					String filename = file.getOriginalFilename();
					//获取文件后缀  
			        String suffix = filename.substring(filename.lastIndexOf(".")+1, filename.length());
					
					// 限制上传类型
					if (!suffix.equals("jpg") && !suffix.equals("png")) {
						f = false;
						continue;
					}
					
					// 限制上传文件大小
					if (file.getSize() >= 20971520) {
						f = false;
						continue;
					}
					
					 //新文件名称
					String newFile = create_not_uniquename()+"."+suffix.toLowerCase();
					File filepath = new File(path, newFile);
					// 判断路径是否存在，如果不存在就创建一个
					if (!filepath.getParentFile().exists()) {
						filepath.getParentFile().mkdirs();
					}
					String newFileName = path + File.separator + newFile;
					// 将上传文件保存到一个目标文件当中
					file.transferTo(new File(newFileName));
					
					JSONObject objs = new JSONObject();
					objs.put("fileurl", httpimgurl + newFile);
					objs.put("size", file.getSize());
					arr.add(objs);
				}
			}
			obj.put("status", 1);
			obj.put("data", arr);
			if(f){
				obj.put("msg", "上传成功");
			}else{
				obj.put("msg", "部分上传成功请看data返回数据");
			}
		} catch (Exception e) {
			e.printStackTrace();
			obj.put("status", -1);
			obj.put("msg", "异常");
		}
		return obj;
	}
	
	private String common_type_filename(int type){
		if(type == 0){
			return "banner/";
		}
		if(type == 1){
			return "news/";
		}
		return null;
	}
	
	//生成不唯一名称
	private String create_not_uniquename(){
		int random = (int) (Math.random() * 10000);
		Long newFileName = System.currentTimeMillis();
		return newFileName.toString() + + random;
	}
}
