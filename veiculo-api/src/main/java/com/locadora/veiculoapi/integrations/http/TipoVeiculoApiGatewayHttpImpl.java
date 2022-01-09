package com.locadora.veiculoapi.integrations.http;

import com.locadora.veiculoapi.integrations.TipoVeiculoApiGateway;
import com.locadora.veiculoapi.integrations.http.resorces.TipoVeiculoResource;
import com.locadora.veiculoapi.models.TipoVeiculo;
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
public class TipoVeiculoApiGatewayHttpImpl implements TipoVeiculoApiGateway {

  private final TipoVeiculoApiFeignIntegration tipoveiculoApiFeignIntegration;

  @Override
  public TipoVeiculo send(final @NotNull String tipoVeiculoCode) {
//    TipoVeiculo tipoVeiculo;
//    try {
//      tipoVeiculo = tipoveiculoApiFeignIntegration.send(tipoVeiculoCode);
//    } catch (FeignException feignError){
//      log.error(feignError.g);
//      throw new ResponseStatusException(HttpStatus.valueOf(ex.ge), );
//    }
    return tipoveiculoApiFeignIntegration.send(tipoVeiculoCode);
  }
}
