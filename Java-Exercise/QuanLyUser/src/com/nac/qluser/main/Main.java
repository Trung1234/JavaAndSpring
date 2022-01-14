package com.nac.qluser.main;

import com.nac.qluser.Manager;
import com.nac.qluser.User;

public class Main {
	public static void main(String[] args) {
		Manager mgr = new Manager();

		User user = new User("Thanh", "123", "thanh", "abc");
		user.setListener(mgr);
		user.register();

		User user1 = new User("Nam", "456", "nam", "def");
		user1.setListener(mgr);
		user1.register();

		User user2 = new User("Hung", "124", "nam", "33");
		user2.setListener(mgr);
		user2.register();

		mgr.sortAndPrintUserByName();
		user2.login();
	}
}
