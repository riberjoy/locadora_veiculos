package com.locadora.veiculoapi.integrations.http;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.locadora.veiculoapi.integrations.http.resorces.TipoVeiculoResource;
import com.locadora.veiculoapi.models.TipoVeiculo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "tipoVeiculo", url = "${integration.tipoVeiculo.url}")
public interface TipoVeiculoApiFeignIntegration {

  @GetMapping(path = "/tipoVeiculo/{tipoVeiculoCode}", produces = APPLICATION_JSON_VALUE)
  TipoVeiculo send(@PathVariable("tipoVeiculoCode") final String tipoVeiculoCode);
}
