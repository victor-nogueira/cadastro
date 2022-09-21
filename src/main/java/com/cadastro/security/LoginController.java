package com.cadastro.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@GetMapping("/login")
	public String login () {
		return "login";
	}
	
	@GetMapping("/")
	public String index () {
		return "index";
	}
	
	
}
