package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.models.Student;





@Component
public class StudentDao {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	public Student getStudentById(int id) {
		Student st = null;
		try {
			st = studentRepository.findById(id).get();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return st;
	}
	
	public void addStudent(Student student) {
		studentRepository.save(student);
	}
	public void deleteStudentById(int id) {
		Student student = studentRepository.findById(id).get();
		studentRepository.delete(student);
	}

}
