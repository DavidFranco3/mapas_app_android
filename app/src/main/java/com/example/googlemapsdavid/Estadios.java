package com.example.googlemapsdavid;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.googlemapsdavid.databinding.ActivityEstadiosBinding;

public class Estadios extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityEstadiosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityEstadiosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng CU = new LatLng(19.3216466, -99.2026681);
        mMap.addMarker(new MarkerOptions().position(CU).title("Marker in Estadio Olimpico Universitario"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(CU));

        LatLng jalisco = new LatLng(20.7049947, -103.3303656);
        mMap.addMarker(new MarkerOptions().position(jalisco).title("Marker in Estadio Jalisco"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(jalisco));

        LatLng BBVA = new LatLng(25.6691181, -100.2466889);
        mMap.addMarker(new MarkerOptions().position(BBVA).title("Marker in Estadio BBVA"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(BBVA));

        LatLng corregidora = new LatLng(20.5776763, -100.3684633);
        mMap.addMarker(new MarkerOptions().position(corregidora).title("Marker in Estadio Corregidora"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(corregidora));

    }
}