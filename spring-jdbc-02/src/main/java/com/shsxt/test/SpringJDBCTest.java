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
			user.setUserName("root" + i);
			user.setUserBalance(12.5);
			list.add(user);
		}
		int r = userDao.addbatchUser(list);
		System.out.println(r);

	}

	@Test
	public void test4() {

		User user = userDao.queryUserByUid(19);
		System.out.println(user);

	}

	@Test
	public void test5() {

		List<User> list = userDao.queryUserlikeByUserName("root");

		for (User user : list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void test6() {

		int i = userDao.delUserByUid(33);
		System.out.println(i);
	}
	
	@Test
	public void test7() {
		
		Integer[] ids =	new Integer[21];
		
		for (int i = 0; i < 21; i++) {
			
			ids[i] = i+12;
		}
		
		int i = userDao.delbatchUserByIds(ids);
		System.out.println(i);
	}

}
