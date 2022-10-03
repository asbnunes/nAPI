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

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Classe abstrata que define as funcoes necessarias para o
 * funcionamento de processos que dizem respeito a criacao de
 * tokens de confirmacao
 */
@Service
@AllArgsConstructor
public class TokenService {

    /* chama o repositorio de tokens */
    private final TokenRepository tokenRepository;

    /* salva um token */
    public void saveToken(Token token){
        tokenRepository.save(token);
    }
}
