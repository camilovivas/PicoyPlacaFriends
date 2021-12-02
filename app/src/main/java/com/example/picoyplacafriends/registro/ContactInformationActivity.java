package com.example.picoyplacafriends.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.picoyplacafriends.R;

public class ContactInformationActivity extends AppCompatActivity {

    private EditText txEPhoneNumber;
    private EditText txEVerificationCode;
    private Button btNextContactinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_information);

        //Referencias de los atributos a inicializar
        txEPhoneNumber = findViewById(R.id.txEPhoneNumber);
        txEVerificationCode = findViewById(R.id.txEVerificationCode);
        btNextContactinfo = findViewById(R.id.btNextContactinfo);

        btNextContactinfo.setOnClickListener( v -> {
            //INTENT: Se lanza la actividad de correspondiente a la información de un vehiculo
            Intent intent = new Intent(this, VehicleInfo.class);
            startActivity(intent);
        });
    }
}