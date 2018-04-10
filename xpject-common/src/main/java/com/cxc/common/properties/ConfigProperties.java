package com.cxc.common.properties;

import java.net.URISyntaxException;

/**
 * 返回结果消息配置文件,如操作不成功，新增失败等
 * 
 * @author tangdongyang
 * 2016年5月6日上午9:10:52
 */
public class ConfigProperties extends BaseProperties{

	/**
	 * 私有构造函数
	 * 
	 * @throws URISyntaxException
	 */
	private ConfigProperties() {
		super("config.properties");
	}
	
	private static class Inner {
		private static final ConfigProperties pop  = new ConfigProperties();
	}

	/**
	 * 静态工厂方法
	 * 
	 * @return 返回ConfigurationRead的单一实例
	 */
	public static ConfigProperties instance() {
		return Inner.pop;
	}
}
