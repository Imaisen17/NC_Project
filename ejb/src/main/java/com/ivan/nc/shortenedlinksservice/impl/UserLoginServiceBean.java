package com.ivan.nc.shortenedlinksservice.impl;

import com.ivan.nc.shortenedlinksservice.entity.UserLogin;
import com.ivan.nc.shortenedlinksservice.interfaces.UserLoginService;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserLoginServiceBean implements UserLoginService {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public UserLogin getUserByLogin(String login) {
    UserLogin user = entityManager.find(UserLogin.class, login);
    return user;
    }

    @Override
    public void createUser(UserLogin userLogin) {
        entityManager.persist(userLogin);
    }
}
