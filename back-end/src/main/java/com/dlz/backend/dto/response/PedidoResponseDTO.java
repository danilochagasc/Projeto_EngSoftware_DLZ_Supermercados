package com.dlz.backend.dto.response;

import com.dlz.backend.model.Pedido;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public record PedidoResponseDTO(

        UUID idPedido,

        UUID idCliente,

        LocalDateTime dataHora,

        List<ItemPedidoResponseDTO> produtosNoPedido
) {

    public PedidoResponseDTO(Pedido pedido){
        this(pedido.getIdPedido(),
                pedido.getCliente().getIdCliente(),
                pedido.getDataHora(),
                pedido.getProdutosNoPedido().stream().map(ItemPedidoResponseDTO::new).collect(Collectors.toList())
        );
    }
}
