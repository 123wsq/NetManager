package com.wsq.net.manager.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wsq.net.manager.bean.SysAuthMenuInf;
import com.wsq.net.manager.bean.SysRoleAuthBean;
import com.wsq.net.manager.bean.Tree;
import com.wsq.net.manager.service.SysAuthService;
import com.wsq.net.manager.util.HttpParam;
import com.wsq.net.manager.util.ReturnMsg;

@Controller
@RequestMapping("auth")
public class SysAuthController {
	
	
	private Logger logger = LoggerFactory.getLogger(SysAuthController.class);
	
	@Autowired
	private SysAuthService sysAuthService;
	
	/**
	 * 显示所有菜单的页面
	 * @return
	 */
	@RequestMapping("authMenuManager")
	public String getMenuListView(){
		
		return "user/auth/authMenuManager";
	}
	
	/**
	 * 添加菜单
	 * @return
	 */
	@RequestMapping("addMenuView")
	public String addMenuView(){
		
		return "user/auth/addmenuView";
	}
	
	/**
	 * 显示所有角色列表的页面
	 * @return
	 */
	@RequestMapping("RoleAuthManager")
	public String getRoleListView(){
		
		return "user/role/authRoleManager";
	}
	
	/**
	 * 添加角色的页面
	 * @return
	 */
	@RequestMapping("addRoleView")
	public String addRoleView(){
		
		return "user/role/addRoleView";
	}
	
	
	
	/**
	 * 获取主界面中左侧的菜单列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value="getLeftMenu", method=RequestMethod.POST)
	@ResponseBody
	public List<Tree> getLeftMenu(HttpServletRequest request) {
		
		ReturnMsg msg = new ReturnMsg();
		Map<String, Object> param =null;
		try {
			param = HttpParam.getHttpParam(request);
			List<Tree> list = sysAuthService.leftMainMenu(param);
			
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg.setFail();
		}
		
		return null;
	}
	
	/**
	 * 获取所有的菜单
	 * @param request
	 * @return
	 */
	@RequestMapping(value="getAllMenu", method=RequestMethod.GET)
	@ResponseBody
	public ReturnMsg getallMenu(HttpServletRequest request) {
		
		
		ReturnMsg msg = new ReturnMsg();
		Map<String, Object> param =null;
		try {
			param = HttpParam.getHttpParam(request);
			List<SysAuthMenuInf> list = sysAuthService.getAllMenu(param);
			msg.setRecords(0);
			msg.setRows(list);
			msg.setSuccess();
			return msg;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg.setFail();
		}
		
		return null;
	}
	
	
	/**
	 * 添加菜单
	 * @param request
	 * @return
	 */
	@RequestMapping(value="addMenu", method=RequestMethod.POST)
	@ResponseBody
	public ReturnMsg addMenu(HttpServletRequest request) {
		
		
		ReturnMsg msg = new ReturnMsg();
		Map<String, Object> param =null;
		try {
			param = HttpParam.getHttpParam(request);
			
			sysAuthService.onAddMenu(param);
			
			msg.setSuccess();
			return msg;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg.setFail();
		}
		
		return null;
	}
	
	/**
	 * 删除菜单
	 * @param request
	 * @return
	 */
	@RequestMapping(value="removeMenu", method=RequestMethod.POST)
	@ResponseBody
	public ReturnMsg removeMenu(HttpServletRequest request) {
		ReturnMsg msg  = new ReturnMsg();
		Map<String, Object> param  = null;
		try {
			param = HttpParam.getHttpParam(request);
			sysAuthService.onRemoveMenu(param);
			msg.setSuccess();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg.setFail();
		}
		
		return msg;
	}
	
	
	/**
	 * 获取所有的角色列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value="getAllRoleList", method=RequestMethod.GET)
	@ResponseBody
	public ReturnMsg getAllRoleList(HttpServletRequest request) {
		
		
		ReturnMsg msg = new ReturnMsg();
		Map<String, Object> param =null;
		try {
			param = HttpParam.getHttpParam(request);
			List<SysRoleAuthBean> list = sysAuthService.getAllRoleList(param);
			msg.setRecords(0);
			msg.setRows(list);
			msg.setSuccess();
			return msg;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg.setFail();
		}
		
		return null;
	}
	
	/**
	 * 添加角色
	 * @param request
	 * @return
	 */
	@RequestMapping(value="addRole", method=RequestMethod.POST)
	@ResponseBody
	public ReturnMsg addRole(HttpServletRequest request) {
		
		
		ReturnMsg msg = new ReturnMsg();
		Map<String, Object> param =null;
		try {
			param = HttpParam.getHttpParam(request);
			
			sysAuthService.onAddRole(param);
			
			msg.setSuccess();
			return msg;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg.setFail();
		}
		
		return null;
	}
	
	/**
	 * 删除角色
	 * @param request
	 * @return
	 */
	@RequestMapping(value="removeRole", method=RequestMethod.POST)
	@ResponseBody
	public ReturnMsg removeRole(HttpServletRequest request) {
		ReturnMsg msg  = new ReturnMsg();
		Map<String, Object> param  = null;
		try {
			param = HttpParam.getHttpParam(request);
			sysAuthService.onAddRole(param);
			msg.setSuccess();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg.setFail();
		}
		
		return msg;
	}
}
