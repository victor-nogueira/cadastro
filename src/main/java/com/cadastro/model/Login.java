package com.cadastro.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "seq_login", sequenceName = "seq_login", allocationSize = 1, initialValue = 1)
public class Login implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@NotNull
	private String login;
	
	@NotNull
	private String password;
}

