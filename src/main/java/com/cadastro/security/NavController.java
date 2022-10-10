package com.cadastro.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavController {
	
	@GetMapping("/auth")
	public String auth () {
		return "auth";
	}
	
	@GetMapping("/")
	public String index () {
		return "index";
	}
	
	
	
}
