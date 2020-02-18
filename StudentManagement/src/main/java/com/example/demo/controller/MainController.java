package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Student;


@Controller
public class MainController {
	private static List<Student> students = new ArrayList<Student>();
	 
    static {
        students.add(new Student(1, "Gates",10,"10A"));
        students.add(new Student(2, "Jobs",8,"10A"));
        students.add(new Student(3, "Jobs",7,"10A"));
    }
 
    @RequestMapping(value = { "/studentList" }, method = RequestMethod.GET)
    public String studentList(Model model) {
 
        model.addAttribute("students", students);
 
        return "studentList";
    }
//    @RequestMapping(value = { "/index" }, method = RequestMethod.GET)
//    public String index(Model model) {
// 
//        model.addAttribute("students", students);
// 
//        return "index";
//    }
}
