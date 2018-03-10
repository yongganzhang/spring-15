package com.shsxt.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shsxt.api.IHelloService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class RmiClientTest {
	
	@Autowired
	private IHelloService helloService;

	@Test
	public void test() {
		String sayHello = helloService.sayHello("哈啊哈");
		
		System.out.println(sayHello);
	}

}
