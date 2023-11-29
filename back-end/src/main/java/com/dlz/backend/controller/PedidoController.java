package com.dlz.backend.controller;

import com.dlz.backend.dto.response.PedidoResponseDTO;
import com.dlz.backend.model.Cliente.Cliente;
import com.dlz.backend.service.Pedido.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pedido")
public class PedidoController {

    final PedidoService pedidoService;

    @GetMapping("/listar")
    public ResponseEntity<?> listarPedidos(){

        //obtem o cliente logado
        Cliente clienteLogado = (Cliente) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        try{
            return ResponseEntity.ok().body(pedidoService.listarPedidos(clienteLogado.getIdCliente()));
        }catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarPedido(){

        //obtem o cliente logado
        Cliente clienteLogado = (Cliente) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        try{
            return ResponseEntity.ok().body(pedidoService.cadastrarPedido(clienteLogado));
        }catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
