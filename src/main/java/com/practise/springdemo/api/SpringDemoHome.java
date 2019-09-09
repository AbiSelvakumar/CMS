package com.practise.springdemo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringDemoHome {

	@GetMapping
	public String SpringDemoHome()
	{
		return "Application is working!";
	}

}
