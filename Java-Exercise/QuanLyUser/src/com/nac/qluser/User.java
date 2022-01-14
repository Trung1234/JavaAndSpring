package com.nac.qluser;

public class User implements Comparable<User> {
	private String name, phone;
	private Account acc;
	private UserListener listener;

	public User(String name, String phone, String userName, String pass) {
		acc = new Account(userName, pass);
		this.name = name;
		this.phone = phone;

	}

	public void register() {
		boolean result = listener.register(this);
		if (result) {
			System.out.println("Register successfully!");
		} else {
			System.out.println("This account is existed!");
		}
	}

	public void login() {
		boolean result = listener.login(this);
		if (result) {
			System.out.println("Login successfully!");
		} else {
			System.out.println("User name or password is invalid!");
		}
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return acc.toString() + "-" + name + "-" + phone + "\n";
	}

	public void setListener(UserListener event) {
		this.listener = event;
	}

	public interface UserListener {
		boolean register(User user);

		boolean login(User user);
	}

	public String getUserName() {
		return acc.getUserName();
	}

	@Override
	public int compareTo(User user2) {
		return name.compareTo(user2.name);
	}

	@Override
	public boolean equals(Object user) {
		if (user instanceof User) {
			return this.acc.getUserName().equals(((User) user).getUserName());
		}
		return super.equals(acc);
	}

	public String getPass() {
		return acc.getPass();
	}
}
