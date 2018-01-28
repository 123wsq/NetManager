package com.wsq.net.manager.intercept;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.wsq.net.manager.util.ServletUtil;


public class AuthLoginInterception implements HandlerInterceptor{
	
	private Logger log = LoggerFactory.getLogger(AuthLoginInterception.class);
	
	@Value("#{managerConfig}")
	private Properties prop;
	
	
	private String LoginView="http://localhost:8080/NetManager/";
	
	/**
	 * 需要拦截的对象的后缀 集合
	 */
	private final static String[] SUFFIX  = {".do"};
	
	
	ServletUtil servletUtil = new ServletUtil();
	
	/**
	 * 签到交易（不拦截）
	 */
	private final static String[] LogUrl = new String[]{
		 "user/login.do"
		 
		};
	
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		log.debug("拦截开始。。。");
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("stime", System.currentTimeMillis());
		
		String url=request.getServletPath().substring(1);	
		
		String requestUrl = prop.getProperty("REQUEST_DIRECT");
		
		boolean filterFlag=true;
		//检查请求后缀，判断是否需要拦截
		for (int i = 0; i <SUFFIX.length; i++) {
			if(url.endsWith(SUFFIX[i])){
				filterFlag=false;
			}
		}
		if(filterFlag){
			log.info("登陆拦截-结束-url("+url+")不在拦截范围之内");
			return true;
		}
		//登陆放行集合检测， 如果需要放行，则放行。
		for (int i = 0; i < LogUrl.length; i++) {
			log.debug("请求的url:{}, 验证：{} ", url.substring(0,url.lastIndexOf(".do")+3), LogUrl[i]);
			if(url.substring(0,url.lastIndexOf(".do")+3).endsWith(LogUrl[i])){
				log.info("登陆拦截-结束-请求地址放行："+LogUrl[i]);
				return true;
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
		long endTime = System.currentTimeMillis();
		long stime = (Long) request.getAttribute("stime");
		
		log.debug("请求共耗时:  {} ms", (endTime- stime));
		
	}
	

}
