package com.example.carlo.livestocktracker;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.carlo.livestocktracker.fragments.LivestockFragment;
import com.example.carlo.livestocktracker.fragments.ScannerFragment;
import com.google.zxing.Result;

import java.util.ArrayList;
import java.util.List;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

//import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity{

//    private TextView textLivestock;
//    private TextView textScan;
//    private TextView textNotification;
//    private GridLayoutManager lLayout;
//    private ZXingScannerView qrScan;
//    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new LivestockFragment());
        fragmentTransaction.commit();

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment fr = null;

                        int id = item.getItemId();
                        if (id == R.id.nav_livestock) {
                            fr = new LivestockFragment();
                        } else if (id == R.id.nav_scan) {
                            fr = new ScannerFragment();
                        } /*else if (id == R.id.nav_packages) {
                            fr = new PackagesFragment();
                        }*/
                        FragmentManager fm = getFragmentManager();
                        FragmentTransaction fragmentTransaction = fm.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container, fr);
                        fragmentTransaction.commit();
//                        switch (item.getItemId()) {
//                            case R.id.action_livestock:
//                                qrScan.setVisibility(View.GONE);
//                                textNotification.setVisibility(View.GONE);
//                                rView.setVisibility(View.VISIBLE);
//                                break;
//                            case R.id.action_scan:
//                                qrScan.setVisibility(View.VISIBLE);
//                                textNotification.setVisibility(View.GONE);
//                                rView.setVisibility(View.GONE);
//                                onClick(qrScan);
//                                break;
//                            case R.id.action_notification:
//                                qrScan.setVisibility(View.GONE);
//                                textNotification.setVisibility(View.VISIBLE);
//                                rView.setVisibility(View.GONE);
//                                break;
//                        }
                        return true;
                    }


                });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        if(id == R.id.action_refresh){
//            Toast.makeText(MainActivity.this, "Refresh App", Toast.LENGTH_LONG).show();
//        }
//        if (id == R.id.text_scan) {
//
//            return true;
//        }
//
//
//        return super.onOptionsItemSelected(item);
//    }






}