package com.example.picoyplacafriends.model;

public class Vehicle {
    private String placa;
    private String tarjetaPropiedadId;

    public Vehicle() {
    }

    public Vehicle(String placa, String tarjetaPropiedadId) {
        this.placa = placa;
        this.tarjetaPropiedadId = tarjetaPropiedadId;
    }

    public String getPlaca() {
        return placa;
    }

    public String getTarjetaPropiedadId() {
        return tarjetaPropiedadId;
    }
}
