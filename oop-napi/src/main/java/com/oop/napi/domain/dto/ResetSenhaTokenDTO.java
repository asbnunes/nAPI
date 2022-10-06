package com.oop.napi.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ResetSenhaTokenDTO {

    private String token;

    @JsonProperty("created_date")
    private Date createdDate;
}
