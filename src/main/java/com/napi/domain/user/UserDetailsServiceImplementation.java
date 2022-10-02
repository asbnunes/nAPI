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
package com.napi.domain.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Classe que implementa a interface UserDetailsService para
 * permitir a busca de atributos dos usuarios por diversos
 * parametros.
 */
@Component
public class UserDetailsServiceImplementation implements UserDetailsService {

    /* variavel repositorio */
    private final UserRepository userRepository;

    /* instancia a classe UserDetailsServiceImplementation na memoria */
    public UserDetailsServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /* procura usuario de acordo com o email cadastrado */
    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.
                        format("Usuario [" + email + "] não encontrado")));
    }
}