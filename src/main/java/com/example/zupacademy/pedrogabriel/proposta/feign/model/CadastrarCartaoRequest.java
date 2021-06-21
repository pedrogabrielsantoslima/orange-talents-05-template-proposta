package com.example.zupacademy.pedrogabriel.proposta.feign.model;

public class CadastrarCartaoRequest {

    private final String nome;
    private final String documento;
    private final String idProposta;

    public CadastrarCartaoRequest(String nome, String documento, String idProposta) {
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
