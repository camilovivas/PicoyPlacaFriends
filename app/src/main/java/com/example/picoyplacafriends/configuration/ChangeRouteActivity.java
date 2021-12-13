package com.example.picoyplacafriends.configuration;

import androidx.appcompat.app.AppCompatActivity;
import com.example.picoyplacafriends.R;
import com.example.picoyplacafriends.model.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Permite cambiar las rutas predefinidas de un usuario
 */
public class ChangeRouteActivity extends AppCompatActivity {

    private EditText etChangePlaque, etNewOrigen, etNewDestino;
    private Button btLoadNewLicenseDriver, btBackR;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_route);

        user = (User) getIntent().getExtras().get("user");
        
        btBackR = findViewById(R.id.btBackV);

        btBackR.setOnClickListener(this::goToBack);

    }

    private void goToBack(View view) {
        Intent intent = new Intent(this, ConfigurationCenterActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }

}