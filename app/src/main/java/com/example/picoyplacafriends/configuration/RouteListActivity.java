package com.example.picoyplacafriends.configuration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.picoyplacafriends.R;
import com.example.picoyplacafriends.driversView.RouteApdater;
import com.example.picoyplacafriends.utils.SpacingItemDecorator;

import android.os.Bundle;

public class RouteListActivity extends AppCompatActivity {

    // Variables globales para configurar el recyclerView.
    //LinearLayoutManager como los viewHolder se acomodan
    // en la pantalla, en este caso se ubicará uno debajo del otro.
    private LinearLayoutManager manager;

    private RecyclerView rvRouteListLibrary;

    private RouteApdater apdater;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_list);
        rvRouteListLibrary = findViewById(R.id.rvRouteListLibrary);

        //Proceso del linearLayout
        manager = new LinearLayoutManager(this);
        rvRouteListLibrary.setLayoutManager(manager);
        //Permite agregar espacio enter viewholders
        SpacingItemDecorator itemDecorator = new SpacingItemDecorator(20);
        rvRouteListLibrary.addItemDecoration(itemDecorator);
        //Proceso del recyclerView.
        apdater = new RouteApdater();
        rvRouteListLibrary.setAdapter(apdater);
        //Tamaño fijo del reciclerView
        rvRouteListLibrary.setHasFixedSize(true);



    }
}