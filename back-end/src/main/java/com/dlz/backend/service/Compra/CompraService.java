package com.dlz.backend.service.Compra;

import com.dlz.backend.dto.request.CompraRequestDTO;
import com.dlz.backend.dto.response.CompraResponseDTO;
import com.dlz.backend.model.Carrinho;
import com.dlz.backend.model.Compra;

import java.util.UUID;

public interface CompraService {

    CompraResponseDTO encontrarPorId(UUID idCliente);

    Compra registrar(Carrinho carrinho);

    CompraResponseDTO atualizar(UUID idCliente, CompraRequestDTO compraRequestDTO);

    String deletar(UUID idCliente);

    Compra retornarCompra(UUID idCliente);
}
