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
package com.napi.email;

/**
 * Interface listando todos os metodos utilizados para enviar um email
 */
public interface EmailSender {

    /*metodo para enviar email*/
    void enviar(String to, String email);
}