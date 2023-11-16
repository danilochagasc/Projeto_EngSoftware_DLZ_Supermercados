package com.dlz.backend.controller;

import com.dlz.backend.dto.request.ClienteRequestDTO;
import com.dlz.backend.dto.response.ClienteResponseDTO;
import com.dlz.backend.service.Cliente.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping("/porId/{id}")
    public ResponseEntity<ClienteResponseDTO> encontrarPorId(@PathVariable(value = "id") UUID id){
        return ResponseEntity.ok().body(clienteService.encontrarPorId(id));
    }

    @PostMapping("/registrar")
    public ResponseEntity<ClienteResponseDTO> registrar(@RequestBody ClienteRequestDTO clienteRequestDTO){
        return ResponseEntity.ok().body(clienteService.registrar(clienteRequestDTO));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ClienteResponseDTO> atualizar(@PathVariable(value = "id") UUID id, @RequestBody ClienteRequestDTO clienteRequestDTO){
        return ResponseEntity.ok().body(clienteService.atualizar(id, clienteRequestDTO));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable(value = "id") UUID id){
        return ResponseEntity.ok().body(clienteService.deletar(id));
    }
}
