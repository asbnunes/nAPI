package com.oop.napi.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oop.napi.domain.services.ResetSenhaSave;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@ResetSenhaSave
public class ResetSenhaDTO {

    @NotNull
    @Size(min=10)
    private String token;

    @NotNull
    @Size(min=2)
    private String password;

    @NotNull
    @Size(min=2)
    @JsonProperty("password_confirm")
    private String passwordConfirm;
}
