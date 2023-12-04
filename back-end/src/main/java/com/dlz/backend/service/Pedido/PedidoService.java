package com.dlz.backend.service.Pedido;

import com.dlz.backend.dto.response.PedidoResponseDTO;
import com.dlz.backend.model.Cliente.Cliente;

import java.util.List;
import java.util.UUID;

public interface PedidoService {

    List<PedidoResponseDTO> listarPedidos(UUID idCliente);
    PedidoResponseDTO cadastrarPedido(Cliente cliente);


}
