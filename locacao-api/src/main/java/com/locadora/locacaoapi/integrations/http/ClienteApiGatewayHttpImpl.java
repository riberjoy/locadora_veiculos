package com.locadora.locacaoapi.integrations.http;

import com.locadora.locacaoapi.integrations.ClienteApiGateway;
import com.locadora.locacaoapi.integrations.http.resorces.FuncionarioResource;
import com.locadora.locacaoapi.models.Cliente;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotNull;

@Slf4j
@Component
@RequiredArgsConstructor
public class ClienteApiGatewayHttpImpl implements ClienteApiGateway {

    private final ClienteApiFeignIntegration clienteApiFeignIntegration;

    @Override
    public Cliente send(final @NotNull String clienteCode) {
        return clienteApiFeignIntegration.send(clienteCode);
    }
}
