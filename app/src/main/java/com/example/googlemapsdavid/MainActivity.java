package com.example.googlemapsdavid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.googlemapsdavid.databinding.ActivitySeleccionImagenBinding;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] array = {
            "Elige una opcion",
            "Ir al menu mapas",
            "Ir al menu imagen"
    };
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.eleccion);
        spinner.setAdapter(new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                array));
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)  {
        if(adapterView.getSelectedItemId()==1){
            Intent in = new Intent(this, SeleccionMapa.class);
            startActivity(in);
        }

        if(adapterView.getSelectedItemId()==2){
            Intent in = new Intent(this, seleccionImagen.class);
            startActivity(in);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
