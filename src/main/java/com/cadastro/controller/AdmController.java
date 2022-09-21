package com.cadastro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.model.Administrador;
import com.cadastro.model.Usuario;
import com.cadastro.repository.AdmRepository;
import com.cadastro.repository.UsuarioRepository;

@RestController
public class AdmController {
	
	@Autowired
	private AdmRepository admRepository;
	
	@GetMapping("listar")
	@ResponseBody 
	public ResponseEntity<List<Administrador>> listar() {
		List<Administrador> usuarios = admRepository.findAll();
		return new ResponseEntity<List<Administrador>>(usuarios, HttpStatus.OK);
	
	}
	
	@PostMapping("salvar")
	@ResponseBody
	public ResponseEntity<Administrador> salvar (@RequestBody Administrador administrador) {
		Administrador adm = admRepository.save(administrador);
		return new ResponseEntity<Administrador>(adm, HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("deletar")
	@ResponseBody
	public ResponseEntity<String> deletar (@RequestParam Long idUser) {
		admRepository.deleteById(idUser); 
		return new ResponseEntity<String>("Usuário deletado com sucesso", HttpStatus.NO_CONTENT);
		
	}
	
	@GetMapping("buscar")
	@ResponseBody
	public ResponseEntity<Administrador> buscarPeloId (@RequestParam(name = "idUser") Long idUser) {
		Administrador adm = admRepository.findById(idUser).get(); 
		return new ResponseEntity<Administrador>(adm, HttpStatus.OK);
		
	}

	@PutMapping("atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar (@RequestBody Administrador administrador) {
		if (administrador.getId() == null) {
			return new ResponseEntity<String>("id não informado para atualização", HttpStatus.OK); 
		}
		
		Administrador adm = admRepository.saveAndFlush(administrador);
		return new ResponseEntity<Administrador>(adm, HttpStatus.OK); 
		
	}
	

	
}
