package com.locadora.locacaoapi.repositorys;

import com.locadora.locacaoapi.models.Locacao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocacaoRepository extends MongoRepository<Locacao, String> {
}
