package com.example.examen_unidadii_estrella;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class DetalleProductoActivity extends AppCompatActivity {

    TextView NombreProducto, DescripcionProducto;
    ImageView fotoProducto;
    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolBar;

    FirebaseDatabase database;
    DatabaseReference productodetalle;
    String ProductoId="";
    Producto currentProducto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);

        //***********PERSONALIZA EL ACTIONBAR *********************
        ActionBar actionBar = getSupportActionBar();
        String titulo = "DETALLE DE PRODUCTO";
        actionBar.setTitle(titulo);
        actionBar.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, R.color.material_deep_brown)));
        //************************************************************

        //LLAMAR MOTOFAST
        Button btnLLamada = (Button) findViewById(R.id.btnMotoFast);
        final String telefono = "943730000";

        btnLLamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dial = "tel:" + telefono;
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
            }
        });



        //Firebase
        database = FirebaseDatabase.getInstance();
        productodetalle = database.getReference("productos");

        NombreProducto =  findViewById(R.id.txtNombreDetProd);
        DescripcionProducto = findViewById(R.id.txtDescripcionDetProd);
        fotoProducto=findViewById(R.id.imgvFotoDetProd);



        /************************/
        Intent intent = getIntent();
        String mNombreProd = intent.getStringExtra("iNombreProd");
        String mDescripcionProd = intent.getStringExtra("iDescripcionProd");
        String mFotoProd = intent.getStringExtra("iFotoProd");


        Picasso.get().load(mFotoProd).into(fotoProducto);
        DescripcionProducto.setText(mDescripcionProd);
        NombreProducto.setText(mNombreProd);





    }

}
