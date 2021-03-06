package com.example.picoyplacafriends.registro;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.picoyplacafriends.R;
import com.example.picoyplacafriends.model.Vehicle;
import com.example.picoyplacafriends.utils.VehiclePlate;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

public class VehicleInfo extends AppCompatActivity{

    private String email;
    private String placa;
    private Vehicle vehicle;
    private FirebaseFirestore db;

    private ActivityResultLauncher<Intent> launcher;
    private TextView archive;
    private EditText p1, p2, p3, p4, p5, p6;
    private Button btNextVehicleInfo, btModifyPlate, upFile;


    private String fileName;
    private Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_info);
        email = getIntent().getExtras().getString("email");
        vehicle = new Vehicle();
        db = FirebaseFirestore.getInstance();
        launcher = registerForActivityResult(new StartActivityForResult(), this::galleryResult);
        //Referencias de los atributos a inicializar
        btNextVehicleInfo = findViewById(R.id.btNextVehicleInfo);
        p1 = findViewById(R.id.pl1);
        p2 = findViewById(R.id.pl2);
        p3 = findViewById(R.id.pl3);
        p4 = findViewById(R.id.pl4);
        p5 = findViewById(R.id.pl5);
        p6 = findViewById(R.id.pl6);
        btModifyPlate = findViewById(R.id.btModifyPlate);


        //Permite cambiar el foco entre editText correspondientes a la placa del vehiculo
        VehiclePlate vehiclePlate = new VehiclePlate(p1,p2,p3,p4,p5,p6,btModifyPlate);
        p1.addTextChangedListener(vehiclePlate);
        p2.addTextChangedListener(vehiclePlate);
        p3.addTextChangedListener(vehiclePlate);
        p4.addTextChangedListener(vehiclePlate);
        p5.addTextChangedListener(vehiclePlate);
        p6.addTextChangedListener(vehiclePlate);

        upFile = findViewById(R.id.upload);
        archive = findViewById(R.id.archive);
        btNextVehicleInfo.setOnClickListener(this::addVehicle);
        upFile.setOnClickListener(this::openGallery);
        //validateEditTextsPlaca(p1);

    }

    private void galleryResult(ActivityResult result) {
        if (result.getResultCode() == RESULT_OK) {
            uri = result.getData().getData();
            fileName = "tarjeta" + placa;
            archive.setText(uri.toString());
            vehicle.setTarjetaPropiedadId(fileName);
        }
    }

    public void addVehicle(View view) {
        vehicle.setPlaca(placa);
        db.collection("users").document(email).collection("vehicle").document(placa).set(vehicle);
        db.collection("users").document(email).update("registryProgress", 3);
        db.collection("users").document(email).update("tarjetaPropiedad", fileName);
        FirebaseStorage.getInstance().getReference().child("documentos").child(fileName).putFile(uri);

        //INTENT: Se lanza la actividad de correspondiente a la informaci??n personal de un usuario
        Intent intent = new Intent(this, UserAndPasswordActivity.class);
        intent.putExtra("email", email);
        startActivity(intent);

    }



    public void openGallery(View view) {
        placa = p1.getText().toString() + p2.getText().toString() + p3.getText().toString() + p4.getText().toString() + p5.getText().toString() + p6.getText().toString();
        if (placa.split("").length == 6) {
            Intent i = new Intent(Intent.ACTION_GET_CONTENT);
            i.setType("application/pdf");
            launcher.launch(i);
        } else {
            Toast.makeText(this, "escribe la placa primero", Toast.LENGTH_LONG).show();
        }

    }



}