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
package com.napi.user;

import com.napi.token.Token;
import com.napi.token.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Classe abstrata que define as funcoes necessarias para o
 * funcionamento de processos que dizem respeito a manipulacao
 * de usuarios no banco de dado.
 */
@Component
@AllArgsConstructor
public class UserDetailsServiceImplementation implements UserDetailsService {

    /* chama a interface repositorio */
    private final UserRepository userRepository;

    /* chama o codificador de senhas */
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /* chama o servico de criacao de token */
    private final TokenService tokenService;

    /* procura usuario de acordo com o email cadastrado */
    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.
                        format("Usuario [" + email + "] não encontrado")));
    }

    /*insere um usuario registrado no banco de dados e retorna um token*/
    public String signUp(UserData userData){
        boolean userExists = userRepository
                .findByEmail(userData.getEmail())
                .isPresent();

        if(userExists){
            throw new IllegalStateException("email ja esta em uso");
        }
        String encodedPassword = bCryptPasswordEncoder
                .encode(userData.getSenha());

        userData.setSenha(encodedPassword);

        userRepository.save(userData);

        String token = UUID.randomUUID().toString();
        Token confirmationToken = new Token(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(30),
                userData
        );

        tokenService.saveToken(confirmationToken);
        return token;
    }
}