package com.example.Cinema.DTO;

public class LoginDTO {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private LoginDTO(){

    }

    public LoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
