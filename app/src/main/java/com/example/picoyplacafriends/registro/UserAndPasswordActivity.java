package com.example.picoyplacafriends.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.picoyplacafriends.R;

public class UserAndPasswordActivity extends AppCompatActivity {


    private EditText txEEmail;
    private EditText txEPassword;
    private EditText txEChecktPassword;
    private Button btNextUserAndPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_and_password);
        //Referencias de los atributos a inicializar
        txEEmail = findViewById(R.id.txEEmail);
        txEPassword = findViewById(R.id.txEPassword);
        txEChecktPassword = findViewById(R.id.txEChecktPassword);
        btNextUserAndPassword = findViewById(R.id.btNextUserAndPassword);
    }

    /**
     * Permite obtener los valores digitados por el usuario correspondiente al usuario y contraseña
     */
    private void addUserAndPassword(){
        String email = txEEmail.getText().toString();
        String password = txEPassword.getText().toString();
        String checkPassword = txEChecktPassword.getText().toString();

        btNextUserAndPassword.setOnClickListener( v -> {
            if(password.equals(checkPassword)){
                //INTENT: Se lanza la actividad de correspondiente a la información de un vehiculo
                //Intent intent = new Intent(this, UserAndPasswordActivity.class);
                //startActivity(intent);
            }else{
                txEPassword.setText("");
                txEChecktPassword.setText("");
                Toast.makeText(this, "Las contraseñas no coinciden, por favor vuelva a escribirlas",Toast.LENGTH_LONG
                ).show();
            }
        });


    }




}