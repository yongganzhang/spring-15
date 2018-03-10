package com.shsxt.bean;

public class User {
	
	private int id;
	
	// 用户名称
	private String userName;
	
	// 用户密码
	private Double userBalance;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Double getUserBalance() {
		return userBalance;
	}

	public void setUserBalance(Double userBalance) {
		this.userBalance = userBalance;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userBalance=" + userBalance + "]";
	}

}
