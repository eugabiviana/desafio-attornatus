package com.desafio.attornatus.dtos.pessoa;

import com.desafio.attornatus.dtos.endereco.EnderecoDTO;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class PessoaDTO {

    @NotNull
    private String nome;
    @NotNull
    private Date dataNasc;

    private Set<EnderecoDTO> enderecos = new HashSet<>();

    public Set<EnderecoDTO> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Set<EnderecoDTO> enderecos) {
        this.enderecos = new HashSet<>(enderecos);
    }

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
