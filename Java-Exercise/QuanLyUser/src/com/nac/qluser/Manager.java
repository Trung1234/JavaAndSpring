package com.nac.qluser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.nac.qluser.User.UserListener;

public class Manager implements UserListener{
	private static final String FILE_PATH = "user.txt";
	private ArrayList<User> listUser;

	public Manager() {
		listUser = new ArrayList<>();
		initUserList();
	}

	private void initUserList() {
		try {
			File file = new File(FILE_PATH);
			if(!file.exists()) return;

			FileInputStream input = new FileInputStream(file);
			String text = "";
			int len;
			byte buff[] = new byte[1024];
			while ((len = input.read(buff)) > 0) {
				text += new String(buff, 0, len);
			}
			input.close();
			String line[] = text.split("\n");
			if (line == null)
				return;

			for (int i = 0; i < line.length; i++) {
				String content[] = line[i].split("-");
				String userName = content[0];
				String pass = content[1];
				String name = content[2];
				String phone = content[3];
				listUser.add(new User(name, phone, userName, pass));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<User> findUserByName(String name) {
		List<User> data = new ArrayList<>();
		for (int i = 0; i < listUser.size(); i++) {
			User user = listUser.get(i);
			if (user.getName().equalsIgnoreCase(name)) {
				data.add(user);
			}
		}
		return data;
	}

	public boolean deleteUserByUserName(String userName) {
		for (int i = 0; i < listUser.size(); i++) {
			if (listUser.get(i).getUserName().equalsIgnoreCase(userName)) {
				listUser.remove(i);	
				saveListUser();
				return true;
			}
		}
		return false;
	}

	public void sortAndPrintUserByName() {
		Collections.sort(listUser);
		System.out.println(listUser.toString());
	}

	@Override
	public boolean register(User user) {
		int index = listUser.indexOf(user);
		if(index > -1) return false;

		listUser.add(user);
		saveListUser();
		return true;
	}

	private void saveListUser() {
		try {
			File file = new File(FILE_PATH);
			file.delete();
			file.createNewFile();

			FileOutputStream output = new FileOutputStream(FILE_PATH);
			for (int i = 0; i < listUser.size(); i++) {
				User user = listUser.get(i);
				output.write(user.toString().getBytes());
			}
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean login(User user) {
		int index = listUser.indexOf(user);
		if(index == -1) return false;
		
		User userFound = listUser.get(index);
		return userFound.getPass().equals(user.getPass());
	}
}
