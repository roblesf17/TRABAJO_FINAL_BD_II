package com.example.examen_unidadii_estrella;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SliderCuponesFragment extends Fragment {


    View view;
    ImageView image;
    TextView title, content;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_slider_cupones, container, false);

        image = view.findViewById(R.id.image_cupon);
        title = view.findViewById(R.id.txtTituloPromo);
        content = view.findViewById(R.id.txtDescripcionPromo);
        RelativeLayout background = view.findViewById(R.id.background);

        //Para recibir la información en el fragment
        if(getArguments()!=null)
        {
            title.setText(getArguments().getString("title"));
            content.setText(getArguments().getString("content"));
            image.setImageResource(getArguments().getInt("image"));
            background.setBackgroundColor(getArguments().getInt("color"));
        }

        return view;
    }

}
