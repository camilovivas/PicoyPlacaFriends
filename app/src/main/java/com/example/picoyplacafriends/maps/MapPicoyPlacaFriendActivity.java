package com.example.picoyplacafriends.maps;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import android.annotation.SuppressLint;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import com.example.picoyplacafriends.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapPicoyPlacaFriendActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    //Permite obtener la ultima ubicación del GPS
    private LocationManager locationManager;
    private Marker myMarker;
    private Button btMyLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_picoy_placa_friend);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //Declaración del location manager
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        //Declaración de atributos
        btMyLocation = findViewById(R.id.btMyLocation);

        btMyLocation.setOnClickListener( (v) ->{
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myMarker.getPosition(),16));
        });


    }


    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(@NonNull  GoogleMap googleMap) {
        mMap = googleMap;
        //Request a los sensores de gps
        /*
         * valor 2: Cada dos metros se actualiza la lat y long
         * valor 1000: Cada segundo refresca la lat y long
         */
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,2,this);
        setInitialPosition();

        //Llamado del metodo que permite controlar la camara con el clik
        mMap.setOnMapClickListener(this);
        //Llamado del metodo que permite añadir un marcador en la posición que sostenga.
        mMap.setOnMapLongClickListener(this);
        //Click en cada uno de los mapas
        mMap.setOnMarkerClickListener(this);
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
     */
    @Override
    public void onLocationChanged(@NonNull Location location) {
        updateMyLocation(location);
    }

    /**
     * Actualiza constantemente la posición en la que se encuentra el usuario
     */
    public void updateMyLocation(Location location){
        LatLng myPos = new LatLng(location.getLatitude(),location.getLongitude());

        if(myMarker == null){
            myMarker = mMap.addMarker(new MarkerOptions().position(myPos).title("I am here"));
        }else{
            myMarker.setPosition(myPos);
        }
       // mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myPos,17));
    }

    /**
     * Este metodo permite enfocar la camara de acuerdo al click del usuario
     * @param latLng latitud y longitud del punto en el mapa.
     */
    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,16));
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        mMap.addMarker(new MarkerOptions().position(latLng).title("Marcador").snippet("Soy un marcador"));
    }

    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {
        Toast.makeText(this,marker.getPosition().latitude+", "+marker.getPosition().longitude,Toast.LENGTH_LONG).show();
        marker.showInfoWindow();
        return true;
    }




}