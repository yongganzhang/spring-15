package com.shsxt.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shsxt.dao.UserDao;

@Service
public class UserService {

	// @Autowired
	@Resource
	private UserDao userDao;

	public void print() {
		System.out.println(userDao);
	}

//	@Autowired
//	public void setUserDao(UserDao userDao) {
//		this.userDao = userDao;
//	}

}
