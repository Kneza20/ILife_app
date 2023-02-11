package com.example.ilife_app_design;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.squareup.picasso.Picasso;

public class  Home extends AppCompatActivity{

    GoogleSignInOptions googleSignInOptions;
    GoogleSignInClient googleSignInClient;
    ImageView imgHamburger, imgX, imgDashboard, imgPayment, imgInfo, imgSignOut, imgProfile;
    TextView PopupMenu, tvNameSurn, tvDashboard, tvPayment, tvFAQ, tvUnderline;
    Button btnSignOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);

        googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);
        imgHamburger = (ImageView) findViewById(R.id.imgHamburgerDash);
        imgX = (ImageView) findViewById(R.id.imgX);
        PopupMenu = (TextView) findViewById(R.id.PopupMenu);
        btnSignOut = (Button) findViewById(R.id.btnSignOut);
        tvNameSurn = (TextView) findViewById(R.id.tvNameSurn);
        tvDashboard = (TextView) findViewById(R.id.tvDashboard);
        tvPayment = (TextView) findViewById(R.id.tvPayment);
        tvFAQ = (TextView) findViewById(R.id.tvFAQ);
        imgDashboard = (ImageView) findViewById(R.id.imgDashboard);
        imgPayment = (ImageView) findViewById(R.id.imgPayment);
        imgInfo = (ImageView) findViewById(R.id.imgInfo);
        imgSignOut = (ImageView) findViewById(R.id.imgSIgnOut);
        imgProfile = (ImageView) findViewById(R.id.imgProfile);
        tvUnderline = (TextView) findViewById(R.id.tvUnderline);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null){
            tvNameSurn.setText(acct.getDisplayName());
            Picasso.get().load(acct.getPhotoUrl()).placeholder(R.drawable.user).into(imgProfile);
        }

        imgHamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgHamburger.setVisibility(imgHamburger.INVISIBLE);
                imgX.setVisibility(imgX.VISIBLE);
                PopupMenu.setVisibility(PopupMenu.VISIBLE);
                tvNameSurn.setVisibility(tvNameSurn.VISIBLE);
                tvDashboard.setVisibility(tvDashboard.VISIBLE);
                tvPayment.setVisibility(tvPayment.VISIBLE);
                tvUnderline.setVisibility(tvUnderline.VISIBLE);
                tvFAQ.setVisibility(tvFAQ.VISIBLE);
                imgProfile.setVisibility(imgProfile.VISIBLE);
                imgDashboard.setVisibility(imgDashboard.VISIBLE);
                imgPayment.setVisibility(imgPayment.VISIBLE);
                imgInfo.setVisibility(imgInfo.VISIBLE);
                imgSignOut.setVisibility(imgSignOut.VISIBLE);
                btnSignOut.setVisibility(btnSignOut.VISIBLE);
                btnSignOut.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        signOut();
                    }
                });
            }
        });

        tvDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDashboard();
            }
        });

        tvPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDashboard();
            }
        });

        tvFAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFAQ();
            }
        });

        imgX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgX.setVisibility(imgX.INVISIBLE);
                imgHamburger.setVisibility(imgHamburger.VISIBLE);
                PopupMenu.setVisibility(PopupMenu.INVISIBLE);
                tvNameSurn.setVisibility(tvNameSurn.INVISIBLE);
                tvDashboard.setVisibility(tvDashboard.INVISIBLE);
                tvPayment.setVisibility(tvPayment.INVISIBLE);
                tvFAQ.setVisibility(tvFAQ.INVISIBLE);
                tvUnderline.setVisibility(tvUnderline.INVISIBLE);
                imgProfile.setVisibility(imgProfile.INVISIBLE);
                imgDashboard.setVisibility(imgDashboard.INVISIBLE);
                imgPayment.setVisibility(imgPayment.INVISIBLE);
                imgInfo.setVisibility(imgInfo.INVISIBLE);
                imgSignOut.setVisibility(imgSignOut.INVISIBLE);
                btnSignOut.setVisibility(btnSignOut.INVISIBLE);
            }
        });

    }

    public void startDashboard() {
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }

    private void startFAQ() {
        Intent intent = new Intent(this, FAQ.class);
        startActivity(intent);
    }

    void signOut(){
        googleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(Task<Void> task) {
                finish();
                startActivity(new Intent(Home.this, Login.class));
            }
        });
    }
}