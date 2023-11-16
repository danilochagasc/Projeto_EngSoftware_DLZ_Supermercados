package com.dlz.backend.controller;

import com.dlz.backend.dto.response.CarrinhoResponseDTO;
import com.dlz.backend.service.Carrinho.CarrinhoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    final CarrinhoService carrinhoService;
    @GetMapping(value = "/{idCliente}")
    public ResponseEntity<CarrinhoResponseDTO> encontrarPorId(@PathVariable(value = "idCliente") UUID idCliente){
        return ResponseEntity.ok(carrinhoService.encontrarPorId(idCliente));
    }

    @PutMapping(value = "/adicionar/{idCliente}/{idProduto}")
    public ResponseEntity<String> adicionarNoCarrinho(@PathVariable(value = "idCliente") UUID idCliente, @PathVariable(value = "idProduto") UUID idProduto){
        return ResponseEntity.ok(carrinhoService.adicionarNoCarrinho(idCliente, idProduto));
    }

    @PutMapping(value = "/remover/{idCliente}/{idProduto}")
    public ResponseEntity<String> removerDoCarrinho(@PathVariable(value = "idCliente") UUID idCliente, @PathVariable(value = "idProduto") UUID idProduto){
        return ResponseEntity.ok(carrinhoService.removerDoCarrinho(idCliente, idProduto));
    }
}
