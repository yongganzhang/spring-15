package com.shsxt.aspectj;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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

	/**
	 * 前置通知
	 */
	@Before(value = "cut ()")
	public void before() {
		System.out.println("前置通知。。。。");
	}

	/**
	 * 返回通知 方法执行后通知
	 */
	@AfterReturning("cut()")
	public void afterReturning() {
		System.out.println("返回通知");
	}

	/**
	 * 最终通知 不论是否发生都会执行
	 */
	@After(value = "cut()")
	public void after() {
		System.out.println("最终通知");
	}

	/**
	 * 异常通知 当拦截方法发生异常时，通知
	 * 
	 * @param ex
	 */
	@AfterThrowing(value = "cut()", throwing = "ex")
	public void afterThrowing(Exception ex) {
		System.out.println("异常通知" + ex.getMessage());
	}

	/***
	 * 
	 * 环绕通知 在方法执行前后 分别通知
	 * 
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	@Around(value = "cut()")
	public Object arround(ProceedingJoinPoint pjp) throws Throwable {

		System.out.println("环绕前置...");
		System.out.println("环绕通知");
		Long t1 = new Date().getTime();

		// 表示 被拦截方法的执行
		Object proceed = pjp.proceed();
		Long t2 = new Date().getTime();
		System.out.println("方法执行:" + (t2 - t1));

		System.out.println("环绕后置...");
		return proceed;
	}

}
