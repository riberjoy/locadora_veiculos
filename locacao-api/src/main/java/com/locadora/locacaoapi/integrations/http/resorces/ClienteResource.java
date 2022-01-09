package com.locadora.locacaoapi.integrations.http.resorces;

import com.locadora.locacaoapi.models.Cliente;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ClienteResource implements Serializable {

    private static final long serialVersionUID = -4761851866573069963L;
    private String id;

    public ClienteResource(final Cliente cliente) {
        this.id = cliente.getId();
    }
}
