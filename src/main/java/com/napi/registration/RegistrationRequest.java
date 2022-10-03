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
package com.napi.registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Classe que indica os parametros que o usuario precisa
 * passar no pedido de cadastro no banco de dados;
 */
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {

    /* nome do usuario */
    private final String userName;

    /* email do usuario */
    private final String email;

    /* senha do usuario */
    private final String senha;

}
