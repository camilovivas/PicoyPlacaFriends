package com.example.picoyplacafriends.logueo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.picoyplacafriends.R;
import com.example.picoyplacafriends.model.User;

public class SelectRoleActivity extends AppCompatActivity {

    private TextView welcome;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_role);
        welcome = findViewById(R.id.welcome);
        user = (User) getIntent().getExtras().get("user");
        welcome.setText("¡Bienvenido "+user.getName());
    }
}