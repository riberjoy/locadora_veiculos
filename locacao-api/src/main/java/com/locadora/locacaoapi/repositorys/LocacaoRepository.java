package com.locadora.locacaoapi.repositorys;

import com.locadora.locacaoapi.models.Locacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LocacaoRepository extends MongoRepository<Locacao, String> {
    Page<Locacao> findAll(Pageable pageable);

    Optional<Locacao> findById(String id);
}
