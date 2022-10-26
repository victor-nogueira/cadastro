package com.cadastro.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.model.Usuario;
import com.cadastro.repository.UsuarioRepository;
import com.cadastro.service.GeradorPdfService;
import com.cadastro.service.UsuarioService;
import com.lowagie.text.DocumentException;

@RestController
public class CadastroController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService service;
	
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
	
	@GetMapping("/pdf-generate")
	public void gerarPdf(HttpServletResponse response, Long id) throws DocumentException, IOException {
		
		  response.setContentType("application/pdf");
		  DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
		  String currentDateTime = dateFormat.format(new Date());
		  String headerkey = "Content-Disposition";
		  String headervalue = "attachment; filename=pdf_"+currentDateTime+".pdf";
		  response.setHeader(headerkey, headervalue);
		  List<Usuario> usuarioList = service.getAllUser();
		  GeradorPdfService gerador = new GeradorPdfService();
		  gerador.setUsuarioList(usuarioList);
		  gerador.generate(response);
		 }
	
}
