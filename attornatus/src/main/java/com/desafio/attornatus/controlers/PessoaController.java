package com.desafio.attornatus.controlers;

import com.desafio.attornatus.dtos.PessoaDTO;
import com.desafio.attornatus.models.Pessoa;
import com.desafio.attornatus.repositories.PessoaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/cadastros")
public class PessoaController {

    @Autowired
    PessoaRepository repository;

    @PostMapping
    public ResponseEntity<Pessoa> save(@RequestBody @Valid PessoaDTO pessoaDTO){
        var pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaDTO, pessoa);
        repository.save(pessoa);

        return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
    }

    @GetMapping
    public ResponseEntity getAll(){
        List<Pessoa> pessoa = repository.findAll();
        return ResponseEntity.ok(pessoa);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable UUID id){
        Optional<Pessoa> pessoa = repository.findById(id);

        return ResponseEntity.ok(pessoa);
    }
    @PutMapping("/{id}")
    public ResponseEntity update (@PathVariable UUID id, @RequestBody PessoaDTO updatedPessoa){
        Optional<Pessoa> pessoaToUpdate = repository.findById(id);
        var pessoa = pessoaToUpdate.get();
        BeanUtils.copyProperties(updatedPessoa, pessoa);

        return ResponseEntity.status(HttpStatus.OK).body(repository.save(pessoa));
    }
}
