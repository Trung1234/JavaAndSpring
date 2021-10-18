package com.howtodoinjava.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.howtodoinjava.demo.model.EmployeeEntity;
import com.howtodoinjava.demo.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeMVCController {

	@Autowired
    EmployeeService service;
 
    
    @RequestMapping(value =  "/list")
	public String index(Model model) {
    	List<EmployeeEntity> employees = service.getAllEmployees(); 
		model.addAttribute("employees", employees);

		return "list-employees";
	}
}
