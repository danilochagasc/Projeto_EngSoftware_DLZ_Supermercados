package com.dlz.backend.service.Cliente;

import com.dlz.backend.dto.request.ClienteRequestDTO;
import com.dlz.backend.dto.response.ClienteResponseDTO;
import com.dlz.backend.model.Cliente.Cliente;
import com.dlz.backend.model.Cupom;
import com.dlz.backend.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Primary
@RequiredArgsConstructor
public class ClienteServiceImplements implements ClienteService, UserDetailsService {

    final ClienteRepository clienteRepository;

    @Override
    public ClienteResponseDTO encontrarPorId(UUID idCliente) {

        //obtendo o cliente(entidade) por id
        Cliente cliente = retornarCliente(idCliente);

        //retornando o cliente(entidade) em formato de ClienteResponseDTO
        return new ClienteResponseDTO(cliente);
    }

    @Override
    public ClienteResponseDTO registrar(ClienteRequestDTO clienteRequestDTO) {

        //verificando se o email já está cadastrado
        if(clienteRepository.findByEmail(clienteRequestDTO.email()) != null){
            throw new RuntimeException("Email já cadastrado");
        }

        //Encriptando a senha passada em um novo cliente(entidade)
        String senhaEncriptada = new BCryptPasswordEncoder().encode(clienteRequestDTO.senha());

        //criando um novo cliente(entidade)
        Cliente cliente = new Cliente(clienteRequestDTO, senhaEncriptada);

        //salvando o cliente(entidade) no banco de dados
        clienteRepository.save(cliente);

        //retornando o cliente(entidade) em formato de ClienteResponseDTO
        return new ClienteResponseDTO(cliente);
    }

    @Override
    public ClienteResponseDTO atualizarDados(UUID idCliente, ClienteRequestDTO clienteRequestDTO) {

        //recuperando o cliente(entidade) pelo id
        Cliente cliente = retornarCliente(idCliente);

        //atualizando o cliente(entidade) com base no clienteRequestDTO
        cliente.setNome(clienteRequestDTO.nome());
        cliente.setEmail(clienteRequestDTO.email());
        cliente.setTelefone(clienteRequestDTO.telefone());
        cliente.setEndereco(clienteRequestDTO.endereco());

        //salvando o cliente(entidade) no banco de dados
        clienteRepository.save(cliente);

        //retornando o cliente(entidade) em formato de ClienteResponseDTO
        return new ClienteResponseDTO(cliente);
    }

    @Override
    public ClienteResponseDTO atualizarSenha(UUID idCliente, ClienteRequestDTO clienteRequestDTO) {

        //recuperando o cliente(entidade) pelo id
        Cliente cliente = retornarCliente(idCliente);

        //encriptando a senha passada
        String senhaEncriptada = new BCryptPasswordEncoder().encode(clienteRequestDTO.senha());

        //atualizando a senha do cliente(entidade)
        cliente.setSenha(senhaEncriptada);

        //salvando o cliente(entidade) no banco de dados
        clienteRepository.save(cliente);

        return new ClienteResponseDTO(cliente);
    }

    @Override
    public String deletar(UUID idCliente) {

            //obtendo o cliente(entidade) por id
            Cliente cliente = retornarCliente(idCliente);

            //deletando o cliente(entidade) do banco de dados
            clienteRepository.delete(cliente);

            //retornando mensagem de sucesso
            return "Cliente deletado com sucesso";
    }

    @Override
    public Cliente retornarCliente(UUID idCliente) {
        return clienteRepository.findById(idCliente).orElseThrow(()->
                new RuntimeException("Cliente não encontrado"));
    }

    @Override
    public void adicionarCupom(UUID idCliente, Cupom cupom) {

        //obtendo o cliente(entidade) por id
        Cliente cliente = retornarCliente(idCliente);

        //adicionando o cupom no cliente(entidade)
        cliente.adicionarCupom(cupom);

        //salvando o cliente(entidade) no banco de dados
        clienteRepository.save(cliente);
    }

    @Override
    public void removerCupom(UUID idCliente, Cupom cupom) {
        //obtendo o cliente(entidade) por id
        Cliente cliente = retornarCliente(idCliente);

        //adicionando o cupom no cliente(entidade)
        cliente.removerCupom(cupom);

        //salvando o cliente(entidade) no banco de dados
        clienteRepository.save(cliente);
    }

    //metodo do UserDetails
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return clienteRepository.findByEmail(username);
    }
}
