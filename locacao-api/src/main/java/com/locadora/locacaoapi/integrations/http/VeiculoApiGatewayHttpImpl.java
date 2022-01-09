package com.locadora.locacaoapi.integrations.http;

import com.locadora.locacaoapi.integrations.VeiculoApiGateway;
import com.locadora.locacaoapi.integrations.http.resorces.VeiculoResource;
import com.locadora.locacaoapi.models.Veiculo;
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
public class VeiculoApiGatewayHttpImpl implements VeiculoApiGateway {

    private final VeiculoApiFeignIntegration veiculoApiFeignIntegration;

    @Override
    public Veiculo send(final @NotNull String veiculoCode) {
        return veiculoApiFeignIntegration.send(veiculoCode);
    }
}
