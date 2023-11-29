package com.dlz.backend.dto.request;

import com.dlz.backend.model.Cliente.ClientePermissao;

public record ClienteRequestDTO(
    String nome,
    String email,
    String senha,
    String telefone,
    String endereco,
    ClientePermissao permissao
) {
}
