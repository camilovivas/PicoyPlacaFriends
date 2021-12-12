package com.example.picoyplacafriends.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class EditTextAction extends AppCompatActivity implements TextWatcher{

    private EditText editText;

    /**
     * Estar
     * @param editText
     */
    public EditTextAction(EditText editText) {
        this.editText = editText;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Log.v("<<e","Entre");

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
