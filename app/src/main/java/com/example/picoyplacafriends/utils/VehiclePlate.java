package com.example.picoyplacafriends.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Esta clase permite realizar el efecto de desplazamiento cuando el usuario escribe los caracteres
 * de su placa. Esta clase o herramienta es usada en la actividad de registro de vehiculo  (VehicleInfo)
 * y en la de actualizar información de vehiculo (vehicleInfo).
 */
public class VehiclePlate implements TextWatcher {

    /**
     * Los 6 caracteres de la placa
     */
    private EditText char1, char2, char3, char4, char5, char6;

    /**
     * Boton para editar la información de la placa
     */
    private Button btModify;

    /**
     * Constructor de la placa de un vehiculo
     * @param char1 Primer letra de la placa
     * @param char2 Segunda letra de la placa
     * @param char3 Tercera letra de la placa
     * @param char4 Primer número de la placa
     * @param char5 Segundo número de la placa
     * @param char6 Tercer número de la placa
     * @param btModify Botón para modificar la placa del vehiculo
     */
    public VehiclePlate(EditText char1, EditText char2, EditText char3, EditText char4, EditText char5, EditText char6, Button btModify) {
        this.char1 = char1;
        this.char2 = char2;
        this.char3 = char3;
        this.char4 = char4;
        this.char5 = char5;
        this.char6 = char6;
        this.btModify = btModify;
        btModify.setOnClickListener(this::onActionBtModifyPlate);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }
    /**
     * Verifica constantemente si el editText fue modificado.
     * @param s
     */
    @Override
    public void afterTextChanged(Editable s) {
        Log.v("<<s","Enter");
        if(char1.getText().length() ==1 && char1.isEnabled()){
            char2.requestFocus();
            char1.setEnabled(false);
        }else if(char2.getText().length() ==1 && char2.isEnabled()){
            char3.requestFocus();
            char2.setEnabled(false);
        }else if(char3.getText().length() ==1 && char3.isEnabled()){
            char4.requestFocus();
            char3.setEnabled(false);
        }else if(char4.getText().length() ==1 && char4.isEnabled()){
            char5.requestFocus();
            char4.setEnabled(false);
        }else if(char5.getText().length() ==1 && char5.isEnabled()){
            char6.requestFocus();
            char5.setEnabled(false);
        }else if(char6.getText().length() ==1 && char6.isEnabled()) {
            char6.setEnabled(false);
            btModify.setVisibility(View.VISIBLE);

        }
    }
    /**
     * Este metodo permite eliminar todos los edits text correspondiente a la placa del vehiculo
     * @param view
     */
    private void onActionBtModifyPlate(View view){

        char1.setText("");
        char2.setText("");
        char3.setText("");
        char4.setText("");
        char5.setText("");
        char6.setText("");

        char1.setEnabled(true);
        char2.setEnabled(true);
        char3.setEnabled(true);
        char4.setEnabled(true);
        char5.setEnabled(true);
        char6.setEnabled(true);
        btModify.setVisibility(View.INVISIBLE);

    }

}
