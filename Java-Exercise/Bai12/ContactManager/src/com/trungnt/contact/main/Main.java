package com.trungnt.contact.main;

import com.trungnt.contact.manager.ContactManager;

import java.util.ArrayList;

/**
 * Created by My PC on 11/11/2017.
 */
public class Main {
	
	private static ArrayList<String> listDB=new ArrayList();
	public static void main (String[] args) throws java.lang.Exception
	{
		listDB.add("ToThang123");
		listDB.add("Thanh123");
		listDB.add("ToTien");
		listDB.add("Tan12");
		listDB.add("123Thang");
		listDB.add("12Thang3");
		find("Thang");
		// your code goes here
	}
	public static void find(String name){
		System.out.println("-------------------------");
		System.out.println("Kết quả tìm kiếm "+name+ " là");
		for(int j = 0;j<listDB.size();j++){
			
			String kiTuCHuoi = listDB.get(j);
			if(kiTuCHuoi.contains(name)){
				System.out.println(kiTuCHuoi);
			}
			
		}
	}
}
