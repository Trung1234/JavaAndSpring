package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Student;

@Component
public class StudentDao {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public void deleteStudentById(int id) {
		Student student = studentRepository.findById(id).get();
		studentRepository.delete(student);
	}

}
