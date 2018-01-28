package com.wsq.net.manager.service;

import java.util.Map;

import com.wsq.net.manager.util.ReturnMsg;


public interface UserService {

	
	/**
	 * 系统用户登录
	 * @param param
	 * @throws Exception
	 */
	ReturnMsg syslogin(Map<String, Object> param) throws Exception;
	
	
}
