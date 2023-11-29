package com.dlz.backend.service.Pedido;

import com.dlz.backend.dto.response.PedidoResponseDTO;
import com.dlz.backend.model.Carrinho;
import com.dlz.backend.model.Cliente.Cliente;
import com.dlz.backend.model.Pedido;
import com.dlz.backend.repository.PedidoRepository;
import com.dlz.backend.service.Carrinho.CarrinhoService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Primary
@RequiredArgsConstructor
public class PedidoServiceImplements implements PedidoService{

    final PedidoRepository pedidoRepository;
    final CarrinhoService carrinhoService;

    @Override
    public List<PedidoResponseDTO> listarPedidos(UUID idCliente){
        return pedidoRepository.encontrarPorIdCliente(idCliente).stream().map(PedidoResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public PedidoResponseDTO cadastrarPedido(Cliente cliente) {
        //recuperando o carrinho do cliente
        List<Carrinho> carrinho = carrinhoService.retornarCarrinho(cliente.getIdCliente());

        //verificando se o carrinho esta vazio
        if (carrinho.isEmpty()) {
            throw new RuntimeException("O carrinho está vazio. Não é possível criar um pedido.");
        }

        //criando um novo pedido com o cliente
        Pedido pedido = Pedido.builder()
                .cliente(cliente)
                .build();

        //adicionando os itens do carrinho no pedido
        for (Carrinho itemCarrinho : carrinho) {

            //calculando o preço de venda
            int precoVenda = calcularPrecoVenda(itemCarrinho);
            pedido.adicionarItemPedido(itemCarrinho.getProduto(), itemCarrinho.getQuantidade(), precoVenda);
        }

        //limpando o carrinho
        carrinhoService.limparCarrinho(cliente.getIdCliente());

        // Salva o pedido no banco de dados
        pedidoRepository.save(pedido);

        return new PedidoResponseDTO(pedido);
    }

    private int calcularPrecoVenda(Carrinho itemCarrinho){

        //variavel que armazena o preço de venda
        int preco = itemCarrinho.getProduto().getPreco_em_centavos();

        //verifica se o item do carrinho possui cupom
        if (itemCarrinho.getCupom() == null) {
            return preco * itemCarrinho.getQuantidade();
        }

        preco = preco - (itemCarrinho.getProduto().getPreco_em_centavos() * itemCarrinho.getCupom().getValorDesconto()/100);

        return preco * itemCarrinho.getQuantidade();
    }
}
