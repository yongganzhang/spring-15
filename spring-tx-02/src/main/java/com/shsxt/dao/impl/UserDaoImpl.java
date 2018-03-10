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

		int i = 1 / 0;

		return res;
	}

}
