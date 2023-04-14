package com.kvs.dao;

import java.util.List;

import com.kvs.entity.Category;

public interface CategoryDAO {
	
	public List<Category> getCategories();
	
	Category getCategory(int theId);

	void saveCategory(Category theCategory);

	void deleteCategory(int theId);

	Category getCategorybyName(String categoryName);

}
