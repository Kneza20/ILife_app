package com.example.ilife_app_design;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Register extends AppCompatActivity {

    TextView tvEmailReg, tvPhoneNumReg, tvLogintoAcc, tvOptE, tvOptP;
    Button btnRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register);

        tvEmailReg = (TextView) findViewById(R.id.tvEmailReg);
        tvPhoneNumReg = (TextView) findViewById(R.id.tvPhoneNumReg);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        tvLogintoAcc = (TextView) findViewById(R.id.tvLogintoAcc);
        tvOptE = (TextView) findViewById(R.id.tvRegOptE);
        tvOptP = (TextView) findViewById(R.id.tvRegOptP);

        replaceFragment(new EmailFragmentR());
        tvOptE.setBackgroundResource(R.drawable.textview_border_visible);

        tvEmailReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new EmailFragmentR());
                tvOptE.setBackgroundResource(R.drawable.textview_border_visible);
                tvOptP.setBackgroundResource(R.drawable.textview_border_invisible);
            }
        });

        tvPhoneNumReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new PhoneNumFragmentR());
                tvOptP.setBackgroundResource(R.drawable.textview_border_visible);
                tvOptE.setBackgroundResource(R.drawable.textview_border_invisible);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        tvLogintoAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startactivity();
            }
        });
    }

    private void startactivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutR, fragment);
        fragmentTransaction.commit();
    }
}