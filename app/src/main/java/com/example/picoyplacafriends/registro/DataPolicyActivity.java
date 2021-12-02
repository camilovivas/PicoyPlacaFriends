package com.example.picoyplacafriends.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.picoyplacafriends.R;

public class DataPolicyActivity extends AppCompatActivity {

    private TextView tVmoreDetails;
    private Button btAcceptDataPolicy;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_policy);
        //Referencias de los atributos a inicializar
        tVmoreDetails = findViewById(R.id.tVmoreDetails);
        btAcceptDataPolicy = findViewById(R.id.btAcceptDataPolicy);

        btAcceptDataPolicy.setOnClickListener( v -> {
            //INTENT: Se lanza la actividad de correspondiente a la información del usuario
            Intent intent = new Intent(this, ContactInformationActivity.class);
            startActivity(intent);
        });

    }



}