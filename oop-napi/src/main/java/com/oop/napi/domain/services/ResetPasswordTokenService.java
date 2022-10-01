package com.oop.napi.domain.services;

import java.util.Optional;

import com.oop.napi.domain.model.ResetPasswordToken;
import com.oop.napi.domain.repository.ResetPasswordTokenRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ResetPasswordTokenService {

    @Autowired
    private ResetPasswordTokenRepository repo;

    public ResetPasswordToken findByEmail(String email) {
        Optional<ResetPasswordToken> obj = this.repo.findByEmail(email);
        return obj.orElse(null);
    }

    public ResetPasswordToken findByToken(String token) {
        Optional<ResetPasswordToken> obj = this.repo.findByToken(token);
        return obj.orElse(null);
    }

    public ResetPasswordToken findById(Integer id) {
        Optional<ResetPasswordToken> obj = this.repo.findById(id);
        return obj.orElse(null);
    }

    public ResetPasswordToken insert(ResetPasswordToken obj) {
        obj.setTokenId(null);
        return this.repo.save(obj);
    }

    public ResetPasswordToken update(ResetPasswordToken obj) {
        if(this.findById(obj.getTokenId()) == null) {

        }
        return this.repo.save(obj);
    }

}