package com.shsxt.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

/**
 * JDK动态代理
 * 
 * 代理类
 * 
 * @author Mr.YongGan.Zhang
 * @versin 1.0.0
 * @since JDK1.8
 */
public class JdkHandler implements InvocationHandler {

	// 目标对象
	private Object target;

	public JdkHandler(Object target) {
		this.target = target;
	}

	/**
	 * 程序运行期 创建 代理对象 动态代理对象
	 * 
	 */
	public Object getProxy() {
		return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	public void before() {
		System.out.println("方法执行前。。");
		System.out.println(new Date().getTime());
	}

	/**
	 * 执行 被代理对象的方法
	 * 
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		before();
		Object invoke = method.invoke(target, args);
		after();
		return invoke;
	}

	public void after() {
		System.out.println("方法执行后。。");
		System.out.println(new Date().getTime());
	}

}
