package com.desafio.attornatus.controlers.pessoa;

import com.desafio.attornatus.dtos.pessoa.PessoaDTO;
import com.desafio.attornatus.models.endereco.Endereco;
import com.desafio.attornatus.models.pessoa.Pessoa;
import com.desafio.attornatus.repositories.pessoa.PessoaRepository;
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
    public ResponseEntity<Pessoa> salvar(@RequestBody @Valid PessoaDTO pessoaDTO){
        var pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setDataNasc(pessoaDTO.getDataNasc());

        pessoaDTO.getEnderecos().forEach(ed -> pessoa.addEndereco(
                new Endereco(ed.getLogradouro(), ed.getCep(), ed.getNumero(), ed.getCidade())));

        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(pessoa));
    }

    @GetMapping
    public ResponseEntity buscarTodos(){
        List<Pessoa> pessoa = repository.findAll();
        return ResponseEntity.ok(pessoa);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable UUID id){
        Optional<Pessoa> pessoa = repository.findById(id);

        return ResponseEntity.ok(pessoa);
    }
    @PutMapping("/{id}")
    public ResponseEntity atualizar (@PathVariable UUID id, @RequestBody PessoaDTO updatedPessoa){
        Optional<Pessoa> pessoaToUpdate = repository.findById(id);
        var pessoa = pessoaToUpdate.get();
        BeanUtils.copyProperties(updatedPessoa, pessoa);

        return ResponseEntity.status(HttpStatus.OK).body(repository.save(pessoa));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity apagar (@PathVariable UUID id){
        Optional<Pessoa> pessoa = repository.findById(id);
        repository.delete(pessoa.get());

        return ResponseEntity.ok("O usuário foi deletado com sucesso!");
    }
}
