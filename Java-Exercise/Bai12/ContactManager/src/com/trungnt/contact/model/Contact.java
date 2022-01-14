package com.trungnt.contact.model;

/**
 * Created by My PC on 11/11/2017.
 */
public class Contact {
	private String name;
	private String phoneNumber;
	
	public Contact(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public String getName() {
		return name;
	}
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public boolean equals(Object o) {
		if(o instanceof Contact){
			Contact contact = (Contact) o;
			return  this.phoneNumber.equals(contact.phoneNumber);
		}
		return super.equals(o);
	}
	
	@Override
	public String toString() {
		return
				"name='" + name + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				'}';
	}
}

