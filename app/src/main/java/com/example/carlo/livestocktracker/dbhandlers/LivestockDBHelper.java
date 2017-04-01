package com.example.carlo.livestocktracker.dbhandlers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.carlo.livestocktracker.objects.Livestock;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by Carlo on 3/29/2017.
 */

public class LivestockDBHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "LivestockTracker";
    private static final int DATABASE_VERSION = 1;

    public LivestockDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            Log.i(LivestockDBHelper.class.getName(), "onCreate");
            TableUtils.createTable(connectionSource, Livestock.class);
        } catch (SQLException e) {
            Log.e(LivestockDBHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            Log.i(LivestockDBHelper.class.getName(), "onUpgrade");
            TableUtils.dropTable(connectionSource, Livestock.class, true);
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            Log.e(LivestockDBHelper.class.getName(), "Can't drop databases", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        super.close();
    }
}
