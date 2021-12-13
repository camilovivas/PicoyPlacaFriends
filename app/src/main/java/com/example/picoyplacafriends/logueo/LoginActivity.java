package com.example.picoyplacafriends.logueo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.picoyplacafriends.R;
import com.example.picoyplacafriends.model.User;
import com.example.picoyplacafriends.registro.DataPolicyActivity;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.gson.Gson;

import java.util.Collections;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private TextView tvForgetPassword;
    private TextView tvRegister;
    private Button btLogin, btFacebookLogin;


    private User user;

    private FirebaseFirestore db;
    private FirebaseAuth auth;
    private CallbackManager callbackManager = CallbackManager.Factory.create();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = new User();
        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        tvForgetPassword = findViewById(R.id.tvForgetPassword);
        btLogin = findViewById(R.id.btLogin);
        tvRegister = findViewById(R.id.tvRegister);
        btFacebookLogin = findViewById(R.id.btFacebookLogin);

        tvRegister.setOnClickListener(this::register);
        btLogin.setOnClickListener(this::login);

        btFacebookLogin.setOnClickListener(this::loginWithFacebook);
        tvForgetPassword.setOnClickListener(this::goToForgetPassword);

    }

    private void loginWithFacebook(View view) {
        LoginManager.getInstance().logInWithReadPermissions(this, Collections.singletonList("public_profile"));
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Log.w("fl", "facebook:onSuccess:" + loginResult);
                        handleFacebookAccessToken(loginResult.getAccessToken());
                    }

                    @Override
                    public void onCancel() {
                        Log.w("fl", "facebook:onCancel");
                    }

                    @Override
                    public void onError(FacebookException error) {
                        Log.w("fl", "facebook:onError:");
                    }
                }
        );


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }


    private void handleFacebookAccessToken(AccessToken accessToken) {
        Log.w("fl", "handleFacebookAccessToken" + accessToken);
        AuthCredential credential = FacebookAuthProvider.getCredential(accessToken.getToken());
        auth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.w("fl", "signInWithCredential:success");

                            FirebaseUser userAuth = auth.getCurrentUser();
                            if (userAuth != null) {
                                updateUser(userAuth);
                                goToSelectRoleActivity();
                            }

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("fl", "signInWithCredential:failure" + task.getException());
                        }
                    }

                });
    }

    private void goToSelectRoleActivity() {
        Intent intent = new Intent(this, SelectRoleActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }


    private void goToForgetPassword(View view) {
        auth.sendPasswordResetEmail(etEmail.getText().toString())
                .addOnSuccessListener(
                        unused -> {
                            Toast.makeText(this, "Revise su email " + etEmail.getText().toString(), Toast.LENGTH_SHORT).show();
                        }
                )
                .addOnFailureListener(
                        e -> {
                            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                );
    }


    private void saveUser(User user) {
        SharedPreferences sp = getSharedPreferences("PicoYPlacaFriends", MODE_PRIVATE);
        String jsonUser = new Gson().toJson(user);
        sp.edit().putString("user", jsonUser).apply();
    }


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = auth.getCurrentUser();
        if (currentUser != null) {
            updateUser(currentUser);
        }
    }

    private void updateUser(FirebaseUser firebaseUser) {
        user.setId(firebaseUser.getUid());
        user.setEmail(firebaseUser.getEmail());

    }

    private void login(View view) {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        Query query = db.collection("users").whereEqualTo("email", email);
        query.get().addOnCompleteListener(
                task -> {
                    if (!task.getResult().isEmpty()) {
                        for (DocumentSnapshot ds : task.getResult()) {
                             user = ds.toObject(User.class);
                            if (user.isAprobado() == true) {
                                if (user.getPassword().equals(password)) {
                                    Intent i = new Intent(this, SelectRoleActivity.class);
                                    i.putExtra("user", user);
                                    startActivity(i);
                                } else {
                                    Toast.makeText(this, "constraseña incorrecta", Toast.LENGTH_LONG).show();
                                }
                            } else {
                                Toast.makeText(this, "Todavia no estas aprobado, intentalo mas tarde", Toast.LENGTH_LONG).show();
                            }
                            break;
                        }
                    } else {
                        Toast.makeText(this, "Correo o constraseña incorrectos", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    private void register(View view) {
        Intent intent = new Intent(this, DataPolicyActivity.class);
        startActivity(intent);
    }


}