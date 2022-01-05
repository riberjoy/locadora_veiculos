package com.locadora.tipoveiculoapi.repositorys;

import com.locadora.tipoveiculoapi.models.TipoVeiculo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TipoVeiculoRepository extends MongoRepository<TipoVeiculo, String> {
}
