package com.example.demo.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import java.util.List;

@Controller
@RequestMapping("/")
public class ProductController {

	@Autowired(required = true)
	ProductService service;

	@RequestMapping("/search")
	public String search(
			 @Param("keyword") String keyword,
			Model model) {
			
		Page<Product> page = service.findPaginated(0, "id",keyword);
		List<Product> products = page.getContent();
		model.addAttribute("currentPage", 1);
	    model.addAttribute("totalPages", page.getTotalPages());;
	    model.addAttribute("sortField", "id");
	    model.addAttribute("products", products);
		return "list-products";
	}

	// http://localhost:8080/list/1?sortField=id
	@GetMapping("/list/{pageNo}")
	public String index(@PathVariable(value = "pageNo") int pageNo,
			@RequestParam("sortField") String sortField,
			Model model) {
			
		Page<Product> page = service.findPaginated(pageNo, sortField,null);
		List<Product> products = page.getContent();
		model.addAttribute("currentPage", pageNo);
	    model.addAttribute("totalPages", page.getTotalPages());;
	    model.addAttribute("sortField", sortField);
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