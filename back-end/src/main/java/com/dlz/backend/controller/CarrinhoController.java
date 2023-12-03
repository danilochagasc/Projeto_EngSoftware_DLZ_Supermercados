package com.dlz.backend.controller;


import com.dlz.backend.dto.request.CarrinhoRequestDTO;
import com.dlz.backend.dto.response.CarrinhoResponseDTO;
import com.dlz.backend.model.Cliente.Cliente;
import com.dlz.backend.service.Carrinho.CarrinhoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    final CarrinhoService carrinhoService;

    @GetMapping()
    public ResponseEntity<List<CarrinhoResponseDTO>> encotrarPorCliente(){

        //obtem o cliente logado
        Cliente clienteLogado = (Cliente) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return ResponseEntity.ok().body(carrinhoService.buscarCarrinhoPorIdCliente(clienteLogado.getIdCliente()));
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody CarrinhoRequestDTO carrinhoRequestDTO){

            //obtem o cliente logado
            Cliente clienteLogado = (Cliente) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            try {
                return ResponseEntity.ok().body(carrinhoService.inserirnoCarrinho(carrinhoRequestDTO, clienteLogado));
            } catch (RuntimeException e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
    }

    @PutMapping("/adicionar/{idProduto}")
    public ResponseEntity<?> adicionarNoCarrinho(@PathVariable UUID idProduto) throws RuntimeException {

        // obtem o cliente logado
        Cliente clienteLogado = (Cliente) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        try {
            return ResponseEntity.ok().body(carrinhoService.adicionarNoCarrinho(clienteLogado.getIdCliente(), idProduto));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PutMapping("/remover/{idProduto}")
    public ResponseEntity<CarrinhoResponseDTO> removerDoCarrinho(@PathVariable UUID idProduto){

        //obtem o cliente logado
        Cliente clienteLogado = (Cliente) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return ResponseEntity.ok().body(carrinhoService.removerDoCarrinho(clienteLogado.getIdCliente(), idProduto));
    }

    @PutMapping("/inserirCupom/{codigo}")
    public ResponseEntity<String> inserirCupom(@PathVariable String codigo){

        //obtem o cliente logado
        Cliente clienteLogado = (Cliente) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        try {
            return ResponseEntity.ok().body(carrinhoService.inserirCupom(clienteLogado.getIdCliente(), codigo));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/deletarItem/{idProduto}")
    public ResponseEntity<String> deletarItem(@PathVariable UUID idProduto){

        //obtem o cliente logado
        Cliente clienteLogado = (Cliente) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return ResponseEntity.ok().body(carrinhoService.deletarItem(clienteLogado.getIdCliente(), idProduto));
    }

    @DeleteMapping("/deletarCarrinho")
    public ResponseEntity<String> deletarCarrinho(){

        //obtem o cliente logado
        Cliente clienteLogado = (Cliente) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return ResponseEntity.ok().body(carrinhoService.deletarCarrinho(clienteLogado.getIdCliente()));
    }


}
