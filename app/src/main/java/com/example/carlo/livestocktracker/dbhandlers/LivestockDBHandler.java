package com.example.carlo.livestocktracker.dbhandlers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.carlo.livestocktracker.objects.Livestock;

import java.util.ArrayList;

/**
 * Created by Carlo on 3/11/2017.
 */

public class LivestockDBHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "LivestockTracker";
    // Contacts table name
    private static final String ls_details_tbl = "t_ls_details";
    // Shops Table Columns names
    private static final String lsd_id_c = "c_ls_id";
    private static final String lsd_tagNumber_c = "c_ls_tagNumber";
    private static final String lsd_breed_c = "c_ls_breed";
    private static final String lsd_type_c = "c_ls_type";
    private static final String lsd_houseNum_c = "c_ls_houseNum";
    private static final String lsd_weight_c = "c_ls_weight";

    public LivestockDBHandler(Context context){
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_ls_details_tbl = "CREATE TABLE " + ls_details_tbl +
                                       "(" + lsd_id_c + " INTEGER PRIMARY KEY,"
                                           + lsd_tagNumber_c + " TEXT,"
                                           + lsd_type_c + " TEXT,"
                                           + lsd_breed_c + " TEXT,"
                                           + lsd_houseNum_c + " TEXT,"
                                           + lsd_weight_c + " TEXT" +
                                        ")";
        db.execSQL(create_ls_details_tbl);
//        System.out.println("test");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + ls_details_tbl);
        onCreate(db);
    }

    // Adding new livestock
    public void addLivestock(Livestock livestock) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(lsd_id_c, livestock.getId());
        values.put(lsd_tagNumber_c, livestock.getNum());
        values.put(lsd_type_c, livestock.getType());
        values.put(lsd_breed_c, livestock.getBreed());
        values.put(lsd_houseNum_c, livestock.getHouseNum());
        values.put(lsd_weight_c, livestock.getWeight());

    // Inserting Row
        db.insert(ls_details_tbl, null, values);
        db.close(); // Closing database connection
    }

    public void updateLivestock(Livestock livestock){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

       // values.put(lsd_id_c, livestock.getId());
        values.put(lsd_tagNumber_c, livestock.getNum());
        values.put(lsd_type_c, livestock.getType());
        values.put(lsd_breed_c, livestock.getBreed());
        values.put(lsd_houseNum_c, livestock.getHouseNum());
        values.put(lsd_weight_c, livestock.getWeight());

        String[] whereClauseArgument = new String[1];
        whereClauseArgument[0] = livestock.getNum();
//getnum == tagnumber? yep

        db.update(ls_details_tbl, values, lsd_tagNumber_c+"=?", whereClauseArgument);
        db.close();

    }

    public Livestock getLivestock(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(ls_details_tbl, new String[] {lsd_id_c, lsd_tagNumber_c,
                                 lsd_type_c,lsd_breed_c, lsd_houseNum_c, lsd_weight_c},
                                 lsd_id_c + "=?", new String[] {String.valueOf(id)}, null, null,null,null);
        if (cursor != null)
            if (cursor != null)
                cursor.moveToFirst();

            Livestock livestock = new Livestock(cursor.getInt(0),
                    cursor.getString(1), 0, cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6));

            return livestock;
    }

    public boolean CheckIsDataAlreadyInDBorNot(int idValue) {
        SQLiteDatabase db = this.getReadableDatabase();
        String Query = "SELECT c_ls_id FROM " + ls_details_tbl + " WHERE " + lsd_id_c + " = " + idValue;
        Cursor cursor = db.rawQuery(Query, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public ArrayList<Livestock> getAllLivestock(){
        ArrayList<Livestock> livestockList = new ArrayList<Livestock>();
        String selectQuery = "SELECT * FROM " + ls_details_tbl;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do {
                Livestock livestock = new Livestock();
                livestock.setId(cursor.getInt(0));
                livestock.setNum(cursor.getString(1));
//                livestock.setPhoto(cursor.getInt(2));
                livestock.setType(cursor.getString(2));
                livestock.setBreed(cursor.getString(3));
                livestock.setHouseNum(cursor.getString(4));
                livestock.setWeight(cursor.getString(5));
                livestockList.add(livestock);
            }while (cursor.moveToNext());
        }
//        System.out.println(cursor.getColumnNames() + "a");
//        Log.d("tag", cursor + "asasda");
        return livestockList;

    }
}
