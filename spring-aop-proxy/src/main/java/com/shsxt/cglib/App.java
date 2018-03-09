package com.shsxt.cglib;

import com.shsxt.jdk.Zi;

public class App {
	
	public static void main(String[] args) {
		
		Zi zi = new  Zi();
		
		CglibInterceptor cglibInterceptor = new CglibInterceptor(zi);
		
		Zi proxy = (Zi)cglibInterceptor.getProxy();
		
		proxy.chi("ha");
	}

}
