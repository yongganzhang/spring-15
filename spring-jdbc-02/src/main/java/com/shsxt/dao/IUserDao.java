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
	
	
	public  User  queryUserByUid (Integer uid);
	
	/**
	 * 根据姓名查询
	 * @return
	 */
	public List<User> queryUserlikeByUserName (String name);
	
	public  int delUserByUid (int id);
	
	
	public int delbatchUserByIds (Integer[] ids) ;
	

}
