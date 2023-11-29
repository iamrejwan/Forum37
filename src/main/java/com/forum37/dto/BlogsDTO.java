package com.forum37.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="blogs")
@Getter
@Setter
public class BlogsDTO extends BaseDTO{

	@Column(name = "title", length = 755)
	private String title;

	@Column(name = "description", length = 60000)
	private String description;
	
	@Column(name = "catName")
	private String catName;
	
	@Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] image;
	
	
}
