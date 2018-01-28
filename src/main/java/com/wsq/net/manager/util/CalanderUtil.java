package com.wsq.net.manager.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CalanderUtil {

	/**
	 * 获取当前时间 格式  yyyyMMddHHmmss
	 * @return
	 */
	public static String getCurrTime(){
		
		SimpleDateFormat  format = new SimpleDateFormat("yyyyMMddHHmmss");
		return format.format(new Date());
	}
	
	
	
}
