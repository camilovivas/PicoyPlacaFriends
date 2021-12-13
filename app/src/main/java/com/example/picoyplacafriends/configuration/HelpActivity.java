package com.example.picoyplacafriends.configuration;

import androidx.appcompat.app.AppCompatActivity;
import com.example.picoyplacafriends.R;
import com.example.picoyplacafriends.model.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Esta actividad muestra las opciones de ayuda
 */
public class HelpActivity extends AppCompatActivity {

    private TextView tvFrequentQuestions, tvHelpChat, tvWhatsappLink, tvOfficialPage;
    private Button btBackH;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        user = (User) getIntent().getExtras().get("user");

        btBackH = findViewById(R.id.btBackV);
        btBackH.setOnClickListener(this::goToBack);
    }

    private void goToBack(View view) {
        Intent intent = new Intent(this, ConfigurationCenterActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }

}