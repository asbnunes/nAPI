package com.oop.napi.domain.services;

import com.oop.napi.domain.data.UserData;
import com.oop.napi.domain.model.Usuario;
import com.oop.napi.domain.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository repository;

    public UserDetailsServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> usuario = repository.findByEmail(email);

        if(usuario.isEmpty()){
            throw new UsernameNotFoundException("Usuário [" + email + "] não encontrado");
        }

        return new UserData(usuario);
    }
}