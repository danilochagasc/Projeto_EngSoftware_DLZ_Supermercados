package com.dlz.backend.dto.response;

import com.dlz.backend.model.Carrinho;
import com.dlz.backend.model.Departamento;
import com.dlz.backend.model.Produto;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class ProdutoResponseDTO {

    private UUID idProduto;

    private  String nome;

    private int quantidade;

    private int preco_em_centavos;

    private String imagem;

    private UUID idDepartamento;


    public ProdutoResponseDTO(Produto produto){
        this.idProduto = produto.getIdProduto();
        this.nome = produto.getNome();
        this.quantidade = produto.getQuantidade();
        this.preco_em_centavos = produto.getPreco_em_centavos();
        this.imagem = produto.getImagem();
        this.idDepartamento = produto.getDepartamento().getIdDepartamento();
    }
}
