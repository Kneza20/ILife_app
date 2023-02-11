package com.example.ilife_app_design;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Pay extends Fragment {

    ImageView imgSave3, imgPencil3, imgSave2, imgPencil2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pay, container, false);

        imgSave3 = (ImageView) view.findViewById(R.id.imgSave3);
        imgPencil3 = (ImageView) view.findViewById(R.id.imgPencil3);
        imgSave2 = (ImageView) view.findViewById(R.id.imgSave2);
        imgPencil2 = (ImageView) view.findViewById(R.id.imgPencil2);

        imgSave3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgPencil3.setVisibility(imgPencil3.VISIBLE);
                imgSave3.setVisibility(imgSave3.INVISIBLE);
            }
        });

        imgPencil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgPencil3.setVisibility(imgPencil3.INVISIBLE);
                imgSave3.setVisibility(imgSave3.VISIBLE);
            }
        });

        imgSave2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgPencil2.setVisibility(imgPencil2.VISIBLE);
                imgSave2.setVisibility(imgSave2.INVISIBLE);
            }
        });

        imgPencil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgPencil2.setVisibility(imgPencil2.INVISIBLE);
                imgSave2.setVisibility(imgSave2.VISIBLE);
            }
        });

        return view;
    }
}