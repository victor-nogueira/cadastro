package com.cadastro.service;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro.model.Usuario;
import com.cadastro.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository ur;
	
	
	public List<Usuario> getAllUser() {
		return ur.findAll();
	}
	
}
