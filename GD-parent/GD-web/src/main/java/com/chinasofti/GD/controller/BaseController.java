package com.chinasofti.GD.controller;

import java.util.HashMap;
import java.util.Map;

public class BaseController {

	/**
	 * 返回处理结果的Map
	 * @param status
	 * @param message
	 * @return
	 */
	protected Map<String, Object> ajaxReturn(String status, String message) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("msg", message);
		resultMap.put("status", status);
		return resultMap;
	}
	
	
	protected Map<String, String> ajaxReturn1(String status, String message) {
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("msg", message);
		resultMap.put("status", status);
		return resultMap;
	}
}
