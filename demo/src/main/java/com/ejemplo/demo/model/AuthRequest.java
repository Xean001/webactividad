package com.ejemplo.demo.model;

import lombok.AllArgsConstructor;   
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor

public class AuthRequest {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public void setUsername(String username) {
        this.username = username;
        }
    public void setPassword(String password) {
        this.password = password;
    }
}
