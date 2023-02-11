package com.example.ilife_app_design;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
import android.widget.Toast;

import java.util.ArrayList;

public class EmailFragment extends Fragment {

    EditText etEmail, etPasswordE;
    ImageView imgVisPassw;
    TextView tvForgotPassw;
    Button btnLogin;

    DBHandler dbHandler;
    ArrayList<String> user_id, user_name, user_surname, user_email, user_password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_email, container, false);

        etEmail = (EditText) view.findViewById(R.id.etEmail);
        etPasswordE = (EditText) view.findViewById(R.id.etPasswordE);
        btnLogin = (Button) view.findViewById(R.id.btnLogin);
        tvForgotPassw = (TextView) view.findViewById(R.id.tvForgotPassw);
        imgVisPassw = (ImageView) view.findViewById(R.id.imgVisPassw);

        dbHandler = new DBHandler(getActivity());
        SQLiteDatabase db = dbHandler.getReadableDatabase();

        imgVisPassw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etPasswordE.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())) {
                    etPasswordE.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    imgVisPassw.setImageResource(R.drawable.notvisible);
                } else {
                    etPasswordE.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    imgVisPassw.setImageResource(R.drawable.visibility);
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String password = etPasswordE.getText().toString();

                if (etEmail.getText().toString().equals("")) {
                    etEmail.setError("Required", null);
                    etEmail.setBackgroundResource(R.drawable.error_et);
                } else {
                    etEmail.setBackgroundResource(R.drawable.bg_rounded_et);
                }

                if (etPasswordE.getText().toString().equals("")) {
                    etPasswordE.setError("Required", null);
                    etPasswordE.setBackgroundResource(R.drawable.error_et);
                } else {
                    etPasswordE.setBackgroundResource(R.drawable.bg_rounded_et);
                }

                if (!etEmail.getText().toString().equals("") && !etPasswordE.getText().toString().equals("")){
                    Boolean checkemailpass = dbHandler.checkEmailPassword(email, password);
                    if (checkemailpass == true){
                        Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();
                        startactHome();
                    } else {
                        Toast.makeText(getActivity(), "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
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

    private void startactHome() {
        Intent intent = new Intent(getActivity(), Home.class);
        startActivity(intent);
    }

    private void startactivity() {
        Intent intent = new Intent(getActivity(), Forgotpassword.class);
        startActivity(intent);
    }
}