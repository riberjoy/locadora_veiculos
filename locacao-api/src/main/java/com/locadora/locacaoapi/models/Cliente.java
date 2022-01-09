package com.locadora.locacaoapi.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Cliente")
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    private String id;
}
