package com.locadora.veiculoapi.repositorys;

import com.locadora.veiculoapi.models.Veiculo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface VeiculoRepository extends MongoRepository<Veiculo, String> {
    Page<Veiculo> findAll(Pageable pageable);

    Page<Veiculo> findByEnabled(Boolean enabled, Pageable pageable);

    List<Veiculo> findByMarcaAndModeloAndCorAndPlacaAndAnoAndTipoVeiculoCode(
            String marca, String modelo, String cor,
            String placa, Integer ano, String tipoVeiculoCode);
}
