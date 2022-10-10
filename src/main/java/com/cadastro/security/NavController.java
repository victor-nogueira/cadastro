package com.cadastro.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavController {
	
	@RequestMapping("/auth")
	public String auth () {
		return "auth";
	}
	
	@RequestMapping("/")
	public String index () {
		return "index";
	}
	
	
	
}
