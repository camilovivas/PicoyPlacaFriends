package com.example.picoyplacafriends.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.picoyplacafriends.R;
import com.example.picoyplacafriends.model.User;
import com.google.firebase.firestore.FirebaseFirestore;

public class ContactInformationActivity extends AppCompatActivity {

    private EditText txEPhoneNumber;
    private EditText txEmail;
    private Button btNextContactinfo;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_information);
        db = FirebaseFirestore.getInstance(); // firebase
        //Referencias de los atributos a inicializar
        txEPhoneNumber = findViewById(R.id.txEPhoneNumber);
        txEmail = findViewById(R.id.txEmail);
        btNextContactinfo = findViewById(R.id.btNextContactinfo);
        btNextContactinfo.setOnClickListener(this::addContactInfo);
    }


    /**
     * Permite obtener los valores digitados por el usuario y registarla si no existe.
     */
    private void addContactInfo(View view) {
        String phoneNumber = txEPhoneNumber.getText().toString();
        String email = txEmail.getText().toString();
        db.collection("users").whereEqualTo("email", email).get().addOnCompleteListener(
                task -> {
                    if (!task.getResult().isEmpty()) {
                        Toast.makeText(this, "Este correo ya esta registrado", Toast.LENGTH_LONG).show();
                    } else {
                        User user = new User("", "","", email, phoneNumber, "");
                        db.collection("users").document(email).set(user);

                        //INTENT: Se lanza la actividad de correspondiente a la información de un vehiculo
                        Intent intent = new Intent(this, PersonalInfoActivity.class);
                        intent.putExtra("email", email);
                        startActivity(intent);
                    }
                }
        );
    }


}