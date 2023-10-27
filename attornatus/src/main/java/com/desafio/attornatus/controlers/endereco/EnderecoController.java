package com.desafio.attornatus.controlers.endereco;

import com.desafio.attornatus.repositories.endereco.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    EnderecoRepository endereco;

}
