package com.ivan.nc.shortenedlinksservice.interfaces;

import com.ivan.nc.shortenedlinksservice.entity.UserLogin;

public interface UserLoginService {
    UserLogin getUserByLogin(String login);

    void createUser(UserLogin userLogin);
}
