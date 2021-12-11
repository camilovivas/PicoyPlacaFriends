package com.example.picoyplacafriends.configuration;

import androidx.appcompat.app.AppCompatActivity;
import com.example.picoyplacafriends.R;
import android.os.Bundle;
import android.widget.EditText;

/**
 * Esta actividad muestra el resumen de la información del usuario
 */
public class InformationUserResumeActivity extends AppCompatActivity {

    private EditText etChangeFirstAndLastName,
            rtChangePlacaVehicle, etChangePicoPlacaDay,
            etFavorsDone, etFavorsReceived, etStarts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_user_resume);
    }
}