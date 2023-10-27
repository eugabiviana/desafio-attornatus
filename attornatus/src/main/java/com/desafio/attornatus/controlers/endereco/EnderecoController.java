package com.desafio.attornatus.controlers.endereco;

import com.desafio.attornatus.dtos.endereco.EnderecoDTO;
import com.desafio.attornatus.dtos.pessoa.PessoaDTO;
import com.desafio.attornatus.models.endereco.Endereco;
import com.desafio.attornatus.models.pessoa.Pessoa;
import com.desafio.attornatus.repositories.endereco.EnderecoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    EnderecoRepository repository;

    @PostMapping
    public ResponseEntity<Endereco> save(@RequestBody @Valid EnderecoDTO enderecoDTO){
        var endereco = new Endereco();
        BeanUtils.copyProperties(enderecoDTO, endereco);
        repository.save(endereco);

        return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
    }

}
