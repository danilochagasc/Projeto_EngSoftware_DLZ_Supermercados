package com.dlz.backend.service.Cliente;

import com.dlz.backend.dto.request.ClienteRequestDTO;
import com.dlz.backend.dto.response.ClienteResponseDTO;
import com.dlz.backend.model.Cliente.Cliente;

import java.util.UUID;

public interface ClienteService {

    ClienteResponseDTO encontrarPorId(UUID id);

    ClienteResponseDTO registrar(ClienteRequestDTO clienteRequestDTO);

    ClienteResponseDTO atualizar(UUID id, ClienteRequestDTO clienteRequestDTO);

    String deletar(UUID id);

    Cliente retornarCliente(UUID id);
}
