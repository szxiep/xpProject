package com.xp.common.result;

import java.net.URISyntaxException;

import com.cxc.common.properties.BaseProperties;


/**
 * 返回结果消息配置文件,如操作不成功，新增失败等
 * 
 * @author tangdongyang
 * 2016年5月6日上午9:10:52
 */
public class ResultMessageProperties extends BaseProperties {
	/**
	 * 私有构造函数
	 * 
	 * @throws URISyntaxException
	 */
	private ResultMessageProperties() {
		super("resultmsg.properties");
	}
	
	private static class Inner {
		private static final ResultMessageProperties pop  = new ResultMessageProperties();
	}

	/**
	 * 静态工厂方法
	 * 
	 * @return 返回ConfigurationRead的单一实例
	 */
	public static ResultMessageProperties getInstance() {
		return Inner.pop;
	}
}
