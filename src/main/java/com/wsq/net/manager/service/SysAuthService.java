package com.wsq.net.manager.service;

import java.util.List;
import java.util.Map;

import com.wsq.net.manager.bean.SysAuthMenuInf;
import com.wsq.net.manager.bean.SysRoleAuthBean;
import com.wsq.net.manager.bean.Tree;


public interface SysAuthService {
	
	
	/**
	 * 获取主界面菜单列表
	 * @param param
	 * @return
	 * @throws Exception
	 */
	List<Tree> leftMainMenu(Map<String, Object> param) throws Exception;
	
	/**
	 * 获取所有菜单
	 * @param param
	 * @return
	 * @throws Exception
	 */
	List<SysAuthMenuInf> getAllMenu(Map<String, Object> param) throws Exception;
	
	/**
	 * 添加菜单
	 * @param param
	 * @throws Exception
	 */
	void onAddMenu(Map<String, Object> param) throws Exception;
	
	/**
	 * 删除菜单
	 * @param param
	 * @throws Exception
	 */
	void onRemoveMenu(Map<String, Object> param) throws Exception;
	
	
	/**
	 * 获取所有角色
	 * @param param
	 * @return
	 * @throws Exception
	 */
	List<SysRoleAuthBean> getAllRoleList(Map<String, Object> param) throws Exception;
	
	/**
	 * 添加角色
	 * @param param
	 * @throws Exception
	 */
	void onAddRole(Map<String, Object> param) throws Exception;
	
	/**
	 * 删除角色
	 * @param param
	 * @throws Exception
	 */
	void onRemoveRole(Map<String, Object> param) throws Exception;

}
