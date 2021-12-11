package com.example.picoyplacafriends.driversView;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.picoyplacafriends.R;

 /**
 * Esta clase es el modelo del renglon del recyclerView, en otras palabras, es el borde del viewHolders
 */
public class RouteView extends RecyclerView.ViewHolder {

    //Atributos del xml defaultRoute
    private TextView tVHeadBoard;


    public RouteView(@NonNull View itemView) {
        super(itemView);
        tVHeadBoard = itemView.findViewById(R.id.tVHeadBoard);
        itemView.findViewById(R.id.btAcceptRoute).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("<<a",tVHeadBoard.getText().toString());
            }
        });

    }

     public TextView gettVHeadBoard() {
         return tVHeadBoard;
     }



 }
