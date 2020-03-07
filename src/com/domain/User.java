package com.domain;

import com.util.md5;

public class User {
	
	private String userName;
	
	private String password;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String password) {
		md5 a = new md5();
		String mduname = a.MD5(userName);
		String mdpwd = a.MD5(userName);
		this.userName = mduname;
		this.password = mdpwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
