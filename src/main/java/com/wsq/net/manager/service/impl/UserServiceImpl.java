package com.wsq.net.manager.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.wsq.net.manager.bean.SysUserInf;
import com.wsq.net.manager.dao.SysUserInfDao;
import com.wsq.net.manager.service.UserService;
import com.wsq.net.manager.util.CalanderUtil;
import com.wsq.net.manager.util.ParamValidate;
import com.wsq.net.manager.util.ReturnMsg;

@Service
public class UserServiceImpl implements UserService{

	private Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Value("#{managerConfig}")
	private Properties prop;
	
	@Autowired
	private SysUserInfDao sysUserInfDao;
	




	/**
	 * 系统用户登录
	 */
	@Override
	public ReturnMsg syslogin(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		
		ParamValidate.doing(param, "userName","userPwd");
			
		ReturnMsg msg = new ReturnMsg();
		log.info("验证用户是否存在");
		List<SysUserInf> list = sysUserInfDao.selectSysEntry(param);
		if (list != null && list.size()==1) {
			
			//更新用户登录时间和登录次数
			param.put("sysLastTime", CalanderUtil.getCurrTime());
			sysUserInfDao.updateSysUserLoginCount(param);
			//记录用户登录记录
			
			msg.setSuccess("登录成功");
			return msg;
		}else {
			msg.setFail("登录失败");
		}
		
		
		return msg;
	}



}
