package com.example.examen_unidadii_estrella;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class ExperienciaActivity extends AppCompatActivity {

    private Intent intent;
    private Button btnCalificar;
    private RatingBar ratingBarCalidad;
    private RatingBar ratingBarAtencion;
    private RatingBar ratingBarAmbiente;
    private TextView txtpuntajeCalidad;
    private TextView txtpuntajeAtencion;
    private TextView txtpuntajeAmbiente;

    private int puntaje = 0;
    private int puntaje2 = 0;
    private int puntaje3 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiencia);


        //***********PERSONALIZA EL ACTIONBAR *********************
        ActionBar actionBar = getSupportActionBar();
        String titulo = "MI EXPERIENCIA PANTTONY";
        actionBar.setTitle(titulo);
        actionBar.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, R.color.material_deep_brown)));
        //************************************************************

        ratingBarCalidad = (RatingBar) findViewById(R.id.ratingBarCalidad);
        ratingBarAtencion = (RatingBar) findViewById(R.id.ratingBarAtencion);
        ratingBarAmbiente = (RatingBar) findViewById(R.id.ratingBarAmbiente);

        txtpuntajeCalidad = (TextView) findViewById(R.id.txtpuntajeCalidad);
        txtpuntajeAtencion = (TextView) findViewById(R.id.txtpuntajeAtencion);
        txtpuntajeAmbiente = (TextView) findViewById(R.id.txtpuntajeAtmbiente);

        //PUNTUACIÓN DE CALIDAD
        ratingBarCalidad.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                int rating = (int) v;


                switch (rating)
                {
                    case 0:
                        puntaje = 0;
                        txtpuntajeCalidad.setText(String.valueOf(puntaje));
                        break;
                    case 1:
                        puntaje = 1;
                        txtpuntajeCalidad.setText(String.valueOf(puntaje));
                        break;
                    case 2:
                        puntaje = 2;
                        txtpuntajeCalidad.setText(String.valueOf(puntaje));
                        break;
                    case 3:
                        puntaje = 3;
                        txtpuntajeCalidad.setText(String.valueOf(puntaje));
                        break;
                    case 4:
                        puntaje = 4;
                        txtpuntajeCalidad.setText(String.valueOf(puntaje));
                        break;
                    case 5:
                        puntaje = 5;
                        txtpuntajeCalidad.setText(String.valueOf(puntaje));
                        break;

                }

            }
        });


        //PUNTUACIÓN DE ATENCION
        ratingBarAtencion.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                int rating2 = (int) v;


                switch (rating2)
                {
                    case 0:
                        puntaje2 = 0;
                        txtpuntajeAtencion.setText(String.valueOf(puntaje2));
                        break;
                    case 1:
                        puntaje2 = 1;
                        txtpuntajeAtencion.setText(String.valueOf(puntaje2));
                        break;
                    case 2:
                        puntaje2 = 2;
                        txtpuntajeAtencion.setText(String.valueOf(puntaje2));
                        break;
                    case 3:
                        puntaje2 = 3;
                        txtpuntajeAtencion.setText(String.valueOf(puntaje2));
                        break;
                    case 4:
                        puntaje2 = 4;
                        txtpuntajeAtencion.setText(String.valueOf(puntaje2));
                        break;
                    case 5:
                        puntaje2 = 5;
                        txtpuntajeAtencion.setText(String.valueOf(puntaje2));
                        break;

                }

            }
        });


        //PUNTUACIÓN DE AMBIENTE
        ratingBarAmbiente.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                int rating3 = (int) v;


                switch (rating3)
                {
                    case 0:
                        puntaje3 = 0;
                        txtpuntajeAmbiente.setText(String.valueOf(puntaje3));
                        break;
                    case 1:
                        puntaje3 = 1;
                        txtpuntajeAmbiente.setText(String.valueOf(puntaje3));
                        break;
                    case 2:
                        puntaje3 = 2;
                        txtpuntajeAmbiente.setText(String.valueOf(puntaje3));
                        break;
                    case 3:
                        puntaje3 = 3;
                        txtpuntajeAmbiente.setText(String.valueOf(puntaje3));
                        break;
                    case 4:
                        puntaje3 = 4;
                        txtpuntajeAmbiente.setText(String.valueOf(puntaje3));
                        break;
                    case 5:
                        puntaje3 = 5;
                        txtpuntajeAmbiente.setText(String.valueOf(puntaje3));
                        break;

                }
            }
        });



        btnCalificar = findViewById(R.id.btnCalificar);

        btnCalificar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {

                if(puntaje == 0 || puntaje2 ==0 || puntaje3 ==0)
                {
                    Toast.makeText(ExperienciaActivity.this, "Por favor asigna un puntaje", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(ExperienciaActivity.this, SorteoActivity.class);
                    startActivity(intent);
                }

            }
        });

    }
}
