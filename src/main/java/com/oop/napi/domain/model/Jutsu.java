package com.oop.napi.domain.model;

import javax.persistence.*;

@Entity
public class Jutsu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jutsu")
    private Long idJutsu;

    @Column(name = "nome_jutsu")
    private String nomeJutsu;

    @ManyToOne(fetch = FetchType.EAGER)
    private Personagem personagem;

    public Long getIdJutsu() {
        return idJutsu;
    }

    public void setIdJutsu(Long idJutsu) {
        this.idJutsu = idJutsu;
    }

    public String getNomeJutsu() {
        return nomeJutsu;
    }

    public void setNomeJutsu(String nomeJutsu) {
        this.nomeJutsu = nomeJutsu;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }
}
