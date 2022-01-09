package com.locadora.locacaoapi.integrations;

import com.locadora.locacaoapi.models.Veiculo;
import javax.validation.constraints.NotNull;

public interface VeiculoApiGateway {

    Veiculo send(@NotNull String veiculoCode);
}
