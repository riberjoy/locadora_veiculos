package com.locadora.veiculoapi.repositorys;

import com.locadora.veiculoapi.models.Veiculo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VeiculoRpository extends MongoRepository<Veiculo, String> {
}
