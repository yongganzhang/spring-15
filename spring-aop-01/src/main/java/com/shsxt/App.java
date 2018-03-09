package com.shsxt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shsxt.service.UserService;

public class App {

	public static void main(String[] args) {
		ApplicationContext act = new ClassPathXmlApplicationContext("spring-context.xml");

		UserService bean = act.getBean(UserService.class);
		bean.print();
	}

}
