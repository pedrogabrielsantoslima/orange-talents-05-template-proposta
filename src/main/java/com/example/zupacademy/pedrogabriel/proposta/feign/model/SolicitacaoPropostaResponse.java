package com.example.zupacademy.pedrogabriel.proposta.feign.model;

public class SolicitacaoPropostaResponse extends SolicitacaoPropostaRequest{

    private String resultadoSolicitacao;
    private String idProposta;

    @Deprecated
    public SolicitacaoPropostaResponse(){}

    public SolicitacaoPropostaResponse(String nome, String documento, String resultadoSolicitacao, String idProposta) {
        super(nome, documento, idProposta);
        this.resultadoSolicitacao = resultadoSolicitacao;
    }

    public String getResultadoSolicitacao() {
        return resultadoSolicitacao;
    }

    public String getIdProposta() {
        return idProposta;
    }
}
