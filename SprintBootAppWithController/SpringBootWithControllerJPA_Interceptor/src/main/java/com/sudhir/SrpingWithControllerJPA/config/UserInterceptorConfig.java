package com.sudhir.SrpingWithControllerJPA.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.sudhir.SrpingWithControllerJPA.interceptor.MyInterceptor;

@SuppressWarnings("deprecation")
@Component
public class UserInterceptorConfig extends WebMvcConfigurerAdapter{

	@Autowired
	MyInterceptor myInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(myInterceptor);
	}
}
