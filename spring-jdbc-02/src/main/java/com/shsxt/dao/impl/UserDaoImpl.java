package com.shsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

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

	/**
	 * 添加用户
	 */
	public int addUserHasNoKey(User user) {

		String sql = "INSERT INTO yg_customer ( user_name , user_balance) VALUES (?, ?)";
		// 实现了 数据插入
		int res = jdbcTemplate.update(sql, new Object[] { user.getUserName(), user.getUserBalance() });
		return res;
	}

	public int addUserHasKey(final User user) {
		final String sql = "INSERT INTO yg_customer ( user_name , user_balance) VALUES (?, ?)";
		// 存放主键信息
		KeyHolder KeyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// 设置主键
				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

				// 设置参数
				ps.setString(1, user.getUserName());
				ps.setDouble(2, user.getUserBalance());
				return ps;
			}

		}, KeyHolder);

		return KeyHolder.getKey().intValue();
	}

	

	/**
	 * 瞅瞅即可
	 * 
	 * @param user
	 * @return
	 */
//	public int addUserHasKeyV2(final User user) {
//		final String sql = "INSERT INTO yg_customer ( user_name , user_balance) VALUES (?, ?)";
//		// 存放主键信息
//		KeyHolder KeyHolder = new GeneratedKeyHolder();
//
//		jdbcTemplate.update(
//				(con) -> {
//					// 设置主键
//					PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//
//					// 设置参数
//					ps.setString(1, user.getUserName());
//					ps.setDouble(2, user.getUserBalance());
//					return ps;
//				}
//		, KeyHolder);
//
//		return KeyHolder.getKey().intValue();
//	}

	/**
	 * 批量插入
	 * 
	 */
	@Override
	public int addbatchUser(List<User> list) {
	
		String sql = "INSERT INTO yg_customer ( user_name , user_balance) VALUES (?, ?)";
		
		int[] batchUpdate = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			//设置值
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setString(1, list.get(i).getUserName());
				ps.setDouble(2,list.get(i).getUserBalance());
			}

			//设置 批量插入的个数
			@Override
			public int getBatchSize() {
				return list.size();
			}
			
		});
		return batchUpdate.length;
	}
	
}
