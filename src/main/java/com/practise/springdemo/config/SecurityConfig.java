package com.practise.springdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	     http.csrf().disable();
	}

	@Bean
	@Override
	protected UserDetailsService userDetailsService(){

		PasswordEncoder encoder=PasswordEncoderFactories.createDelegatingPasswordEncoder();
		User.UserBuilder userBuilder=User.builder().passwordEncoder(encoder::encode);
		UserDetails user1=userBuilder
				.username("demouser")
				.password("password")
				.roles("USER")
				.build();

		UserDetails user2=userBuilder
				.username("admin")
				.password("admin")
				.roles("USER","ADMIN")
				.build();

		return new InMemoryUserDetailsManager(user1,user2);
	}



}
