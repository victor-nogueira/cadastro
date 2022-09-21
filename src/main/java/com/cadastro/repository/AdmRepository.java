package com.cadastro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cadastro.model.Administrador;
import com.cadastro.model.Usuario;

@Repository
public interface AdmRepository extends JpaRepository<Administrador, Long>{
	
	@Query(value = "select u from Administrador u where upper(trim(u.nome)) like %?1%")
	List<Administrador> buscarPorNome (String nome);
}
