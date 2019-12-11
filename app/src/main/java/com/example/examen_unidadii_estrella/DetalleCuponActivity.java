package com.example.examen_unidadii_estrella;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetalleCuponActivity extends AppCompatActivity {

    TextView TituloCupon, DescripcionCupon, CodigoPromo;
    ImageView ImagenCupon, CodigoQR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_cupon);


        //***********PERSONALIZA EL ACTIONBAR *********************
        ActionBar actionBar = getSupportActionBar();
        String titulo = "DETALLE DE CUPÓN";
        actionBar.setTitle(titulo);
        actionBar.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, R.color.material_deep_brown)));
        //************************************************************


        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");
        String codigoPromo = intent.getStringExtra("codigoPromo");
        String image = intent.getStringExtra("image");
        String qr = intent.getStringExtra("qr");


        TituloCupon =  findViewById(R.id.txtTituloCuponDet);
        DescripcionCupon = findViewById(R.id.txtDescripcionCuponDet);
        CodigoPromo = findViewById(R.id.txtCodigoPromocion);
        ImagenCupon=findViewById(R.id.imageCuponDet);
        CodigoQR=findViewById(R.id.imageQR);


        TituloCupon.setText(title);
        DescripcionCupon.setText(content);
        CodigoPromo.setText(codigoPromo);

        Bundle bundle=this.getIntent().getExtras();
        int pic = bundle.getInt("image");
        ImagenCupon.setImageResource(pic);

        Bundle bundleqr=this.getIntent().getExtras();
        int pic2 = bundleqr.getInt("qr");
        CodigoQR.setImageResource(pic2);



    }
}
