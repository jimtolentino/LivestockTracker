package com.example.carlo.livestocktracker;

/**
 * Created by Carlo on 2/12/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView livestockNum;
    public ImageView livestockPhoto;
    public TextView Breed;
    public TextView Weight;
    public TextView Type;
    public TextView HouseNum;
    Context context;
    ArrayList<Livestock> livestock = new ArrayList<Livestock>();

    public RecyclerViewHolders(View itemView, Context context, ArrayList<Livestock> livestock) {
        super(itemView);
        this.livestock = livestock;
        this.context = context;
        itemView.setOnClickListener(this);
        livestockNum = (TextView)itemView.findViewById(R.id.lstock_num);
        livestockPhoto = (ImageView)itemView.findViewById(R.id.lstock_photo);
        Breed = (TextView)itemView.findViewById(R.id.detail_label_breed);
        Weight = (TextView)itemView.findViewById(R.id.detail_label_weight);
        Type = (TextView)itemView.findViewById(R.id.detail_label_type);
        HouseNum = (TextView)itemView.findViewById(R.id.detail_label_housenum);

    }

    @Override
    public void onClick(View view) {
        int position = getAdapterPosition();
        Livestock livestock = this.livestock.get(position);

        Intent intent = new Intent(this.context, LivestockDetails.class);
        intent.putExtra("goatNum", livestock.getNum());
        intent.putExtra("img_id", livestock.getPhoto());
        intent.putExtra("type", livestock.getType());
        intent.putExtra("breed", livestock.getBreed());
        intent.putExtra("houseNum",livestock.getHouseNum());
        intent.putExtra("weight", livestock.getWeight());
        this.context.startActivity(intent);

    }


}
