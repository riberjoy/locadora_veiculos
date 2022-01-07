package com.locadora.veiculoapi.repositorys;

import com.locadora.veiculoapi.models.Veiculo;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.awt.print.Pageable;

public interface VeiculoRepository extends MongoRepository<Veiculo, String> {
    Page<Veiculo> findAll(Pageable pageable);
}
