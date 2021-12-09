package com.example.picoyplacafriends.configuration;

import androidx.appcompat.app.AppCompatActivity;
import com.example.picoyplacafriends.R;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ConfigurationCenterActivity extends AppCompatActivity {

    private Button btInformationUser, btChangeVehicle, btChangeRoute, btRouteList, btLogout;
    private TextView tvFrequentQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration_center);
    }



}