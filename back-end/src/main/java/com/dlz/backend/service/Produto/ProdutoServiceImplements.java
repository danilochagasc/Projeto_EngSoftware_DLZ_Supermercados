package com.dlz.backend.service.Produto;

import com.dlz.backend.dto.request.ProdutoRequestDTO;
import com.dlz.backend.dto.response.ProdutoResponseDTO;
import com.dlz.backend.model.Produto;
import com.dlz.backend.repository.ProdutoRepository;
import com.dlz.backend.util.ProdutoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Primary
@RequiredArgsConstructor
public class ProdutoServiceImplements implements ProdutoService{

    final ProdutoRepository produtoRepository;
    final ProdutoMapper produtoMapper;

    @Override
    public ProdutoResponseDTO encontrarPorId(UUID id) {

        //obtendo o produto(entidade) por id
        Produto produto = retornarProduto(id);

        //retornando o produto(entidade) em formato de ProdutoResponseDTO
        return produtoMapper.toProdutoDTO(produto);
    }

    @Override
    public List<ProdutoResponseDTO> listarTodos() {
        //retornando lista de produtos em formato de ProdutoResponseDTO
        return produtoMapper.toProdutoListDTO(produtoRepository.findAll());
    }

    @Override
    public List<ProdutoResponseDTO> listarPorDepartamento(String nomeDep) {
        return produtoMapper.toProdutoListDTO(produtoRepository.procurarPorDepartamento(nomeDep));
    }

    @Override
    public ProdutoResponseDTO registrar(ProdutoRequestDTO produtoRequestDTO) {

        //transformando produtoRequestDTO em produto(entidade)
        Produto produto = produtoMapper.toProduto(produtoRequestDTO);

        //salvando produto(entidade)
        return produtoMapper.toProdutoDTO(produtoRepository.save(produto));
    }

    @Override
    public ProdutoResponseDTO atualizar(UUID id, ProdutoRequestDTO produtoRequestDTO) {

        //recuperando produto por id
        Produto produto = retornarProduto(id);

        //atualizando produto com base no produtoRequestDTO
        produtoMapper.atualizarProduto(produto, produtoRequestDTO);

        //salvando produto atualizado
        return produtoMapper.toProdutoDTO(produtoRepository.save(produto));
    }

    @Override
    public String deletar(UUID id) {

        //deletando produto por id
        produtoRepository.deleteById(id);
        return "Produto id: " + id + "deletado com sucesso";
    }

    //funcoes auxiliares
    private Produto retornarProduto(UUID id){
        return produtoRepository.findById(id).orElseThrow(()-> new RuntimeException("Produto não encontrado"));
    }
}
