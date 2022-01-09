package com.locadora.locacaoapi.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Funcionario")
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {
    @Id
    private String id;
}
