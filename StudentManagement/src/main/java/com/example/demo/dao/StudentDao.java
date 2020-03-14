package com.example.demo.dao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.models.Course;
import com.example.demo.models.Courseregist;
import com.example.demo.models.Student;





@Component
public class StudentDao {

	@Autowired
	private CourseregistRepository courseregistRepository;
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
		  
		  studentRepository.saveAndFlush(student);
		  if(student.getId()>0) {
			  List<Courseregist> studentCourseregist = courseregistRepository.findAll();
			  for(Courseregist studentCourse : studentCourseregist) {
				  int stId = studentCourse.getStudent().getId();
				  if(stId == student.getId()) {
					  courseregistRepository.delete(studentCourse); 
				  }				  
			  }
		  }
		  for(String c : course) 
		  {
			  Courseregist cr = new Courseregist();
			  Course cou =  couDao.getCourseById(Integer.parseInt(c)); 
		  
			  cr.setStudent(student);
			  cr.setCourse(cou);
			  courseregistRepository.save(cr);
		  } 
		  
		  
		  System.out.println("abc");
		   
	  }
	 

	public void deleteStudentById(int id) {
		Student student = studentRepository.findById(id).get();
		studentRepository.delete(student);
	}

}
