package com.oop.napi.domain.repository;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import com.oop.napi.domain.model.ResetPasswordToken;
import com.oop.napi.domain.services.ResetPasswordTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oop.napi.domain.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Optional<Usuario> findByEmail(String email);

	@Autowired
	ResetPasswordTokenService resetPasswordService = null;
	public default ResetPasswordToken generateResetPasswordToken(Optional<Usuario> obj) {
		Optional<Usuario> user = this.findById(obj.getId());
		ResetPasswordToken resetToken = new ResetPasswordToken();

		if(user != null) {
			resetToken.setUser(user);
			Date createdDate = new Date();
			resetToken.setToken(UUID.randomUUID().toString());
			resetToken.setCreatedDate(createdDate);
			resetPasswordService.insert(resetToken);
		}
		return resetToken;
	}


}	
