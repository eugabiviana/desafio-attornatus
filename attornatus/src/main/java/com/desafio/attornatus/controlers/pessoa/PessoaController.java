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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cadastros")
public class PessoaController {

    @Autowired
    PessoaRepository repository;

    @PostMapping
    public ResponseEntity<Pessoa> save(@RequestBody @Valid PessoaDTO pessoaDTO){
        var pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setDataNasc(pessoaDTO.getDataNasc());
//        var endereco = new Endereco();
//        endereco.setCidade(pessoaDTO.getEnderecos().toArray()[0].);
//        BeanUtils.copyProperties(pessoaDTO, pessoa);
        var enderecos = pessoaDTO.getEnderecos().stream().map(e->new Endereco(null,e.getLogradouro(),e.getCep(),e.getNumero(),
                e.getCidade(),null)).collect(Collectors.toSet());
        pessoa.setEnderecos(enderecos);
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
    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable UUID id){
        Optional<Pessoa> pessoa = repository.findById(id);
        repository.delete(pessoa.get());

        return ResponseEntity.ok("O usuário foi deletado com sucesso!");
    }
}
