package com.dlz.backend.service.Produto;

import com.dlz.backend.dto.request.ProdutoRequestDTO;
import com.dlz.backend.dto.response.ProdutoResponseDTO;
import com.dlz.backend.model.Produto;
import com.dlz.backend.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Primary
@RequiredArgsConstructor
public class ProdutoServiceImplements implements ProdutoService{

    final ProdutoRepository produtoRepository;

    @Override
    public ProdutoResponseDTO encontrarPorId(UUID idProduto) {

        //obtendo o produto(entidade) pelo id
        Produto produto = retornarProduto(idProduto);

        //retornando o produto
        return new ProdutoResponseDTO(produto);
    }

    @Override
    public List<ProdutoResponseDTO> listarTodos() {

        //obtendo todos os produtos
        List<Produto> produtos = produtoRepository.findAll();

        //retornando todos os produtos
        return produtos.stream().map(ProdutoResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<ProdutoResponseDTO> listarPorDepartamento(String nomeDep) {

        //obtendo todos os produtos
        List<Produto> produtos = produtoRepository.procurarPorDepartamento(nomeDep);

        //retornando todos os produtos
        return produtos.stream().map(ProdutoResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<ProdutoResponseDTO> listarEmOrdemAlfabetica(String ordem) {

        if(ordem.equals("ASC")){
            //obtendo todos os produtos em ordem alfabética ascendente
            List<Produto> produtos = produtoRepository.procurarPorOrdemAlfabeticaAscendente();

            //retornando todos os produtos
            return produtos.stream().map(ProdutoResponseDTO::new).collect(Collectors.toList());
        }else{
            //obtendo todos os produtos em ordem alfabética descendente
            List<Produto> produtos = produtoRepository.procurarPorOrdemAlfabeticaDescendente();

            //retornando todos os produtos
            return produtos.stream().map(ProdutoResponseDTO::new).collect(Collectors.toList());
        }
    }

    @Override
    public ProdutoResponseDTO registrar(ProdutoRequestDTO produtoRequestDTO) {

        //criando um novo produto
        Produto produto = new Produto(produtoRequestDTO);

        //salvando o produto
        produtoRepository.save(produto);

        //retornando o produto salvo
        return new ProdutoResponseDTO(produto);
    }

    @Override
    public ProdutoResponseDTO atualizar(UUID idProduto, ProdutoRequestDTO produtoRequestDTO) {

        //obtendo o produto(entidade) pelo id
        Produto produto = retornarProduto(idProduto);

        //setando os novos valores
        produto.setNome(produtoRequestDTO.nome());
        produto.setPreco_em_centavos(produtoRequestDTO.preco_em_centavos());
        produto.setDepartamento(produtoRequestDTO.departamento());

        //salvando o produto
        produtoRepository.save(produto);

        //retornando o produto salvo
        return new ProdutoResponseDTO(produto);
    }

    @Override
    public void reduzirQuantidade(UUID idProduto, int quantidade) {

            //obtendo o produto(entidade) pelo id
            Produto produto = retornarProduto(idProduto);

            //verificando se a quantidade é menor que a quantidade no estoque
            if(produto.getQuantidade() < quantidade){
                throw new RuntimeException("Impossível Realizar Compra, quantidade insuficiente em estoque");
            }

            //setando a nova quantidade
            produto.setQuantidade(produto.getQuantidade() - quantidade);

            //salvando o produto
            produtoRepository.save(produto);
    }

    @Override
    public void aumentarQuantidade(UUID idProduto, int quantidade) {

            //obtendo o produto(entidade) pelo id
            Produto produto = retornarProduto(idProduto);

            //setando a nova quantidade
            produto.setQuantidade(produto.getQuantidade() + quantidade);

            //salvando o produto
            produtoRepository.save(produto);
    }

    @Override
    public String deletar(UUID idProduto) {

        //obtendo o produto(entidade) pelo id
        Produto produto = retornarProduto(idProduto);

        //deletando o produto
        produtoRepository.delete(produto);

        //retornando uma mensagem de sucesso
        return "Produto deletado com sucesso";
    }

    @Override
    public Produto retornarProduto(UUID idProduto) {
        return produtoRepository.findById(idProduto).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }
}
