package com.forum37.ctl;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.forum37.dto.BlogsDTO;
import com.forum37.form.BlogForm;
import com.forum37.service.BlogService;


@Controller
public class HomeCtl {
	
	@Autowired
	public BlogService service;
	
	
	@GetMapping("/")
	public String list(@ModelAttribute("form")BlogForm form, Model model){
	List<BlogsDTO> list = service.list();
	model.addAttribute("list", list);
	return "bloglist";
		
	}
	
	@GetMapping("/home")
	public String home(@ModelAttribute("form")BlogForm form, Model model) {
		List<BlogsDTO> list = service.list();
		model.addAttribute("list", list);
		return "bloglist";
	}

}
