package com.shsxt.service;

import com.shsxt.dao.UserDao;

public class StaticFactory {
	
	public static UserDao createUserDao () {
		return new UserDao();
	}

}
