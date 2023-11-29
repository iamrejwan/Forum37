package com.forum37.service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forum37.dao.BlogDAO;
import com.forum37.dto.BlogsDTO;


@Service
public class BlogService {
	
	@Autowired
	public BlogDAO dao;
	
	 
	
	public BlogsDTO Add(BlogsDTO dto) {
	    System.out.println("dto Before Save: "+dto);
	    BlogsDTO news =  dao.save(dto);
       return  news;
	}
	public List<BlogsDTO> list(){
		List<BlogsDTO> dto = dao.findAll();
		return dto;
	}	
	
	public BlogsDTO findNewsById(long id) {
		return dao.findById(id);
	}
	
	public BlogsDTO update(BlogsDTO dto){
		BlogsDTO bean = dao.saveAndFlush(dto);
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


	public Blob getImageById(long id) throws SerialException, SQLException {
	
		BlogsDTO news = dao.findById(id);
		byte[] blob = news.getImage();
		Blob bBlob = new SerialBlob(blob);
		return bBlob;
	}

}
