package com.forum37.ctl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.forum37.dto.CategoryDTO;
import com.forum37.dto.UserDTO;
import com.forum37.exception.RecordNotFoundException;
import com.forum37.form.CategoryForm;
import com.forum37.form.UserForm;
import com.forum37.service.CategoryService;


@Controller
public class CategoryCtl {
	
   @Autowired
   private CategoryService service;
	
	@GetMapping("/category")
	public String categoryPage(@ModelAttribute("form")CategoryForm form, Model model) {

		return "category";
	}
	
	@PostMapping("/addCat")
	public String Add(@Valid @ModelAttribute("form")CategoryForm form,  BindingResult bindingResult, Model model) {

		System.out.println("form: "+form);
		try {
		if (bindingResult.hasErrors()) {
			System.out.println("bindingResult : "+bindingResult);
			return "category";
		}else {
			CategoryDTO bean = form.getDTO();
			if(form.getId()>0) {			
				service.update(bean);
				model.addAttribute("success", "Category Updated successfully");
			}else {
				service.Add(bean);
				model.addAttribute("success", "Category successfully");
			}
			
			return "category";
		}}catch (RecordNotFoundException e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
			e.printStackTrace();
			return "category";
		}
	}
	
	@GetMapping("/catlist")
	public String list(@ModelAttribute("form")CategoryForm form, Model model){
	List<CategoryDTO> list = service.list();
	model.addAttribute("list", list);
	return "categorylist";
		
	}
	
	@GetMapping("/catEdit")	
	public String update(@ModelAttribute("form")CategoryForm form, Model model, @RequestParam("id") long id ){
		CategoryDTO bean = service.findCatNameById(id);
		form.populate(bean);
		model.addAttribute("bean",bean);	
		return "category";
	}
	
	@GetMapping("/catDelete")	
	public String delete(@ModelAttribute("form")CategoryForm form, Model model, @RequestParam("id") long id ) throws Exception{
		service.delete(id);	
		
		List<CategoryDTO> list =	service.list();
		model.addAttribute("list", list);
		model.addAttribute("success", "Category Deleted successfully");
		return "categorylist";
	}
}
