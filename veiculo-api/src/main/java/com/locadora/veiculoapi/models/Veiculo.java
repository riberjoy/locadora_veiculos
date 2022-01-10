package com.locadora.veiculoapi.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@Document("Veiculo")
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
    @Id
    private String id = null;

    @NotNull
    private String marca;

    @NotNull
    private String modelo;

    @NotNull
    private String cor;

    @NotNull
    private String placa;

    @NotNull
    private Integer ano;

    @NotNull
    private String tipoVeiculoCode;

    @NotNull
    private Boolean enabled = true; // Ativo S/N

    private String enabledDescricao;

}
