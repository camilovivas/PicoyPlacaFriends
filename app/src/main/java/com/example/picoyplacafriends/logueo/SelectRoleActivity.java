package com.example.picoyplacafriends.logueo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.picoyplacafriends.R;
import com.example.picoyplacafriends.management.AddSelectRouteActivity;
import com.example.picoyplacafriends.model.User;

public class SelectRoleActivity extends AppCompatActivity {

    private TextView welcome;
    private User user;
    private Button btDriver, btPassager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_role);

        btDriver = findViewById(R.id.btDriver);
        btPassager = findViewById(R.id.btPassager);
        welcome = findViewById(R.id.welcome);

        user = (User) getIntent().getExtras().get("user");
        welcome.setText("¡Bienvenido "+user.getName());

        btDriver.setOnClickListener(this::goDriver);


    }

    private void goDriver(View view) {
        Intent intent = new Intent(this, AddSelectRouteActivity.class);
        startActivity(intent);
    }


}