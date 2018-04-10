package com.cxc.common.beans;

import java.lang.reflect.Field;

import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


/**
 * 获取spring bean实例 
 * @author tangdongyang
 * 2016年5月10日下午8:42:14
 */
@Component
public final class SpringBeans implements ApplicationContextAware {
    private static ApplicationContext context;

    public void setApplicationContext(ApplicationContext param) throws BeansException {
        context = param;
    }

    /**
     * 根据指定的bean名称和类型获取bean对象
     * @param beanName  bean对象名称
     * @param clz  类型
     * @return
     */
    public static <T> T get(String beanName, Class<T> clz) {
        Object obj = context.getBean(beanName);
        if(AopUtils.isAopProxy(obj)) {  
        	 try {
     	        if(AopUtils.isJdkDynamicProxy(obj)) {  
     	        	obj = getJdkDynamicTarget(obj);
     	        } else {
     	        	obj = getCglibTarget(obj);  
     	        }  
             } catch (Exception e) {
     			return null;
     		}  
        }  
        return clz.isInstance(obj) ? clz.cast(obj) : null;
    }
    
    /**
     * 根据class对象类型名获取bean
     * @param clz
     * @return
     */
    public static <T> T get(Class<T> clz) {
        return  context.getBean(clz);
    }
    
    /**
     * 根据class对象类型名获取bean
     * @param clz
     * @return
     */
    public static Object get(String id) {
        return  context.getBean(id);
    }
    
    /**
     * 获取Cglib代理对象的目标对象
     * @param proxy
     * @return
     * @throws Exception
     */
    private static Object getCglibTarget(Object proxy) throws Exception {  
        Field h = proxy.getClass().getDeclaredField("CGLIB$CALLBACK_0");  
        h.setAccessible(true);  
        Object dynamicAdvisedInterceptor = h.get(proxy);  
          
        Field advised = dynamicAdvisedInterceptor.getClass().getDeclaredField("advised");  
        advised.setAccessible(true);  
        Object target = ((AdvisedSupport)advised.get(dynamicAdvisedInterceptor)).getTargetSource().getTarget();  
          
        return target;  
    }  
  
   /**
    * JDK动态代理对象的目标对象
    * @param proxy
    * @return
    * @throws Exception
    */
    private static Object getJdkDynamicTarget(Object proxy) throws Exception {  
        Field h = proxy.getClass().getSuperclass().getDeclaredField("h");  
        h.setAccessible(true);  
        AopProxy aopProxy = (AopProxy) h.get(proxy);  
          
        Field advised = aopProxy.getClass().getDeclaredField("advised");  
        advised.setAccessible(true);  
          
        Object target = ((AdvisedSupport)advised.get(aopProxy)).getTargetSource().getTarget();  
          
        return target;  
    }  
}
