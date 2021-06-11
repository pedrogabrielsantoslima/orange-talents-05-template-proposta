package com.example.zupacademy.pedrogabriel.proposta.request;

public class SolicitacaoPropostaRequest {

    private String nome;
    private String documento;

    @Deprecated
    public SolicitacaoPropostaRequest(){}

    public SolicitacaoPropostaRequest(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }
}
