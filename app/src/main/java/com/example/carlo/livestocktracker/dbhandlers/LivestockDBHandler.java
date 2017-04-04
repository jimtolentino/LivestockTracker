package com.example.carlo.livestocktracker.dbhandlers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.carlo.livestocktracker.objects.Livestock;

import java.util.ArrayList;

/**
 * Created by Carlo on 3/11/2017.
 */

public class LivestockDBHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 3;
    // Database Name
    private static final String DATABASE_NAME = "LivestockTrackerDBS";
    // table name
    private static final String LIVESTOCK_DETAILS = "livestock_details_tbl";
    //Table Columns names
    private static final String KEY_ID = "ls_id";
    private static final String KEY_NAME = "ls_name";
    private static final String KEY_TAG = "ls_tag";
    private static final String KEY_WEIGHT = "ls_weight";
    private static final String KEY_DATE_OF_BIRTH = "ls_dateOfBirth";
    private static final String KEY_TYPE = "ls_type";
    private static final String KEY_BREED = "ls_breed";
    private static final String KEY_OFFSPRING_CTR = "ls_offspring_ctr";
    private static final String KEY_STATUS = "ls_status";
    private static final String KEY_HOUSE_NUM = "ls_house_num";
    private static final String KEY_QR_CODE = "ls_qr_code";
    private static final String KEY_COMMENTS = "ls_comments";
    private static final String KEY_MED_HIST = "ls_med_hist";
    private static final String KEY_DISPLAY_PIC = "ls_display_pic";
    private static final String KEY_PHOTOS = "ls_photos";
    private static final String KEY_FARM = "ls_farm";
    private static final String KEY_INVESTOR = "ls_investor";
    private static final String KEY_INVESTMENT = "ls_investment";
    private static final String KEY_CREATED_AT = "ls_created_at";
    private static final String KEY_CREATOR = "ls_creator";


    private static final String TAG = "DBHandler";


    public LivestockDBHandler(Context context){
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            String create_livestock_details_tbl = "CREATE TABLE " + LIVESTOCK_DETAILS +
                    "(" + KEY_ID + " INTEGER PRIMARY KEY,"
                    + KEY_NAME + " TEXT,"
                    + KEY_TAG + " TEXT,"
                    + KEY_WEIGHT + " INTEGER,"
                    + KEY_DATE_OF_BIRTH + " DATE,"
                    + KEY_TYPE + " TEXT,"
                    + KEY_BREED + " TEXT,"
                    + KEY_OFFSPRING_CTR + " INTEGER,"
                    + KEY_STATUS + " TEXT,"
                    + KEY_HOUSE_NUM + " TEXT,"
                    + KEY_QR_CODE + " TEXT,"
                    + KEY_COMMENTS + " TEXT,"
                    + KEY_MED_HIST + " TEXT,"
                    + KEY_DISPLAY_PIC + " TEXT,"
                    + KEY_PHOTOS + " TEXT,"
                    + KEY_FARM + " TEXT,"
                    + KEY_INVESTOR + " TEXT,"
                    + KEY_INVESTMENT + " TEXT,"
                    + KEY_CREATED_AT + " DATE,"
                    + KEY_CREATOR + " TEXT" +
                    ");";
            db.execSQL(create_livestock_details_tbl);
        } catch (Exception e){
            Toast.makeText(null, e.getMessage(), Toast.LENGTH_SHORT).show();
            Log.i(TAG, e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + LIVESTOCK_DETAILS);
        onCreate(db);
    }

    // Adding new livestock
    public void addLivestock(Livestock livestock) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_ID, livestock.getId());
        values.put(KEY_NAME, livestock.getName());
        values.put(KEY_TAG, livestock.getTag());
        values.put(KEY_WEIGHT, livestock.getWeight());
        values.put(KEY_DATE_OF_BIRTH, "");
        values.put(KEY_TYPE, livestock.getType());
        values.put(KEY_BREED, livestock.getBreed());
        values.put(KEY_OFFSPRING_CTR, livestock.getOffSpringCounter());
        values.put(KEY_STATUS, livestock.getStatus());
        values.put(KEY_HOUSE_NUM, livestock.getHouseNumber());
        values.put(KEY_QR_CODE, livestock.getQrCode());
        values.put(KEY_COMMENTS, "");
        values.put(KEY_MED_HIST, "");
        values.put(KEY_DISPLAY_PIC, "");
        values.put(KEY_PHOTOS, "");
        values.put(KEY_FARM, "");
        values.put(KEY_INVESTOR, "");
        values.put(KEY_INVESTMENT, "");
        values.put(KEY_CREATED_AT, "");
        values.put(KEY_CREATOR, "");

    // Inserting Row
        db.insert(LIVESTOCK_DETAILS, null, values);
        db.close(); // Closing database connection
    }

    public void updateLivestock(Livestock livestock){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_ID, livestock.getId());
        values.put(KEY_NAME, livestock.getName());
        values.put(KEY_TAG, livestock.getTag());
        values.put(KEY_WEIGHT, livestock.getWeight());
        values.put(KEY_DATE_OF_BIRTH, "");
        values.put(KEY_TYPE, livestock.getType());
        values.put(KEY_BREED, livestock.getBreed());
        values.put(KEY_OFFSPRING_CTR, livestock.getOffSpringCounter());
        values.put(KEY_STATUS, livestock.getStatus());
        values.put(KEY_HOUSE_NUM, livestock.getHouseNumber());
        values.put(KEY_QR_CODE, livestock.getQrCode());
        values.put(KEY_COMMENTS, "");
        values.put(KEY_MED_HIST, "");
        values.put(KEY_DISPLAY_PIC, "");
        values.put(KEY_PHOTOS, "");
        values.put(KEY_FARM, "");
        values.put(KEY_INVESTOR, "");
        values.put(KEY_INVESTMENT, "");
        values.put(KEY_CREATED_AT, "");
        values.put(KEY_CREATOR, "");

//        values.put(KEY_NAME, livestock.getName());
//        values.put(KEY_TAG, livestock.getTag());
//        values.put(KEY_WEIGHT, livestock.getWeight());
//        values.put(KEY_DATE_OF_BIRTH, livestock.getDateOfBirth());
//        values.put(KEY_TYPE, livestock.getType());
//        values.put(KEY_BREED, livestock.getBreed());
//        values.put(KEY_OFFSPRING_CTR, livestock.getOffSpringCounter());
//        values.put(KEY_STATUS, livestock.getStatus());
//        values.put(KEY_HOUSE_NUM, livestock.getHouseNumber());
//        values.put(KEY_QR_CODE, livestock.getQrCode());
//        values.put(KEY_COMMENTS, livestock.getComments());
//        values.put(KEY_MED_HIST, livestock.getMedicalHistories());
//        values.put(KEY_DISPLAY_PIC, livestock.getDisplayPicture());
//        values.put(KEY_PHOTOS, livestock.getPhotos());
//        values.put(KEY_FARM, livestock.getFarm());
//        values.put(KEY_INVESTOR, livestock.getInvestor());
//        values.put(KEY_INVESTMENT, livestock.getInvestment());
//        values.put(KEY_CREATED_AT, livestock.getCreated_at());
//        values.put(KEY_CREATOR, livestock.getCreator());

        String[] whereClauseArgument = new String[1];
        whereClauseArgument[0] = String.valueOf(livestock.getTag());

        db.update(LIVESTOCK_DETAILS, values, KEY_TAG + "=?", whereClauseArgument);
        db.close();

    }

    public Livestock getLivestock(String tag){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(LIVESTOCK_DETAILS, new String[] {KEY_NAME,
                        KEY_TAG,KEY_WEIGHT, KEY_DATE_OF_BIRTH, KEY_TYPE, KEY_BREED,
                        KEY_OFFSPRING_CTR, KEY_STATUS, KEY_HOUSE_NUM, KEY_COMMENTS,
                        KEY_MED_HIST, KEY_DISPLAY_PIC, KEY_FARM, KEY_INVESTOR},
                                 KEY_TAG + "=?", new String[] {String.valueOf(tag)}, null, null,null,null);
        if (cursor != null)
            if (cursor != null)
                cursor.moveToFirst();

            Livestock livestock = new Livestock();

            livestock.setName(cursor.getString(0));
            livestock.setTag(cursor.getString(1));
            livestock.setWeight(cursor.getDouble(2));
//            livestock.setDateOfBirth(cursor.getString(3));
            livestock.setType(cursor.getString(4));
            livestock.setBreed(cursor.getString(5));
            livestock.setOffSpringCounter(cursor.getInt(6));
            livestock.setStatus(cursor.getString(7));
            livestock.setHouseNumber(cursor.getString(8));
//            livestock.setComments(cursor.getString(9));
//            livestock.setMedicalHistories(cursor.getString(10));
//            livestock.setDisplayPicture(cursor.getString(11));
//            livestock.setFarm(cursor.getString(12));
//            livestock.setInvestor(cursor.getString(13));

            return livestock;
    }

    public boolean CheckIsDataAlreadyInDBorNot(String qrCode1) {
        SQLiteDatabase db = this.getReadableDatabase();
        String Query = "SELECT * FROM " + LIVESTOCK_DETAILS + " WHERE " + KEY_QR_CODE + "=" + qrCode1;
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
        try{
        String selectQuery = "SELECT "+
                             KEY_NAME + "," +
                             KEY_TAG + "," +
                             KEY_WEIGHT + "," +
                             KEY_TYPE + "," +
                             KEY_BREED + "," +
                             KEY_OFFSPRING_CTR + "," +
                             KEY_STATUS + "," +
                             KEY_HOUSE_NUM +
                             " FROM " + LIVESTOCK_DETAILS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(LIVESTOCK_DETAILS, new String[] {KEY_NAME,
                        KEY_TAG,KEY_WEIGHT, KEY_TYPE, KEY_BREED,
                        KEY_OFFSPRING_CTR, KEY_STATUS, KEY_HOUSE_NUM},
                        null, null, null,null,null, null);

        if (cursor.moveToFirst()){
            do {
                Livestock livestock = new Livestock();

                livestock.setName(cursor.getString(0));
                livestock.setTag(cursor.getString(1));
                livestock.setWeight(cursor.getDouble(2));
//            livestock.setDateOfBirth(cursor.getString(3));
                livestock.setType(cursor.getString(3));
                livestock.setBreed(cursor.getString(4));
                livestock.setOffSpringCounter(cursor.getInt(5));
                livestock.setStatus(cursor.getString(6));
                livestock.setHouseNumber(cursor.getString(7));
//            livestock.setComments(cursor.getString(9));
//            livestock.setMedicalHistories(cursor.getString(10));
//            livestock.setDisplayPicture(cursor.getString(11));
//            livestock.setFarm(cursor.getString(12));
//            livestock.setInvestor(cursor.getString(13));
                livestockList.add(livestock);
            }while (cursor.moveToNext());
        }
//        System.out.println(cursor.getColumnNames() + "a");
//        Log.d("tag", cursor + "asasda");

    }catch (Exception e){
            Toast.makeText(null, e.getMessage(), Toast.LENGTH_SHORT).show();
            Log.i(TAG, e.getMessage());
    }
        return livestockList;
    }
}
