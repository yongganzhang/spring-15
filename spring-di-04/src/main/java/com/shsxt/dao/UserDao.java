package com.shsxt.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	private String userName = "admin";

	private String userPwd = "admin";

	public boolean userLogin(String userName, String userPwd) {

		if (this.userName.equals(userName) && this.userPwd.equals(userPwd)) {
			return true;
		}

		return false;

	}

}
