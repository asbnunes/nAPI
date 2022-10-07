package com.oop.napi.domain.services;

import com.oop.napi.api.exceptionhandler.FieldMessage;
import com.oop.napi.domain.dto.ResetSenhaDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ResetSenhaSaveValidator implements ConstraintValidator<ResetSenhaSave,
        ResetSenhaDTO> {

    @Override
    public void initialize(ResetSenhaSave ann) {
    }

    @Override
    public boolean isValid(ResetSenhaDTO objDto, ConstraintValidatorContext context) {
        List<FieldMessage> erros = new ArrayList<>();

        if(!objDto.getSenha().equals(objDto.getConfirmaSenha())) {
            erros.add(new FieldMessage("Senha","não confere"));        }

        for (FieldMessage e : erros) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return erros.isEmpty();
    }
}
