package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;




@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService service;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addProduct(Model model) {
		Product product = new Product();
		product.setId(0L);
		model.addAttribute("product", product);
		return "add-product";
	}


	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(Product user) throws RecordNotFoundException {
		service.createOrUpdateProduct(user);
		return "add-product";
	}
}