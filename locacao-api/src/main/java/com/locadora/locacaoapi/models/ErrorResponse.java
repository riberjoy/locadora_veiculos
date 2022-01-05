package com.locadora.locacaoapi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private List<String> errors = new ArrayList<>();

    public void adicionarError(final String erro) {
        errors.add(erro);
    }
}
