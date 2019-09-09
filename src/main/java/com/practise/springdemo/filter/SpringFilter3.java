package com.practise.springdemo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class SpringFilter3 implements Filter{

	@Override
	public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse,
			FilterChain filterChain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("Filter 3 is called");
		filterChain.doFilter(servletrequest,servletresponse);
	}



}
