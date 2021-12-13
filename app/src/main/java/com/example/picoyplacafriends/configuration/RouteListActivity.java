package com.example.picoyplacafriends.configuration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.picoyplacafriends.R;
import com.example.picoyplacafriends.driversView.RouteApdater;
import com.example.picoyplacafriends.model.User;
import com.example.picoyplacafriends.utils.SpacingItemDecorator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Muestra la lista de routas predefinidas por el usuario
 */
public class RouteListActivity extends AppCompatActivity {

    // Variables globales para configurar el recyclerView.
    //LinearLayoutManager como los viewHolder se acomodan
    // en la pantalla, en este caso se ubicará uno debajo del otro.
    private LinearLayoutManager manager;
    private RecyclerView rvRouteListLibrary;
    private RouteApdater apdater;

    private Button btBackLR;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_list);

        user = (User) getIntent().getExtras().get("user");



        rvRouteListLibrary = findViewById(R.id.rvRouteListLibrary);
        btBackLR = findViewById(R.id.btBackV);

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


        btBackLR.setOnClickListener(this::goToBack);

    }


    private void goToBack(View view) {
        Intent intent = new Intent(this, ConfigurationCenterActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }



}