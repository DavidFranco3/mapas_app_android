package com.example.googlemapsdavid;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.googlemapsdavid.databinding.ActivityCiudadesBinding;

public class Ciudades extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityCiudadesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCiudadesBinding.inflate(getLayoutInflater());
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
        LatLng ciudadJuarez = new LatLng(31.6538179, -106.5890222);
        mMap.addMarker(new MarkerOptions().position(ciudadJuarez).title("Marker in Ciudad Juarez"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ciudadJuarez));

        LatLng morelia = new LatLng(19.7036417, -101.2761648);
        mMap.addMarker(new MarkerOptions().position(morelia).title("Marker in Morelia"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(morelia));

        LatLng cozumel = new LatLng(20.5123516, -86.9713826);
        mMap.addMarker(new MarkerOptions().position(cozumel).title("Marker in Cozumel"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cozumel));

    }
}