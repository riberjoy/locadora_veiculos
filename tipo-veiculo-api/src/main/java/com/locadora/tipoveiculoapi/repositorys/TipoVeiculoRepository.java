package com.locadora.tipoveiculoapi.repositorys;

import com.locadora.tipoveiculoapi.models.TipoVeiculo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoVeiculoRepository extends MongoRepository<TipoVeiculo, String> {
    Page<TipoVeiculo> findAll(Pageable pageable);

    Optional<TipoVeiculo> findByNome(String nome);
}
