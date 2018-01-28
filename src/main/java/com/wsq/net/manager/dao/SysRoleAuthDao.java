package com.wsq.net.manager.dao;

import java.util.List;
import java.util.Map;


import com.wsq.net.manager.bean.SysRoleAuthBean;

public interface SysRoleAuthDao {
	
	/**
	 * 查询角色列表
	 * @return
	 * @throws Exception
	 */
	List<SysRoleAuthBean> selectSysRoleEntry(Map<String, Object> param)throws Exception;
	
	
	/**
	 * 添加角色
	 */
	void addRole(Map<String, Object> param) throws Exception;
	
	/**
	 * 删除角色
	 */
	void removeRole(Map<String, Object> param) throws Exception;
	

}
