package com.dlz.backend.controller;

import com.dlz.backend.dto.request.ProdutoRequestDTO;
import com.dlz.backend.dto.response.ProdutoResponseDTO;
import com.dlz.backend.service.Produto.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping("/{idProduto}")
    public ResponseEntity<ProdutoResponseDTO> encontrarPorId(@PathVariable UUID idProduto) {
        return ResponseEntity.ok().body(produtoService.encontrarPorId(idProduto));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ProdutoResponseDTO>> encontrarTodos() {
        return ResponseEntity.ok().body(produtoService.listarTodos());
    }

    @GetMapping("/listarPorDep/{nomeDep}")
    public ResponseEntity<List<ProdutoResponseDTO>> encontrarPorDepartamento(@PathVariable String nomeDep) {
        return ResponseEntity.ok().body(produtoService.listarPorDepartamento(nomeDep));
    }

    @GetMapping("/ordemAlfabetica/{ASCouDESC}")
    public ResponseEntity<List<ProdutoResponseDTO>> ordemAlfabetica(@PathVariable String ASCouDESC) {
        return ResponseEntity.ok().body(produtoService.listarEmOrdemAlfabetica(ASCouDESC));
    }

    @PostMapping("/registrar")
    public ResponseEntity<ProdutoResponseDTO> registrar(@RequestBody ProdutoRequestDTO produtoRequestDTO) {
        return ResponseEntity.ok().body(produtoService.registrar(produtoRequestDTO));
    }

    @PutMapping("/atualizar/{idProduto}")
    public ResponseEntity<ProdutoResponseDTO> atualizar(@PathVariable UUID idProduto, @RequestBody ProdutoRequestDTO produtoRequestDTO) {
        return ResponseEntity.ok().body(produtoService.atualizar(idProduto, produtoRequestDTO));
    }

    @DeleteMapping("/deletar/{idProduto}")
    public ResponseEntity<String> deletar(@PathVariable UUID idProduto) {
        return ResponseEntity.ok().body(produtoService.deletar(idProduto));
    }
}
