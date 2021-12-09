package com.example.picoyplacafriends.configuration;

import androidx.appcompat.app.AppCompatActivity;
import com.example.picoyplacafriends.R;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ChangeRouteActivity extends AppCompatActivity {

    private EditText etChangePlaque, etNewOrigen, etNewDestino;
    private Button btLoadNewLicenseDriver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_route);
    }
}