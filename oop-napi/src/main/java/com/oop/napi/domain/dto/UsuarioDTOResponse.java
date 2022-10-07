package com.oop.napi.domain.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UsuarioDTOResponse {

    @Email
    @NotNull
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
