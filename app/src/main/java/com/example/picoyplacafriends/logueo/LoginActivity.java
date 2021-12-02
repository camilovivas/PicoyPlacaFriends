package com.example.picoyplacafriends.logueo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.picoyplacafriends.R;
import com.example.picoyplacafriends.model.User;
import com.example.picoyplacafriends.registro.DataPolicyActivity;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private TextView tvForgetPassword;
    private Button btLogin;
    private TextView tvRegister;

    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = FirebaseFirestore.getInstance();
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        tvForgetPassword = findViewById(R.id.tvForgetPassword);
        btLogin = findViewById(R.id.btLogin);
        tvRegister = findViewById(R.id.tvRegister);

        tvRegister.setOnClickListener(this::register);
        btLogin.setOnClickListener(this::login);

    }

    private void login(View view) {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        Query query = db.collection("users").whereEqualTo("email", email);
        query.get().addOnCompleteListener(
                task -> {
                    if (!task.getResult().isEmpty()) {
                        for (DocumentSnapshot ds : task.getResult()) {
                            User user = ds.toObject(User.class);
                            if(user.isAprobado() == true){
                                if (user.getPassword().equals(password)) {
                                    Intent i = new Intent(this, SelectRoleActivity.class);
                                    i.putExtra("user", user);
                                    startActivity(i);
                                } else {
                                    Toast.makeText(this, "constraseña incorrecta", Toast.LENGTH_LONG).show();
                                }
                            }
                            else{
                                Toast.makeText(this, "Todavia estas aprovado, intentalo mas tarde", Toast.LENGTH_LONG).show();
                            }
                            break;
                        }
                    }
                    else{
                        Toast.makeText(this, "Correo o constraseña incorrectos", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    private void register(View view) {
        Intent intent = new Intent(this, DataPolicyActivity.class);
        startActivity(intent);
    }


}