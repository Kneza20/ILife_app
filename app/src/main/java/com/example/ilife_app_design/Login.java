package com.example.ilife_app_design;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class Login extends AppCompatActivity {

    TextView tvCreateAcc, tvForgotPassw, tvEmailOpt, tvPhoneNumOpt, tvLoginBackground, tvLogin, tvNoAcc, tvOptE, tvOptP;
    Button btnLogin;
    ImageView imgEmailico, imgPhoneNumico;
    ImageButton btnGoogle, btnTwitter;
    GoogleSignInOptions googleSignInOptions;
    GoogleSignInClient googleSignInClient;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_login);
        tvCreateAcc = (TextView) findViewById(R.id.tvCreateAcc);
        tvEmailOpt = (TextView) findViewById(R.id.tvEmailOpt);
        tvPhoneNumOpt = (TextView) findViewById(R.id.tvPhoneNumOpt);
        tvLoginBackground = (TextView) findViewById(R.id.tvLoginBackground);
        tvLogin = (TextView) findViewById(R.id.tvLogin);
        tvNoAcc = (TextView) findViewById(R.id.tvNoacc);
        imgEmailico = (ImageView) findViewById(R.id.imgEmailico);
        imgPhoneNumico = (ImageView) findViewById(R.id.imgPhoneNumico);
        tvOptE = (TextView) findViewById(R.id.tvOptEmail);
        tvOptP = (TextView) findViewById(R.id.tvOptPhone);
        btnGoogle = (ImageButton) findViewById(R.id.btnGoogle);
        googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);
        btnTwitter = (ImageButton) findViewById(R.id.btnTwitter);

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

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });
    }

    void signIn(){
        Intent signInIntent = googleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                task.getResult(ApiException.class);
                navigateToHomeActivity();
            } catch (ApiException e) {
                Toast.makeText(this, "Something went wrong.", Toast.LENGTH_SHORT).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    void navigateToHomeActivity(){
        finish();
        Intent intent = new Intent(Login.this, Home.class);
        startActivity(intent);
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
}