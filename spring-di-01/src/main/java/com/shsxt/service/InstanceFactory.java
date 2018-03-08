package com.shsxt.service;

import com.shsxt.dao.UserDao;

public class InstanceFactory {
	
	public static UserDao createUserDao () {
		return new UserDao();
	}


}
