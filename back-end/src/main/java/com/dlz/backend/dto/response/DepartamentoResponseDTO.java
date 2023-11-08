package com.dlz.backend.dto.response;

import com.dlz.backend.model.Departamento;
import lombok.Getter;

import java.util.UUID;
@Getter
public class DepartamentoResponseDTO {

    private UUID idDepartamento;

    private String nome;

    public DepartamentoResponseDTO(Departamento departamento){
        this.idDepartamento = departamento.getIdDepartamento();
        this.nome = departamento.getNome();
    }
}
