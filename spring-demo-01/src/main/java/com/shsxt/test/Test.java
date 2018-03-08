package com.shsxt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shsxt.demo.HelloService;

public class Test {

	public static void main(String[] args) {

		// 加载好配置文件夹
		ApplicationContext act = new ClassPathXmlApplicationContext("spring-context.xml");

		HelloService hs = (HelloService) act.getBean("helloService");

		System.out.println(hs);
		for (int i = 0; i < 10; i++) {
			hs = (HelloService) act.getBean("helloService");
			System.out.println(hs);
		}
		hs = (HelloService) act.getBean("helloService");
		System.out.println(hs);

	}

}
