package com.dlz.backend.dto.request;

import com.dlz.backend.model.Cliente.ClientePermissao;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ClienteRequestDTO {

    private String nome;

    private String email;

    private String senha;

    private String telefone;

    private String endereco;

    private ClientePermissao permissao;

}
