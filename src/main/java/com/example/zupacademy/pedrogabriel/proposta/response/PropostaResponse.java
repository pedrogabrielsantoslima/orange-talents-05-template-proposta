package com.example.zupacademy.pedrogabriel.proposta.response;

import com.example.zupacademy.pedrogabriel.proposta.model.Proposta;
import com.example.zupacademy.pedrogabriel.proposta.request.PropostaRequest;

import java.math.BigDecimal;

public class PropostaResponse extends PropostaRequest {

    private Integer id;

    public PropostaResponse(String nome, String email, String endereco, String cpf_cnpj, BigDecimal salario) {
        super(nome, email, endereco, cpf_cnpj, salario);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static PropostaResponse converterDe(Proposta proposta) {
        PropostaResponse propostaResponse = new PropostaResponse(proposta.getNome(), proposta.getEmail(),
                proposta.getEndereco(), proposta.getCpf_cnpj(), proposta.getSalario());

        propostaResponse.id = proposta.getId();

        return propostaResponse;
    }
}
