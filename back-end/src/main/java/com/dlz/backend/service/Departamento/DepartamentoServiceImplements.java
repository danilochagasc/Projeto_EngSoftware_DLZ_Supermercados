package com.dlz.backend.service.Departamento;

import com.dlz.backend.dto.response.DepartamentoResponseDTO;
import com.dlz.backend.dto.request.DepartamentoRequestDTO;
import com.dlz.backend.model.Departamento;
import com.dlz.backend.repository.DepartamentoRepository;
import com.dlz.backend.util.DepartamentoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Primary
@RequiredArgsConstructor
public class DepartamentoServiceImplements implements DepartamentoService{

    final DepartamentoRepository departamentoRepository;
    final DepartamentoMapper departamentoMapper;


    @Override
    public DepartamentoResponseDTO encontrarPorId(UUID id) {

        //obtendo o departamento(entidade) por id
        Departamento departamento = retornarDepartamento(id);

        //retornando o departamento(entidade) em formato de DepartamentoResponseDTO
        return departamentoMapper.toDepartamentoDTO(departamento);
    }

    @Override
    public List<DepartamentoResponseDTO> listarTodos() {

        //retornando lista de departamentos em formato de DepartamentoResponseDTO
        return departamentoMapper.toDepartamentoListDTO(departamentoRepository.findAll());
    }

    @Override
    public DepartamentoResponseDTO registrar(DepartamentoRequestDTO departamentoDTO) {

        //transformando departamentoRequestDTO em departamento(entidade)
        Departamento departamento = departamentoMapper.toDepartamento(departamentoDTO);

        //salvando departamento(entidade)
        return departamentoMapper.toDepartamentoDTO(departamentoRepository.save(departamento));
    }

    @Override
    public DepartamentoResponseDTO atualizar(UUID id, DepartamentoRequestDTO departamentoRequestDTO) {

        //recuperando departamento(entidade) por id
        Departamento departamento = retornarDepartamento(id);

        //atualizando departamento(entidade) com base no departamentoRequestDTO
        departamentoMapper.atualizarDepartamento(departamento, departamentoRequestDTO);

        //salvando departamento(entidade) atualizado
        return departamentoMapper.toDepartamentoDTO(departamentoRepository.save(departamento));
    }

    @Override
    public String deletar(UUID id) {

        //deletando departamento por id
        departamentoRepository.deleteById(id);
        return "Departamento: " + id + " deletado com sucesso!";
    }

    //funcoes auxiliares
    private Departamento retornarDepartamento(UUID id){
        return departamentoRepository.findById(id).orElseThrow(()-> new RuntimeException("Departamento não encontrado"));
    }
}
