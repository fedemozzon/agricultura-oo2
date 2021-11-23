package oo2.agricultura.model;

import javax.persistence.*;
import java.util.Optional;

@Table(name = "login_user")
@Entity
public class LoginUser extends  User {
    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "mail", nullable = false)
    private String mail;

    @Transient
    private Strategy strategy;

    @Column(name = "idStrategy", nullable = false)
    private Long idStrategy;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public LoginUser() {

    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LoginUser(String username, String mail) {
        super();
        this.username = username;
        this.mail = mail;
    }

    public LoginUser(String username, String mail, Strategy strategy) {
        this.username = username;
        this.mail = mail;
        this.strategy = strategy;
        this.idStrategy = new Long(1);
    }

    public Long getIdStrategy() {
        return idStrategy;
    }

    public void setIdStrategy(Long idStrategy) {
        this.idStrategy = idStrategy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Strategy getStrategy() {
        return strategy;
    }


    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}