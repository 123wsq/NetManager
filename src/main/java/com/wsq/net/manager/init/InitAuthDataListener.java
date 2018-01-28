package com.wsq.net.manager.init;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletContextAware;


public class InitAuthDataListener  implements InitializingBean, ServletContextAware{

	private Logger log = LoggerFactory.getLogger(InitAuthDataListener.class);
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		// TODO Auto-generated method stub
		
		log.info("数据初始化");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
