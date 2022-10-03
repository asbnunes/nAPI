/**
 * Andre Santoro, Gustavo Pedro Lima, Maisa Moreira
 *
 * 01/10/2022
 *
 * Esse programa foi feito para fins educativos, para a materia
 * de Programacaoo Orientada a Objetos, oferecida no Centro
 * Universitário IESB no periodo 2022.2, ministrada pelo professor
 * Kenniston Arraes.
 */
package com.napi.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interface que lista os possiveis metodos para criacao de
 * tokens de confirmacao para a autenticacao.
 */
@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

    Optional<Token> findByToken(String token);
}
