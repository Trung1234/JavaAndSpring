package com.trungnt.quanlyuser.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by My PC on 18/11/2017.
 */
public class Main {
	public static void main(String[] args) {
		File file = new File("txt.txt");
		try {
			FileInputStream input = new FileInputStream(file);
			byte buff[] = new byte[1024];
			int length = input.read(buff);
			String content = "";
			while (length>0){
				content += new String(buff, 0,length);
				length = input.read(buff);
			}
			input.close();
			
			System.out.println(content);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
