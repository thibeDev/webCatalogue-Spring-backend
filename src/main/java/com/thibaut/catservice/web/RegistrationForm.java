package com.thibaut.catservice.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class RegistrationForm {
    private String username;
    private String password;
    private String repassword;
}
