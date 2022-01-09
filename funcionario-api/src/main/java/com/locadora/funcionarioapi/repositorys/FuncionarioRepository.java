package com.locadora.funcionarioapi.repositorys;

import com.locadora.funcionarioapi.models.Funcionario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {
	
	Page<Funcionario> findAll(Pageable pageable);

	Optional<Funcionario> findById(String id);
    
}
