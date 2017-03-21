package com.example.carlo.livestocktracker.adapters;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carlo.livestocktracker.fragments.AddUpdLivestockGoatFragment;
import com.example.carlo.livestocktracker.objects.Livestock;
import com.example.carlo.livestocktracker.R;

import java.util.ArrayList;

import static android.R.attr.fragment;

/**
 * Created by Carlo on 3/4/2017.
 */

public class LivestockAdapter extends  RecyclerView.Adapter<LivestockAdapter.ViewHolder> {
    private ArrayList<Livestock> livestockList;
    private Livestock livestock;
    private Context context;
    private Activity activity;

    public LivestockAdapter(Activity activity, ArrayList<Livestock> livestockList) {
        this.activity = activity;
        this.livestockList = livestockList;
        this.context = activity.getApplicationContext();

    }

    @Override
    public LivestockAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_list, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LivestockAdapter.ViewHolder holder, int position) {

        livestock = livestockList.get(position);

//        Livestock lstock = itemList.get(position);
        holder.livestockNum.setText(livestockList.get(position).getNum());
        holder.livestockPhoto.setImageResource(livestockList.get(position).getPhoto());
//        holder.Breed.setText(itemList.get(position).getBreed());
//        holder.Type.setText(itemList.get(position).getType());
//        holder.Weight.setText(itemList.get(position).getWeight());
//        holder.HouseNum.setText(itemList.get(position).getHouseNum());

    }

    @Override
    public int getItemCount() {
        return this.livestockList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView livestockNum;
        public ImageView livestockPhoto;
        public TextView Breed;
        public TextView Weight;
        public TextView Type;
        public TextView HouseNum;
        Context context;
        Livestock livestock = new Livestock();

        public ViewHolder (View view) {
            super(view);

            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){

                    int position = getAdapterPosition();

                    android.app.FragmentManager fm = activity.getFragmentManager();
                    FragmentTransaction fragmentTransaction = fm.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, AddUpdLivestockGoatFragment.newInstance(livestockList.get(position)));
                    fragmentTransaction.commit();

                }
            });

            livestockNum = (TextView)view.findViewById(R.id.lstock_num);
            livestockPhoto = (ImageView)view.findViewById(R.id.lstock_photo);
            Breed = (TextView)view.findViewById(R.id.detail_label_breed);
            Weight = (TextView)view.findViewById(R.id.detail_label_weight);
            Type = (TextView)view.findViewById(R.id.detail_label_type);
            HouseNum = (TextView)view.findViewById(R.id.detail_label_housenum);

        }

//        @Override
//        public void onClick(View view) {
//            int position = getAdapterPosition();
//            Livestock livestock = this.livestock.get(position);
//
//            Intent intent = new Intent(this.context, LivestockDetailsFragment.class);
//            intent.putExtra("goatNum", livestock.getNum());
//            intent.putExtra("img_id", livestock.getPhoto());
//            intent.putExtra("type", livestock.getType());
//            intent.putExtra("breed", livestock.getBreed());
//            intent.putExtra("houseNum",livestock.getHouseNum());
//            intent.putExtra("weight", livestock.getWeight());
//            this.context.startActivity(intent);
//
//        }


    }



}
