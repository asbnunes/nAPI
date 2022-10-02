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

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface que lista os possiveis metodos para procurar os
 * dados de um usuario por criterios diferentes.
 */
@Repository
public interface UserRepository extends JpaRepository<UserData, Long> {

	/* metodo para achar usuarios por email */
	Optional<UserData> findByEmail(String email);

}	
