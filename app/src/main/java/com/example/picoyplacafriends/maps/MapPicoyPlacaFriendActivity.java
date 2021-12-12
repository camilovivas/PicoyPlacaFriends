package com.example.picoyplacafriends.maps;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.example.picoyplacafriends.R;
import com.example.picoyplacafriends.databinding.ActivityMapPicoyPlacaFriendBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;


public class MapPicoyPlacaFriendActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    private GoogleMap mMap;
    private ActivityMapPicoyPlacaFriendBinding binding;
    //Permite obtener la ultima ubicación del GPS
    private LocationManager locationManager;

    private Marker myMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapPicoyPlacaFriendBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //Declaración del location manager
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
    }


    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //Request a los sensores de gps
        /*
         * 2: Cada dos metros se actualiza la lat y long
         * 1000: Cada segundo refresca la lat y long
         */
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,2,this);
        setInitialPosition();
    }

    /**
     * Permite establecer la posición inicial que mostrará el mapa
     */
    @SuppressLint("MissingPermission")
    public void setInitialPosition(){
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if(location != null){
            updateMyLocation(location);
        }
    }

    /**
     * Controla el cambio de posición del usuario
     * @param location
     */
    @Override
    public void onLocationChanged(@NonNull Location location) {
        updateMyLocation(location);
    }

    /**
     * Actualiza constantemente la posición en la que se encuentra el usuario
     * @param location
     */
    public void updateMyLocation(Location location){
        LatLng myPos = new LatLng(location.getLatitude(),location.getLongitude());

        if(myMarker == null){
            myMarker = mMap.addMarker(new MarkerOptions().position(myPos).title("I am here"));
        }else{
            myMarker.setPosition(myPos);
        }
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myPos,17));
    }
}