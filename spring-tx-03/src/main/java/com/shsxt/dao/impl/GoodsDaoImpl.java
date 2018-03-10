package com.shsxt.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.shsxt.bean.Goods;
import com.shsxt.dao.IGoodsDao;

@Repository
public class GoodsDaoImpl implements IGoodsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 查询商品信息
	 */
	public Goods queryGoodsById(Integer id) {

		String sql = "select  id, goods_name, goods_price, goods_stock from yg_goods where id = ?";

		return jdbcTemplate.queryForObject(sql, new Object[] { id }, new RowMapper<Goods>() {

			public Goods mapRow(ResultSet rs, int rowNum) throws SQLException {

				// 解析结果集
				Goods goods = new Goods();

				int id = rs.getInt(1);
				goods.setId(id);

				String name = rs.getString(2);
				goods.setGoodsName(name);

				double price = rs.getDouble(3);
				goods.setGoodsPrice(price);

				int stcok = rs.getInt(4);
				goods.setGoodsStock(stcok);
				return goods;
			}
		});
	}

	/**
	 * 商品的修改
	 */
	public int updateGoodsInfoById(Goods goods) {

		String sql = "UPDATE `yg_goods` SET   `goods_stock`= ? WHERE (`id`=?)";

		return jdbcTemplate.update(sql, new Object[] {goods.getGoodsStock(), goods.getId() });

	}

}
