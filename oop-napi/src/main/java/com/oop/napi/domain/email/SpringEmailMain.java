package com.oop.napi.domain.email;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class SpringEmailMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                SpringEmailMain.class.getPackage().getName());

        Mailer mailer = applicationContext.getBean(Mailer.class);
        mailer.enviar(new MensagemEmail("Teste do napi <oop.napi@gmail.com>",
                Arrays.asList("Mais um teste do napi <oop.napi@gmail.com>"),
                "Sobre envio de email spring", "Olá! \n\n O envio do e-mail deu certo."));

        applicationContext.close();

        System.out.println("Fim!");
    }
}
