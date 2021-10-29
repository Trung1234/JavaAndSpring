package com.howtodoinjava.demo.web;

import java.util.Optional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.howtodoinjava.demo.exception.RecordNotFoundException;
import com.howtodoinjava.demo.model.EmployeeEntity;
import com.howtodoinjava.demo.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeMVCController {

	@Autowired
	EmployeeService service;

	@RequestMapping(value = "/list")
	public String index(Model model) {
		List<EmployeeEntity> employees = service.getAllEmployees();
		model.addAttribute("employees", employees);

		return "list-employees";
	}
	
	@RequestMapping(value = "/listEmployees", method = RequestMethod.GET)
    public String listEmployees(
      Model model, 
      @RequestParam("page") Optional<Integer> page, 
      @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        Page<EmployeeEntity> employees = service.findPaginated(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("employees", employees);

        int totalPages = employees.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "list-emplouees-paging.html";
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") Long id) throws RecordNotFoundException {
		EmployeeEntity entity = service.getEmployeeById(id);

		return new ResponseEntity<EmployeeEntity>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addUser(Model model) {
		EmployeeEntity employee = new EmployeeEntity();
		employee.setId(0L);
		model.addAttribute("employee", employee);
		return "add-edit-employee";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") Long id) throws RecordNotFoundException {
	    ModelAndView mav = new ModelAndView("edit-employee");
	    EmployeeEntity employee = service.getEmployeeById(id);
	    mav.addObject("employee", employee);	     
	    return mav;
	}
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(EmployeeEntity user) throws RecordNotFoundException {
		service.createOrUpdateEmployee(user);
		return "redirect:/employee/list";
	}

	@RequestMapping("/delete/{id}")
	public String deleteEmployeeById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deleteEmployeeById(id);
		return "redirect:/employee/list";
	}
}
