package com.dlz.backend.controller;

import com.dlz.backend.dto.request.DepartamentoRequestDTO;
import com.dlz.backend.dto.response.DepartamentoResponseDTO;
import com.dlz.backend.service.Departamento.DepartamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    @GetMapping("/{idDepartamento}")
    public ResponseEntity<DepartamentoResponseDTO> encontrarPorId(@PathVariable UUID idDepartamento) {
        return ResponseEntity.ok().body(departamentoService.encontrarPorId(idDepartamento));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<DepartamentoResponseDTO>> encontrarTodos() {
        return ResponseEntity.ok().body(departamentoService.listarTodos());
    }

    @PostMapping("/registrar")
    public ResponseEntity<DepartamentoResponseDTO> registrar(@RequestBody DepartamentoRequestDTO departamentoRequestDTO) {
        return ResponseEntity.ok().body(departamentoService.registrar(departamentoRequestDTO));
    }

    @PutMapping("/atualizar/{idDepartamento}")
    public ResponseEntity<DepartamentoResponseDTO> atualizar(@PathVariable UUID idDepartamento, @RequestBody DepartamentoRequestDTO departamentoRequestDTO) {
        return ResponseEntity.ok().body(departamentoService.atualizar(idDepartamento, departamentoRequestDTO));
    }

    @DeleteMapping("/deletar/{idDepartamento}")
    public ResponseEntity<String> deletar(@PathVariable UUID idDepartamento) {
        return ResponseEntity.ok().body(departamentoService.deletar(idDepartamento));
    }
}
