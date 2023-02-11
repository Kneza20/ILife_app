package com.example.ilife_app_design;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class Dashboard extends AppCompatActivity {

    ImageView imgUser, imgPay, imgReserved, imgHome, btnSignOut, imgHamburger, imgClose;
    TextView tvDashboardBg;
    GoogleSignInClient googleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_dashboard);
        imgUser = (ImageView) findViewById(R.id.imgUser);
        imgPay = (ImageView) findViewById(R.id.imgPay);
        imgReserved = (ImageView) findViewById(R.id.imgReserved);
        imgHome = (ImageView) findViewById(R.id.imgHome);
        btnSignOut = (ImageView) findViewById(R.id.btnSignOut);
        imgHamburger = (ImageView) findViewById(R.id.imgHamburgerDash);
        imgClose = (ImageView) findViewById(R.id.imgClose);
        tvDashboardBg = (TextView) findViewById(R.id.tvDashboardBg);

        replace(new UserProfile());
        imgHamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgHamburger.setVisibility(imgHamburger.INVISIBLE);
                tvDashboardBg.setVisibility(tvDashboardBg.VISIBLE);
                imgClose.setVisibility(imgClose.VISIBLE);
                imgUser.setVisibility(imgUser.VISIBLE);
                imgPay.setVisibility(imgPay.VISIBLE);
                imgReserved.setVisibility(imgReserved.VISIBLE);
                imgHome.setVisibility(imgHome.VISIBLE);
                btnSignOut.setVisibility(btnSignOut.VISIBLE);
            }
        });

        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgHamburger.setVisibility(imgHamburger.VISIBLE);
                tvDashboardBg.setVisibility(tvDashboardBg.INVISIBLE);
                imgClose.setVisibility(imgClose.INVISIBLE);
                imgUser.setVisibility(imgUser.INVISIBLE);
                imgPay.setVisibility(imgPay.INVISIBLE);
                imgReserved.setVisibility(imgReserved.INVISIBLE);
                imgHome.setVisibility(imgHome.INVISIBLE);
                btnSignOut.setVisibility(btnSignOut.INVISIBLE);
            }
        });

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });

        imgUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replace(new UserProfile());
            }
        });

        imgPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replace(new Pay());
            }
        });

        imgReserved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replace(new Reserved());
            }
        });

        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startactivity();
            }
        });
    }

    private void startactivity() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    private void startactivity2() {
        Intent intent1 = new Intent(this, Login.class);
        startActivity(intent1);
    }

    public void signOut(){
        googleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(Task<Void> task) {
                startactivity2();
                finish();
            }
        });
    }

    private void replace(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_dashboard, fragment);
        fragmentTransaction.commit();
    }
}