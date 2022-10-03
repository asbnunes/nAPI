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

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Classe que implementa a interface EmailSender e seus metodos, contendo
 * as funcoes para enviar email.
 */
@AllArgsConstructor
@Service
public class EmailController implements EmailSender{

    /* instancia o Logger para fazer registros */
    private final static Logger LOGGER = LoggerFactory.
            getLogger(EmailController.class);

    /* instancia o JavaMailSender para enviar emails */
    private final JavaMailSender mailSender;

    /* funcao que envia email e trata de suas excecoes */
    @Override
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
