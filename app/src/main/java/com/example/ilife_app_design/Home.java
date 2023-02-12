package com.example.ilife_app_design;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
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
    ImageView imgHamburger, imgX, imgDashboard, imgPayment, imgInfo, imgSignOut, imgProfile,
    imgStar1, imgStar2, imgStar3, imgStar4, imgStar5;
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
        imgStar1 = (ImageView) findViewById(R.id.imgStar1);
        imgStar2 = (ImageView) findViewById(R.id.imgStar2);
        imgStar3 = (ImageView) findViewById(R.id.imgStar3);
        imgStar4 = (ImageView) findViewById(R.id.imgStar4);
        imgStar5 = (ImageView) findViewById(R.id.imgStar5);

        DatabaseManager dbManager = new DatabaseManager(this);
        DBHandler dbHandler = new DBHandler(this);
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        try {
            dbManager.open();
        } catch (Exception e){
            e.printStackTrace();
        }

        imgStar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgStar1.setImageResource(R.drawable.staryellow);
                imgStar2.setImageResource(R.drawable.star);
                imgStar3.setImageResource(R.drawable.star);
                imgStar4.setImageResource(R.drawable.star);
                imgStar5.setImageResource(R.drawable.star);
            }
        });

        imgStar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgStar1.setImageResource(R.drawable.staryellow);
                imgStar2.setImageResource(R.drawable.staryellow);
                imgStar3.setImageResource(R.drawable.star);
                imgStar4.setImageResource(R.drawable.star);
                imgStar5.setImageResource(R.drawable.star);
            }
        });

        imgStar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgStar1.setImageResource(R.drawable.staryellow);
                imgStar2.setImageResource(R.drawable.staryellow);
                imgStar3.setImageResource(R.drawable.staryellow);
                imgStar4.setImageResource(R.drawable.star);
                imgStar5.setImageResource(R.drawable.star);
            }
        });

        imgStar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgStar1.setImageResource(R.drawable.staryellow);
                imgStar2.setImageResource(R.drawable.staryellow);
                imgStar3.setImageResource(R.drawable.staryellow);
                imgStar4.setImageResource(R.drawable.staryellow);
                imgStar5.setImageResource(R.drawable.star);
            }
        });

        imgStar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgStar1.setImageResource(R.drawable.staryellow);
                imgStar2.setImageResource(R.drawable.staryellow);
                imgStar3.setImageResource(R.drawable.staryellow);
                imgStar4.setImageResource(R.drawable.staryellow);
                imgStar5.setImageResource(R.drawable.staryellow);
            }
        });

        Cursor cursor = dbManager.fetch();
        if (cursor.moveToFirst()){
            do {
                @SuppressLint("Range") String id = cursor.getString(cursor.getColumnIndex(DBHandler.ID_COL));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(DBHandler.NAME_COL));
                @SuppressLint("Range") String surname = cursor.getString(cursor.getColumnIndex(DBHandler.SURNAME_COL));
                @SuppressLint("Range") String email = cursor.getString(cursor.getColumnIndex(DBHandler.EMAIL_COL));
                @SuppressLint("Range") String password = cursor.getString(cursor.getColumnIndex(DBHandler.PASSWORD_COL));
                Log.i("DATABASE_TAG", "I have read ID: " + id + " Name: " + name + " Surname: " + surname + " Email: " + email + " Password: " + password);

                tvNameSurn.setText(name + " " + surname);
            }while (cursor.moveToNext());
        }

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