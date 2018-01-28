package com.wsq.net.manager.util;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ParamValidate {
	
	
	private static Logger log = LoggerFactory.getLogger(ParamValidate.class);
	
	public static void doing(Map<String, Object> param, String...key)throws Exception{
		
		for (int i = 0; i < key.length; i++) {
			if (!param.containsKey(key[i]) || param.get(key[i]).equals("") || param.get(key[i]) =="") {
				throw new Exception("必要参数 "+key[i]+" 不能为空!");
			}
		}
	}
	
	public static boolean validate(String...param){
		
		for (int i = 0; i < param.length; i++) {
			
			if (param[i] == null || param[i].equals("")) {
				
				return false;
			}
		}
		
		return true;
	}
}
