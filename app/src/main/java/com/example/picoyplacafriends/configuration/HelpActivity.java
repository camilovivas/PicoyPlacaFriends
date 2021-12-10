package com.example.picoyplacafriends.configuration;

import androidx.appcompat.app.AppCompatActivity;
import com.example.picoyplacafriends.R;
import android.os.Bundle;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {

    private TextView tvFrequentQuestions, tvHelpChat, tvWhatsappLink, tvOfficialPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }
}