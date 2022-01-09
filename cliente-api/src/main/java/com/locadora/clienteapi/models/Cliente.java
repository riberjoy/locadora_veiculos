package com.locadora.clienteapi.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("Cliente")
public class Cliente {

    @Id
    private String id;

    @NotNull
    private String nome;

    @NotNull
    private String cnh;

    @NotNull
    private String endereco;

    @NotNull
    private String telefone;

    @NotNull
    private Boolean enabled = true; // Ativo S/N
}
