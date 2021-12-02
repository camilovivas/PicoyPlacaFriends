package com.example.picoyplacafriends.model;

public class User {

    private String name, email, telefono, password;

    public User() {
    }

    public User(String name, String email, String telefono, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getTelefono() {
        return telefono;
    }
}
