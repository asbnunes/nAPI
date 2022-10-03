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
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que toma conta das mensagens a serem enviadas em caso de erro
 */
@ControllerAdvice
@AllArgsConstructor
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    /* instancia a classe MessageSource para ter a fonte das mensagens */
    private MessageSource messageSource;

    /* metodo para tratar excecoes e enviar uma mensagem ao inves de codigo de erro*/
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid
            (MethodArgumentNotValidException ex,
             HttpHeaders headers,
             HttpStatus status,
             WebRequest request) {
        Problema problema = new Problema();
        List<Problema.Campo> campos = new ArrayList<>();

        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            String nome = ((FieldError) error).getField();
            String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());
            campos.add(new Problema.Campo(nome, mensagem));
        }
        problema.setStatus(status.value());
        problema.setDataHora(LocalDateTime.now());
        problema.setTitulo("Um ou mais campos inválidos. " +
                "Preencha corretamente e tente novamente.");
        problema.setCampo(campos);
        return handleExceptionInternal(ex, problema, headers, status, request);
    }
}
