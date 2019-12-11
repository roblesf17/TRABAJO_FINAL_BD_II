package com.example.examen_unidadii_estrella;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MenuPrincipalActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewPager viewPager;
    private MyViewPagerAdapter adapter;
    private LinearLayout dotsLayout;
    private Button btnBack, btnNext;

    private Button btnCupones, btnMisCupones, btnTiendas, btnProductos, btnInstitucional, btnPerfil;

    //Para almacenar la información que se guardará en cada fragment
    private int[] image = {R.drawable.publicidad6, R.drawable.publicidad8, R.drawable.publicidad7, R.drawable.publicidad1, R.drawable.publicidad5};
    private int[] colorBackground, colorDot;
    private TextView[] dots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        //***********PERSONALIZA EL ACTIONBAR *********************
        ActionBar actionBar = getSupportActionBar();
        String titulo = "MENÚ PRINCIPAL";
        getSupportActionBar().setTitle(Html.fromHtml("<p align=center>"+titulo+"</p>"));
        //actionBar.setTitle(titulo);
        actionBar.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, R.color.material_deep_brown)));
        //************************************************************


        colorBackground = getResources().getIntArray(R.array.array_background);
        colorDot = getResources().getIntArray(R.array.array_dot);
        viewPager = findViewById(R.id.viewPager);
        dotsLayout = findViewById(R.id.dotsLayout);

        //Métodos
        addDots(0);
        loadViewPager();


        //BOTONES DE ACCESO

        btnCupones = findViewById(R.id.btnCupones);
        btnMisCupones = findViewById(R.id.btnMisCupones);
        btnTiendas = findViewById(R.id.btnTiendas);
        btnProductos = findViewById(R.id.btnProductos);
        btnInstitucional = findViewById(R.id.btnInstitucional);
        btnPerfil = findViewById(R.id.btnPerfil);

        btnCupones.setOnClickListener(this);
        btnMisCupones.setOnClickListener(this);
        btnTiendas.setOnClickListener(this);
        btnProductos.setOnClickListener(this);
        btnInstitucional.setOnClickListener(this);
        btnPerfil.setOnClickListener(this);


    }

    private int getItem(int i)
    {

        return viewPager.getCurrentItem()+i;
    }


    //método recibe el fragment actual
    private void addDots(int currentPage)
    {
        dots = new TextView[image.length];

        dotsLayout.removeAllViews();

        for(int i=0;i<dots.length;i++)
        {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            //Definir el color de los Puntos dependiendo de la posición
            if(i==currentPage)
            {
                dots[i].setTextColor(colorDot[currentPage]); //para el punto seleccionado
            }
            else
            {
                dots[i].setTextColor(Color.LTGRAY); //el punto estará de color gris
            }
            dotsLayout.addView(dots[i]);
        }
    }

    //Agregar los elementos al ViewPager
    private void loadViewPager()
    {
        adapter = new MyViewPagerAdapter(getSupportFragmentManager());
        //crear una instancia para cada fragment
        for(int i=0;i<image.length;i++)
        {
            adapter.addFragment(newInstance(image[i], colorBackground[i]));
        }
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(pageListener);


    }


    //Para llenar los ViewPager con los fragmentos
    //Esta es la información que se envía
    private SliderFragment newInstance (int image, int color)
    {
        //Creando una instancia diferente del fragment para colocar otra información en su interior
        Bundle bundle = new Bundle();
        bundle.putInt("image", image);
        bundle.putInt("color", color);

        SliderFragment fragment = new SliderFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    ViewPager.OnPageChangeListener pageListener = new ViewPager.OnPageChangeListener(){

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        //para detectar la página actual
        @Override
        public void onPageSelected(int position) {
            addDots(position);


        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };



    @Override
    public void onClick(View view) {
        Intent intent;

        switch (view.getId())
        {
            case R.id.btnCupones:
            {
                intent = new Intent(this, CuponesActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.btnMisCupones:
            {
                intent = new Intent(this, ExperienciaActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.btnTiendas:
            {
                intent = new Intent(this, TiendasActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.btnPerfil:
            {
                intent = new Intent(this, PerfilActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.btnProductos:
            {
                intent = new Intent(this, ProductosActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.btnInstitucional:
            {
                intent = new Intent(this, InstitucionalActivity.class);
                startActivity(intent);
                break;
            }


        }
    }


}
