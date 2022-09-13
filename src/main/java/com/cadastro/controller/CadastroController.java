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

import com.cadastro.model.Usuario;
import com.cadastro.repository.UsuarioRepository;

@RestController
public class CadastroController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("listar")
	@ResponseBody 
	public ResponseEntity<List<Usuario>> listar() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	
	}
	
	@PostMapping("salvar")
	@ResponseBody
	public ResponseEntity<Usuario> salvar (@RequestBody Usuario usuario) {
		Usuario usuarios = usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(usuarios, HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("deletar")
	@ResponseBody
	public ResponseEntity<String> deletar (@RequestParam Long idUser) {
		usuarioRepository.deleteById(idUser); 
		return new ResponseEntity<String>("Usuário deletado com sucesso", HttpStatus.NO_CONTENT);
		
	}
	
	@GetMapping("buscar")
	@ResponseBody
	public ResponseEntity<Usuario> buscarPeloId (@RequestParam(name = "idUser") Long idUser) {
		Usuario usuario = usuarioRepository.findById(idUser).get(); 
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		
	}

	@PutMapping("atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar (@RequestBody Usuario usuario) {
		if (usuario.getId() == null) {
			return new ResponseEntity<String>("id não informado para atualização", HttpStatus.OK); 
		}
		
		Usuario usuarios = usuarioRepository.saveAndFlush(usuario);
		return new ResponseEntity<Usuario>(usuarios, HttpStatus.OK); 
		
	}
	
	@GetMapping("buscarPorNome")
	@ResponseBody
	public ResponseEntity<List<Usuario>> buscarPorNome (@RequestParam(name = "nome") String nome) {
		List<Usuario> usuario = usuarioRepository.buscarPorNome(nome.trim().toUpperCase()); 
		return new ResponseEntity<List<Usuario>>(usuario, HttpStatus.OK);
		
	}
	
}
