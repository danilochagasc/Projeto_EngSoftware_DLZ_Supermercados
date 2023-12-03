package com.dlz.backend.dto.response;

import com.dlz.backend.model.ItemPedido;

import java.util.UUID;

public record ItemPedidoResponseDTO(

        UUID idItemPedido,

        UUID idPedido,

        ProdutoResponseDTO produto,

        int quantidadeComprada,

        int precoVenda
) {

    public ItemPedidoResponseDTO(ItemPedido itemPedido){
        this(itemPedido.getIdItemPedido(),
                itemPedido.getPedido().getIdPedido(),
                new ProdutoResponseDTO(itemPedido.getProduto()),
                itemPedido.getQuantidade(),
                itemPedido.getPrecoVenda()
        );
    }
}
