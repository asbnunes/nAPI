package com.oop.napi.domain.repository;

import com.oop.napi.domain.model.Personagem;
import com.oop.napi.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {

    Optional<Personagem> findById(Long id);

}
