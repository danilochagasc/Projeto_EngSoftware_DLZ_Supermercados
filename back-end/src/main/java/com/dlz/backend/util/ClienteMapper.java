package com.dlz.backend.util;

import com.dlz.backend.dto.request.ClienteRequestDTO;
import com.dlz.backend.dto.response.ClienteResponseDTO;
import com.dlz.backend.model.Cliente.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    //transforma um ClienteRequestDTO em um Cliente(Entidade)
    public Cliente toCliente(ClienteRequestDTO clienteDTO){
        return Cliente.builder()
                .nome(clienteDTO.getNome())
                .email(clienteDTO.getEmail())
                .senha(clienteDTO.getSenha())
                .telefone(clienteDTO.getTelefone())
                .endereco(clienteDTO.getEndereco())
                .permissao(clienteDTO.getPermissao())
                .build();
    }

    //transforma um Cliente(Entidade) em um ClienteResponseDTO
    public ClienteResponseDTO toClienteDTO(Cliente cliente){
        return new ClienteResponseDTO(cliente);
    }

    //atualiza os dados de um Cliente(Entidade) com base em um ClienteRequestDTO
    public void atualizarDadosCliente(Cliente cliente, ClienteRequestDTO clienteDTO){
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setSenha(cliente.getSenha());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setEndereco(clienteDTO.getEndereco());
        cliente.setPermissao(clienteDTO.getPermissao());
    }
}
