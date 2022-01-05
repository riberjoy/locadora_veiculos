package com.locadora.clienteapi.repositorys;

import com.locadora.clienteapi.models.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String>  {

}
