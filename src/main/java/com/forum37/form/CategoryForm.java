package com.forum37.form;

import javax.validation.constraints.NotEmpty;

import com.forum37.dto.BaseDTO;
import com.forum37.dto.CategoryDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryForm extends BaseDTO{

	@NotEmpty(message = "Category name is required")
	private String catName;
	
	
	public CategoryDTO getDTO() {
		CategoryDTO bean=new CategoryDTO();
		bean.setId(id);
		bean.setCatName(catName);
		return bean;
	}

	public void populate(CategoryDTO bean) {
		id = bean.getId();
		catName=bean.getCatName();


	}

}
