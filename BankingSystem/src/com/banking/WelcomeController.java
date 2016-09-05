package com.banking;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
	@RequestMapping("/")
	public String frontpage(){
		return "index";
	}
	@RequestMapping("/about")
	public String about(){
		return "about";
	}
}
