package com.locadora.funcionarioapi.models;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("Funcionario")
public class Funcionario {
	
	@Id
	private String id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String telefone;
	
	@NotNull
	private String rg;
	
	@NotNull
	private String cpf;
	
	@NotNull
	private Boolean enabled; // Ativo S/N
}
