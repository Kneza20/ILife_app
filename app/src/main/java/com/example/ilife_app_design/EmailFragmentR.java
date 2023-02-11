package com.example.ilife_app_design;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class EmailFragmentR extends Fragment {

    EditText etName, etSurname, etEmail, etPassword, etRepeat;
    ImageView imgVisPass, imgVisRep;
    Button btnRegister;
    DBHandler dbHandler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_email_r, container, false);

        etEmail = (EditText) view.findViewById(R.id.etEmailE);
        etPassword = (EditText) view.findViewById(R.id.etPasswordER);
        etRepeat = (EditText) view.findViewById(R.id.etRepPassw);
        etName = (EditText) view.findViewById(R.id.etNameE);
        etSurname = (EditText) view.findViewById(R.id.etSurnameE);
        btnRegister = (Button) view.findViewById(R.id.btnRegister);
        imgVisPass = (ImageView) view.findViewById(R.id.imgVisPass);
        imgVisRep = (ImageView) view.findViewById(R.id.imgVisRep);

        dbHandler = new DBHandler(getActivity());

        String name = etName.getText().toString();
        String surname = etSurname.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        imgVisPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etPassword.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    imgVisPass.setImageResource(R.drawable.notvisible);
                } else {
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    imgVisPass.setImageResource(R.drawable.visibility);
                }
            }
        });

        imgVisRep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etRepeat.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                    etRepeat.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    imgVisRep.setImageResource(R.drawable.notvisible);
                } else {
                    etRepeat.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    imgVisRep.setImageResource(R.drawable.visibility);
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHandler = new DBHandler(getContext());
                if (etEmail.getText().toString().equals("")){
                    etEmail.setError("Required", null);
                    etEmail.setBackgroundResource(R.drawable.error_et);
                } else if (!Patterns.EMAIL_ADDRESS.matcher(etEmail.getText().toString()).matches()){
                    etEmail.setError("Invalid email address", null);
                    etEmail.setBackgroundResource(R.drawable.error_et);
                } else {
                    etEmail.setBackgroundResource(R.drawable.bg_rounded_et);
                }

                if (etPassword.getText().toString().equals("")){
                    etPassword.setError("Required", null);
                    etPassword.setBackgroundResource(R.drawable.error_et);
                } else if(etPassword.getText().toString().length()<8 || etPassword.getText().toString().length()>20){
                    etPassword.setError("Must be greater than 8 and less than 20 characters long", null);
                    etPassword.setBackgroundResource(R.drawable.error_et);
                } else {
                    etPassword.setBackgroundResource(R.drawable.bg_rounded_et);
                }

                if (etRepeat.getText().toString().equals("")){
                    etRepeat.setError("Required", null);
                    etRepeat.setBackgroundResource(R.drawable.error_et);
                } else if (etRepeat.getText().toString() == etPassword.getText().toString()){
                    etRepeat.setError("Passwords do not match", null);
                    etRepeat.setBackgroundResource(R.drawable.error_et);
                } else {
                    etRepeat.setBackgroundResource(R.drawable.bg_rounded_et);
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

                if (!etName.getText().toString().equals("") && !etSurname.getText().toString().equals("") && !etEmail.getText().toString().equals("") && !etPassword.getText().toString().equals("")){
                    startactLogin();
                    dbHandler.addUser(etName.getText().toString().trim(),
                            etSurname.getText().toString().trim(),
                            etEmail.getText().toString().trim(),
                            etPassword.getText().toString().trim());
                }
            }
        });
        return view;
    }

    private void startactLogin() {
        Intent intent = new Intent(getActivity(), Login.class);
        startActivity(intent);
    }
}