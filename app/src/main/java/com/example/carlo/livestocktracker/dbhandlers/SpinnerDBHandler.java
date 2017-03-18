package com.example.carlo.livestocktracker.dbhandlers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Carlo on 3/18/2017.
 */

public class SpinnerDBHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "LivestockTracker";
    // Contacts table name
    private static final String s_breedType_tbl = "t_spinner_breedType";
    // Shops Table Columns names
    private static final String spinner_id_c = "spinner_id";
    private static final String spinner_breed_c = "spinner_breed";
    private static final String spinner_type_c = "spinner_type";


    public SpinnerDBHandler (Context context){
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        String create_s_breedType_tbl = "CREATE TABLE " + s_breedType_tbl +
                "(" + spinner_id_c + " INTEGER PRIMARY KEY,"
                + spinner_breed_c + " TEXT,"
                + spinner_type_c + " TEXT" +
                ")";
        db.execSQL(create_s_breedType_tbl);
//        System.out.println("test");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + s_breedType_tbl);
        onCreate(db);
    }



}




