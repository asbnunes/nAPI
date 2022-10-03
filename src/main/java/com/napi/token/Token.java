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
package com.napi.token;

import com.napi.user.UserData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Classe que define as caracteristicas de um token em um banco de dados.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Token {

    /**
     * ID do token. Incrementada automaticamente pelo
     * banco de dados em sua forma nativa.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* o token em si, campo nao nulo */
    @Column(nullable = false)
    private String token;

    /* o momento de criacao do token, campo nao nulo */
    @Column(nullable = false)
    private LocalDateTime timeCreated;

    /* o momento de expiracao do token, campo nao nulo */
    @Column(nullable = false)
    private LocalDateTime timeExpiration;

    /* o momento de confirmacao do token, campo nao nulo */
    @Column(nullable = false)
    private LocalDateTime timeConfirmed;

    /** informacao do usuario que pediu o token.
     * O usuario pode ter pedido um token mais de uma vez.
     */
    @ManyToOne
    private UserData userData;

    /* instancia o token na memoria */
    public Token(String token,
                 LocalDateTime timeCreated,
                 LocalDateTime timeExpiration,
                 UserData userData) {
        this.token = token;
        this.timeCreated = timeCreated;
        this.timeExpiration = timeExpiration;
        this.userData = userData;
    }

}
