package com.shsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shsxt.bean.User;
import com.shsxt.dao.IUserDao;

/**
 * 使用spring jdbc 完成CRUD 操作
 * 
 * 
 * @author Mr.YongGan.Zhang
 * @versin 1.0.0
 * @since JDK1.8
 */
@Repository
public class UserDaoImpl implements IUserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;


	public User queryUserById(Integer id) {
	
		String sql = "select  id, user_name 'userName', user_balance 'userBalance' from yg_customer where id = ?";

		return jdbcTemplate.queryForObject(sql, new Object[] { id }, new RowMapper<User>() {

			public User mapRow(ResultSet rs, int rowNum) throws SQLException {

				// 解析结果集
				User user = new User();
				int id = rs.getInt(1);
				user.setId(id);

				String name = rs.getString(2);
				user.setUserName(name);

				double bal = rs.getDouble(3);
				user.setUserBalance(bal);

				return user;
			}
		});
	}

	/**
	 * 修改账户余额
	 */
	public int updateUserInfoById(User user) {
	
		String sql =  "UPDATE `yg_customer` SET `user_balance`= ? WHERE  id= ? ";
		
		return jdbcTemplate.update(sql, new Object[] {user.getUserBalance(), user.getId()});
	}


	
}
