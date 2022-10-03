package com.oop.napi.domain.repository;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import com.oop.napi.domain.model.ResetPasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oop.napi.domain.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Optional<Usuario> findByEmail(String email);

}	
