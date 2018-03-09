package com.shsxt.jdk;

public class App {
	
	public static void main(String[] args) {
		
		// 获取目标对象
		Foo f = new Zi();
		
		//获取代理对象
		JdkHandler jdkHandler = new JdkHandler(f);
		Object proxy = (Foo)jdkHandler.getProxy();
		
		// 代理对象执行方法
		f.chi("");
		
	}
}
