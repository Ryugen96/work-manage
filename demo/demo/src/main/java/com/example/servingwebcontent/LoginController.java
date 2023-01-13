package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@GetMapping("/")
	public String greeting(@RequestParam(name="username", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("username", name);
		return "login";
	}

}