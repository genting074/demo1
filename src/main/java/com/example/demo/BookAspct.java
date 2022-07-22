package com.example.demo;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BookAspct {
	@Pointcut("execution(* com.example.demo.*Constroller.*(..))")
	private void logtext() {
		
	}
	
	@Before("logtext()")	
//	@Before("execution(* com.example.demo.HelloConstroller.*(..))")	
	public void before(JoinPoint joinpoint) {		
		System.out.println("before: "+ joinpoint.getSignature().getName());
	}
	
	@After("logtext()")	
//	@After("execution(* com.example.demo.HelloConstroller.*(..))")	
	public void after(JoinPoint joinpoint) {		
		System.out.println("after:"+joinpoint.getSignature().getModifiers());		
	}
	
	@Around("logtext()")	
//	@Around("execution(* com.example.demo.HelloConstroller.*(..))")	
	public Object arround(ProceedingJoinPoint joinPoint) throws Throwable {		
		System.out.println("arround before");		
		Object obj = joinPoint.proceed();
		System.out.println("arround after");		
		return obj;
	}
}
