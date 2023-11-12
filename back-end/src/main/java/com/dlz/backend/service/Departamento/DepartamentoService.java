package com.dlz.backend.service.Departamento;

import com.dlz.backend.dto.response.DepartamentoResponseDTO;
import com.dlz.backend.dto.request.DepartamentoRequestDTO;
import com.dlz.backend.model.Departamento;

import java.util.List;
import java.util.UUID;

public interface DepartamentoService {

    DepartamentoResponseDTO encontrarPorId(UUID id);

    List<DepartamentoResponseDTO> listarTodos();

    DepartamentoResponseDTO registrar(DepartamentoRequestDTO departamentoRequestDTO);

    DepartamentoResponseDTO atualizar(UUID id, DepartamentoRequestDTO departamentoRequestDTO);

    String deletar(UUID id);

    Departamento retornarDepartamento(UUID id);
}
