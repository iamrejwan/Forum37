package com.forum37.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forum37.dto.BlogsDTO;
import com.forum37.dto.CategoryDTO;


public interface CategoryDAO extends JpaRepository<CategoryDTO, Long> {
	
	public CategoryDTO findById(long id);
	public CategoryDTO findByCatName(String catName);

}