package com.shsxt.factory;

import com.shsxt.bean.UserSerivce;

/**
 * 静态工厂
 * @author Mr.YongGan.Zhang
 * @versin 1.0.0
 * @since JDK1.8
 */
public class StaticFactory {
	
	public static UserSerivce createUserSerivce () {
		return new UserSerivce();
	}

}
