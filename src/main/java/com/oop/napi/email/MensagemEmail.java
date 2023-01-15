package com.oop.napi.domain.email;

import com.oop.napi.domain.model.Usuario;
import org.springframework.mail.SimpleMailMessage;

import java.util.List;

public class MensagemEmail extends SimpleMailMessage {
    private String remetente;
    private List<String> destinatario;
    private String assunto;
    private String corpo;

    public MensagemEmail(String remetente, List<String> destinatario, String assunto, String corpo) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.assunto = assunto;
        this.corpo = corpo;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public List<String> getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(List<String> destinatario) {
        this.destinatario = destinatario;
    }
}
