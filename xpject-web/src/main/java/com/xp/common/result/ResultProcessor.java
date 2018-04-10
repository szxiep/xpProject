package com.xp.common.result;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.cxc.common.code.GlobalCode;
import com.cxc.entity.BaseVO;


/**
 * 返回结果工具类， 封装返回JSON格式数据
 * 
 * @author Administrator
 * 
 */
public class ResultProcessor {

	private BaseControl control;
	
	/**
	 * 返回消息配置
	 */
	@SuppressWarnings("unused")
	private ResultMessageProperties properties = ResultMessageProperties.getInstance();
	

	public ResultProcessor(BaseControl control) {
		this.control = control;
	}

	
	
	/**
	 * 返回成功信息
	 * @param msgCode 返回消息编码 可以为空 
	 */
	public void resultSuccess(String msgCode) {
		resultCode(GlobalCode.SUCCESS, message(msgCode));
	}
	
	/**
	 * 返回错误信息
	 * @param msgCode 返回消息编码 可以为空 
	 */
	public void resultError(String msgCode) {
		resultCode(GlobalCode.FAIL, message(msgCode));
    }
	
	/**
	 * 封装单个返回数据
	 * 
	 * @param data
	 * @return
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	@SuppressWarnings("unchecked")
	public void resultData(int state, String msgCode, Object data) throws IllegalArgumentException, IllegalAccessException {
		ResultWarpper warpper = new ResultWarpper();
		ResultValue value = initResultValue(state, message(msgCode));
		if (null != data) {
			//map类型
			if (Map.class.isAssignableFrom(data.getClass())) {
				value.setData(warpper.map((Map<String, Object>) data));
			//集合类型
			} else if (List.class.isAssignableFrom(data.getClass())) {
				value.setData(warpper.list((List<? extends BaseVO>) data));
			} else if (Set.class.isAssignableFrom(data.getClass())) {
				value.setData(warpper.set((Set<? extends BaseVO>) data));
			} else if (Number.class.isAssignableFrom(data.getClass())) {
				value.setData(data);
			} else if (String.class.isAssignableFrom(data.getClass())) {
				value.setData(data);
			} else {
				//其他自定义类想
				value.setData(warpper.single(data));
			}
		}
		
		holdResultValuel(value);
	}
	
	/**
	 * 保存返回结果数据
	 * @param model
	 */
	private void holdResultValuel(ResultValue value) {
		getControl().setResult(value);
	}
	
	
	
	public BaseControl getControl() {
		return control;
	}

	/**
	 * 初始化返回结果数据
	 * @param state
	 * @param message
	 * @return
	 */
	private static ResultValue initResultValue(int state, String message) {
		ResultValue value = new ResultValue();
		value.setStatus(state);
		value.setMsg(message);
		return value;
	}
	
	private String message(String item) {
		//return properties.getItem(item);
		return item;
	}
	
	/**
	 * 返回消息编码
	 * @param code 0 成功 ；-1失败；  其他{@link GlobalCode}
	 * @param msg 消息
	 */
	private void resultCode(int code, String message) {
		ResultValue value = initResultValue(code, message);
		value.setData(StringUtils.EMPTY);
		holdResultValuel(value);
	}
}
