package com.cxc.annotation;

/**
 * 自定义注解, 标记web端返回参数
 */
public @interface WebReturnParam {
	/**
	 * 属性名称描述 （默认值为空）
	 * 
	 * @return String
	 */
	String name() default "";
}