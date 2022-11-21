package com.oop.napi.domain.repository;

import com.oop.napi.domain.model.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonagemRepository extends JpaRepository<Personagem, Integer> {

    public Personagem findById(Long id);

}
