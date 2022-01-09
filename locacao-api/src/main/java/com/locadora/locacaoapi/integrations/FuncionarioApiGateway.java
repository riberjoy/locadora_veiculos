package com.locadora.locacaoapi.integrations;

import com.locadora.locacaoapi.models.Funcionario;
import javax.validation.constraints.NotNull;

public interface FuncionarioApiGateway {

    Funcionario send(@NotNull String funcionarioCode);

}
