package com.trungnt.main;

import com.trungnt.manger.StudentManager;
import com.trungnt.model.Student;

/**
 * Created by My PC on 05/11/2017.
 */
public class Main {
	public static void main(String[] args) {
		StudentManager studentManager = new StudentManager();
		studentManager.iniT();
		studentManager.printList();
		studentManager.finStudentByScore(9);
	}
}
