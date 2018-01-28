package com.wsq.net.manager.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HttpParam {

	private static Logger log = LoggerFactory.getLogger(HttpParam.class);
	/**
	 * 获取请求参数
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> getHttpParam(HttpServletRequest request) throws Exception{
		
		Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Entry<String, String[]>> it = request.getParameterMap().entrySet().iterator();
		
		while (it.hasNext()) {
			Entry<String, String[]> e = it.next();
			
			param.put(e.getKey(), e.getValue()[0]);
		}
		
		
		if (param.containsKey("page")) {
			
			int page = Integer.parseInt(param.get("page").toString());
			int rows = Integer.parseInt(param.get("rows").toString());
			param.put("start", (page-1)*rows);
			param.put("size", rows);
		}
		log.info("请求参数: {}", param);
		return param;
	}
}
