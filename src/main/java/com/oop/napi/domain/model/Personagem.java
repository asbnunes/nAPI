package com.oop.napi.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity(name = "Personagem")
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 60)
    private String nome;

    private String sexo;

    private String cla;

    private String aldeia;

    private String registroNinja;

    private String patenteNinja;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCla() {
        return cla;
    }

    public void setCla(String cla) {
        this.cla = cla;
    }

    public String getAldeia() {
        return aldeia;
    }

    public void setAldeia(String aldeia) {
        this.aldeia = aldeia;
    }

    public String getRegistroNinja() {
        return registroNinja;
    }

    public void setRegistroNinja(String registroNinja) {
        this.registroNinja = registroNinja;
    }

    public String getPatenteNinja() {
        return patenteNinja;
    }

    public void setPatenteNinja(String patenteNinja) {
        this.patenteNinja = patenteNinja;
    }
}
