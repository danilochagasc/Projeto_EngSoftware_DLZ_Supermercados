package com.dlz.backend.controller;

import com.dlz.backend.dto.response.CarrinhoResponseDTO;
import com.dlz.backend.model.Cliente.Cliente;
import com.dlz.backend.service.Carrinho.CarrinhoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    final CarrinhoService carrinhoService;
    @GetMapping()
    public ResponseEntity<CarrinhoResponseDTO> encontrarPorId(){

        //obtem o cliente logado
        Cliente clienteLogado = (Cliente) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return ResponseEntity.ok(carrinhoService.encontrarPorId(clienteLogado.getIdCliente()));
    }

    @PutMapping(value = "/adicionar/{idProduto}")
    public ResponseEntity<String> adicionarNoCarrinho(@PathVariable(value = "idProduto") UUID idProduto){

        //obtem o cliente logado
        Cliente clienteLogado = (Cliente) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return ResponseEntity.ok(carrinhoService.adicionarNoCarrinho(clienteLogado.getIdCliente(), idProduto));
    }

    @PutMapping(value = "/remover/{idProduto}")
    public ResponseEntity<String> removerDoCarrinho(@PathVariable(value = "idProduto") UUID idProduto){

        //obtem o cliente logado
        Cliente clienteLogado = (Cliente) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return ResponseEntity.ok(carrinhoService.removerDoCarrinho(clienteLogado.getIdCliente(), idProduto));
    }
}
