package com.shsxt.aspectj;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogCut {

	/**
	 * 切点
	 */
	@Pointcut("execution (* com.shsxt.service..*.*(..))")
	public void cut() {
	}

	@Before(value = "cut ()")
	public void before() {
		System.out.println("前置通知。。。。");
	}

	/**
	 * 返回通知
	 */
	@AfterReturning ("cut()")
	public void afterReturning () {
		System.out.println("返回通知");
	}
	
}
