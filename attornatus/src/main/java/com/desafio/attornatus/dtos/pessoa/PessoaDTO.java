package com.desafio.attornatus.dtos.pessoa;

import com.desafio.attornatus.dtos.endereco.EnderecoDTO;
import jakarta.validation.constraints.NotNull;

import java.util.*;

public class PessoaDTO {

    private UUID id;
    @NotNull
    private String nome;
    @NotNull
    private Date dataNasc;

    private List<EnderecoDTO> enderecos;

    public List<EnderecoDTO> getEnderecos() {
        return enderecos;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setEnderecos(List<EnderecoDTO> enderecos) {
        this.enderecos = enderecos;
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
