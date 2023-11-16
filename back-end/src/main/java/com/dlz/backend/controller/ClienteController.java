package com.dlz.backend.controller;

import com.dlz.backend.dto.request.ClienteRequestDTO;
import com.dlz.backend.dto.response.ClienteResponseDTO;
import com.dlz.backend.service.Cliente.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;
    private final AuthenticationManager authenticationManager;


    @GetMapping("/porId/{id}")
    public ResponseEntity<ClienteResponseDTO> encontrarPorId(@PathVariable(value = "id") UUID id){
        return ResponseEntity.ok().body(clienteService.encontrarPorId(id));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody ClienteRequestDTO clienteRequestDTO){

        //gera um token referente ao email e senha passados
        var emailSenha = new UsernamePasswordAuthenticationToken(clienteRequestDTO.getEmail(), clienteRequestDTO.getSenha());

        //valida o token gerado acima
        var autenticacao = authenticationManager.authenticate(emailSenha);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/registrar")
    public ResponseEntity<ClienteResponseDTO> registrar(@RequestBody ClienteRequestDTO clienteRequestDTO){

        try{
            return ResponseEntity.ok().body(clienteService.registrar(clienteRequestDTO));
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ClienteResponseDTO> atualizar(@PathVariable(value = "id") UUID id, @RequestBody ClienteRequestDTO clienteRequestDTO){
        return ResponseEntity.ok().body(clienteService.atualizar(id, clienteRequestDTO));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable(value = "id") UUID id){
        return ResponseEntity.ok().body(clienteService.deletar(id));
    }
}
