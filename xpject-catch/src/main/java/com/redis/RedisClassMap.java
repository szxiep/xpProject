/*package com.redis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.sf.json.JSONObject;


public class RedisClassMap {
	
	public static long time = 1000000000;

	*//***
	 * 查询缓存类
	 * @param t
	 * @param entity
	 * @return
	 *//*
	public static <T> Map<String, T> getMap(Class t,String entity){
		RedisService rs = RedisTool.getRedisService();
		JSONObject Mapjson =  JSONObject.fromObject(rs.get(entity));
		Iterator iterator = Mapjson.keys();
		Map<String, T> map = new HashMap<String, T>();
		synchronized (map) {
			while(iterator.hasNext()){
			     String key = (String) iterator.next();
			     String val = Mapjson.getString(key);
			     JSONObject json =  JSONObject.fromObject(val);
			     T ent=(T)JSONObject.toBean(json, t);
			     map.put(key, ent);
			}
		}
		return map;
	}
	
	*//***
	 * 添加缓存类
	 * @param entity
	 * @param mapCacde
	 *//*
	public  static <T> void  setMap(String entity,Map<String, T> mapCacde ){
		RedisService rs = RedisTool.getRedisService();
		JSONObject jsonObject = JSONObject.fromObject(mapCacde);  
		rs.set(entity, jsonObject.toString(), time);
	}
		
	*//***
	 * 删除缓存类
	 * @param entity
	 * @param mapCacde
	 *//*
	public static void delMap(String entity){
		RedisService rs = RedisTool.getRedisService();
		rs.del(entity);;
	}
}
*/