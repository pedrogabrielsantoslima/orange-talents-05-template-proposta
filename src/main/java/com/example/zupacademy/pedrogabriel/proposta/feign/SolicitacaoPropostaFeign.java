package com.example.zupacademy.pedrogabriel.proposta.feign;

import com.example.zupacademy.pedrogabriel.proposta.request.SolicitacaoPropostaRequest;
import com.example.zupacademy.pedrogabriel.proposta.response.SolicitacaoPropostaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "solicitacaoPropostaFeign", url = "http://localhost:9999")
public interface SolicitacaoPropostaFeign {

    @PostMapping(value = "/api/solicitacao")
    SolicitacaoPropostaResponse execute(@RequestBody SolicitacaoPropostaRequest solicitacaoPropostaRequest);
}
