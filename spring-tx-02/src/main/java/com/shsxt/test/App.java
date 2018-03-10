package com.shsxt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shsxt.dao.IUserDao;

public class App {

	public static void main(String[] args) {

		ApplicationContext act = new ClassPathXmlApplicationContext("spring-context.xml");
		IUserDao bean = act.getBean(IUserDao.class);
		
		System.out.println(bean);
	}

}
