package com.dlz.backend.service.Cliente;

import com.dlz.backend.dto.request.ClienteRequestDTO;
import com.dlz.backend.dto.response.ClienteResponseDTO;
import com.dlz.backend.model.Cliente.Cliente;
import com.dlz.backend.model.Cupom;

import java.util.UUID;

public interface ClienteService {

    ClienteResponseDTO encontrarPorId(UUID idCliente);

    ClienteResponseDTO registrar(ClienteRequestDTO clienteRequestDTO);

    ClienteResponseDTO atualizarDados(UUID idCliente, ClienteRequestDTO clienteRequestDTO);

    ClienteResponseDTO atualizarSenha(UUID idCliente, ClienteRequestDTO clienteRequestDTO);

    String deletar(UUID idCliente);

    Cliente retornarCliente(UUID idCliente);

    void adicionarCupom(UUID idCliente, Cupom cupom);

    void removerCupom(UUID idCliente, Cupom cupom);
}
