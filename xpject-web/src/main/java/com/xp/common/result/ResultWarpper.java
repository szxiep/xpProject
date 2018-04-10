package com.xp.common.result;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cxc.annotation.ReturnParam;
import com.cxc.entity.BaseVO;


/**
 * 封装返回结果
 * 
 * @author Administrator
 * 
 */
public class ResultWarpper {
	
	private Class<? extends ReturnParam> paramClazz = ReturnParam.class;
	
	/**
	 * 封装返回结果数据， 只返回{@link ReturnParam}注解的参数
	 * @param instance
	 * @return
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws ApplicationException
	 */
	public <T> Map<String, Object> single(T instance) throws IllegalArgumentException, IllegalAccessException {
		if (null != instance) {
			return value(instance, instance.getClass(), new HashMap<String, Object>()); 
		} else {
			return new HashMap<String, Object>();
		}
		
	}
	
	/**
	 * List集合格式化
	 * @param sources
	 * @return
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public List<Map<String, Object>> list(List<? extends BaseVO> sources) throws IllegalArgumentException, IllegalAccessException  {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(sources.size());
		for (Object obj : sources) {
			list.add(value(obj, obj.getClass(), new HashMap<String, Object>()));
		}
		return list;
	}
	
	/**
	 * List集合格式化
	 * @param sources
	 * @return
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public Set<Map<String, Object>> set(Set<? extends BaseVO> sources) throws IllegalArgumentException, IllegalAccessException  {
		Set<Map<String, Object>> list = new HashSet<Map<String, Object>>(sources.size());
		for (Object obj : sources) {
			list.add(value(obj, obj.getClass(), new HashMap<String, Object>()));
		}
		return list;
	}
	
	/**
	 * List集合格式化
	 * @param sources
	 * @return
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public Map<String, Object> map(Map<String, Object> source) throws IllegalArgumentException, IllegalAccessException  {
		Object obj = null;
		Map<String, Object> map = new HashMap<String, Object>(); 
		for (Map.Entry<String, Object> entry : source.entrySet()) {
			obj = entry.getValue();
			if (null != obj && BaseVO.class.isAssignableFrom(obj.getClass())) {
				map.put(entry.getKey(), value(obj, obj.getClass(), new HashMap<String, Object>()));
			} else {
				map.put(entry.getKey(), obj);
			}
		}
		return map;
	}
	
	@SuppressWarnings("unchecked")
	private <T> Map<String, Object> value(T instance, Class<?> clazz, Map<String, Object> conditions)
			throws IllegalArgumentException, IllegalAccessException {
		Class<?> sp = clazz.getSuperclass();
		if (sp != Object.class) {
			value(instance, sp, conditions);
		} 
		Object val = null;
		for (Field field : clazz.getDeclaredFields()) {		
			if (null != field.getAnnotation(paramClazz)) {		
				field.setAccessible(true);
				val = field.get(instance);
				if (null == val) {
					continue;
				}
				//是否为BaseVO类型
				if (BaseVO.class.isAssignableFrom(field.getType()))  {
					conditions.put(field.getName(), single(val));
				//是否为List类型
				} else if(List.class.isAssignableFrom(field.getType())) {
					conditions.put(field.getName(), list((List<? extends BaseVO>)val));
				} else if(Set.class.isAssignableFrom(field.getType())) {
					conditions.put(field.getName(), set((Set<? extends BaseVO>)val));
				} else if (Number.class.isAssignableFrom(field.getType())){
					conditions.put(field.getName(), val);
				} else {
					conditions.put(field.getName(), val);
				}
			};
		}
		return conditions;
	}
}
