package com.oop.napi.domain.services;

import com.oop.napi.domain.model.ResetSenhaToken;
import com.oop.napi.domain.model.Usuario;
import com.oop.napi.domain.repository.ResetSenhaTokenRepository;
import com.oop.napi.domain.repository.UsuarioRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    ResetSenhaTokenService resetSenhaTokenService;

    @Autowired
    ResetSenhaTokenRepository resetSenhaTokenRepository;


    public Usuario findById(Long id) {
        Optional<Usuario> obj = this.usuarioRepository.findById(id);
        return obj.orElse(null);
    }

    public Usuario findByEmail(String email) {
        Optional<Usuario> obj = this.usuarioRepository.findByEmail(email);
        return obj.orElse(null);
    }

    public Usuario update(Usuario obj) {
        if(this.findById(obj.getId()) == null) {
            throw new ObjectNotFoundException("Usuário: "+Usuario.class.getName(),
                    " não encontrado. ID: "+obj.getId());
        }
        obj.setSenha(encoder.encode(obj.getSenha()));
        return this.usuarioRepository.save(obj);
    }

    public ResetSenhaToken generateResetPasswordToken(Usuario obj) {
        Usuario usuario = this.findById(obj.getId());
        ResetSenhaToken resetToken = new ResetSenhaToken();

        if(usuario != null) {
            resetToken.setUser(usuario);
            Date createdDate = new Date();
            resetToken.setToken(UUID.randomUUID().toString());
            resetToken.setCreatedDate(createdDate);
            resetSenhaTokenService.insert(resetToken);
        }
        return resetToken;
    }

    public Usuario getUser(final String verificationToken) {

        final ResetSenhaToken token = resetSenhaTokenService.findByToken(verificationToken);
        if (token != null) {
            return token.getUser();
        }
        return null;
    }

    public ResetSenhaToken getVerificationToken(final String verificationToken) {
        return resetSenhaTokenService.findByToken(verificationToken);
    }
}
