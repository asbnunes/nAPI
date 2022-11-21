package com.oop.napi.domain.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 60)
    private String nome;

    private String sexo;

    private String cla;

    private String aldeia;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personagem", fetch = FetchType.EAGER)
    private Set<Jutsu> jutsu;

    private String registroNinja;

    private String patenteNinja;

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

    public Set<Jutsu> getJutsu() {
        return jutsu;
    }

    public void setJutsu(Set<Jutsu> jutsu) {
        this.jutsu = jutsu;
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
