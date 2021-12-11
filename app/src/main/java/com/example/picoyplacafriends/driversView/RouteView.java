package com.example.picoyplacafriends.driversView;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.picoyplacafriends.R;

 /**
 * Esta clase es el modelo del renglon del recyclerView, en otras palabras, es el borde del viewHolders
 */
public class RouteView extends RecyclerView.ViewHolder {

    //Atributos del xml defaultRoute
    private TextView tVHeadBoard;
    private Button btAcceptRoute;


    public RouteView(@NonNull View itemView) {
        super(itemView);
        tVHeadBoard = itemView.findViewById(R.id.tVHeadBoard);
        btAcceptRoute = itemView.findViewById(R.id.btAcceptRoute);
    }

     public TextView gettVHeadBoard() {
         return tVHeadBoard;
     }

     public Button getBtAcceptRoute() {
         return btAcceptRoute;
     }

     public void setBtAcceptRoute(Button btAcceptRoute) {
         this.btAcceptRoute = btAcceptRoute;
     }
 }
