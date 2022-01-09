package com.locadora.locacaoapi.integrations.http;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.locadora.locacaoapi.integrations.http.resorces.ClienteResource;
import com.locadora.locacaoapi.models.Cliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "cliente", url = "${integration.cliente.url}")
public interface ClienteApiFeignIntegration {

    @GetMapping(path = "/cliente/{clienteCode}", produces = APPLICATION_JSON_VALUE)
    Cliente send(@PathVariable("clienteCode") final String clienteCode);
}
