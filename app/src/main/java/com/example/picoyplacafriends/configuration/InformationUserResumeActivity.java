package com.example.picoyplacafriends.configuration;

import androidx.appcompat.app.AppCompatActivity;
import com.example.picoyplacafriends.R;
import com.example.picoyplacafriends.model.User;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.gson.Gson;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Esta actividad muestra el resumen de la información del usuario
 */
public class InformationUserResumeActivity extends AppCompatActivity {

    private EditText etChangeFirstAndLastName,
            rtChangePlacaVehicle, etChangePicoPlacaDay,
            etFavorsDone, etFavorsReceived, etStarts;
    private ImageView ivBackIUR;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_user_resume);

        user = (User) getIntent().getExtras().get("user");
        Log.w(">>", new Gson().toJson(user.toString()));

        // Se registran los elementos gráficos
        etChangeFirstAndLastName = findViewById(R.id.etChangeFirstAndLastName);
        rtChangePlacaVehicle = findViewById(R.id.rtChangePlacaVehicle);
        etChangePicoPlacaDay = findViewById(R.id.etChangePicoPlacaDay);
        etFavorsDone = findViewById(R.id.etFavorsDone);
        etFavorsReceived = findViewById(R.id.etFavorsReceived);
        etStarts = findViewById(R.id.etStarts);
        ivBackIUR = findViewById(R.id.ivBackIUR);

        // Se muestran los datos
        etChangeFirstAndLastName.setHint(user.getName()+" "+user.getLastname());
        rtChangePlacaVehicle.setHint(user.getTarjetaPropiedad());

        // Actualiza los datos
        updateUserInformation();

        ivBackIUR.setOnClickListener(this::goToBack);
    }

    private void goToBack(View view) {
        Intent intent = new Intent(this, ConfigurationCenterActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }

    public void updateUserInformation(){
        etChangeFirstAndLastName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                if (etChangeFirstAndLastName.getText().toString().length() != 0){
                    String[] completeName = etChangeFirstAndLastName.getText().toString().split(" ");
                    user.setName(completeName[0].toString());
                    user.setLastname(completeName[1].toString());
                }
            }
        });

        rtChangePlacaVehicle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                if (rtChangePlacaVehicle.getText().toString().length() != 0){
                    user.setTarjetaPropiedad("tarjeta"+rtChangePlacaVehicle.getText().toString());
                }
            }
        });

        updateUser();

    }

    private void updateUser(){
        // Actualiza los datos del usuario en Firebase
        FirebaseFirestore.getInstance().collection("users").document(user.getEmail()).set(user);
    }


}