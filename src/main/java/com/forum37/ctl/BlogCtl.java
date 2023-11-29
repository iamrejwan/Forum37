package com.forum37.ctl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.forum37.dto.BlogsDTO;
import com.forum37.dto.CategoryDTO;
import com.forum37.exception.RecordNotFoundException;
import com.forum37.form.BlogForm;
import com.forum37.service.BlogService;
import com.forum37.service.CategoryService;

@Controller
public class BlogCtl {
	
	@Autowired
	public BlogService service;
	
	@Autowired
	public CategoryService catService;
	
	@GetMapping("/blog")
	public String newsPage(@ModelAttribute("form")BlogForm form, Model model) {
		List<CategoryDTO> list = catService.list();
		model.addAttribute("cList", list);
		return "blog";
	}

	@PostMapping("/addBlog")
	public String Add(@RequestParam(value = "image") MultipartFile image, @Valid @ModelAttribute("form")BlogForm form,  BindingResult bindingResult, Model model) {

		System.out.println("form: "+form);
		try {
		if (bindingResult.hasErrors()) {
			System.out.println("bindingResult : "+bindingResult);
			return "blog";
		}else {
			BlogsDTO bean = form.getDTO();
			bean.setImage(image.getBytes());
			if(form.getId()>0) {			
				service.update(bean);
				model.addAttribute("success", "Blog Updated successfully");
			}else {
				service.Add(bean);
				model.addAttribute("success", "Blog successfully");
			}
			
			return "blog";
		}}catch (RecordNotFoundException e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
			e.printStackTrace();
			return "blog";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "blog";
	}
	
	@GetMapping("/blogList")
	public String list(@ModelAttribute("form")BlogForm form, Model model){
	List<BlogsDTO> list = service.list();
	model.addAttribute("list", list);
	return "bloglist";
		
	}
	
	@GetMapping("/viewBlog")
	public String newsById(@ModelAttribute("form")BlogForm form, @RequestParam("id") long id, Model model){
	BlogsDTO news = service.findNewsById(id);
	model.addAttribute("blog", news);
	return "viewblog";
		
	}
	
	@GetMapping("/blogEdit")	
	public String update(@ModelAttribute("form")BlogForm form, Model model, @RequestParam("id") long id ){
		BlogsDTO bean = service.findNewsById(id);
		form.populate(bean);
		List<CategoryDTO> list = catService.list();
		model.addAttribute("cList", list);
		model.addAttribute("bean",bean);	
		return "blog";
	}
	
	@GetMapping("/blogDelete")	
	public String delete(@ModelAttribute("form")BlogForm form, Model model, @RequestParam("id") long id ) throws Exception{
		service.delete(id);	
		
		List<BlogsDTO> list =	service.list();
		model.addAttribute("list", list);
		model.addAttribute("success", "Category Deleted successfully");
		return "bloglist";
	}
	
	@GetMapping("/getImage/{id}")
	public void getNewsImage(HttpServletResponse response, @PathVariable("id") long id) throws Exception {
		response.setContentType("image/jpeg");

		Blob blb=service.getImageById(id);
		
		byte[] bytes = blb.getBytes(1, (int) blb.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	}

}
