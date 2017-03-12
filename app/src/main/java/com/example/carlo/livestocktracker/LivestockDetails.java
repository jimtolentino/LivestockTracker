package com.example.carlo.livestocktracker;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class LivestockDetails extends AppCompatActivity {
    ImageView imageView;
    TextView tv_goatNum, tv_breed, tv_type, tv_weight, tv_houseNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_livestock);
        imageView = (ImageView) findViewById(R.id.detail_lstock_photo);
        tv_goatNum = (TextView)findViewById(R.id.detail_label_eartag_num);
        tv_breed = (TextView)findViewById(R.id.detail_label_breed);
        tv_type = (TextView)findViewById(R.id.detail_label_type);
        tv_weight = (TextView)findViewById(R.id.detail_label_weight);
        tv_houseNum = (TextView)findViewById(R.id.detail_label_housenum);

        tv_goatNum.setText("Eartag Number: "+ getIntent().getStringExtra("goatNum"));
        imageView.setImageResource(getIntent().getIntExtra("img_id",00));
        tv_type.setText("Type: "+ getIntent().getStringExtra("type"));
        tv_breed.setText("Breed: "+ getIntent().getStringExtra("breed"));
        tv_houseNum.setText("House Number: "+ getIntent().getStringExtra("houseNum"));
        tv_weight.setText("Weight: "+ getIntent().getStringExtra("weight"));


    }

}
