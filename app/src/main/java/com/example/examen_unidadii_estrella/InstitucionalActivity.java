package com.example.examen_unidadii_estrella;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import ai.api.AIListener;
import ai.api.android.AIConfiguration;
import ai.api.android.AIService;
import ai.api.model.AIError;
import ai.api.model.AIResponse;
import ai.api.model.Result;

public class InstitucionalActivity extends AppCompatActivity implements AIListener {




    //INICIO DIALOG FLOW DIALOGFLOW -----------------
    private TextToSpeech mTextToSpeech;
    private AIService mAIService;
    //FIN DIALOG FLOW ------------------------------





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institucional);

        //***********PERSONALIZA EL ACTIONBAR *********************
        ActionBar actionBar = getSupportActionBar();
        String titulo = "INSTITUCIONAL";
        actionBar.setTitle(titulo);
        actionBar.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, R.color.material_deep_brown)));
        //************************************************************


        //HACER LLAMADA

        Button btnLLamada = (Button) findViewById(R.id.llamada);
        final String telefono = "952640011";

        btnLLamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dial = "tel:" + telefono;
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
            }
        });


        //IR A PAGINA DE FACEBOOK

        Button facebook = (Button) findViewById(R.id.facebook);

        facebook.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://web.facebook.com/Panttony/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


        //IR A PAGINA DE INSTAGRAM

        Button instagram = (Button) findViewById(R.id.instagram);

        instagram.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri2 = Uri.parse("https://www.instagram.com/panttony.panaderia/?hl=es-la");
                Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
                startActivity(intent2);
            }
        });



        //INICIO DIALOFLOW -------------------------
        final ai.api.android.AIConfiguration config = new ai.api.android.AIConfiguration
                ("aede6a2870454455a5d45d718555e9dd", ai.api.android.AIConfiguration.SupportedLanguages.Spanish, AIConfiguration.RecognitionEngine.System);
        mAIService = AIService.getService(this, config);
        mAIService.setListener( this );
        mTextToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

            }
        });
        //FIN DIALOGFLOW ----------------------------


    }


    //INICIO DIALOG FLOW --------------------------------------
    public void AsistenteBoot(View view)
    {
        mAIService.startListening();
    }






    @Override
    public void onError(AIError error)
    {

    }

    @Override
    public void onResult(AIResponse response) {
        Result result = response.getResult();
        mTextToSpeech.speak(result.getFulfillment().getSpeech(), TextToSpeech.QUEUE_FLUSH, null, null);
    }

    @Override
    public void onAudioLevel(float level) {

    }

    @Override
    public void onListeningStarted() {

    }

    @Override
    public void onListeningCanceled() {

    }

    @Override
    public void onListeningFinished() {

    }
    //FIN DIALOG FLOW -------------------------------------------



}
