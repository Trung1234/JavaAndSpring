package com.trungnt.manger;

import com.trungnt.model.Student;

import java.util.Comparator;

/**
 * Created by My PC on 05/11/2017.
 */
public class StudentManager {

	Student[] students = new Student[5];
	public  void iniT(){
		students[0] = new Student("trung",1,5);
		students[1] = new Student("tung",2,4);
		students[2] = new Student("hung",3,7);
		students[3] = new Student("thanh",4,8);
		students[4] = new Student("thang",6,9);
	}
	public void printList(){
		System.out.println("Thong tinh sinh vien  la : ");
		for(int i = 0; i < 5; i ++){
			System.out.println("Thong tin cua sinh vien la : "+ students[i].toString());
		}
	}
	public void finStudentByScore(int score){
		System.out.println("Tim diem cua sinh vien: ");
		for(int i=0;i<5;i++){
			if(score==students[i].getScore()){
				System.out.println("Sinh vien co diem can tim la : " +students[i].getName());
			}
			else {
				System.out.println(" Null ");
			}
		}
	}
}
