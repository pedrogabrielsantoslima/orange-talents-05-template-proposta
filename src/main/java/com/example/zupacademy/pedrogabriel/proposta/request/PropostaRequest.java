package com.example.zupacademy.pedrogabriel.proposta.request;

import com.example.zupacademy.pedrogabriel.proposta.model.Proposta;
import com.example.zupacademy.pedrogabriel.proposta.validator.CPFOrCNPJ;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class PropostaRequest {

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @Email
    private String email;

    @NotBlank(message = "O endereço é obrigatório")
    private String endereco;

    @CPFOrCNPJ
    private String cpf_cnpj;

    @NotNull(message = "O salario é obrigatório")
    @Positive
    private BigDecimal salario;

    public PropostaRequest(String nome, String email, String endereco, String cpf_cnpj, BigDecimal salario) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.cpf_cnpj = cpf_cnpj;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public Proposta toModel() {
        return new Proposta(nome, email, endereco, cpf_cnpj, salario);
    }
}
