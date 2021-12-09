package com.example.picoyplacafriends.registro;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.picoyplacafriends.R;
import com.example.picoyplacafriends.model.Vehicle;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

public class VehicleInfo extends AppCompatActivity implements TextWatcher {

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
        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);
        p3 = findViewById(R.id.p3);
        p4 = findViewById(R.id.p4);
        p5 = findViewById(R.id.p5);
        p6 = findViewById(R.id.p6);

        //Permite cambiar el foco entre editText correspondientes a la placa del vehiculo
        p1.addTextChangedListener(this);
        p2.addTextChangedListener(this);
        p3.addTextChangedListener(this);
        p4.addTextChangedListener(this);
        p5.addTextChangedListener(this);
        p6.addTextChangedListener(this);


        upFile = findViewById(R.id.upload);
        btModifyPlate = findViewById(R.id.btModifyPlate);
        archive = findViewById(R.id.archive);
        btNextVehicleInfo.setOnClickListener(this::addVehicle);
        upFile.setOnClickListener(this::openGallery);
        btModifyPlate.setOnClickListener(this::onActionBtModifyPlate);
        //validateEditTextsPlaca(p1);

    }

    /**
     * Este metodo permite eliminar todos los edits text correspondiente a la placa del vehiculo
     * @param view
     */
    private void onActionBtModifyPlate(View view){

        p1.setText("");
        p2.setText("");
        p3.setText("");
        p4.setText("");
        p5.setText("");
        p6.setText("");

        p1.setEnabled(true);
        p2.setEnabled(true);
        p3.setEnabled(true);
        p4.setEnabled(true);
        p5.setEnabled(true);
        p6.setEnabled(true);
        btModifyPlate.setVisibility(View.INVISIBLE);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    /**
     * Verifica constantemente que si el editText fue modificado.
     * @param s
     */
    @Override
    public void afterTextChanged(Editable s) {
        Log.v("<<s","Enter");
        if(p1.getText().length() ==1 && p1.isEnabled()){
            p2.requestFocus();
            p1.setEnabled(false);
        }else if(p2.getText().length() ==1 && p2.isEnabled()){
            p3.requestFocus();
            p2.setEnabled(false);
        }else if(p3.getText().length() ==1 && p3.isEnabled()){
            p4.requestFocus();
            p3.setEnabled(false);
        }else if(p4.getText().length() ==1 && p4.isEnabled()){
            p5.requestFocus();
            p4.setEnabled(false);
        }else if(p5.getText().length() ==1 && p5.isEnabled()){
            p6.requestFocus();
            p5.setEnabled(false);
        }else if(p6.getText().length() ==1 && p6.isEnabled()) {
            p6.setEnabled(false);
            btModifyPlate.setVisibility(View.VISIBLE);

        }
    }

    public void onFocusChange(View v, boolean hasFocus) {
        boolean change = true;
            if(hasFocus){
                while(change){
                    if(p1.getText().length() == 1){
                    p2.requestFocus();
                    Log.v("<<l","Enter");
                    change = false;
                }

            }
        }

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

        //INTENT: Se lanza la actividad de correspondiente a la información personal de un usuario
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