package com.shsxt;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shsxt.demo.UserService;

public class Test {

	public static void main(String[] args) {

		// 加载好配置文件夹
		AbstractApplicationContext act = new ClassPathXmlApplicationContext("spring-context.xml");
		UserService bean = act.getBean(UserService.class);

		System.out.println(bean);
		bean = act.getBean(UserService.class);
		System.out.println(bean);
		
		///////////////////////
		act.close();

	}
}
