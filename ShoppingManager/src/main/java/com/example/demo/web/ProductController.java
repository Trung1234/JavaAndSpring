package com.example.demo.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import java.util.List;

@Controller
@RequestMapping("/")
public class ProductController {

	@Autowired(required = true)
	ProductService service;

	@RequestMapping(value = "/index")
	public String index(Model model) {
		List<Product> products = service.getAllProduct();
		model.addAttribute("products", products);
		return "list-products";
	}

	// http://localhost:8080/list/1?sortField=name&sortDir=desc
	@GetMapping("/list/{pageNo}")
	public String index(@PathVariable(value = "pageNo") int pageNo,
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 8;
		Page<Product> page = service.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Product> products = page.getContent();
		model.addAttribute("currentPage", pageNo);
	    model.addAttribute("totalPages", page.getTotalPages());
	    model.addAttribute("totalItems", page.getTotalElements());
	    model.addAttribute("sortField", sortField);
	    model.addAttribute("sortDir", sortDir);
	    model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
	    model.addAttribute("products", products);
		return "list-products";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addProduct(Model model) {
		Product product = new Product();
		product.setId(0L);
		model.addAttribute("product", product);
		return "add-product";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(Product product, @RequestParam("file") MultipartFile file)
			throws RecordNotFoundException, IOException {
		String fileLocation = new File("src\\main\\resources\\static\\images").getAbsolutePath() + "\\"
				+ file.getOriginalFilename();
		FileOutputStream output = new FileOutputStream(fileLocation);
		output.write(file.getBytes());
		output.close();
		product.setImagePath(fileLocation);
		service.createOrUpdateProduct(product);
		return "add-product";
	}
}