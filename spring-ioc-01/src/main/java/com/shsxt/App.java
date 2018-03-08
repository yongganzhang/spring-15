package com.shsxt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shsxt.bean.UserSerivce;
import com.shsxt.bean.UserSerivce2;

public class App {

	public static void main(String[] args) {

		// 加载好配置文件夹
		ApplicationContext act = new ClassPathXmlApplicationContext("spring-context.xml");

//		UserSerivce userSerivce = act.getBean(UserSerivce.class);
//		
//		userSerivce.print();
		
		UserSerivce2 bean = act.getBean(UserSerivce2.class);
		
		bean.print();
		
	}

}
