package com.locadora.clienteapi.repositorys;

import com.locadora.clienteapi.models.Cliente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ClienteRepository extends MongoRepository<Cliente, String>  {

	Page<Cliente> findAll(Pageable pageable);

	Optional<Cliente> findById(String id);
}
