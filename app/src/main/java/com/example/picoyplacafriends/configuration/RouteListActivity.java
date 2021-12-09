package com.example.picoyplacafriends.configuration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.picoyplacafriends.R;
import android.os.Bundle;

public class RouteListActivity extends AppCompatActivity {

    private RecyclerView rvRouteList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_list);
    }
}