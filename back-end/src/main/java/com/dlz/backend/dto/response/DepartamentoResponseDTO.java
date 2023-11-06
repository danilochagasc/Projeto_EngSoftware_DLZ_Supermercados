package com.dlz.backend.dto.response;


import com.dlz.backend.model.Departamento;
import lombok.Getter;

@Getter
public class DepartamentoResponseDTO {

    private String nome;

    public DepartamentoResponseDTO(Departamento departamento){
        this.nome = departamento.getNome();
    }
}
