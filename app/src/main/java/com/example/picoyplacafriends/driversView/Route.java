package com.example.picoyplacafriends.driversView;

import android.widget.Button;

public class Route {
    //Identificador de la ruta
    private String idRoute;

    //Nombre de la ruta guardada, ejemplo: Universidad - Casa
    private String headBoard;

    public Route(String idRoute, String headBoard) {
        this.idRoute = idRoute;
        this.headBoard = headBoard;
    }

    public String getIdRoute() {
        return idRoute;
    }

    public String getHeadBoard() {
        return headBoard;
    }

}
