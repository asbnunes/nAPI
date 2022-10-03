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
package com.napi.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Classe que armazena o tipo de erro e o que ele indica.
 */
@Getter
@Setter
@AllArgsConstructor
public class Problema {
    /* codigo http */
    private int status;
    /* data em horas */
    private LocalDateTime dataHora;
    /* titulo do erro */
    private String titulo;
    /* lista com o nome dos erros e suas mensagens */
    private List<Campo> campo;

    /* instancia a classe Problema com valores nulos */
    public Problema(){}

    /**
     * Classe que associa uma mensagem a um nome de erro.
     */
    @AllArgsConstructor
    @Getter
    @Setter
    public static class Campo {
        /*nome do erro*/
        private String nome;
        /*mensagem do erro*/
        private String mensagem;

    }
}
