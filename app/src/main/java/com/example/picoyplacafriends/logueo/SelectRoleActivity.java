package com.example.picoyplacafriends.logueo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.picoyplacafriends.R;
import com.example.picoyplacafriends.configuration.ConfigurationCenterActivity;
import com.example.picoyplacafriends.driversView.AddRouteDriverActivity;
import com.example.picoyplacafriends.management.AddSelectRouteActivity;
import com.example.picoyplacafriends.model.User;

public class SelectRoleActivity extends AppCompatActivity {

    private TextView welcome;
    private User user;
    private Button btDriver, btPassager;
    private ImageView ivConfiguration, ivNotifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_role);

        btDriver = findViewById(R.id.btDriver);
        btPassager = findViewById(R.id.btPassager);
        welcome = findViewById(R.id.welcome);
        ivNotifications = findViewById(R.id.ivNotifications);
        ivConfiguration = findViewById(R.id.ivConfiguration);

        user = (User) getIntent().getExtras().get("user");
        welcome.setText("¡Bienvenido "+user.getName());

        btDriver.setOnClickListener(this::goToDriver);
        btPassager.setOnClickListener(this::goToPassager);
        ivConfiguration.setOnClickListener(this::goToConfiguration);



    }

    private void goToConfiguration(View view) {
        Intent intent = new Intent(this, ConfigurationCenterActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }

    private void goToPassager(View view) {
        Intent intent = new Intent(this, AddSelectRouteActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }

    private void goToDriver(View view) {
        Intent intent = new Intent(this, AddRouteDriverActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }




}