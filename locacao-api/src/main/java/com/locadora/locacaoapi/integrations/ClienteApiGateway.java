package com.locadora.locacaoapi.integrations;

import com.locadora.locacaoapi.models.Cliente;
import javax.validation.constraints.NotNull;

public interface ClienteApiGateway {

  Cliente send(@NotNull String clienteCode);

}
