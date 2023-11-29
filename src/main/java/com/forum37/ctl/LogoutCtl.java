package com.forum37.ctl;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.forum37.dto.UserDTO;

@Controller
public class LogoutCtl {
	
	@GetMapping("/logout")
	public String logout(HttpSession session, Model model) {
		UserDTO user = (UserDTO) session.getAttribute("user");
		if(user != null) {
			session.invalidate();
			model.addAttribute("success", "Logout Sucessfully");
		}
		return "login";
	}
	
	

}
