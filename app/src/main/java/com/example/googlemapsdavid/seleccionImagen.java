package com.example.googlemapsdavid;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.IOException;

public class seleccionImagen extends AppCompatActivity implements View.OnClickListener {

    ImageView elegida;
    RadioButton camara, celular;
    Button accionar, regresar;
    public final static int cons=0;
    public Uri uri;
    Bitmap bitmap, bitmapimagen;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_imagen);

        camara = (RadioButton) findViewById(R.id.camara);
        celular = (RadioButton) findViewById(R.id.galeria);
        accionar = (Button) findViewById(R.id.accionarBoton);
        regresar = (Button) findViewById(R.id.regresarMenu);
        elegida = (ImageView) findViewById(R.id.imagen);

        camara.setOnClickListener(this);
        celular.setOnClickListener(this);
        accionar.setOnClickListener(this);
        regresar.setOnClickListener(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        //codigo para la camara del telefono
        if(resultCode==RESULT_OK && requestCode==REQUEST_IMAGE_CAPTURE){
            Bundle b=data.getExtras();
            bitmapimagen=(Bitmap) b.get("data");
            Intent intent = new Intent(this, imagen.class);
            intent.putExtra("imagenca", bitmapimagen);
            startActivity(intent);
        }

        //codigo por si eligio la imagen de la galeria del telefono
        else if(requestCode==cons){
            uri=data.getData();
            Intent intent2 = new Intent(this, imagen.class);
            intent2.putExtra("imagenga", uri);
            startActivity(intent2);

        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.accionarBoton:
                if (camara.isChecked() || celular.isChecked()) {

                    if (camara.isChecked()) {
                        Intent in = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        if(in.resolveActivity(getPackageManager()) !=null){
                            startActivityForResult(in, REQUEST_IMAGE_CAPTURE);
                        }
                    }
                    else if (celular.isChecked()) {
                        Intent a=new Intent (Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        a.setType("image/*");
                        startActivityForResult(a.createChooser(a,""),cons);
                    }

                }else{
                    Toast.makeText(getApplicationContext(), "Elige una opcion", Toast.LENGTH_LONG).show();
                }
                    break;
            case R.id.regresarMenu:
                Intent i = new Intent(seleccionImagen.this,MainActivity.class);
                startActivity(i);
                break;
        }
    }

}