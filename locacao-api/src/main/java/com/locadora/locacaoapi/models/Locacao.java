package com.locadora.locacaoapi.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Document("Locacao")
@NoArgsConstructor
@AllArgsConstructor
public class Locacao {
    @Id
    private String id;
    @NotNull
    private String funcionarioCode;
    @NotNull
    private String clienteCode;
    @NotNull
    private String veiculoCode;
    @NotNull
    private Date data_saida;
    @NotNull
    private Date data_chegada;
    @NotNull
    private String odometro_saida;

    private String odometro_chegada;
    @NotNull
    private String combustivel_saida;

    private String combustivel_chegada;
    @NotNull
    private Integer tempo_locacao; // Em dias
    @NotNull
    private Double total;
}
