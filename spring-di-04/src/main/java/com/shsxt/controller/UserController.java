package com.shsxt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.shsxt.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	public boolean userLogin(String userName, String userPwd) {
		return userService.userLogin(userName, userPwd);
	}

}
