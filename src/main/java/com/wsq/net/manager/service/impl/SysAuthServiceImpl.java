package com.wsq.net.manager.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wsq.net.manager.bean.Attributes;
import com.wsq.net.manager.bean.SysAuthMenuInf;
import com.wsq.net.manager.bean.SysRoleAuthBean;
import com.wsq.net.manager.bean.Tree;
import com.wsq.net.manager.dao.SysAuthMenuInfDao;
import com.wsq.net.manager.dao.SysRoleAuthDao;
import com.wsq.net.manager.service.SysAuthService;
import com.wsq.net.manager.util.CalanderUtil;
import com.wsq.net.manager.util.ParamValidate;

@Service
public class SysAuthServiceImpl implements SysAuthService{

	
	private Logger Log = LoggerFactory.getLogger(SysAuthServiceImpl.class);
	
	@Autowired
	private SysAuthMenuInfDao sysAuthMenuInfDao;
	
	@Autowired
	private SysRoleAuthDao sysRoleAuthDao;
	
	/**
	 * 获取主界面中的菜单列表
	 */
	@Override
	public List<Tree> leftMainMenu(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		Log.info("开始验证参数");
		ParamValidate.doing(param, "user_id");
		List<Tree> tree = new ArrayList<Tree>();
		List<SysAuthMenuInf> list = sysAuthMenuInfDao.selectSysMenuAuthEntry(param);
		
		Log.info("读取到的菜单列表   {}", list);
		tree.addAll(makeMenuToTreeForM(list, "00"));
		return tree;
	}
	
	private List<Tree> makeMenuToTreeForM(List<SysAuthMenuInf> menuList,String parentId) {
		
		List<Tree> treeList = new ArrayList<Tree>();
		
		for(SysAuthMenuInf menu:menuList){
			if(menu.getParent_id()!=null){
				if(parentId.equals(menu.getParent_id().trim())){
					Tree tree = new Tree();
					tree.setId(menu.getMenu_id());
					tree.setText(menu.getMenu_name());
					tree.setName(menu.getMenu_name());
					tree.setMenuParId(menu.getParent_id());
					tree.setType("folder");
					Attributes attr = new Attributes();
					attr = new Attributes();
					attr.setUrl(menu.getMenu_url());
					//菜单属性元素
					attr.setMenuStatus(menu.getMenu_state()+"");
					//将属性设置到树节点
					tree.setAttributes(attr);
					addChildrenToTreeForM(tree.children,menu.getMenu_id().trim(),menuList);
					treeList.add(tree);
				}
			}
		}
		return treeList;
	}
	
	private void addChildrenToTreeForM(List<Tree> treeList,String parId,List<SysAuthMenuInf> menuList) {
		for(SysAuthMenuInf menu:menuList){
			if(menu.getParent_id()!=null){
				if(parId.equals(menu.getParent_id().trim())){
					Tree tree = new Tree();
					tree.setId(menu.getMenu_id());
					tree.setText(menu.getMenu_name());
					tree.setName(menu.getMenu_name());
					Attributes attr = new Attributes();
					attr.setMenuStatus(menu.getMenu_state()+"");
					attr.setUrl(menu.getMenu_url());
					tree.setAttributes(attr);
						
					addChildrenToTreeForM(tree.children,menu.getMenu_id().trim(),menuList);
					treeList.add(tree);
				}
			}
		}
	}

	
	/**
	 * 获取所有的菜单
	 */
	@Override
	public List<SysAuthMenuInf> getAllMenu(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		
		List<SysAuthMenuInf> list = sysAuthMenuInfDao.selectSysMenuEntry(param);
		
		return list;
	}

	/**
	 * 添加菜单
	 */
	@Override
	public void onAddMenu(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		
		//验证菜单
		ParamValidate.doing(param,  "menu_name","menu_state", "menu_type");
		Map<String, Object> insertParam = new HashMap<String, Object>();
		
		String parent_id = "";
//		if (ParamValidate.validate(parent_id)) {
//			parent_id ="00";
//		}
		if (!ParamValidate.validate(param.get("threeMenu")+"")) {
			
			if (!ParamValidate.validate(param.get("twoMenu")+"")) {
				
				if (!ParamValidate.validate(param.get("oneMenu")+"")) {
					parent_id = "00";
				}else {
					parent_id = param.get("oneMenu")+"";
				}
			}else {
				parent_id = param.get("twoMenu")+"";
			}
		}else {
			parent_id = param.get("threeMenu")+"";
		}
		
		
		Log.info(insertParam.toString());
		insertParam.put("parent_id", parent_id);
		//g根据父级菜单查询子菜单的最后一个的ID；
		List<SysAuthMenuInf> list = sysAuthMenuInfDao.selectSysMenuEntry(insertParam);
		SysAuthMenuInf menuInfo = list.get(list.size()-1);
		String pMenu_id = menuInfo.getMenu_id();
		int pMenu_id1 = Integer.parseInt(pMenu_id);
		Log.info(pMenu_id1+"");
		pMenu_id1++;
		String menu_id= "";
		if ((pMenu_id1+"").length() % 2 == 0 ) {
			menu_id = pMenu_id.length()==0 ? "00" : pMenu_id;
		}else {
			menu_id = "0" + pMenu_id1;
		}
		Log.info(menu_id+"");
		insertParam.put("menu_id", menu_id);
		insertParam.put("menu_name", param.get("menu_name"));
		insertParam.put("menu_state", param.get("menu_state"));
		insertParam.put("menu_url", param.get("menu_url"));
		insertParam.put("menu_level", menu_id.length() / 2);
		//判断菜单类型
		String menu_type = param.get("menu_type")+"";
		if (menu_type.equals("0")) { //表示菜单
			insertParam.put("menu_type", 0);
			
		}else { //按钮
			insertParam.put("menu_type", 1);
		}
		
		//开始插入数据库
		sysAuthMenuInfDao.addMenu(insertParam);
	}

	/**
	 * 删除菜单
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void onRemoveMenu(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		ParamValidate.doing(param, "menu_id");
		//删除菜单表中的该数据
		sysAuthMenuInfDao.removeMenu(param);
		//删除菜单用户权限中的数据
		sysAuthMenuInfDao.removeAuthMenu(param);
	}

	
	/**
	 * 获取角色列表
	 */
	@Override
	public List<SysRoleAuthBean> getAllRoleList(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		
		List<SysRoleAuthBean> list = sysRoleAuthDao.selectSysRoleEntry(param);
		return list;
	}

	/**
	 * 添加角色
	 */
	@Override
	public void onAddRole(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		ParamValidate.doing(param, "role_name");
		param.put("role_id", CalanderUtil.getCurrTime());
		param.put("create_time", CalanderUtil.getCurrTime());
		param.put("update_time", CalanderUtil.getCurrTime());
		
		sysRoleAuthDao.addRole(param);
	}

	/**
	 * 删除角色
	 * 在删除角色的同时  也应当要将该角色的所有用户解除关系
	 */
	@Override
	public void onRemoveRole(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		
		ParamValidate.doing(param, "role_id");
		
		sysRoleAuthDao.removeRole(param);
	}


}
