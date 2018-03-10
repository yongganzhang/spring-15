package com.shsxt.dao;

import com.shsxt.bean.Goods;

public interface IGoodsDao {
	
	/**
	 * 查询 商品信息
	 * @param id
	 * @return
	 */
	Goods queryGoodsById (Integer id); 
	
	
	/**
	 * 修改商品信息
	 * @param goods
	 * @return
	 */
	int updateGoodsInfoById (Goods goods);
	

}
