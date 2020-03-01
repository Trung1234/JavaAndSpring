package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.models.Course;

@Component
public class CourseDao {
	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}
	
	public Course getCourseById(int id) {
		Course st = null;
		try {
			st = courseRepository.findById(id).get();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return st;
	}
}
