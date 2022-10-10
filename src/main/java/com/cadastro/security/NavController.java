package com.cadastro.security;

import org.springframework.web.bind.annotation.RequestMapping;

public class NavController {
	
	@RequestMapping("/")
	public String index () {
		return "index";
	}
	
	@RequestMapping("/auth")
	public String auth () {
		return "auth";
	}
	
}
