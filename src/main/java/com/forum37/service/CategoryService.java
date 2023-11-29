package com.forum37.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forum37.dao.CategoryDAO;
import com.forum37.dto.CategoryDTO;
import com.forum37.exception.RecordNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	public CategoryDAO dao;
	
	public CategoryDTO Add(CategoryDTO dto) {
		CategoryDTO user = null;
	user = dao.findByCatName(dto.getCatName());
	System.out.println("Category........: "+user);
	if(user != null)
		throw new RecordNotFoundException("Category is already exists..");
	    System.out.println("dto Before Save: "+dto);
	    user = dao.save(dto);
       return  user;
	}
	
	public CategoryDTO findCatNameById(long id) {
		return dao.findById(id);
	}


	public List<CategoryDTO> list(){
		List<CategoryDTO> dto = dao.findAll();
		return dto;
	}
	
	public CategoryDTO update(CategoryDTO dto){
		CategoryDTO bean = dao.saveAndFlush(dto);
		return bean;
	}
	
	public void delete(long id) throws Exception {
		if(id>0)
		{
			dao.deleteById(id);
		}else {
			throw new Exception("Not a valid id");
		}
		
	}

}
