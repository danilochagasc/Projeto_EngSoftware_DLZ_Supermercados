package com.dlz.backend.dto.request;

import com.dlz.backend.model.Produto;

import java.util.UUID;

public record ProdutoRequestDTO(
        String nome,
        int quantidade,
        int preco_em_centavos,
        String imagem,
        UUID idDepartamento
) {

    public ProdutoRequestDTO(Produto produto) {
        this(produto.getNome(), produto.getQuantidade(), produto.getPreco_em_centavos(), produto.getImagem(), produto.getDepartamento().getIdDepartamento());
    }
}
