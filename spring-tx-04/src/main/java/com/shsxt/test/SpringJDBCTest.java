package com.shsxt.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shsxt.bean.User;
import com.shsxt.dao.IUserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class SpringJDBCTest {

	@Autowired
	private IUserDao userDao;

	@Test
	public void test() {
		User user = new User();
		user.setUserName("root");
		user.setUserBalance(12.5);
		int r = userDao.addUserHasNoKey(user);
		System.out.println(r);

	}

}
