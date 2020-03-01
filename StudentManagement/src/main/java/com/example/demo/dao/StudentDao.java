package com.example.demo.dao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.models.Course;
import com.example.demo.models.Student;





@Component
public class StudentDao {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CourseDao couDao;

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
	
	public void addStudent(Student student, String[] course) {

		Set<Course> stCourse =  new HashSet<>();
		for(String c : course) {
			Course cou = couDao.getCourseById(Integer.parseInt(c));
			cou.getStudents().add(student);
			stCourse.add(cou);
		}
		student.setCourses(stCourse);
		studentRepository.save(student);
	}
	public void deleteStudentById(int id) {
		Student student = studentRepository.findById(id).get();
		studentRepository.delete(student);
	}

}
