package com.shsxt.dao;

import com.shsxt.bean.Goods;
import com.shsxt.bean.User;

public interface IUserDao {
	
	
	/**
	 * 查询 商品信息
	 * @param id
	 * @return
	 */
	User queryUserById (Integer id); 
	
	
	/**
	 * 修改商品信息
	 * @param goods
	 * @return
	 */
	int updateUserInfoById (User user);
	
}
