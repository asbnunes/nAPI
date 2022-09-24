package com.oop.napi.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oop.napi.domain.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	//public Optional<Usuario> findByUserName(String userName);
	public Optional<Usuario> findByEmail(String email);

}	
