package com.example.ilife_app_design;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.squareup.picasso.Picasso;

public class UserProfile extends Fragment {

    TextView tvNameField, etUserName, etUserSurname, etUserMail, etUserPassw;
    EditText etChangeName, etChangeSurname, etChangeEmail, etChangePassword;
    ImageView imgProf, imgSave, imgPencil;
    GoogleSignInOptions googleSignInOptions;
    HorizontalScrollView horizontalScrollView, horizontalScrollViewET;
    @SuppressLint("Range")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);

        DatabaseManager dbManager = new DatabaseManager(getActivity());
        DBHandler dbHandler = new DBHandler(getActivity());
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        try {
            dbManager.open();
        } catch (Exception e){
            e.printStackTrace();
        }

        googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        tvNameField = (TextView) view.findViewById(R.id.tvNameField);
        imgProf = (ImageView) view.findViewById(R.id.imgProf);
        etUserName = (TextView) view.findViewById(R.id.tvUserName);
        etUserSurname = (TextView) view.findViewById(R.id.tvUserSurname);
        etUserMail = (TextView) view.findViewById(R.id.tvUserMail);
        etUserPassw = (TextView) view.findViewById(R.id.tvUserPassw);
        imgSave = (ImageView) view.findViewById(R.id.imgSave);
        imgPencil = (ImageView) view.findViewById(R.id.imgPencil);
        etChangeName = (EditText) view.findViewById(R.id.etChangeName);
        etChangeSurname = (EditText) view.findViewById(R.id.etChangeSurname);
        etChangeEmail = (EditText) view.findViewById(R.id.etChangeEmail);
        etChangePassword = (EditText) view.findViewById(R.id.etChangePassword);
        horizontalScrollView = (HorizontalScrollView) view.findViewById(R.id.horizontalScrollView);
        horizontalScrollViewET = (HorizontalScrollView) view.findViewById(R.id.horizontalScrollViewET);

        Cursor cursor = dbManager.fetch();
        if (cursor.moveToFirst()){
            do {
                String id = cursor.getString(cursor.getColumnIndex(DBHandler.ID_COL));
                String name = cursor.getString(cursor.getColumnIndex(DBHandler.NAME_COL));
                String surname = cursor.getString(cursor.getColumnIndex(DBHandler.SURNAME_COL));
                String email = cursor.getString(cursor.getColumnIndex(DBHandler.EMAIL_COL));
                String password = cursor.getString(cursor.getColumnIndex(DBHandler.PASSWORD_COL));
                Log.i("DATABASE_TAG", "I have read ID: " + id + " Name: " + name + " Surname: " + surname + " Email: " + email + " Password: " + password);

                tvNameField.setText(name + " " + surname);
                etUserName.setText(name);
                etUserSurname.setText(surname);
                etUserMail.setText(email);
                etUserPassw.setText(password);
            }while (cursor.moveToNext());
        }

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
                etUserName.setVisibility(etUserName.VISIBLE);
                etUserSurname.setVisibility(etUserSurname.VISIBLE);
                etUserMail.setVisibility(etUserMail.VISIBLE);
                etUserPassw.setVisibility(etUserPassw.VISIBLE);
                etChangeName.setVisibility(etChangeName.INVISIBLE);
                etChangeSurname.setVisibility(etChangeSurname.INVISIBLE);
                etChangeName.setVisibility(etChangeName.VISIBLE);
                etChangeSurname.setVisibility(etChangeSurname.VISIBLE);
                etChangeEmail.setVisibility(etChangeEmail.INVISIBLE);
                etChangePassword.setVisibility(etChangePassword.INVISIBLE);
                horizontalScrollView.setVisibility(horizontalScrollView.VISIBLE);
                horizontalScrollViewET.setVisibility(horizontalScrollViewET.INVISIBLE);
            }
        });

        imgPencil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgPencil.setVisibility(imgPencil.INVISIBLE);
                imgSave.setVisibility(imgSave.VISIBLE);
                etUserName.setVisibility(etUserName.INVISIBLE);
                etUserSurname.setVisibility(etUserSurname.INVISIBLE);
                etUserMail.setVisibility(etUserMail.INVISIBLE);
                etUserPassw.setVisibility(etUserPassw.INVISIBLE);
                etChangeEmail.setVisibility(etChangeEmail.VISIBLE);
                etChangePassword.setVisibility(etChangePassword.VISIBLE);
                horizontalScrollView.setVisibility(horizontalScrollView.INVISIBLE);
                horizontalScrollViewET.setVisibility(horizontalScrollViewET.VISIBLE);
            }
        });

        return view;
    }
}