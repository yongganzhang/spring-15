package com.shsxt.service;

import com.shsxt.dao.UserDao;

public class InstanceFactory {
	
	public  UserDao createUserDao () {
		return new UserDao();
	}


}
