package com.example.examen_unidadii_estrella;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SliderFragment extends Fragment {

    View view;
    ImageView image;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_slider, container, false);

        image = view.findViewById(R.id.image);
        RelativeLayout background = view.findViewById(R.id.background);

        //Para recibir la información en el fragment
        if(getArguments()!=null)
        {
            image.setImageResource(getArguments().getInt("image"));
            background.setBackgroundColor(getArguments().getInt("color"));
        }

        return view;
    }
}
