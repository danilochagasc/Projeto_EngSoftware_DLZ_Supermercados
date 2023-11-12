package com.dlz.backend.service.Carrinho;

import com.dlz.backend.dto.request.CarrinhoRequestDTO;
import com.dlz.backend.dto.request.ProdutoRequestDTO;
import com.dlz.backend.dto.response.CarrinhoResponseDTO;
import com.dlz.backend.model.Carrinho;

import java.util.List;
import java.util.UUID;

public interface CarrinhoService {

    CarrinhoResponseDTO encontrarPorId(UUID idCliente);

    Carrinho registrar(Carrinho carrinho);

    String adicionarNoCarrinho(UUID idCliente, UUID idProduto);

    String removerDoCarrinho(UUID idCliente, UUID idProduto);

    String deletar(UUID idCliente);


    Carrinho retornarCarrinho(UUID idCliente);
}
