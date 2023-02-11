package com.example.ilife_app_design;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class Forgotpassword extends AppCompatActivity {

    EditText etEmail, etPhoneNum;
    Button btnSearchEmail, btnSearchPhoneNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_forgotpassword);

        etEmail = (EditText) findViewById(R.id.etRecEmail);
        etPhoneNum = (EditText) findViewById(R.id.etRecPhoneNum);
        btnSearchEmail = (Button) findViewById(R.id.btnSearchEmail);
        btnSearchPhoneNum = (Button) findViewById(R.id.btnSearchPhoneNum);

        btnSearchEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnSearchPhoneNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}