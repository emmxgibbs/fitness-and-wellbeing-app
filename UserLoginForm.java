package com.team4.fitness_and_wellbeing.model;

public class UserLoginForm {
    private String email;
    private String password;

    public UserLoginForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
