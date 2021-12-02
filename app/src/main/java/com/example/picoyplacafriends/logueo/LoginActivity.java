package com.example.picoyplacafriends.logueo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.picoyplacafriends.R;
import com.example.picoyplacafriends.registro.DataPolicyActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private TextView tvForgetPassword;
    private Button btLogin;
    private TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        tvForgetPassword = findViewById(R.id.tvForgetPassword);
        btLogin = findViewById(R.id.btLogin);
        tvRegister = findViewById(R.id.tvRegister);

        tvRegister.setOnClickListener(this::register);

    }

    private void register(View view) {
        Intent intent = new Intent(this, DataPolicyActivity.class);
        startActivity(intent);
    }


}