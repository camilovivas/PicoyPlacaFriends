package com.example.picoyplacafriends.configuration;

import androidx.appcompat.app.AppCompatActivity;
import com.example.picoyplacafriends.R;
import com.example.picoyplacafriends.logueo.LoginActivity;
import com.example.picoyplacafriends.management.AddSelectRouteActivity;
import com.example.picoyplacafriends.model.User;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Esta actividad muestra la lista de configuraciones
 */
public class ConfigurationCenterActivity extends AppCompatActivity {

    private Button btInformationUser, btChangeVehicle, btChangeRoute, btRouteList, btLogout;
    private TextView tvFrequentQuestions;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration_center);

        user = (User) getIntent().getExtras().get("user");

        btInformationUser = findViewById(R.id.btInformationUser);
        btChangeVehicle = findViewById(R.id.btChangeVehicle);
        btChangeRoute = findViewById(R.id.btChangeRoute);
        btRouteList = findViewById(R.id.btRouteList);
        btLogout = findViewById(R.id.btLogout);
        tvFrequentQuestions = findViewById(R.id.tvFrequentQuestions);

        btInformationUser.setOnClickListener(this::goToInformationUser);
        btChangeVehicle.setOnClickListener(this::gotToChangeVehicle);
        btChangeRoute.setOnClickListener(this::gotToChangeRoute);
        btRouteList.setOnClickListener(this::gotToRouteList);
        btLogout.setOnClickListener(this::gotToLogout);
        tvFrequentQuestions.setOnClickListener(this::gotToFrequentQuestions);


    }

    private void gotToFrequentQuestions(View view) {
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
    }


    private void gotToLogout(View view) {
        LoginManager.getInstance().logOut();
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private void gotToRouteList(View view) {
        Intent intent = new Intent(this, RouteListActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }

    private void gotToChangeRoute(View view) {
        Intent intent = new Intent(this, ChangeRouteActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }

    private void gotToChangeVehicle(View view) {
        Intent intent = new Intent(this, ChangeVehicleActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }

    private void goToInformationUser(View view) {
        Intent intent = new Intent(this, InformationUserResumeActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }




}