package com.example.ilife_app_design;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.squareup.picasso.Picasso;

public class UserProfile extends Fragment {

    TextView tvNameField, etUserName, etUserSurname, etUserMail, etUserPassw;;
    ImageView imgProf, imgSave, imgPencil;
    GoogleSignInOptions googleSignInOptions;
    @SuppressLint("Range")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);

        DBHandler dbHandler = new DBHandler(getActivity());
        SQLiteDatabase db = dbHandler.getReadableDatabase();

        googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        tvNameField = (TextView) view.findViewById(R.id.tvNameField);
        imgProf = (ImageView) view.findViewById(R.id.imgProf);
        etUserName = (TextView) view.findViewById(R.id.tvUserName);
        etUserSurname = (TextView) view.findViewById(R.id.tvUserSurname);
        etUserMail = (TextView) view.findViewById(R.id.tvUserMail);
        etUserPassw = (TextView) view.findViewById(R.id.tvUserPassw);
        imgSave = (ImageView) view.findViewById(R.id.imgSave);
        imgPencil = (ImageView) view.findViewById(R.id.imgPencil);

        String name = tvNameField.getText().toString();
        String surname = etUserSurname.getText().toString();
        String email = etUserMail.getText().toString();
        String password = etUserPassw.getText().toString();



        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getContext());
        if (acct != null){
            tvNameField.setText(acct.getDisplayName());
            String[] arr = acct.getDisplayName().split(" ");
            String fname = arr[0];
            String lname = arr[1];
            etUserName.setText(fname);
            etUserSurname.setText(lname);
            etUserMail.setText(acct.getEmail());
            Picasso.get().load(acct.getPhotoUrl()).placeholder(R.drawable.user).into(imgProf);
        }

        imgSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgPencil.setVisibility(imgPencil.VISIBLE);
                imgSave.setVisibility(imgSave.INVISIBLE);
            }
        });

        imgPencil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgPencil.setVisibility(imgPencil.INVISIBLE);
                imgSave.setVisibility(imgSave.VISIBLE);
            }
        });

        return view;
    }
}