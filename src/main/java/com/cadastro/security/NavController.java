package com.cadastro.security;

import org.springframework.web.bind.annotation.RequestMapping;

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
