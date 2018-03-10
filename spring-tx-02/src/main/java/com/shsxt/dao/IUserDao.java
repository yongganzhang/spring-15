package com.shsxt.dao;

import com.shsxt.bean.User;

public interface IUserDao {
	
	/**
	 * 添加用户  
	 * @param user
	 * @return
	 */
	int addUserHasNoKey (User user);
	

}
