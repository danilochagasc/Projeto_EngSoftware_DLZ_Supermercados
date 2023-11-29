package com.dlz.backend.service.Carrinho;

import com.dlz.backend.dto.request.CarrinhoRequestDTO;
import com.dlz.backend.dto.response.CarrinhoResponseDTO;
import com.dlz.backend.model.Carrinho;
import com.dlz.backend.model.Cliente.Cliente;

import java.util.List;
import java.util.UUID;

public interface CarrinhoService {

    List<CarrinhoResponseDTO> buscarCarrinhoPorIdCliente(UUID idCliente);

    CarrinhoResponseDTO inserirnoCarrinho(CarrinhoRequestDTO carrinhoRequestDTO, Cliente cliente);

    CarrinhoResponseDTO adicionarNoCarrinho(UUID idCliente, UUID idProduto);

    CarrinhoResponseDTO removerDoCarrinho(UUID idCliente, UUID idProduto);

    String inserirCupom(UUID idCliente, String codigo);

    String deletarItem(UUID idCliente, UUID idProduto);

    String deletarCarrinho(UUID idCliente);

    void limparCarrinho(UUID idCliente);

    List<Carrinho> retornarCarrinho(UUID idCliente);


}
