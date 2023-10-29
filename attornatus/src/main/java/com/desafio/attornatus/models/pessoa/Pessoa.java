package com.desafio.attornatus.models.pessoa;

import com.desafio.attornatus.models.endereco.Endereco;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.*;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    private String nome;
    @NotNull
    private Date dataNasc;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa", orphanRemoval = true)
    private List<Endereco> enderecos = new ArrayList<>();

    public Pessoa() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public void addEndereco(Endereco endereco) {
        enderecos.add(endereco);
        endereco.setPessoa(this);
    }

    public void remEndereco(Endereco endereco) {
        enderecos.remove(endereco);
        endereco.setPessoa(null);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNasc=" + dataNasc +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa pessoa)) return false;
        return Objects.equals(id, pessoa.id) && Objects.equals(nome, pessoa.nome) && Objects.equals(dataNasc, pessoa.dataNasc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, dataNasc);
    }

    public void save(Set<Endereco> enderecos) {
        var endereco = new Endereco();
        enderecos.add(endereco);
    }
}
