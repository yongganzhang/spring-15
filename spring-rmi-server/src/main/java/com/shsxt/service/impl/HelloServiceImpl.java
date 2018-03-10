package com.shsxt.service.impl;

import org.springframework.stereotype.Service;

import com.shsxt.api.IHelloService;

@Service
public class HelloServiceImpl implements IHelloService {

	public String sayHello(String msg) {

		System.out.println("服务器端收到信息：" + msg);
		return "hello:" + msg;

	}

}
