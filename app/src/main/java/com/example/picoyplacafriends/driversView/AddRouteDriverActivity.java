package com.example.picoyplacafriends.driversView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.picoyplacafriends.R;
import com.example.picoyplacafriends.utils.SpacingItemDecorator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 *
 */
public class AddRouteDriverActivity extends AppCompatActivity {

    private TextView tVbalance;
    private EditText eTextRouteOfOrigin,eTextRouteOfDestination,eTextComments;
    private ImageView iVConfig;
    private Button btGetBack;
    private RecyclerView routesRecycler;

    // Variables globales para configurar el recyclerView.
    //LinearLayoutManager como los viewHolder se acomodan
    // en la pantalla, en este caso se ubicará uno debajo del otro.
    private LinearLayoutManager manager;
    //Fabrica de viewHolders.
    private RouteApdater apdater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_route);

        //Inicialización de atributos
        tVbalance = findViewById(R.id.tVbalance);
        eTextRouteOfOrigin = findViewById(R.id.eTextRouteOfOrigin);
        eTextRouteOfDestination = findViewById(R.id.eTextRouteOfDestination);
        eTextComments = findViewById(R.id.eTextComments);
        iVConfig = findViewById(R.id.iVConfig);
        tVbalance = findViewById(R.id.tVbalance);
        btGetBack = findViewById(R.id.btGetBack);
        routesRecycler = findViewById(R.id.routesRecycler);

        //Proceso del linearLayout
        manager = new LinearLayoutManager(this);
        routesRecycler.setLayoutManager(manager);

        /*
        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(routesRecycler.getContext(),
                manager.getOrientation());
        routesRecycler.addItemDecoration(mDividerItemDecoration);
*/
        SpacingItemDecorator itemDecorator = new SpacingItemDecorator(20);
        routesRecycler.addItemDecoration(itemDecorator);
        //Proceso del recyclerView.
        apdater = new RouteApdater();
        routesRecycler.setAdapter(apdater);
        //Tamaño fijo del reciclerView
        routesRecycler.setHasFixedSize(true);



    }
}