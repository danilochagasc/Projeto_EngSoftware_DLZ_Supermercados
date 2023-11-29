package com.dlz.backend.dto.request;

import com.dlz.backend.model.Produto;

public record CarrinhoRequestDTO(

        Produto produto,

        int quantidade
) {
}
