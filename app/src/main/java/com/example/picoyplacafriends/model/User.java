package com.example.picoyplacafriends.model;

public class User {

    private String name, lastname, documento, email, telefono, password;
    private int registryProgress;

    public User() {
    }

    public User(String name, String lastname,String documento, String email, String telefono, String password, int registryProgress) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.lastname = lastname;
        this.documento = documento;
        this.registryProgress = registryProgress;
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

    public String getLastname() {
        return lastname;
    }

    public String getDocumento() {
        return documento;
    }

    public int getRegistryProgress() {
        return registryProgress;
    }
}
