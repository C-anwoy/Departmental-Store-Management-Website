package com.kvs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kvs.dao.CategoryDAO;
import com.kvs.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

		//need to inject category dao
		@Autowired
		private CategoryDAO categoryDAO; 

		@Override
		@Transactional
		public List<Category> getCategories() {
			return categoryDAO.getCategories();
		}

		
		@Override
		@Transactional
		public void saveCategory(Category theCategory) {

			categoryDAO.saveCategory(theCategory);

		}


		@Override
		@Transactional
		public Category getCategory(int theId) {
			
			Category theCategory=categoryDAO.getCategory(theId);
			
			return theCategory;
		}


		@Override
		@Transactional
		public void deleteCategory(int theId) {

			categoryDAO.deleteCategory(theId);
			
		}


		@Override
		@Transactional
		public Category getCategorybyName(String categoryName) {

			Category theCategory=categoryDAO.getCategorybyName(categoryName);
			
			return theCategory;
		}

}
