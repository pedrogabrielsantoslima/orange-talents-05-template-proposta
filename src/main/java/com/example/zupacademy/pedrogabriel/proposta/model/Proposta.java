package com.example.zupacademy.pedrogabriel.proposta.model;

import com.example.zupacademy.pedrogabriel.proposta.enums.StatusPropostaEnum;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String endereco;
    @Column(nullable = false)
    private String cpf_cnpj;
    @Column(nullable = false)
    private BigDecimal salario = new BigDecimal(0.1);
    @Column(length = 19)
    private String numero_cartao;
    @Enumerated(EnumType.STRING)
    private StatusPropostaEnum status;

    @Deprecated
    public Proposta(){}

    public Proposta(String nome, String email, String endereco, String cpf_cnpj, BigDecimal salario) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.cpf_cnpj = cpf_cnpj;
        this.salario = salario;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco(){
        return endereco;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public StatusPropostaEnum getStatus() {
        return status;
    }

    public String getNumero_cartao() {
        return numero_cartao;
    }

    public void setStatus(StatusPropostaEnum status) {
        this.status = status;
    }

    public void setNumero_cartao(String numero_cartao) {
        this.numero_cartao = numero_cartao;
    }
}
