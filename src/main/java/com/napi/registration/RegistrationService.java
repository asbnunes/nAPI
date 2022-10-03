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
package com.napi.registration;

import com.napi.email.EmailSender;
import com.napi.token.TokenService;
import com.napi.user.UserAccessType;
import com.napi.user.UserData;
import com.napi.user.UserDetailsServiceImplementation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Classe abstrata que define as funcionalidades pertinentes ao
 * processo de cadastro de um usuario no banco de dados.
 */
@Service
@Transactional
@AllArgsConstructor
public class RegistrationService {

    /**
     * chama a classe abstrata que define as funcoes necessarias
     * para a manipulacao de dados de usuario no banco de dados.
     */
    private final UserDetailsServiceImplementation userDetailsServiceImplementation;

    /* chama a classe abstrata de servico de criacao de tokens */
    private final TokenService TokenService;

    /* chama a interface de envio de emails */
    private final EmailSender emailSender;

    /* metodo de registrar o usuario e enviar um email de confirmacao */
    public String register(RegistrationRequest request) {

        String token = userDetailsServiceImplementation.signUp(
                new UserData(
                        request.getUserName(),
                        request.getEmail(),
                        request.getSenha(),
                        UserAccessType.NORMAL

                )
        );

        String link = "http://localhost:8080/napi/registration/confirm?token=" + token;
        emailSender.enviar(
                request.getEmail(),
                buildEmail(request.getUserName(), link));

        return token;
    }
    /* constroi um template de email */
    private String buildEmail(String name, String link) {
        return "email";
    }
}