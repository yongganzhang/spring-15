package com.shsxt.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shsxt.bean.User;
import com.shsxt.dao.IUserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-context.xml" })
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
	
	@Test
	public void test2() {

		User user = new User();
		user.setUserName("root123");
		user.setUserBalance(12.5);
		int r = userDao.addUserHasKey(user);
		System.out.println(r);

	}
	
	@Test
	public void test3() {
		
		List<User> list = new ArrayList<>();
		
		for (int i = 0; i < 5; i++) {
			User user = new User();
			user.setUserName("root"+i);
			user.setUserBalance(12.5);
			list.add(user);
		}
		int r = userDao.addbatchUser(list);
		System.out.println(r);

	}

}
