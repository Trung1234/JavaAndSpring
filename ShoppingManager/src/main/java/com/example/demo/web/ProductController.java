package com.example.demo.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;




@Controller
@RequestMapping("/")
public class ProductController {

	@Autowired(required=true)
	ProductService service;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addProduct(Model model) {
		Product product = new Product();
		product.setId(0L);
		model.addAttribute("product", product);
		return "add-product";
	}


	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(Product product,
			@RequestParam("file") MultipartFile file) throws RecordNotFoundException, IOException {
		String fileLocation = new File("src\\main\\resources\\static\\uploads").getAbsolutePath() + "\\" + file.getName();
		FileOutputStream output = new FileOutputStream(fileLocation);
		output.write(file.getBytes());
		output.close();
		product.setImagePath(file.getName());
		service.createOrUpdateProduct(product);
		return "add-product";
	}
}