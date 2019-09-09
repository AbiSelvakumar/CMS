package com.practise.springdemo.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpring {

	@RequestMapping(value="/hello")
	public String SayHello()
	{
		return "Hello Spring";
	}

}
