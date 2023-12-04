package com.dlz.backend.dto.response;

import com.dlz.backend.model.Departamento;

import java.util.UUID;

public record DepartamentoResponseDTO(UUID idDepartamento, String nome) {

    public DepartamentoResponseDTO(Departamento departamento){
        this(departamento.getIdDepartamento(), departamento.getNome());
    }
}
