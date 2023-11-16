package com.dlz.backend.dto.response;

import com.dlz.backend.model.Carrinho;
import com.dlz.backend.model.Cliente.Cliente;
import com.dlz.backend.model.Cliente.ClientePermissao;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ClienteResponseDTO {

    private UUID idCliente;

    private String nome;

    private String email;

    private String senha;

    private String telefone;

    private String endereco;

    private ClientePermissao permissao;

    private UUID idCarrinho;

    public ClienteResponseDTO(Cliente cliente){
        this.idCliente = cliente.getIdCliente();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.senha = cliente.getSenha();
        this.telefone = cliente.getTelefone();
        this.endereco = cliente.getEndereco();
        this.permissao = cliente.getPermissao();
        this.idCarrinho = cliente.getCarrinho().getIdCarrinho();
    }
}
