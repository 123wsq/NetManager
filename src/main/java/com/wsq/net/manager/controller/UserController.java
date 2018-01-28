package com.wsq.net.manager.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wsq.net.manager.service.UserService;
import com.wsq.net.manager.util.HttpParam;
import com.wsq.net.manager.util.ReturnMsg;

/**
 * 用户控制器
 * @author wsq
 *
 */
@Controller
@RequestMapping("user")
public class UserController {
	
	private Logger log = LoggerFactory.getLogger(UserController.class);
	
	
	@Autowired
	private UserService userService;
	
	
	/**
	 * 获取主页面地址
	 * @return
	 */
	@RequestMapping("mainPanel")
	public String gotoMain(HttpServletRequest request){
		
		return "index";
	}
	
	/**
	 * 用户登录
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@RequestMapping(value="login", method=RequestMethod.POST)
	@ResponseBody
	public ReturnMsg Login(HttpServletRequest request, HttpSession session, HttpServletResponse response){
		log.debug("开始登录"); 
		ReturnMsg msg = new ReturnMsg();
		Map<String, Object> param =null;
		try {
			
			param = HttpParam.getHttpParam(request);
			
			msg = userService.syslogin(param);
			msg.put("redirect", "user/mainPanel.do");
			msg.setSuccess();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg.setFail();
			
		}
		
		
		return msg;
	}
	
	
	
	
}
