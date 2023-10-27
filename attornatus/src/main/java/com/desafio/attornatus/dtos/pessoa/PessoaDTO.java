package com.desafio.attornatus.dtos.pessoa;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class PessoaDTO {

    @NotNull
    private String nome;
    @NotNull
    private Date dataNasc;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }
}
