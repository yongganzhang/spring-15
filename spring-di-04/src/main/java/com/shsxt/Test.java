package com.shsxt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shsxt.controller.UserController;
import com.shsxt.service.UserService;

public class Test {

	public static void main(String[] args) {

		// 加载好配置文件夹
		ApplicationContext act = new ClassPathXmlApplicationContext("spring-context.xml");

		UserController bean = act.getBean(UserController.class);

		System.out.println(bean.userLogin("admin", "admin"));

	}
}
