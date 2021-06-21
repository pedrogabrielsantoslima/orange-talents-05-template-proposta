package com.example.zupacademy.pedrogabriel.proposta.controller;

import com.example.zupacademy.pedrogabriel.proposta.enums.StatusPropostaEnum;
import com.example.zupacademy.pedrogabriel.proposta.feign.CadastrarCartaoFeign;
import com.example.zupacademy.pedrogabriel.proposta.feign.SolicitacaoPropostaFeign;
import com.example.zupacademy.pedrogabriel.proposta.feign.model.CadastrarCartaoRequest;
import com.example.zupacademy.pedrogabriel.proposta.feign.model.CadastrarCartaoResponse;
import com.example.zupacademy.pedrogabriel.proposta.model.Proposta;
import com.example.zupacademy.pedrogabriel.proposta.repository.PropostaRepository;
import com.example.zupacademy.pedrogabriel.proposta.request.PropostaRequest;
import com.example.zupacademy.pedrogabriel.proposta.feign.model.SolicitacaoPropostaRequest;
import com.example.zupacademy.pedrogabriel.proposta.response.PropostaResponse;
import com.example.zupacademy.pedrogabriel.proposta.feign.model.SolicitacaoPropostaResponse;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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

    @Autowired
    private SolicitacaoPropostaFeign solicitacaoPropostaFeign;

    @Autowired
    private CadastrarCartaoFeign cadastrarCartaoFeign;

    @GetMapping
    public List<PropostaResponse> listar() {
        return propostaRepository.findAll()
                .stream()
                .map(PropostaResponse::converterDe)
                .collect(Collectors.toList());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PropostaResponse> cadastrar(@Valid @RequestBody PropostaRequest propostaRequest) {

        final Proposta proposta = propostaRepository.save(propostaRequest.toModel());

        proposta.setStatus(validarSolicitacaoProposta(proposta));

        CadastrarCartaoResponse cartaoResponse = cadastrarCartaoFeign.execute(new CadastrarCartaoRequest(proposta.getNome(), proposta.getCpf_cnpj(),
                proposta.getId().toString()));

        proposta.setNumero_cartao(cartaoResponse.getId());

        this.propostaRepository.save(proposta);

        return ResponseEntity
                .created(UriComponentsBuilder.fromPath(String.format("/propostas/%s", proposta.getId())).build().toUri())
                .body(PropostaResponse.converterDe(proposta));
    }

    private StatusPropostaEnum validarSolicitacaoProposta(final Proposta proposta) {
        StatusPropostaEnum status;

        try {
            SolicitacaoPropostaResponse solicitacaoPropostaResponse = solicitacaoPropostaFeign
                    .execute(new SolicitacaoPropostaRequest(proposta.getNome(), proposta.getCpf_cnpj(), proposta.getId().toString()));

            status = StatusPropostaEnum.getByRestricao(solicitacaoPropostaResponse.getResultadoSolicitacao());

        } catch (FeignException.UnprocessableEntity unprocessableEntity) {
            status = StatusPropostaEnum.NAO_ELEGIVEL;
        }

        return status;
    }
}
