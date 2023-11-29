package com.dlz.backend.dto.response;

import com.dlz.backend.model.Carrinho;

import java.util.UUID;

public record CarrinhoResponseDTO(

        UUID idCarrinho,

        UUID idCliente,

        ProdutoResponseDTO produto,

        int quantidade,

        String cupomAplicado
) {
    public CarrinhoResponseDTO(Carrinho carrinho) {
        this(carrinho.getIdCarrinho(),
                carrinho.getCliente().getIdCliente(),
                new ProdutoResponseDTO(carrinho.getProduto()),
                carrinho.getQuantidade(),
                carrinho.getCupom() == null ? "Nenhum cupom aplicado" : carrinho.getCupom().getCodigo());
    }
}
