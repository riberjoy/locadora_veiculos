package com.locadora.tipoveiculoapi.repositorys;

import com.locadora.tipoveiculoapi.models.TipoVeiculo;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.awt.print.Pageable;

public interface TipoVeiculoRepository extends MongoRepository<TipoVeiculo, String> {
    Page<TipoVeiculo> findAll(Pageable pageable);
}
