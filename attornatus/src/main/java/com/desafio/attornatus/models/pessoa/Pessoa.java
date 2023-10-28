package com.desafio.attornatus.models.pessoa;

import com.desafio.attornatus.models.endereco.Endereco;
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
//    @JoinTable(
//            name = "tb_pessoa_endereco",
//            joinColumns = @JoinColumn(name = "pessoa_id"),
//            inverseJoinColumns = @JoinColumn(name = "endereco_id")
//    )
    private Set<Endereco> enderecos = new HashSet<>();

    public Pessoa() {

    }

    public Pessoa(UUID id, @NotNull String nome, @NotNull Date dataNasc, Set<Endereco> enderecos) {
        this.id = id;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.enderecos = enderecos;
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

    public Set<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Set<Endereco> enderecos) {
        this.enderecos = new HashSet<>(enderecos);
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
}
