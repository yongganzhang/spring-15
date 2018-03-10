package com.shsxt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shsxt.bean.Goods;
import com.shsxt.bean.User;
import com.shsxt.dao.IGoodsDao;
import com.shsxt.dao.IUserDao;

@Service
public class ShoppingGoodsService {
	
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IGoodsDao goodsDao;
	
	
	/**
	 * 商品够买
	 * @param uid
	 * @param gid
	 * @param num
	 */
	@Transactional
	public  void  payGoodsOrder (int uid, int gid, int num) {
		
		// 用户信息
		User user = userDao.queryUserById(uid);
		// 商品信息
		Goods goods = goodsDao.queryGoodsById(gid);
	
		//判断用户是否符合购买条件
		double newbal = user.getUserBalance() -  goods.getGoodsPrice() * num;
		if  (newbal < 0) 
			throw new  RuntimeException("用户余额不足");
		user.setUserBalance(newbal);
		
		// 修改用户的余额
		int res = userDao.updateUserInfoById(user);
		if (res != 1)
			throw new  RuntimeException("用户扣除余额 失败");
		
		//////////扣除商品库存///////////////////
		int  newstcok =  goods.getGoodsStock() - num;
		if (newstcok < 0)
			throw new  RuntimeException("商品的库存不足");
		
		//修改商品库存
		goods.setGoodsStock(newstcok);
		int gr = goodsDao.updateGoodsInfoById(goods);
		if (gr !=  1)
			throw new  RuntimeException("商品的库扣减失败");
		
	}

}
