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
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

public class VehicleInfo extends AppCompatActivity {

    private String email;
    private String placa;
    private Vehicle vehicle;
    private FirebaseFirestore db;

    private ActivityResultLauncher<Intent> launcher;
private TextView archive;
    private EditText p1, p2, p3, p4, p5, p6;
    private Button btNextVehicleInfo, upFile;
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
        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);
        p3 = findViewById(R.id.p3);
        p4 = findViewById(R.id.p4);
        p5 = findViewById(R.id.p5);
        p6 = findViewById(R.id.p6);
        upFile = findViewById(R.id.upload);
        archive = findViewById(R.id.archive);
//        btNextVehicleInfo.setOnClickListener(v -> {
//            //INTENT: Se lanza la actividad de correspondiente a la información personal de un usuario
//            Intent intent = new Intent(this, PersonalInfoActivity.class);
//            startActivity(intent);
//        });
        upFile.setOnClickListener(this::openGallery);

    }

    private void galleryResult(ActivityResult result) {
        if(result.getResultCode() == RESULT_OK){
            Uri uri =result.getData().getData();

            String fileName = "tarjeta "+placa;
            archive.setText(uri.toString());
            FirebaseStorage.getInstance().getReference().child("documentos").child(fileName).putFile(uri);
            vehicle.setTarjetaPropiedadId(fileName);
        }
    }

    public void addVehicle(){
        vehicle.setPlaca(placa);
        db.collection("users").document(email).collection("vehicle").document(placa).set(vehicle);
    }

    public void openGallery(View view){
        placa = p1.getText().toString()+p2.getText().toString()+p3.getText().toString()+p4.getText().toString()+p5.getText().toString()+p6.getText().toString();
        if(placa.split("").length == 6){
            Intent i = new Intent(Intent.ACTION_GET_CONTENT);
            i.setType("application/pdf");
            launcher.launch(i);
        }
        else{
            Toast.makeText(this,"escribe la placa primero", Toast.LENGTH_LONG).show();
        }

    }
}