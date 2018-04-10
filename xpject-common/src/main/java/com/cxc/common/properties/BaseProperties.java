package com.cxc.common.properties;

import org.apache.commons.lang3.StringUtils;

/**
 * 属性文件基本操作
 * 
 * @author tangdongyang
 * 2016年5月6日上午9:10:52
 */
public class BaseProperties {
	/**
	 * 属性文件所对应的属性对象变量
	 */
	private PropertiesHandler handler = null;
	
	public BaseProperties (String fileName) {
		handler = new PropertiesHandler(fileName);
	}
	
	/**
	 * 读取一特定的属性项
	 */
	public String getItem(String item) {
		if (!StringUtils.isEmpty(item)) {
			return handler.getProps().getProperty(item);
		} else {
			return StringUtils.EMPTY;
		}
	}
}
