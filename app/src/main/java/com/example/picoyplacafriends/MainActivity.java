package com.example.picoyplacafriends;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;

import com.example.picoyplacafriends.logueo.LoginActivity;

public class MainActivity extends AppCompatActivity {

    private Intent loginActivityIntent;
    private boolean isAlive = true;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermissions(new String[]{
                Manifest.permission.READ_EXTERNAL_STORAGE
        }, 1);
        runCounter();
    }

    /**
     * Realiza un conteo y luego lanza una atividad principal de la aplicación,
     * la actividad home
     */
    public void runCounter(){
        new Thread(
                ()->{
                    while (isAlive){
                        try {
                            if (counter==1) {
                                runOnUiThread(() -> {
                                    // Se lanza la actividad home
                                    loginActivityIntent = new Intent(this, LoginActivity.class);
                                    startActivity(loginActivityIntent);
                                });
                                isAlive = false;
                            }else {
                                Thread.sleep(1000);
                                counter++;
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            finish();
                        }
                    }
                }
        ).start();
    }


}