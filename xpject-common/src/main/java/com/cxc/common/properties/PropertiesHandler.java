package com.cxc.common.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

import com.cxc.common.exception.ApplicationException;


/**
 * 动态读取配置文件工具类
 * @author tangdongyang
 * 2016年5月6日上午9:11:11
 */
public class PropertiesHandler {
	

	/**
	 * 对应于属性文件的文件对象变量
	 */
	private File file = null;

	/**
	 * 属性文件所对应的属性对象变量
	 */
	private Properties props = null;
	
	/**
	 * 属性文件所对应的属性对象变量
	 */
	private long lastModifiedTime = 0;


	/**
	 * 私有构造函数
	 * 
	 * @throws URISyntaxException
	 */
	public PropertiesHandler(String name) {
		buildFile(name);
		buildProps();
	}

	/**
	 * 查找ClassPath路径获取文件
	 * 
	 * @return File对象
	 * @throws URISyntaxException
	 */
	private void buildFile(String name) {
		try {
			setFile(new File(this.getClass()
					.getClassLoader().getResource(name).toURI()));
		} catch (URISyntaxException e) {
			throw new ApplicationException(e);
		}
	}




	private void buildProps() {
		Properties props = new Properties();
		try {
			props.load(new FileInputStream(getFile()));
		} catch (FileNotFoundException e) {
			throw new ApplicationException(e);
		} catch (IOException e) {
			throw new ApplicationException(e);
		}
		setProps(props);
	}



	public Properties getProps() {
		long newTime = getFile().lastModified();
		// 检查属性文件是否被修改
		if (newTime == 0) {
			return null;
		} else if (newTime > getLastModifiedTime()) {
			buildProps();
		}
		setLastModifiedTime(newTime);
		return props;
	}

	private void setProps(Properties props) {
		this.props = props;
	}
	

	private void setFile(File file) {
		this.file = file;
	}

	private File getFile() {
		return file;
	}
	
	private long getLastModifiedTime() {
		return lastModifiedTime;
	}

	private void setLastModifiedTime(long lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}


}
