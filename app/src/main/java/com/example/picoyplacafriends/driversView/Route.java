package com.example.picoyplacafriends.driversView;

import android.widget.Button;

public class Route {
    //Identificador de la ruta
    private String idRoute;

    //Nombre de la ruta guardada, ejemplo: Universidad - Casa
    private String headBoard;

    //Permite acceder a la ruta que quiere usar
    private Button acceptRoute;

    public Route(String idRoute, String headBoard, Button acceptRoute) {
        this.idRoute = idRoute;
        this.headBoard = headBoard;
        this.acceptRoute = acceptRoute;
    }

    public String getIdRoute() {
        return idRoute;
    }

    public String getHeadBoard() {
        return headBoard;
    }

    public Button getAcceptRoute() {
        return acceptRoute;
    }
}
