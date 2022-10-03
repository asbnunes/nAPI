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

package com.napi.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Collections;

/**
 * Classe que implementa os dados de quem quer acessar
 * os conteudos da API, chamado de usuario.
 */
@EqualsAndHashCode
@Entity
@Getter
@Setter
public class UserData implements UserDetails {

    /**
     * ID do usuario. Incrementada automaticamente pelo
     * banco de dados em sua forma nativa.
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* email do usuario */
    @NotBlank
    @Email
    @Size(max = 255)
    private String email;

    private String nomeUsuario;

    /* senha do usuario */
    @NotBlank
    @Size(max = 255)
    private String senha;

    /**
     * O tipo de acesso do usuario. O valor somente pode ser
     * uma string.
     **/
    @Enumerated(EnumType.STRING)
    private UserAccessType userAccessType;

    /* instancia a classe UserData na memoria */
    public UserData(String nomeUsuario,
                    String email,
                    String senha,
                    UserAccessType userAccessType) {
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
        this.userAccessType = userAccessType;
    }

    /* concede aos usuarios autorizacoes, e as listam */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority autorizacao =
                new SimpleGrantedAuthority(userAccessType.name());
        return Collections.singletonList(autorizacao);
    }

    /* retorna a senha utilizada na autenticacao */
    @Override
    public String getPassword() {
        return senha;
    }

    /* retorna o email utilizado na autenticacao */
    @Override
    public String getUsername() {
        return email;
    }

    /* avalia se o login do usuario esta ativo ou nao */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /* avalia se o login do usuario esta bloqueado ou nao */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /* avalia se a senha do usuario esta expirada */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /* avalia se o usuario esta ativado ou desativado */
    @Override
    public boolean isEnabled() {
        return true;
    }
}