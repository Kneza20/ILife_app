package com.example.ilife_app_design;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Pay extends Fragment {

    ImageView imgSave3, imgPencil3, imgSave2, imgPencil2;
    TextView tvCountry, tvStateProvince, tvAddress, tvPostal, tvHolder, tvCardName, tvCCV;
    EditText etChangeCountry, etChangeState, etChangeAddress, etChangePostal, etChangeHolder, etChangeCardNum, etChangeCCV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pay, container, false);

        imgSave3 = (ImageView) view.findViewById(R.id.imgSave3);
        imgPencil3 = (ImageView) view.findViewById(R.id.imgPencil3);
        imgSave2 = (ImageView) view.findViewById(R.id.imgSave2);
        imgPencil2 = (ImageView) view.findViewById(R.id.imgPencil2);
        etChangeCountry = (EditText) view.findViewById(R.id.etChangeCountry);
        etChangeAddress = (EditText) view.findViewById(R.id.etChangeAddress);
        etChangeState = (EditText) view.findViewById(R.id.etChangeState);
        etChangePostal = (EditText) view.findViewById(R.id.etChangePostal);
        etChangeHolder = (EditText) view.findViewById(R.id.etChangeHolder);
        etChangeCardNum = (EditText) view.findViewById(R.id.etChangeCardNUm);
        etChangeCCV = (EditText) view.findViewById(R.id.etChangeCCV);
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
                tvCountry.setVisibility(tvCountry.VISIBLE);
                tvStateProvince.setVisibility(tvStateProvince.VISIBLE);
                tvAddress.setVisibility(tvAddress.VISIBLE);
                tvPostal.setVisibility(tvPostal.VISIBLE);
                tvHolder.setVisibility(tvHolder.VISIBLE);
                tvCardName.setVisibility(tvCardName.VISIBLE);
                tvCCV.setVisibility(tvCCV.VISIBLE);
                etChangeCountry.setVisibility(etChangeCountry.INVISIBLE);
                etChangeState.setVisibility(etChangeState.INVISIBLE);
                etChangeAddress.setVisibility(etChangeAddress.INVISIBLE);
                etChangePostal.setVisibility(etChangePostal.INVISIBLE);
                etChangeHolder.setVisibility(etChangeHolder.INVISIBLE);
                etChangeCardNum.setVisibility(etChangeCardNum.INVISIBLE);
                etChangeCCV.setVisibility(etChangeCCV.INVISIBLE);
            }
        });

        imgPencil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgPencil2.setVisibility(imgPencil2.INVISIBLE);
                imgSave2.setVisibility(imgSave2.VISIBLE);
                tvCountry.setVisibility(tvCountry.INVISIBLE);
                tvStateProvince.setVisibility(tvStateProvince.INVISIBLE);
                tvAddress.setVisibility(tvAddress.INVISIBLE);
                tvPostal.setVisibility(tvPostal.INVISIBLE);
                tvHolder.setVisibility(tvHolder.INVISIBLE);
                tvCardName.setVisibility(tvCardName.INVISIBLE);
                tvCCV.setVisibility(tvCCV.INVISIBLE);
                etChangeCountry.setVisibility(etChangeCountry.VISIBLE);
                etChangeState.setVisibility(etChangeState.VISIBLE);
                etChangeAddress.setVisibility(etChangeAddress.VISIBLE);
                etChangePostal.setVisibility(etChangePostal.VISIBLE);
                etChangeHolder.setVisibility(etChangeHolder.VISIBLE);
                etChangeCardNum.setVisibility(etChangeCardNum.VISIBLE);
                etChangeCCV.setVisibility(etChangeCCV.VISIBLE);
            }
        });

        return view;
    }
}