package com.example.ilife_app_design;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class DatabaseManager {
    private DBHandler dbHandler;
    private Context context;
    private SQLiteDatabase db;

    public DatabaseManager(Context ct){
        context = ct;
    }

    public DatabaseManager open() throws SQLiteException {
        dbHandler = new DBHandler(context);
        db = dbHandler.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHandler.close();
    }

    public void insert(String name, String surname, String email, String password){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHandler.NAME_COL, name);
        contentValues.put(DBHandler.SURNAME_COL, surname);
        contentValues.put(DBHandler.EMAIL_COL, email);
        contentValues.put(DBHandler.PASSWORD_COL, password);
        db.insert(DBHandler.TABLE_NAME, name, contentValues);
    }

    public Cursor fetch() {
        String [] columns = new String[] {DBHandler.ID_COL, DBHandler.NAME_COL, DBHandler.SURNAME_COL, DBHandler.EMAIL_COL, DBHandler.PASSWORD_COL};
        Cursor cursor = db.query(DBHandler.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long id, String name, String surname, String email, String password){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHandler.NAME_COL, name);
        contentValues.put(DBHandler.SURNAME_COL, surname);
        contentValues.put(DBHandler.EMAIL_COL, email);
        contentValues.put(DBHandler.PASSWORD_COL, password);
        int ret = db.update(DBHandler.TABLE_NAME, contentValues, DBHandler.ID_COL + " = " + id, null);
        return ret;
    }

    public void delete(long id){
        db.delete(DBHandler.TABLE_NAME, DBHandler.ID_COL + " = " + id, null);
    }
}
