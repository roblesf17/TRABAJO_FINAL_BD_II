package com.example.examen_unidadii_estrella;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class CuponesActivity extends AppCompatActivity {

    Context context;
    private ViewPager viewPager;
    private MyViewPagerAdapter adapter;
    private LinearLayout dotsLayout;
    private Button btnobtenerCupon;

    //Para almacenar la información que se guardará en cada fragment
    private int[] image = {R.drawable.promobollito, R.drawable.promodonas, R.drawable.promogaseosa, R.drawable.promominitorta, R.drawable.promopizza};
    private String[] title = { "Bollito de Queso gratis",
                                "3 x 2 Donas",
                                "Empanada Criolla + Gaseosa a S/ 5.00",
                                "Minitorta de Tres Leches a S/ 10.00",
                                "Porción de Pizza a S/ 5.00"};
    private String[] content = {"Presenta este cupón en nuestra tienda de Av. Varela 686 y reclama tu Bollito totalmente GRATIS",
                                    "Presenta este cupón en cualquiera de nuestras tiendas y reclama la tercera dona totalmente GRATIS",
                                    "Presenta este cupón en cualquiera de nuestras tiendas y caompra una Empanada Criolla + Gaseosa a solo S/ 5.00",
                                    "Presenta este cupón en cualquiera de nuestras tiendas y compra una Minitorta de Tres Leches a S/ 10.00",
                                    "Presenta este cupón en cualquiera de nuestras tiendas y compra una Porción de Pizza a S/ 5.00"};
    private int[] colorBackgroundCupones, colorDotCupones;
    private TextView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cupones);

        //***********PERSONALIZA EL ACTIONBAR *********************
        ActionBar actionBar = getSupportActionBar();
        String titulo = "CUPONES";
        actionBar.setTitle(titulo);
        actionBar.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, R.color.material_deep_brown)));
        //************************************************************


        colorBackgroundCupones = getResources().getIntArray(R.array.array_backgroundcupones);
        colorDotCupones = getResources().getIntArray(R.array.array_dotcupones);
        viewPager = findViewById(R.id.viewPager);
        dotsLayout = findViewById(R.id.dotsLayout);
        btnobtenerCupon = findViewById(R.id.btnObtenerCupon);

        //Métodos
        addDots(0);
        loadViewPager();


        btnobtenerCupon.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {

                Intent intent;

                //obtengo la posición del la pantalla (viewpager) en el slide
                int posicion = viewPager.getCurrentItem();

                    if(posicion==0)
                    {
                        intent = new Intent(CuponesActivity.this, DetalleCuponActivity.class);
                        String title = "Bollito de Queso gratis";
                        String content = "Presenta este cupón en nuestra tienda de Av. Varela N° 686 y reclama tu Bollito totalmente GRATIS";
                        String codigoPromo = "PROMOBOLLGRATIS";

                        Bundle bundle=new Bundle();
                        bundle.putInt("image",R.drawable.promobollito);
                        intent.putExtras(bundle);

                        Bundle bundleqr=new Bundle();
                        bundleqr.putInt("qr",R.drawable.qrpromobollgratis);
                        intent.putExtras(bundleqr);


                        intent.putExtra("title", title);
                        intent.putExtra("content", content);
                        intent.putExtra("codigoPromo",codigoPromo);

                        startActivity(intent);
                    }

                    if(posicion==1)
                    {
                        intent = new Intent(CuponesActivity.this, DetalleCuponActivity.class);
                        String title = "3 x 2 Donas";
                        String content = "Presenta este cupón en cualquiera de nuestras tiendas y reclama la tercera dona totalmente GRATIS";
                        String codigoPromo = "PROMODON3X2";

                        Bundle bundle=new Bundle();
                        bundle.putInt("image",R.drawable.promodonas);

                        Bundle bundleqr=new Bundle();
                        bundleqr.putInt("qr",R.drawable.qrpromodon3x2);
                        intent.putExtras(bundleqr);


                        intent.putExtras(bundle);
                        intent.putExtra("title", title);
                        intent.putExtra("content", content);
                        intent.putExtra("codigoPromo",codigoPromo);

                        startActivity(intent);
                    }

                    if(posicion==2)
                    {
                        intent = new Intent(CuponesActivity.this, DetalleCuponActivity.class);
                        String title = "Empanada Criolla + Gaseosa a S/ 5.00";
                        String content = "Presenta este cupón en cualquiera de nuestras tiendas y caompra una Empanada Criolla + Gaseosa a solo S/ 5.00";
                        String codigoPromo = "PROMOEMPGAS5";

                        Bundle bundle=new Bundle();
                        bundle.putInt("image",R.drawable.promogaseosa);

                        Bundle bundleqr=new Bundle();
                        bundleqr.putInt("qr",R.drawable.qrpromoempgas5);
                        intent.putExtras(bundleqr);

                        intent.putExtras(bundle);
                        intent.putExtra("title", title);
                        intent.putExtra("content", content);
                        intent.putExtra("codigoPromo",codigoPromo);

                        startActivity(intent);
                    }

                    if(posicion==3)
                    {
                        intent = new Intent(CuponesActivity.this, DetalleCuponActivity.class);
                        String title = "Minitorta de Tres Leches a S/ 10.00";
                        String content = "Presenta este cupón en cualquiera de nuestras tiendas y compra una Minitorta de Tres Leches a S/ 10.00";
                        String codigoPromo = "PROMOMINTOR10";

                        Bundle bundle=new Bundle();
                        bundle.putInt("image",R.drawable.promominitorta);

                        Bundle bundleqr=new Bundle();
                        bundleqr.putInt("qr",R.drawable.qrpromomintor10);
                        intent.putExtras(bundleqr);

                        intent.putExtras(bundle);
                        intent.putExtra("title", title);
                        intent.putExtra("content", content);
                        intent.putExtra("codigoPromo",codigoPromo);

                        startActivity(intent);
                    }

                    if(posicion==4)
                    {
                        intent = new Intent(CuponesActivity.this, DetalleCuponActivity.class);
                        String title = "Porción de Pizza a S/ 5.00";
                        String content = "Presenta este cupón en cualquiera de nuestras tiendas y compra una Porción de Pizza a S/ 5.00";
                        String codigoPromo = "PROMOPIZZA5";

                        Bundle bundle=new Bundle();
                        bundle.putInt("image",R.drawable.promopizza);

                        Bundle bundleqr=new Bundle();
                        bundleqr.putInt("qr",R.drawable.qrpromopizza5);
                        intent.putExtras(bundleqr);

                        intent.putExtras(bundle);
                        intent.putExtra("title", title);
                        intent.putExtra("content", content);
                        intent.putExtra("codigoPromo",codigoPromo);

                        startActivity(intent);

                    }

                }


        });


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
                dots[i].setTextColor(colorDotCupones[currentPage]); //para el punto seleccionado
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
        //Para recorrer los arreglos y crear una instancia para cada fragment
        for(int i=0;i<image.length;i++)
        {
            adapter.addFragment(newInstance(title[i], content[i], image[i], colorBackgroundCupones[i]));
        }
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(pageListener);
    }


    //Para llenar los ViewPager con los fragmentos
    //Esta es la información que se envía
    private SliderCuponesFragment newInstance (String title, String content, int image, int color)
    {
        //Creando una instancia diferente del fragment para colocar otra información en su interior
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putString("content", content);
        bundle.putInt("image", image);
        bundle.putInt("color", color);

        SliderCuponesFragment fragment = new SliderCuponesFragment();
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


}
