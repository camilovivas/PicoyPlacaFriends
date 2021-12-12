package com.example.picoyplacafriends.model;

import java.io.Serializable;

public class User implements Serializable {

    private String id, name, lastname, documento, email, telefono, password, tarjetaPropiedad;
    private int registryProgress;
    private boolean aprobado;

    public User() {
    }

    public User(String id, String name, String lastname,String documento, String email, String telefono, String password, String tarjetaPropiedad, boolean aprobado, int registryProgress) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.lastname = lastname;
        this.documento = documento;
        this.tarjetaPropiedad = tarjetaPropiedad;
        this.aprobado = aprobado;
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

    public String getTarjetaPropiedad() {
        return tarjetaPropiedad;
    }

    public boolean isAprobado() {
        return aprobado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTarjetaPropiedad(String tarjetaPropiedad) {
        this.tarjetaPropiedad = tarjetaPropiedad;
    }

    public void setRegistryProgress(int registryProgress) {
        this.registryProgress = registryProgress;
    }

    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }

}
