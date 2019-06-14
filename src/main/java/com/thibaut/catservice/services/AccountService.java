package com.thibaut.catservice.services;

import com.thibaut.catservice.entities.AppRole;
import com.thibaut.catservice.entities.AppUser;

public interface AccountService {
    AppUser saveUser(String username,String password,String confirmedPassword);
    AppRole saveRole(AppRole role);
    AppUser findByUserName(String username);
    void addRoleToUser(String username, String role);
}
