package com.dlz.backend.service.Carrinho;

import com.dlz.backend.dto.request.CarrinhoRequestDTO;
import com.dlz.backend.dto.response.CarrinhoResponseDTO;
import com.dlz.backend.model.Carrinho;
import com.dlz.backend.model.Cliente.Cliente;
import com.dlz.backend.model.Cupom;
import com.dlz.backend.repository.CarrinhoRepository;
import com.dlz.backend.repository.CupomRepository;
import com.dlz.backend.service.Cliente.ClienteService;
import com.dlz.backend.service.Produto.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Primary
@RequiredArgsConstructor
public class CarrinhoServiceImplements implements CarrinhoService{

    final CarrinhoRepository carrinhoRepository;
    final ProdutoService produtoService;
    final CupomRepository cupomRepository;
    final ClienteService clienteService;

    @Override
    public List<CarrinhoResponseDTO> buscarCarrinhoPorIdCliente(UUID idCliente) {
        return retornarCarrinho(idCliente).stream().map(CarrinhoResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public CarrinhoResponseDTO inserirnoCarrinho(CarrinhoRequestDTO carrinhoRequestDTO, Cliente cliente) {

        //verifica se o carrinho ja existe, se sim lança uma exceção
        if(carrinhoRepository.encontrarPorIdClienteEIdProduto(cliente.getIdCliente(), carrinhoRequestDTO.produto().getIdProduto()) != null){
            throw new RuntimeException("Item já existe no carrinho");
        }

        //criando um novo carrinho com os dados inseridos
        Carrinho carrinho = new Carrinho(carrinhoRequestDTO, cliente);

        //verificando se algum carrinho do cliente esta usando o cupom, se sim, aplicar o cupom no carrinho
        for (Carrinho c : retornarCarrinho(cliente.getIdCliente())) {
            if(c.getCupom() != null){
                carrinho.setCupom(c.getCupom());
            }
        }

        //decrementando a quantidade do produto
        produtoService.reduzirQuantidade(carrinho.getProduto().getIdProduto(), carrinho.getQuantidade());

        //salvando o carrinho
        return new CarrinhoResponseDTO(carrinhoRepository.save(carrinho));

    }

    @Override
    public CarrinhoResponseDTO adicionarNoCarrinho(UUID idCliente, UUID idProduto) {

        //obtendo o carrinho pelo id do cliente e id do produto
        Carrinho carrinho = carrinhoRepository.encontrarPorIdClienteEIdProduto(idCliente, idProduto);

        //adicionando 1 na quantidade
        carrinho.setQuantidade(carrinho.getQuantidade() + 1);

        //decrementando a quantidade do produto
        produtoService.reduzirQuantidade(carrinho.getProduto().getIdProduto(), 1);

        //salvando o carrinho
        return new CarrinhoResponseDTO(carrinhoRepository.save(carrinho));
    }

    @Override
    public CarrinhoResponseDTO removerDoCarrinho(UUID idCliente, UUID idProduto) {

        //obtendo o carrinho pelo id do cliente e id do produto
        Carrinho carrinho = carrinhoRepository.encontrarPorIdClienteEIdProduto(idCliente, idProduto);

        //removendo 1 na quantidade
        carrinho.setQuantidade(carrinho.getQuantidade() - 1);


        //incrementando a quantidade do produto
        produtoService.aumentarQuantidade(carrinho.getProduto().getIdProduto(), 1);

        //verificando se a quantidade é 0, se sim deleta o item
        if (carrinho.getQuantidade() <= 0) {
            deletarItem(idCliente, idProduto);
            return null;
        }

        //salvando o carrinho
        return new CarrinhoResponseDTO(carrinhoRepository.save(carrinho));
    }

    @Override
    public String inserirCupom(UUID idCliente, String codigo) {

        //obtendo o carrinho pelo id do cliente
        List<Carrinho> carrinho = retornarCarrinho(idCliente);

        //obtendo o cupom pelo codigo
        Cupom cupom = cupomRepository.encontrarPorCodigo(codigo);

        //verificando se o cupom é valido
        if(cupom == null){
            throw new RuntimeException("Cupom inválido");
        }

        //verificando se o cupom ja foi usado pelo cliente
        for (Cliente c : cupom.getClientesComCupom()) {
            if(c.getIdCliente().equals(idCliente)){
                throw new RuntimeException("Cupom já utilizado");
            }
        }

        //se não houve nenhuma exceção, adiciona o cupom no carrinho
        carrinho.forEach(c -> c.setCupom(cupom));

        //adiciona o cupom no cliente
        clienteService.adicionarCupom(idCliente, cupom);

        //salvando o cupom
        cupomRepository.save(cupom);

        //salvando o carrinho
        carrinhoRepository.saveAll(carrinho);

        return "Cupom aplicado com sucesso";
    }

    @Override
    public String deletarItem(UUID idCliente, UUID idProduto) {

        //obtendo o carrinho pelo id do cliente e id do produto
        Carrinho carrinho = carrinhoRepository.encontrarPorIdClienteEIdProduto(idCliente, idProduto);

        //incrementando a quantidade do produto
        produtoService.aumentarQuantidade(carrinho.getProduto().getIdProduto(), carrinho.getQuantidade());

        //deletando o carrinho
        carrinhoRepository.delete(carrinho);

        //retornando uma mensagem de sucesso
        return "Item deletado com sucesso";
    }

    @Override
    public String deletarCarrinho(UUID idCliente) {

            //obtendo o carrinho pelo id do cliente
            List<Carrinho> carrinho = carrinhoRepository.encontrarPorIdCliente(idCliente);

            //incrementando a quantidade do produto
            carrinho.forEach(c -> produtoService.aumentarQuantidade(c.getProduto().getIdProduto(), c.getQuantidade()));

            //verificando se o carrinho tinha algum cupom
            if(carrinho.get(0).getCupom() != null){
                //removendo o cupom do cliente
                clienteService.removerCupom(idCliente, carrinho.get(0).getCupom());
            }

            //deletando o carrinho
            carrinhoRepository.deleteAll(carrinho);

            //retornando uma mensagem de sucesso
            return "Carrinho deletado com sucesso";
    }

    @Override
    public void limparCarrinho(UUID idCliente) {

        //obtendo o carrinho pelo id do cliente
        List<Carrinho> carrinho = carrinhoRepository.encontrarPorIdCliente(idCliente);

        //limpando o carrinho
        carrinhoRepository.deleteAll(carrinho);
    }

    @Override
    public List<Carrinho> retornarCarrinho(UUID idCliente) {
        return carrinhoRepository.encontrarPorIdCliente(idCliente);
    }
}
