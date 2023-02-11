package com.example.ilife_app_design;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.auth.api.identity.GetPhoneNumberHintIntentRequest;

public class PhoneNumFragmentR extends Fragment {

    EditText etPhoneNum, etPassw, etRepPassw, etName, etSurname;
    ImageView imgVisPassw, imgVisPasswRep;
    Button btnRegister;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_phone_num_r, container, false);

        etPhoneNum = (EditText) view.findViewById(R.id.etPhoneNumR);
        etPassw = (EditText) view.findViewById(R.id.etPasswR);
        etRepPassw = (EditText) view.findViewById(R.id.etRepPasswR);
        etName = (EditText) view.findViewById(R.id.etNameR);
        etSurname = (EditText) view.findViewById(R.id.etSurnameR);
        btnRegister = (Button) view.findViewById(R.id.btnRegister);
        imgVisPassw = (ImageView) view.findViewById(R.id.imgVisPassw);
        imgVisPasswRep = (ImageView) view.findViewById(R.id.imgVisPasswRep);

        imgVisPassw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etPassw.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                    etPassw.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    imgVisPassw.setImageResource(R.drawable.notvisible);
                } else {
                    etPassw.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    imgVisPassw.setImageResource(R.drawable.visibility);
                }
            }
        });

        imgVisPasswRep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etRepPassw.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                    etRepPassw.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    imgVisPasswRep.setImageResource(R.drawable.notvisible);
                } else {
                    etRepPassw.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    imgVisPasswRep.setImageResource(R.drawable.visibility);
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etPhoneNum.getText().toString().equals("")){
                    etPhoneNum.setError("Required", null);
                    etPhoneNum.setBackgroundResource(R.drawable.error_et);
                } else {
                    etPhoneNum.setBackgroundResource(R.drawable.bg_rounded_et);
                }

                if (etPassw.getText().toString().equals("")){
                    etPassw.setError("Required", null);
                    etPassw.setBackgroundResource(R.drawable.error_et);
                } else if(etPassw.getText().toString().length()<8 || etPassw.getText().toString().length()>20){
                    etPassw.setError("Must be greater than 8 and less than 20 characters long", null);
                    etPassw.setBackgroundResource(R.drawable.error_et);
                } else {
                    etPassw.setBackgroundResource(R.drawable.bg_rounded_et);
                }

                if (etRepPassw.getText().toString().equals("")){
                    etRepPassw.setError("Required", null);
                    etRepPassw.setBackgroundResource(R.drawable.error_et);
                } else if (!(etRepPassw.getText().toString() == etRepPassw.getText().toString())){
                    etRepPassw.setError("Passwords do not match", null);
                    etRepPassw.setBackgroundResource(R.drawable.error_et);
                } else {
                    etRepPassw.setBackgroundResource(R.drawable.bg_rounded_et);
                }

                if (etName.getText().toString().equals("")){
                    etName.setError("Required", null);
                    etName.setBackgroundResource(R.drawable.error_et);
                } else {
                    etName.setBackgroundResource(R.drawable.bg_rounded_et);
                }

                if (etSurname.getText().toString().equals("")){
                    etSurname.setError("Required", null);
                    etSurname.setBackgroundResource(R.drawable.error_et);
                } else {
                    etSurname.setBackgroundResource(R.drawable.bg_rounded_et);
                }
            }
        });

        return view;
    }
}