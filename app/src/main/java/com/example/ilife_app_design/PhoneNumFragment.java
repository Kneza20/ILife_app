package com.example.ilife_app_design;

import android.content.Intent;
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
import android.widget.TextView;

import java.sql.BatchUpdateException;

public class PhoneNumFragment extends Fragment {

    EditText etPhoneNum, etPasswL;
    ImageView imgVisPassw;
    TextView tvForgotPassw;
    Button btnLogin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_phone_num, container, false);

        etPhoneNum = (EditText) view.findViewById(R.id.etPhoneNumLog);
        etPasswL = (EditText) view.findViewById(R.id.etPassL);
        tvForgotPassw = (TextView) view.findViewById(R.id.tvForgotPassw);
        btnLogin = (Button) view.findViewById(R.id.btnLogin);
        imgVisPassw = (ImageView) view.findViewById(R.id.imgVisPassw);

        imgVisPassw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etPasswL.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                    etPasswL.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    imgVisPassw.setImageResource(R.drawable.notvisible);
                } else {
                    etPasswL.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    imgVisPassw.setImageResource(R.drawable.visibility);
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etPhoneNum.getText().toString().equals("")){
                    etPhoneNum.setError("Required", null);
                    etPhoneNum.setBackgroundResource(R.drawable.error_et);
                } else {
                    etPhoneNum.setBackgroundResource(R.drawable.bg_rounded_et);
                }

                if (etPasswL.getText().toString().equals("")){
                    etPasswL.setError("Required", null);
                    etPasswL.setBackgroundResource(R.drawable.error_et);
                } else {
                    etPasswL.setBackgroundResource(R.drawable.bg_rounded_et);
                }
            }
        });

        tvForgotPassw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startactivity();
            }
        });

        return view;
    }

    private void startactivity() {
        Intent intent = new Intent(getActivity(), Forgotpassword.class);
        startActivity(intent);
    }
}