package com.dlz.backend.service.Carrinho;

import com.dlz.backend.dto.response.CarrinhoResponseDTO;
import com.dlz.backend.model.Carrinho;
import com.dlz.backend.model.Produto;
import com.dlz.backend.repository.CarrinhoRepository;
import com.dlz.backend.repository.ProdutoRepository;
import com.dlz.backend.service.Compra.CompraService;
import com.dlz.backend.service.Produto.ProdutoService;
import com.dlz.backend.util.CarrinhoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Primary
@RequiredArgsConstructor
public class CarrinhoServiceImplements implements CarrinhoService{

    final CarrinhoRepository carrinhoRepository;
    final CarrinhoMapper carrinhoMapper;
    final ProdutoService produtoService;
    final CompraService compraService;
    final ProdutoRepository produtoRepository;

    @Override
    public CarrinhoResponseDTO encontrarPorId(UUID idCliente) {

        //obtendo o carrinho(entidade) pelo id
        Carrinho carrinho = retornarCarrinho(idCliente);

        //retornando o carrinho(entidade) em formato de carrinhoResponseDTO
        return carrinhoMapper.toCarrinhoDTO(carrinho);
    }

    @Override
    public Carrinho registrar(Carrinho carrinho) {

        //criar uma compra(entidade) para o carrinho(entidade)
        inicializaCompra(carrinho);

        //salvando o carrinho(entidade) no banco de dados
        carrinhoRepository.save(carrinho);
        //retornando o carrinho(entidade) salvo
        return carrinho;
    }

    @Override
    public String adicionarNoCarrinho(UUID idCliente, UUID idProduto) {

        //Obtendo o carrinho(entidade) e produto(entidade) pelo id
        Carrinho carrinho = retornarCarrinho(idCliente);
        Produto produto = produtoService.retornarProduto(idProduto);

        //adicionando o produto(entidade) no carrinho(entidade)
        carrinho.getProdutos().add(produto);

        //decrementando a quantidade do produto(entidade) no estoque
        produto.setQuantidade(produto.getQuantidade() - 1);

        //salvando o carrinho(entidade) no banco de dados
        carrinhoRepository.save(carrinho);

        //salvando o produto(entidade) no banco de dados
        produtoRepository.save(produto);



        return "Produto adicionado com sucesso";
    }

    @Override
    public String removerDoCarrinho(UUID idCliente, UUID idProduto) {
        //Obtendo o carrinho(entidade) e produto(entidade) pelo id
        Carrinho carrinho = retornarCarrinho(idCliente);
        Produto produto = produtoService.retornarProduto(idProduto);

        //removendo o produto(entidade) do carrinho(entidade)
        carrinho.getProdutos().remove(produto);

        //incrementando a quantidade do produto(entidade) no estoque
        produto.setQuantidade(produto.getQuantidade() + 1);

        //salvando o produto(entidade) no banco de dados
        produtoRepository.save(produto);

        //salvando o carrinho(entidade) no banco de dados
        carrinhoRepository.save(carrinho);

        return "Produto removido com sucesso";
    }

    @Override
    public String deletar(UUID idCliente) {

        //deletando o carrinho(entidade) pelo id
        carrinhoRepository.delete(retornarCarrinho(idCliente));
        return "Carrinho deletado com sucesso";
    }

    //funcoes auxiliares
    @Override
    public Carrinho retornarCarrinho(UUID idCliente){
        return carrinhoRepository.findByIdCliente(idCliente);
    }

    public void inicializaCompra(Carrinho carrinho){
        compraService.registrar(carrinho);
    }

}
