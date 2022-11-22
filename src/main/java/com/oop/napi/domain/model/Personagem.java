package com.oop.napi.domain.model;

import javax.persistence.*;
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

    private String estilo;

    private int registroNinja;

    private String jutsu;

    @Column(name = "patente_ninja")
    private String patenteNinja;

    @Column(name = "dublador_jp")
    private String dubladorJapones;

    @Column(name = "dublador_pt")
    private String dubladorPortugues;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public int getRegistroNinja() {
        return registroNinja;
    }

    public void setRegistroNinja(int registroNinja) {
        this.registroNinja = registroNinja;
    }

    public String getJutsu() {
        return jutsu;
    }

    public void setJutsu(String jutsu) {
        this.jutsu = jutsu;
    }

    public String getPatenteNinja() {
        return patenteNinja;
    }

    public void setPatenteNinja(String patenteNinja) {
        this.patenteNinja = patenteNinja;
    }

    public String getDubladorJapones() {
        return dubladorJapones;
    }

    public void setDubladorJapones(String dubladorJapones) {
        this.dubladorJapones = dubladorJapones;
    }

    public String getDubladorPortugues() {
        return dubladorPortugues;
    }

    public void setDubladorPortugues(String dubladorPortugues) {
        this.dubladorPortugues = dubladorPortugues;
    }
}