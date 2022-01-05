package com.locadora.funcionarioapi.repositorys;

import com.locadora.funcionarioapi.models.Funcionario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {
}
