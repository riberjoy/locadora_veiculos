package com.locadora.veiculoapi.integrations.http.resorces;

import com.locadora.veiculoapi.models.TipoVeiculo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class TipoVeiculoResource implements Serializable {

    private static final long serialVersionUID = -4761851866573069963L;
    private String id;

    private String nome;

    private Double preco;

    public TipoVeiculoResource(final TipoVeiculo tipoVeiculo) {
        this.id = tipoVeiculo.getId();
        this.nome = tipoVeiculo.getNome();
        this.preco = tipoVeiculo.getPreco();
    }
}
