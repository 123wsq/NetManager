package com.wsq.net.manager.dao;

import java.util.List;
import java.util.Map;

import com.wsq.net.manager.bean.SysAuthMenuInf;

public interface SysAuthMenuInfDao {
	
	
	/**
	 * 查询菜单列表
	 * @return
	 * @throws Exception
	 */
	List<SysAuthMenuInf> selectSysMenuEntry(Map<String, Object> param)throws Exception;
	
	/**
	 * 获取用户菜单树
	 * @return
	 * @throws Exception
	 */
	List<SysAuthMenuInf> selectSysMenuAuthEntry(Map<String, Object> param)throws Exception;
	
	/**
	 * 添加菜单
	 */
	void addMenu(Map<String, Object> param) throws Exception;
	
	/**
	 * 删除菜单
	 */
	void removeMenu(Map<String, Object> param) throws Exception;
	
	/**
	 * 删除用户权限菜单
	 * @param param
	 * @throws Exception
	 */
	void removeAuthMenu(Map<String, Object> param) throws Exception;

}
