package com.example.picoyplacafriends.management;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.picoyplacafriends.R;
import com.example.picoyplacafriends.model.User;

public class AddSelectRouteActivity extends AppCompatActivity {

    private TextView tvPendingTravels;
    private EditText etOrigenAddress, etDestinoAddress, etComment;
    private RecyclerView rvAddresses;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_select_route);

        tvPendingTravels = findViewById(R.id.tvPendingTravels);
        etOrigenAddress = findViewById(R.id.etOrigenAddress);
        etDestinoAddress = findViewById(R.id.etDestinoAddress);
        etComment = findViewById(R.id.etComment);
        rvAddresses = findViewById(R.id.rvAddresses);

        user = (User) getIntent().getExtras().get("user");

    }
}