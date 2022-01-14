package com.trungnt.contact.manager;

import com.trungnt.contact.model.Contact;

import java.util.ArrayList;

/**
 * Created by My PC on 11/11/2017.
 */
public class ContactManager {
	private ArrayList<Contact> listDB;
	
	public ContactManager() {
		listDB = new ArrayList<>();
	}
	public boolean checkExist(String soDT){
		for (int i=0;i<listDB.size();i++){
			if(listDB.get(i).getPhoneNumber()==soDT){
				return true;
			}
			
	}
		return false;
}
	public void addContact(String name,String phoneNumber){
		Contact contact = new Contact(name,phoneNumber);
		if(!listDB.contains(contact)){
			listDB.add(contact);
			System.out.println("Đã thêm  " +contact.getName()+" thành công");
		}
	}
	public void modifyContact(String gtriSDT,String SDTMoi){
		for (int i=0;i<listDB.size();i++) {
			if (listDB.get(i).getPhoneNumber().equals(gtriSDT)) {
				listDB.get(i).setPhoneNumber(SDTMoi);
			}
			
		}
	}
	public void printAllContact(){
		System.out.println("-------------------------");
		System.out.println("Ta có danh bạ là");
		for(int i=0;i<listDB.size();i++){
			System.out.println(listDB.get(i).toString());
		}
		
	}
	public void find(String name){
		System.out.println("-------------------------");
		System.out.println("Kết quả tìm kiếm "+name+ " là");
		for(int j = 0;j<listDB.size();j++){
			String kiTuCHuoi = listDB.get(j).getName();
			if(kiTuCHuoi.contains(name)){
				System.out.println(kiTuCHuoi);
			}
			
		}
	}
//	public int  checkName(String chuoitim,String name){
//		int index = -1;
//		for(int i=0;i<name.length();i++){
//			char cha = name.charAt(i);
//			if(index == chuoitim.indexOf(cha,index+1)){
//				return true;
//			}
//			if(index==-1){
//				break;
//			}
//
//		}
//		return index>=0;
//	}
	
}
