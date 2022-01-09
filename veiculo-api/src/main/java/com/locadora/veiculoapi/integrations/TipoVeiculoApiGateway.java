package com.locadora.veiculoapi.integrations;

import com.locadora.veiculoapi.models.TipoVeiculo;
import javax.validation.constraints.NotNull;

public interface TipoVeiculoApiGateway {

  TipoVeiculo send(@NotNull String tipoVeiculo);

}
