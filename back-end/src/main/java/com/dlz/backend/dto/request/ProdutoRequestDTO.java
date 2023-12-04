package com.dlz.backend.dto.request;


import com.dlz.backend.model.Departamento;


public record ProdutoRequestDTO(
        String nome,
        int quantidade,
        int preco_em_centavos,
        String imagem,
        Departamento departamento
) {
}
