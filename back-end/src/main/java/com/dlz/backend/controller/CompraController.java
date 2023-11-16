package com.dlz.backend.controller;

import com.dlz.backend.dto.request.CompraRequestDTO;
import com.dlz.backend.service.Compra.CompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/compra")
public class CompraController {

    private final CompraService compraService;

    @GetMapping("/{idCliente}")
    public ResponseEntity<?> encontrarPorId(@PathVariable(value = "idCliente") UUID idCliente){
        return ResponseEntity.ok(compraService.encontrarPorId(idCliente));
    }

    @PutMapping("/{idCliente}")
    public ResponseEntity<?> atualizar(@PathVariable(value = "idCliente") UUID idCliente, @RequestBody CompraRequestDTO compraRequestDTO){
        return ResponseEntity.ok(compraService.atualizar(idCliente, compraRequestDTO));
    }
}
