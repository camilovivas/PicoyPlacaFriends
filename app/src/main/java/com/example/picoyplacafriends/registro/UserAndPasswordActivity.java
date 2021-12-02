package com.example.picoyplacafriends.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.picoyplacafriends.R;
import com.example.picoyplacafriends.logueo.LoginActivity;
import com.google.firebase.firestore.FirebaseFirestore;

public class UserAndPasswordActivity extends AppCompatActivity {

    private EditText txEPassword;
    private EditText txEChecktPassword;
    private Button btNextUserAndPassword;
    private String email;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_and_password);
        db = FirebaseFirestore.getInstance();
        email = getIntent().getExtras().getString("email");
        //Referencias de los atributos a inicializar
        txEPassword = findViewById(R.id.txEPassword);
        txEChecktPassword = findViewById(R.id.txEChecktPassword);
        btNextUserAndPassword = findViewById(R.id.btNextUserAndPassword);
        btNextUserAndPassword.setOnClickListener(this::addUserAndPassword);


    }

    /**
     * Permite obtener los valores digitados por el usuario correspondiente al usuario y contraseña
     */
    private void addUserAndPassword(View view){
        String password = txEPassword.getText().toString();
        String checkPassword = txEChecktPassword.getText().toString();

            if(password.equals(checkPassword)){
                //INTENT: Se lanza la actividad de correspondiente a la información de un vehiculo
                db.collection("users").document(email).update("password", password);
                db.collection("users").document(email).update("registryProgress", 4);
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
            }else{
                txEPassword.setText("");
                txEChecktPassword.setText("");
                Toast.makeText(this, "Las contraseñas no coinciden, por favor vuelva a escribirlas",Toast.LENGTH_LONG).show();
            }
    }




}