package com.example.picoyplacafriends.configuration;

import androidx.appcompat.app.AppCompatActivity;
import com.example.picoyplacafriends.R;
import com.example.picoyplacafriends.model.User;
import com.example.picoyplacafriends.utils.VehiclePlate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Esta actividad se encarga de cambiar la información de un vehiculo
 */
public class ChangeVehicleActivity extends AppCompatActivity {

    private EditText pl1,pl2,pl3,pl4,pl5,pl6;
    private ImageView ivNewLicenseDriver;
    private Button btModifyPlateChVehicle;
    private Button btBackV,btLoadNewLicenseDriver,btUpdateInfo;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_vehicle);

        user = (User) getIntent().getExtras().get("user");


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
        btBackV = findViewById(R.id.btBackV);

        btBackV.setOnClickListener(this::goToBack);

        // Se le agrega la acción a cada uno de los editText
        VehiclePlate vehiclePlate = new VehiclePlate(pl1,pl2,pl3,pl4,pl5,pl6,btModifyPlateChVehicle);
        pl1.addTextChangedListener(vehiclePlate);
        pl2.addTextChangedListener(vehiclePlate);
        pl3.addTextChangedListener(vehiclePlate);
        pl4.addTextChangedListener(vehiclePlate);
        pl5.addTextChangedListener(vehiclePlate);
        pl6.addTextChangedListener(vehiclePlate);

    }

    private void goToBack(View view) {
        Intent intent = new Intent(this, ConfigurationCenterActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }
}