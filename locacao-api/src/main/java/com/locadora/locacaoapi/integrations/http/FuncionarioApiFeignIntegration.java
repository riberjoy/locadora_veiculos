package com.locadora.locacaoapi.integrations.http;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.locadora.locacaoapi.integrations.http.resorces.FuncionarioResource;
import com.locadora.locacaoapi.models.Funcionario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "funcionario", url = "${integration.funcionario.url}")
public interface FuncionarioApiFeignIntegration {

    @GetMapping(path = "/funcionario/{funcionarioCode}", produces = APPLICATION_JSON_VALUE)
    Funcionario send(@PathVariable("funcionarioCode") final String funcionarioCode);
}
