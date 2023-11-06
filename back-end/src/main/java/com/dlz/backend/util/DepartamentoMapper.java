package com.dlz.backend.util;

import com.dlz.backend.dto.request.DepartamentoRequestDTO;
import com.dlz.backend.dto.response.DepartamentoResponseDTO;
import com.dlz.backend.model.Departamento;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DepartamentoMapper {

    //transforma um DepartamentoRequestDTO em um Departamento(entidade)
    public Departamento toDepartamento(DepartamentoRequestDTO departamentoDTO){
        return Departamento.builder()
                .nome(departamentoDTO.getNome())
                .build();
    }

    //transforma um Departamento(entidade) em um DepartamentoResponseDTO
    public DepartamentoResponseDTO toDepartamentoDTO(Departamento departamento){
        return new DepartamentoResponseDTO(departamento);
    }

    //transforma uma lista de Departamento(entidade) em uma lista de DepartamentoResponseDTO
    public List<DepartamentoResponseDTO> toDepartamentoListDTO(List<Departamento> departamentos){
        return departamentos.stream().map(DepartamentoResponseDTO::new).collect(Collectors.toList());
    }

    //atualiza os dados de um Departamento(entidade) com base em um DepartamentoRequestDTO
    public void atualizarDepartamento(Departamento departamento, DepartamentoRequestDTO departamentoDTO){
        departamento.setNome(departamentoDTO.getNome());
    }
}
