package com.nac.qluser;

public class Account {
	private String userName, pass;

	public Account(String userName, String pass) {
		this.userName = userName;
		this.pass = pass;
	}

	public String getUserName() {
		return userName;
	}

	public String getPass() {
		return pass;
	}

	@Override
	public String toString() {
		return userName + "-" + pass;
	}
}
