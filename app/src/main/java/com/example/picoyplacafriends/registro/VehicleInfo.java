package com.example.picoyplacafriends.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.picoyplacafriends.R;

public class VehicleInfo extends AppCompatActivity {

    private Button btNextVehicleInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_info);

        //Referencias de los atributos a inicializar
        btNextVehicleInfo = findViewById(R.id.btNextVehicleInfo);

        btNextVehicleInfo.setOnClickListener(v -> {
            //INTENT: Se lanza la actividad de correspondiente a la información personal de un usuario
            Intent intent = new Intent(this, PersonalInfoActivity.class);
            startActivity(intent);
        });


    }
}