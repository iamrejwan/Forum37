package com.forum37.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forum37.dto.BlogsDTO;

public interface BlogDAO extends JpaRepository<BlogsDTO, Long>{

	public BlogsDTO findById(long id);
	public BlogsDTO findByCatName(String catName);
}
