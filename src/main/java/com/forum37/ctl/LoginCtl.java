package com.forum37.ctl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.forum37.dto.BlogsDTO;
import com.forum37.dto.UserDTO;
import com.forum37.form.BlogForm;
import com.forum37.service.BlogService;
import com.forum37.service.UserService;

@Controller
public class LoginCtl {
	
	@Autowired
	public UserService service;
	
	@Autowired
	public BlogService blog_service;
	
	
	@GetMapping("/loginView")
	public String LoginPage() {
		return "login";
	}
	
	@PostMapping("/auth")
	public String Login(@ModelAttribute("form") UserDTO dto, BlogForm form, Model model, HttpSession session) {
		
	UserDTO user =	service.Login(dto.getEmail(), dto.getPassword());
	if(user == null) {
		model.addAttribute("error", "Invalid UserName or Password");
		return "login";
	}else {
		session.setAttribute("user", user);
		List<BlogsDTO> list = blog_service.list();
		model.addAttribute("list", list);
		return "bloglist";
	}
	
		
	}

}
