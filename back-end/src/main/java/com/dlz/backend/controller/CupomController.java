package com.dlz.backend.controller;

import com.dlz.backend.dto.request.CupomRequestDTO;
import com.dlz.backend.dto.response.CupomResponseDTO;
import com.dlz.backend.model.Cupom;
import com.dlz.backend.repository.CupomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cupom")
public class CupomController {

    final CupomRepository cupomRepository;

    @PostMapping("/registrar")
    public ResponseEntity<CupomResponseDTO> registrar(@RequestBody CupomRequestDTO cupomRequestDTO){

        Cupom cupom = new Cupom(cupomRequestDTO);

        return ResponseEntity.ok().body(new CupomResponseDTO(cupomRepository.save(cupom)));
    }

    @DeleteMapping("/deletar/{idCupom}")
    public ResponseEntity<String> deletarCupom(@PathVariable UUID idCupom){

        cupomRepository.deleteById(idCupom);

        return ResponseEntity.ok().body("Cupom deletado com sucesso!");
    }
}
