package com.jbk.dao;

import com.jbk.entity.CategoryEntity;

public interface CategoryDao {
	
	public boolean addCategory(CategoryEntity categoryEntity);

	public CategoryEntity getCategoryById(long categoryId);
	
	public boolean updateCategory(CategoryEntity categoryEntity);
}
