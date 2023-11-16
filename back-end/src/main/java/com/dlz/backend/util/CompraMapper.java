package com.dlz.backend.util;

import com.dlz.backend.dto.request.CompraRequestDTO;
import com.dlz.backend.dto.response.CompraResponseDTO;
import com.dlz.backend.model.Compra;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CompraMapper {

    //transforma uma CompraRequestDTO em uma Compra(entidade)
    public Compra toCompra(CompraRequestDTO compraDTO){
        return Compra.builder()
                .valorTotal(compraDTO.getValorTotal())
                .build();
    }

    //transforma uma Compra(entidade) em uma CompraRequestDTO
    public CompraResponseDTO toCompraDTO(Compra compra){
        return new CompraResponseDTO(compra);
    }

    //atualiza os dados de uma Compra(entidade) com base em uma CompraRequestDTO
    public void atualizarCompra(Compra compra, CompraRequestDTO compraDTO){
        compra.setDataCompra(LocalDate.now());
        compra.setValorTotal(compraDTO.getValorTotal());
    }

}
