package com.locadora.locacaoapi.integrations.http.resorces;

import com.locadora.locacaoapi.models.Veiculo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class VeiculoResource implements Serializable {

    private static final long serialVersionUID = -4761851866573069963L;
    private String id;

    public VeiculoResource(final Veiculo veiculo) {
        this.id = veiculo.getId();
    }
}
