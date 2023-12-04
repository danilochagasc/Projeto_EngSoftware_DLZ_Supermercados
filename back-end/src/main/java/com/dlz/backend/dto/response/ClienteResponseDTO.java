package com.dlz.backend.dto.response;

import com.dlz.backend.model.Cliente.Cliente;
import com.dlz.backend.model.Cliente.ClientePermissao;

import java.util.UUID;

public record ClienteResponseDTO(
    UUID idCliente,
    String nome,
    String email,
    String senha,
    String telefone,
    String endereco,
    ClientePermissao permissao
) {

    public ClienteResponseDTO(Cliente cliente){
        this(cliente.getIdCliente(), cliente.getNome(), cliente.getEmail(), cliente.getSenha(), cliente.getTelefone(), cliente.getEndereco(), cliente.getPermissao());
    }
}
