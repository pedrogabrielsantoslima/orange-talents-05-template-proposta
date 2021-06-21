package com.example.zupacademy.pedrogabriel.proposta.response;

import com.example.zupacademy.pedrogabriel.proposta.enums.StatusPropostaEnum;
import com.example.zupacademy.pedrogabriel.proposta.model.Proposta;
import com.example.zupacademy.pedrogabriel.proposta.request.PropostaRequest;

import java.math.BigDecimal;

public class PropostaResponse extends PropostaRequest {

    private Integer id;
    private StatusPropostaEnum status;
    private String numero_cartao;

    public PropostaResponse(String nome, String email, String endereco, String cpf_cnpj, BigDecimal salario) {
        super(nome, email, endereco, cpf_cnpj, salario);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StatusPropostaEnum getStatus() {
        return status;
    }

    public void setStatus(StatusPropostaEnum status) {
        this.status = status;
    }

    public String getNumero_cartao() {
        return numero_cartao;
    }

    public void setNumero_cartao(String numero_cartao) {
        this.numero_cartao = numero_cartao;
    }

    public static PropostaResponse converterDe(Proposta proposta) {
        PropostaResponse propostaResponse = new PropostaResponse(proposta.getNome(), proposta.getEmail(),
                proposta.getEndereco(), proposta.getCpf_cnpj(), proposta.getSalario());

        propostaResponse.id = proposta.getId();
        propostaResponse.status = proposta.getStatus();
        propostaResponse.numero_cartao = proposta.getNumero_cartao();

        return propostaResponse;
    }
}
