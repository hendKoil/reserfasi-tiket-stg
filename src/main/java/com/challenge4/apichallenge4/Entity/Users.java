package com.challenge4.apichallenge4.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity //mendeklarasikan sebagai Entity
@Table(name = "Users")
@Setter
@Getter

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_users")
    private int id_users;
    @Column(name = "username")
    private String username;
    @Column(name = "email" )
    private String email;
    @Column(name = "password")
    private String password;

//    @ManyToMany()
//    @JoinTable(
//            name = "customer_order",
//            joinColumns = @JoinColumn(name = "id_users"),
//            inverseJoinColumns = @JoinColumn(name = "schedules_id")
//    )
//    private List<Schedules> schedules;


    public Users() {
    }

    public Users(int id_users, String username, String email, String password) {
        this.id_users = id_users;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getId_users() {
        return id_users;
    }

    public void setId_users(int id_users) {
        this.id_users = id_users;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
