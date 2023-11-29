package com.forum37.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="category")
@Getter
@Setter
public class CategoryDTO extends BaseDTO{
	
	@Column(name = "catName", length = 755)
	private String catName;


}
