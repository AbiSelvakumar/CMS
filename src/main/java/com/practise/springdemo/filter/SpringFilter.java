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
@Order(3)
public class SpringFilter implements Filter{

	@Override
	public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse,
			FilterChain filterChain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("Filter 1 is called");
		filterChain.doFilter(servletrequest,servletresponse);
	}



}
