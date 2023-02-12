package com.example.ilife_app_design;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.ConnectionService;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class Register extends AppCompatActivity {

    TextView tvEmailReg, tvPhoneNumReg, tvLogintoAcc, tvOptE, tvOptP, tvTerms, tvPrivacy;
    ImageButton btnGoogle;
    GoogleSignInOptions googleSignInOptions;
    GoogleSignInClient googleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register);

        tvEmailReg = (TextView) findViewById(R.id.tvEmailReg);
        tvPhoneNumReg = (TextView) findViewById(R.id.tvPhoneNumReg);
        tvLogintoAcc = (TextView) findViewById(R.id.tvLogintoAcc);
        tvOptE = (TextView) findViewById(R.id.tvRegOptE);
        tvOptP = (TextView) findViewById(R.id.tvRegOptP);
        btnGoogle = (ImageButton) findViewById(R.id.btnGoogle);
        googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);
        tvTerms = (TextView) findViewById(R.id.tvTerms);
        tvPrivacy = (TextView) findViewById(R.id.tvPrivacy);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct!=null){
            navigateToHomeActivity();
        }

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

        tvLogintoAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startactivity();
            }
        });

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });

        tvTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTerms();
            }
        });

        tvPrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPrivacy();
            }
        });
    }

    private void startTerms() {
        Intent intent = new Intent(this, Terms_of_Use.class);
        startActivity(intent);
    }

    private void startPrivacy(){
        Intent intent = new Intent(this, Privacy_Policy.class);
        startActivity(intent);
    }

    private void startactivity() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutR, fragment);
        fragmentTransaction.commit();
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
    }
    void navigateToHomeActivity(){
        finish();
        Intent intent = new Intent(Register.this, Home.class);
        startActivity(intent);
    }
}