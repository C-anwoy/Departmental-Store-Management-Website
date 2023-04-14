package com.kvs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kvs.entity.Category;
import com.kvs.entity.Product;
import com.kvs.service.CategoryService;
import com.kvs.service.ProductService;

@Controller
public class CategoryController {
	
	//inject the customer dao
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;

	@RequestMapping("/")
	public String listCategories(Model theModel) {
		
		//get categories from service
		List<Category> theCategories = categoryService.getCategories();
		
		//add the categories to the model
		theModel.addAttribute("categories", theCategories);
		
		return "index";
		
	}
	
	@RequestMapping("/showProducts")
	public String listProducts(@RequestParam("categoryId") int categoryId,
								Model theModel){
		
		//get categories from dao
		List<Product> theProducts = productService.findProductByCatAndQty(categoryId);;
		
		//add the categories to the model
		theModel.addAttribute("products", theProducts);
		
		return "viewProductsHome";
		
	}
}
