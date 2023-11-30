package com.dlz.backend.controller;

import com.dlz.backend.dto.request.ClienteRequestDTO;
import com.dlz.backend.dto.response.ClienteResponseDTO;
import com.dlz.backend.infra.seguranca.TokenService;
import com.dlz.backend.model.Cliente.Cliente;
import com.dlz.backend.service.Cliente.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @GetMapping()
    public ResponseEntity<ClienteResponseDTO> encontrarPorId(){

        //obtem o cliente logado
        Cliente clienteLogado = (Cliente) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return ResponseEntity.ok().body(new ClienteResponseDTO(clienteLogado));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody ClienteRequestDTO clienteRequestDTO){

        //gera um token referente ao email e senha passados
        var emailSenha = new UsernamePasswordAuthenticationToken(clienteRequestDTO.email(), clienteRequestDTO.senha());

        //valida o token gerado acima
        var autenticacao = authenticationManager.authenticate(emailSenha);

        //gera um token JWT
        var token = tokenService.gerarToken((Cliente) autenticacao.getPrincipal());

        //retornando o token JWT dp usuario
        return ResponseEntity.ok().body(token);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody ClienteRequestDTO clienteRequestDTO){

        try{
            return ResponseEntity.ok().body(clienteService.registrar(clienteRequestDTO));
        }catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/atualizarCliente")
    public ResponseEntity<ClienteResponseDTO> atualizarCliente(@RequestBody ClienteRequestDTO clienteRequestDTO){

        //obtem o cliente logado
        Cliente clienteLogado = (Cliente) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return ResponseEntity.ok().body(clienteService.atualizarDados(clienteLogado.getIdCliente(), clienteRequestDTO));
    }

    @PutMapping("/atualizarSenhaCliente")
    public ResponseEntity<ClienteResponseDTO> atualizarSenhaCliente(@RequestBody ClienteRequestDTO clienteRequestDTO){

        //obtem o cliente logado
        Cliente clienteLogado = (Cliente) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return ResponseEntity.ok().body(clienteService.atualizarSenha(clienteLogado.getIdCliente(), clienteRequestDTO));
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<String> deletar(){

        //obtem o cliente logado
        Cliente clienteLogado = (Cliente) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return ResponseEntity.ok().body(clienteService.deletar(clienteLogado.getIdCliente()));
    }
}
