package com.dlz.backend.service.Departamento;

import com.dlz.backend.dto.request.DepartamentoRequestDTO;
import com.dlz.backend.dto.response.DepartamentoResponseDTO;
import com.dlz.backend.model.Departamento;
import com.dlz.backend.repository.DepartamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Primary
@RequiredArgsConstructor
public class DepartamentoServiceImplements implements DepartamentoService{

    final DepartamentoRepository departamentoRepository;
    @Override
    public DepartamentoResponseDTO encontrarPorId(UUID id) {

        //obtendo o departamento(entidade) pelo id
        Departamento departamento = retornarDepartamento(id);

        //retornando o departamento
        return new DepartamentoResponseDTO(departamento);
    }

    @Override
    public List<DepartamentoResponseDTO> listarTodos() {

        //obtendo todos os departamentos
        List<Departamento> departamentos = departamentoRepository.findAll();

        //retornando todos os departamentos
        return departamentos.stream().map(DepartamentoResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public DepartamentoResponseDTO registrar(DepartamentoRequestDTO departamentoRequestDTO) {

        //criando um novo departamento
        Departamento departamento = new Departamento(departamentoRequestDTO);

        //salvando o departamento
        departamentoRepository.save(departamento);

        //retornando o departamento salvo
        return new DepartamentoResponseDTO(departamento);
    }

    @Override
    public DepartamentoResponseDTO atualizar(UUID id, DepartamentoRequestDTO departamentoRequestDTO) {

        //obtendo o departamento(entidade) pelo id
        Departamento departamento = retornarDepartamento(id);

        //setando os novos valores
        departamento.setNome(departamentoRequestDTO.nome());

        //salvando o departamento
        departamentoRepository.save(departamento);

        //retornando o departamento atualizado
        return new DepartamentoResponseDTO(departamento);
    }

    @Override
    public String deletar(UUID id) {

        //obtendo o departamento(entidade) pelo id
        Departamento departamento = retornarDepartamento(id);

        //deletando o departamento
        departamentoRepository.delete(departamento);

        return "Departamento deletado com sucesso";
    }

    @Override
    public Departamento retornarDepartamento(UUID id) {
        return departamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Departamento não encontrado"));
    }
}
