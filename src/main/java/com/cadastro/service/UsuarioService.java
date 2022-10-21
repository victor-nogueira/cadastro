package com.cadastro.service;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.cadastro.model.Usuario;
import com.cadastro.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository ur;
	
	public ResponseEntity<Usuario> buscar(@RequestParam(name = "idUser")Long idUser) {
		Usuario usuario = ur.findById(idUser).get(); 
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }
     
}
