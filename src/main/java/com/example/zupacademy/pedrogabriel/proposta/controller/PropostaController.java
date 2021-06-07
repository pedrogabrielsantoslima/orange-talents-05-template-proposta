package com.example.zupacademy.pedrogabriel.proposta.controller;

import com.example.zupacademy.pedrogabriel.proposta.model.Proposta;
import com.example.zupacademy.pedrogabriel.proposta.repository.PropostaRepository;
import com.example.zupacademy.pedrogabriel.proposta.request.PropostaRequest;
import com.example.zupacademy.pedrogabriel.proposta.response.PropostaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/propostas")
public class PropostaController {

    @Autowired
    private PropostaRepository propostaRepository;

    @GetMapping
    public List<PropostaResponse> listar(){
        return propostaRepository.findAll()
                .stream()
                .map(PropostaResponse::converterDe)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<PropostaResponse> cadastrar(@Valid @RequestBody PropostaRequest propostaRequest){
        Proposta proposta = propostaRepository.save(propostaRequest.toModel());

        return ResponseEntity
                .created(UriComponentsBuilder.fromPath(String.format("/propostas/%s", proposta.getId())).build().toUri())
                .body(PropostaResponse.converterDe(proposta));
    }
}