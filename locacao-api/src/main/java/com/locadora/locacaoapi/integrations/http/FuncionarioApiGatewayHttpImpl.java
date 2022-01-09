package com.locadora.locacaoapi.integrations.http;

import com.locadora.locacaoapi.integrations.FuncionarioApiGateway;
import com.locadora.locacaoapi.integrations.http.resorces.FuncionarioResource;
import com.locadora.locacaoapi.models.Funcionario;
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
public class FuncionarioApiGatewayHttpImpl implements FuncionarioApiGateway {

    private final FuncionarioApiFeignIntegration funcionarioApiFeignIntegration;

    @Override
    public Funcionario send(final @NotNull String funcionarioCode) {
        return funcionarioApiFeignIntegration.send(funcionarioCode);
    }
}
