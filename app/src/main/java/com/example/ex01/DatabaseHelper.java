package com.example.ex01;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "citizen.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_CITIZEN = "tblCitizen";

    private static final String CREATE_TABLE_CITIZEN = "CREATE TABLE " + TABLE_CITIZEN + " (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name TEXT," +
            "identification TEXT," +
            "address TEXT" +
            ");";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CITIZEN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CITIZEN);
        onCreate(db);
    }

    public void addCitizen(Citizen citizen) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", citizen.getName());
        values.put("identification", citizen.getIdentification());
        values.put("address", citizen.getAddress());
        db.insert(TABLE_CITIZEN, null, values);
        db.close();
    }

    public ArrayList<Citizen> getAllCitizens() {
        ArrayList<Citizen> citizenList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_CITIZEN, null);
        if (cursor.moveToFirst()) {
            do {
                Citizen citizen = new Citizen(
                        cursor.getString(1), // name
                        cursor.getString(2), // identification
                        cursor.getString(3)  // address
                );
                citizen.setId(cursor.getInt(0)); // set ID
                citizenList.add(citizen);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return citizenList;
    }
}
