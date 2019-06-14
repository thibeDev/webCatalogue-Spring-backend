package com.thibaut.catservice.web;

import com.thibaut.catservice.entities.AppUser;
import com.thibaut.catservice.services.AccountService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private AccountService accountService;
    @PostMapping("/register")
    public AppUser register(@RequestBody RegistrationForm registrationForm){
        return  accountService.saveUser(registrationForm.getUsername(),registrationForm.getPassword(),registrationForm.getRepassword());
    }

}




