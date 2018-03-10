package com.shsxt.dao;

import java.util.List;

import com.shsxt.bean.User;

public interface IUserDao {
	
	/**
	 * 添加用户  
	 * @param user
	 * @return
	 */
	int addUserHasNoKey (User user);
	
	
	/**
	 * 添加用户  
	 * @param user
	 * @return
	 */
	int addUserHasKey (User user);
	
	
	public int addbatchUser (List<User> list) ;

}
