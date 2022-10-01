package com.oop.napi.domain.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class Mailer {

    @Autowired
    private JavaMailSender javaMailSender;

    public void enviar(MensagemEmail mensagemEmail) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom(mensagemEmail.getRemetente());
        simpleMailMessage.setTo(mensagemEmail.getDestinatario()
                .toArray(new String[mensagemEmail.getDestinatario().size()]));
        simpleMailMessage.setSubject(mensagemEmail.getAssunto());
        simpleMailMessage.setText(mensagemEmail.getCorpo());

        javaMailSender.send(simpleMailMessage);
    }
}
