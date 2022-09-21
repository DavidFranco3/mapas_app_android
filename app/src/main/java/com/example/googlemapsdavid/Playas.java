package com.example.googlemapsdavid;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.googlemapsdavid.databinding.ActivityPlayasBinding;

public class Playas extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityPlayasBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPlayasBinding.inflate(getLayoutInflater());
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
        LatLng cancun = new LatLng(21.1212853, -86.9893228);
        mMap.addMarker(new MarkerOptions().position(cancun).title("Marker in Cancun"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cancun));

        LatLng puertoVallarta = new LatLng(20.6408576, -105.2945655);
        mMap.addMarker(new MarkerOptions().position(puertoVallarta).title("Marker in Puerto Vallarta"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(puertoVallarta));

        LatLng mazatlan = new LatLng(23.2467283, -106.4923184);
        mMap.addMarker(new MarkerOptions().position(mazatlan).title("Marker in Mazatlan"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mazatlan));

        LatLng lazaroCardenas = new LatLng(17.9588767, -102.2228227);
        mMap.addMarker(new MarkerOptions().position(lazaroCardenas).title("Marker in Lazaro Cardenas"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lazaroCardenas));
    }
}