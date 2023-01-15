package com.oop.napi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;


@Entity
@ToString(exclude = "id")
@EqualsAndHashCode(exclude={"token","createdDate"})
public class ResetSenhaToken implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    @OneToOne(targetEntity = Usuario.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "id")
    private Usuario user;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public boolean isExpired(Long resetSenhaTokenExpirationMisiseg) {
        Calendar timeout = Calendar.getInstance();
        timeout.setTimeInMillis(this.createdDate.getTime() + resetSenhaTokenExpirationMisiseg);
        Date dateTimeout = timeout.getTime();
        return (dateTimeout.before(new Date()));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}