package com.mlb.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import fc.wpf.rest.utils.DateStyle;
import fc.wpf.rest.utils.DateUtil;

/**
 * 保存页面 用户上次访问的值时，设置的值。
 * 
 * @author zhongweisheng
 *
 */
public class GetParamsUtils {
	// 存入 内存中
	private static Map<String, HashMap<String, String>> paramMap = new HashMap<String, HashMap<String, String>>();

	public static void putParamMap(int userId, int pageId, HttpServletRequest request) {
		HashMap<String, String> paramsTemp = new HashMap<String, String>();
		Map<String, String[]> params = request.getParameterMap();

		String mapKey = userId + "-" + pageId;
		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				String value = values[i];
				paramsTemp.put(key, value);
			}
		}
		if (paramsTemp.size() > 0) {
			paramMap.put(mapKey, paramsTemp);
		}

	}

	public static HashMap<String, String> getParamMap(int userId, int pageId) {
		String mapKey = userId + "-" + pageId;
		if (paramMap.get(mapKey) != null) {
			return paramMap.get(mapKey);
		} else {
			return new HashMap<String, String>();
		}
	}

	public static String getParamMap(int userId, int pageId, String key) {
		String mapKey = userId + "-" + pageId;
		String value = "";
		HashMap<String, String> paramsTemp = new HashMap<String, String>();
		if (paramMap.get(mapKey) != null) {
			paramsTemp = paramMap.get(mapKey);
			value = StringUtils.trimToEmpty(paramsTemp.get(key));
		}
		return value;

	}

	// 清空用户所有页面搜索条件
	public static String clearParamMap(int userId) {
		String mapKey = userId + "-";
		String value = "";
		for (String key : paramMap.keySet()) {
			if (key.startsWith(mapKey)) {
				paramMap.put(key, null);
			}
		}
		return value;
	}

	// 清空用户指定页面的搜索条件
	public static String clearParamMap(int userId, int pageId) {
		String mapKey = userId + "-" + pageId;
		String value = "";
		paramMap.put(mapKey, null);
		return value;
	}

	@SuppressWarnings("rawtypes")
	public static Map<String, Object> getParamMap(HttpServletRequest request) {
		HashMap<String, Object> paramsTemp = new HashMap<String, Object>();
		Map<String, String[]> params = request.getParameterMap();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				String value = values[i];
				paramsTemp.put(key, value);
			}
		}

		String query = request.getParameter("query");
		if (StringUtils.isNotEmpty(query)) {
			// 将json字符串转换成jsonObject
			JSONObject jsonObject = JSONObject.fromObject(query);
			Iterator ite = jsonObject.keys();
			// 遍历jsonObject数据,添加到Map对象
			while (ite.hasNext()) {
				String key = ite.next().toString();
				String value = jsonObject.get(key).toString();
				paramsTemp.put(key, value);
			}
		}
		return paramsTemp;
	}

	public static void main(String[] args) {
		// String query = request.getParameter("query");
//		String query = "{\"key1\":\"value1\",\"key2\":\"value2\"}";
//
//		if (StringUtils.isNotEmpty(query)) {
//			// 将json字符串转换成jsonObject
//			JSONObject jsonObject = JSONObject.fromObject(query);
//			@SuppressWarnings("rawtypes")
//			Iterator ite = jsonObject.keys();
//			// 遍历jsonObject数据,添加到Map对象
//			while (ite.hasNext()) {
//				String key = ite.next().toString();
//				String value = jsonObject.get(key).toString();
//				System.out.println(key + ":" + value);
//			}
//		}
//		System.out.println(DateUtil.format(DateUtil.addDays(new Date(), -5), DateStyle.YYYY_MM_DD_HH_MM_SS));
//		
//		Date time = DateUtil.addDays(new Date(), -5);
//		time.setHours(0);
//		time.setMinutes(0);
//		time.setSeconds(0);
//		System.out.println(DateUtil.format(time, DateStyle.YYYY_MM_DD_HH_MM_SS));
		
		
		int i = 0;
		for (;i >= 0; i--) {
			System.out.println(i);
		}
	}
}