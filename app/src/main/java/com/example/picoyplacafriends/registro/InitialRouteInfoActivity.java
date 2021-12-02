package com.example.picoyplacafriends.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.picoyplacafriends.R;

public class InitialRouteInfoActivity extends AppCompatActivity {

    private EditText txEEndTime;
    private EditText txEStartTime;
    private EditText txEEndAddress;
    private EditText txEStartAddress;
    private Button btSkip;
    private Button btNextInitialRoute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_route_info);
        //Referencias de los atributos a inicializar
        txEEndTime = findViewById(R.id.txEEndTime);
        txEStartTime = findViewById(R.id.txEStartTime);
        txEEndAddress = findViewById(R.id.txEEndAddress);
        txEStartAddress = findViewById(R.id.txEStartAddress);
        btSkip = findViewById(R.id.btSkip);
        btNextInitialRoute = findViewById(R.id.btNextInitialRoute);
    }

    /**
     * Este metodo permite añadir al usuario una ruta inicial durante el
     * proceso de registro
     */
    private void addInitialRoute(){
        String endTime = txEEndTime.getText().toString();
        String startTime = txEStartTime.getText().toString();
        String endAddress= txEEndAddress.getText().toString();
        String startAddress = txEStartAddress.getText().toString();

        btSkip.setOnClickListener( v -> {
            // Aquí va la opción del boton de omitir
        });

        btNextInitialRoute.setOnClickListener( v-> {
            // Aquí va la opción del boton de siguiente.
        });


    }

}