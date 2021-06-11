package com.example.zupacademy.pedrogabriel.proposta.response;

import com.example.zupacademy.pedrogabriel.proposta.request.SolicitacaoPropostaRequest;

public class SolicitacaoPropostaResponse extends SolicitacaoPropostaRequest{

    private String resultadoSolicitacao;
    private Integer idProposta;

    @Deprecated
    public SolicitacaoPropostaResponse(){}

    public SolicitacaoPropostaResponse(String nome, String documento, String resultadoSolicitacao, Integer idProposta) {
        super(nome, documento);
        this.resultadoSolicitacao = resultadoSolicitacao;
        this.idProposta = idProposta;
    }

    public String getResultadoSolicitacao() {
        return resultadoSolicitacao;
    }

    public Integer getIdProposta() {
        return idProposta;
    }
}
