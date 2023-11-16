package com.dlz.backend.service.Cliente;

import com.dlz.backend.dto.request.ClienteRequestDTO;
import com.dlz.backend.dto.response.ClienteResponseDTO;
import com.dlz.backend.model.Carrinho;
import com.dlz.backend.model.Cliente.Cliente;
import com.dlz.backend.repository.ClienteRepository;
import com.dlz.backend.service.Carrinho.CarrinhoService;
import com.dlz.backend.util.CarrinhoMapper;
import com.dlz.backend.util.ClienteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Primary
@RequiredArgsConstructor
public class ClienteServiceImplements implements ClienteService{

    final ClienteRepository clienteRepository;
    final ClienteMapper clienteMapper;
    final CarrinhoService carrinhoService;
    final CarrinhoMapper carrinhoMapper;

    @Override
    public ClienteResponseDTO encontrarPorId(UUID id) {

        //obtendo o cliente(entidade) por id
        Cliente cliente = retornarCliente(id);

        //retornando o cliente(entidade) em formato de ClienteResponseDTO
        return clienteMapper.toClienteDTO(cliente);
    }

    @Override
    public ClienteResponseDTO registrar(ClienteRequestDTO clienteRequestDTO) {

        //transformando o clienteRequestDTO em um cliente(entidade)
        Cliente cliente = clienteMapper.toCliente(clienteRequestDTO);

        //inicializando o carrinho do cliente
        inicializaCliente(cliente);

        //salvando o cliente(entidade) no banco de dados
        clienteRepository.save(cliente);

        //retornando o cliente(entidade) em formato de ClienteResponseDTO
        return clienteMapper.toClienteDTO(cliente);
    }

    @Override
    public ClienteResponseDTO atualizar(UUID id, ClienteRequestDTO clienteRequestDTO) {

        //recuperando o cliente(entidade) pelo id
        Cliente cliente = retornarCliente(id);

        //atualizando o cliente(entidade) com base no clienteRequestDTO
        clienteMapper.atualizarDadosCliente(cliente, clienteRequestDTO);

        //salvando o cliente(entidade) no banco de dados
        return clienteMapper.toClienteDTO(clienteRepository.save(cliente));
    }

    @Override
    public String deletar(UUID id) {

            //obtendo o cliente(entidade) por id
            Cliente cliente = retornarCliente(id);

            //deletando o cliente(entidade) do banco de dados
            clienteRepository.delete(cliente);

            //retornando mensagem de sucesso
            return "Cliente deletado com sucesso";
    }

    @Override
    public Cliente retornarCliente(UUID id) {
        return clienteRepository.findById(id).orElseThrow(()->
                new RuntimeException("Cliente não encontrado"));
    }

    //Seta o carrinho do cliente
    public void inicializaCliente(Cliente cliente){
        cliente.setCarrinho(inicializaCarrinho());
    }

    //Inicializa o carrinho
    public Carrinho inicializaCarrinho(){
        Carrinho carrinho = Carrinho.builder().build();
        return carrinhoService.registrar(carrinho);
    }
}
