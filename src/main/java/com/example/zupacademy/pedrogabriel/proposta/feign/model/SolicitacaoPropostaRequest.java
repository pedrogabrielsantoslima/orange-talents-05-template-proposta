package com.example.zupacademy.pedrogabriel.proposta.feign.model;

public class SolicitacaoPropostaRequest {

    private String nome;
    private String documento;
    private String idProposta;

    @Deprecated
    public SolicitacaoPropostaRequest(){}

    public SolicitacaoPropostaRequest(String nome, String documento, String idProposta) {
        this.nome = nome;
        this.documento = documento;
        this.idProposta = idProposta;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getIdProposta() {
        return idProposta;
    }
}
