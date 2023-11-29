package com.forum37.form;

import javax.validation.constraints.NotEmpty;

import com.forum37.dto.BaseDTO;
import com.forum37.dto.BlogsDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogForm extends BaseDTO {

	
	@NotEmpty(message = "Title name is required")
	private String title;

	@NotEmpty(message = "Description name is required")
	private String description;
	
	@NotEmpty(message = "Category name is required")
	private String catName;
	
	public BlogsDTO getDTO() {
		BlogsDTO bean=new BlogsDTO();
		bean.setId(id);
		bean.setTitle(title);
		bean.setDescription(description);
		bean.setCatName(catName);
		return bean;
	}

	public void populate(BlogsDTO bean) {
		id = bean.getId();
		title = bean.getTitle();
		description = bean.getDescription();
		catName=bean.getCatName();


	}
}
