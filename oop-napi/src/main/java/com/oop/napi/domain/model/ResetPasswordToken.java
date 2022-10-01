package com.oop.napi.domain.model;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@ToString(exclude="id")
@EqualsAndHashCode(exclude={"token","createdDate"})
public class ResetPasswordToken implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tokenId;

    private String token;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public void setUser(Optional<Usuario> user) {
        this.user = user;
    }

    @OneToOne(targetEntity = Usuario.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "id")
    private Optional<Usuario> user;

    public boolean isExpired(Long resetPasswordTokenExpirationMisiseg) {
        Calendar timeout = Calendar.getInstance();
        timeout.setTimeInMillis(this.createdDate.getTime() + resetPasswordTokenExpirationMisiseg);
        Date dateTimeout = timeout.getTime();
        return (dateTimeout.before(new Date()));
    }

    public Integer getTokenId() {
        return tokenId;
    }

    public void setTokenId(Integer tokenId) {
        this.tokenId = tokenId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Optional<Usuario> getUser() {
        return user;
    }
}