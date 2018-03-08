package com.shsxt.service;

import com.shsxt.dao.UserDao;

public class UserService {

	private UserDao userDao;
	
	private String name;
	
	private Integer age;

	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public void setUserDao(UserDao dao) {
		this.userDao = dao;
	}

	public void print() {
		System.out.println(userDao);
		System.out.println(name + "---->" + age);
	}
}
