package com.dlz.backend.util;

import com.dlz.backend.dto.request.CarrinhoRequestDTO;
import com.dlz.backend.dto.response.CarrinhoResponseDTO;
import com.dlz.backend.model.Carrinho;
import org.springframework.stereotype.Component;

@Component
public class CarrinhoMapper {

    //transforma um CarrinhoRequestDTO em um Carrinho(entidade)
    public Carrinho toCarrinho(CarrinhoRequestDTO CarrinhoRequestDTO){
        return Carrinho.builder()
                .cliente(CarrinhoRequestDTO.getCliente())
                .compra(CarrinhoRequestDTO.getCompra())
                .produtos(CarrinhoRequestDTO.getProdutos())
                .build();
    }

    //transforma um Carrinho(entidade) em um CarrinhoResponseDTO
    public CarrinhoResponseDTO toCarrinhoDTO(Carrinho Carrinho){
        return new CarrinhoResponseDTO(Carrinho);
    }

    //atualiza os dados de um Carrinho(entidade) com base em um CarrinhoRequestDTO
    public void atualizarCarrinho(Carrinho carrinho, CarrinhoRequestDTO carrinhoRequestDTO){
        carrinho.setCliente(carrinhoRequestDTO.getCliente());
        carrinho.setCompra(carrinhoRequestDTO.getCompra());
        carrinho.setProdutos(carrinhoRequestDTO.getProdutos());
    }
}
