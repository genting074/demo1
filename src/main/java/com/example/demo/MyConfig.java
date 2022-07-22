package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//public class MyConfig implements WebMvcConfigurer {
	public class MyConfig  {
//	@Autowired
//	private DemoInterceptor demoInterceptor;
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//	registry.addInterceptor(demoInterceptor).addPathPatterns("/**");
//	}
	@Bean
	public TestInertface showComponent() {

		System.out.println("showComponent");
		return new TestComponent();
	}
}
