package com.dlz.backend.dto.response;

import com.dlz.backend.model.Cupom;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public record CupomResponseDTO(
        UUID idCupom,

        String codigo,

        int valorDesconto,

        List<ClienteResponseDTO> clientesComCupom
) {

    public CupomResponseDTO(Cupom cupom){
        this(
                cupom.getIdCupom(),
                cupom.getCodigo(),
                cupom.getValorDesconto(),
                cupom.getClientesComCupom().stream().map(ClienteResponseDTO::new).collect(Collectors.toList())
        );
    }
}
