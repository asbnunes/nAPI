package com.oop.napi.domain.repository;

import com.oop.napi.domain.model.ResetSenhaToken;
import com.oop.napi.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;
import java.util.stream.Stream;

public interface SenhaTokenRepository extends JpaRepository<ResetSenhaToken, Long> {

    @Transactional(readOnly = true)
    public Optional<ResetSenhaToken> findByToken(@Param("token") String token);

    @Transactional(readOnly = true)
    @Query(value = "SELECT spt FROM ResetSenhaToken spt JOIN spt.user user WHERE user.email = :email")
    Optional<ResetSenhaToken> findByEmail(@Param("email") String email);

    /*ResetSenhaToken findByToken(String token);

    ResetSenhaToken findByUser(Usuario user);

    Stream<ResetSenhaToken> findAllByExpiryDateLessThan(Date now);

    void deleteByExpiryDateLessThan(Date now);

    @Modifying
    @Query("delete from ResetSenhaToken t where t.expiryDate <= ?1")
    void deleteAllExpiredSince(Date now);*/
}
