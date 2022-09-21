package com.cadastro.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.cadastro.model.Administrador;


import lombok.Getter;

@Getter
public class AuthUser extends User{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long userId;
	private String fullName;
	
	
	public AuthUser(Administrador administrador, Collection<? extends GrantedAuthority> authorities) {
		super(administrador.getNome(), administrador.getSenha(), authorities);
		
		this.userId = administrador.getId();
		this.fullName = administrador.getNome();

	}
	
}
