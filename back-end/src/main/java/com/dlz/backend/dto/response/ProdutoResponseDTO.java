package com.dlz.backend.dto.response;

import com.dlz.backend.model.Produto;

import java.util.UUID;

public record ProdutoResponseDTO(
        UUID idProduto,
        String nome,
        int quantidade,
        int preco_em_centavos,
        String imagem,
        UUID idDepartamento) {

    public ProdutoResponseDTO(Produto produto) {
        this(produto.getIdProduto(),produto.getNome(), produto.getQuantidade(), produto.getPreco_em_centavos(), produto.getImagem(), produto.getDepartamento().getIdDepartamento());
    }
}
