package com.desafio.attornatus.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "db_pessoa")
public class Pessoa {

    @Id
    private UUID id;
    @NotNull
    private String nome;
    @NotNull
    private Date dataNasc;

}
