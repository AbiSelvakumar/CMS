package com.practise.springdemo.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.practise.springdemo.filter.SpringFilter_URL;

@Configuration
public class SpringConfig {

	@Bean
	public FilterRegistrationBean<SpringFilter_URL> registrationBean(){

		FilterRegistrationBean<SpringFilter_URL> registrationBean=new FilterRegistrationBean<>();
		registrationBean.setFilter(new SpringFilter_URL());
		registrationBean.addUrlPatterns("/customers/*");

		return registrationBean;
	}

}
