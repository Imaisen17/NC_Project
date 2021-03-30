package com.ivan.nc.shortenedlinksservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "authUser")
public class UserLogin {
    @Id
   private String login;

   private String password;

    public UserLogin() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserLogin(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
