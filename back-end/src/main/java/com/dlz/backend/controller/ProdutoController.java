package com.dlz.backend.controller;

import com.dlz.backend.dto.request.ProdutoRequestDTO;
import com.dlz.backend.dto.response.ProdutoResponseDTO;
import com.dlz.backend.service.Produto.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping(value = "/porId/{id}")
    public ResponseEntity<ProdutoResponseDTO> encontrarPorId(@PathVariable(value = "id") UUID id){
        return ResponseEntity.ok().body(produtoService.encontrarPorId(id));
    }

    @GetMapping()
    public ResponseEntity<List<ProdutoResponseDTO>> encontrarTodos(){
        return ResponseEntity.ok().body(produtoService.listarTodos());
    }

    @GetMapping(value = "/porDep/{nomeDep}")
    public ResponseEntity<List<ProdutoResponseDTO>> encontrarTodos(@PathVariable(value = "nomeDep") String nomeDep){
        return ResponseEntity.ok().body(produtoService.listarPorDepartamento(nomeDep));
    }

    @PostMapping(value = "/registrar")
    public ResponseEntity<ProdutoResponseDTO> registrarProduto(@RequestBody ProdutoRequestDTO produtoRequestDTO, UriComponentsBuilder uriBuilder){

        //cadastrando um produto
        ProdutoResponseDTO produtoResponseDTO = produtoService.registrar(produtoRequestDTO);

        //uri criada para o novo produto
        URI uri = uriBuilder.path("produto/{id}").buildAndExpand(produtoResponseDTO.getIdProduto()).toUri();

        //retornando o produto cadastrado com status 201("created")
        return ResponseEntity.created(uri).body(produtoResponseDTO);
    }

    @PutMapping(value = "/atualizar/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizarProduto(@PathVariable(value = "id") UUID id, @RequestBody ProdutoRequestDTO produtoRequestDTO){
        return ResponseEntity.ok().body(produtoService.atualizar(id, produtoRequestDTO));
    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable(name = "id") UUID id){
        return ResponseEntity.ok().body(produtoService.deletar(id));
    }
}
