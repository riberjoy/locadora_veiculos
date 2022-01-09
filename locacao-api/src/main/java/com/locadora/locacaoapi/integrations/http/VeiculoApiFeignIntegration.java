package com.locadora.locacaoapi.integrations.http;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.locadora.locacaoapi.integrations.http.resorces.VeiculoResource;
import com.locadora.locacaoapi.models.Veiculo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "veiculo", url = "${integration.veiculo.url}")
public interface VeiculoApiFeignIntegration {

    @GetMapping(path = "/veiculo/{veiculoCode}", produces = APPLICATION_JSON_VALUE)
    Veiculo send(@PathVariable("veiculoCode") final String veiculoCode);
}
