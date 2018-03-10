package com.shsxt.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shsxt.dao.IUserDao;
import com.shsxt.service.ShoppingGoodsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class SpringJDBCTest {

	@Autowired
	private ShoppingGoodsService goodsService;

	@Test
	public void test() {
		goodsService.payGoodsOrder(1, 1, 1);

	}

}
