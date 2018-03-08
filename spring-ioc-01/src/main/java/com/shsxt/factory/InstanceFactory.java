package com.shsxt.factory;

import com.shsxt.bean.UserSerivce;
import com.shsxt.bean.UserSerivce2;

public class InstanceFactory {
	
	public UserSerivce2 createUserSerivce2 () {
		return new UserSerivce2();
	}
	
	
	public UserSerivce createUserSerivce () {
		return new UserSerivce();
	}

}
