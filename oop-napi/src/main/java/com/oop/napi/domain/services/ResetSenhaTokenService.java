package com.oop.napi.domain.services;

import com.oop.napi.domain.model.ResetSenhaToken;
import com.oop.napi.domain.repository.SenhaTokenRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResetSenhaTokenService {

    @Autowired
    private SenhaTokenRepository repo;

    public ResetSenhaToken findByEmail(String email) {
        Optional<ResetSenhaToken> obj = this.repo.findByEmail(email);
        return obj.orElse(null);
    }

    public ResetSenhaToken findByToken(String token) {
        Optional<ResetSenhaToken> obj = this.repo.findByToken(token);
        return obj.orElse(null);
    }

    public ResetSenhaToken findById(Long id) {
        Optional<ResetSenhaToken> obj = this.repo.findById(Long.valueOf(id));
        return obj.orElse(null);
    }

    public ResetSenhaToken insert(ResetSenhaToken obj) {
        obj.setId(null);
        return this.repo.save(obj);
    }

    public ResetSenhaToken update(ResetSenhaToken obj) {
        if(this.findById(obj.getId()) == null) {
            throw new ObjectNotFoundException("Object "+ResetSenhaToken.class.getName()," not found! ID "+obj.getId());
        }
        return this.repo.save(obj);
    }

}
