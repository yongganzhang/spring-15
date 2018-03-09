package com.shsxt.cglib;

import java.lang.reflect.Method;
import java.util.Date;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * cglib 实现动态代理
 * 
 * @author Mr.YongGan.Zhang
 * @versin 1.0.0
 * @since JDK1.8
 */
public class CglibInterceptor implements MethodInterceptor {

	private Object target;

	public CglibInterceptor(Object target) {
		this.target = target;
	}

	// 运行期动态创建代理类
	public Object getProxy() {
		Enhancer enhancer = new Enhancer();
		// 设置父类 class
		enhancer.setSuperclass(target.getClass()); // 目标对象的类
		enhancer.setCallback(this);
		return enhancer.create();// 创建代理对象
	}

	public void before() {
		System.out.println("方法执行前。。");
		System.out.println(new Date().getTime());
	}

	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

		before();
		Object invoke = proxy.invoke(target, args);
		after();
		return invoke;
	}

	public void after() {
		System.out.println("方法执行后。。");
		System.out.println(new Date().getTime());
	}

}
