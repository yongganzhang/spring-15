package com.shsxt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shsxt.dao.UserDao;
import com.shsxt.util.StringUtil;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public boolean userLogin(String userName, String userPwd) {

		if (!StringUtil.isNotNullOrEmpty(userName) 
				|| !StringUtil.isNotNullOrEmpty(userPwd)) {
			return false;
		}
		return userDao.userLogin(userName, userPwd);
	}

}
