package com.shsxt.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-context.xml"})
public class SpringJDBCTest {

	@Autowired
	private JdbcTemplate  jdbcTemplate;
	
	@Test
	public void test() {
		
		String sql =  "select count(1) from yg_goods";
		Integer queryForObject = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println(queryForObject);
	}

}
