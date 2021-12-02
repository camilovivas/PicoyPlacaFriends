package com.example.picoyplacafriends.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.picoyplacafriends.R;

public class PersonalInfoActivity extends AppCompatActivity {

    private EditText txEAge;
    private EditText txELastName;
    private EditText txEName;
    private EditText txEDocument;
    private RadioButton rbCitizenshipCard;
    private RadioButton rbIdentityCard;
    private Button btNextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);

        //Referencias de los atributos a inicializar
        txEAge = findViewById(R.id.txEAge);
        txELastName = findViewById(R.id.txELastName);
        txEName = findViewById(R.id.txEName);
        txEDocument = findViewById(R.id.txEDocument);
        rbCitizenshipCard = findViewById(R.id.rbCitizenshipCard);
        rbIdentityCard = findViewById(R.id.rbIdentityCard);
        btNextActivity = findViewById(R.id.btNextActivity);
        addPersonInfo();
    }

    /**
     * Recoge la información de una persona para ser tratada más adelante.
     */
    private void addPersonInfo(){
        String name = txEName.getText().toString();
        String lastName = txELastName.getText().toString();
        String document = txEDocument.getText().toString();
        String age = txEAge.getText().toString();

        btNextActivity.setOnClickListener(v ->{
            //INTENT: Se lanza la actividad de correspondiente a la información de un vehiculo
            Intent intent = new Intent(this, VehicleInfo.class);
            startActivity(intent);
        });
    }

    /**
     * Permite verficicar que radio button fue seleccionado.
     * @param view
     */
    public void onRadioButtonClicked(View view) {
        boolean ismarket = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rbIdentityCard:
                if (ismarket) {
                    txEDocument.setHint("Digite su número de su cédula de ciudadanía ");
                    // Aquí se realizará el proceso de validación de la cédula de ciudadanía
                }
                break;

            case R.id.rbCitizenshipCard:
                if (ismarket) {
                    txEDocument.setHint("Digite su tarjeta de identidad");
                    // Aquí se realizará el proceso de validación de la tarjeta de identidad
                }
                break;
        }
    }
}