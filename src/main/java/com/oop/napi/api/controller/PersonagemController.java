package com.oop.napi.api.controller;

import com.oop.napi.domain.model.Personagem;
import com.oop.napi.domain.repository.PersonagemRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personagem")
@Api(value = "Endpoint para personagens")
public class PersonagemController {

    private final PersonagemRepository repository;

    public PersonagemController(PersonagemRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/listar-personagens")
    @ApiOperation(value = "Lista todos os personagens", response = Personagem[].class)
    @Query(value = "SELECT p.nome, p.sexo, p.cla, p.aldeia, e.estilo, p.registroNinja, p.patenteNinja " +
            "FROM Personagem m, Estilo e " +
            "INNER JOIN Personagem ON p.nome = e.nome")
    public ResponseEntity<List<Personagem>> listarTodos() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/listar-personagem/{id}")
    @ApiOperation(value = "Lista personagem por ID", response = Personagem.class)
    public ResponseEntity<Personagem> listarId(@PathVariable long id) {
        return ResponseEntity.ok(repository.findById(id));
    }

    @PostMapping("/adicionar-personagem")
    @ApiOperation(value = "Adiciona personagem", response = Personagem.class)
    public ResponseEntity<Personagem> salvarPersonagem(@RequestBody Personagem personagem) {
        System.out.println(personagem);
        return ResponseEntity.ok(repository.save(personagem));
    }
}
