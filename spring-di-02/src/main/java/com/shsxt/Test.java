package com.shsxt;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shsxt.demo.FoodsService;

public class Test {

	public static void main(String[] args) {

		// 加载好配置文件夹
		ApplicationContext act = new ClassPathXmlApplicationContext("spring-context.xml");

		FoodsService bean = act.getBean(FoodsService.class);
		List<String> list = bean.getList();

		for (String s : list) {
			System.out.println(s);
		}

		//////////////////////////////////////
		Set<String> set = bean.getSet();
		for (String s : set) {
			System.out.println(s);
		}

		Map<String, String> map = bean.getMap();
		Set<Entry<String, String>> entrySet = map.entrySet();
		for (Entry<String, String> entry : entrySet) {
			System.out.println(entry.getKey() + "----->" + entry.getValue());
		}

	}
}
