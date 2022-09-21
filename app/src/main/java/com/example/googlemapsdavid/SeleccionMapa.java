package com.example.googlemapsdavid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class SeleccionMapa extends AppCompatActivity implements View.OnClickListener {

    RadioButton playas, estadios;
    Button accionar, regresar;
    public final static int cons=0;
    public Uri uri;
    Bitmap bitmap, bitmapimagen;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_mapa);

        playas = (RadioButton) findViewById(R.id.playas);
        estadios = (RadioButton) findViewById(R.id.estadios);
        accionar = (Button) findViewById(R.id.accionar);
        regresar = (Button) findViewById(R.id.regresar);

        playas.setOnClickListener(this);
        estadios.setOnClickListener(this);
        accionar.setOnClickListener(this);
        regresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.accionar:
            if (playas.isChecked() || estadios.isChecked()) {

                if (playas.isChecked()) {
                    Intent i = new Intent(SeleccionMapa.this,Playas.class);
                    startActivity(i);
                }
                if (estadios.isChecked()) {
                    Intent i = new Intent(SeleccionMapa.this,Estadios.class);
                    startActivity(i);
                }
            }else{
                Toast.makeText(getApplicationContext(), "Elige una opcion", Toast.LENGTH_LONG).show();
            }
            break;
            case R.id.regresar:
                Intent i = new Intent(SeleccionMapa.this,MainActivity.class);
                startActivity(i);
                break;
        }
    }
}