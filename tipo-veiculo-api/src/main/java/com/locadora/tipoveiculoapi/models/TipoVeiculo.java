package com.locadora.tipoveiculoapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
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

    @NotNull(message="{not.null}")
    private String nome;

    private Double preco;

    @NotNull
    private Boolean enabled = true; // Ativo S/N

    private String enabledDescricao;
}
