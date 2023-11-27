package com.dlz.backend.controller;

import com.dlz.backend.dto.response.DepartamentoResponseDTO;
import com.dlz.backend.dto.request.DepartamentoRequestDTO;
import com.dlz.backend.service.Departamento.DepartamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    @GetMapping(value = "/{id}")
    ResponseEntity<DepartamentoResponseDTO> encontrarPorId(@PathVariable(value = "id") UUID id){
        return ResponseEntity.ok().body(departamentoService.encontrarPorId(id));
    }

    @GetMapping()
    ResponseEntity<List<DepartamentoResponseDTO>> encontrarTodosDepartamentos(){
        return ResponseEntity.ok().body(departamentoService.listarTodos());
    }

    @PostMapping(value = "/registrar")
    public ResponseEntity<DepartamentoRequestDTO> registrarDepartamento(@RequestBody DepartamentoRequestDTO departamentoRequestDTO, UriComponentsBuilder uriBuilder){

        //cadastrando um departamento
        DepartamentoResponseDTO departamentoResponseDTO = departamentoService.registrar(departamentoRequestDTO);

        //uri criada para o novo departamento
        URI uri = uriBuilder.path("departamento/{id}").buildAndExpand(departamentoResponseDTO.getIdDepartamento()).toUri();

        //retornando o departamento cadastrado com status 201("created")
        return ResponseEntity.created(uri).body(departamentoRequestDTO);

    }

    @PutMapping(value = "/atualizar/{id}")
    public ResponseEntity<DepartamentoResponseDTO> atualizarDepartamento(@PathVariable(value = "id") UUID id, @RequestBody DepartamentoRequestDTO departamentoRequestDTO){
        return ResponseEntity.ok().body(departamentoService.atualizar(id, departamentoRequestDTO));
    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<String> deletarDepartamento(@PathVariable(name = "id") UUID id){
        return ResponseEntity.ok().body(departamentoService.deletar(id));
    }
}
