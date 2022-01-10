package com.locadora.veiculoapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@Document("TipoVeiculo")
@NoArgsConstructor
@AllArgsConstructor
public class TipoVeiculo {

    @Id
    private String id;

    private String nome;

    private Double preco;

    private Boolean enabled;

    private String enabledDescricao;
}
