package com.example.zupacademy.pedrogabriel.proposta.enums;

import com.example.zupacademy.pedrogabriel.proposta.exceptions.StatusPropostaNaoEncontradoException;

import java.util.stream.Stream;

public enum StatusPropostaEnum {

    ELEGIVEL ("SEM_RESTRICAO"),
    NAO_ELEGIVEL ("COM_RESTRICAO");

    private final String restricao;

    StatusPropostaEnum(String restricao) {
        this.restricao = restricao;
    }

    public static StatusPropostaEnum getByRestricao(String restricao){
        return Stream.of(StatusPropostaEnum.values())
                .filter(statusPropostaEnum -> statusPropostaEnum.restricao.equals(restricao))
                .findFirst()
                .orElseThrow(() -> new StatusPropostaNaoEncontradoException("nenhum status proposta para restrição"));
    }
}
