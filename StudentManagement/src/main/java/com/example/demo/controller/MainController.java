package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.CourseDao;
import com.example.demo.dao.StudentDao;
import com.example.demo.models.Course;
import com.example.demo.models.Student;

@Controller
public class MainController {
	private List<Student> students = new ArrayList<Student>();
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private CourseDao courseDao;

	@RequestMapping(value = { "/studentList" }, method = RequestMethod.GET)
	public String studentList(Model model, @RequestParam(required = false) String error) {
		students = studentDao.getAllStudents();
		model.addAttribute("students", students);
		if(error != null) {
			if(error != "0") {
				model.addAttribute("error", "Delete student successfully ");
			}else {
				model.addAttribute("error", "Some error happens ");
			}
		}
		return "students";
	}
	@RequestMapping(value = { "/updateStudent" }, method = RequestMethod.GET)
	public String updateStudent(@RequestParam("stid") int id,Model model) {
		Student student = studentDao.getStudentById(id);
		List<Course> courses = courseDao.getAllCourses();

		model.addAttribute("student",student);
		model.addAttribute("courses",courses);
		model.addAttribute("stcourses",student.getCourses());
		return "studentForm";
	}
	
	@RequestMapping(value = { "/viewStudent" }, method = RequestMethod.GET)
	public String viewStudent(@RequestParam("stid") int id,Model model) {
		Student student = studentDao.getStudentById(id);
		model.addAttribute("courseset",student.getCourses());
		return "studentDetail";
	}
	
	@RequestMapping(value = { "/createStudent" }, method = RequestMethod.GET)
	public String getStudent(Model model) {		
		List<Course> courses = courseDao.getAllCourses();
		model.addAttribute("student",new Student());
		model.addAttribute("courses",courses);
		return "studentForm";
	}
	
	@RequestMapping(value = { "/createStudent" }, method = RequestMethod.POST)
	public String createStudent(@ModelAttribute("student") Student st, String[] course,
							Model model) {
		try {
			studentDao.addStudent(st,course);
		}
		catch (Exception e) {
			int error =0;
			model.addAttribute("error", error);
		}
		return "redirect:/studentList";
	}
	@RequestMapping(value = { "/abc" }, method = RequestMethod.GET)
	public String abcd(Model model) {
		return "NewFile";
	}
	
	//deteteStudent?stid=10
	@RequestMapping(value = { "/deleteStudent" }, method = RequestMethod.GET)
	public String deleteStudent(@RequestParam("stid") int id, Model model) {
		int error = 0;//khong co loi
		try {
			studentDao.deleteStudentById(id);
		} catch (Exception e) {
			error = id;
		}
		return "redirect:/studentList?error=" + error;
	}
//    @RequestMapping(value = { "/index" }, method = RequestMethod.GET)
//    public String index(Model model) {
// 
//        model.addAttribute("students", students);
// 
//        return "index";
//    }
}
