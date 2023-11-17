package com.dlz.backend.controller;

import com.dlz.backend.dto.request.CompraRequestDTO;
import com.dlz.backend.model.Cliente.Cliente;
import com.dlz.backend.service.Compra.CompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/compra")
public class CompraController {

    private final CompraService compraService;

    @GetMapping()
    public ResponseEntity<?> encontrarPorId(){

        //obtem o cliente logado
        Cliente clienteLogado = (Cliente) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return ResponseEntity.ok(compraService.encontrarPorId(clienteLogado.getIdCliente()));
    }

    @PutMapping()
    public ResponseEntity<?> atualizar(@RequestBody CompraRequestDTO compraRequestDTO){

        //obtem o cliente logado
        Cliente clienteLogado = (Cliente) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return ResponseEntity.ok(compraService.atualizar(clienteLogado.getIdCliente(), compraRequestDTO));
    }
}
