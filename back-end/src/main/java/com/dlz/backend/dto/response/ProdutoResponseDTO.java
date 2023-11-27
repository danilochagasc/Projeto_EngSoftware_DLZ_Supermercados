package com.dlz.backend.dto.response;

import java.util.UUID;

public record ProdutoResponseDTO(
        UUID idProduto,
        String nome,
        int quantidade,
        int preco_em_centavos,
        String imagem,
        DepartamentoResponseDTO departamento) {
}
