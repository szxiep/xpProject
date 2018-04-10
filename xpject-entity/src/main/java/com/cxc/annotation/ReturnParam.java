package com.cxc.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 自定义注解, 标记返回参数
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface ReturnParam {
	/**
	 * 属性名称描述 （默认值为空）
	 * 
	 * @return String
	 */
	String name() default "";
}