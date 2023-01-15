package com.oop.napi.domain.repository;

import com.oop.napi.domain.model.ResetSenhaToken;
import com.oop.napi.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ResetSenhaTokenRepository extends JpaRepository<ResetSenhaToken, Long> {

    ResetSenhaToken findByUser(Usuario user);

    @Transactional(readOnly = true)
    Optional<ResetSenhaToken> findByToken(@Param("token") String token);

    @Transactional(readOnly = true)
    @Query(value = "SELECT spt FROM ResetSenhaToken spt JOIN spt.user user WHERE user.email = :email") //???
    Optional<ResetSenhaToken> findByEmail(@Param("email") String email);

}
