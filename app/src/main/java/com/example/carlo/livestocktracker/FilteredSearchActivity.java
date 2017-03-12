package com.example.carlo.livestocktracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Carlo on 2/26/2017.
 */

public class FilteredSearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Getting array of String to Bind in Spinner
         */
        final List<String> list = Arrays.asList(getResources().getStringArray(R.array.lstocktype_array));

        final List<KeyPairBoolData> listArray = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            KeyPairBoolData h = new KeyPairBoolData();
            h.setId(i + 1);
            h.setName(list.get(i));
            h.setSelected(false);
            listArray.add(h);
        }

        final List<KeyPairBoolData> listArray2 = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            KeyPairBoolData h = new KeyPairBoolData();
            h.setId(i + 1);
            h.setName(list.get(i));
            h.setSelected(false);
            listArray2.add(h);
        }
        final List<KeyPairBoolData> listArray3 = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            KeyPairBoolData h = new KeyPairBoolData();
            h.setId(i + 1);
            h.setName(list.get(i));
            h.setSelected(false);
            listArray3.add(h);
        }
        /**
         * Simple MultiSelection Spinner (Without Search/Filter Functionlity)
         *
         *  Using MultiSpinner class
         */
        /*MultiSpinner simpleSpinner = (MultiSpinner) findViewById(R.id.simpleMultiSpinner);

        simpleSpinner.setItems(listArray, -1, new MultiSpinnerListener() {

            @Override
            public void onItemsSelected(boolean[] selected) {
            }

        });*/

        /**
         * Search MultiSelection Spinner (With Search/Filter Functionality)
         *
         *  Using MultiSpinnerSearch class
         */
        MultiSpinnerSearch SpinnerType = (MultiSpinnerSearch) findViewById(R.id.filter_type);
        MultiSpinnerSearch SpinnerBreed = (MultiSpinnerSearch) findViewById(R.id.filter_breed);
        MultiSpinnerSearch SpinnerHouseNum = (MultiSpinnerSearch) findViewById(R.id.filter_houseNum);

        /***
         * -1 is no by default selection
         * 0 to length will select corresponding values
         */
        SpinnerType.setItems(listArray, -1, new SpinnerListener() {

            @Override
            public void onItemsSelected(List<KeyPairBoolData> items) {

                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).isSelected()) {
                        Log.i("TAG", i + " : " + items.get(i).getName() + " : " + items.get(i).isSelected());
                    }
                }
            }
        });

        SpinnerType.setLimit(-1, new MultiSpinnerSearch.LimitExceedListener() {
            @Override
            public void onLimitListener(KeyPairBoolData data) {
                Toast.makeText(getApplicationContext(),
                        "Limit exceed ", Toast.LENGTH_LONG).show();
            }
        });

        SpinnerBreed.setItems(listArray, -1, new SpinnerListener() {

            @Override
            public void onItemsSelected(List<KeyPairBoolData> items) {

                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).isSelected()) {
                        Log.i("TAG", i + " : " + items.get(i).getName() + " : " + items.get(i).isSelected());
                    }
                }
            }
        });

        SpinnerBreed.setLimit(-1, new MultiSpinnerSearch.LimitExceedListener() {
            @Override
            public void onLimitListener(KeyPairBoolData data) {
                Toast.makeText(getApplicationContext(),
                        "Limit exceed ", Toast.LENGTH_LONG).show();
            }
        });

        SpinnerHouseNum.setItems(listArray, -1, new SpinnerListener() {

            @Override
            public void onItemsSelected(List<KeyPairBoolData> items) {

                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).isSelected()) {
                        Log.i("TAG", i + " : " + items.get(i).getName() + " : " + items.get(i).isSelected());
                    }
                }
            }
        });

        SpinnerHouseNum.setLimit(-1, new MultiSpinnerSearch.LimitExceedListener() {
            @Override
            public void onLimitListener(KeyPairBoolData data) {
                Toast.makeText(getApplicationContext(),
                        "Limit exceed ", Toast.LENGTH_LONG).show();
            }
        });

    }
}

