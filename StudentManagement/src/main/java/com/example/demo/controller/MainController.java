package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;

@Controller
public class MainController {
	private List<Student> students = new ArrayList<Student>();
	@Autowired
	private StudentDao studentDao;
//    static {
//        students.add(new Student(1, "Gates",10,"10A"));
//        students.add(new Student(2, "Jobs",8,"10A"));
//        students.add(new Student(3, "Jobs",7,"10A"));
//    }

	@RequestMapping(value = { "/studentList" }, method = RequestMethod.GET)
	public String studentList(Model model, @RequestParam(required = false) String error) {
		students = studentDao.getAllStudents();
		model.addAttribute("students", students);
		if(error != null) {
			model.addAttribute("error", "Fail to delete student id: " + error);
		}
		return "students";
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
