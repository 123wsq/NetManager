package com.wsq.net.manager.dao;

import java.util.List;
import java.util.Map;

import com.wsq.net.manager.bean.SysUserInf;

public interface SysUserInfDao {
	
	
	/**
	 * 获取系统用户信息
	 * @param param
	 * @return
	 * @throws Exception
	 */
	List<SysUserInf> selectSysEntry(Map<String, Object> param) throws Exception;
	
	/**
	 * 修改系统用户参数
	 * @param param
	 * @throws Exception
	 */
	void updateSysEntry(Map<String, Object> param) throws Exception;
	
	
	/**
	 * 修改用户登录次数
	 * @param param
	 * @throws Exception
	 */
	void updateSysUserLoginCount(Map<String, Object> param) throws Exception;

}
