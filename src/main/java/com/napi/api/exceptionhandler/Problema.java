package com.napi.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

public class Problema {
    private int status;
    private LocalDateTime dataHora;
    private String titulo;
    private List<Campo> campo;

    public static class Campo {
        private String nome;
        private String mensagem;

        public Campo(String nome, String mensagem) {
            this.nome = nome;
            this.mensagem = mensagem;
        }

        public String getNome() {
            return nome;
        }

        public String getMensagem() {
            return mensagem;
        }
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Campo> getCampo() {
        return campo;
    }

    public void setCampo(List<Campo> campo) {
        this.campo = campo;
    }
}
