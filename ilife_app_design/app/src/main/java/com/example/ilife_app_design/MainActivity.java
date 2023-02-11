package com.example.ilife_app_design;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvCreateAcc, tvForgotPassw, tvEmailOpt, tvPhoneNumOpt, tvLoginBackground, tvLogin, tvNoAcc, tvOptE, tvOptP;
    Button btnLogin;
    ImageView imgEmailico, imgPhoneNumico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);
        tvCreateAcc = (TextView) findViewById(R.id.tvCreateAcc);
        tvForgotPassw = (TextView) findViewById(R.id.tvForgotPassw);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        tvEmailOpt = (TextView) findViewById(R.id.tvEmailOpt);
        tvPhoneNumOpt = (TextView) findViewById(R.id.tvPhoneNumOpt);
        tvLoginBackground = (TextView) findViewById(R.id.tvLoginBackground);
        tvLogin = (TextView) findViewById(R.id.tvLogin);
        tvNoAcc = (TextView) findViewById(R.id.tvNoacc);
        imgEmailico = (ImageView) findViewById(R.id.imgEmailico);
        imgPhoneNumico = (ImageView) findViewById(R.id.imgPhoneNumico);
        tvOptE = (TextView) findViewById(R.id.tvOptEmail);
        tvOptP = (TextView) findViewById(R.id.tvOptPhone);

        replaceFragment(new EmailFragment());
        tvOptE.setBackgroundResource(R.drawable.textview_border_visible);

        tvEmailOpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new EmailFragment());
                tvOptE.setBackgroundResource(R.drawable.textview_border_visible);
                tvOptP.setBackgroundResource(R.drawable.textview_border_invisible);
            }
        });

        tvPhoneNumOpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new PhoneNumFragment());
                tvOptP.setBackgroundResource(R.drawable.textview_border_visible);
                tvOptE.setBackgroundResource(R.drawable.textview_border_invisible);
            }
        });

        tvCreateAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startactivity2();
            }
        });

        tvForgotPassw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startactivity3();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    public void onConfigurationChanged(Configuration configuration){

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }

    private void startactivity2() {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }

    private void startactivity3() {
        Intent intent = new Intent(this, Forgotpassword.class);
        startActivity(intent);
    }
}