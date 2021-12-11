package com.example.picoyplacafriends.configuration;

import androidx.appcompat.app.AppCompatActivity;
import com.example.picoyplacafriends.R;
import com.example.picoyplacafriends.utils.VehiclePlate;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ChangeVehicleActivity extends AppCompatActivity {

    private EditText pl1,pl2,pl3,pl4,pl5,pl6;
    private ImageView ivNewLicenseDriver;
    private Button btModifyPlateChVehicle;
    private Button btBack,btLoadNewLicenseDriver,btUpdateInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_vehicle);
        //Inicialzación de caracteres de la placa
        pl1 = findViewById(R.id.pl1);
        pl2 = findViewById(R.id.pl2);
        pl3 = findViewById(R.id.pl3);
        pl4 = findViewById(R.id.pl4);
        pl5 = findViewById(R.id.pl5);
        pl6 = findViewById(R.id.pl6);

        //Inicialización de imageView
        ivNewLicenseDriver = findViewById(R.id.ivNewLicenseDriver);

        //Inicialización de botones
        btModifyPlateChVehicle = findViewById(R.id.btModifyPlateChVehicle);
        btLoadNewLicenseDriver = findViewById(R.id.btLoadNewLicenseDriver);
        btBack = findViewById(R.id.btBack);
        // Se le agrega la acción a cada uno de los editText
        VehiclePlate vehiclePlate = new VehiclePlate(pl1,pl2,pl3,pl4,pl5,pl6,btModifyPlateChVehicle);
        pl1.addTextChangedListener(vehiclePlate);
        pl2.addTextChangedListener(vehiclePlate);
        pl3.addTextChangedListener(vehiclePlate);
        pl4.addTextChangedListener(vehiclePlate);
        pl5.addTextChangedListener(vehiclePlate);
        pl6.addTextChangedListener(vehiclePlate);



    }
}