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
package com.napi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe "main", que inicializa a API.
 */
@SpringBootApplication
public class OopNapiApplication {

	/* metodo que inicializa a API */
	public static void main(String[] args) {
		SpringApplication.run(OopNapiApplication.class, args);
	}
}