package com.locadora.locacaoapi.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Veiculo")
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
    @Id
    private String id;
}
