package com.napi.domain.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


public class EmailController{

    private final static Logger LOGGER = LoggerFactory.
            getLogger(EmailController.class);

    private final JavaMailSender mailSender;

    public EmailController(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Async
    public void enviar(String to, String email) {
        try{
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper =
                    new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject("Alterar Senha");
            helper.setFrom("oop.napi@gmail.com");
        } catch (MessagingException e){
            LOGGER.error("falha ao enviar o email", e);
            throw new IllegalStateException("falha ao enviar o email");
        }
    }
}
