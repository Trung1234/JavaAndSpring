package com.example.demo.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import com.example.demo.utils.WebUtils;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired(required = true)
	ProductService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String adminPage(Model model, Principal principal) {
		
		User loginedUser = (User) ((Authentication) principal).getPrincipal();

		String userInfo = WebUtils.toString(loginedUser);
		model.addAttribute("userInfo", userInfo);
		
		return "adminPage";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addProduct(Model model) {
		Product product = new Product();
		product.setId(0L);
		model.addAttribute("product", product);
		return "add-product";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("product") Product product, 
			BindingResult bindingResult,
			@RequestParam("file") MultipartFile file
			, RedirectAttributes redirAttrs)
			throws RecordNotFoundException, IOException {
		if(!bindingResult.hasErrors()) 
		{
			String fileLocation = new File("src\\main\\resources\\static\\images").getAbsolutePath() + "\\"
					+ file.getOriginalFilename();
			try {
				FileOutputStream output = new FileOutputStream(fileLocation);
				output.write(file.getBytes());
				output.close();
				product.setImagePath("/images/"+file.getOriginalFilename());
				service.createOrUpdateProduct(product);
				redirAttrs.addFlashAttribute("success", "product has been created.");
			}catch(Exception ex)
			{
				redirAttrs.addFlashAttribute("error", "an error happened, please contact admin.");
			}	
		}else {
			return "add-product";
		}
		return "redirect:/admin/add";
	}
}
