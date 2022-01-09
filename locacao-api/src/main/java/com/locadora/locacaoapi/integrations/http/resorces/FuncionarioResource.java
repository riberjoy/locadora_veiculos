package com.locadora.locacaoapi.integrations.http.resorces;

import com.locadora.locacaoapi.models.Funcionario;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class FuncionarioResource implements Serializable {

    private static final long serialVersionUID = -4761851866573069963L;
    private String id;

    public FuncionarioResource(final Funcionario funcionario) {
        this.id = funcionario.getId();
    }
}
