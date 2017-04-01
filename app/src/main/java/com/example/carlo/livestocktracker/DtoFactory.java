package com.example.carlo.livestocktracker;

//import android.app.Application;
import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.example.carlo.livestocktracker.dbhandlers.LivestockDBHelper;
import com.example.carlo.livestocktracker.objects.Livestock;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.io.File;
import java.sql.SQLException;

/**
 * Created by Carlo on 3/29/2017.
 */

public class DtoFactory extends Application {

    private SharedPreferences preferences;
    private LivestockDBHelper livestockDBHelper = null;

    private Dao<Livestock, Integer> livestockDAO = null;

    @Override
    public void onCreate() {
        super.onCreate();
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        livestockDBHelper = new LivestockDBHelper(this);
    }

    public SharedPreferences getPreferences() {return preferences;}

    public Dao<Livestock, Integer> getLivestockDao() throws SQLException {
        if (livestockDAO == null) {
            livestockDAO = livestockDBHelper.getDao(Livestock.class);
        }
        return livestockDAO;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        if (livestockDBHelper != null) {
            OpenHelperManager.releaseHelper();
            livestockDBHelper = null;
        }
    }
}