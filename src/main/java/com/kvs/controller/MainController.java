package com.kvs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kvs.entity.Category;
import com.kvs.service.CategoryService;

@Controller
public class MainController {
	
	@Autowired
	private CategoryService categoryService;

	/*@GetMapping("/")
	public String showIndex() {
		
		return "index";
	}*/
	
	@GetMapping("/home")
	public String showHome() {
		
		return "home";
	}
	
	@GetMapping("/login_home")
	public String showHome2(Model theModel) {
		
		//get categories from service
		List<Category> theCategories = categoryService.getCategories();
				
		//add the categories to the model
		theModel.addAttribute("categories", theCategories);
		
		return "login_home";
	}
	
	
	
}










