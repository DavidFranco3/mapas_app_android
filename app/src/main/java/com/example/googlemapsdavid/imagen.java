package com.example.googlemapsdavid;

import static android.util.Log.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.IOException;

public class imagen extends AppCompatActivity implements View.OnClickListener {

    ImageView Imagen;
    RadioButton camara, celular;
    Button regresar;
    public final static int cons=0;
    //public Uri uri;
    Bitmap bitmap, bitmapimagen;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen);

        Imagen = (ImageView) findViewById(R.id.imagen);
        regresar = (Button) findViewById(R.id.regresar);

        regresar.setOnClickListener(this);

        if(getIntent().hasExtra("imagenca")){
            bitmap = getIntent().getParcelableExtra("imagenca");
            Imagen.setImageBitmap(bitmap);
        }

        if(getIntent().hasExtra("imagenga")){
            Bundle ima = getIntent().getExtras();
            Uri uri = (Uri) ima.get("imagenga");
            Log.e("URI", uri.toString());
            try{
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),(Uri) uri);
                Imagen.setImageBitmap(bitmap);
            } catch (IOException e){
                e.printStackTrace();
            }
        }


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.regresar:
                Intent i = new Intent(imagen.this,seleccionImagen.class);
                startActivity(i);
                break;
        }
    }
}