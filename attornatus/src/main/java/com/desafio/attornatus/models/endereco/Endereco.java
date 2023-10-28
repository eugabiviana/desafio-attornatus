package com.desafio.attornatus.models.endereco;

import com.desafio.attornatus.models.pessoa.Pessoa;
import jakarta.persistence.*;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_endereco")
public class Endereco {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;
        private String logradouro;
        private String cep;
        private Integer numero;
        private String cidade;
        @ManyToOne
        @JoinColumn(name = "pessoa_id")
        private Pessoa pessoa;
//        private Set<Pessoa> pessoas = new HashSet<>();

    public Endereco() {
    }

    public Endereco(UUID id, String logradouro, String cep, Integer numero, String cidade, Pessoa pessoa) {
        this.id = id;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.pessoa = pessoa;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Endereco endereco)) return false;
        return Objects.equals(id, endereco.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
