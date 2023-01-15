//Fonte https://github.com/davifelipems/spring-backend-template/blob/2ede3be043e576e557c42cf3dc5390e74f6962be/src/main/java/com/br/davifelipe/springjwt/dto/MessageDTO.java
package com.oop.napi.domain.dto;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.Serializable;
import java.net.URI;
import java.util.Date;

public class MensagemDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    private void setValues(String message, String error, Integer status) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().build().toUri();

        this.status = status;
        this.timestamp = new Date().getTime();
        this.message = message;
        this.path = uri.getRawPath();
        this.error = error;
    }

    public MensagemDTO(String message, String error, Integer status) {
        this.setValues(message, error, status);
    }

    public MensagemDTO(String message, Integer status) {
        this.setValues(message, null, status);
    }
}
